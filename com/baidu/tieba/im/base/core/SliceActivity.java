package com.baidu.tieba.im.base.core;

import android.content.Intent;
import android.view.KeyEvent;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class SliceActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public SliceActivity() {
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
        this.a = -1;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    @CallSuper
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.finish();
            for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                if (fragment instanceof BaseFragment) {
                    ((BaseFragment) fragment).onActivityFinish();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                if (fragment instanceof BaseFragment) {
                    fragment.onActivityResult(i, i2, intent);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    @CallSuper
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                if (fragment instanceof BaseFragment) {
                    fragment.onRequestPermissionsResult(i, strArr, iArr);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    @CallSuper
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || this.a == i) {
            return;
        }
        this.a = i;
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            if (fragment instanceof BaseFragment) {
                ((BaseFragment) fragment).onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                if (fragment instanceof BaseFragment) {
                    ((BaseFragment) fragment).onKeyboardVisibilityChanged(z);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    @CallSuper
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, keyEvent)) == null) {
            for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                if ((fragment instanceof BaseFragment) && ((BaseFragment) fragment).onKeyDown(i, keyEvent)) {
                    return true;
                }
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }
}
