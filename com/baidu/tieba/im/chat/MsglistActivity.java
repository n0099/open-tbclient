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
    public void avC() {
        ave();
    }

    public void ave() {
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
        if (this.dvQ != null) {
            this.dvQ.setImageUploadUIProgressCallback(this.dvW);
        }
        avI();
        if (a((d) this)) {
            loadDraft();
            avc();
            j.dvO = com.baidu.tbadk.util.i.GX();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.dvQ != null) {
            this.dvQ.onDestroy();
        }
        setIntent(intent);
        if (!o(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0080d.common_color_10022, false);
        avI();
        if (a((d) this)) {
            loadDraft();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dvP != null) {
            this.dvP.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dvP != null) {
            this.dvP.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            auZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void auZ() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.dvP.showReceiver();
        } else {
            this.dvP.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.dvQ.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        avd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void avc() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void avd() {
    }
}
