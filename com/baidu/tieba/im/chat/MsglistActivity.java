package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public abstract class MsglistActivity extends TalkableActivity implements bt {
    protected abstract boolean a(bt btVar);

    protected abstract boolean h(Bundle bundle);

    protected abstract void nu();

    @Override // com.baidu.tieba.im.chat.bt
    public void JU() {
        Ju();
    }

    public void Ju() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!h(bundle)) {
            finish();
            return;
        }
        nu();
        if (this.aPQ != null) {
            this.aPQ.setImageUploadUIProgressCallback(this.aPW);
        }
        Kc();
        if (a((bt) this)) {
            loadDraft();
            nY();
            dm.aPO = com.baidu.tbadk.util.e.uZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (!h(null)) {
            finish();
            return;
        }
        nu();
        Kc();
        if (a((bt) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aPP != null) {
            this.aPP.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.aPP != null) {
            this.aPP.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
            Jq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Jq() {
        if (TbadkApplication.m251getInst().isHeadsetModeOn()) {
            this.aPP.showReceiver();
        } else {
            this.aPP.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.aPQ.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Jt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nY() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Jt() {
    }
}
