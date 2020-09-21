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
    public void cFw() {
        cEX();
    }

    public void cEX() {
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
        if (this.jpm != null) {
            this.jpm.setImageUploadUIProgressCallback(this.jpr);
        }
        bMj();
        if (a((d) this)) {
            loadDraft();
            cEV();
            j.jpk = n.bwA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.jpm != null) {
            this.jpm.onDestroy();
        }
        setIntent(intent);
        if (!at(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bMj();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jpl != null) {
            this.jpl.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jpl != null) {
            this.jpl.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            cES();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cES() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.jpl.showReceiver();
        } else {
            this.jpl.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.jpm.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cEW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cEV() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cEW() {
    }
}
