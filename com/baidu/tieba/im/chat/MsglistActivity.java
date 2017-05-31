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
    public void amm() {
        alO();
    }

    public void alO() {
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
        if (this.cQl != null) {
            this.cQl.setImageUploadUIProgressCallback(this.cQr);
        }
        ams();
        if (a((ak) this)) {
            loadDraft();
            alM();
            bq.cQj = com.baidu.tbadk.util.h.Gj();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.cQl != null) {
            this.cQl.onDestroy();
        }
        setIntent(intent);
        if (!l(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(w.e.common_color_10022, false);
        ams();
        if (a((ak) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cQk != null) {
            this.cQk.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cQk != null) {
            this.cQk.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            alJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alJ() {
        if (TbadkCoreApplication.m9getInst().isHeadsetModeOn()) {
            this.cQk.showReceiver();
        } else {
            this.cQk.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.cQl.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        alN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alM() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alN() {
    }
}
