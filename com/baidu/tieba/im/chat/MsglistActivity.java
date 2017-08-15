package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract void initView();

    protected abstract boolean n(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.d
    public void asw() {
        arY();
    }

    public void arY() {
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!n(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.e.common_color_10022, false);
        if (this.dke != null) {
            this.dke.setImageUploadUIProgressCallback(this.dkk);
        }
        asC();
        if (a((d) this)) {
            loadDraft();
            arW();
            j.dkc = com.baidu.tbadk.util.i.Hd();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.dke != null) {
            this.dke.onDestroy();
        }
        setIntent(intent);
        if (!n(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.e.common_color_10022, false);
        asC();
        if (a((d) this)) {
            loadDraft();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dkd != null) {
            this.dkd.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dkd != null) {
            this.dkd.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            arT();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void arT() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.dkd.showReceiver();
        } else {
            this.dkd.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.dke.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        arX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void arW() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void arX() {
    }
}
