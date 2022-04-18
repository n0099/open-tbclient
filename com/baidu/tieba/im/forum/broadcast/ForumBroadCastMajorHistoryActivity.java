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
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
import com.baidu.tieba.im.forum.broadcast.model.ForumBroadCastMajorHistoryModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mi;
import com.repackage.s67;
import com.repackage.t67;
import com.repackage.v67;
/* loaded from: classes3.dex */
public class ForumBroadCastMajorHistoryActivity extends BaseActivity<ForumBroadCastMajorHistoryActivity> implements s67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mForumId;
    public String mForumName;
    public ForumBroadCastMajorHistoryModel mModel;
    public v67 mView;
    public String mfrom;
    public View rootView;

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

    private void initParamsFromIntent(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, bundle) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.mForumId = intent.getStringExtra("forum_id");
                this.mForumName = intent.getStringExtra("forum_name");
                this.mfrom = intent.getStringExtra("from");
            } else if (bundle != null) {
                this.mForumId = bundle.getString("forum_id");
                this.mForumName = bundle.getString("forum_name");
                this.mfrom = bundle.getString("from");
            }
        }
    }

    @Override // com.repackage.s67
    public void loadMore() {
        ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (forumBroadCastMajorHistoryModel = this.mModel) == null) {
            return;
        }
        forumBroadCastMajorHistoryModel.loadMore();
    }

    @Override // com.repackage.s67
    public void netCallback(t67 t67Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t67Var) == null) {
            ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel = this.mModel;
            if (forumBroadCastMajorHistoryModel != null && !forumBroadCastMajorHistoryModel.a()) {
                this.mView.r(getString(R.string.obfuscated_res_0x7f0f089e), false);
                return;
            }
            v67 v67Var = this.mView;
            if (v67Var != null) {
                v67Var.o(t67Var);
            }
        }
    }

    @Override // com.repackage.s67
    public void netResidueCallback(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumBroadcastMajorResidueData) == null) {
            this.mView.u(forumBroadcastMajorResidueData);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
            this.mView.m(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            initParamsFromIntent(bundle);
            this.mModel = new ForumBroadCastMajorHistoryModel(getPageContext(), this, this.mForumId);
            this.rootView = LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d02aa, (ViewGroup) null);
            this.mView = new v67(getPageContext(), this, this.rootView, this.mForumId, this.mForumName, this.mfrom, bundle);
            setContentView(this.rootView);
            this.mModel.H();
            refresh();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            v67 v67Var = this.mView;
            if (v67Var != null) {
                v67Var.n();
            }
            ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel = this.mModel;
            if (forumBroadCastMajorHistoryModel != null) {
                forumBroadCastMajorHistoryModel.J();
            }
        }
    }

    @Override // com.repackage.cu4.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            refresh();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && mi.z()) {
            hideNetRefreshView(this.rootView);
            refresh();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        v67 v67Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, intent) == null) {
            super.onNewIntent(intent);
            refresh();
            if (!ForumBroadcastHelper.VALUE_INTENT_BCAST_FROM_EDIT_SUCCESS.equals(intent.getStringExtra("from")) || (v67Var = this.mView) == null) {
                return;
            }
            v67Var.s();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
        }
    }

    @Override // com.repackage.s67
    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, errorData) == null) {
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.obfuscated_res_0x7f0f089e);
                }
            }
            ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel = this.mModel;
            if (forumBroadCastMajorHistoryModel == null || forumBroadCastMajorHistoryModel.a()) {
                return;
            }
            this.mView.r(errorData != null ? getString(R.string.obfuscated_res_0x7f0f0c16, new Object[]{errorData.error_msg, Integer.valueOf(errorData.error_code)}) : null, false);
        }
    }

    @Override // com.repackage.s67
    public void refresh() {
        ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (forumBroadCastMajorHistoryModel = this.mModel) == null) {
            return;
        }
        forumBroadCastMajorHistoryModel.refresh();
    }
}
