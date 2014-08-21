package com.baidu.tieba.game;

import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.base.f {
    private static SparseArray<ad> t = new SparseArray<>();
    private BaseActivity a;
    private NavigationBar b;
    private NoNetworkView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private y h;
    private HeadImageView i;
    private TextView j;
    private RelativeLayout k;
    private View l;
    private View m;
    private HorizontalListView n;
    private TextView o;
    private Handler p;
    private com.baidu.adp.lib.guide.d q;
    private com.baidu.tbadk.game.b r;
    private View s;
    private Runnable u;

    static {
        t.append(1, new ad(com.baidu.tieba.r.cp_cont_g, com.baidu.tieba.r.cp_cont_g_1, com.baidu.tieba.t.game_center_start_btn, com.baidu.tieba.t.game_center_start_btn_1, com.baidu.tieba.x.download_game));
        t.append(2, new ad(com.baidu.tieba.r.cp_link_tip_a, com.baidu.tieba.r.cp_link_tip_a_1, com.baidu.tieba.t.game_center_download_btn, com.baidu.tieba.t.game_center_download_btn_1, com.baidu.tieba.x.stop_download));
        t.append(3, new ad(com.baidu.tieba.r.cp_link_tip_a, com.baidu.tieba.r.cp_link_tip_a_1, com.baidu.tieba.t.game_center_download_btn, com.baidu.tieba.t.game_center_download_btn_1, com.baidu.tieba.x.continue_download));
        t.append(4, new ad(com.baidu.tieba.r.cp_cont_g, com.baidu.tieba.r.cp_cont_g_1, com.baidu.tieba.t.game_center_start_btn, com.baidu.tieba.t.game_center_start_btn_1, com.baidu.tieba.x.install_game));
        t.append(5, new ad(com.baidu.tieba.r.cp_cont_g, com.baidu.tieba.r.cp_cont_g_1, com.baidu.tieba.t.game_center_start_btn, com.baidu.tieba.t.game_center_start_btn_1, com.baidu.tieba.x.start_game));
    }

    public aa(BaseActivity baseActivity) {
        super(baseActivity);
        this.p = new Handler();
        this.q = null;
        this.u = new ab(this);
        this.a = baseActivity;
        this.a.setContentView(com.baidu.tieba.v.game_detail_activity);
        this.s = this.a.findViewById(com.baidu.tieba.u.game_detail_view);
        this.b = (NavigationBar) this.a.findViewById(com.baidu.tieba.u.game_detail_navigation_bar);
        this.b.a(this.a.getString(com.baidu.tieba.x.emotion_image_detail));
        this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c = (NoNetworkView) this.a.findViewById(com.baidu.tieba.u.game_detail_no_network);
        this.k = (RelativeLayout) this.a.findViewById(com.baidu.tieba.u.game_detail_info_container);
        this.l = this.a.findViewById(com.baidu.tieba.u.game_detail_title_divider);
        this.m = this.a.findViewById(com.baidu.tieba.u.game_detail_desc_divider);
        this.o = (TextView) this.a.findViewById(com.baidu.tieba.u.game_detail_game_desc_title_tv);
        this.i = (HeadImageView) this.a.findViewById(com.baidu.tieba.u.game_detail_icon);
        this.d = (TextView) this.a.findViewById(com.baidu.tieba.u.game_detail_name_tv);
        this.e = (TextView) this.a.findViewById(com.baidu.tieba.u.game_detail_game_size_tv);
        this.f = (TextView) this.a.findViewById(com.baidu.tieba.u.game_detail_player_number_tv);
        this.g = (TextView) this.a.findViewById(com.baidu.tieba.u.game_detail_game_desc_tv);
        this.j = (TextView) this.a.findViewById(com.baidu.tieba.u.game_detail_download_btn);
        this.j.setOnClickListener(this.a);
        this.n = (HorizontalListView) this.a.findViewById(com.baidu.tieba.u.game_detail_image_listview);
        this.h = new y();
        this.n.setAdapter((ListAdapter) this.h);
        this.k.setVisibility(8);
        this.l.setVisibility(8);
        this.m.setVisibility(8);
        this.o.setVisibility(8);
    }

    public void a() {
        if (this.r != null && ae.a().b(this.r)) {
            b();
        }
    }

    private void b() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.a(this.b).a(0).b(false);
        gVar.a(new ac(this));
        this.q = gVar.a();
        this.q.a(this.a);
        this.p.postDelayed(this.u, 3000L);
    }

    public void a(int i) {
        this.b.c(i);
        this.c.a(i);
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.s);
    }

    public void a(com.baidu.tbadk.game.b bVar) {
        int j;
        if (bVar.i() == 1) {
            this.j.setText(com.baidu.tieba.x.game_center_waiting);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                this.j.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_d_1));
                this.j.setBackgroundResource(com.baidu.tieba.t.btn_pass_d_1);
            } else {
                this.j.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_d));
                this.j.setBackgroundResource(com.baidu.tieba.t.btn_pass_d);
            }
            this.f.setVisibility(4);
            return;
        }
        this.f.setVisibility(0);
        if (bVar.c() == 2) {
            j = 5;
        } else {
            j = ae.a().j(bVar);
        }
        ad adVar = t.get(j);
        if (adVar != null) {
            this.j.setText(adVar.c);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                this.j.setTextColor(this.a.getResources().getColor(adVar.d));
                this.j.setBackgroundResource(adVar.e);
                return;
            }
            this.j.setTextColor(this.a.getResources().getColor(adVar.a));
            this.j.setBackgroundResource(adVar.b);
        }
    }

    public void b(com.baidu.tbadk.game.b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.a())) {
            this.a.showToast(com.baidu.tieba.x.game_detail_no_data);
            this.a.finish();
            return;
        }
        this.r = bVar;
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.i.a(bVar.d(), 10, false);
        String b = bVar.b();
        if (com.baidu.tieba.game.a.a.a(b) > 14) {
            b = String.valueOf(com.baidu.tieba.game.a.a.a(b, 0, 14)) + "...";
        }
        this.d.setText(b);
        if (bVar.c() == 1) {
            this.e.setText(new StringBuilder().append(bVar.g()).append("M"));
        }
        this.f.setText(this.a.getString(com.baidu.tieba.x.game_center_player_num, new Object[]{com.baidu.tieba.game.a.a.a(bVar.e())}));
        if (!TextUtils.isEmpty(bVar.p())) {
            this.m.setVisibility(0);
            this.o.setVisibility(0);
            if (bVar.p().length() > 80) {
                this.g.setText(String.valueOf(bVar.p().substring(0, 80)) + "...");
            } else {
                this.g.setText(bVar.p());
            }
        }
        if (bVar.j() != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(bVar.j());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (TextUtils.isEmpty((String) it.next())) {
                    it.remove();
                }
            }
            if (arrayList.size() == 0) {
                this.n.setVisibility(8);
                this.m.setVisibility(8);
            } else {
                this.n.setVisibility(0);
                this.m.setVisibility(0);
            }
            this.h.a(arrayList);
        } else {
            this.n.setVisibility(8);
            this.m.setVisibility(8);
        }
        this.h.notifyDataSetChanged();
        a(bVar);
    }
}
