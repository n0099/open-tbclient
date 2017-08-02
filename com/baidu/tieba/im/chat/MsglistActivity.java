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
    public void arD() {
        arf();
    }

    public void arf() {
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
        if (this.dgP != null) {
            this.dgP.setImageUploadUIProgressCallback(this.dgV);
        }
        arJ();
        if (a((d) this)) {
            loadDraft();
            ard();
            j.dgN = com.baidu.tbadk.util.i.GV();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.dgP != null) {
            this.dgP.onDestroy();
        }
        setIntent(intent);
        if (!n(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.e.common_color_10022, false);
        arJ();
        if (a((d) this)) {
            loadDraft();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dgO != null) {
            this.dgO.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dgO != null) {
            this.dgO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            ara();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ara() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.dgO.showReceiver();
        } else {
            this.dgO.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.dgP.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        are();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ard() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void are() {
    }
}
