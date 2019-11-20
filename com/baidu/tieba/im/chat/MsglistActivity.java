package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean T(Bundle bundle);

    protected abstract boolean a(d dVar);

    protected abstract void initView();

    @Override // com.baidu.tieba.im.chat.d
    public void bye() {
        bxG();
    }

    public void bxG() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!T(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        if (this.gzE != null) {
            this.gzE.setImageUploadUIProgressCallback(this.gzK);
        }
        initCallback();
        if (a((d) this)) {
            loadDraft();
            bxE();
            j.gzC = k.axw();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gzE != null) {
            this.gzE.onDestroy();
        }
        setIntent(intent);
        if (!T(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        initCallback();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gzD != null) {
            this.gzD.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gzD != null) {
            this.gzD.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            bxB();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bxB() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.gzD.showReceiver();
        } else {
            this.gzD.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.gzE.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bxF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bxE() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bxF() {
    }
}
