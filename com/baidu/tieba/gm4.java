package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class gm4 {
    public static /* synthetic */ Interceptable $ic;
    public static View.OnClickListener a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TbPageContext<?> d;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Object tag = view2.getTag();
                if (tag instanceof CompleteTaskToastData) {
                    CompleteTaskToastData completeTaskToastData = (CompleteTaskToastData) tag;
                    if (TextUtils.isEmpty(completeTaskToastData.url) || (d = gm4.d()) == null) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(d, new String[]{completeTaskToastData.url});
                    wm4.b(completeTaskToastData.activityId, completeTaskToastData.missionId);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947798715, "Lcom/baidu/tieba/gm4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947798715, "Lcom/baidu/tieba/gm4;");
                return;
            }
        }
        a = new a();
    }

    public static void a(MotionEvent motionEvent, int i, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{motionEvent, Integer.valueOf(i), Long.valueOf(j)}) == null) && motionEvent != null && motionEvent.getAction() == 0) {
            g(i, j);
        }
    }

    public static void b(int i, int i2, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), str}) == null) {
            MissionEvent missionEvent = new MissionEvent();
            missionEvent.tid = j;
            missionEvent.pageId = i2;
            missionEvent.pageType = i;
            missionEvent.actionType = str;
            na5.i(missionEvent);
        }
    }

    public static void c(int i, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Long.valueOf(j), str}) == null) {
            MissionEvent missionEvent = new MissionEvent();
            missionEvent.tid = j;
            missionEvent.pageId = i;
            missionEvent.actionType = str;
            na5.i(missionEvent);
        }
    }

    public static TbPageContext d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof BaseActivity) {
                return ((BaseActivity) currentActivity).getPageContext();
            }
            if (currentActivity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) currentActivity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? TbadkCoreApplication.getInst().isMainProcess(true) : invokeV.booleanValue;
    }

    public static void f(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (e()) {
                rl4.w().E();
            } else {
                c(i, j, MissionEvent.MESSAGE_PAUSE);
            }
        }
    }

    public static void g(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (e()) {
                rl4.w().F();
            } else {
                c(i, j, MissionEvent.MESSAGE_TOUCH);
            }
        }
    }

    public static void h(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (e()) {
                rl4.w().K(i, j);
            } else {
                c(i, j, MissionEvent.MESSAGE_ACTIVITY);
            }
        }
    }

    public static tu4 i(CompleteTaskToastData completeTaskToastData) {
        InterceptResult invokeL;
        TbPageContext d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, completeTaskToastData)) == null) {
            if (completeTaskToastData == null || (d = d()) == null || d.getUniqueId() == null || completeTaskToastData.pageId != d.getUniqueId().getId()) {
                return null;
            }
            tu4 f = tu4.f(d.getPageActivity(), completeTaskToastData.message);
            f.g(completeTaskToastData.duration);
            f.h(a);
            f.i(completeTaskToastData);
            f.j();
            return f;
        }
        return (tu4) invokeL.objValue;
    }

    public static void j(int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            if (e()) {
                rl4.w().P(i, j);
            } else {
                b(i, i2, j, "onResume");
            }
        }
    }
}
