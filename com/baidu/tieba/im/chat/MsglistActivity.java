package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract void initView();

    protected abstract boolean p(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.d
    public void aMU() {
        aMw();
    }

    public void aMw() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!p(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(e.d.common_color_10022, false);
        if (this.eAJ != null) {
            this.eAJ.setImageUploadUIProgressCallback(this.eAO);
        }
        aNa();
        if (a((d) this)) {
            loadDraft();
            aMu();
            j.eAH = com.baidu.tbadk.util.i.OA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.eAJ != null) {
            this.eAJ.onDestroy();
        }
        setIntent(intent);
        if (!p(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(e.d.common_color_10022, false);
        aNa();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eAI != null) {
            this.eAI.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.eAI != null) {
            this.eAI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            aMr();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aMr() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.eAI.showReceiver();
        } else {
            this.eAI.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.eAJ.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aMv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aMu() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aMv() {
    }
}
