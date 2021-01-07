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
/* loaded from: classes8.dex */
public class ForumBroadCastMajorHistoryActivity extends BaseActivity<ForumBroadCastMajorHistoryActivity> implements a {
    private String jtx;
    private ForumBroadCastMajorHistoryModel kBD;
    private com.baidu.tieba.im.forum.broadcast.view.a kBE;
    private String mForumId;
    private String mForumName;
    private View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        an(bundle);
        this.kBD = new ForumBroadCastMajorHistoryModel(getPageContext(), this, this.mForumId);
        this.rootView = LayoutInflater.from(this).inflate(R.layout.forum_broadcast_history_list, (ViewGroup) null);
        this.kBE = new com.baidu.tieba.im.forum.broadcast.view.a(getPageContext(), this, this.rootView, this.mForumId, this.mForumName, this.jtx, bundle);
        setContentView(this.rootView);
        this.kBD.cXY();
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    private void an(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumId = intent.getStringExtra("forum_id");
            this.mForumName = intent.getStringExtra("forum_name");
            this.jtx = intent.getStringExtra("from");
        } else if (bundle != null) {
            this.mForumId = bundle.getString("forum_id");
            this.mForumName = bundle.getString("forum_name");
            this.jtx = bundle.getString("from");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kBE.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.im.forum.broadcast.a
    public void bUq() {
        if (this.kBD != null) {
            this.kBD.bUq();
        }
    }

    @Override // com.baidu.tieba.im.forum.broadcast.a
    public void refresh() {
        if (this.kBD != null) {
            this.kBD.refresh();
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
        if (this.kBD != null && !this.kBD.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getString(R.string.net_error_text, new Object[]{errorData.error_msg, Integer.valueOf(errorData.error_code)});
            }
            this.kBE.aR(str, false);
        }
    }

    @Override // com.baidu.tieba.im.forum.broadcast.a
    public void a(com.baidu.tieba.im.forum.broadcast.data.a aVar) {
        if (this.kBD != null && !this.kBD.hasData()) {
            this.kBE.aR(getString(R.string.im_error_default), false);
        } else if (this.kBE != null) {
            this.kBE.b(aVar);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        refresh();
        if ("broadcast_publish_success".equals(intent.getStringExtra("from")) && this.kBE != null) {
            this.kBE.cYb();
        }
    }

    @Override // com.baidu.tieba.im.forum.broadcast.a
    public void a(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        this.kBE.b(forumBroadcastMajorResidueData);
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
        if (this.kBE != null) {
            this.kBE.onDestory();
        }
        if (this.kBD != null) {
            this.kBD.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}
