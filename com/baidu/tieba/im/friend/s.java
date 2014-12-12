package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
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
    private final InviteFriendListActivity baB;
    private SearchBar baC;
    private p baD;
    private View baE;
    private InviteFriendCandidateList baF;
    private LinearLayout baG;
    private Button baH;
    private View baI;
    private int baJ;
    private boolean baK;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public s(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.baJ = 0;
        this.baB = inviteFriendListActivity;
        this.baK = z;
        initialize();
    }

    private void initialize() {
        this.baB.setContentView(com.baidu.tieba.x.invite_friend_list);
        this.mRoot = this.baB.findViewById(com.baidu.tieba.w.root_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.baC = (SearchBar) this.mRoot.findViewById(com.baidu.tieba.w.search_bar);
        this.baC.setOnClickListener(this.baB);
        this.baC.setHint(this.baB.getPageContext().getString(z.search));
        this.baC.setFocusable(true);
        this.baC.setFocusableInTouchMode(true);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mListView = (BdListView) this.mRoot.findViewById(com.baidu.tieba.w.friend_list);
        this.mListView.setOnItemClickListener(this.baB);
        if (this.baK) {
            this.mNoDataView = NoDataViewFactory.a(this.baB.getPageContext().getPageActivity(), this.mRoot, aa.a(NoDataViewFactory.ImgType.NODATA), ab.t(z.no_friends, z.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.baB.getPageContext().getPageActivity(), this.mRoot, aa.a(NoDataViewFactory.ImgType.NODATA), ab.t(z.no_chat_friends, z.no_chat_friends_tip), com.baidu.tbadk.core.view.z.a(new y(TbadkCoreApplication.m255getInst().getResources().getString(z.find_new_friend), new t(this))));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.w.progress);
        this.baF = (InviteFriendCandidateList) this.mRoot.findViewById(com.baidu.tieba.w.candidate_list);
        this.baF.a(new u(this));
        this.baG = (LinearLayout) this.mRoot.findViewById(com.baidu.tieba.w.invite_candidate);
        this.baE = this.mRoot.findViewById(com.baidu.tieba.w.invite_candidate_border);
        if (this.baK) {
            this.mNavigationBar.setTitleText(z.invite_contact_title);
            this.baG.setVisibility(8);
            this.baE.setVisibility(8);
        } else {
            this.mNavigationBar.setTitleText(z.invite_friend);
        }
        Ov();
        this.baH = (Button) this.mRoot.findViewById(com.baidu.tieba.w.button_send);
        this.baH.setOnClickListener(this.baB);
        qA();
        Os();
        fO(0);
    }

    public void a(au auVar) {
        this.baC.setHandler(auVar);
    }

    public void qA() {
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        this.baB.getLayoutMode().ab(skinType == 1);
        this.baB.getLayoutMode().h(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.baB.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.baB.getPageContext(), skinType);
        this.baB.getLayoutMode().h(this.baC);
        this.baC.onChangeSkinType(skinType);
        ax.i(this.baI, com.baidu.tieba.v.invite_friend_list_item_bg_color);
        this.baI.setEnabled(false);
    }

    public void Os() {
        this.mListView.setOnTouchListener(new v(this));
    }

    public int Ot() {
        return this.baH.getId();
    }

    public String getSearchText() {
        return this.baC.getSearchText();
    }

    public String Ou() {
        return this.baF.Oo();
    }

    public void a(List<com.baidu.tbadk.coreExtra.relationship.b> list, boolean z) {
        if (this.baD == null) {
            this.baD = new p(this.baB, this.baK);
            this.baD.a(this);
            this.baD.a(new w(this));
            this.mListView.setAdapter((ListAdapter) this.baD);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.mListView.setVisibility(8);
            if (!this.baK) {
                this.baG.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.mListView.setVisibility(0);
        this.baD.setData(list);
        this.baD.notifyDataSetChanged();
        if (!this.baK) {
            this.baG.setVisibility(0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [255=4] */
    private void Ov() {
        int dimensionPixelSize = this.baB.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_height) + this.baB.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_padding_bottom) + this.baB.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_padding_top);
        this.baI = new View(this.baB.getPageContext().getPageActivity());
        this.baI.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.baI.setEnabled(false);
        this.mListView.addFooterView(this.baI);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.baF.d(bVar);
            fO(this.baF.getItemLength());
            Ow();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.baF.f(bVar);
            fO(this.baF.getItemLength());
            Ow();
        }
    }

    private void Ow() {
        if (this.baF.getItemLength() > 0) {
            this.baH.setEnabled(true);
        } else {
            this.baH.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        com.baidu.adp.lib.util.l.c(this.baB.getPageContext().getPageActivity(), this.baC.getEditText());
    }

    private void fO(int i) {
        this.baH.setText(String.format(this.baB.getPageContext().getString(z.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public void startLoad() {
        this.mProgress.setVisibility(0);
    }

    public void Ok() {
        this.mProgress.setVisibility(8);
    }

    public int Ox() {
        return this.baJ;
    }

    public void fP(int i) {
        this.baJ = i;
        this.baF.setMaxCount(i);
    }

    @Override // com.baidu.tieba.im.friend.r
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.baF.e(bVar);
        }
    }
}
