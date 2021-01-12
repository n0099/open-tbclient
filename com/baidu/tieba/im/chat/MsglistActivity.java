package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements c {
    protected abstract boolean a(c cVar);

    protected abstract boolean au(Bundle bundle);

    protected abstract void initView();

    @Override // com.baidu.tieba.im.chat.c
    public void cSD() {
        cSy();
    }

    public void cSy() {
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
        if (this.ksY != null) {
            this.ksY.setImageUploadUIProgressCallback(this.ktd);
        }
        bVP();
        if (a((c) this)) {
            loadDraft();
            cSw();
            h.ksW = m.bEY();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.ksY != null) {
            this.ksY.onDestroy();
        }
        setIntent(intent);
        if (!au(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bVP();
        if (a((c) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ksX != null) {
            this.ksX.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.ksX != null) {
            this.ksX.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            cSt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cSt() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.ksX.showReceiver();
        } else {
            this.ksX.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.ksY.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cSx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cSw() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cSx() {
    }
}
