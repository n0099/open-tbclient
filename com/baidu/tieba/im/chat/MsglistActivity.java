package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b67;
import com.repackage.ke5;
import com.repackage.w57;
/* loaded from: classes3.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements w57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean u;

    public MsglistActivity() {
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

    public abstract void initView();

    public abstract boolean m1(w57 w57Var);

    public abstract boolean n1(Bundle bundle);

    public boolean o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            View view2 = this.o;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            }
            AbsMsglistView absMsglistView = this.b;
            if (absMsglistView != null) {
                absMsglistView.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            if (!n1(bundle)) {
                finish();
                return;
            }
            initView();
            adjustResizeForSoftInput(R.color.CAM_X0201, false);
            MsglistModel msglistModel = this.c;
            if (msglistModel != null) {
                msglistModel.setImageUploadUIProgressCallback(this.j);
            }
            T0();
            if (m1(this)) {
                p1();
                s1();
                b67.a = ke5.b();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            t1();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) {
            super.onNewIntent(intent);
            MsglistModel msglistModel = this.c;
            if (msglistModel != null) {
                msglistModel.onDestroy();
            }
            setIntent(intent);
            if (!n1(null)) {
                finish();
                return;
            }
            initView();
            adjustResizeForSoftInput(R.color.common_color_10022, false);
            T0();
            if (m1(this)) {
                p1();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            AbsMsglistView absMsglistView = this.b;
            if (absMsglistView != null) {
                absMsglistView.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                r1();
            }
        }
    }

    public boolean p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.c.loadDraft() : invokeV.booleanValue;
    }

    public void q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public void r1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                this.b.showReceiver();
            } else {
                this.b.closeReceiver();
            }
        }
    }

    public void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // com.repackage.w57
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            q1();
        }
    }
}
