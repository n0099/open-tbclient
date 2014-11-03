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
    public void JY() {
        Jy();
    }

    public void Jy() {
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
        if (this.aQe != null) {
            this.aQe.setImageUploadUIProgressCallback(this.aQk);
        }
        Kg();
        if (a((bt) this)) {
            loadDraft();
            nY();
            dm.aQc = com.baidu.tbadk.util.e.vb();
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
        Kg();
        if (a((bt) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aQd != null) {
            this.aQd.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.aQd != null) {
            this.aQd.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
            Ju();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ju() {
        if (TbadkApplication.m251getInst().isHeadsetModeOn()) {
            this.aQd.showReceiver();
        } else {
            this.aQd.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.aQe.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Jx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nY() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Jx() {
    }
}
