package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract boolean at(Bundle bundle);

    protected abstract void initView();

    @Override // com.baidu.tieba.im.chat.d
    public void cnw() {
        cmX();
    }

    public void cmX() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!at(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        if (this.iLw != null) {
            this.iLw.setImageUploadUIProgressCallback(this.iLB);
        }
        byq();
        if (a((d) this)) {
            loadDraft();
            cmV();
            j.iLu = m.biK();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.iLw != null) {
            this.iLw.onDestroy();
        }
        setIntent(intent);
        if (!at(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        byq();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iLv != null) {
            this.iLv.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iLv != null) {
            this.iLv.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            cmS();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cmS() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.iLv.showReceiver();
        } else {
            this.iLv.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.iLw.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cmW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cmV() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cmW() {
    }
}
