package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements al {
    protected abstract boolean a(al alVar);

    protected abstract void initView();

    protected abstract boolean k(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.al
    public void asv() {
        arV();
    }

    public void arV() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!k(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(r.d.common_color_10022, false);
        if (this.dbq != null) {
            this.dbq.setImageUploadUIProgressCallback(this.dbw);
        }
        asC();
        if (a((al) this)) {
            loadDraft();
            arT();
            br.dbo = com.baidu.tbadk.util.g.GX();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.dbq != null) {
            this.dbq.onDestroy();
        }
        setIntent(intent);
        if (!k(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(r.d.common_color_10022, false);
        asC();
        if (a((al) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dbp != null) {
            this.dbp.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dbp != null) {
            this.dbp.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            arQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void arQ() {
        if (TbadkCoreApplication.m9getInst().isHeadsetModeOn()) {
            this.dbp.showReceiver();
        } else {
            this.dbp.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.dbq.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        arU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void arT() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void arU() {
    }
}
