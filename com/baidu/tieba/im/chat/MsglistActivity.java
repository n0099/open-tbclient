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
    public void alm() {
        akO();
    }

    public void akO() {
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
        if (this.cKN != null) {
            this.cKN.setImageUploadUIProgressCallback(this.cKT);
        }
        als();
        if (a((ak) this)) {
            loadDraft();
            akM();
            bq.cKL = com.baidu.tbadk.util.h.Gp();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.cKN != null) {
            this.cKN.onDestroy();
        }
        setIntent(intent);
        if (!l(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(w.e.common_color_10022, false);
        als();
        if (a((ak) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cKM != null) {
            this.cKM.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cKM != null) {
            this.cKM.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            akJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akJ() {
        if (TbadkCoreApplication.m9getInst().isHeadsetModeOn()) {
            this.cKM.showReceiver();
        } else {
            this.cKM.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.cKN.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        akN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akM() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akN() {
    }
}
