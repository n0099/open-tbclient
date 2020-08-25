package com.baidu.tieba.forumsearch.controller;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
/* loaded from: classes18.dex */
public class ForumSearchActivity extends BaseActivity {
    b hQy;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hQy = new b(getPageContext());
        setContentView(this.hQy.ckw().mRoot);
        Intent intent = getIntent();
        if (intent != null) {
            this.hQy.setFrom(intent.getIntExtra(SelectForumActivityConfig.EXTRA_KEY_FROM, 0));
            this.hQy.setLiveId(intent.getLongExtra("extra_key_live_id", 0L));
            this.hQy.setOriginalThread((OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_ORIGINAL_THREAD));
            this.hQy.setBaijiahaoData((BaijiahaoData) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_BAIJIAHAO_DATA));
            this.hQy.setTransmitOriginThreadComment(intent.getStringExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_ORIGIN_THREAD_CONTENT));
            this.hQy.setTransmitThreadAuthorNameShow(intent.getStringExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_THREAD_AUTHOR_NAME_SHOW));
            this.hQy.setMoreForumImg(intent.getStringExtra("more_forum_img"));
            this.hQy.setMoreForumUrl(intent.getStringExtra("more_forum_url"));
            this.hQy.setMoreForumTitle(intent.getStringExtra("more_forum_title"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hQy.onDestory();
    }
}
