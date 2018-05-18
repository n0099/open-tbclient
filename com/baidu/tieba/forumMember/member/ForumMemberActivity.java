package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements e.b {
    private am cUZ;
    private com.baidu.tieba.forumMember.member.a.b cVb;
    private e cVc;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.h> cVa = null;
    private aj cVd = new aj() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            ForumMemberActivity.this.cVb.Os();
            ForumMemberActivity.this.cVb.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.g) {
                        it.remove();
                    }
                }
            }
            if (!v.w(arrayList)) {
                ForumMemberActivity.this.cVb.Qk();
                ForumMemberActivity.this.cVa = arrayList;
                ForumMemberActivity.this.cVb.bf(ForumMemberActivity.this.cVa);
            } else if (v.w(ForumMemberActivity.this.cVa) && apVar != null) {
                ForumMemberActivity.this.cVb.lH(apVar.errMsg);
            }
        }
    };
    private NoNetworkView.a cun = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            ForumMemberActivity.this.cVb.fm(z);
            if (z) {
                if (v.w(ForumMemberActivity.this.cVa)) {
                    ForumMemberActivity.this.aog();
                } else {
                    ForumMemberActivity.this.cVb.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j(bundle);
        this.cVb = new com.baidu.tieba.forumMember.member.a.b(this);
        this.cVb.g(this.cun);
        this.cVc = new e();
        this.cVc.setTag(getUniqueId());
        this.cVc.init();
        this.cVc.a(this.cVd);
        aog();
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
        this.cUZ = new am();
        this.cUZ.forumId = this.mForumId;
        this.cUZ.forumName = this.mForumName;
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
        this.cVb.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cVc.Rv();
    }

    @Override // com.baidu.tbadk.core.view.e.b
    public void aO(boolean z) {
        e eVar = this.cVc;
        e eVar2 = this.cVc;
        eVar.a(3, 0, this.cUZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.gD()) {
            aog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aog() {
        this.cVb.showLoadingView();
        e eVar = this.cVc;
        e eVar2 = this.cVc;
        eVar.a(3, 0, this.cUZ);
    }
}
