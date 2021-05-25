package com.baidu.tbadk.pageExtra;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.swan.apps.so.SoUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.tencent.connect.common.Constants;
import d.a.c.e.m.e;
import d.a.m0.i0.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
/* loaded from: classes3.dex */
public class TbPageExtraHelper {

    /* renamed from: a  reason: collision with root package name */
    public static String f12896a;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, String> f12897b = new HashMap<String, String>() { // from class: com.baidu.tbadk.pageExtra.TbPageExtraHelper.1
        {
            put(Constants.VIA_REPORT_TYPE_SET_AVATAR, "a028");
            put("52", "a075");
            put(SoUtils.SO_EVENT_ID_DEFAULT, "a025");
            put("18", "a075");
            put("7", "a028");
            put("1", "a075");
            put("2", "a028");
            put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "a075");
            put("54", "a085");
        }
    };

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12898e;

        public a(String str) {
            this.f12898e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String unused = TbPageExtraHelper.f12896a = (String) TbPageExtraHelper.f12897b.get(this.f12898e);
        }
    }

    public static ArrayList<String> c(ArrayList<String> arrayList, String str) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (!ListUtils.isEmpty(arrayList)) {
            arrayList2.addAll(arrayList);
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList2.add(str);
        }
        return arrayList2;
    }

    public static BaseFragment d(View view) {
        d.a.m0.i0.a e2 = e(view);
        if (e2 == null || e2.getTbFragmentExtra() == null) {
            return null;
        }
        return e2.getTbFragmentExtra().a();
    }

    public static d.a.m0.i0.a e(View view) {
        ViewParent parent = view.getParent();
        d.a.m0.i0.a aVar = null;
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup instanceof d.a.m0.i0.a) {
                aVar = (d.a.m0.i0.a) parent;
                q(viewGroup, "ITbFragmentExtraSupport From Implements Interface------->");
            }
            if (aVar == null) {
                Object tag = viewGroup.getTag(R.id.tag_tb_fragment_extra);
                if (tag instanceof d.a.m0.i0.a) {
                    aVar = (d.a.m0.i0.a) tag;
                    q(viewGroup, "ITbFragmentExtraSupport From View.getTag()------->");
                }
            }
            if (aVar != null && aVar.getTbFragmentExtra() != null) {
                BaseFragment a2 = aVar.getTbFragmentExtra().a();
                if (a2 != null && a2.getBaseFragmentActivity() != null) {
                    BaseFragmentActivity baseFragmentActivity = a2.getBaseFragmentActivity();
                    q(a2, "ActivityPageKey=" + baseFragmentActivity.getCurrentPageKey() + ",FragmentPageKey=" + a2.getCurrentPageKey());
                }
                return aVar;
            }
            return e(viewGroup);
        }
        return null;
    }

    public static c f(View view) {
        BaseFragment d2 = d(view);
        c tbPageExtra = d2 != null ? d2.getTbPageExtra() : null;
        return (tbPageExtra == null || tbPageExtra.e()) ? k(g(view)) : tbPageExtra;
    }

    public static Activity g(View view) {
        if (view == null) {
            return null;
        }
        return h(view.getContext());
    }

    public static Activity h(Context context) {
        q(context, "currentContext");
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                q(activity, "currentActivity");
                return activity;
            }
            context = ((ContextWrapper) context).getBaseContext();
            q(context, "currentContextWrapper");
        }
        return null;
    }

    public static c i(Activity activity) {
        if (activity instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) activity;
            q(baseFragmentActivity, "context is BaseFragmentActivity");
            c j = j(baseFragmentActivity);
            s(j);
            return j;
        } else if (activity instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) activity;
            q(baseActivity, "context is BaseActivity");
            c tbPageExtra = baseActivity.getTbPageExtra();
            s(tbPageExtra);
            return tbPageExtra;
        } else {
            return null;
        }
    }

    public static c j(BaseFragmentActivity baseFragmentActivity) {
        FragmentManager supportFragmentManager = baseFragmentActivity.getSupportFragmentManager();
        p(supportFragmentManager);
        List<Fragment> fragments = supportFragmentManager.getFragments();
        Stack stack = new Stack();
        for (Fragment fragment : fragments) {
            if (fragment instanceof BaseFragment) {
                t(stack, (BaseFragment) fragment);
            }
        }
        c cVar = null;
        while (true) {
            if (stack.empty()) {
                break;
            }
            BaseFragment baseFragment = (BaseFragment) stack.pop();
            if (baseFragment != null && baseFragment.isPrimary() && baseFragment.getTbPageExtra() != null) {
                cVar = baseFragment.getTbPageExtra();
                q(baseFragment, "CurrentFragmentExtra-->" + cVar);
                break;
            }
        }
        stack.clear();
        if (cVar == null || cVar.e()) {
            c tbPageExtra = baseFragmentActivity.getTbPageExtra();
            q(baseFragmentActivity, "CurrentActivityExtra-->" + tbPageExtra);
            return tbPageExtra;
        }
        return cVar;
    }

    public static c k(Context context) {
        r("======================Start==============================");
        r("context : " + context);
        Activity h2 = h(context);
        if (!(context instanceof Activity)) {
            q(context, "context is not Activity, so getCurrentActivity()");
            h2 = TbadkCoreApplication.getInst().getCurrentActivity();
        }
        c i2 = i(h2);
        if (i2 == null) {
            q(context, "------Not Activity，No TbPageExtra!------");
        }
        r("**************************End**************************");
        return i2;
    }

    public static String l(Context context) {
        c k = k(context);
        if (k == null) {
            return null;
        }
        return k.a();
    }

    public static String m() {
        return f12896a;
    }

    public static boolean n() {
        return TbadkCoreApplication.getInst().isDebugMode();
    }

    public static boolean o(BaseFragment baseFragment) {
        return baseFragment != null && baseFragment.isVisible() && baseFragment.isPrimary();
    }

    public static final void p(FragmentManager fragmentManager) {
        if (n()) {
            List<Fragment> fragments = fragmentManager.getFragments();
            if (ListUtils.isEmpty(fragments)) {
                return;
            }
            r("FragmentManager---->" + fragmentManager);
            r("---------------------------Start---------------------------");
            r("Print All ChildFragments=" + ListUtils.getCount(fragments));
            for (Fragment fragment : fragments) {
                boolean isPrimary = fragment instanceof BaseFragment ? ((BaseFragment) fragment).isPrimary() : false;
                boolean userVisibleHint = fragment.getUserVisibleHint();
                boolean isVisible = fragment.isVisible();
                q(fragment, "isUserVisible=" + userVisibleHint + ",isVisible=" + isVisible + ",isPrimary=" + isPrimary);
            }
            r("---------------------------End---------------------------");
        }
    }

    public static final void q(Object obj, String str) {
        if (n()) {
            if (obj != null) {
                str = obj.getClass().getSimpleName() + ZeusCrashHandler.NAME_SEPERATOR + str;
            }
            Log.d("TbPageKeyHelper", str);
        }
    }

    public static final void r(String str) {
        if (n()) {
            Log.d("TbPageKeyHelper", str);
        }
    }

    public static final void s(c cVar) {
        if (n() && cVar != null) {
            String a2 = cVar.a();
            String d2 = cVar.d();
            ArrayList<String> c2 = cVar.c();
            ArrayList<String> b2 = cVar.b();
            q(cVar, "Current TbPageExtra:currentPageKey=" + a2 + ",prePageKey=" + d2 + ",preList=" + c2.toString() + ",nextList=" + b2.toString());
        }
    }

    public static void t(Stack<BaseFragment> stack, BaseFragment baseFragment) {
        if (o(baseFragment)) {
            stack.push(baseFragment);
            q(baseFragment, "VisibleParentFragment-->" + baseFragment);
            FragmentManager childFragmentManager = baseFragment.getChildFragmentManager();
            p(childFragmentManager);
            List<Fragment> fragments = childFragmentManager.getFragments();
            if (ListUtils.isEmpty(fragments)) {
                return;
            }
            for (Fragment fragment : fragments) {
                if (fragment instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) fragment;
                    if (o(baseFragment2)) {
                        t(stack, baseFragment2);
                    }
                }
            }
        }
    }

    public static void u(String str) {
        f12896a = str;
    }

    public static void v(String str) {
        if (!StringUtil.isEmpty(str) && f12897b.containsKey(str)) {
            e.a().postDelayed(new a(str), 100L);
        }
    }
}
