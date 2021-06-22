package com.baidu.tieba.forumsearch.controller;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import d.a.o0.q0.b.b;
/* loaded from: classes4.dex */
public class ForumSearchActivity extends BaseActivity {
    public b mController;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b bVar = new b(getPageContext());
        this.mController = bVar;
        setContentView(bVar.o().f62081b);
        Intent intent = getIntent();
        if (intent != null) {
            this.mController.w(intent.getIntExtra(SelectForumActivityConfig.EXTRA_KEY_FROM, 0));
            this.mController.x(intent.getLongExtra("extra_key_live_id", 0L));
            this.mController.H(intent.getStringExtra("extra_key_yy_anchor_bduid"));
            this.mController.B((OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_ORIGINAL_THREAD));
            this.mController.u((BaijiahaoData) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_BAIJIAHAO_DATA));
            this.mController.F(intent.getStringExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_ORIGIN_THREAD_CONTENT));
            this.mController.G(intent.getStringExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_THREAD_AUTHOR_NAME_SHOW));
            this.mController.y(intent.getStringExtra("more_forum_img"));
            this.mController.A(intent.getStringExtra("more_forum_url"));
            this.mController.z(intent.getStringExtra("more_forum_title"));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mController.t();
    }
}
