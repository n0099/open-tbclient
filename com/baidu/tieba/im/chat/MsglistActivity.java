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
import com.repackage.e27;
import com.repackage.j27;
import com.repackage.ub5;
/* loaded from: classes3.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements e27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    public abstract boolean first(e27 e27Var);

    public abstract boolean initData(Bundle bundle);

    public abstract void initView();

    public boolean isFriend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean loadDraft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mListModel.loadDraft() : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            View view2 = this.contentView;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            }
            AbsMsglistView absMsglistView = this.mListView;
            if (absMsglistView != null) {
                absMsglistView.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            if (!initData(bundle)) {
                finish();
                return;
            }
            initView();
            adjustResizeForSoftInput(R.color.CAM_X0201, false);
            MsglistModel msglistModel = this.mListModel;
            if (msglistModel != null) {
                msglistModel.setImageUploadUIProgressCallback(this.mUploadProgressCallback);
            }
            initCallback();
            if (first(this)) {
                loadDraft();
                regReceiver();
                j27.a = ub5.b();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            unregReceiver();
        }
    }

    @Override // com.repackage.e27
    public void onFirstHistoryPageLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            onPageInited();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, intent) == null) {
            super.onNewIntent(intent);
            MsglistModel msglistModel = this.mListModel;
            if (msglistModel != null) {
                msglistModel.onDestroy();
            }
            setIntent(intent);
            if (!initData(null)) {
                finish();
                return;
            }
            initView();
            adjustResizeForSoftInput(R.color.common_color_10022, false);
            initCallback();
            if (first(this)) {
                loadDraft();
            }
        }
    }

    public void onPageInited() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            AbsMsglistView absMsglistView = this.mListView;
            if (absMsglistView != null) {
                absMsglistView.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                refreshHeadIcon();
            }
        }
    }

    public void refreshHeadIcon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                this.mListView.showReceiver();
            } else {
                this.mListView.closeReceiver();
            }
        }
    }

    public void regReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public void unregReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }
}
