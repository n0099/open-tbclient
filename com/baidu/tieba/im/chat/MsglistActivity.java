package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements al {
    protected abstract boolean a(al alVar);

    protected abstract void initView();

    protected abstract boolean n(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.al
    public void akA() {
        aka();
    }

    public void aka() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!n(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(u.d.common_color_10022, false);
        if (this.cFR != null) {
            this.cFR.setImageUploadUIProgressCallback(this.cFX);
        }
        akH();
        if (a((al) this)) {
            loadDraft();
            ajY();
            br.cFP = com.baidu.tbadk.util.h.FA();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.cFR != null) {
            this.cFR.onDestroy();
        }
        setIntent(intent);
        if (!n(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(u.d.common_color_10022, false);
        akH();
        if (a((al) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cFQ != null) {
            this.cFQ.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cFQ != null) {
            this.cFQ.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            ajV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajV() {
        if (TbadkCoreApplication.m9getInst().isHeadsetModeOn()) {
            this.cFQ.showReceiver();
        } else {
            this.cFQ.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.cFR.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ajZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajY() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajZ() {
    }
}
