package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements ak {
    protected abstract boolean a(ak akVar);

    protected abstract void initView();

    protected abstract boolean l(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.ak
    public void ans() {
        amU();
    }

    public void amU() {
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!l(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(w.e.common_color_10022, false);
        if (this.cOu != null) {
            this.cOu.setImageUploadUIProgressCallback(this.cOA);
        }
        any();
        if (a((ak) this)) {
            loadDraft();
            amS();
            bq.cOs = com.baidu.tbadk.util.g.Hj();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.cOu != null) {
            this.cOu.onDestroy();
        }
        setIntent(intent);
        if (!l(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(w.e.common_color_10022, false);
        any();
        if (a((ak) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cOt != null) {
            this.cOt.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cOt != null) {
            this.cOt.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            amP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void amP() {
        if (TbadkCoreApplication.m9getInst().isHeadsetModeOn()) {
            this.cOt.showReceiver();
        } else {
            this.cOt.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.cOu.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        amT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void amS() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void amT() {
    }
}
