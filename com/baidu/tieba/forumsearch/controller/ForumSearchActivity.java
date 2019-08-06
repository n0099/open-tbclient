package com.baidu.tieba.forumsearch.controller;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
/* loaded from: classes6.dex */
public class ForumSearchActivity extends BaseActivity {
    b fss;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fss = new b(getPageContext());
        setContentView(this.fss.bkR().mRoot);
        Intent intent = getIntent();
        if (intent != null) {
            this.fss.setFrom(intent.getIntExtra(SelectForumActivityConfig.EXTRA_KEY_FROM, 0));
            this.fss.setLiveId(intent.getLongExtra("extra_key_live_id", 0L));
            this.fss.setOriginalThread((OriginalThreadInfo) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_ORIGINAL_THREAD));
            this.fss.setMoreForumImg(intent.getStringExtra("more_forum_img"));
            this.fss.setMoreForumUrl(intent.getStringExtra("more_forum_url"));
            this.fss.setMoreForumTitle(intent.getStringExtra("more_forum_title"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fss.onDestory();
    }
}
