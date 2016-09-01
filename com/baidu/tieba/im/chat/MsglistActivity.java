package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements al {
    protected abstract boolean a(al alVar);

    protected abstract void initView();

    protected abstract boolean k(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.al
    public void apZ() {
        apz();
    }

    public void apz() {
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
        adjustResizeForSoftInput(t.d.common_color_10022, false);
        if (this.cUl != null) {
            this.cUl.setImageUploadUIProgressCallback(this.cUr);
        }
        aqg();
        if (a((al) this)) {
            loadDraft();
            apx();
            br.cUj = com.baidu.tbadk.util.h.GV();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.cUl != null) {
            this.cUl.onDestroy();
        }
        setIntent(intent);
        if (!k(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(t.d.common_color_10022, false);
        aqg();
        if (a((al) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cUk != null) {
            this.cUk.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cUk != null) {
            this.cUk.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            apu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apu() {
        if (TbadkCoreApplication.m9getInst().isHeadsetModeOn()) {
            this.cUk.showReceiver();
        } else {
            this.cUk.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.cUl.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        apy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apx() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apy() {
    }
}
