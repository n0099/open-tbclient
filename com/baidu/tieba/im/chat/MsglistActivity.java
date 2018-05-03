package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract void initView();

    protected abstract boolean n(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.d
    public void aAQ() {
        aAs();
    }

    public void aAs() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!n(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0126d.common_color_10022, false);
        if (this.dRy != null) {
            this.dRy.setImageUploadUIProgressCallback(this.dRD);
        }
        aAW();
        if (a((d) this)) {
            loadDraft();
            aAq();
            j.dRw = com.baidu.tbadk.util.i.HC();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.dRy != null) {
            this.dRy.onDestroy();
        }
        setIntent(intent);
        if (!n(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0126d.common_color_10022, false);
        aAW();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dRx != null) {
            this.dRx.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dRx != null) {
            this.dRx.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            aAn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aAn() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.dRx.showReceiver();
        } else {
            this.dRx.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.dRy.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aAr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aAq() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aAr() {
    }
}
