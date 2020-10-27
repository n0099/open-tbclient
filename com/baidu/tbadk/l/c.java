package com.baidu.tbadk.l;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/* loaded from: classes.dex */
public class c {
    private static boolean bzC() {
        return TbadkCoreApplication.getInst().isDebugMode();
    }

    private static final void h(Object obj, String str) {
        if (bzC()) {
            if (obj != null) {
                str = obj.getClass().getSimpleName() + " : " + str;
            }
            Log.d("TbPageKeyHelper", str);
        }
    }

    public static final void printLog(String str) {
        if (bzC()) {
            Log.d("TbPageKeyHelper", str);
        }
    }

    private static final void c(FragmentManager fragmentManager) {
        if (bzC()) {
            List<Fragment> fragments = fragmentManager.getFragments();
            if (!y.isEmpty(fragments)) {
                printLog("FragmentManager---->" + fragmentManager);
                printLog("---------------------------Start---------------------------");
                printLog("Print All ChildFragments=" + y.getCount(fragments));
                for (Fragment fragment : fragments) {
                    boolean isPrimary = fragment instanceof BaseFragment ? ((BaseFragment) fragment).isPrimary() : false;
                    h(fragment, "isUserVisible=" + fragment.getUserVisibleHint() + ",isVisible=" + fragment.isVisible() + ",isPrimary=" + isPrimary);
                }
                printLog("---------------------------End---------------------------");
            }
        }
    }

    private static final void a(b bVar) {
        if (bzC() && bVar != null) {
            String currentPageKey = bVar.getCurrentPageKey();
            String bzB = bVar.bzB();
            ArrayList<String> bzz = bVar.bzz();
            ArrayList<String> bzA = bVar.bzA();
            StringBuilder sb = new StringBuilder("Current TbPageExtra:");
            sb.append("currentPageKey=").append(currentPageKey).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("prePageKey=").append(bzB).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("preList=").append(bzz.toString()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("nextList=").append(bzA.toString());
            h(bVar, sb.toString());
        }
    }

    public static Activity eq(Context context) {
        h(context, "currentContext");
        Context context2 = context;
        while (context2 instanceof ContextWrapper) {
            if (context2 instanceof Activity) {
                Activity activity = (Activity) context2;
                h(activity, "currentActivity");
                return activity;
            }
            context2 = ((ContextWrapper) context2).getBaseContext();
            h(context2, "currentContextWrapper");
        }
        return null;
    }

    public static b er(Context context) {
        printLog("======================Start==============================");
        printLog("context : " + context);
        Activity eq = eq(context);
        if (!(context instanceof Activity)) {
            h(context, "context is not Activity, so getCurrentActivity()");
            eq = TbadkCoreApplication.getInst().getCurrentActivity();
        }
        b ah = ah(eq);
        if (ah == null) {
            h(context, "------Not Activity，No TbPageExtra!------");
        }
        printLog("**************************End**************************");
        return ah;
    }

    private static b ah(Activity activity) {
        if (activity instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) activity;
            h(baseFragmentActivity, "context is BaseFragmentActivity");
            b d = d(baseFragmentActivity);
            a(d);
            return d;
        } else if (activity instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) activity;
            h(baseActivity, "context is BaseActivity");
            b tbPageExtra = baseActivity.getTbPageExtra();
            a(tbPageExtra);
            return tbPageExtra;
        } else {
            return null;
        }
    }

    private static b d(BaseFragmentActivity baseFragmentActivity) {
        b bVar;
        FragmentManager supportFragmentManager = baseFragmentActivity.getSupportFragmentManager();
        c(supportFragmentManager);
        List<Fragment> fragments = supportFragmentManager.getFragments();
        Stack stack = new Stack();
        for (Fragment fragment : fragments) {
            if (fragment instanceof BaseFragment) {
                a(stack, (BaseFragment) fragment);
            }
        }
        while (true) {
            if (stack.empty()) {
                bVar = null;
                break;
            }
            BaseFragment baseFragment = (BaseFragment) stack.pop();
            if (baseFragment != null && baseFragment.isPrimary() && baseFragment.getTbPageExtra() != null) {
                b tbPageExtra = baseFragment.getTbPageExtra();
                h(baseFragment, "CurrentFragmentExtra-->" + tbPageExtra);
                bVar = tbPageExtra;
                break;
            }
        }
        stack.clear();
        if (bVar == null || bVar.isDirtyData()) {
            b tbPageExtra2 = baseFragmentActivity.getTbPageExtra();
            h(baseFragmentActivity, "CurrentActivityExtra-->" + tbPageExtra2);
            return tbPageExtra2;
        }
        return bVar;
    }

    private static void a(Stack<BaseFragment> stack, BaseFragment baseFragment) {
        if (a(baseFragment)) {
            stack.push(baseFragment);
            h(baseFragment, "VisibleParentFragment-->" + baseFragment);
            FragmentManager childFragmentManager = baseFragment.getChildFragmentManager();
            c(childFragmentManager);
            List<Fragment> fragments = childFragmentManager.getFragments();
            if (!y.isEmpty(fragments)) {
                for (Fragment fragment : fragments) {
                    if (fragment instanceof BaseFragment) {
                        BaseFragment baseFragment2 = (BaseFragment) fragment;
                        if (a(baseFragment2)) {
                            a(stack, baseFragment2);
                        }
                    }
                }
            }
        }
    }

    private static boolean a(BaseFragment baseFragment) {
        return baseFragment != null && baseFragment.isVisible() && baseFragment.isPrimary();
    }

    public static ArrayList<String> d(ArrayList<String> arrayList, String str) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (!y.isEmpty(arrayList)) {
            arrayList2.addAll(arrayList);
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList2.add(str);
        }
        return arrayList2;
    }
}
