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
    public void bpZ() {
        bpB();
    }

    public void bpB() {
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
        if (this.gck != null) {
            this.gck.setImageUploadUIProgressCallback(this.gcp);
        }
        bqf();
        if (a((d) this)) {
            loadDraft();
            bpz();
            j.gci = l.apT();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gck != null) {
            this.gck.onDestroy();
        }
        setIntent(intent);
        if (!T(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0277d.common_color_10022, false);
        bqf();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gcj != null) {
            this.gcj.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gcj != null) {
            this.gcj.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            bpw();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bpw() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.gcj.showReceiver();
        } else {
            this.gcj.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.gck.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bpA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bpz() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bpA() {
    }
}
