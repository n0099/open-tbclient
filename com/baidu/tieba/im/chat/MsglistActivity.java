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
    public void amW() {
        amx();
    }

    public void amx() {
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!k(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(r.d.common_color_10022, false);
        if (this.cGA != null) {
            this.cGA.setImageUploadUIProgressCallback(this.cGG);
        }
        anc();
        if (a((al) this)) {
            loadDraft();
            amv();
            br.cGy = com.baidu.tbadk.util.g.Gt();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.cGA != null) {
            this.cGA.onDestroy();
        }
        setIntent(intent);
        if (!k(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(r.d.common_color_10022, false);
        anc();
        if (a((al) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cGz != null) {
            this.cGz.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cGz != null) {
            this.cGz.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            ams();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ams() {
        if (TbadkCoreApplication.m9getInst().isHeadsetModeOn()) {
            this.cGz.showReceiver();
        } else {
            this.cGz.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.cGA.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        amw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void amv() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void amw() {
    }
}
