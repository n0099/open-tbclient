package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.n;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract boolean at(Bundle bundle);

    protected abstract void initView();

    @Override // com.baidu.tieba.im.chat.d
    public void cON() {
        cOo();
    }

    public void cOo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!at(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        if (this.jWF != null) {
            this.jWF.setImageUploadUIProgressCallback(this.jWK);
        }
        bTX();
        if (a((d) this)) {
            loadDraft();
            cOm();
            j.jWD = n.bDC();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.jWF != null) {
            this.jWF.onDestroy();
        }
        setIntent(intent);
        if (!at(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bTX();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jWE != null) {
            this.jWE.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jWE != null) {
            this.jWE.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            cOj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cOj() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.jWE.showReceiver();
        } else {
            this.jWE.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.jWF.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cOn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cOm() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cOn() {
    }
}
