package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements ak {
    protected abstract boolean a(ak akVar);

    protected abstract void initView();

    protected abstract boolean l(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.ak
    public void aot() {
        anV();
    }

    public void anV() {
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!l(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(w.e.common_color_10022, false);
        if (this.cQL != null) {
            this.cQL.setImageUploadUIProgressCallback(this.cQR);
        }
        aoz();
        if (a((ak) this)) {
            loadDraft();
            anT();
            bq.cQJ = com.baidu.tbadk.util.g.Hj();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.cQL != null) {
            this.cQL.onDestroy();
        }
        setIntent(intent);
        if (!l(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(w.e.common_color_10022, false);
        aoz();
        if (a((ak) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cQK != null) {
            this.cQK.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cQK != null) {
            this.cQK.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            anQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anQ() {
        if (TbadkCoreApplication.m9getInst().isHeadsetModeOn()) {
            this.cQK.showReceiver();
        } else {
            this.cQK.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.cQL.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        anU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anT() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anU() {
    }
}
