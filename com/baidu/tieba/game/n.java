package com.baidu.tieba.game;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.square.ap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.GetGameCenter.AdList;
/* loaded from: classes.dex */
public class n {
    private View a;
    private GameCenterHomeActivity b;
    private View.OnClickListener c;
    private BdListView d;
    private View e;
    private TextView f;
    private TextView g;
    private View h;
    private View i;
    private TextView j;
    private LinearLayout k;
    private HorizontalScrollView l;
    private NavigationBar r;
    private LinearLayout s;
    private NoNetworkView t;
    private View u;
    private boolean x;
    private com.baidu.tieba.square.q q = null;
    private Handler v = new Handler();
    private com.baidu.adp.lib.guide.d w = null;
    private View.OnClickListener y = new o(this);
    private View.OnClickListener z = new p(this);
    private AdapterView.OnItemClickListener A = new q(this);
    private Runnable B = new r(this);
    private List<com.baidu.tbadk.game.b> m = new LinkedList();
    private List<com.baidu.tbadk.game.b> n = new LinkedList();
    private List<AdList> o = new LinkedList();
    private t p = new t(this, null);

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        return com.baidu.tbadk.core.sharedPref.b.a().a(str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        com.baidu.tbadk.core.sharedPref.b.a().b(str, true);
    }

    public View a() {
        return this.u;
    }

    public View b() {
        return this.d;
    }

    public List<com.baidu.tbadk.game.b> c() {
        return this.m;
    }

    public List<com.baidu.tbadk.game.b> d() {
        return this.n;
    }

    public void a(int i) {
        this.r.c(i);
        if (this.t != null) {
            this.t.a(i);
        }
        this.b.getLayoutMode().a(i == 1);
        this.b.getLayoutMode().a(this.a);
        this.b.getLayoutMode().a(this.e);
        this.b.getLayoutMode().a(this.u);
        if (this.q != null) {
            this.q.a(i);
        }
    }

    public void e() {
        j();
        if (this.p != null) {
            this.p.notifyDataSetChanged();
        }
    }

    public void f() {
        if (this.m != null && this.m.size() != 0) {
            for (com.baidu.tbadk.game.b bVar : this.m) {
                if (ae.a().b(bVar)) {
                    k();
                    return;
                }
            }
        }
    }

    public void g() {
        if (this.q != null) {
            this.q.a();
        }
    }

    public void h() {
        if (this.q != null) {
            this.q.b();
        }
    }

    private void i() {
        HashSet hashSet = new HashSet();
        if (this.o != null && this.o.size() > 0) {
            Iterator<AdList> it = this.o.iterator();
            while (it.hasNext()) {
                AdList next = it.next();
                if (TextUtils.isEmpty(next.img_url) || TextUtils.isEmpty(next.link_url)) {
                    it.remove();
                }
            }
            Iterator<AdList> it2 = this.o.iterator();
            while (it2.hasNext()) {
                if (!hashSet.add(it2.next().img_url)) {
                    it2.remove();
                }
            }
        }
        hashSet.clear();
        if (this.n != null && this.n.size() > 0) {
            Iterator<com.baidu.tbadk.game.b> it3 = this.n.iterator();
            while (it3.hasNext()) {
                if (!hashSet.add(it3.next().a())) {
                    it3.remove();
                }
            }
        }
        if (this.m != null && this.m.size() > 0) {
            HashSet hashSet2 = new HashSet();
            Iterator<com.baidu.tbadk.game.b> it4 = this.m.iterator();
            while (it4.hasNext()) {
                if (!hashSet2.add(it4.next().a())) {
                    it4.remove();
                }
            }
            Iterator<com.baidu.tbadk.game.b> it5 = this.n.iterator();
            while (it5.hasNext()) {
                if (hashSet2.add(it5.next().a())) {
                    it5.remove();
                }
            }
            Iterator<com.baidu.tbadk.game.b> it6 = this.m.iterator();
            while (it6.hasNext()) {
                if (!hashSet.add(it6.next().a())) {
                    it6.remove();
                }
            }
        }
    }

    public void a(List<AdList> list, List<com.baidu.tbadk.game.b> list2, List<com.baidu.tbadk.game.b> list3) {
        a(list, list2, list3, false);
    }

    public void b(List<AdList> list, List<com.baidu.tbadk.game.b> list2, List<com.baidu.tbadk.game.b> list3) {
        a(list, list2, list3, true);
    }

    private void a(List<AdList> list, List<com.baidu.tbadk.game.b> list2, List<com.baidu.tbadk.game.b> list3, boolean z) {
        if (this.x) {
            this.o.clear();
            this.m.clear();
            if (this.n != null) {
                this.n.clear();
            }
        }
        if (list != null) {
            this.o.addAll(list);
        }
        if (list2 != null) {
            this.m.addAll(list2);
        }
        if (list3 != null) {
            this.n.addAll(list3);
        }
        if ((this.n == null || this.n.size() == 0) && ((this.m == null || this.m.size() == 0) && (this.o == null || this.o.size() == 0))) {
            this.d.setVisibility(8);
            return;
        }
        this.d.setVisibility(0);
        this.h.setVisibility(0);
        this.i.setVisibility(0);
        this.q.getViewPagerBottomLine().setVisibility(0);
        i();
        this.x = z;
        if (this.o.size() >= 1) {
            this.q.setVisibility(0);
            ArrayList<ap> arrayList = new ArrayList<>();
            int size = this.o.size() > 5 ? 5 : this.o.size();
            for (int i = 0; i < size; i++) {
                ap apVar = new ap();
                apVar.a(this.o.get(i).img_url);
                apVar.b(this.o.get(i).link_url);
                arrayList.add(apVar);
            }
            this.q.a(arrayList);
        } else {
            this.q.getViewPagerBottomLine().setVisibility(8);
            this.q.a((ArrayList<ap>) null);
        }
        j();
        this.p.notifyDataSetChanged();
    }

    public n(GameCenterHomeActivity gameCenterHomeActivity, View.OnClickListener onClickListener) {
        this.b = gameCenterHomeActivity;
        this.c = onClickListener;
        l();
    }

    private void j() {
        String string = this.b.getResources().getString(com.baidu.tieba.x.game_center_undownload_num);
        if (this.m == null || this.m.size() == 0) {
            this.g.setText(String.format(string, 0));
            this.j.setVisibility(0);
            this.i.setVisibility(0);
        } else {
            this.j.setVisibility(8);
            this.i.setVisibility(0);
            this.g.setText(String.format(string, Integer.valueOf(this.m.size())));
        }
        if (this.n == null || this.n.size() == 0) {
            this.s.setVisibility(8);
            return;
        }
        this.s.setVisibility(0);
        this.f.setText(String.format(this.b.getResources().getString(com.baidu.tieba.x.game_center_download_num), Integer.valueOf(this.n.size())));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = com.baidu.adp.lib.util.j.c(this.b, com.baidu.tieba.s.ds30);
        layoutParams.rightMargin = com.baidu.adp.lib.util.j.c(this.b, com.baidu.tieba.s.ds30);
        this.k.removeAllViews();
        for (int i = 0; i < this.n.size(); i++) {
            View a = com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.game_center_downloaded_item, null, false);
            TbImageView tbImageView = (TbImageView) a.findViewById(com.baidu.tieba.u.game_center_downloaded_image);
            TextView textView = (TextView) a.findViewById(com.baidu.tieba.u.game_center_downloaded_game_name);
            tbImageView.a(this.n.get(i).d(), 10, false);
            tbImageView.setDrawerType(1);
            tbImageView.setRadius(com.baidu.adp.lib.util.j.c(this.b, com.baidu.tieba.s.ds26));
            String b = this.n.get(i).b();
            if (com.baidu.tieba.game.a.a.a(b) > 14) {
                b = String.valueOf(com.baidu.tieba.game.a.a.a(b, 0, 14)) + "...";
            }
            textView.setText(b);
            a.setTag(Integer.valueOf(i));
            a.setOnClickListener(this.z);
            a(a);
            this.k.addView(a, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.a(this.r).a(0).b(false);
        gVar.a(new s(this));
        this.w = gVar.a();
        this.w.a(this.b);
        this.v.postDelayed(this.B, 3000L);
    }

    private void l() {
        this.a = this.b.findViewById(com.baidu.tieba.u.game_center_home_view);
        this.t = (NoNetworkView) this.b.findViewById(com.baidu.tieba.u.view_no_network);
        this.d = (BdListView) this.b.findViewById(com.baidu.tieba.u.game_center_list);
        this.q = new com.baidu.tieba.square.q(this.b, true);
        this.r = (NavigationBar) this.b.findViewById(com.baidu.tieba.u.game_center_navi);
        this.r.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.r.a(this.b.getResources().getString(com.baidu.tieba.x.game_center));
        this.d.addHeaderView(this.q);
        this.e = com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.game_center_header_below, null, false);
        this.s = (LinearLayout) this.e.findViewById(com.baidu.tieba.u.game_center_header_downloaded_part);
        this.l = (HorizontalScrollView) this.e.findViewById(com.baidu.tieba.u.game_center_horizontal_scrollview);
        this.f = (TextView) this.e.findViewById(com.baidu.tieba.u.game_center_header_download_num);
        this.g = (TextView) this.e.findViewById(com.baidu.tieba.u.game_center_header_undownload_num);
        this.h = this.e.findViewById(com.baidu.tieba.u.game_center_header_download_line);
        this.i = this.e.findViewById(com.baidu.tieba.u.game_center_header_undownload_line);
        this.j = (TextView) this.e.findViewById(com.baidu.tieba.u.waiting);
        this.k = (LinearLayout) this.e.findViewById(com.baidu.tieba.u.game_center_header_horizontal_view);
        this.d.addHeaderView(this.e);
        this.u = (RelativeLayout) com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.game_center_list_footer, this.d, false);
        this.u.setVisibility(8);
        this.d.addFooterView(this.u);
        this.d.setAdapter((ListAdapter) this.p);
        this.d.setOnSrollToBottomListener(this.b);
        this.d.setOnItemClickListener(this.A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        this.b.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.b.getLayoutMode().a(view);
    }
}
