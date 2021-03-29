package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.MsglistModel;
import d.b.h0.z0.o;
import d.b.i0.d1.f.c;
import d.b.i0.d1.f.h;
/* loaded from: classes3.dex */
public abstract class MsglistActivity<T> extends TalkableActivity<T> implements c {
    public abstract boolean first(c cVar);

    public abstract boolean initData(Bundle bundle);

    public abstract void initView();

    public boolean loadDraft() {
        return this.mListModel.loadDraft();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        AbsMsglistView absMsglistView = this.mListView;
        if (absMsglistView != null) {
            absMsglistView.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!initData(bundle)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        MsglistModel msglistModel = this.mListModel;
        if (msglistModel != null) {
            msglistModel.setImageUploadUIProgressCallback(this.mUploadProgressCallback);
        }
        initCallback();
        if (first(this)) {
            loadDraft();
            regReceiver();
            h.f53684a = o.e();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregReceiver();
    }

    @Override // d.b.i0.d1.f.c
    public void onFirstHistoryPageLoaded() {
        onPageInited();
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        MsglistModel msglistModel = this.mListModel;
        if (msglistModel != null) {
            msglistModel.onDestroy();
        }
        setIntent(intent);
        if (!initData(null)) {
            finish();
            return;
        }
        initView();
        adjustResizeForSoftInput(R.color.common_color_10022, false);
        initCallback();
        if (first(this)) {
            loadDraft();
        }
    }

    public void onPageInited() {
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        AbsMsglistView absMsglistView = this.mListView;
        if (absMsglistView != null) {
            absMsglistView.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            refreshHeadIcon();
        }
    }

    public void refreshHeadIcon() {
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.mListView.showReceiver();
        } else {
            this.mListView.closeReceiver();
        }
    }

    public void regReceiver() {
    }

    public void unregReceiver() {
    }
}
