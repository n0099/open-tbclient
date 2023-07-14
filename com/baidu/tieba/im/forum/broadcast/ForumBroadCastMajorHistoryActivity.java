package com.baidu.tieba.im.forum.broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
import com.baidu.tieba.im.forum.broadcast.model.ForumBroadCastMajorHistoryModel;
import com.baidu.tieba.je8;
import com.baidu.tieba.ke8;
import com.baidu.tieba.me8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ForumBroadCastMajorHistoryActivity extends BaseActivity<ForumBroadCastMajorHistoryActivity> implements je8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumBroadCastMajorHistoryModel a;
    public me8 b;
    public View c;
    public String d;
    public String e;
    public String f;

    public ForumBroadCastMajorHistoryActivity() {
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

    @Override // com.baidu.tieba.je8
    public void b() {
        ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (forumBroadCastMajorHistoryModel = this.a) != null) {
            forumBroadCastMajorHistoryModel.b();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            me8 me8Var = this.b;
            if (me8Var != null) {
                me8Var.n();
            }
            ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel = this.a;
            if (forumBroadCastMajorHistoryModel != null) {
                forumBroadCastMajorHistoryModel.g0();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && BdNetTypeUtil.isNetWorkAvailable()) {
            hideNetRefreshView(this.c);
            refresh();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
        }
    }

    @Override // com.baidu.tieba.je8
    public void refresh() {
        ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (forumBroadCastMajorHistoryModel = this.a) != null) {
            forumBroadCastMajorHistoryModel.refresh();
        }
    }

    @Override // com.baidu.tieba.je8
    public void J0(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, forumBroadcastMajorResidueData) == null) {
            this.b.u(forumBroadcastMajorResidueData);
        }
    }

    @Override // com.baidu.tieba.sa5.g
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            refresh();
        }
    }

    @Override // com.baidu.tieba.je8
    public void l0(ke8 ke8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ke8Var) == null) {
            ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel = this.a;
            if (forumBroadCastMajorHistoryModel != null && !forumBroadCastMajorHistoryModel.d()) {
                this.b.r(getString(R.string.obfuscated_res_0x7f0f0a41), false);
                return;
            }
            me8 me8Var = this.b;
            if (me8Var != null) {
                me8Var.o(ke8Var);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            this.b.m(i);
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        me8 me8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, intent) == null) {
            super.onNewIntent(intent);
            refresh();
            if (ForumBroadcastHelper.VALUE_INTENT_BCAST_FROM_EDIT_SUCCESS.equals(intent.getStringExtra("from")) && (me8Var = this.b) != null) {
                me8Var.s();
            }
        }
    }

    @Override // com.baidu.tieba.je8
    public void f(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, errorData) == null) {
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.obfuscated_res_0x7f0f0a41);
                }
            }
            ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel = this.a;
            if (forumBroadCastMajorHistoryModel != null && !forumBroadCastMajorHistoryModel.d()) {
                String str = null;
                if (errorData != null) {
                    str = getString(R.string.net_error_text, new Object[]{errorData.error_msg, Integer.valueOf(errorData.error_code)});
                }
                this.b.r(str, false);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            u1(bundle);
            this.a = new ForumBroadCastMajorHistoryModel(getPageContext(), this, this.d);
            this.c = LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d02ea, (ViewGroup) null);
            this.b = new me8(getPageContext(), this, this.c, this.d, this.e, this.f, bundle);
            setContentView(this.c);
            this.a.e0();
            refresh();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public final void u1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.d = intent.getStringExtra("forum_id");
                this.e = intent.getStringExtra("forum_name");
                this.f = intent.getStringExtra("from");
            } else if (bundle != null) {
                this.d = bundle.getString("forum_id");
                this.e = bundle.getString("forum_name");
                this.f = bundle.getString("from");
            }
        }
    }
}
