package com.baidu.tieba.im.forum.broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.h87;
import com.baidu.tieba.i87;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
import com.baidu.tieba.im.forum.broadcast.model.ForumBroadCastMajorHistoryModel;
import com.baidu.tieba.k87;
import com.baidu.tieba.pi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ForumBroadCastMajorHistoryActivity extends BaseActivity<ForumBroadCastMajorHistoryActivity> implements h87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumBroadCastMajorHistoryModel a;
    public k87 b;
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

    @Override // com.baidu.tieba.h87
    public void A0(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, forumBroadcastMajorResidueData) == null) {
            this.b.u(forumBroadcastMajorResidueData);
        }
    }

    @Override // com.baidu.tieba.h87
    public void b() {
        ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (forumBroadCastMajorHistoryModel = this.a) == null) {
            return;
        }
        forumBroadCastMajorHistoryModel.b();
    }

    @Override // com.baidu.tieba.h87
    public void c0(i87 i87Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i87Var) == null) {
            ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel = this.a;
            if (forumBroadCastMajorHistoryModel != null && !forumBroadCastMajorHistoryModel.a()) {
                this.b.r(getString(R.string.obfuscated_res_0x7f0f08bd), false);
                return;
            }
            k87 k87Var = this.b;
            if (k87Var != null) {
                k87Var.o(i87Var);
            }
        }
    }

    @Override // com.baidu.tieba.bv4.g
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            refresh();
        }
    }

    @Override // com.baidu.tieba.h87
    public void f(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, errorData) == null) {
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.obfuscated_res_0x7f0f08bd);
                }
            }
            ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel = this.a;
            if (forumBroadCastMajorHistoryModel == null || forumBroadCastMajorHistoryModel.a()) {
                return;
            }
            this.b.r(errorData != null ? getString(R.string.obfuscated_res_0x7f0f0c3f, new Object[]{errorData.error_msg, Integer.valueOf(errorData.error_code)}) : null, false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            z1(bundle);
            this.a = new ForumBroadCastMajorHistoryModel(getPageContext(), this, this.d);
            this.c = LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d029f, (ViewGroup) null);
            this.b = new k87(getPageContext(), this, this.c, this.d, this.e, this.f, bundle);
            setContentView(this.c);
            this.a.I();
            refresh();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            k87 k87Var = this.b;
            if (k87Var != null) {
                k87Var.n();
            }
            ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel = this.a;
            if (forumBroadCastMajorHistoryModel != null) {
                forumBroadCastMajorHistoryModel.K();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && pi.z()) {
            hideNetRefreshView(this.c);
            refresh();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        k87 k87Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, intent) == null) {
            super.onNewIntent(intent);
            refresh();
            if (!ForumBroadcastHelper.VALUE_INTENT_BCAST_FROM_EDIT_SUCCESS.equals(intent.getStringExtra("from")) || (k87Var = this.b) == null) {
                return;
            }
            k87Var.s();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
        }
    }

    @Override // com.baidu.tieba.h87
    public void refresh() {
        ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (forumBroadCastMajorHistoryModel = this.a) == null) {
            return;
        }
        forumBroadCastMajorHistoryModel.refresh();
    }

    public final void z1(Bundle bundle) {
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
