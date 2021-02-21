package com.baidu.tieba.forumsearch.controller;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
/* loaded from: classes8.dex */
public class ForumSearchActivity extends BaseActivity {
    b jeg;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jeg = new b(getPageContext());
        setContentView(this.jeg.cBd().mRoot);
        Intent intent = getIntent();
        if (intent != null) {
            this.jeg.setFrom(intent.getIntExtra(SelectForumActivityConfig.EXTRA_KEY_FROM, 0));
            this.jeg.setLiveId(intent.getLongExtra("extra_key_live_id", 0L));
            this.jeg.setOriginalThread((OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_ORIGINAL_THREAD));
            this.jeg.setBaijiahaoData((BaijiahaoData) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_BAIJIAHAO_DATA));
            this.jeg.setTransmitOriginThreadComment(intent.getStringExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_ORIGIN_THREAD_CONTENT));
            this.jeg.setTransmitThreadAuthorNameShow(intent.getStringExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_THREAD_AUTHOR_NAME_SHOW));
            this.jeg.setMoreForumImg(intent.getStringExtra("more_forum_img"));
            this.jeg.setMoreForumUrl(intent.getStringExtra("more_forum_url"));
            this.jeg.setMoreForumTitle(intent.getStringExtra("more_forum_title"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jeg.onDestory();
    }
}
