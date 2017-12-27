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
    public void aEm() {
        aDO();
    }

    public void aDO() {
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!p(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0108d.common_color_10022, false);
        if (this.eqO != null) {
            this.eqO.setImageUploadUIProgressCallback(this.eqT);
        }
        aEs();
        if (a((d) this)) {
            loadDraft();
            aDM();
            j.eqM = com.baidu.tbadk.util.i.OE();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.eqO != null) {
            this.eqO.onDestroy();
        }
        setIntent(intent);
        if (!p(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0108d.common_color_10022, false);
        aEs();
        if (a((d) this)) {
            loadDraft();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eqN != null) {
            this.eqN.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.eqN != null) {
            this.eqN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            aDJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aDJ() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.eqN.showReceiver();
        } else {
            this.eqN.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.eqO.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aDN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aDM() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aDN() {
    }
}
