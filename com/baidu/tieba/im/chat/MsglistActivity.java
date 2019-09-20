package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean U(Bundle bundle);

    protected abstract boolean a(d dVar);

    protected abstract void initView();

    @Override // com.baidu.tieba.im.chat.d
    public void bBv() {
        bAX();
    }

    public void bAX() {
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
        if (this.gCx != null) {
            this.gCx.setImageUploadUIProgressCallback(this.gCC);
        }
        bBB();
        if (a((d) this)) {
            loadDraft();
            bAV();
            j.gCv = k.awu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gCx != null) {
            this.gCx.onDestroy();
        }
        setIntent(intent);
        if (!U(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bBB();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gCw != null) {
            this.gCw.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gCw != null) {
            this.gCw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            bAS();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bAS() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.gCw.showReceiver();
        } else {
            this.gCw.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.gCx.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bAW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bAV() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bAW() {
    }
}
