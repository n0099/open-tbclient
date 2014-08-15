package com.baidu.tieba.game;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
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
    private GameCenterHomeActivity a;
    private View.OnClickListener b;
    private BdListView c;
    private View d;
    private TextView e;
    private TextView f;
    private View g;
    private View h;
    private TextView i;
    private LinearLayout j;
    private HorizontalScrollView k;
    private List<ab> m;
    private NavigationBar q;
    private LinearLayout r;
    private NoNetworkView s;
    private View t;
    private com.baidu.tieba.square.q p = null;
    private Handler u = new Handler();
    private com.baidu.adp.lib.guide.d v = null;
    private View.OnClickListener w = new o(this);
    private View.OnClickListener x = new p(this);
    private AdapterView.OnItemClickListener y = new q(this);
    private Runnable z = new r(this);
    private List<ab> l = new LinkedList();
    private List<AdList> n = new LinkedList();
    private t o = new t(this, null);

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        return com.baidu.tbadk.core.sharedPref.b.a().a(str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        com.baidu.tbadk.core.sharedPref.b.a().b(str, true);
    }

    public View a() {
        return this.t;
    }

    public View b() {
        return this.c;
    }

    public List<ab> c() {
        return this.l;
    }

    public List<ab> d() {
        return this.m;
    }

    public void a(int i) {
        this.q.c(0);
        if (this.s != null) {
            this.s.a(0);
        }
    }

    public void e() {
        i();
        if (this.o != null) {
            this.o.notifyDataSetChanged();
        }
    }

    public void f() {
        if (this.p != null) {
            this.p.a();
        }
    }

    public void g() {
        if (this.p != null) {
            this.p.b();
        }
    }

    private void h() {
        HashSet hashSet = new HashSet();
        if (this.n != null && this.n.size() > 0) {
            Iterator<AdList> it = this.n.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next().img_url)) {
                    it.remove();
                }
            }
        }
        hashSet.clear();
        if (this.m != null && this.m.size() > 0) {
            Iterator<ab> it2 = this.m.iterator();
            while (it2.hasNext()) {
                if (!hashSet.add(it2.next().a())) {
                    it2.remove();
                }
            }
        }
        if (this.l != null && this.l.size() > 0) {
            HashSet hashSet2 = new HashSet();
            Iterator<ab> it3 = this.l.iterator();
            while (it3.hasNext()) {
                if (!hashSet2.add(it3.next().a())) {
                    it3.remove();
                }
            }
            Iterator<ab> it4 = this.m.iterator();
            while (it4.hasNext()) {
                if (hashSet2.add(it4.next().a())) {
                    it4.remove();
                }
            }
            Iterator<ab> it5 = this.l.iterator();
            while (it5.hasNext()) {
                if (!hashSet.add(it5.next().a())) {
                    it5.remove();
                }
            }
        }
    }

    public void a(List<AdList> list, List<ab> list2, List<ab> list3) {
        this.n.addAll(list);
        this.l.addAll(list2);
        this.m = list3;
        h();
        if (this.n.size() >= 1) {
            this.p.setVisibility(0);
            ArrayList<ap> arrayList = new ArrayList<>();
            int size = this.n.size() > 5 ? 5 : this.n.size();
            for (int i = 0; i < size; i++) {
                ap apVar = new ap();
                apVar.a(this.n.get(i).img_url);
                apVar.b(this.n.get(i).link_url);
                arrayList.add(apVar);
            }
            this.p.a(arrayList);
        } else {
            this.p.getViewPagerBottomLine().setVisibility(8);
            this.p.a((ArrayList<ap>) null);
        }
        i();
        if ((this.m == null || this.m.size() == 0) && ((this.l == null || this.l.size() == 0) && (this.n == null || this.n.size() == 0))) {
            this.g.setVisibility(8);
            this.h.setVisibility(8);
            this.p.getViewPagerBottomLine().setVisibility(8);
        } else {
            this.g.setVisibility(0);
            this.h.setVisibility(0);
            this.p.getViewPagerBottomLine().setVisibility(0);
        }
        this.o.notifyDataSetChanged();
    }

    public n(GameCenterHomeActivity gameCenterHomeActivity, View.OnClickListener onClickListener) {
        this.a = gameCenterHomeActivity;
        this.b = onClickListener;
        k();
    }

    private void i() {
        String string = this.a.getResources().getString(com.baidu.tieba.x.game_center_undownload_num);
        if (this.l == null || this.l.size() == 0) {
            this.f.setText(String.format(string, 0));
            this.i.setVisibility(0);
            this.h.setVisibility(0);
        } else {
            this.i.setVisibility(8);
            this.h.setVisibility(0);
            this.f.setText(String.format(string, Integer.valueOf(this.l.size())));
        }
        if (this.m == null || this.m.size() == 0) {
            this.r.setVisibility(8);
            return;
        }
        this.r.setVisibility(0);
        this.e.setText(String.format(this.a.getResources().getString(com.baidu.tieba.x.game_center_download_num), Integer.valueOf(this.m.size())));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = com.baidu.adp.lib.util.j.c(this.a, com.baidu.tieba.s.ds30);
        layoutParams.rightMargin = com.baidu.adp.lib.util.j.c(this.a, com.baidu.tieba.s.ds30);
        LayoutInflater layoutInflater = this.a.getLayoutInflater();
        this.j.removeAllViews();
        for (int i = 0; i < this.m.size(); i++) {
            View inflate = layoutInflater.inflate(com.baidu.tieba.v.game_center_downloaded_item, (ViewGroup) null, false);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(com.baidu.tieba.u.game_center_downloaded_image);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.u.game_center_downloaded_game_name);
            tbImageView.a(this.m.get(i).d(), 10, false);
            tbImageView.setRadius(com.baidu.adp.lib.util.j.c(this.a, com.baidu.tieba.s.ds26));
            String b = this.m.get(i).b();
            if (com.baidu.tieba.game.a.a.a(b) > 14) {
                b = String.valueOf(com.baidu.tieba.game.a.a.a(b, 0, 14)) + "...";
            }
            textView.setText(b);
            inflate.setTag(Integer.valueOf(i));
            inflate.setOnClickListener(this.x);
            this.j.addView(inflate, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.a(this.q).a(0).b(false);
        gVar.a(new s(this));
        this.v = gVar.a();
        this.v.a(this.a);
        this.u.postDelayed(this.z, 3000L);
    }

    private void k() {
        this.s = (NoNetworkView) this.a.findViewById(com.baidu.tieba.u.view_no_network);
        this.c = (BdListView) this.a.findViewById(com.baidu.tieba.u.game_center_list);
        LayoutInflater layoutInflater = this.a.getLayoutInflater();
        this.p = new com.baidu.tieba.square.q(this.a, true);
        this.q = (NavigationBar) this.a.findViewById(com.baidu.tieba.u.game_center_navi);
        this.q.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.q.a(this.a.getResources().getString(com.baidu.tieba.x.game_center));
        this.c.addHeaderView(this.p);
        this.d = layoutInflater.inflate(com.baidu.tieba.v.game_center_header_below, (ViewGroup) null, false);
        this.r = (LinearLayout) this.d.findViewById(com.baidu.tieba.u.game_center_header_downloaded_part);
        this.k = (HorizontalScrollView) this.d.findViewById(com.baidu.tieba.u.game_center_horizontal_scrollview);
        this.e = (TextView) this.d.findViewById(com.baidu.tieba.u.game_center_header_download_num);
        this.f = (TextView) this.d.findViewById(com.baidu.tieba.u.game_center_header_undownload_num);
        this.g = this.d.findViewById(com.baidu.tieba.u.game_center_header_download_line);
        this.h = this.d.findViewById(com.baidu.tieba.u.game_center_header_undownload_line);
        this.i = (TextView) this.d.findViewById(com.baidu.tieba.u.waiting);
        this.j = (LinearLayout) this.d.findViewById(com.baidu.tieba.u.game_center_header_horizontal_view);
        this.c.addHeaderView(this.d);
        this.t = (RelativeLayout) layoutInflater.inflate(com.baidu.tieba.v.game_center_list_footer, (ViewGroup) this.c, false);
        this.t.setVisibility(8);
        this.c.addFooterView(this.t);
        this.c.setAdapter((ListAdapter) this.o);
        this.c.setOnSrollToBottomListener(this.a);
        this.c.setOnItemClickListener(this.y);
    }
}
