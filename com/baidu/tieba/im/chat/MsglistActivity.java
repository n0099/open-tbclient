package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract void initView();

    protected abstract boolean v(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.d
    public void aOk() {
        aNM();
    }

    public void aNM() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!v(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(e.d.common_color_10022, false);
        if (this.eIR != null) {
            this.eIR.setImageUploadUIProgressCallback(this.eIW);
        }
        aOq();
        if (a((d) this)) {
            loadDraft();
            aNK();
            j.eIP = com.baidu.tbadk.util.i.PP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.eIR != null) {
            this.eIR.onDestroy();
        }
        setIntent(intent);
        if (!v(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(e.d.common_color_10022, false);
        aOq();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eIQ != null) {
            this.eIQ.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.eIQ != null) {
            this.eIQ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            aNH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aNH() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.eIQ.showReceiver();
        } else {
            this.eIQ.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.eIR.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aNL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aNK() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aNL() {
    }
}
