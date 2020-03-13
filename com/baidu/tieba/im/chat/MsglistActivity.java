package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract boolean am(Bundle bundle);

    protected abstract void initView();

    @Override // com.baidu.tieba.im.chat.d
    public void bSj() {
        bRK();
    }

    public void bRK() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!am(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        if (this.htB != null) {
            this.htB.setImageUploadUIProgressCallback(this.htG);
        }
        bgh();
        if (a((d) this)) {
            loadDraft();
            bRI();
            j.htz = m.aSa();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.htB != null) {
            this.htB.onDestroy();
        }
        setIntent(intent);
        if (!am(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bgh();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.htA != null) {
            this.htA.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.htA != null) {
            this.htA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            bRF();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bRF() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.htA.showReceiver();
        } else {
            this.htA.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.htB.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bRJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bRI() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bRJ() {
    }
}
