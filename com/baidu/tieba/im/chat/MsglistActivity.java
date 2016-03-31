package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements al {
    protected abstract boolean a(al alVar);

    protected abstract void initView();

    protected abstract boolean l(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.al
    public void acm() {
        abM();
    }

    public void abM() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!l(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(t.d.transparent, false);
        if (this.cac != null) {
            this.cac.setImageUploadUIProgressCallback(this.cai);
        }
        act();
        if (a((al) this)) {
            loadDraft();
            KL();
            bq.caa = com.baidu.tbadk.util.h.Hs();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.cac != null) {
            this.cac.onDestroy();
        }
        setIntent(intent);
        if (!l(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(t.d.transparent, false);
        act();
        if (a((al) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cab != null) {
            this.cab.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cab != null) {
            this.cab.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
            abI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abI() {
        if (TbadkCoreApplication.m411getInst().isHeadsetModeOn()) {
            this.cab.showReceiver();
        } else {
            this.cab.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.cac.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        abL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void KL() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abL() {
    }
}
