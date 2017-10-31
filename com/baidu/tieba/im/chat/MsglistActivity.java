package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract void initView();

    protected abstract boolean o(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.d
    public void avl() {
        auN();
    }

    public void auN() {
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!o(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0080d.common_color_10022, false);
        if (this.dvw != null) {
            this.dvw.setImageUploadUIProgressCallback(this.dvC);
        }
        avr();
        if (a((d) this)) {
            loadDraft();
            auL();
            j.dvu = com.baidu.tbadk.util.i.GM();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.dvw != null) {
            this.dvw.onDestroy();
        }
        setIntent(intent);
        if (!o(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0080d.common_color_10022, false);
        avr();
        if (a((d) this)) {
            loadDraft();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dvv != null) {
            this.dvv.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dvv != null) {
            this.dvv.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            auI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void auI() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.dvv.showReceiver();
        } else {
            this.dvv.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.dvw.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        auM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void auL() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void auM() {
    }
}
