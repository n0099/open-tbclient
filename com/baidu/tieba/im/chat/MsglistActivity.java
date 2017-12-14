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
    public void axl() {
        awN();
    }

    public void awN() {
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!o(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0096d.common_color_10022, false);
        if (this.dEH != null) {
            this.dEH.setImageUploadUIProgressCallback(this.dEN);
        }
        axr();
        if (a((d) this)) {
            loadDraft();
            awL();
            j.dEF = com.baidu.tbadk.util.i.Hf();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.dEH != null) {
            this.dEH.onDestroy();
        }
        setIntent(intent);
        if (!o(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0096d.common_color_10022, false);
        axr();
        if (a((d) this)) {
            loadDraft();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dEG != null) {
            this.dEG.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dEG != null) {
            this.dEG.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            awI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void awI() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.dEG.showReceiver();
        } else {
            this.dEG.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.dEH.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        awM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void awL() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void awM() {
    }
}
