package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bq;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.a.e {
    protected NavigationBar a;
    private GroupLevelActivity c;
    private View d;
    private ImageView e;
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

    public m(GroupLevelActivity groupLevelActivity) {
        super(groupLevelActivity);
        this.u = new ImageView[4];
        this.v = new TextView[4];
        this.w = new TextView[4];
        this.x = new String[4];
        this.a = null;
        this.c = groupLevelActivity;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        b(groupLevelActivity);
        a(groupLevelActivity);
    }

    private void a(GroupLevelActivity groupLevelActivity) {
        this.e.setOnClickListener(this.c);
        this.y.setOnClickListener(this.c);
    }

    private void b(GroupLevelActivity groupLevelActivity) {
        this.d = groupLevelActivity.findViewById(R.id.parent);
        this.t = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.f = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.g = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.h = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.i = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.j = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.k = (ViewGroup) groupLevelActivity.findViewById(R.id.grouplevel_active);
        this.l = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.m = (ProgressBar) groupLevelActivity.findViewById(R.id.active_progress);
        this.n = (TextView) groupLevelActivity.findViewById(R.id.active_day_cur);
        this.o = (TextView) groupLevelActivity.findViewById(R.id.active_day_total);
        this.p = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.q = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.r = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.s = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.w[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.w[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.w[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.u[1] = this.f;
        this.u[2] = this.g;
        this.u[3] = this.h;
        this.x[1] = groupLevelActivity.getString(R.string.grouplevel_level_1);
        this.x[2] = groupLevelActivity.getString(R.string.grouplevel_level_2);
        this.x[3] = groupLevelActivity.getString(R.string.grouplevel_level_3);
        this.v[1] = this.q;
        this.v[2] = this.r;
        this.v[3] = this.s;
        this.a = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.a.setSystemClickable(false);
        this.a.a(this.c.getResources().getString(R.string.grouplevel_title));
        this.e = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.y = (Button) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.z = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.i.setText(TiebaApplication.g().getString(R.string.grouplevel_vip_current_level));
            bq.a(this.i, R.color.group_level_promote, 1);
        } else {
            this.i.setText(TiebaApplication.g().getString(R.string.grouplevel_current_level));
            bq.a(this.i, R.color.group_level_secondtitle_text, 1);
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
            string = String.format(TiebaApplication.g().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            bq.a(this.y, R.color.upgrade_mem_group_btn_text, 3);
            this.y.setEnabled(true);
        } else {
            if (!z3) {
                string = TiebaApplication.g().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TiebaApplication.g().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.y.setEnabled(false);
            bq.a(this.y, R.color.upgrade_mem_group_btn_cannotup_text, 3);
        }
        this.z.setText(string);
    }

    public ImageView a() {
        return this.e;
    }

    public Button e() {
        return this.y;
    }

    public void a(int i) {
        this.c.getLayoutMode().a(i == 1);
        this.c.getLayoutMode().a(this.d);
        this.a.c(i);
    }

    public TextView[] f() {
        return this.v;
    }

    public TextView[] g() {
        return this.w;
    }

    public void a(boolean z) {
        this.t.setVisibility(z ? 0 : 8);
    }

    public void a(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        while (i2 <= i) {
            if (!z) {
                bq.d(this.u[i2], (int) R.drawable.icon_grade_big_star_s);
            } else {
                bq.d(this.u[i2], (int) R.drawable.icon_vip_grade_big_star_s);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (!z) {
                bq.d(this.u[i2], (int) R.drawable.icon_grade_big_star_n);
            } else {
                bq.d(this.u[i2], (int) R.drawable.icon_vip_grade_big_star_n);
            }
            i2++;
        }
        this.j.setText(this.x[i]);
    }

    public TextView h() {
        return this.p;
    }

    public void a(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            this.m.setProgress((int) ((i2 / i3) * 100.0f));
            String string = this.c.getString(R.string.grouplevel_active_day_value, new Object[]{String.valueOf(i3)});
            this.n.setText(String.valueOf(i2));
            this.o.setText(string);
        } else if (i >= 3) {
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            this.l.setText(R.string.grouplevel_highest_grade);
        }
    }
}
