package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements al {
    protected abstract boolean a(al alVar);

    protected abstract void initView();

    protected abstract boolean j(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.al
    public void YT() {
        Yt();
    }

    public void Yt() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!j(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(t.d.transparent, false);
        if (this.bPK != null) {
            this.bPK.setImageUploadUIProgressCallback(this.bPQ);
        }
        Za();
        if (a((al) this)) {
            loadDraft();
            Jq();
            bq.bPI = com.baidu.tbadk.util.e.Gw();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.bPK != null) {
            this.bPK.onDestroy();
        }
        setIntent(intent);
        if (!j(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(t.d.transparent, false);
        Za();
        if (a((al) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bPJ != null) {
            this.bPJ.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bPJ != null) {
            this.bPJ.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
            Yp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Yp() {
        if (TbadkCoreApplication.m411getInst().isHeadsetModeOn()) {
            this.bPJ.showReceiver();
        } else {
            this.bPJ.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.bPK.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Ys();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Jq() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ys() {
    }
}
