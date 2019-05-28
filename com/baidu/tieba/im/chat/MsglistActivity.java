package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean U(Bundle bundle);

    protected abstract boolean a(d dVar);

    protected abstract void initView();

    @Override // com.baidu.tieba.im.chat.d
    public void bxO() {
        bxq();
    }

    public void bxq() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!U(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        if (this.gtB != null) {
            this.gtB.setImageUploadUIProgressCallback(this.gtG);
        }
        bxU();
        if (a((d) this)) {
            loadDraft();
            bxo();
            j.gtz = l.auX();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gtB != null) {
            this.gtB.onDestroy();
        }
        setIntent(intent);
        if (!U(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bxU();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gtA != null) {
            this.gtA.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gtA != null) {
            this.gtA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            bxl();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bxl() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.gtA.showReceiver();
        } else {
            this.gtA.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.gtB.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bxp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bxo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bxp() {
    }
}
