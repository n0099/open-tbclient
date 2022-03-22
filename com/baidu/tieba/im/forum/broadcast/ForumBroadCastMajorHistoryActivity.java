package com.baidu.tieba.im.forum.broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.p0.u1.i.a.a;
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
/* loaded from: classes5.dex */
public class ForumBroadCastMajorHistoryActivity extends BaseActivity<ForumBroadCastMajorHistoryActivity> implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mForumId;
    public String mForumName;
    public ForumBroadCastMajorHistoryModel mModel;
    public c.a.p0.u1.i.a.c.a mView;
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

    @Override // c.a.p0.u1.i.a.a
    public void loadMore() {
        ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (forumBroadCastMajorHistoryModel = this.mModel) == null) {
            return;
        }
        forumBroadCastMajorHistoryModel.loadMore();
    }

    @Override // c.a.p0.u1.i.a.a
    public void netCallback(c.a.p0.u1.i.a.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel = this.mModel;
            if (forumBroadCastMajorHistoryModel != null && !forumBroadCastMajorHistoryModel.a()) {
                this.mView.r(getString(R.string.obfuscated_res_0x7f0f089e), false);
                return;
            }
            c.a.p0.u1.i.a.c.a aVar2 = this.mView;
            if (aVar2 != null) {
                aVar2.o(aVar);
            }
        }
    }

    @Override // c.a.p0.u1.i.a.a
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
            this.rootView = LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d02a9, (ViewGroup) null);
            this.mView = new c.a.p0.u1.i.a.c.a(getPageContext(), this, this.rootView, this.mForumId, this.mForumName, this.mfrom, bundle);
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
            c.a.p0.u1.i.a.c.a aVar = this.mView;
            if (aVar != null) {
                aVar.n();
            }
            ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel = this.mModel;
            if (forumBroadCastMajorHistoryModel != null) {
                forumBroadCastMajorHistoryModel.J();
            }
        }
    }

    @Override // c.a.o0.r.l0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            refresh();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && l.z()) {
            hideNetRefreshView(this.rootView);
            refresh();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        c.a.p0.u1.i.a.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, intent) == null) {
            super.onNewIntent(intent);
            refresh();
            if (!ForumBroadcastHelper.VALUE_INTENT_BCAST_FROM_EDIT_SUCCESS.equals(intent.getStringExtra("from")) || (aVar = this.mView) == null) {
                return;
            }
            aVar.s();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
        }
    }

    @Override // c.a.p0.u1.i.a.a
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
            this.mView.r(errorData != null ? getString(R.string.obfuscated_res_0x7f0f0c14, new Object[]{errorData.error_msg, Integer.valueOf(errorData.error_code)}) : null, false);
        }
    }

    @Override // c.a.p0.u1.i.a.a
    public void refresh() {
        ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (forumBroadCastMajorHistoryModel = this.mModel) == null) {
            return;
        }
        forumBroadCastMajorHistoryModel.refresh();
    }
}
