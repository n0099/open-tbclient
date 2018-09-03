package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract void initView();

    protected abstract boolean o(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.d
    public void aHo() {
        aGQ();
    }

    public void aGQ() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!o(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(f.d.common_color_10022, false);
        if (this.ely != null) {
            this.ely.setImageUploadUIProgressCallback(this.elD);
        }
        aHu();
        if (a((d) this)) {
            loadDraft();
            aGO();
            j.elw = com.baidu.tbadk.util.h.Ll();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.ely != null) {
            this.ely.onDestroy();
        }
        setIntent(intent);
        if (!o(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(f.d.common_color_10022, false);
        aHu();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.elx != null) {
            this.elx.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.elx != null) {
            this.elx.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            aGL();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aGL() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.elx.showReceiver();
        } else {
            this.elx.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.ely.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aGP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aGO() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aGP() {
    }
}
