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
        if (this.iRD != null) {
            this.iRD.setImageUploadUIProgressCallback(this.iRI);
        }
        bBE();
        if (a((d) this)) {
            loadDraft();
            cqv();
            j.iRB = m.bmD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.iRD != null) {
            this.iRD.onDestroy();
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
        if (this.iRC != null) {
            this.iRC.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iRC != null) {
            this.iRC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            cqs();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cqs() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.iRC.showReceiver();
        } else {
            this.iRC.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.iRD.loadDraft();
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
