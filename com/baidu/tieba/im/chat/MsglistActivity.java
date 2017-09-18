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
    public void auk() {
        atM();
    }

    public void atM() {
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
        if (this.drE != null) {
            this.drE.setImageUploadUIProgressCallback(this.drK);
        }
        auq();
        if (a((d) this)) {
            loadDraft();
            atK();
            j.drC = com.baidu.tbadk.util.i.Hc();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.drE != null) {
            this.drE.onDestroy();
        }
        setIntent(intent);
        if (!p(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.e.common_color_10022, false);
        auq();
        if (a((d) this)) {
            loadDraft();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.drD != null) {
            this.drD.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.drD != null) {
            this.drD.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            atH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void atH() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.drD.showReceiver();
        } else {
            this.drD.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.drE.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        atL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void atK() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void atL() {
    }
}
