package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract void initView();

    protected abstract boolean s(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.d
    public void aMs() {
        aLU();
    }

    public void aLU() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!s(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(e.d.common_color_10022, false);
        if (this.eCc != null) {
            this.eCc.setImageUploadUIProgressCallback(this.eCh);
        }
        aMy();
        if (a((d) this)) {
            loadDraft();
            aLS();
            j.eCa = com.baidu.tbadk.util.i.OJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.eCc != null) {
            this.eCc.onDestroy();
        }
        setIntent(intent);
        if (!s(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(e.d.common_color_10022, false);
        aMy();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eCb != null) {
            this.eCb.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.eCb != null) {
            this.eCb.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            aLP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aLP() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.eCb.showReceiver();
        } else {
            this.eCb.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.eCc.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aLT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aLS() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aLT() {
    }
}
