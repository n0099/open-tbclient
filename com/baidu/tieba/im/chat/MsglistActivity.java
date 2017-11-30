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
    public void axc() {
        awE();
    }

    public void awE() {
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!o(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0082d.common_color_10022, false);
        if (this.dDD != null) {
            this.dDD.setImageUploadUIProgressCallback(this.dDJ);
        }
        axi();
        if (a((d) this)) {
            loadDraft();
            awC();
            j.dDB = com.baidu.tbadk.util.i.He();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.dDD != null) {
            this.dDD.onDestroy();
        }
        setIntent(intent);
        if (!o(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0082d.common_color_10022, false);
        axi();
        if (a((d) this)) {
            loadDraft();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dDC != null) {
            this.dDC.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dDC != null) {
            this.dDC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            awz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void awz() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.dDC.showReceiver();
        } else {
            this.dDC.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.dDD.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        awD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void awC() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void awD() {
    }
}
