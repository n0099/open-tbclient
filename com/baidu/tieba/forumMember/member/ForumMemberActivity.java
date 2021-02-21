package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.ba;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements f.c {
    private ax jcw;
    private com.baidu.tieba.forumMember.member.a.b jcy;
    private d jcz;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.n> jcx = null;
    private ar jcA = new ar() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.ar
        public void a(int i, int i2, ba baVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
            ForumMemberActivity.this.jcy.hideLoadingView();
            ForumMemberActivity.this.jcy.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.n) {
                        it.remove();
                    }
                }
            }
            if (!y.isEmpty(arrayList)) {
                ForumMemberActivity.this.jcy.WZ();
                ForumMemberActivity.this.jcx = arrayList;
                ForumMemberActivity.this.jcy.df(ForumMemberActivity.this.jcx);
            } else if (y.isEmpty(ForumMemberActivity.this.jcx) && baVar != null) {
                ForumMemberActivity.this.jcy.Ka(baVar.errMsg);
            }
        }
    };
    private NoNetworkView.a gyn = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.jcy.qo(z);
            if (z) {
                if (y.isEmpty(ForumMemberActivity.this.jcx)) {
                    ForumMemberActivity.this.cAR();
                } else {
                    ForumMemberActivity.this.jcy.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.jcy = new com.baidu.tieba.forumMember.member.a.b(this);
        this.jcy.f(this.gyn);
        this.jcz = new d();
        this.jcz.setTag(getUniqueId());
        this.jcz.init();
        this.jcz.a(this.jcA);
        cAR();
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
        this.jcw = new ax();
        this.jcw.forumId = this.mForumId;
        this.jcw.forumName = this.mForumName;
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
        this.jcy.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jcz.bYU();
        if (this.jcy != null) {
            this.jcy.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        d dVar = this.jcz;
        d dVar2 = this.jcz;
        dVar.a(3, 0, this.jcw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            cAR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAR() {
        this.jcy.showLoadingView();
        d dVar = this.jcz;
        d dVar2 = this.jcz;
        dVar.a(3, 0, this.jcw);
    }
}
