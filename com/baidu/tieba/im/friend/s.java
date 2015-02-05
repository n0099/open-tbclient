package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.coreExtra.view.SearchBar;
import com.baidu.tbadk.coreExtra.view.au;
import com.baidu.tieba.z;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.g<InviteFriendListActivity> implements r {
    private final InviteFriendListActivity bbV;
    private SearchBar bbW;
    private p bbX;
    private View bbY;
    private InviteFriendCandidateList bbZ;
    private LinearLayout bca;
    private Button bcb;
    private View bcc;
    private int bcd;
    private boolean bce;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public s(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.bcd = 0;
        this.bbV = inviteFriendListActivity;
        this.bce = z;
        initialize();
    }

    private void initialize() {
        this.bbV.setContentView(com.baidu.tieba.x.invite_friend_list);
        this.mRoot = this.bbV.findViewById(com.baidu.tieba.w.root_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.bbW = (SearchBar) this.mRoot.findViewById(com.baidu.tieba.w.search_bar);
        this.bbW.setOnClickListener(this.bbV);
        this.bbW.setHint(this.bbV.getPageContext().getString(z.search));
        this.bbW.setFocusable(true);
        this.bbW.setFocusableInTouchMode(true);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mListView = (BdListView) this.mRoot.findViewById(com.baidu.tieba.w.friend_list);
        this.mListView.setOnItemClickListener(this.bbV);
        if (this.bce) {
            this.mNoDataView = NoDataViewFactory.a(this.bbV.getPageContext().getPageActivity(), this.mRoot, aa.a(NoDataViewFactory.ImgType.NODATA), ab.t(z.no_friends, z.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.bbV.getPageContext().getPageActivity(), this.mRoot, aa.a(NoDataViewFactory.ImgType.NODATA), ab.t(z.no_chat_friends, z.no_chat_friends_tip), com.baidu.tbadk.core.view.z.a(new y(TbadkCoreApplication.m255getInst().getResources().getString(z.find_new_friend), new t(this))));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.w.progress);
        this.bbZ = (InviteFriendCandidateList) this.mRoot.findViewById(com.baidu.tieba.w.candidate_list);
        this.bbZ.a(new u(this));
        this.bca = (LinearLayout) this.mRoot.findViewById(com.baidu.tieba.w.invite_candidate);
        this.bbY = this.mRoot.findViewById(com.baidu.tieba.w.invite_candidate_border);
        if (this.bce) {
            this.mNavigationBar.setTitleText(z.invite_contact_title);
            this.bca.setVisibility(8);
            this.bbY.setVisibility(8);
        } else {
            this.mNavigationBar.setTitleText(z.invite_friend);
        }
        OM();
        this.bcb = (Button) this.mRoot.findViewById(com.baidu.tieba.w.button_send);
        this.bcb.setOnClickListener(this.bbV);
        qF();
        OJ();
        fT(0);
    }

    public void a(au auVar) {
        this.bbW.setHandler(auVar);
    }

    public void qF() {
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        this.bbV.getLayoutMode().ab(skinType == 1);
        this.bbV.getLayoutMode().h(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.bbV.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bbV.getPageContext(), skinType);
        this.bbV.getLayoutMode().h(this.bbW);
        this.bbW.onChangeSkinType(skinType);
        bc.i(this.bcc, com.baidu.tieba.v.invite_friend_list_item_bg_color);
        this.bcc.setEnabled(false);
    }

    public void OJ() {
        this.mListView.setOnTouchListener(new v(this));
    }

    public int OK() {
        return this.bcb.getId();
    }

    public String getSearchText() {
        return this.bbW.getSearchText();
    }

    public String OL() {
        return this.bbZ.OF();
    }

    public void a(List<com.baidu.tbadk.coreExtra.relationship.b> list, boolean z) {
        if (this.bbX == null) {
            this.bbX = new p(this.bbV, this.bce);
            this.bbX.a(this);
            this.bbX.a(new w(this));
            this.mListView.setAdapter((ListAdapter) this.bbX);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.mListView.setVisibility(8);
            if (!this.bce) {
                this.bca.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.mListView.setVisibility(0);
        this.bbX.setData(list);
        this.bbX.notifyDataSetChanged();
        if (!this.bce) {
            this.bca.setVisibility(0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [255=4] */
    private void OM() {
        int dimensionPixelSize = this.bbV.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_height) + this.bbV.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_padding_bottom) + this.bbV.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_padding_top);
        this.bcc = new View(this.bbV.getPageContext().getPageActivity());
        this.bcc.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bcc.setEnabled(false);
        this.mListView.addFooterView(this.bcc);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.bbZ.d(bVar);
            fT(this.bbZ.getItemLength());
            ON();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.bbZ.f(bVar);
            fT(this.bbZ.getItemLength());
            ON();
        }
    }

    private void ON() {
        if (this.bbZ.getItemLength() > 0) {
            this.bcb.setEnabled(true);
        } else {
            this.bcb.setEnabled(false);
        }
    }

    public void OO() {
        com.baidu.adp.lib.util.l.c(this.bbV.getPageContext().getPageActivity(), this.bbW.getEditText());
    }

    private void fT(int i) {
        this.bcb.setText(String.format(this.bbV.getPageContext().getString(z.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public void startLoad() {
        this.mProgress.setVisibility(0);
    }

    public void OB() {
        this.mProgress.setVisibility(8);
    }

    public int OP() {
        return this.bcd;
    }

    public void fU(int i) {
        this.bcd = i;
        this.bbZ.setMaxCount(i);
    }

    @Override // com.baidu.tieba.im.friend.r
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.bbZ.e(bVar);
        }
    }
}
