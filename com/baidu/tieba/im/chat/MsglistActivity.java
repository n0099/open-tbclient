package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract boolean am(Bundle bundle);

    protected abstract void initView();

    @Override // com.baidu.tieba.im.chat.d
    public void bQF() {
        bQg();
    }

    public void bQg() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!am(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        if (this.hro != null) {
            this.hro.setImageUploadUIProgressCallback(this.hrt);
        }
        bdU();
        if (a((d) this)) {
            loadDraft();
            bQe();
            j.hrm = m.aPG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.hro != null) {
            this.hro.onDestroy();
        }
        setIntent(intent);
        if (!am(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bdU();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hrn != null) {
            this.hrn.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hrn != null) {
            this.hrn.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            bQb();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bQb() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.hrn.showReceiver();
        } else {
            this.hrn.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.hro.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bQf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bQe() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bQf() {
    }
}
