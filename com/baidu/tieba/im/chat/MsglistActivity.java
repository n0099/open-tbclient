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
    public void aHr() {
        aGT();
    }

    public void aGT() {
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
        adjustResizeForSoftInput(d.C0140d.common_color_10022, false);
        if (this.elC != null) {
            this.elC.setImageUploadUIProgressCallback(this.elH);
        }
        aHx();
        if (a((d) this)) {
            loadDraft();
            aGR();
            j.elA = com.baidu.tbadk.util.h.Lh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.elC != null) {
            this.elC.onDestroy();
        }
        setIntent(intent);
        if (!o(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0140d.common_color_10022, false);
        aHx();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.elB != null) {
            this.elB.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.elB != null) {
            this.elB.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            aGO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aGO() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.elB.showReceiver();
        } else {
            this.elB.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.elC.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aGS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aGR() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aGS() {
    }
}
