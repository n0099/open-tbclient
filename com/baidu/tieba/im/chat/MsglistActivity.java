package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements d {
    protected abstract boolean a(d dVar);

    protected abstract boolean as(Bundle bundle);

    protected abstract void initView();

    @Override // com.baidu.tieba.im.chat.d
    public void cjx() {
        ciY();
    }

    public void ciY() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!as(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        if (this.itD != null) {
            this.itD.setImageUploadUIProgressCallback(this.itI);
        }
        bvs();
        if (a((d) this)) {
            loadDraft();
            ciW();
            j.itB = m.bgv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.itD != null) {
            this.itD.onDestroy();
        }
        setIntent(intent);
        if (!as(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        bvs();
        if (a((d) this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.itC != null) {
            this.itC.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.itC != null) {
            this.itC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            ciT();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ciT() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.itC.showReceiver();
        } else {
            this.itC.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.itD.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ciX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ciW() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ciX() {
    }
}
