package com.baidu.tieba.forumsearch.controller;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.ih7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ForumSearchActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ih7 a;

    public ForumSearchActivity() {
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
            this.a.t();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            ih7 ih7Var = new ih7(getPageContext());
            this.a = ih7Var;
            setContentView(ih7Var.o().b);
            Intent intent = getIntent();
            if (intent != null) {
                this.a.y(intent.getIntExtra(SelectForumActivityConfig.EXTRA_KEY_FROM, 0));
                this.a.z(intent.getLongExtra("extra_key_live_id", 0L));
                this.a.G(intent.getStringExtra("extra_key_yy_anchor_bduid"));
                this.a.D((OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_ORIGINAL_THREAD));
                this.a.u((BaijiahaoData) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_BAIJIAHAO_DATA));
                this.a.E(intent.getStringExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_ORIGIN_THREAD_CONTENT));
                this.a.F(intent.getStringExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_THREAD_AUTHOR_NAME_SHOW));
                this.a.A(intent.getStringExtra("more_forum_img"));
                this.a.C(intent.getStringExtra("more_forum_url"));
                this.a.B(intent.getStringExtra("more_forum_title"));
            }
        }
    }
}
