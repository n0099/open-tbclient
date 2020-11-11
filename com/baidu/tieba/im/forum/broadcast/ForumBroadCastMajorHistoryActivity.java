package com.baidu.tieba.im.forum.broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.R;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
import com.baidu.tieba.im.forum.broadcast.model.ForumBroadCastMajorHistoryModel;
/* loaded from: classes26.dex */
public class ForumBroadCastMajorHistoryActivity extends BaseActivity<ForumBroadCastMajorHistoryActivity> implements a {
    private String kcA;
    private ForumBroadCastMajorHistoryModel kcy;
    private com.baidu.tieba.im.forum.broadcast.view.a kcz;
    private String mForumId;
    private String mForumName;
    private View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as(bundle);
        this.kcy = new ForumBroadCastMajorHistoryModel(getPageContext(), this, this.mForumId);
        this.rootView = LayoutInflater.from(this).inflate(R.layout.forum_broadcast_history_list, (ViewGroup) null);
        this.kcz = new com.baidu.tieba.im.forum.broadcast.view.a(getPageContext(), this, this.rootView, this.mForumId, this.mForumName, this.kcA, bundle);
        setContentView(this.rootView);
        this.kcy.cRH();
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    private void as(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumId = intent.getStringExtra("forum_id");
            this.mForumName = intent.getStringExtra("forum_name");
            this.kcA = intent.getStringExtra("from");
        } else if (bundle != null) {
            this.mForumId = bundle.getString("forum_id");
            this.mForumName = bundle.getString("forum_name");
            this.kcA = bundle.getString("from");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kcz.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.im.forum.broadcast.a
    public void bOI() {
        if (this.kcy != null) {
            this.kcy.bOI();
        }
    }

    @Override // com.baidu.tieba.im.forum.broadcast.a
    public void refresh() {
        if (this.kcy != null) {
            this.kcy.refresh();
        }
    }

    @Override // com.baidu.tieba.im.forum.broadcast.a
    public void a(ErrorData errorData) {
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(R.string.im_error_default);
            }
        }
        if (this.kcy != null && !this.kcy.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getString(R.string.net_error_text, new Object[]{errorData.error_msg, Integer.valueOf(errorData.error_code)});
            }
            this.kcz.aQ(str, false);
        }
    }

    @Override // com.baidu.tieba.im.forum.broadcast.a
    public void a(com.baidu.tieba.im.forum.broadcast.data.a aVar) {
        if (this.kcy != null && !this.kcy.hasData()) {
            this.kcz.aQ(getString(R.string.im_error_default), false);
        } else if (this.kcz != null) {
            this.kcz.b(aVar);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        refresh();
        if ("broadcast_publish_success".equals(intent.getStringExtra("from")) && this.kcz != null) {
            this.kcz.cRK();
        }
    }

    @Override // com.baidu.tieba.im.forum.broadcast.a
    public void a(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        this.kcz.b(forumBroadcastMajorResidueData);
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.rootView);
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kcz != null) {
            this.kcz.onDestory();
        }
        if (this.kcy != null) {
            this.kcy.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}
