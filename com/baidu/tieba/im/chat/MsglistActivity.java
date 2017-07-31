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
    public void arP() {
        arr();
    }

    public void arr() {
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!n(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.e.common_color_10022, false);
        if (this.dih != null) {
            this.dih.setImageUploadUIProgressCallback(this.din);
        }
        arV();
        if (a((d) this)) {
            loadDraft();
            arp();
            j.dif = com.baidu.tbadk.util.i.Hd();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.dih != null) {
            this.dih.onDestroy();
        }
        setIntent(intent);
        if (!n(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.e.common_color_10022, false);
        arV();
        if (a((d) this)) {
            loadDraft();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dig != null) {
            this.dig.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dig != null) {
            this.dig.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            arm();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void arm() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.dig.showReceiver();
        } else {
            this.dig.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.dih.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        arq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void arp() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void arq() {
    }
}
