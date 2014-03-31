package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SearchBar;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y extends com.baidu.adp.a.f implements x {
    private final InviteFriendListActivity a;
    private NavigationBar c;
    private View d;
    private SearchBar e;
    private BdListView f;
    private s g;
    private LinearLayout h;
    private ProgressBar i;
    private InviteFriendCandidateList j;
    private LinearLayout k;
    private Button l;
    private View m;
    private int n;
    private final com.baidu.tbadk.imageManager.d o;

    public y(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity);
        this.n = 0;
        this.o = new z(this);
        this.a = inviteFriendListActivity;
        this.a.setContentView(com.baidu.tieba.im.i.invite_friend_list);
        this.d = this.a.findViewById(com.baidu.tieba.im.h.root_view);
        this.c = (NavigationBar) this.d.findViewById(com.baidu.tieba.im.h.view_navigation_bar);
        this.c.a(com.baidu.tieba.im.j.invite_friend);
        this.e = (SearchBar) this.d.findViewById(com.baidu.tieba.im.h.search_bar);
        this.e.setOnClickListener(this.a);
        this.e.setHint(this.a.getString(com.baidu.tieba.im.j.search));
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = (BdListView) this.d.findViewById(com.baidu.tieba.im.h.friend_list);
        this.h = (LinearLayout) this.d.findViewById(com.baidu.tieba.im.h.no_data_container);
        this.i = (ProgressBar) this.d.findViewById(com.baidu.tieba.im.h.progress);
        this.j = (InviteFriendCandidateList) this.d.findViewById(com.baidu.tieba.im.h.candidate_list);
        this.j.a(new ab(this));
        this.k = (LinearLayout) this.d.findViewById(com.baidu.tieba.im.h.invite_candidate);
        int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.invite_friend_candidate_item_height) + this.a.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.invite_friend_candidate_padding_bottom) + this.a.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.invite_friend_candidate_padding_top);
        this.m = new View(this.a);
        this.m.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.f.addFooterView(this.m);
        this.l = (Button) this.d.findViewById(com.baidu.tieba.im.h.button_send);
        this.l.setOnClickListener(this.a);
        a();
        this.f.setOnScrollListener(new ac(this));
        this.f.setOnTouchListener(new ad(this));
        b(0);
    }

    public final void a(com.baidu.tbadk.coreExtra.view.ag agVar) {
        this.e.setHandler(agVar);
    }

    public final void a() {
        int l = TbadkApplication.j().l();
        this.a.getLayoutMode().a(l == 1);
        this.a.getLayoutMode().a(this.d);
        this.c.b(l);
        this.a.getLayoutMode().a(this.e);
        this.e.a(l);
        if (l == 1) {
            this.m.setBackgroundResource(com.baidu.tieba.im.g.invite_friend_list_item_bg_color_1);
        } else {
            this.m.setBackgroundResource(com.baidu.tieba.im.g.invite_friend_list_item_bg_color);
        }
    }

    public final void d() {
        com.baidu.tbadk.core.util.ac.a(this.f, this.g.a(), null, this.o, null, 0, 1);
    }

    public final int e() {
        return this.l.getId();
    }

    public final int f() {
        return this.e.getSearchButtonId();
    }

    public final String g() {
        return this.e.getSearchText();
    }

    public final String h() {
        return this.j.a();
    }

    public final void a(com.baidu.tieba.im.data.d dVar) {
        if (this.g == null) {
            this.g = new s(this.a);
            this.g.a(this);
            this.g.a(new ae(this));
            this.f.setAdapter((ListAdapter) this.g);
            this.j.a(this.g.a());
        }
        if (dVar != null) {
            ArrayList<com.baidu.tieba.im.data.c> a = dVar.a();
            if (!dVar.b() && (a == null || a.size() <= 0)) {
                this.h.setVisibility(0);
                this.f.setVisibility(8);
                this.k.setVisibility(8);
                return;
            }
            this.h.setVisibility(8);
            this.f.setVisibility(0);
            this.g.a(dVar.a());
            this.g.notifyDataSetChanged();
            this.k.setVisibility(0);
        }
    }

    public final void b(com.baidu.tieba.im.data.c cVar) {
        if (cVar != null) {
            this.j.a(cVar);
            b(this.j.b());
            m();
        }
    }

    public final void c(com.baidu.tieba.im.data.c cVar) {
        if (cVar != null) {
            this.j.c(cVar);
            b(this.j.b());
            m();
        }
    }

    private void m() {
        if (this.j.b() > 0) {
            this.l.setEnabled(true);
        } else {
            this.l.setEnabled(false);
        }
    }

    public final void i() {
        com.baidu.adp.lib.util.i.a(this.a, this.e.getEditText());
    }

    private void b(int i) {
        this.l.setText(String.format(this.a.getString(com.baidu.tieba.im.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public final void j() {
        this.i.setVisibility(0);
    }

    public final void k() {
        this.i.setVisibility(8);
    }

    public final int l() {
        return this.n;
    }

    public final void a(int i) {
        this.n = 100;
        this.j.a(100);
    }

    @Override // com.baidu.tieba.im.friend.x
    public final void a(com.baidu.tieba.im.data.c cVar) {
        if (cVar != null) {
            this.j.b(cVar);
        }
    }
}
