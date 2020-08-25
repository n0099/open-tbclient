package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract boolean at(Bundle bundle);

    protected abstract void initView();

    @Override // com.baidu.tieba.im.chat.d
    public void cBO() {
        cBp();
    }

    public void cBp() {
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
        if (this.jgA != null) {
            this.jgA.setImageUploadUIProgressCallback(this.jgF);
        }
        bKY();
        if (a((d) this)) {
            loadDraft();
            cBn();
            j.jgy = m.bvq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.jgA != null) {
            this.jgA.onDestroy();
        }
        setIntent(intent);
        if (!at(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bKY();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jgz != null) {
            this.jgz.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jgz != null) {
            this.jgz.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            cBk();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cBk() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.jgz.showReceiver();
        } else {
            this.jgz.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.jgA.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cBo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cBn() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cBo() {
    }
}
