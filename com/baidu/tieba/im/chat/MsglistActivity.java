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
    public void cUB() {
        cUw();
    }

    public void cUw() {
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
        if (this.kBf != null) {
            this.kBf.setImageUploadUIProgressCallback(this.kBk);
        }
        bWt();
        if (a((c) this)) {
            loadDraft();
            cUu();
            h.kBd = n.bFr();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.kBf != null) {
            this.kBf.onDestroy();
        }
        setIntent(intent);
        if (!au(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bWt();
        if (a((c) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kBe != null) {
            this.kBe.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kBe != null) {
            this.kBe.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            cUs();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cUs() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.kBe.showReceiver();
        } else {
            this.kBe.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.kBf.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cUv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cUu() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cUv() {
    }
}
