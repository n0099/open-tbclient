package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.dx5;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.td8;
import com.baidu.tieba.zd8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements td8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean u;

    public abstract boolean U1(td8 td8Var);

    public abstract boolean W1(Bundle bundle);

    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public abstract void initView();

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

    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c.loadDraft();
        }
        return invokeV.booleanValue;
    }

    public void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                this.b.showReceiver();
            } else {
                this.b.closeReceiver();
            }
        }
    }

    @Override // com.baidu.tieba.td8
    public void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Z1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            c2();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            AbsMsglistView absMsglistView = this.b;
            if (absMsglistView != null) {
                absMsglistView.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                a2();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
            if (!W1(bundle)) {
                finish();
                return;
            }
            initView();
            adjustResizeForSoftInput(R.color.CAM_X0201, false);
            MsglistModel msglistModel = this.c;
            if (msglistModel != null) {
                msglistModel.setImageUploadUIProgressCallback(this.j);
            }
            F1();
            if (!U1(this)) {
                return;
            }
            Y1();
            b2();
            zd8.a = dx5.b();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, intent) == null) {
            super.onNewIntent(intent);
            MsglistModel msglistModel = this.c;
            if (msglistModel != null) {
                msglistModel.onDestroy();
            }
            setIntent(intent);
            if (!W1(null)) {
                finish();
                return;
            }
            initView();
            adjustResizeForSoftInput(R.color.common_color_10022, false);
            F1();
            if (!U1(this)) {
                return;
            }
            Y1();
        }
    }
}
