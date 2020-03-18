package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract boolean am(Bundle bundle);

    protected abstract void initView();

    @Override // com.baidu.tieba.im.chat.d
    public void bSB() {
        bSc();
    }

    public void bSc() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!am(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        if (this.hvb != null) {
            this.hvb.setImageUploadUIProgressCallback(this.hvg);
        }
        bgm();
        if (a((d) this)) {
            loadDraft();
            bSa();
            j.huZ = m.aSe();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.hvb != null) {
            this.hvb.onDestroy();
        }
        setIntent(intent);
        if (!am(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bgm();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hva != null) {
            this.hva.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hva != null) {
            this.hva.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            bRX();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bRX() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.hva.showReceiver();
        } else {
            this.hva.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.hvb.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bSb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSa() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSb() {
    }
}
