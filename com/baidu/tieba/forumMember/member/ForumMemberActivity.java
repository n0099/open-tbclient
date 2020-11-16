package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.frs.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes22.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements f.c {
    private ba iEc;
    private com.baidu.tieba.forumMember.member.a.b iEe;
    private e iEf;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.q> iEd = null;
    private av iEg = new av() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            ForumMemberActivity.this.iEe.hideLoadingView();
            ForumMemberActivity.this.iEe.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.n) {
                        it.remove();
                    }
                }
            }
            if (!y.isEmpty(arrayList)) {
                ForumMemberActivity.this.iEe.VB();
                ForumMemberActivity.this.iEd = arrayList;
                ForumMemberActivity.this.iEe.cZ(ForumMemberActivity.this.iEd);
            } else if (y.isEmpty(ForumMemberActivity.this.iEd) && bdVar != null) {
                ForumMemberActivity.this.iEe.JM(bdVar.errMsg);
            }
        }
    };
    private NoNetworkView.a ghn = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.iEe.po(z);
            if (z) {
                if (y.isEmpty(ForumMemberActivity.this.iEd)) {
                    ForumMemberActivity.this.cwh();
                } else {
                    ForumMemberActivity.this.iEe.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.iEe = new com.baidu.tieba.forumMember.member.a.b(this);
        this.iEe.f(this.ghn);
        this.iEf = new e();
        this.iEf.setTag(getUniqueId());
        this.iEf.init();
        this.iEf.a(this.iEg);
        cwh();
    }

    private void initBundle(Bundle bundle) {
        if (bundle == null) {
            if (getIntent() != null) {
                this.mForumId = getIntent().getStringExtra("forum_id");
                this.mForumName = getIntent().getStringExtra("forum_name");
            } else {
                return;
            }
        } else {
            this.mForumId = bundle.getString("forum_id", "");
            this.mForumName = bundle.getString("forum_name", "");
        }
        this.iEc = new ba();
        this.iEc.forumId = this.mForumId;
        this.iEc.forumName = this.mForumName;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("forum_name", this.mForumName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iEe.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.iEf.bVo();
        if (this.iEe != null) {
            this.iEe.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.iEf;
        e eVar2 = this.iEf;
        eVar.a(3, 0, this.iEc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            cwh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwh() {
        this.iEe.showLoadingView();
        e eVar = this.iEf;
        e eVar2 = this.iEf;
        eVar.a(3, 0, this.iEc);
    }
}
