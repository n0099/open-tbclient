package com.baidu.tieba.forumsearch.controller;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
/* loaded from: classes3.dex */
public class ForumSearchActivity extends BaseActivity {
    b dzP;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dzP = new b(getPageContext());
        setContentView(this.dzP.axW().ajk);
        Intent intent = getIntent();
        if (intent != null) {
            this.dzP.setFrom(intent.getIntExtra(SelectForumActivityConfig.EXTRA_KEY_FROM, 0));
            this.dzP.setLiveId(intent.getLongExtra("extra_key_live_id", 0L));
            this.dzP.setOriginalThread((OriginalThreadInfo) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_ORIGINAL_THREAD));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dzP.onDestory();
    }
}
