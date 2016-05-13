package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements al {
    protected abstract boolean a(al alVar);

    protected abstract void initView();

    protected abstract boolean m(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.al
    public void aco() {
        abO();
    }

    public void abO() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!m(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(t.d.transparent, false);
        if (this.caH != null) {
            this.caH.setImageUploadUIProgressCallback(this.caN);
        }
        acv();
        if (a((al) this)) {
            loadDraft();
            abM();
            bq.caF = com.baidu.tbadk.util.h.Fs();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.caH != null) {
            this.caH.onDestroy();
        }
        setIntent(intent);
        if (!m(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(t.d.transparent, false);
        acv();
        if (a((al) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.caG != null) {
            this.caG.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.caG != null) {
            this.caG.onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
            abJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abJ() {
        if (TbadkCoreApplication.m11getInst().isHeadsetModeOn()) {
            this.caG.showReceiver();
        } else {
            this.caG.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.caH.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        abN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abM() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abN() {
    }
}
