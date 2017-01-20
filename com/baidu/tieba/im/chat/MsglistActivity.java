package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements ak {
    protected abstract boolean a(ak akVar);

    protected abstract void initView();

    protected abstract boolean l(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.ak
    public void aoe() {
        anG();
    }

    public void anG() {
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!l(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(r.e.common_color_10022, false);
        if (this.cNI != null) {
            this.cNI.setImageUploadUIProgressCallback(this.cNO);
        }
        aok();
        if (a((ak) this)) {
            loadDraft();
            anE();
            bq.cNG = com.baidu.tbadk.util.g.Gl();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.cNI != null) {
            this.cNI.onDestroy();
        }
        setIntent(intent);
        if (!l(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(r.e.common_color_10022, false);
        aok();
        if (a((ak) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cNH != null) {
            this.cNH.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cNH != null) {
            this.cNH.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            anB();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anB() {
        if (TbadkCoreApplication.m9getInst().isHeadsetModeOn()) {
            this.cNH.showReceiver();
        } else {
            this.cNH.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.cNI.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        anF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anE() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anF() {
    }
}
