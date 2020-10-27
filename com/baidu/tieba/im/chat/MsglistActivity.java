package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.n;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract boolean at(Bundle bundle);

    protected abstract void initView();

    @Override // com.baidu.tieba.im.chat.d
    public void cMm() {
        cLN();
    }

    public void cLN() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!at(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        if (this.jQI != null) {
            this.jQI.setImageUploadUIProgressCallback(this.jQN);
        }
        bRy();
        if (a((d) this)) {
            loadDraft();
            cLL();
            j.jQG = n.bBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.jQI != null) {
            this.jQI.onDestroy();
        }
        setIntent(intent);
        if (!at(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bRy();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jQH != null) {
            this.jQH.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jQH != null) {
            this.jQH.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            cLI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cLI() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.jQH.showReceiver();
        } else {
            this.jQH.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.jQI.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cLM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cLL() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cLM() {
    }
}
