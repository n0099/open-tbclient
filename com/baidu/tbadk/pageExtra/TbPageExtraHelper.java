package com.baidu.tbadk.pageExtra;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.so.SoUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import d.a.c.e.m.e;
import d.a.o0.i0.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
/* loaded from: classes3.dex */
public class TbPageExtraHelper {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f13144a;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, String> f13145b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f13146e;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13146e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String unused = TbPageExtraHelper.f13144a = (String) TbPageExtraHelper.f13145b.get(this.f13146e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1973060363, "Lcom/baidu/tbadk/pageExtra/TbPageExtraHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1973060363, "Lcom/baidu/tbadk/pageExtra/TbPageExtraHelper;");
                return;
            }
        }
        f13145b = new HashMap<String, String>() { // from class: com.baidu.tbadk.pageExtra.TbPageExtraHelper.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                put("12", "a028");
                put("52", "a075");
                put(SoUtils.SO_EVENT_ID_DEFAULT, "a025");
                put("18", "a075");
                put("7", "a028");
                put("1", "a075");
                put("2", "a028");
                put("14", "a075");
                put("54", "a085");
            }
        };
    }

    public static ArrayList<String> c(ArrayList<String> arrayList, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, arrayList, str)) == null) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            if (!ListUtils.isEmpty(arrayList)) {
                arrayList2.addAll(arrayList);
            }
            if (!TextUtils.isEmpty(str)) {
                arrayList2.add(str);
            }
            return arrayList2;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static BaseFragment d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view)) == null) {
            d.a.o0.i0.a e2 = e(view);
            if (e2 == null || e2.getTbFragmentExtra() == null) {
                return null;
            }
            return e2.getTbFragmentExtra().a();
        }
        return (BaseFragment) invokeL.objValue;
    }

    public static d.a.o0.i0.a e(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, view)) == null) {
            ViewParent parent = view.getParent();
            d.a.o0.i0.a aVar = null;
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if (viewGroup instanceof d.a.o0.i0.a) {
                    aVar = (d.a.o0.i0.a) parent;
                    q(viewGroup, "ITbFragmentExtraSupport From Implements Interface------->");
                }
                if (aVar == null) {
                    Object tag = viewGroup.getTag(R.id.tag_tb_fragment_extra);
                    if (tag instanceof d.a.o0.i0.a) {
                        aVar = (d.a.o0.i0.a) tag;
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
        return (d.a.o0.i0.a) invokeL.objValue;
    }

    public static c f(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, view)) == null) {
            BaseFragment d2 = d(view);
            c tbPageExtra = d2 != null ? d2.getTbPageExtra() : null;
            return (tbPageExtra == null || tbPageExtra.e()) ? k(g(view)) : tbPageExtra;
        }
        return (c) invokeL.objValue;
    }

    public static Activity g(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, view)) == null) {
            if (view == null) {
                return null;
            }
            return h(view.getContext());
        }
        return (Activity) invokeL.objValue;
    }

    public static Activity h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
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
        return (Activity) invokeL.objValue;
    }

    public static c i(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, activity)) == null) {
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
        return (c) invokeL.objValue;
    }

    public static c j(BaseFragmentActivity baseFragmentActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, baseFragmentActivity)) == null) {
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
        return (c) invokeL.objValue;
    }

    public static c k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
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
        return (c) invokeL.objValue;
    }

    public static String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            c k = k(context);
            if (k == null) {
                return null;
            }
            return k.a();
        }
        return (String) invokeL.objValue;
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? f13144a : (String) invokeV.objValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? TbadkCoreApplication.getInst().isDebugMode() : invokeV.booleanValue;
    }

    public static boolean o(BaseFragment baseFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, baseFragment)) == null) ? baseFragment != null && baseFragment.isVisible() && baseFragment.isPrimary() : invokeL.booleanValue;
    }

    public static final void p(FragmentManager fragmentManager) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65552, null, fragmentManager) == null) && n()) {
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65553, null, obj, str) == null) && n()) {
            if (obj != null) {
                str = obj.getClass().getSimpleName() + ZeusCrashHandler.NAME_SEPERATOR + str;
            }
            Log.d("TbPageKeyHelper", str);
        }
    }

    public static final void r(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, null, str) == null) && n()) {
            Log.d("TbPageKeyHelper", str);
        }
    }

    public static final void s(c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65555, null, cVar) == null) && n() && cVar != null) {
            String a2 = cVar.a();
            String d2 = cVar.d();
            ArrayList<String> c2 = cVar.c();
            ArrayList<String> b2 = cVar.b();
            q(cVar, "Current TbPageExtra:currentPageKey=" + a2 + ",prePageKey=" + d2 + ",preList=" + c2.toString() + ",nextList=" + b2.toString());
        }
    }

    public static void t(Stack<BaseFragment> stack, BaseFragment baseFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65556, null, stack, baseFragment) == null) && o(baseFragment)) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            f13144a = str;
        }
    }

    public static void v(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65558, null, str) == null) && !StringUtil.isEmpty(str) && f13145b.containsKey(str)) {
            e.a().postDelayed(new a(str), 100L);
        }
    }
}
