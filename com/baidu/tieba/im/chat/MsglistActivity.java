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
    public void cUI() {
        cUD();
    }

    public void cUD() {
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
        if (this.kBt != null) {
            this.kBt.setImageUploadUIProgressCallback(this.kBy);
        }
        bWA();
        if (a((c) this)) {
            loadDraft();
            cUB();
            h.kBr = n.bFr();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.kBt != null) {
            this.kBt.onDestroy();
        }
        setIntent(intent);
        if (!au(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bWA();
        if (a((c) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kBs != null) {
            this.kBs.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kBs != null) {
            this.kBs.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            cUz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cUz() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.kBs.showReceiver();
        } else {
            this.kBs.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.kBt.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cUC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cUB() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cUC() {
    }
}
