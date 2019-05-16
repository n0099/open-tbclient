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
    public void bxL() {
        bxn();
    }

    public void bxn() {
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
        if (this.gtA != null) {
            this.gtA.setImageUploadUIProgressCallback(this.gtF);
        }
        bxR();
        if (a((d) this)) {
            loadDraft();
            bxl();
            j.gty = l.auX();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gtA != null) {
            this.gtA.onDestroy();
        }
        setIntent(intent);
        if (!U(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bxR();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gtz != null) {
            this.gtz.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gtz != null) {
            this.gtz.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            bxi();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bxi() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.gtz.showReceiver();
        } else {
            this.gtz.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.gtA.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bxm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bxl() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bxm() {
    }
}
