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
    public void apX() {
        apz();
    }

    public void apz() {
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
        if (this.cYh != null) {
            this.cYh.setImageUploadUIProgressCallback(this.cYn);
        }
        aqd();
        if (a((ak) this)) {
            loadDraft();
            apx();
            bq.cYf = com.baidu.tbadk.util.i.GG();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.cYh != null) {
            this.cYh.onDestroy();
        }
        setIntent(intent);
        if (!l(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(w.e.common_color_10022, false);
        aqd();
        if (a((ak) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cYg != null) {
            this.cYg.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cYg != null) {
            this.cYg.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            apu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apu() {
        if (TbadkCoreApplication.m9getInst().isHeadsetModeOn()) {
            this.cYg.showReceiver();
        } else {
            this.cYg.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.cYh.loadDraft();
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
