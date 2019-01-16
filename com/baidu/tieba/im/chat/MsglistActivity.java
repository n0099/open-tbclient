package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract void initView();

    protected abstract boolean v(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.d
    public void aPx() {
        aOZ();
    }

    public void aOZ() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!v(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(e.d.common_color_10022, false);
        if (this.eMu != null) {
            this.eMu.setImageUploadUIProgressCallback(this.eMz);
        }
        aPD();
        if (a((d) this)) {
            loadDraft();
            aOX();
            j.eMs = com.baidu.tbadk.util.i.Qj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.eMu != null) {
            this.eMu.onDestroy();
        }
        setIntent(intent);
        if (!v(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(e.d.common_color_10022, false);
        aPD();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eMt != null) {
            this.eMt.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.eMt != null) {
            this.eMt.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            aOU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aOU() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.eMt.showReceiver();
        } else {
            this.eMt.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.eMu.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aOY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aOX() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aOY() {
    }
}
