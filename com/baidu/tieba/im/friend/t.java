package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.an;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.SearchBar;
import com.baidu.tieba.view.cb;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.a.e implements s {
    private InviteFriendListActivity a;
    private NoNetworkView c;
    private NavigationBar d;
    private View e;
    private ImageView f;
    private SearchBar g;
    private BdListView h;
    private o i;
    private LinearLayout j;
    private ProgressBar k;
    private InviteFriendCandidateList l;
    private LinearLayout m;
    private Button n;
    private View o;
    private int p;
    private com.baidu.tbadk.imageManager.c q;

    public t(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity);
        this.p = 0;
        this.q = new v(this);
        this.a = inviteFriendListActivity;
        o();
    }

    private void o() {
        this.a.setContentView(R.layout.invite_friend_list);
        this.e = this.a.findViewById(R.id.root_view);
        this.c = (NoNetworkView) this.e.findViewById(R.id.view_no_network);
        this.d = (NavigationBar) this.e.findViewById(R.id.view_navigation_bar);
        this.d.a(R.string.invite_friend);
        this.g = (SearchBar) this.e.findViewById(R.id.search_bar);
        this.g.setOnClickListener(this.a);
        this.g.setHint(this.a.getString(R.string.search));
        this.f = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.h = (BdListView) this.e.findViewById(R.id.friend_list);
        this.j = (LinearLayout) this.e.findViewById(R.id.no_data_container);
        this.k = (ProgressBar) this.e.findViewById(R.id.progress);
        this.l = (InviteFriendCandidateList) this.e.findViewById(R.id.candidate_list);
        this.l.setItemOPerationHandler(new u(this));
        this.m = (LinearLayout) this.e.findViewById(R.id.invite_candidate);
        p();
        this.n = (Button) this.e.findViewById(R.id.button_send);
        this.n.setOnClickListener(this.a);
        a();
        f();
        b(0);
    }

    public void a(cb cbVar) {
        this.g.setHandler(cbVar);
    }

    public void a() {
        int al = TiebaApplication.h().al();
        this.a.getLayoutMode().a(al == 1);
        this.a.getLayoutMode().a(this.e);
        this.d.c(al);
        this.a.getLayoutMode().a((View) this.g);
        this.g.a(al);
        if (al == 1) {
            this.o.setBackgroundResource(R.drawable.invite_friend_list_item_bg_color_1);
        } else {
            this.o.setBackgroundResource(R.drawable.invite_friend_list_item_bg_color);
        }
    }

    public void e() {
        an.a(this.h, this.i.a(), null, this.q, null, 0, 1);
    }

    public void f() {
        this.h.setOnScrollListener(new w(this));
        this.h.setOnTouchListener(new x(this));
    }

    public int g() {
        return this.n.getId();
    }

    public int h() {
        return this.g.getSearchButtonId();
    }

    public String i() {
        return this.g.getSearchText();
    }

    public String j() {
        return this.l.getDataList();
    }

    public void a(com.baidu.tieba.im.data.e eVar) {
        if (this.i == null) {
            this.i = new o(this.a);
            this.i.a(this);
            this.i.a(new y(this));
            this.h.setAdapter((ListAdapter) this.i);
            this.l.setImageLoader(this.i.a());
        }
        if (eVar != null) {
            ArrayList<com.baidu.tieba.im.data.d> a = eVar.a();
            if (!eVar.b() && (a == null || a.size() <= 0)) {
                this.j.setVisibility(0);
                this.h.setVisibility(8);
                this.m.setVisibility(8);
                return;
            }
            this.j.setVisibility(8);
            this.h.setVisibility(0);
            this.i.a(eVar.a());
            this.i.notifyDataSetChanged();
            this.m.setVisibility(0);
        }
    }

    private void p() {
        int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.invite_friend_candidate_item_height) + this.a.getResources().getDimensionPixelSize(R.dimen.invite_friend_candidate_padding_bottom) + this.a.getResources().getDimensionPixelSize(R.dimen.invite_friend_candidate_padding_top);
        this.o = new View(this.a);
        this.o.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.h.addFooterView(this.o);
    }

    public void a(com.baidu.tieba.im.data.d dVar) {
        if (dVar != null) {
            this.l.a(dVar);
            b(this.l.getItemLength());
            q();
        }
    }

    public void b(com.baidu.tieba.im.data.d dVar) {
        if (dVar != null) {
            this.l.c(dVar);
            b(this.l.getItemLength());
            q();
        }
    }

    private void q() {
        if (this.l.getItemLength() > 0) {
            this.n.setEnabled(true);
        } else {
            this.n.setEnabled(false);
        }
    }

    public void k() {
        com.baidu.adp.lib.g.g.a(this.a, this.g.getEditText());
    }

    private void b(int i) {
        this.n.setText(String.format(this.a.getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public void l() {
        this.k.setVisibility(0);
    }

    public void m() {
        this.k.setVisibility(8);
    }

    public int n() {
        return this.p;
    }

    public void a(int i) {
        this.p = i;
        this.l.setMaxCount(i);
    }

    @Override // com.baidu.tieba.im.friend.s
    public void a(View view, com.baidu.tieba.im.data.d dVar) {
        if (dVar != null) {
            this.l.b(dVar);
        }
    }
}
