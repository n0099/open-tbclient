package com.baidu.tbadk.pageExtra;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.ah;
import com.baidu.tieba.vd5;
import com.baidu.tieba.xd5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
/* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String unused = TbPageExtraHelper.prePageKey = (String) TbPageExtraHelper.typeAndPreFlutterPageKeyMap.get(this.a);
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                put("12", "a028");
                put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_AMOUNT_ITEM_CLICK, "a075");
                put("24", "a025");
                put("18", "a075");
                put("7", "a028");
                put("1", "a075");
                put("2", "a028");
                put("14", "a075");
                put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_CLOSE_BTN_CLICK, "a085");
            }
        };
    }

    public TbPageExtraHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getPrePageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return prePageKey;
        }
        return (String) invokeV.objValue;
    }

    public static boolean isNeedPrintLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return TbadkCoreApplication.getInst().isDebugMode();
        }
        return invokeV.booleanValue;
    }

    public static BaseFragment findFragmentByView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, view2)) == null) {
            vd5 findFragmentExtraSupportByView = findFragmentExtraSupportByView(view2);
            if (findFragmentExtraSupportByView != null && findFragmentExtraSupportByView.getTbFragmentExtra() != null) {
                return findFragmentExtraSupportByView.getTbFragmentExtra().a();
            }
            return null;
        }
        return (BaseFragment) invokeL.objValue;
    }

    public static xd5 findPageExtraByView(View view2) {
        InterceptResult invokeL;
        xd5 xd5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, view2)) == null) {
            BaseFragment findFragmentByView = findFragmentByView(view2);
            if (findFragmentByView != null) {
                xd5Var = findFragmentByView.getTbPageExtra();
            } else {
                xd5Var = null;
            }
            if (xd5Var == null || xd5Var.f()) {
                return getCurrentVisiblePageExtra(getActivityByView(view2));
            }
            return xd5Var;
        }
        return (xd5) invokeL.objValue;
    }

    public static Activity getActivityByView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            return getActivityFromContext(view2.getContext());
        }
        return (Activity) invokeL.objValue;
    }

    public static String getCurrentVisiblePageKey(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            xd5 currentVisiblePageExtra = getCurrentVisiblePageExtra(context);
            if (currentVisiblePageExtra == null) {
                return null;
            }
            return currentVisiblePageExtra.a();
        }
        return (String) invokeL.objValue;
    }

    public static boolean isVisibleFragment(BaseFragment baseFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, baseFragment)) == null) {
            if (baseFragment != null && baseFragment.isVisible() && baseFragment.isPrimary()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean prePageKeyIsPersonalCenter(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (typeAndPreFlutterPageKeyMap.get(str) == "a028") {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final void printLog(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65556, null, str) != null) || !isNeedPrintLog()) {
            return;
        }
        Log.d(KEY, str);
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
            ah.a().postDelayed(new a(str), 100L);
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

    public static vd5 findFragmentExtraSupportByView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, view2)) == null) {
            ViewParent parent = view2.getParent();
            vd5 vd5Var = null;
            if (!(parent instanceof ViewGroup)) {
                return null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup instanceof vd5) {
                vd5Var = (vd5) parent;
                printLog(viewGroup, "ITbFragmentExtraSupport From Implements Interface------->");
            }
            if (vd5Var == null) {
                Object tag = viewGroup.getTag(R.id.obfuscated_res_0x7f0920e3);
                if (tag instanceof vd5) {
                    vd5Var = (vd5) tag;
                    printLog(viewGroup, "ITbFragmentExtraSupport From View.getTag()------->");
                }
            }
            if (vd5Var != null && vd5Var.getTbFragmentExtra() != null) {
                BaseFragment a2 = vd5Var.getTbFragmentExtra().a();
                if (a2 != null && a2.getBaseFragmentActivity() != null) {
                    BaseFragmentActivity baseFragmentActivity = a2.getBaseFragmentActivity();
                    printLog(a2, "ActivityPageKey=" + baseFragmentActivity.getCurrentPageKey() + ",FragmentPageKey=" + a2.getCurrentPageKey());
                }
                return vd5Var;
            }
            return findFragmentExtraSupportByView(viewGroup);
        }
        return (vd5) invokeL.objValue;
    }

    public static final void printTbPageExtra(xd5 xd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65557, null, xd5Var) != null) || !isNeedPrintLog() || xd5Var == null) {
            return;
        }
        String a2 = xd5Var.a();
        String e = xd5Var.e();
        ArrayList<String> d = xd5Var.d();
        ArrayList<String> c = xd5Var.c();
        printLog(xd5Var, "Current TbPageExtra:currentPageKey=" + a2 + ",prePageKey=" + e + ",preList=" + d.toString() + ",nextList=" + c.toString());
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

    public static xd5 getCurrentPageExtraByActivity(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, activity)) == null) {
            if (activity instanceof BaseFragmentActivity) {
                BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) activity;
                printLog(baseFragmentActivity, "context is BaseFragmentActivity");
                xd5 currentPageExtraByFragmentActivity = getCurrentPageExtraByFragmentActivity(baseFragmentActivity);
                printTbPageExtra(currentPageExtraByFragmentActivity);
                return currentPageExtraByFragmentActivity;
            } else if (activity instanceof BaseActivity) {
                BaseActivity baseActivity = (BaseActivity) activity;
                printLog(baseActivity, "context is BaseActivity");
                xd5 tbPageExtra = baseActivity.getTbPageExtra();
                printTbPageExtra(tbPageExtra);
                return tbPageExtra;
            } else {
                return null;
            }
        }
        return (xd5) invokeL.objValue;
    }

    public static xd5 getCurrentPageExtraByFragmentActivity(BaseFragmentActivity baseFragmentActivity) {
        InterceptResult invokeL;
        String b;
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
            xd5 xd5Var = null;
            while (true) {
                if (stack.empty()) {
                    break;
                }
                BaseFragment baseFragment = (BaseFragment) stack.pop();
                if (baseFragment != null && baseFragment.isPrimary() && baseFragment.getTbPageExtra() != null) {
                    xd5Var = baseFragment.getTbPageExtra();
                    printLog(baseFragment, "CurrentFragmentExtra-->" + xd5Var);
                    break;
                }
            }
            stack.clear();
            if (xd5Var == null || xd5Var.f()) {
                if (xd5Var == null) {
                    b = "";
                } else {
                    b = xd5Var.b();
                }
                xd5 tbPageExtra = baseFragmentActivity.getTbPageExtra();
                if (tbPageExtra != null) {
                    tbPageExtra.h(b);
                }
                printLog(baseFragmentActivity, "CurrentActivityExtra-->" + tbPageExtra);
                return tbPageExtra;
            }
            return xd5Var;
        }
        return (xd5) invokeL.objValue;
    }

    public static final void printFragments(FragmentManager fragmentManager) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65554, null, fragmentManager) != null) || !isNeedPrintLog()) {
            return;
        }
        List<Fragment> fragments = fragmentManager.getFragments();
        if (ListUtils.isEmpty(fragments)) {
            return;
        }
        printLog("FragmentManager---->" + fragmentManager);
        printLog("---------------------------Start---------------------------");
        printLog("Print All ChildFragments=" + ListUtils.getCount(fragments));
        for (Fragment fragment : fragments) {
            if (fragment instanceof BaseFragment) {
                z = ((BaseFragment) fragment).isPrimary();
            } else {
                z = false;
            }
            boolean userVisibleHint = fragment.getUserVisibleHint();
            boolean isVisible = fragment.isVisible();
            printLog(fragment, "isUserVisible=" + userVisibleHint + ",isVisible=" + isVisible + ",isPrimary=" + z);
        }
        printLog("---------------------------End---------------------------");
    }

    public static xd5 getCurrentVisiblePageExtra(Context context) {
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
            xd5 currentPageExtraByActivity = getCurrentPageExtraByActivity(activityFromContext);
            if (currentPageExtraByActivity == null) {
                printLog(context, "------Not Activity，No TbPageExtra!------");
            }
            printLog("**************************End**************************");
            return currentPageExtraByActivity;
        }
        return (xd5) invokeL.objValue;
    }

    public static final void printLog(Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65555, null, obj, str) != null) || !isNeedPrintLog()) {
            return;
        }
        if (obj != null) {
            str = obj.getClass().getSimpleName() + ZeusCrashHandler.NAME_SEPERATOR + str;
        }
        Log.d(KEY, str);
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
}
