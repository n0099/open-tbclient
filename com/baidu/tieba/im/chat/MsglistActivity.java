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
    public void bxP() {
        bxr();
    }

    public void bxr() {
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
        if (this.gtD != null) {
            this.gtD.setImageUploadUIProgressCallback(this.gtI);
        }
        bxV();
        if (a((d) this)) {
            loadDraft();
            bxp();
            j.gtB = l.auX();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gtD != null) {
            this.gtD.onDestroy();
        }
        setIntent(intent);
        if (!U(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bxV();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gtC != null) {
            this.gtC.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gtC != null) {
            this.gtC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            bxm();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bxm() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.gtC.showReceiver();
        } else {
            this.gtC.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.gtD.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bxq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bxp() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bxq() {
    }
}
