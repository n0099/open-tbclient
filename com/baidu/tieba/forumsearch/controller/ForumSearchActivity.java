package com.baidu.tieba.forumsearch.controller;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
/* loaded from: classes3.dex */
public class ForumSearchActivity extends BaseActivity {
    b dkE;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dkE = new b(getPageContext());
        setContentView(this.dkE.ato().aaW);
        Intent intent = getIntent();
        if (intent != null) {
            this.dkE.setFrom(intent.getIntExtra(SelectForumActivityConfig.EXTRA_KEY_FROM, 0));
            this.dkE.setLiveId(intent.getLongExtra("extra_key_live_id", 0L));
            this.dkE.setOriginalThread((OriginalThreadInfo) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_ORIGINAL_THREAD));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dkE.onDestory();
    }
}
