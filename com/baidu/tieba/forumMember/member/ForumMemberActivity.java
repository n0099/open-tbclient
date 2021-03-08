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
/* loaded from: classes7.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements f.c {
    private ax jef;
    private com.baidu.tieba.forumMember.member.a.b jeh;
    private d jei;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.n> jeg = null;
    private ar jej = new ar() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.ar
        public void a(int i, int i2, ba baVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
            ForumMemberActivity.this.jeh.hideLoadingView();
            ForumMemberActivity.this.jeh.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.n) {
                        it.remove();
                    }
                }
            }
            if (!y.isEmpty(arrayList)) {
                ForumMemberActivity.this.jeh.Xc();
                ForumMemberActivity.this.jeg = arrayList;
                ForumMemberActivity.this.jeh.df(ForumMemberActivity.this.jeg);
            } else if (y.isEmpty(ForumMemberActivity.this.jeg) && baVar != null) {
                ForumMemberActivity.this.jeh.Kj(baVar.errMsg);
            }
        }
    };
    private NoNetworkView.a gzW = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.jeh.qo(z);
            if (z) {
                if (y.isEmpty(ForumMemberActivity.this.jeg)) {
                    ForumMemberActivity.this.cAX();
                } else {
                    ForumMemberActivity.this.jeh.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.jeh = new com.baidu.tieba.forumMember.member.a.b(this);
        this.jeh.f(this.gzW);
        this.jei = new d();
        this.jei.setTag(getUniqueId());
        this.jei.init();
        this.jei.a(this.jej);
        cAX();
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
        this.jef = new ax();
        this.jef.forumId = this.mForumId;
        this.jef.forumName = this.mForumName;
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
        this.jeh.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jei.bZa();
        if (this.jeh != null) {
            this.jeh.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        d dVar = this.jei;
        d dVar2 = this.jei;
        dVar.a(3, 0, this.jef);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            cAX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAX() {
        this.jeh.showLoadingView();
        d dVar = this.jei;
        d dVar2 = this.jei;
        dVar.a(3, 0, this.jef);
    }
}
