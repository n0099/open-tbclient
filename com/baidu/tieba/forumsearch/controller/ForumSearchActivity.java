package com.baidu.tieba.forumsearch.controller;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import d.b.i0.p0.b.b;
/* loaded from: classes4.dex */
public class ForumSearchActivity extends BaseActivity {
    public b mController;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b bVar = new b(getPageContext());
        this.mController = bVar;
        setContentView(bVar.o().f58873b);
        Intent intent = getIntent();
        if (intent != null) {
            this.mController.x(intent.getIntExtra(SelectForumActivityConfig.EXTRA_KEY_FROM, 0));
            this.mController.y(intent.getLongExtra("extra_key_live_id", 0L));
            this.mController.E((OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_ORIGINAL_THREAD));
            this.mController.v((BaijiahaoData) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_BAIJIAHAO_DATA));
            this.mController.F(intent.getStringExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_ORIGIN_THREAD_CONTENT));
            this.mController.G(intent.getStringExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_THREAD_AUTHOR_NAME_SHOW));
            this.mController.z(intent.getStringExtra("more_forum_img"));
            this.mController.B(intent.getStringExtra("more_forum_url"));
            this.mController.A(intent.getStringExtra("more_forum_title"));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mController.u();
    }
}
