package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract void initView();

    protected abstract boolean n(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.d
    public void aAO() {
        aAq();
    }

    public void aAq() {
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
        adjustResizeForSoftInput(d.C0126d.common_color_10022, false);
        if (this.dSF != null) {
            this.dSF.setImageUploadUIProgressCallback(this.dSK);
        }
        aAU();
        if (a((d) this)) {
            loadDraft();
            aAo();
            j.dSD = com.baidu.tbadk.util.i.HA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.dSF != null) {
            this.dSF.onDestroy();
        }
        setIntent(intent);
        if (!n(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0126d.common_color_10022, false);
        aAU();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dSE != null) {
            this.dSE.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dSE != null) {
            this.dSE.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            aAl();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aAl() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.dSE.showReceiver();
        } else {
            this.dSE.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.dSF.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aAp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aAo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aAp() {
    }
}
