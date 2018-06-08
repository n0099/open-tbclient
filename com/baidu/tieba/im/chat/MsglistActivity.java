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
    public void aFJ() {
        aFl();
    }

    public void aFl() {
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
        adjustResizeForSoftInput(d.C0141d.common_color_10022, false);
        if (this.edS != null) {
            this.edS.setImageUploadUIProgressCallback(this.edX);
        }
        aFP();
        if (a((d) this)) {
            loadDraft();
            aFj();
            j.edQ = com.baidu.tbadk.util.i.KU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.edS != null) {
            this.edS.onDestroy();
        }
        setIntent(intent);
        if (!o(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0141d.common_color_10022, false);
        aFP();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.edR != null) {
            this.edR.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.edR != null) {
            this.edR.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            aFg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aFg() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.edR.showReceiver();
        } else {
            this.edR.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.edS.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aFk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aFj() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aFk() {
    }
}
