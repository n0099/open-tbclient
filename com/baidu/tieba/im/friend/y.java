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
import com.baidu.tbadk.coreExtra.view.at;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.c implements x {
    private final InviteFriendListActivity a;
    private NavigationBar b;
    private View c;
    private SearchBar d;
    private BdListView e;
    private s f;
    private LinearLayout g;
    private ProgressBar h;
    private InviteFriendCandidateList i;
    private LinearLayout j;
    private Button k;
    private View l;
    private int m;
    private final com.baidu.tbadk.imageManager.d n;

    public y(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity);
        this.m = 0;
        this.n = new z(this);
        this.a = inviteFriendListActivity;
        l();
    }

    private void l() {
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
        this.i.a(new ab(this));
        this.j = (LinearLayout) this.c.findViewById(com.baidu.tieba.v.invite_candidate);
        m();
        this.k = (Button) this.c.findViewById(com.baidu.tieba.v.button_send);
        this.k.setOnClickListener(this.a);
        a();
        c();
        b(0);
    }

    public void a(at atVar) {
        this.d.setHandler(atVar);
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
    }

    public void b() {
        com.baidu.tbadk.core.util.ae.a(this.e, this.f.a(), null, this.n, null, 0, 1);
    }

    public void c() {
        this.e.setOnScrollListener(new ac(this));
        this.e.setOnTouchListener(new ad(this));
    }

    public int d() {
        return this.k.getId();
    }

    public int e() {
        return this.d.getSearchButtonId();
    }

    public String f() {
        return this.d.getSearchText();
    }

    public String g() {
        return this.i.a();
    }

    public void a(com.baidu.tieba.im.data.f fVar) {
        if (this.f == null) {
            this.f = new s(this.a);
            this.f.a(this);
            this.f.a(new ae(this));
            this.e.setAdapter((ListAdapter) this.f);
            this.i.a(this.f.a());
        }
        if (fVar != null) {
            ArrayList<com.baidu.tieba.im.data.e> a = fVar.a();
            if (!fVar.b() && (a == null || a.size() <= 0)) {
                this.g.setVisibility(0);
                this.e.setVisibility(8);
                this.j.setVisibility(8);
                return;
            }
            this.g.setVisibility(8);
            this.e.setVisibility(0);
            this.f.a(fVar.a());
            this.f.notifyDataSetChanged();
            this.j.setVisibility(0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [284=4] */
    private void m() {
        int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_height) + this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_bottom) + this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_top);
        this.l = new View(this.a);
        this.l.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.e.addFooterView(this.l);
    }

    public void a(com.baidu.tieba.im.data.e eVar) {
        if (eVar != null) {
            this.i.a(eVar);
            b(this.i.b());
            n();
        }
    }

    public void b(com.baidu.tieba.im.data.e eVar) {
        if (eVar != null) {
            this.i.c(eVar);
            b(this.i.b());
            n();
        }
    }

    private void n() {
        if (this.i.b() > 0) {
            this.k.setEnabled(true);
        } else {
            this.k.setEnabled(false);
        }
    }

    public void h() {
        com.baidu.adp.lib.util.k.a(this.a, this.d.getEditText());
    }

    private void b(int i) {
        this.k.setText(String.format(this.a.getString(com.baidu.tieba.y.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public void i() {
        this.h.setVisibility(0);
    }

    public void j() {
        this.h.setVisibility(8);
    }

    public int k() {
        return this.m;
    }

    public void a(int i) {
        this.m = i;
        this.i.a(i);
    }

    @Override // com.baidu.tieba.im.friend.x
    public void a(View view, com.baidu.tieba.im.data.e eVar) {
        if (eVar != null) {
            this.i.b(eVar);
        }
    }
}
