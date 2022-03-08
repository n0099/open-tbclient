package com.baidu.tbadk.pageExtra;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import c.a.d.f.m.e;
import c.a.q0.n0.c;
import com.baidu.android.common.others.lang.StringUtil;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
/* loaded from: classes5.dex */
public class TbPageExtraHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ENTER_TYPE_CREATE_CENTER = "18";
    public static final String ENTER_TYPE_PERSONAL_PAGE = "12";
    public static final String ENTER_TYPE_VIDEO_HOT_TOPIC = "13";
    public static final String ENTER_TYPE_WORK_MANAGEMENT = "19";
    public static final String FLUTTER_FRAGMENT_CLASS_NAME = "com.baidu.tieba.flutter.view.TbFlutterFragment";
    public static final String KEY = "TbPageKeyHelper";
    public static String prePageKey;
    public static HashMap<String, String> typeAndPreFlutterPageKeyMap;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f39735e;

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
            this.f39735e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String unused = TbPageExtraHelper.prePageKey = (String) TbPageExtraHelper.typeAndPreFlutterPageKeyMap.get(this.f39735e);
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
        typeAndPreFlutterPageKeyMap = new HashMap<String, String>() { // from class: com.baidu.tbadk.pageExtra.TbPageExtraHelper.1
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
                put("24", "a025");
                put("18", "a075");
                put("7", "a028");
                put("1", "a075");
                put("2", "a028");
                put("14", "a075");
                put("54", "a085");
            }
        };
    }

    public TbPageExtraHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ArrayList<String> buildNextPageSourceKeyList(ArrayList<String> arrayList, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, arrayList, str)) == null) {
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

    public static BaseFragment findFragmentByView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, view)) == null) {
            c.a.q0.n0.a findFragmentExtraSupportByView = findFragmentExtraSupportByView(view);
            if (findFragmentExtraSupportByView == null || findFragmentExtraSupportByView.getTbFragmentExtra() == null) {
                return null;
            }
            return findFragmentExtraSupportByView.getTbFragmentExtra().a();
        }
        return (BaseFragment) invokeL.objValue;
    }

    public static c.a.q0.n0.a findFragmentExtraSupportByView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, view)) == null) {
            ViewParent parent = view.getParent();
            c.a.q0.n0.a aVar = null;
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if (viewGroup instanceof c.a.q0.n0.a) {
                    aVar = (c.a.q0.n0.a) parent;
                    printLog(viewGroup, "ITbFragmentExtraSupport From Implements Interface------->");
                }
                if (aVar == null) {
                    Object tag = viewGroup.getTag(R.id.tag_tb_fragment_extra);
                    if (tag instanceof c.a.q0.n0.a) {
                        aVar = (c.a.q0.n0.a) tag;
                        printLog(viewGroup, "ITbFragmentExtraSupport From View.getTag()------->");
                    }
                }
                if (aVar != null && aVar.getTbFragmentExtra() != null) {
                    BaseFragment a2 = aVar.getTbFragmentExtra().a();
                    if (a2 != null && a2.getBaseFragmentActivity() != null) {
                        BaseFragmentActivity baseFragmentActivity = a2.getBaseFragmentActivity();
                        printLog(a2, "ActivityPageKey=" + baseFragmentActivity.getCurrentPageKey() + ",FragmentPageKey=" + a2.getCurrentPageKey());
                    }
                    return aVar;
                }
                return findFragmentExtraSupportByView(viewGroup);
            }
            return null;
        }
        return (c.a.q0.n0.a) invokeL.objValue;
    }

    public static c findPageExtraByView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, view)) == null) {
            BaseFragment findFragmentByView = findFragmentByView(view);
            c tbPageExtra = findFragmentByView != null ? findFragmentByView.getTbPageExtra() : null;
            return (tbPageExtra == null || tbPageExtra.f()) ? getCurrentVisiblePageExtra(getActivityByView(view)) : tbPageExtra;
        }
        return (c) invokeL.objValue;
    }

    public static Activity getActivityByView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, view)) == null) {
            if (view == null) {
                return null;
            }
            return getActivityFromContext(view.getContext());
        }
        return (Activity) invokeL.objValue;
    }

    public static Activity getActivityFromContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            printLog(context, "currentContext");
            while (context instanceof ContextWrapper) {
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    printLog(activity, "currentActivity");
                    return activity;
                }
                context = ((ContextWrapper) context).getBaseContext();
                printLog(context, "currentContextWrapper");
            }
            return null;
        }
        return (Activity) invokeL.objValue;
    }

    public static c getCurrentPageExtraByActivity(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, activity)) == null) {
            if (activity instanceof BaseFragmentActivity) {
                BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) activity;
                printLog(baseFragmentActivity, "context is BaseFragmentActivity");
                c currentPageExtraByFragmentActivity = getCurrentPageExtraByFragmentActivity(baseFragmentActivity);
                printTbPageExtra(currentPageExtraByFragmentActivity);
                return currentPageExtraByFragmentActivity;
            } else if (activity instanceof BaseActivity) {
                BaseActivity baseActivity = (BaseActivity) activity;
                printLog(baseActivity, "context is BaseActivity");
                c tbPageExtra = baseActivity.getTbPageExtra();
                printTbPageExtra(tbPageExtra);
                return tbPageExtra;
            } else {
                return null;
            }
        }
        return (c) invokeL.objValue;
    }

    public static c getCurrentPageExtraByFragmentActivity(BaseFragmentActivity baseFragmentActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, baseFragmentActivity)) == null) {
            FragmentManager supportFragmentManager = baseFragmentActivity.getSupportFragmentManager();
            printFragments(supportFragmentManager);
            List<Fragment> fragments = supportFragmentManager.getFragments();
            Stack stack = new Stack();
            for (Fragment fragment : fragments) {
                if (fragment instanceof BaseFragment) {
                    pushStackVisibleFragment(stack, (BaseFragment) fragment);
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
                    printLog(baseFragment, "CurrentFragmentExtra-->" + cVar);
                    break;
                }
            }
            stack.clear();
            if (cVar == null || cVar.f()) {
                String b2 = cVar == null ? "" : cVar.b();
                c tbPageExtra = baseFragmentActivity.getTbPageExtra();
                if (tbPageExtra != null) {
                    tbPageExtra.h(b2);
                }
                printLog(baseFragmentActivity, "CurrentActivityExtra-->" + tbPageExtra);
                return tbPageExtra;
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public static c getCurrentVisiblePageExtra(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            printLog("======================Start==============================");
            printLog("context : " + context);
            Activity activityFromContext = getActivityFromContext(context);
            if (!(context instanceof Activity)) {
                printLog(context, "context is not Activity, so getCurrentActivity()");
                activityFromContext = TbadkCoreApplication.getInst().getCurrentActivity();
            }
            c currentPageExtraByActivity = getCurrentPageExtraByActivity(activityFromContext);
            if (currentPageExtraByActivity == null) {
                printLog(context, "------Not Activity，No TbPageExtra!------");
            }
            printLog("**************************End**************************");
            return currentPageExtraByActivity;
        }
        return (c) invokeL.objValue;
    }

    public static String getCurrentVisiblePageKey(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            c currentVisiblePageExtra = getCurrentVisiblePageExtra(context);
            if (currentVisiblePageExtra == null) {
                return null;
            }
            return currentVisiblePageExtra.a();
        }
        return (String) invokeL.objValue;
    }

    public static String getPrePageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? prePageKey : (String) invokeV.objValue;
    }

    public static boolean isNeedPrintLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? TbadkCoreApplication.getInst().isDebugMode() : invokeV.booleanValue;
    }

    public static boolean isVisibleFragment(BaseFragment baseFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, baseFragment)) == null) ? baseFragment != null && baseFragment.isVisible() && baseFragment.isPrimary() : invokeL.booleanValue;
    }

    public static boolean prePageKeyIsPersonalCenter(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) ? typeAndPreFlutterPageKeyMap.get(str) == "a028" : invokeL.booleanValue;
    }

    public static final void printFragments(FragmentManager fragmentManager) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, null, fragmentManager) == null) && isNeedPrintLog()) {
            List<Fragment> fragments = fragmentManager.getFragments();
            if (ListUtils.isEmpty(fragments)) {
                return;
            }
            printLog("FragmentManager---->" + fragmentManager);
            printLog("---------------------------Start---------------------------");
            printLog("Print All ChildFragments=" + ListUtils.getCount(fragments));
            for (Fragment fragment : fragments) {
                boolean isPrimary = fragment instanceof BaseFragment ? ((BaseFragment) fragment).isPrimary() : false;
                boolean userVisibleHint = fragment.getUserVisibleHint();
                boolean isVisible = fragment.isVisible();
                printLog(fragment, "isUserVisible=" + userVisibleHint + ",isVisible=" + isVisible + ",isPrimary=" + isPrimary);
            }
            printLog("---------------------------End---------------------------");
        }
    }

    public static final void printLog(Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65555, null, obj, str) == null) && isNeedPrintLog() && obj != null) {
            String str2 = obj.getClass().getSimpleName() + ZeusCrashHandler.NAME_SEPERATOR + str;
        }
    }

    public static final void printTbPageExtra(c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65557, null, cVar) == null) && isNeedPrintLog() && cVar != null) {
            String a2 = cVar.a();
            String e2 = cVar.e();
            ArrayList<String> d2 = cVar.d();
            ArrayList<String> c2 = cVar.c();
            printLog(cVar, "Current TbPageExtra:currentPageKey=" + a2 + ",prePageKey=" + e2 + ",preList=" + d2.toString() + ",nextList=" + c2.toString());
        }
    }

    public static void pushStackVisibleFragment(Stack<BaseFragment> stack, BaseFragment baseFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65558, null, stack, baseFragment) == null) && isVisibleFragment(baseFragment)) {
            stack.push(baseFragment);
            printLog(baseFragment, "VisibleParentFragment-->" + baseFragment);
            FragmentManager childFragmentManager = baseFragment.getChildFragmentManager();
            printFragments(childFragmentManager);
            List<Fragment> fragments = childFragmentManager.getFragments();
            if (ListUtils.isEmpty(fragments)) {
                return;
            }
            for (Fragment fragment : fragments) {
                if (fragment instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) fragment;
                    if (isVisibleFragment(baseFragment2)) {
                        pushStackVisibleFragment(stack, baseFragment2);
                    }
                }
            }
        }
    }

    public static void setPrePageKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, str) == null) {
            prePageKey = str;
        }
    }

    public static void setPrePageKeyByFlutterStart(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65560, null, str) == null) && !StringUtil.isEmpty(str) && typeAndPreFlutterPageKeyMap.containsKey(str)) {
            e.a().postDelayed(new a(str), 100L);
        }
    }

    public static final void printLog(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65556, null, str) != null) || !isNeedPrintLog()) {
        }
    }
}
