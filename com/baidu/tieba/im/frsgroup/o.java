package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public final class o extends com.baidu.adp.a.f {
    protected NavigationBar a;
    private GroupLevelActivity c;
    private View d;
    private View e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private TextView i;
    private TextView j;
    private ViewGroup k;
    private TextView l;
    private ProgressBar m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private ProgressBar t;
    private ImageView[] u;
    private TextView[] v;
    private TextView[] w;
    private String[] x;
    private Button y;
    private TextView z;

    public o(GroupLevelActivity groupLevelActivity) {
        super(groupLevelActivity);
        this.u = new ImageView[4];
        this.v = new TextView[4];
        this.w = new TextView[4];
        this.x = new String[4];
        this.a = null;
        this.c = groupLevelActivity;
        groupLevelActivity.setContentView(com.baidu.tieba.im.i.im_grouplevel_activity);
        this.d = groupLevelActivity.findViewById(com.baidu.tieba.im.h.parent);
        this.t = (ProgressBar) groupLevelActivity.findViewById(com.baidu.tieba.im.h.progress_loading);
        this.f = (ImageView) groupLevelActivity.findViewById(com.baidu.tieba.im.h.level_image_1);
        this.g = (ImageView) groupLevelActivity.findViewById(com.baidu.tieba.im.h.level_image_2);
        this.h = (ImageView) groupLevelActivity.findViewById(com.baidu.tieba.im.h.level_image_3);
        this.i = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.im.h.text_current_level);
        this.j = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.im.h.current_level);
        this.k = (ViewGroup) groupLevelActivity.findViewById(com.baidu.tieba.im.h.grouplevel_active);
        this.l = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.im.h.grouplevel_highest);
        this.m = (ProgressBar) groupLevelActivity.findViewById(com.baidu.tieba.im.h.active_progress);
        this.n = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.im.h.active_day_cur);
        this.o = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.im.h.active_day_total);
        this.p = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.im.h.active_condition);
        this.q = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.im.h.group_max1);
        this.r = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.im.h.group_max2);
        this.s = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.im.h.group_max3);
        this.w[1] = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.im.h.vgroup_max1);
        this.w[2] = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.im.h.vgroup_max2);
        this.w[3] = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.im.h.vgroup_max3);
        this.u[1] = this.f;
        this.u[2] = this.g;
        this.u[3] = this.h;
        this.x[1] = groupLevelActivity.getString(com.baidu.tieba.im.j.grouplevel_level_1);
        this.x[2] = groupLevelActivity.getString(com.baidu.tieba.im.j.grouplevel_level_2);
        this.x[3] = groupLevelActivity.getString(com.baidu.tieba.im.j.grouplevel_level_3);
        this.v[1] = this.q;
        this.v[2] = this.r;
        this.v[3] = this.s;
        this.a = (NavigationBar) groupLevelActivity.findViewById(com.baidu.tieba.im.h.grouplevel_top_bar);
        this.a.setSystemClickable(false);
        this.a.a(this.c.getResources().getString(com.baidu.tieba.im.j.grouplevel_title));
        this.e = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.y = (Button) groupLevelActivity.findViewById(com.baidu.tieba.im.h.upgrade_mem_group_btn);
        this.z = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.im.h.upgrade_mem_group_tip);
        this.e.setOnClickListener(this.c);
        this.y.setOnClickListener(this.c);
    }

    public final void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.i.setText(TbadkApplication.j().getString(com.baidu.tieba.im.j.grouplevel_vip_current_level));
            ba.a(this.i, com.baidu.tieba.im.e.group_level_promote, 1);
        } else {
            this.i.setText(TbadkApplication.j().getString(com.baidu.tieba.im.j.grouplevel_current_level));
            ba.a(this.i, com.baidu.tieba.im.e.group_level_secondtitle_text, 1);
        }
        if (z || !z2) {
            this.y.setVisibility(8);
            this.z.setVisibility(8);
            return;
        }
        this.y.setVisibility(0);
        this.z.setVisibility(0);
        if (z3 && i > 0) {
            this.y.setEnabled(true);
            string = String.format(TbadkApplication.j().getString(com.baidu.tieba.im.j.upgrade_mem_group_left_num), String.valueOf(i));
            ba.a(this.y, com.baidu.tieba.im.e.upgrade_mem_group_btn_text, 3);
            this.y.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.j().getString(com.baidu.tieba.im.j.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.j().getString(com.baidu.tieba.im.j.upgrade_mem_group_over_max_num);
            }
            this.y.setEnabled(false);
            ba.a(this.y, com.baidu.tieba.im.e.upgrade_mem_group_btn_cannotup_text, 3);
        }
        this.z.setText(string);
    }

    public final View a() {
        return this.e;
    }

    public final Button d() {
        return this.y;
    }

    public final void a(int i) {
        this.c.getLayoutMode().a(i == 1);
        this.c.getLayoutMode().a(this.d);
        this.a.b(i);
    }

    public final TextView[] e() {
        return this.v;
    }

    public final TextView[] f() {
        return this.w;
    }

    public final void a(boolean z) {
        this.t.setVisibility(z ? 0 : 8);
    }

    public final void a(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        int i3 = com.baidu.tieba.im.g.icon_grade_big_star_s;
        int i4 = com.baidu.tieba.im.g.icon_grade_big_star_n;
        int i5 = com.baidu.tieba.im.g.icon_vip_grade_big_star_s;
        int i6 = com.baidu.tieba.im.g.icon_vip_grade_big_star_n;
        while (i2 <= i) {
            if (z) {
                ba.c(this.u[i2], i5);
            } else {
                ba.c(this.u[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                ba.c(this.u[i2], i6);
            } else {
                ba.c(this.u[i2], i4);
            }
            i2++;
        }
        this.j.setText(this.x[i]);
    }

    public final TextView g() {
        return this.p;
    }

    public final void a(int i, int i2, int i3) {
        if (i > 0 && i <= 2) {
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            this.m.setProgress((int) ((i2 / i3) * 100.0f));
            String string = this.c.getString(com.baidu.tieba.im.j.grouplevel_active_day_value, new Object[]{String.valueOf(i3)});
            this.n.setText(String.valueOf(i2));
            this.o.setText(string);
        } else if (i >= 3) {
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            this.l.setText(com.baidu.tieba.im.j.grouplevel_highest_grade);
        }
    }
}
