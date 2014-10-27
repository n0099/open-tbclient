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
    private final InviteFriendListActivity aVV;
    private SearchBar aVW;
    private p aVX;
    private View aVY;
    private InviteFriendCandidateList aVZ;
    private LinearLayout aWa;
    private Button aWb;
    private View aWc;
    private int aWd;
    private boolean aWe;
    private com.baidu.tbadk.core.view.o ahO;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgress;
    private View mRoot;
    private BdListView vl;

    public s(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity);
        this.aWd = 0;
        this.aVV = inviteFriendListActivity;
        this.aWe = z;
        ny();
    }

    private void ny() {
        this.aVV.setContentView(com.baidu.tieba.w.invite_friend_list);
        this.mRoot = this.aVV.findViewById(com.baidu.tieba.v.root_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.aVW = (SearchBar) this.mRoot.findViewById(com.baidu.tieba.v.search_bar);
        this.aVW.setOnClickListener(this.aVV);
        this.aVW.setHint(this.aVV.getString(y.search));
        this.aVW.setFocusable(true);
        this.aVW.setFocusableInTouchMode(true);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.vl = (BdListView) this.mRoot.findViewById(com.baidu.tieba.v.friend_list);
        this.vl.setOnItemClickListener(this.aVV);
        if (this.aWe) {
            this.ahO = NoDataViewFactory.a(this.aVV, this.mRoot, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.s.q(y.no_friends, y.no_friends_tip), null);
        } else {
            this.ahO = NoDataViewFactory.a(this.aVV, this.mRoot, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.s.q(y.no_chat_friends, y.no_chat_friends_tip), com.baidu.tbadk.core.view.q.a(new com.baidu.tbadk.core.view.p(TbadkApplication.m251getInst().getResources().getString(y.find_new_friend), new t(this))));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.v.progress);
        this.aVZ = (InviteFriendCandidateList) this.mRoot.findViewById(com.baidu.tieba.v.candidate_list);
        this.aVZ.a(new u(this));
        this.aWa = (LinearLayout) this.mRoot.findViewById(com.baidu.tieba.v.invite_candidate);
        this.aVY = this.mRoot.findViewById(com.baidu.tieba.v.invite_candidate_border);
        if (this.aWe) {
            this.mNavigationBar.setTitleText(y.invite_contact_title);
            this.aWa.setVisibility(8);
            this.aVY.setVisibility(8);
        } else {
            this.mNavigationBar.setTitleText(y.invite_friend);
        }
        Ng();
        this.aWb = (Button) this.mRoot.findViewById(com.baidu.tieba.v.button_send);
        this.aWb.setOnClickListener(this.aVV);
        nz();
        Nd();
        fC(0);
    }

    public void a(at atVar) {
        this.aVW.setHandler(atVar);
    }

    public void nz() {
        int skinType = TbadkApplication.m251getInst().getSkinType();
        this.aVV.getLayoutMode().L(skinType == 1);
        this.aVV.getLayoutMode().h(this.mRoot);
        this.mNavigationBar.onChangeSkinType(skinType);
        this.ahO.onChangeSkinType(skinType);
        this.aVV.getLayoutMode().h(this.aVW);
        this.aVW.onChangeSkinType(skinType);
        aw.h(this.aWc, com.baidu.tieba.u.invite_friend_list_item_bg_color);
        this.aWc.setEnabled(false);
    }

    public void Nd() {
        this.vl.setOnTouchListener(new v(this));
    }

    public int Ne() {
        return this.aWb.getId();
    }

    public String getSearchText() {
        return this.aVW.getSearchText();
    }

    public String Nf() {
        return this.aVZ.MZ();
    }

    public void a(List<com.baidu.tbadk.coreExtra.relationship.b> list, boolean z) {
        if (this.aVX == null) {
            this.aVX = new p(this.aVV, this.aWe);
            this.aVX.a(this);
            this.aVX.a(new w(this));
            this.vl.setAdapter((ListAdapter) this.aVX);
        }
        if (!z && list.isEmpty()) {
            this.ahO.setVisibility(0);
            this.vl.setVisibility(8);
            if (!this.aWe) {
                this.aWa.setVisibility(8);
                return;
            }
            return;
        }
        this.ahO.setVisibility(8);
        this.vl.setVisibility(0);
        this.aVX.setData(list);
        this.aVX.notifyDataSetChanged();
        if (!this.aWe) {
            this.aWa.setVisibility(0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [255=4] */
    private void Ng() {
        int dimensionPixelSize = this.aVV.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_height) + this.aVV.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_bottom) + this.aVV.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_top);
        this.aWc = new View(this.aVV);
        this.aWc.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.aWc.setEnabled(false);
        this.vl.addFooterView(this.aWc);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.aVZ.d(bVar);
            fC(this.aVZ.getItemLength());
            Nh();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.aVZ.f(bVar);
            fC(this.aVZ.getItemLength());
            Nh();
        }
    }

    private void Nh() {
        if (this.aVZ.getItemLength() > 0) {
            this.aWb.setEnabled(true);
        } else {
            this.aWb.setEnabled(false);
        }
    }

    public void Ni() {
        com.baidu.adp.lib.util.m.b(this.aVV, this.aVW.getEditText());
    }

    private void fC(int i) {
        this.aWb.setText(String.format(this.aVV.getString(y.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public void Nj() {
        this.mProgress.setVisibility(0);
    }

    public void MV() {
        this.mProgress.setVisibility(8);
    }

    public int Nk() {
        return this.aWd;
    }

    public void fD(int i) {
        this.aWd = i;
        this.aVZ.setMaxCount(i);
    }

    @Override // com.baidu.tieba.im.friend.r
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.aVZ.e(bVar);
        }
    }
}
