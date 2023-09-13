package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.Activity;
import android.app.Dialog;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.timepicker.pickerview.listener.OnTimeSelectListener;
import com.baidu.tieba.qe5;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SignManager {
    public static /* synthetic */ Interceptable $ic;
    public static SignManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public qe5 mISignManager;
    public String mSignInfo;

    public SignManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mISignManager = getISignManager();
    }

    private qe5 getISignManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, qe5.class);
            if (runTask != null) {
                return (qe5) runTask.getData();
            }
            return null;
        }
        return (qe5) invokeV.objValue;
    }

    public static SignManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (mInstance == null) {
                synchronized (SignManager.class) {
                    if (mInstance == null) {
                        mInstance = new SignManager();
                    }
                }
            }
            return mInstance;
        }
        return (SignManager) invokeV.objValue;
    }

    public int getSignAlertHours() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            qe5 qe5Var = this.mISignManager;
            if (qe5Var != null) {
                return qe5Var.g();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getSignAlertMins() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            qe5 qe5Var = this.mISignManager;
            if (qe5Var != null) {
                return qe5Var.b();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String getSignInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mSignInfo;
        }
        return (String) invokeV.objValue;
    }

    public boolean isSignAlertOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            qe5 qe5Var = this.mISignManager;
            if (qe5Var != null) {
                return qe5Var.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void updateSignAlarm() {
        qe5 qe5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (qe5Var = this.mISignManager) != null) {
            qe5Var.c();
        }
    }

    public void checkAndShowTimePicker(int i, TbPageContext tbPageContext, ViewGroup viewGroup, boolean z) {
        qe5 qe5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), tbPageContext, viewGroup, Boolean.valueOf(z)}) == null) && (qe5Var = this.mISignManager) != null) {
            qe5Var.f(i, tbPageContext, viewGroup, z);
        }
    }

    public void setSignAlert(boolean z, int i, int i2) {
        qe5 qe5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) && (qe5Var = this.mISignManager) != null) {
            qe5Var.i(z, i, i2);
        }
    }

    public void setSignInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.mSignInfo = str;
        }
    }

    public NavigationBarCoverTip showSignNavBarCoverTip(Activity activity, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, activity, viewGroup)) == null) {
            qe5 qe5Var = this.mISignManager;
            if (qe5Var != null) {
                return qe5Var.e(activity, viewGroup);
            }
            return null;
        }
        return (NavigationBarCoverTip) invokeLL.objValue;
    }

    public void updateSignSwitchAndTimeByServerSync(boolean z, long j) {
        qe5 qe5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) && (qe5Var = this.mISignManager) != null) {
            qe5Var.h(z, j);
        }
    }

    public Dialog showTimePicker(int i, TbPageContext tbPageContext, OnTimeSelectListener onTimeSelectListener, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), tbPageContext, onTimeSelectListener, Boolean.valueOf(z)})) == null) {
            qe5 qe5Var = this.mISignManager;
            if (qe5Var != null) {
                return qe5Var.d(i, tbPageContext, onTimeSelectListener, z);
            }
            return null;
        }
        return (Dialog) invokeCommon.objValue;
    }
}
