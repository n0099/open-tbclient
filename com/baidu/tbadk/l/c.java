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
    private static boolean aZf() {
        return TbadkCoreApplication.getInst().isDebugMode();
    }

    private static final void d(Object obj, String str) {
        if (aZf()) {
            if (obj != null) {
                str = str + " : " + obj.getClass().getSimpleName();
            }
            Log.d("TbPageKeyHelper", str);
        }
    }

    private static final void a(Fragment fragment, List<Fragment> list) {
        if (aZf()) {
            d((Object) null, "--------------------------------------------------");
            d((Object) null, "ParentFragment:" + fragment);
            d((Object) null, "Print All ChildFragments=" + v.getCount(list));
            if (!v.isEmpty(list)) {
                for (Fragment fragment2 : list) {
                    boolean isPrimary = fragment2 instanceof BaseFragment ? ((BaseFragment) fragment2).isPrimary() : false;
                    d(fragment2, "isUserVisible=" + fragment2.getUserVisibleHint() + ",isVisible=" + fragment2.isVisible() + ",isPrimary=" + isPrimary);
                }
            }
        }
    }

    private static final void a(b bVar) {
        if (aZf() && bVar != null) {
            String currentPageKey = bVar.getCurrentPageKey();
            ArrayList<String> aZd = bVar.aZd();
            ArrayList<String> aZe = bVar.aZe();
            StringBuilder sb = new StringBuilder("Current TbPageExtra:");
            sb.append("currentKey=").append(currentPageKey).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("preList=").append(aZd.toString()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("nextList=").append(aZe.toString());
            d(bVar, sb.toString());
        }
    }

    public static b dB(Context context) {
        b bVar = null;
        Activity dC = dC(context);
        if (dC instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) dC;
            d(baseFragmentActivity, "BaseFragmentActivity");
            BaseFragment d = d(baseFragmentActivity);
            if (d != null) {
                bVar = d.getTbPageExtra();
                d(baseFragmentActivity, "FragmentExtra-->" + bVar);
            }
            if (bVar == null || TextUtils.isEmpty(bVar.getCurrentPageKey())) {
                bVar = baseFragmentActivity.getTbPageExtra();
                d(baseFragmentActivity, "ActivityExtra-->" + bVar);
            }
            b bVar2 = bVar;
            a(bVar2);
            return bVar2;
        } else if (dC instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) dC;
            d(baseActivity, "BaseActivity");
            b tbPageExtra = baseActivity.getTbPageExtra();
            d(baseActivity, "ActivityExtra=" + tbPageExtra);
            a(tbPageExtra);
            return tbPageExtra;
        } else {
            d(context, "------Not Activity，No TbPageExtra!------");
            return null;
        }
    }

    public static Activity dC(Context context) {
        d(context, "currentContext");
        Context context2 = context;
        while (context2 instanceof ContextWrapper) {
            if (context2 instanceof Activity) {
                Activity activity = (Activity) context2;
                d(activity, "currentActivity");
                return activity;
            }
            context2 = ((ContextWrapper) context2).getBaseContext();
            d(context2, "currentContextWrapper");
        }
        return null;
    }

    public static BaseFragment d(BaseFragmentActivity baseFragmentActivity) {
        d(baseFragmentActivity, "fragmentActivity--->getVisibleFragment");
        return c(baseFragmentActivity.getSupportFragmentManager());
    }

    private static BaseFragment c(FragmentManager fragmentManager) {
        d(fragmentManager, "FragmentManager=" + fragmentManager);
        List<Fragment> fragments = fragmentManager.getFragments();
        a(null, fragments);
        for (Fragment fragment : fragments) {
            d(fragment, "foreach fragment");
            if (fragment instanceof BaseFragment) {
                BaseFragment a = a((BaseFragment) fragment);
                if (b(a)) {
                    d(a, "Current VisibleFragment");
                    return a;
                }
            }
        }
        return null;
    }

    private static BaseFragment a(BaseFragment baseFragment) {
        if (b(baseFragment)) {
            FragmentManager childFragmentManager = baseFragment.getChildFragmentManager();
            d(childFragmentManager, "getChildFragmentManager=" + childFragmentManager);
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
