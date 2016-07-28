package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements al {
    protected abstract boolean a(al alVar);

    protected abstract void initView();

    protected abstract boolean k(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.al
    public void alk() {
        akK();
    }

    public void akK() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!k(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(u.d.common_color_10022, false);
        if (this.cIG != null) {
            this.cIG.setImageUploadUIProgressCallback(this.cIM);
        }
        alr();
        if (a((al) this)) {
            loadDraft();
            akI();
            br.cIE = com.baidu.tbadk.util.h.FB();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.cIG != null) {
            this.cIG.onDestroy();
        }
        setIntent(intent);
        if (!k(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(u.d.common_color_10022, false);
        alr();
        if (a((al) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cIF != null) {
            this.cIF.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cIF != null) {
            this.cIF.onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
            akF();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akF() {
        if (TbadkCoreApplication.m10getInst().isHeadsetModeOn()) {
            this.cIF.showReceiver();
        } else {
            this.cIF.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.cIG.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        akJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akI() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akJ() {
    }
}
