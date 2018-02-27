package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract void initView();

    protected abstract boolean q(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.d
    public void aFP() {
        aFr();
    }

    public void aFr() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!q(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0141d.common_color_10022, false);
        if (this.ewF != null) {
            this.ewF.setImageUploadUIProgressCallback(this.ewK);
        }
        aFV();
        if (a((d) this)) {
            loadDraft();
            aFp();
            j.ewD = com.baidu.tbadk.util.i.OY();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.ewF != null) {
            this.ewF.onDestroy();
        }
        setIntent(intent);
        if (!q(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0141d.common_color_10022, false);
        aFV();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ewE != null) {
            this.ewE.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.ewE != null) {
            this.ewE.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            aFm();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aFm() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.ewE.showReceiver();
        } else {
            this.ewE.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.ewF.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aFq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aFp() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aFq() {
    }
}
