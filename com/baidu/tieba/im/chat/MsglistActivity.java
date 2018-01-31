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
    public void aEw() {
        aDY();
    }

    public void aDY() {
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
        if (this.esH != null) {
            this.esH.setImageUploadUIProgressCallback(this.esM);
        }
        aEC();
        if (a((d) this)) {
            loadDraft();
            aDW();
            j.esF = com.baidu.tbadk.util.i.Ou();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.esH != null) {
            this.esH.onDestroy();
        }
        setIntent(intent);
        if (!p(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0108d.common_color_10022, false);
        aEC();
        if (a((d) this)) {
            loadDraft();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.esG != null) {
            this.esG.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.esG != null) {
            this.esG.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            aDT();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aDT() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.esG.showReceiver();
        } else {
            this.esG.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.esH.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aDX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aDW() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aDX() {
    }
}
