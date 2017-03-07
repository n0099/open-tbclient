package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements ak {
    protected abstract boolean a(ak akVar);

    protected abstract void initView();

    protected abstract boolean k(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.ak
    public void any() {
        ana();
    }

    public void ana() {
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!k(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(w.e.common_color_10022, false);
        if (this.cPX != null) {
            this.cPX.setImageUploadUIProgressCallback(this.cQd);
        }
        anE();
        if (a((ak) this)) {
            loadDraft();
            amY();
            bq.cPV = com.baidu.tbadk.util.g.GK();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.cPX != null) {
            this.cPX.onDestroy();
        }
        setIntent(intent);
        if (!k(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(w.e.common_color_10022, false);
        anE();
        if (a((ak) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cPW != null) {
            this.cPW.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cPW != null) {
            this.cPW.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            amV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void amV() {
        if (TbadkCoreApplication.m9getInst().isHeadsetModeOn()) {
            this.cPW.showReceiver();
        } else {
            this.cPW.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.cPX.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        amZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void amY() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void amZ() {
    }
}
