package com.baidu.tieba;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d9<T> mContext;
    public InputMethodManager mInputManager;

    public b9(d9<T> d9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = null;
        this.mInputManager = null;
        this.mContext = d9Var;
    }

    public void HidenSoftKeyPad(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            try {
                if (this.mInputManager == null) {
                    getInputMethodManager();
                }
                if (this.mInputManager != null && view2 != null) {
                    this.mInputManager.hideSoftInputFromWindow(view2.getWindowToken(), 2);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void ShowSoftKeyPad(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            try {
                getInputMethodManager().showSoftInput(view2, 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public InputMethodManager getInputMethodManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mInputManager == null) {
                this.mInputManager = (InputMethodManager) this.mContext.getContext().getSystemService("input_method");
            }
            return this.mInputManager;
        }
        return (InputMethodManager) invokeV.objValue;
    }

    public d9<T> getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mContext : (d9) invokeV.objValue;
    }

    public void setInputMethodManager(InputMethodManager inputMethodManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, inputMethodManager) == null) {
            this.mInputManager = inputMethodManager;
        }
    }
}
