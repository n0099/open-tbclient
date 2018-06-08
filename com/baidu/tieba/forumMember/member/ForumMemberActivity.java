package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements f.b {
    private am dek;
    private com.baidu.tieba.forumMember.member.a.b dem;
    private e den;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.h> del = null;
    private aj deo = new aj() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            ForumMemberActivity.this.dem.hideLoadingView();
            ForumMemberActivity.this.dem.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.g) {
                        it.remove();
                    }
                }
            }
            if (!w.z(arrayList)) {
                ForumMemberActivity.this.dem.TI();
                ForumMemberActivity.this.del = arrayList;
                ForumMemberActivity.this.dem.bi(ForumMemberActivity.this.del);
            } else if (w.z(ForumMemberActivity.this.del) && apVar != null) {
                ForumMemberActivity.this.dem.mo(apVar.errMsg);
            }
        }
    };
    private NoNetworkView.a cCR = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            ForumMemberActivity.this.dem.fq(z);
            if (z) {
                if (w.z(ForumMemberActivity.this.del)) {
                    ForumMemberActivity.this.asl();
                } else {
                    ForumMemberActivity.this.dem.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j(bundle);
        this.dem = new com.baidu.tieba.forumMember.member.a.b(this);
        this.dem.g(this.cCR);
        this.den = new e();
        this.den.setTag(getUniqueId());
        this.den.init();
        this.den.a(this.deo);
        asl();
    }

    private void j(Bundle bundle) {
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
        this.dek = new am();
        this.dek.forumId = this.mForumId;
        this.dek.forumName = this.mForumName;
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
        this.dem.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.den.UT();
        if (this.dem != null) {
            this.dem.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.b
    public void aS(boolean z) {
        e eVar = this.den;
        e eVar2 = this.den;
        eVar.a(3, 0, this.dek);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.jr()) {
            asl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asl() {
        this.dem.showLoadingView();
        e eVar = this.den;
        e eVar2 = this.den;
        eVar.a(3, 0, this.dek);
    }
}
