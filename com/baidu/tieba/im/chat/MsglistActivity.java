package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.n;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements c {
    protected abstract boolean a(c cVar);

    protected abstract boolean au(Bundle bundle);

    protected abstract void initView();

    @Override // com.baidu.tieba.im.chat.c
    public void cUP() {
        cUK();
    }

    public void cUK() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!au(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        if (this.kDv != null) {
            this.kDv.setImageUploadUIProgressCallback(this.kDA);
        }
        bWG();
        if (a((c) this)) {
            loadDraft();
            cUI();
            h.kDt = n.bFv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.kDv != null) {
            this.kDv.onDestroy();
        }
        setIntent(intent);
        if (!au(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bWG();
        if (a((c) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kDu != null) {
            this.kDu.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kDu != null) {
            this.kDu.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            cUG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cUG() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.kDu.showReceiver();
        } else {
            this.kDu.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.kDv.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cUJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cUI() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cUJ() {
    }
}
