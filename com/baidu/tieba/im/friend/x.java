package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SearchBar;
import com.baidu.tbadk.coreExtra.view.au;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.adp.base.f implements w {
    private final InviteFriendListActivity a;
    private NavigationBar b;
    private View c;
    private SearchBar d;
    private BdListView e;
    private r f;
    private LinearLayout g;
    private ProgressBar h;
    private InviteFriendCandidateList i;
    private LinearLayout j;
    private Button k;
    private View l;
    private int m;
    private final com.baidu.tbadk.imageManager.d n;

    public x(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity);
        this.m = 0;
        this.n = new y(this);
        this.a = inviteFriendListActivity;
        k();
    }

    private void k() {
        this.a.setContentView(com.baidu.tieba.w.invite_friend_list);
        this.c = this.a.findViewById(com.baidu.tieba.v.root_view);
        this.b = (NavigationBar) this.c.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.b.a(com.baidu.tieba.y.invite_friend);
        this.d = (SearchBar) this.c.findViewById(com.baidu.tieba.v.search_bar);
        this.d.setOnClickListener(this.a);
        this.d.setHint(this.a.getString(com.baidu.tieba.y.search));
        this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = (BdListView) this.c.findViewById(com.baidu.tieba.v.friend_list);
        this.g = (LinearLayout) this.c.findViewById(com.baidu.tieba.v.no_data_container);
        this.h = (ProgressBar) this.c.findViewById(com.baidu.tieba.v.progress);
        this.i = (InviteFriendCandidateList) this.c.findViewById(com.baidu.tieba.v.candidate_list);
        this.i.a(new aa(this));
        this.j = (LinearLayout) this.c.findViewById(com.baidu.tieba.v.invite_candidate);
        l();
        this.k = (Button) this.c.findViewById(com.baidu.tieba.v.button_send);
        this.k.setOnClickListener(this.a);
        a();
        c();
        b(0);
    }

    public void a(au auVar) {
        this.d.setHandler(auVar);
    }

    public void a() {
        int skinType = TbadkApplication.m252getInst().getSkinType();
        this.a.getLayoutMode().a(skinType == 1);
        this.a.getLayoutMode().a(this.c);
        this.b.c(skinType);
        this.a.getLayoutMode().a((View) this.d);
        this.d.a(skinType);
        if (skinType == 1) {
            this.l.setBackgroundResource(com.baidu.tieba.u.invite_friend_list_item_bg_color_1);
        } else {
            this.l.setBackgroundResource(com.baidu.tieba.u.invite_friend_list_item_bg_color);
        }
        this.l.setEnabled(false);
    }

    public void b() {
        aj.a(this.e, this.f.a(), null, this.n, null, 0, 1);
    }

    public void c() {
        this.e.setOnScrollListener(new ab(this));
        this.e.setOnTouchListener(new ac(this));
    }

    public int d() {
        return this.k.getId();
    }

    public String e() {
        return this.d.getSearchText();
    }

    public String f() {
        return this.i.a();
    }

    public void a(List<com.baidu.tbadk.coreExtra.relationship.b> list, boolean z) {
        if (this.f == null) {
            this.f = new r(this.a);
            this.f.a(this);
            this.f.a(new ad(this));
            this.e.setAdapter((ListAdapter) this.f);
            this.i.a(this.f.a());
        }
        if (!z && list.isEmpty()) {
            this.g.setVisibility(0);
            this.e.setVisibility(8);
            this.j.setVisibility(8);
            return;
        }
        this.g.setVisibility(8);
        this.e.setVisibility(0);
        this.f.a(list);
        this.f.notifyDataSetChanged();
        this.j.setVisibility(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [277=4] */
    private void l() {
        int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_height) + this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_bottom) + this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_top);
        this.l = new View(this.a);
        this.l.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.l.setEnabled(false);
        this.e.addFooterView(this.l);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.i.a(bVar);
            b(this.i.b());
            m();
        }
    }

    public void b(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.i.c(bVar);
            b(this.i.b());
            m();
        }
    }

    private void m() {
        if (this.i.b() > 0) {
            this.k.setEnabled(true);
        } else {
            this.k.setEnabled(false);
        }
    }

    public void g() {
        com.baidu.adp.lib.util.j.a(this.a, this.d.getEditText());
    }

    private void b(int i) {
        this.k.setText(String.format(this.a.getString(com.baidu.tieba.y.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public void h() {
        this.h.setVisibility(0);
    }

    public void i() {
        this.h.setVisibility(8);
    }

    public int j() {
        return this.m;
    }

    public void a(int i) {
        this.m = i;
        this.i.a(i);
    }

    @Override // com.baidu.tieba.im.friend.w
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.i.b(bVar);
        }
    }
}
