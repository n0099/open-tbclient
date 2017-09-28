package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract void initView();

    protected abstract boolean p(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.d
    public void asV() {
        asx();
    }

    public void asx() {
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!p(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.e.common_color_10022, false);
        if (this.dnT != null) {
            this.dnT.setImageUploadUIProgressCallback(this.dnZ);
        }
        atb();
        if (a((d) this)) {
            loadDraft();
            asv();
            j.dnR = com.baidu.tbadk.util.h.GG();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.dnT != null) {
            this.dnT.onDestroy();
        }
        setIntent(intent);
        if (!p(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.e.common_color_10022, false);
        atb();
        if (a((d) this)) {
            loadDraft();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dnS != null) {
            this.dnS.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dnS != null) {
            this.dnS.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            ass();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ass() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.dnS.showReceiver();
        } else {
            this.dnS.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.dnT.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        asw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asv() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asw() {
    }
}
