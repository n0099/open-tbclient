package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean U(Bundle bundle);

    protected abstract boolean a(d dVar);

    protected abstract void initView();

    @Override // com.baidu.tieba.im.chat.d
    public void bAt() {
        bzV();
    }

    public void bzV() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!U(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        if (this.gzO != null) {
            this.gzO.setImageUploadUIProgressCallback(this.gzT);
        }
        bAz();
        if (a((d) this)) {
            loadDraft();
            bzT();
            j.gzM = l.awg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gzO != null) {
            this.gzO.onDestroy();
        }
        setIntent(intent);
        if (!U(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bAz();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gzN != null) {
            this.gzN.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gzN != null) {
            this.gzN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            bzQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bzQ() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.gzN.showReceiver();
        } else {
            this.gzN.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.gzO.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bzU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bzT() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bzU() {
    }
}
