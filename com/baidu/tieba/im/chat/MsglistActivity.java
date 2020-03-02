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
    public void bSi() {
        bRJ();
    }

    public void bRJ() {
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
        if (this.htp != null) {
            this.htp.setImageUploadUIProgressCallback(this.htu);
        }
        bgg();
        if (a((d) this)) {
            loadDraft();
            bRH();
            j.htn = m.aRZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.htp != null) {
            this.htp.onDestroy();
        }
        setIntent(intent);
        if (!am(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bgg();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hto != null) {
            this.hto.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hto != null) {
            this.hto.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            bRE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bRE() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.hto.showReceiver();
        } else {
            this.hto.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.htp.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bRI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bRH() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bRI() {
    }
}
