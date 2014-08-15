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
import com.baidu.tbadk.coreExtra.view.au;
import com.baidu.tieba.x;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.f implements r {
    private final InviteFriendListActivity a;
    private NavigationBar b;
    private View c;
    private SearchBar d;
    private BdListView e;
    private p f;
    private LinearLayout g;
    private ProgressBar h;
    private View i;
    private InviteFriendCandidateList j;
    private LinearLayout k;
    private Button l;
    private View m;
    private int n;
    private boolean o;

    public s(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity);
        this.n = 0;
        this.a = inviteFriendListActivity;
        this.o = z;
        j();
    }

    private void j() {
        this.a.setContentView(com.baidu.tieba.v.invite_friend_list);
        this.c = this.a.findViewById(com.baidu.tieba.u.root_view);
        this.b = (NavigationBar) this.c.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.d = (SearchBar) this.c.findViewById(com.baidu.tieba.u.search_bar);
        this.d.setOnClickListener(this.a);
        this.d.setHint(this.a.getString(x.search));
        this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = (BdListView) this.c.findViewById(com.baidu.tieba.u.friend_list);
        this.e.setOnItemClickListener(this.a);
        this.g = (LinearLayout) this.c.findViewById(com.baidu.tieba.u.no_data_container);
        this.h = (ProgressBar) this.c.findViewById(com.baidu.tieba.u.progress);
        this.j = (InviteFriendCandidateList) this.c.findViewById(com.baidu.tieba.u.candidate_list);
        this.j.a(new t(this));
        this.k = (LinearLayout) this.c.findViewById(com.baidu.tieba.u.invite_candidate);
        this.i = this.c.findViewById(com.baidu.tieba.u.invite_candidate_border);
        if (this.o) {
            this.b.a(x.invite_contact_title);
            this.k.setVisibility(8);
            this.i.setVisibility(8);
        } else {
            this.b.a(x.invite_friend);
        }
        k();
        this.l = (Button) this.c.findViewById(com.baidu.tieba.u.button_send);
        this.l.setOnClickListener(this.a);
        a();
        b();
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
            this.m.setBackgroundResource(com.baidu.tieba.t.invite_friend_list_item_bg_color_1);
        } else {
            this.m.setBackgroundResource(com.baidu.tieba.t.invite_friend_list_item_bg_color);
        }
        this.m.setEnabled(false);
    }

    public void b() {
        this.e.setOnTouchListener(new u(this));
    }

    public int c() {
        return this.l.getId();
    }

    public String d() {
        return this.d.getSearchText();
    }

    public String e() {
        return this.j.a();
    }

    public void a(List<com.baidu.tbadk.coreExtra.relationship.b> list, boolean z) {
        if (this.f == null) {
            this.f = new p(this.a, this.o);
            this.f.a(this);
            this.f.a(new v(this));
            this.e.setAdapter((ListAdapter) this.f);
        }
        if (!z && list.isEmpty()) {
            this.g.setVisibility(0);
            this.e.setVisibility(8);
            if (!this.o) {
                this.k.setVisibility(8);
                return;
            }
            return;
        }
        this.g.setVisibility(8);
        this.e.setVisibility(0);
        this.f.a(list);
        this.f.notifyDataSetChanged();
        if (!this.o) {
            this.k.setVisibility(0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [217=4] */
    private void k() {
        int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.invite_friend_candidate_item_height) + this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.invite_friend_candidate_padding_bottom) + this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.invite_friend_candidate_padding_top);
        this.m = new View(this.a);
        this.m.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.m.setEnabled(false);
        this.e.addFooterView(this.m);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.j.a(bVar);
            b(this.j.b());
            l();
        }
    }

    public void b(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.j.c(bVar);
            b(this.j.b());
            l();
        }
    }

    private void l() {
        if (this.j.b() > 0) {
            this.l.setEnabled(true);
        } else {
            this.l.setEnabled(false);
        }
    }

    public void f() {
        com.baidu.adp.lib.util.j.a(this.a, this.d.getEditText());
    }

    private void b(int i) {
        this.l.setText(String.format(this.a.getString(x.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public void g() {
        this.h.setVisibility(0);
    }

    public void h() {
        this.h.setVisibility(8);
    }

    public int i() {
        return this.n;
    }

    public void a(int i) {
        this.n = i;
        this.j.a(i);
    }

    @Override // com.baidu.tieba.im.friend.r
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.j.b(bVar);
        }
    }
}
