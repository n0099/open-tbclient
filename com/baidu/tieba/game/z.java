package com.baidu.tieba.game;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.base.f {
    private static SparseArray<aa> p = new SparseArray<>();
    private BaseActivity a;
    private NavigationBar b;
    private NoNetworkView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private x h;
    private HeadImageView i;
    private TextView j;
    private RelativeLayout k;
    private View l;
    private View m;
    private HorizontalListView n;
    private TextView o;

    static {
        p.append(1, new aa(com.baidu.tieba.r.cp_cont_g, com.baidu.tieba.t.game_center_start_btn, com.baidu.tieba.x.download_game));
        p.append(2, new aa(com.baidu.tieba.r.cp_link_tip_a, com.baidu.tieba.t.game_center_download_btn, com.baidu.tieba.x.stop_download));
        p.append(3, new aa(com.baidu.tieba.r.cp_link_tip_a, com.baidu.tieba.t.game_center_download_btn, com.baidu.tieba.x.continue_download));
        p.append(4, new aa(com.baidu.tieba.r.cp_cont_g, com.baidu.tieba.t.game_center_start_btn, com.baidu.tieba.x.install_game));
        p.append(5, new aa(com.baidu.tieba.r.cp_cont_g, com.baidu.tieba.t.game_center_start_btn, com.baidu.tieba.x.start_game));
    }

    public z(BaseActivity baseActivity) {
        super(baseActivity);
        this.a = baseActivity;
        this.a.setContentView(com.baidu.tieba.v.game_detail_activity);
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
        this.h = new x();
        this.n.setAdapter((ListAdapter) this.h);
        this.k.setVisibility(8);
        this.l.setVisibility(8);
        this.m.setVisibility(8);
        this.o.setVisibility(8);
    }

    public void a(int i) {
        this.b.c(i);
        this.c.a(i);
    }

    public void a(ab abVar) {
        int j;
        if (abVar.i() == 1) {
            this.j.setText(com.baidu.tieba.x.game_center_waiting);
            this.j.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_d));
            this.j.setBackgroundResource(com.baidu.tieba.t.btn_pass_d);
            this.f.setVisibility(4);
            return;
        }
        this.f.setVisibility(0);
        if (abVar.c() == 2) {
            j = 5;
        } else {
            j = ac.a().j(abVar);
        }
        aa aaVar = p.get(j);
        if (aaVar != null) {
            this.j.setText(aaVar.c);
            this.j.setTextColor(this.a.getResources().getColor(aaVar.a));
            this.j.setBackgroundResource(aaVar.b);
        }
    }

    public void b(ab abVar) {
        if (abVar == null || TextUtils.isEmpty(abVar.a())) {
            this.a.showToast(com.baidu.tieba.x.game_detail_no_data);
            this.a.finish();
            return;
        }
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.i.a(abVar.d(), 10, false);
        String b = abVar.b();
        if (com.baidu.tieba.game.a.a.a(b) > 14) {
            b = String.valueOf(com.baidu.tieba.game.a.a.a(b, 0, 14)) + "...";
        }
        this.d.setText(b);
        if (abVar.c() == 1) {
            this.e.setText(new StringBuilder().append(abVar.g()).append("M"));
        }
        this.f.setText(this.a.getString(com.baidu.tieba.x.game_center_player_num, new Object[]{com.baidu.tieba.game.a.a.a(abVar.e())}));
        if (!TextUtils.isEmpty(abVar.p())) {
            this.m.setVisibility(0);
            this.o.setVisibility(0);
            this.g.setText(abVar.p());
        }
        this.h.a(abVar.j());
        if (abVar.j() != null) {
            if (abVar.j().size() == 0) {
                this.n.setVisibility(8);
                this.m.setVisibility(8);
            } else {
                this.n.setVisibility(0);
                this.m.setVisibility(0);
            }
        } else {
            this.n.setVisibility(8);
            this.m.setVisibility(8);
        }
        this.h.notifyDataSetChanged();
        a(abVar);
    }
}
