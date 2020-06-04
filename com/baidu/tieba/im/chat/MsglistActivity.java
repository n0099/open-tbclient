package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract boolean as(Bundle bundle);

    protected abstract void initView();

    @Override // com.baidu.tieba.im.chat.d
    public void cjG() {
        cjh();
    }

    public void cjh() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!as(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        if (this.iuq != null) {
            this.iuq.setImageUploadUIProgressCallback(this.iuv);
        }
        bvu();
        if (a((d) this)) {
            loadDraft();
            cjf();
            j.iuo = m.bgw();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.iuq != null) {
            this.iuq.onDestroy();
        }
        setIntent(intent);
        if (!as(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bvu();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iup != null) {
            this.iup.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iup != null) {
            this.iup.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            cjc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cjc() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.iup.showReceiver();
        } else {
            this.iup.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.iuq.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cjg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cjf() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cjg() {
    }
}
