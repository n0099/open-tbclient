package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract void initView();

    protected abstract boolean p(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.d
    public void asQ() {
        ass();
    }

    public void ass() {
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!p(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.e.common_color_10022, false);
        if (this.dnG != null) {
            this.dnG.setImageUploadUIProgressCallback(this.dnM);
        }
        asW();
        if (a((d) this)) {
            loadDraft();
            asq();
            j.dnE = com.baidu.tbadk.util.h.GA();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.dnG != null) {
            this.dnG.onDestroy();
        }
        setIntent(intent);
        if (!p(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.e.common_color_10022, false);
        asW();
        if (a((d) this)) {
            loadDraft();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dnF != null) {
            this.dnF.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dnF != null) {
            this.dnF.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            asn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asn() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.dnF.showReceiver();
        } else {
            this.dnF.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.dnG.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        asr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asq() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asr() {
    }
}
