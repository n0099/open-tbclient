package com.baidu.tieba.forumsearch.controller;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
/* loaded from: classes7.dex */
public class ForumSearchActivity extends BaseActivity {
    b iYl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iYl = new b(getPageContext());
        setContentView(this.iYl.czL().mRoot);
        Intent intent = getIntent();
        if (intent != null) {
            this.iYl.setFrom(intent.getIntExtra(SelectForumActivityConfig.EXTRA_KEY_FROM, 0));
            this.iYl.setLiveId(intent.getLongExtra("extra_key_live_id", 0L));
            this.iYl.setOriginalThread((OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_ORIGINAL_THREAD));
            this.iYl.setBaijiahaoData((BaijiahaoData) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_BAIJIAHAO_DATA));
            this.iYl.setTransmitOriginThreadComment(intent.getStringExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_ORIGIN_THREAD_CONTENT));
            this.iYl.setTransmitThreadAuthorNameShow(intent.getStringExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_THREAD_AUTHOR_NAME_SHOW));
            this.iYl.setMoreForumImg(intent.getStringExtra("more_forum_img"));
            this.iYl.setMoreForumUrl(intent.getStringExtra("more_forum_url"));
            this.iYl.setMoreForumTitle(intent.getStringExtra("more_forum_title"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.iYl.onDestory();
    }
}
