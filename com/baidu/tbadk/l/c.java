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
    private static boolean btV() {
        return TbadkCoreApplication.getInst().isDebugMode();
    }

    private static final void g(Object obj, String str) {
        if (btV()) {
            if (obj != null) {
                str = obj.getClass().getSimpleName() + " : " + str;
            }
            Log.d("TbPageKeyHelper", str);
        }
    }

    public static final void printLog(String str) {
        if (btV()) {
            Log.d("TbPageKeyHelper", str);
        }
    }

    private static final void c(FragmentManager fragmentManager) {
        if (btV()) {
            List<Fragment> fragments = fragmentManager.getFragments();
            if (!y.isEmpty(fragments)) {
                printLog("FragmentManager---->" + fragmentManager);
                printLog("---------------------------Start---------------------------");
                printLog("Print All ChildFragments=" + y.getCount(fragments));
                for (Fragment fragment : fragments) {
                    boolean isPrimary = fragment instanceof BaseFragment ? ((BaseFragment) fragment).isPrimary() : false;
                    g(fragment, "isUserVisible=" + fragment.getUserVisibleHint() + ",isVisible=" + fragment.isVisible() + ",isPrimary=" + isPrimary);
                }
                printLog("---------------------------End---------------------------");
            }
        }
    }

    private static final void a(b bVar) {
        if (btV() && bVar != null) {
            String currentPageKey = bVar.getCurrentPageKey();
            String btU = bVar.btU();
            ArrayList<String> btS = bVar.btS();
            ArrayList<String> btT = bVar.btT();
            StringBuilder sb = new StringBuilder("Current TbPageExtra:");
            sb.append("currentPageKey=").append(currentPageKey).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("prePageKey=").append(btU).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("preList=").append(btS.toString()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("nextList=").append(btT.toString());
            g(bVar, sb.toString());
        }
    }

    public static Activity eh(Context context) {
        g(context, "currentContext");
        Context context2 = context;
        while (context2 instanceof ContextWrapper) {
            if (context2 instanceof Activity) {
                Activity activity = (Activity) context2;
                g(activity, "currentActivity");
                return activity;
            }
            context2 = ((ContextWrapper) context2).getBaseContext();
            g(context2, "currentContextWrapper");
        }
        return null;
    }

    public static b ei(Context context) {
        printLog("======================Start==============================");
        printLog("context : " + context);
        Activity eh = eh(context);
        if (!(context instanceof Activity)) {
            g(context, "context is not Activity, so getCurrentActivity()");
            eh = TbadkCoreApplication.getInst().getCurrentActivity();
        }
        b ad = ad(eh);
        if (ad == null) {
            g(context, "------Not Activity，No TbPageExtra!------");
        }
        printLog("**************************End**************************");
        return ad;
    }

    private static b ad(Activity activity) {
        if (activity instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) activity;
            g(baseFragmentActivity, "context is BaseFragmentActivity");
            b d = d(baseFragmentActivity);
            a(d);
            return d;
        } else if (activity instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) activity;
            g(baseActivity, "context is BaseActivity");
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
                g(baseFragment, "CurrentFragmentExtra-->" + tbPageExtra);
                bVar = tbPageExtra;
                break;
            }
        }
        stack.clear();
        if (bVar == null || bVar.isDirtyData()) {
            b tbPageExtra2 = baseFragmentActivity.getTbPageExtra();
            g(baseFragmentActivity, "CurrentActivityExtra-->" + tbPageExtra2);
            return tbPageExtra2;
        }
        return bVar;
    }

    private static void a(Stack<BaseFragment> stack, BaseFragment baseFragment) {
        if (a(baseFragment)) {
            stack.push(baseFragment);
            g(baseFragment, "VisibleParentFragment-->" + baseFragment);
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
