package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract boolean au(Bundle bundle);

    protected abstract void initView();

    @Override // com.baidu.tieba.im.chat.d
    public void cqW() {
        cqx();
    }

    public void cqx() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!au(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        if (this.iRB != null) {
            this.iRB.setImageUploadUIProgressCallback(this.iRG);
        }
        bBE();
        if (a((d) this)) {
            loadDraft();
            cqv();
            j.iRz = m.bmD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.iRB != null) {
            this.iRB.onDestroy();
        }
        setIntent(intent);
        if (!au(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bBE();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iRA != null) {
            this.iRA.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iRA != null) {
            this.iRA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            cqs();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cqs() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.iRA.showReceiver();
        } else {
            this.iRA.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.iRB.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cqw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cqv() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cqw() {
    }
}
