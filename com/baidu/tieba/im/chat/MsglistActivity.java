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
    public void aOX() {
        aOz();
    }

    public void aOz() {
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
        if (this.eLI != null) {
            this.eLI.setImageUploadUIProgressCallback(this.eLN);
        }
        aPd();
        if (a((d) this)) {
            loadDraft();
            aOx();
            j.eLG = com.baidu.tbadk.util.i.PR();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.eLI != null) {
            this.eLI.onDestroy();
        }
        setIntent(intent);
        if (!v(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(e.d.common_color_10022, false);
        aPd();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eLH != null) {
            this.eLH.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.eLH != null) {
            this.eLH.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            aOu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aOu() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.eLH.showReceiver();
        } else {
            this.eLH.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.eLI.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aOy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aOx() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aOy() {
    }
}
