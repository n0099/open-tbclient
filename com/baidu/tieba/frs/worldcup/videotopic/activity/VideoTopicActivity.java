package com.baidu.tieba.frs.worldcup.videotopic.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class VideoTopicActivity extends BaseFragmentActivity {
    private VideoTopicFragment ede;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.ede == null) {
            this.ede = new VideoTopicFragment();
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.ede.setArguments(extras);
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (!supportFragmentManager.isDestroyed()) {
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            beginTransaction.add(16908290, this.ede);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.ede.onChangeSkinType(i);
    }
}
