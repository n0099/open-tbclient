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
    private final InviteFriendListActivity bbW;
    private SearchBar bbX;
    private p bbY;
    private View bbZ;
    private InviteFriendCandidateList bca;
    private LinearLayout bcb;
    private Button bcc;
    private View bcd;
    private int bce;
    private boolean bcf;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public s(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.bce = 0;
        this.bbW = inviteFriendListActivity;
        this.bcf = z;
        initialize();
    }

    private void initialize() {
        this.bbW.setContentView(com.baidu.tieba.x.invite_friend_list);
        this.mRoot = this.bbW.findViewById(com.baidu.tieba.w.root_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.bbX = (SearchBar) this.mRoot.findViewById(com.baidu.tieba.w.search_bar);
        this.bbX.setOnClickListener(this.bbW);
        this.bbX.setHint(this.bbW.getPageContext().getString(z.search));
        this.bbX.setFocusable(true);
        this.bbX.setFocusableInTouchMode(true);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mListView = (BdListView) this.mRoot.findViewById(com.baidu.tieba.w.friend_list);
        this.mListView.setOnItemClickListener(this.bbW);
        if (this.bcf) {
            this.mNoDataView = NoDataViewFactory.a(this.bbW.getPageContext().getPageActivity(), this.mRoot, aa.a(NoDataViewFactory.ImgType.NODATA), ab.t(z.no_friends, z.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.bbW.getPageContext().getPageActivity(), this.mRoot, aa.a(NoDataViewFactory.ImgType.NODATA), ab.t(z.no_chat_friends, z.no_chat_friends_tip), com.baidu.tbadk.core.view.z.a(new y(TbadkCoreApplication.m255getInst().getResources().getString(z.find_new_friend), new t(this))));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.w.progress);
        this.bca = (InviteFriendCandidateList) this.mRoot.findViewById(com.baidu.tieba.w.candidate_list);
        this.bca.a(new u(this));
        this.bcb = (LinearLayout) this.mRoot.findViewById(com.baidu.tieba.w.invite_candidate);
        this.bbZ = this.mRoot.findViewById(com.baidu.tieba.w.invite_candidate_border);
        if (this.bcf) {
            this.mNavigationBar.setTitleText(z.invite_contact_title);
            this.bcb.setVisibility(8);
            this.bbZ.setVisibility(8);
        } else {
            this.mNavigationBar.setTitleText(z.invite_friend);
        }
        OR();
        this.bcc = (Button) this.mRoot.findViewById(com.baidu.tieba.w.button_send);
        this.bcc.setOnClickListener(this.bbW);
        qL();
        OO();
        fT(0);
    }

    public void a(au auVar) {
        this.bbX.setHandler(auVar);
    }

    public void qL() {
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        this.bbW.getLayoutMode().ab(skinType == 1);
        this.bbW.getLayoutMode().h(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.bbW.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bbW.getPageContext(), skinType);
        this.bbW.getLayoutMode().h(this.bbX);
        this.bbX.onChangeSkinType(skinType);
        bc.i(this.bcd, com.baidu.tieba.v.invite_friend_list_item_bg_color);
        this.bcd.setEnabled(false);
    }

    public void OO() {
        this.mListView.setOnTouchListener(new v(this));
    }

    public int OP() {
        return this.bcc.getId();
    }

    public String getSearchText() {
        return this.bbX.getSearchText();
    }

    public String OQ() {
        return this.bca.OK();
    }

    public void a(List<com.baidu.tbadk.coreExtra.relationship.b> list, boolean z) {
        if (this.bbY == null) {
            this.bbY = new p(this.bbW, this.bcf);
            this.bbY.a(this);
            this.bbY.a(new w(this));
            this.mListView.setAdapter((ListAdapter) this.bbY);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.mListView.setVisibility(8);
            if (!this.bcf) {
                this.bcb.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.mListView.setVisibility(0);
        this.bbY.setData(list);
        this.bbY.notifyDataSetChanged();
        if (!this.bcf) {
            this.bcb.setVisibility(0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [255=4] */
    private void OR() {
        int dimensionPixelSize = this.bbW.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_height) + this.bbW.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_padding_bottom) + this.bbW.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_padding_top);
        this.bcd = new View(this.bbW.getPageContext().getPageActivity());
        this.bcd.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bcd.setEnabled(false);
        this.mListView.addFooterView(this.bcd);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.bca.d(bVar);
            fT(this.bca.getItemLength());
            OS();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.bca.f(bVar);
            fT(this.bca.getItemLength());
            OS();
        }
    }

    private void OS() {
        if (this.bca.getItemLength() > 0) {
            this.bcc.setEnabled(true);
        } else {
            this.bcc.setEnabled(false);
        }
    }

    public void OT() {
        com.baidu.adp.lib.util.l.c(this.bbW.getPageContext().getPageActivity(), this.bbX.getEditText());
    }

    private void fT(int i) {
        this.bcc.setText(String.format(this.bbW.getPageContext().getString(z.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public void startLoad() {
        this.mProgress.setVisibility(0);
    }

    public void OG() {
        this.mProgress.setVisibility(8);
    }

    public int OU() {
        return this.bce;
    }

    public void fU(int i) {
        this.bce = i;
        this.bca.setMaxCount(i);
    }

    @Override // com.baidu.tieba.im.friend.r
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.bca.e(bVar);
        }
    }
}
