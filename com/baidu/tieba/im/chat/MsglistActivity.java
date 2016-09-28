package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements al {
    protected abstract boolean a(al alVar);

    protected abstract void initView();

    protected abstract boolean k(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.al
    public void aqy() {
        apY();
    }

    public void apY() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!k(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(r.d.common_color_10022, false);
        if (this.cVF != null) {
            this.cVF.setImageUploadUIProgressCallback(this.cVL);
        }
        aqF();
        if (a((al) this)) {
            loadDraft();
            apW();
            br.cVD = com.baidu.tbadk.util.h.GU();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.cVF != null) {
            this.cVF.onDestroy();
        }
        setIntent(intent);
        if (!k(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(r.d.common_color_10022, false);
        aqF();
        if (a((al) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cVE != null) {
            this.cVE.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cVE != null) {
            this.cVE.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            apT();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apT() {
        if (TbadkCoreApplication.m9getInst().isHeadsetModeOn()) {
            this.cVE.showReceiver();
        } else {
            this.cVE.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.cVF.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        apX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apW() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apX() {
    }
}
