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
    public void cWu() {
        cWp();
    }

    public void cWp() {
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
        if (this.kxD != null) {
            this.kxD.setImageUploadUIProgressCallback(this.kxI);
        }
        bZG();
        if (a((c) this)) {
            loadDraft();
            cWn();
            h.kxB = m.bIP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.kxD != null) {
            this.kxD.onDestroy();
        }
        setIntent(intent);
        if (!au(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bZG();
        if (a((c) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kxC != null) {
            this.kxC.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kxC != null) {
            this.kxC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            cWk();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cWk() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.kxC.showReceiver();
        } else {
            this.kxC.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.kxD.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cWo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cWn() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cWo() {
    }
}
