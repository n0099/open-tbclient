package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean T(Bundle bundle);

    protected abstract boolean a(d dVar);

    protected abstract void initView();

    @Override // com.baidu.tieba.im.chat.d
    public void bqc() {
        bpE();
    }

    public void bpE() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!T(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0277d.common_color_10022, false);
        if (this.gcw != null) {
            this.gcw.setImageUploadUIProgressCallback(this.gcB);
        }
        bqi();
        if (a((d) this)) {
            loadDraft();
            bpC();
            j.gcu = l.apW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gcw != null) {
            this.gcw.onDestroy();
        }
        setIntent(intent);
        if (!T(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0277d.common_color_10022, false);
        bqi();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gcv != null) {
            this.gcv.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gcv != null) {
            this.gcv.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            bpz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bpz() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.gcv.showReceiver();
        } else {
            this.gcv.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.gcw.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bpD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bpC() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bpD() {
    }
}
