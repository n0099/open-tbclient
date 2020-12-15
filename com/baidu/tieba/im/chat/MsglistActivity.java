package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.n;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract boolean au(Bundle bundle);

    protected abstract void initView();

    @Override // com.baidu.tieba.im.chat.d
    public void cTI() {
        cTj();
    }

    public void cTj() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!au(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        if (this.kkX != null) {
            this.kkX.setImageUploadUIProgressCallback(this.klc);
        }
        bXb();
        if (a((d) this)) {
            loadDraft();
            cTh();
            j.kkV = n.bGw();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.kkX != null) {
            this.kkX.onDestroy();
        }
        setIntent(intent);
        if (!au(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bXb();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kkW != null) {
            this.kkW.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kkW != null) {
            this.kkW.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            cTe();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cTe() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.kkW.showReceiver();
        } else {
            this.kkW.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.kkX.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cTi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cTh() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cTi() {
    }
}
