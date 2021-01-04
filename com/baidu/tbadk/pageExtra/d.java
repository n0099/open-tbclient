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
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.swan.games.utils.so.SoUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
/* loaded from: classes.dex */
public class d {
    private static String prePageKey = null;
    private static HashMap<String, String> fLb = new HashMap<String, String>() { // from class: com.baidu.tbadk.pageExtra.TbPageExtraHelper$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            put(Constants.VIA_REPORT_TYPE_SET_AVATAR, "a028");
            put("52", "a075");
            put(SoUtils.SO_EVENT_ID_DEFAULT, PageStayDurationConstants.PageName.ENTER_FORUM);
            put("18", "a075");
            put("7", "a028");
            put("1", "a075");
            put("2", "a028");
            put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "a075");
        }
    };

    private static boolean bHn() {
        return TbadkCoreApplication.getInst().isDebugMode();
    }

    private static final void h(Object obj, String str) {
        if (bHn()) {
            if (obj != null) {
                str = obj.getClass().getSimpleName() + " : " + str;
            }
            Log.d("TbPageKeyHelper", str);
        }
    }

    public static final void printLog(String str) {
        if (bHn()) {
            Log.d("TbPageKeyHelper", str);
        }
    }

    private static final void a(FragmentManager fragmentManager) {
        if (bHn()) {
            List<Fragment> fragments = fragmentManager.getFragments();
            if (!x.isEmpty(fragments)) {
                printLog("FragmentManager---->" + fragmentManager);
                printLog("---------------------------Start---------------------------");
                printLog("Print All ChildFragments=" + x.getCount(fragments));
                for (Fragment fragment : fragments) {
                    boolean isPrimary = fragment instanceof BaseFragment ? ((BaseFragment) fragment).isPrimary() : false;
                    h(fragment, "isUserVisible=" + fragment.getUserVisibleHint() + ",isVisible=" + fragment.isVisible() + ",isPrimary=" + isPrimary);
                }
                printLog("---------------------------End---------------------------");
            }
        }
    }

    private static final void a(c cVar) {
        if (bHn() && cVar != null) {
            String currentPageKey = cVar.getCurrentPageKey();
            String bHm = cVar.bHm();
            ArrayList<String> bHk = cVar.bHk();
            ArrayList<String> bHl = cVar.bHl();
            StringBuilder sb = new StringBuilder("Current TbPageExtra:");
            sb.append("currentPageKey=").append(currentPageKey).append(",");
            sb.append("prePageKey=").append(bHm).append(",");
            sb.append("preList=").append(bHk.toString()).append(",");
            sb.append("nextList=").append(bHl.toString());
            h(cVar, sb.toString());
        }
    }

    public static c bV(View view) {
        c cVar = null;
        BaseFragment bW = bW(view);
        if (bW != null) {
            cVar = bW.getTbPageExtra();
        }
        if (cVar == null || cVar.isDirtyData()) {
            return ft(bY(view));
        }
        return cVar;
    }

    public static BaseFragment bW(View view) {
        a bX = bX(view);
        if (bX == null || bX.getTbFragmentExtra() == null) {
            return null;
        }
        return bX.getTbFragmentExtra().bHj();
    }

    private static a bX(View view) {
        a aVar;
        a aVar2 = null;
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup instanceof a) {
                h(viewGroup, "ITbFragmentExtraSupport From Implements Interface------->");
                aVar2 = (a) parent;
            }
            if (aVar2 == null) {
                Object tag = viewGroup.getTag(R.id.tag_tb_fragment_extra);
                if (tag instanceof a) {
                    aVar = (a) tag;
                    h(viewGroup, "ITbFragmentExtraSupport From View.getTag()------->");
                    if (aVar == null && aVar.getTbFragmentExtra() != null) {
                        BaseFragment bHj = aVar.getTbFragmentExtra().bHj();
                        if (bHj != null && bHj.getBaseFragmentActivity() != null) {
                            BaseFragmentActivity baseFragmentActivity = bHj.getBaseFragmentActivity();
                            StringBuilder sb = new StringBuilder();
                            sb.append("ActivityPageKey=").append(baseFragmentActivity.getCurrentPageKey()).append(",");
                            sb.append("FragmentPageKey=").append(bHj.getCurrentPageKey());
                            h(bHj, sb.toString());
                        }
                        return aVar;
                    }
                    return bX(viewGroup);
                }
            }
            aVar = aVar2;
            if (aVar == null) {
            }
            return bX(viewGroup);
        }
        return null;
    }

    public static Activity bY(View view) {
        if (view == null) {
            return null;
        }
        return fr(view.getContext());
    }

    public static Activity fr(Context context) {
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

    public static String fs(Context context) {
        c ft = ft(context);
        if (ft == null) {
            return null;
        }
        return ft.getCurrentPageKey();
    }

    public static c ft(Context context) {
        printLog("======================Start==============================");
        printLog("context : " + context);
        Activity fr = fr(context);
        if (!(context instanceof Activity)) {
            h(context, "context is not Activity, so getCurrentActivity()");
            fr = TbadkCoreApplication.getInst().getCurrentActivity();
        }
        c aj = aj(fr);
        if (aj == null) {
            h(context, "------Not Activity，No TbPageExtra!------");
        }
        printLog("**************************End**************************");
        return aj;
    }

    private static c aj(Activity activity) {
        if (activity instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) activity;
            h(baseFragmentActivity, "context is BaseFragmentActivity");
            c d = d(baseFragmentActivity);
            a(d);
            return d;
        } else if (activity instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) activity;
            h(baseActivity, "context is BaseActivity");
            c tbPageExtra = baseActivity.getTbPageExtra();
            a(tbPageExtra);
            return tbPageExtra;
        } else {
            return null;
        }
    }

    private static c d(BaseFragmentActivity baseFragmentActivity) {
        c cVar;
        FragmentManager supportFragmentManager = baseFragmentActivity.getSupportFragmentManager();
        a(supportFragmentManager);
        List<Fragment> fragments = supportFragmentManager.getFragments();
        Stack stack = new Stack();
        for (Fragment fragment : fragments) {
            if (fragment instanceof BaseFragment) {
                a(stack, (BaseFragment) fragment);
            }
        }
        while (true) {
            if (stack.empty()) {
                cVar = null;
                break;
            }
            BaseFragment baseFragment = (BaseFragment) stack.pop();
            if (baseFragment != null && baseFragment.isPrimary() && baseFragment.getTbPageExtra() != null) {
                c tbPageExtra = baseFragment.getTbPageExtra();
                h(baseFragment, "CurrentFragmentExtra-->" + tbPageExtra);
                cVar = tbPageExtra;
                break;
            }
        }
        stack.clear();
        if (cVar == null || cVar.isDirtyData()) {
            c tbPageExtra2 = baseFragmentActivity.getTbPageExtra();
            h(baseFragmentActivity, "CurrentActivityExtra-->" + tbPageExtra2);
            return tbPageExtra2;
        }
        return cVar;
    }

    private static void a(Stack<BaseFragment> stack, BaseFragment baseFragment) {
        if (a(baseFragment)) {
            stack.push(baseFragment);
            h(baseFragment, "VisibleParentFragment-->" + baseFragment);
            FragmentManager childFragmentManager = baseFragment.getChildFragmentManager();
            a(childFragmentManager);
            List<Fragment> fragments = childFragmentManager.getFragments();
            if (!x.isEmpty(fragments)) {
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
        if (!x.isEmpty(arrayList)) {
            arrayList2.addAll(arrayList);
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList2.add(str);
        }
        return arrayList2;
    }

    public static void Ek(String str) {
        prePageKey = str;
    }

    public static String bHm() {
        return prePageKey;
    }

    public static void El(final String str) {
        if (!StringUtil.isEmpty(str) && fLb.containsKey(str)) {
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tbadk.pageExtra.d.1
                @Override // java.lang.Runnable
                public void run() {
                    String unused = d.prePageKey = (String) d.fLb.get(str);
                }
            }, 100L);
        }
    }
}
