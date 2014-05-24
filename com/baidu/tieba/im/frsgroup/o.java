package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.c {
    protected NavigationBar a;
    private GroupLevelActivity b;
    private View c;
    private View d;
    private ImageView e;
    private ImageView f;
    private ImageView g;
    private TextView h;
    private TextView i;
    private ViewGroup j;
    private TextView k;
    private ProgressBar l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private ProgressBar s;
    private ImageView[] t;
    private TextView[] u;
    private TextView[] v;
    private String[] w;
    private Button x;
    private TextView y;

    public o(GroupLevelActivity groupLevelActivity) {
        super(groupLevelActivity);
        this.t = new ImageView[4];
        this.u = new TextView[4];
        this.v = new TextView[4];
        this.w = new String[4];
        this.a = null;
        this.b = groupLevelActivity;
        groupLevelActivity.setContentView(com.baidu.tieba.w.im_grouplevel_activity);
        b(groupLevelActivity);
        a(groupLevelActivity);
    }

    private void a(GroupLevelActivity groupLevelActivity) {
        this.d.setOnClickListener(this.b);
        this.x.setOnClickListener(this.b);
    }

    private void b(GroupLevelActivity groupLevelActivity) {
        this.c = groupLevelActivity.findViewById(com.baidu.tieba.v.parent);
        this.s = (ProgressBar) groupLevelActivity.findViewById(com.baidu.tieba.v.progress_loading);
        this.e = (ImageView) groupLevelActivity.findViewById(com.baidu.tieba.v.level_image_1);
        this.f = (ImageView) groupLevelActivity.findViewById(com.baidu.tieba.v.level_image_2);
        this.g = (ImageView) groupLevelActivity.findViewById(com.baidu.tieba.v.level_image_3);
        this.h = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.text_current_level);
        this.i = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.current_level);
        this.j = (ViewGroup) groupLevelActivity.findViewById(com.baidu.tieba.v.grouplevel_active);
        this.k = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.grouplevel_highest);
        this.l = (ProgressBar) groupLevelActivity.findViewById(com.baidu.tieba.v.active_progress);
        this.m = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.active_day_cur);
        this.n = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.active_day_total);
        this.o = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.active_condition);
        this.p = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.group_max1);
        this.q = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.group_max2);
        this.r = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.group_max3);
        this.v[1] = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.vgroup_max1);
        this.v[2] = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.vgroup_max2);
        this.v[3] = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.vgroup_max3);
        this.t[1] = this.e;
        this.t[2] = this.f;
        this.t[3] = this.g;
        this.w[1] = groupLevelActivity.getString(com.baidu.tieba.y.grouplevel_level_1);
        this.w[2] = groupLevelActivity.getString(com.baidu.tieba.y.grouplevel_level_2);
        this.w[3] = groupLevelActivity.getString(com.baidu.tieba.y.grouplevel_level_3);
        this.u[1] = this.p;
        this.u[2] = this.q;
        this.u[3] = this.r;
        this.a = (NavigationBar) groupLevelActivity.findViewById(com.baidu.tieba.v.grouplevel_top_bar);
        this.a.setSystemClickable(false);
        this.a.a(this.b.getResources().getString(com.baidu.tieba.y.grouplevel_title));
        this.d = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.x = (Button) groupLevelActivity.findViewById(com.baidu.tieba.v.upgrade_mem_group_btn);
        this.y = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.upgrade_mem_group_tip);
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.h.setText(TbadkApplication.m252getInst().getString(com.baidu.tieba.y.grouplevel_vip_current_level));
            bc.a(this.h, com.baidu.tieba.s.group_level_promote, 1);
        } else {
            this.h.setText(TbadkApplication.m252getInst().getString(com.baidu.tieba.y.grouplevel_current_level));
            bc.a(this.h, com.baidu.tieba.s.group_level_secondtitle_text, 1);
        }
        if (z || !z2) {
            this.x.setVisibility(8);
            this.y.setVisibility(8);
            return;
        }
        this.x.setVisibility(0);
        this.y.setVisibility(0);
        if (z3 && i > 0) {
            this.x.setEnabled(true);
            string = String.format(TbadkApplication.m252getInst().getString(com.baidu.tieba.y.upgrade_mem_group_left_num), String.valueOf(i));
            bc.a(this.x, com.baidu.tieba.s.upgrade_mem_group_btn_text, 3);
            this.x.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.m252getInst().getString(com.baidu.tieba.y.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.m252getInst().getString(com.baidu.tieba.y.upgrade_mem_group_over_max_num);
            }
            this.x.setEnabled(false);
            bc.a(this.x, com.baidu.tieba.s.upgrade_mem_group_btn_cannotup_text, 3);
        }
        this.y.setText(string);
    }

    public View a() {
        return this.d;
    }

    public Button b() {
        return this.x;
    }

    public void a(int i) {
        this.b.getLayoutMode().a(i == 1);
        this.b.getLayoutMode().a(this.c);
        this.a.c(i);
    }

    public TextView[] c() {
        return this.u;
    }

    public TextView[] d() {
        return this.v;
    }

    public void a(boolean z) {
        this.s.setVisibility(z ? 0 : 8);
    }

    public void a(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        int i3 = com.baidu.tieba.u.icon_grade_big_star_s;
        int i4 = com.baidu.tieba.u.icon_grade_big_star_n;
        int i5 = com.baidu.tieba.u.icon_vip_grade_big_star_s;
        int i6 = com.baidu.tieba.u.icon_vip_grade_big_star_n;
        while (i2 <= i) {
            if (z) {
                bc.c(this.t[i2], i5);
            } else {
                bc.c(this.t[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                bc.c(this.t[i2], i6);
            } else {
                bc.c(this.t[i2], i4);
            }
            i2++;
        }
        this.i.setText(this.w[i]);
    }

    public TextView e() {
        return this.o;
    }

    public void a(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.j.setVisibility(0);
            this.k.setVisibility(8);
            this.l.setProgress((int) ((i2 / i3) * 100.0f));
            String string = this.b.getString(com.baidu.tieba.y.grouplevel_active_day_value, new Object[]{String.valueOf(i3)});
            this.m.setText(String.valueOf(i2));
            this.n.setText(string);
        } else if (i >= 3) {
            this.j.setVisibility(8);
            this.k.setVisibility(0);
            this.k.setText(com.baidu.tieba.y.grouplevel_highest_grade);
        }
    }
}
