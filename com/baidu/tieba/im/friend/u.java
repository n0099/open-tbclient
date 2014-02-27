package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.SearchBar;
import com.baidu.tieba.view.ci;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class u extends com.baidu.adp.a.e implements t {
    private final InviteFriendListActivity a;
    private NavigationBar c;
    private View d;
    private SearchBar e;
    private BdListView f;
    private o g;
    private LinearLayout h;
    private ProgressBar i;
    private InviteFriendCandidateList j;
    private LinearLayout k;
    private Button l;
    private View m;
    private int n;
    private final com.baidu.tbadk.imageManager.d o;

    public u(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity);
        this.n = 0;
        this.o = new v(this);
        this.a = inviteFriendListActivity;
        this.a.setContentView(R.layout.invite_friend_list);
        this.d = this.a.findViewById(R.id.root_view);
        this.c = (NavigationBar) this.d.findViewById(R.id.view_navigation_bar);
        this.c.a(R.string.invite_friend);
        this.e = (SearchBar) this.d.findViewById(R.id.search_bar);
        this.e.setOnClickListener(this.a);
        this.e.setHint(this.a.getString(R.string.search));
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = (BdListView) this.d.findViewById(R.id.friend_list);
        this.h = (LinearLayout) this.d.findViewById(R.id.no_data_container);
        this.i = (ProgressBar) this.d.findViewById(R.id.progress);
        this.j = (InviteFriendCandidateList) this.d.findViewById(R.id.candidate_list);
        this.j.setItemOPerationHandler(new x(this));
        this.k = (LinearLayout) this.d.findViewById(R.id.invite_candidate);
        int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.invite_friend_candidate_item_height) + this.a.getResources().getDimensionPixelSize(R.dimen.invite_friend_candidate_padding_bottom) + this.a.getResources().getDimensionPixelSize(R.dimen.invite_friend_candidate_padding_top);
        this.m = new View(this.a);
        this.m.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.f.addFooterView(this.m);
        this.l = (Button) this.d.findViewById(R.id.button_send);
        this.l.setOnClickListener(this.a);
        a();
        this.f.setOnScrollListener(new y(this));
        this.f.setOnTouchListener(new z(this));
        b(0);
    }

    public final void a(ci ciVar) {
        this.e.setHandler(ciVar);
    }

    public final void a() {
        int ae = TiebaApplication.g().ae();
        this.a.getLayoutMode().a(ae == 1);
        this.a.getLayoutMode().a(this.d);
        this.c.b(ae);
        this.a.getLayoutMode().a(this.e);
        this.e.a(ae);
        if (ae == 1) {
            this.m.setBackgroundResource(R.drawable.invite_friend_list_item_bg_color_1);
        } else {
            this.m.setBackgroundResource(R.drawable.invite_friend_list_item_bg_color);
        }
    }

    public final void d() {
        ap.a(this.f, this.g.a(), null, this.o, null, 0, 1);
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
        return this.j.getDataList();
    }

    public final void a(com.baidu.tieba.im.data.e eVar) {
        if (this.g == null) {
            this.g = new o(this.a);
            this.g.a(this);
            this.g.a(new aa(this));
            this.f.setAdapter((ListAdapter) this.g);
            this.j.setImageLoader(this.g.a());
        }
        if (eVar != null) {
            ArrayList<com.baidu.tieba.im.data.d> a = eVar.a();
            if (!eVar.b() && (a == null || a.size() <= 0)) {
                this.h.setVisibility(0);
                this.f.setVisibility(8);
                this.k.setVisibility(8);
                return;
            }
            this.h.setVisibility(8);
            this.f.setVisibility(0);
            this.g.a(eVar.a());
            this.g.notifyDataSetChanged();
            this.k.setVisibility(0);
        }
    }

    public final void b(com.baidu.tieba.im.data.d dVar) {
        if (dVar != null) {
            this.j.a(dVar);
            b(this.j.getItemLength());
            m();
        }
    }

    public final void c(com.baidu.tieba.im.data.d dVar) {
        if (dVar != null) {
            this.j.c(dVar);
            b(this.j.getItemLength());
            m();
        }
    }

    private void m() {
        if (this.j.getItemLength() > 0) {
            this.l.setEnabled(true);
        } else {
            this.l.setEnabled(false);
        }
    }

    public final void i() {
        BdUtilHelper.a(this.a, this.e.getEditText());
    }

    private void b(int i) {
        this.l.setText(String.format(this.a.getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
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
        this.j.setMaxCount(100);
    }

    @Override // com.baidu.tieba.im.friend.t
    public final void a(com.baidu.tieba.im.data.d dVar) {
        if (dVar != null) {
            this.j.b(dVar);
        }
    }
}
