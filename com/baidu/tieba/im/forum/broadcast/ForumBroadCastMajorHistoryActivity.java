package com.baidu.tieba.im.forum.broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
import com.baidu.tieba.im.forum.broadcast.model.ForumBroadCastMajorHistoryModel;
import d.b.c.e.p.j;
import d.b.j0.e1.i.a.a;
/* loaded from: classes4.dex */
public class ForumBroadCastMajorHistoryActivity extends BaseActivity<ForumBroadCastMajorHistoryActivity> implements a {
    public String mForumId;
    public String mForumName;
    public ForumBroadCastMajorHistoryModel mModel;
    public d.b.j0.e1.i.a.c.a mView;
    public String mfrom;
    public View rootView;

    private void initParamsFromIntent(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumId = intent.getStringExtra("forum_id");
            this.mForumName = intent.getStringExtra("forum_name");
            this.mfrom = intent.getStringExtra("from");
        } else if (bundle != null) {
            this.mForumId = bundle.getString("forum_id");
            this.mForumName = bundle.getString("forum_name");
            this.mfrom = bundle.getString("from");
        }
    }

    @Override // d.b.j0.e1.i.a.a
    public void loadMore() {
        ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel = this.mModel;
        if (forumBroadCastMajorHistoryModel != null) {
            forumBroadCastMajorHistoryModel.E();
        }
    }

    @Override // d.b.j0.e1.i.a.a
    public void netCallback(d.b.j0.e1.i.a.b.a aVar) {
        ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel = this.mModel;
        if (forumBroadCastMajorHistoryModel != null && !forumBroadCastMajorHistoryModel.C()) {
            this.mView.r(getString(R.string.im_error_default), false);
            return;
        }
        d.b.j0.e1.i.a.c.a aVar2 = this.mView;
        if (aVar2 != null) {
            aVar2.o(aVar);
        }
    }

    @Override // d.b.j0.e1.i.a.a
    public void netResidueCallback(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        this.mView.u(forumBroadcastMajorResidueData);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mView.m(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initParamsFromIntent(bundle);
        this.mModel = new ForumBroadCastMajorHistoryModel(getPageContext(), this, this.mForumId);
        this.rootView = LayoutInflater.from(this).inflate(R.layout.forum_broadcast_history_list, (ViewGroup) null);
        this.mView = new d.b.j0.e1.i.a.c.a(getPageContext(), this, this.rootView, this.mForumId, this.mForumName, this.mfrom, bundle);
        setContentView(this.rootView);
        this.mModel.B();
        refresh();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.b.j0.e1.i.a.c.a aVar = this.mView;
        if (aVar != null) {
            aVar.n();
        }
        ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel = this.mModel;
        if (forumBroadCastMajorHistoryModel != null) {
            forumBroadCastMajorHistoryModel.F();
        }
    }

    @Override // d.b.i0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        refresh();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.z()) {
            hideNetRefreshView(this.rootView);
            refresh();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        d.b.j0.e1.i.a.c.a aVar;
        super.onNewIntent(intent);
        refresh();
        if (!ForumBroadcastHelper.VALUE_INTENT_BCAST_FROM_EDIT_SUCCESS.equals(intent.getStringExtra("from")) || (aVar = this.mView) == null) {
            return;
        }
        aVar.s();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // d.b.j0.e1.i.a.a
    public void onServerError(ErrorData errorData) {
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(R.string.im_error_default);
            }
        }
        ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel = this.mModel;
        if (forumBroadCastMajorHistoryModel == null || forumBroadCastMajorHistoryModel.C()) {
            return;
        }
        this.mView.r(errorData != null ? getString(R.string.net_error_text, new Object[]{errorData.error_msg, Integer.valueOf(errorData.error_code)}) : null, false);
    }

    @Override // d.b.j0.e1.i.a.a
    public void refresh() {
        ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel = this.mModel;
        if (forumBroadCastMajorHistoryModel != null) {
            forumBroadCastMajorHistoryModel.H();
        }
    }
}
