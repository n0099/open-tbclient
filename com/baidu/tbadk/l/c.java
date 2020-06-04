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
import com.baidu.tbadk.core.util.v;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static boolean bfq() {
        return TbadkCoreApplication.getInst().isDebugMode();
    }

    private static final void g(Object obj, String str) {
        if (bfq()) {
            if (obj != null) {
                str = str + " : " + obj.getClass().getSimpleName();
            }
            Log.d("TbPageKeyHelper", str);
        }
    }

    private static final void a(Fragment fragment, List<Fragment> list) {
        if (bfq()) {
            g(null, "--------------------------------------------------");
            g(null, "ParentFragment:" + fragment);
            g(null, "Print All ChildFragments=" + v.getCount(list));
            if (!v.isEmpty(list)) {
                for (Fragment fragment2 : list) {
                    boolean isPrimary = fragment2 instanceof BaseFragment ? ((BaseFragment) fragment2).isPrimary() : false;
                    g(fragment2, "isUserVisible=" + fragment2.getUserVisibleHint() + ",isVisible=" + fragment2.isVisible() + ",isPrimary=" + isPrimary);
                }
            }
        }
    }

    private static final void a(b bVar) {
        if (bfq() && bVar != null) {
            String currentPageKey = bVar.getCurrentPageKey();
            ArrayList<String> bfo = bVar.bfo();
            ArrayList<String> bfp = bVar.bfp();
            StringBuilder sb = new StringBuilder("Current TbPageExtra:");
            sb.append("currentKey=").append(currentPageKey).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("preList=").append(bfo.toString()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("nextList=").append(bfp.toString());
            g(bVar, sb.toString());
        }
    }

    public static b dS(Context context) {
        b bVar = null;
        Activity dT = dT(context);
        if (dT instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) dT;
            g(baseFragmentActivity, "BaseFragmentActivity");
            BaseFragment d = d(baseFragmentActivity);
            if (d != null) {
                bVar = d.getTbPageExtra();
                g(baseFragmentActivity, "FragmentExtra-->" + bVar);
            }
            if (bVar == null || TextUtils.isEmpty(bVar.getCurrentPageKey())) {
                bVar = baseFragmentActivity.getTbPageExtra();
                g(baseFragmentActivity, "ActivityExtra-->" + bVar);
            }
            b bVar2 = bVar;
            a(bVar2);
            return bVar2;
        } else if (dT instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) dT;
            g(baseActivity, "BaseActivity");
            b tbPageExtra = baseActivity.getTbPageExtra();
            g(baseActivity, "ActivityExtra=" + tbPageExtra);
            a(tbPageExtra);
            return tbPageExtra;
        } else {
            g(context, "------Not Activity，No TbPageExtra!------");
            return null;
        }
    }

    public static Activity dT(Context context) {
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

    public static BaseFragment d(BaseFragmentActivity baseFragmentActivity) {
        g(baseFragmentActivity, "fragmentActivity--->getVisibleFragment");
        return c(baseFragmentActivity.getSupportFragmentManager());
    }

    private static BaseFragment c(FragmentManager fragmentManager) {
        g(fragmentManager, "FragmentManager=" + fragmentManager);
        List<Fragment> fragments = fragmentManager.getFragments();
        a(null, fragments);
        for (Fragment fragment : fragments) {
            g(fragment, "foreach fragment");
            if (fragment instanceof BaseFragment) {
                BaseFragment a = a((BaseFragment) fragment);
                if (b(a)) {
                    g(a, "Current VisibleFragment");
                    return a;
                }
            }
        }
        return null;
    }

    private static BaseFragment a(BaseFragment baseFragment) {
        if (b(baseFragment)) {
            FragmentManager childFragmentManager = baseFragment.getChildFragmentManager();
            g(childFragmentManager, "getChildFragmentManager=" + childFragmentManager);
            List<Fragment> fragments = childFragmentManager.getFragments();
            a(baseFragment, fragments);
            if (!v.isEmpty(fragments)) {
                for (Fragment fragment : fragments) {
                    if (fragment instanceof BaseFragment) {
                        BaseFragment baseFragment2 = (BaseFragment) fragment;
                        if (b(baseFragment2)) {
                            return a(baseFragment2);
                        }
                    }
                }
                return baseFragment;
            }
            return baseFragment;
        }
        return null;
    }

    private static boolean b(BaseFragment baseFragment) {
        return baseFragment != null && baseFragment.isVisible() && baseFragment.isPrimary();
    }

    public static ArrayList<String> d(ArrayList<String> arrayList, String str) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (!v.isEmpty(arrayList)) {
            arrayList2.addAll(arrayList);
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList2.add(str);
        }
        return arrayList2;
    }
}
