package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract void initView();

    protected abstract boolean o(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.d
    public void aGr() {
        aFT();
    }

    public void aFT() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!o(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0142d.common_color_10022, false);
        if (this.ehM != null) {
            this.ehM.setImageUploadUIProgressCallback(this.ehR);
        }
        aGx();
        if (a((d) this)) {
            loadDraft();
            aFR();
            j.ehK = com.baidu.tbadk.util.i.Lm();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.ehM != null) {
            this.ehM.onDestroy();
        }
        setIntent(intent);
        if (!o(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0142d.common_color_10022, false);
        aGx();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ehL != null) {
            this.ehL.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.ehL != null) {
            this.ehL.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            aFO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aFO() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.ehL.showReceiver();
        } else {
            this.ehL.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.ehM.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aFS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aFR() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aFS() {
    }
}
