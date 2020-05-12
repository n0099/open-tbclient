package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract boolean am(Bundle bundle);

    protected abstract void initView();

    @Override // com.baidu.tieba.im.chat.d
    public void ccZ() {
        ccA();
    }

    public void ccA() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!am(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        if (this.ieU != null) {
            this.ieU.setImageUploadUIProgressCallback(this.ieZ);
        }
        bpB();
        if (a((d) this)) {
            loadDraft();
            ccy();
            j.ieS = m.bal();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.ieU != null) {
            this.ieU.onDestroy();
        }
        setIntent(intent);
        if (!am(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bpB();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ieT != null) {
            this.ieT.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.ieT != null) {
            this.ieT.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            ccv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ccv() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.ieT.showReceiver();
        } else {
            this.ieT.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.ieU.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ccz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ccy() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ccz() {
    }
}
