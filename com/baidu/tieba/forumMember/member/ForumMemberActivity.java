package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.av;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements f.c {
    private as hju;
    private com.baidu.tieba.forumMember.member.a.b hjw;
    private e hjx;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.o> hjv = null;
    private ao hjy = new ao() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.ao
        public void a(int i, int i2, av avVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
            ForumMemberActivity.this.hjw.hideLoadingView();
            ForumMemberActivity.this.hjw.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.o> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.k) {
                        it.remove();
                    }
                }
            }
            if (!v.isEmpty(arrayList)) {
                ForumMemberActivity.this.hjw.bqO();
                ForumMemberActivity.this.hjv = arrayList;
                ForumMemberActivity.this.hjw.cj(ForumMemberActivity.this.hjv);
            } else if (v.isEmpty(ForumMemberActivity.this.hjv) && avVar != null) {
                ForumMemberActivity.this.hjw.Ex(avVar.errMsg);
            }
        }
    };
    private NoNetworkView.a faq = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.hjw.mD(z);
            if (z) {
                if (v.isEmpty(ForumMemberActivity.this.hjv)) {
                    ForumMemberActivity.this.bTw();
                } else {
                    ForumMemberActivity.this.hjw.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.hjw = new com.baidu.tieba.forumMember.member.a.b(this);
        this.hjw.f(this.faq);
        this.hjx = new e();
        this.hjx.setTag(getUniqueId());
        this.hjx.init();
        this.hjx.a(this.hjy);
        bTw();
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
        this.hju = new as();
        this.hju.forumId = this.mForumId;
        this.hju.forumName = this.mForumName;
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
        this.hjw.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hjx.bwi();
        if (this.hjw != null) {
            this.hjw.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.hjx;
        e eVar2 = this.hjx;
        eVar.a(3, 0, this.hju);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            bTw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTw() {
        this.hjw.showLoadingView();
        e eVar = this.hjx;
        e eVar2 = this.hjx;
        eVar.a(3, 0, this.hju);
    }
}
