package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements au {
    protected abstract boolean first(au auVar);

    protected abstract boolean initData(Bundle bundle);

    protected abstract void initView();

    @Override // com.baidu.tieba.im.chat.au
    public void onFirstHistoryPageLoaded() {
        onPageInited();
    }

    public void onPageInited() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!initData(bundle)) {
            finish();
            return;
        }
        initView();
        if (this.mListModel != null) {
            this.mListModel.setImageUploadUIProgressCallback(this.mUploadProgressCallback);
        }
        initCallback();
        if (first(this)) {
            loadDraft();
            regReceiver();
            cv.aTd = com.baidu.tbadk.util.h.zL();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (!initData(null)) {
            finish();
            return;
        }
        initView();
        initCallback();
        if (first(this)) {
            loadDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mListView != null) {
            this.mListView.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mListView != null) {
            this.mListView.onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
            refreshHeadIcon();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void refreshHeadIcon() {
        if (TbadkCoreApplication.m255getInst().isHeadsetModeOn()) {
            this.mListView.showReceiver();
        } else {
            this.mListView.closeReceiver();
        }
    }

    protected boolean loadDraft() {
        return this.mListModel.loadDraft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregReceiver();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void regReceiver() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unregReceiver() {
    }
}
