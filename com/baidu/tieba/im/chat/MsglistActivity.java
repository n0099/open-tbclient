package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract void initView();

    protected abstract boolean p(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.d
    public void aEr() {
        aDT();
    }

    public void aDT() {
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!p(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0107d.common_color_10022, false);
        if (this.esm != null) {
            this.esm.setImageUploadUIProgressCallback(this.esr);
        }
        aEx();
        if (a((d) this)) {
            loadDraft();
            aDR();
            j.esk = com.baidu.tbadk.util.i.Os();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.esm != null) {
            this.esm.onDestroy();
        }
        setIntent(intent);
        if (!p(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0107d.common_color_10022, false);
        aEx();
        if (a((d) this)) {
            loadDraft();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.esl != null) {
            this.esl.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.esl != null) {
            this.esl.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            aDO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aDO() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.esl.showReceiver();
        } else {
            this.esl.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.esm.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aDS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aDR() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aDS() {
    }
}
