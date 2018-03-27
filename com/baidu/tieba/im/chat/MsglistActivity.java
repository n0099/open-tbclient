package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract void initView();

    protected abstract boolean q(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.d
    public void aFQ() {
        aFs();
    }

    public void aFs() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!q(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0141d.common_color_10022, false);
        if (this.ewV != null) {
            this.ewV.setImageUploadUIProgressCallback(this.exa);
        }
        aFW();
        if (a((d) this)) {
            loadDraft();
            aFq();
            j.ewT = com.baidu.tbadk.util.i.OZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.ewV != null) {
            this.ewV.onDestroy();
        }
        setIntent(intent);
        if (!q(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.C0141d.common_color_10022, false);
        aFW();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ewU != null) {
            this.ewU.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.ewU != null) {
            this.ewU.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            aFn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aFn() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.ewU.showReceiver();
        } else {
            this.ewU.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.ewV.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aFr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aFq() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aFr() {
    }
}
