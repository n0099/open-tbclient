package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.SearchBar;
import com.baidu.tbadk.coreExtra.view.at;
import com.baidu.tieba.y;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.f implements r {
    private final InviteFriendListActivity aWj;
    private SearchBar aWk;
    private p aWl;
    private View aWm;
    private InviteFriendCandidateList aWn;
    private LinearLayout aWo;
    private Button aWp;
    private View aWq;
    private int aWr;
    private boolean aWs;
    private com.baidu.tbadk.core.view.o ahX;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgress;
    private View mRoot;
    private BdListView vl;

    public s(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity);
        this.aWr = 0;
        this.aWj = inviteFriendListActivity;
        this.aWs = z;
        ny();
    }

    private void ny() {
        this.aWj.setContentView(com.baidu.tieba.w.invite_friend_list);
        this.mRoot = this.aWj.findViewById(com.baidu.tieba.v.root_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.aWk = (SearchBar) this.mRoot.findViewById(com.baidu.tieba.v.search_bar);
        this.aWk.setOnClickListener(this.aWj);
        this.aWk.setHint(this.aWj.getString(y.search));
        this.aWk.setFocusable(true);
        this.aWk.setFocusableInTouchMode(true);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.vl = (BdListView) this.mRoot.findViewById(com.baidu.tieba.v.friend_list);
        this.vl.setOnItemClickListener(this.aWj);
        if (this.aWs) {
            this.ahX = NoDataViewFactory.a(this.aWj, this.mRoot, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.s.q(y.no_friends, y.no_friends_tip), null);
        } else {
            this.ahX = NoDataViewFactory.a(this.aWj, this.mRoot, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.s.q(y.no_chat_friends, y.no_chat_friends_tip), com.baidu.tbadk.core.view.q.a(new com.baidu.tbadk.core.view.p(TbadkApplication.m251getInst().getResources().getString(y.find_new_friend), new t(this))));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.v.progress);
        this.aWn = (InviteFriendCandidateList) this.mRoot.findViewById(com.baidu.tieba.v.candidate_list);
        this.aWn.a(new u(this));
        this.aWo = (LinearLayout) this.mRoot.findViewById(com.baidu.tieba.v.invite_candidate);
        this.aWm = this.mRoot.findViewById(com.baidu.tieba.v.invite_candidate_border);
        if (this.aWs) {
            this.mNavigationBar.setTitleText(y.invite_contact_title);
            this.aWo.setVisibility(8);
            this.aWm.setVisibility(8);
        } else {
            this.mNavigationBar.setTitleText(y.invite_friend);
        }
        Nk();
        this.aWp = (Button) this.mRoot.findViewById(com.baidu.tieba.v.button_send);
        this.aWp.setOnClickListener(this.aWj);
        nz();
        Nh();
        fC(0);
    }

    public void a(at atVar) {
        this.aWk.setHandler(atVar);
    }

    public void nz() {
        int skinType = TbadkApplication.m251getInst().getSkinType();
        this.aWj.getLayoutMode().L(skinType == 1);
        this.aWj.getLayoutMode().h(this.mRoot);
        this.mNavigationBar.onChangeSkinType(skinType);
        this.ahX.onChangeSkinType(skinType);
        this.aWj.getLayoutMode().h(this.aWk);
        this.aWk.onChangeSkinType(skinType);
        aw.h(this.aWq, com.baidu.tieba.u.invite_friend_list_item_bg_color);
        this.aWq.setEnabled(false);
    }

    public void Nh() {
        this.vl.setOnTouchListener(new v(this));
    }

    public int Ni() {
        return this.aWp.getId();
    }

    public String getSearchText() {
        return this.aWk.getSearchText();
    }

    public String Nj() {
        return this.aWn.Nd();
    }

    public void a(List<com.baidu.tbadk.coreExtra.relationship.b> list, boolean z) {
        if (this.aWl == null) {
            this.aWl = new p(this.aWj, this.aWs);
            this.aWl.a(this);
            this.aWl.a(new w(this));
            this.vl.setAdapter((ListAdapter) this.aWl);
        }
        if (!z && list.isEmpty()) {
            this.ahX.setVisibility(0);
            this.vl.setVisibility(8);
            if (!this.aWs) {
                this.aWo.setVisibility(8);
                return;
            }
            return;
        }
        this.ahX.setVisibility(8);
        this.vl.setVisibility(0);
        this.aWl.setData(list);
        this.aWl.notifyDataSetChanged();
        if (!this.aWs) {
            this.aWo.setVisibility(0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [255=4] */
    private void Nk() {
        int dimensionPixelSize = this.aWj.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_height) + this.aWj.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_bottom) + this.aWj.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_top);
        this.aWq = new View(this.aWj);
        this.aWq.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.aWq.setEnabled(false);
        this.vl.addFooterView(this.aWq);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.aWn.d(bVar);
            fC(this.aWn.getItemLength());
            Nl();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.aWn.f(bVar);
            fC(this.aWn.getItemLength());
            Nl();
        }
    }

    private void Nl() {
        if (this.aWn.getItemLength() > 0) {
            this.aWp.setEnabled(true);
        } else {
            this.aWp.setEnabled(false);
        }
    }

    public void Nm() {
        com.baidu.adp.lib.util.m.b(this.aWj, this.aWk.getEditText());
    }

    private void fC(int i) {
        this.aWp.setText(String.format(this.aWj.getString(y.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public void Nn() {
        this.mProgress.setVisibility(0);
    }

    public void MZ() {
        this.mProgress.setVisibility(8);
    }

    public int No() {
        return this.aWr;
    }

    public void fD(int i) {
        this.aWr = i;
        this.aWn.setMaxCount(i);
    }

    @Override // com.baidu.tieba.im.friend.r
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.aWn.e(bVar);
        }
    }
}
