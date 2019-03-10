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
    public void bqd() {
        bpF();
    }

    public void bpF() {
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!T(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0236d.common_color_10022, false);
        if (this.gcx != null) {
            this.gcx.setImageUploadUIProgressCallback(this.gcC);
        }
        bqj();
        if (a((d) this)) {
            loadDraft();
            bpD();
            j.gcv = l.apX();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gcx != null) {
            this.gcx.onDestroy();
        }
        setIntent(intent);
        if (!T(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0236d.common_color_10022, false);
        bqj();
        if (a((d) this)) {
            loadDraft();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gcw != null) {
            this.gcw.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gcw != null) {
            this.gcw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            bpA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bpA() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.gcw.showReceiver();
        } else {
            this.gcw.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.gcx.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bpE();
    }

    protected void bpD() {
    }

    protected void bpE() {
    }
}
