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
    public void atZ() {
        atB();
    }

    public void atB() {
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
        if (this.dqJ != null) {
            this.dqJ.setImageUploadUIProgressCallback(this.dqP);
        }
        auf();
        if (a((d) this)) {
            loadDraft();
            atz();
            j.dqH = com.baidu.tbadk.util.i.Hc();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.dqJ != null) {
            this.dqJ.onDestroy();
        }
        setIntent(intent);
        if (!p(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(d.e.common_color_10022, false);
        auf();
        if (a((d) this)) {
            loadDraft();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dqI != null) {
            this.dqI.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dqI != null) {
            this.dqI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            atw();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void atw() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.dqI.showReceiver();
        } else {
            this.dqI.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.dqJ.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        atA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void atz() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void atA() {
    }
}
