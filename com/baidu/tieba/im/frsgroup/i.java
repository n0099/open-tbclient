package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    protected NavigationBar f1710a;
    private GroupLevelActivity c;
    private View d;
    private ImageView e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
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
    private String[] v;

    public i(GroupLevelActivity groupLevelActivity) {
        super(groupLevelActivity);
        this.t = new ImageView[4];
        this.u = new TextView[4];
        this.v = new String[4];
        this.f1710a = null;
        this.c = groupLevelActivity;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        b(groupLevelActivity);
        a(groupLevelActivity);
    }

    private void a(GroupLevelActivity groupLevelActivity) {
        this.e.setOnClickListener(this.c);
    }

    private void b(GroupLevelActivity groupLevelActivity) {
        this.d = groupLevelActivity.findViewById(R.id.parent);
        this.s = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.f = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.g = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.h = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.i = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.j = (ViewGroup) groupLevelActivity.findViewById(R.id.grouplevel_active);
        this.k = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.l = (ProgressBar) groupLevelActivity.findViewById(R.id.active_progress);
        this.m = (TextView) groupLevelActivity.findViewById(R.id.active_day_cur);
        this.n = (TextView) groupLevelActivity.findViewById(R.id.active_day_total);
        this.o = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.p = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.q = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.r = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.t[1] = this.f;
        this.t[2] = this.g;
        this.t[3] = this.h;
        this.v[1] = groupLevelActivity.getString(R.string.grouplevel_level_1);
        this.v[2] = groupLevelActivity.getString(R.string.grouplevel_level_2);
        this.v[3] = groupLevelActivity.getString(R.string.grouplevel_level_3);
        this.u[1] = this.p;
        this.u[2] = this.q;
        this.u[3] = this.r;
        this.f1710a = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.f1710a.setSystemClickable(false);
        this.f1710a.a(this.c.getResources().getString(R.string.grouplevel_title));
        this.e = this.f1710a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void a(int i) {
        this.c.getLayoutMode().a(i == 1);
        this.c.getLayoutMode().a(this.d);
        this.f1710a.c(i);
    }

    public ImageView a() {
        return this.e;
    }

    public TextView[] e() {
        return this.u;
    }

    public void a(boolean z) {
        this.s.setVisibility(z ? 0 : 8);
    }

    public void b(int i) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        while (i2 <= i) {
            if (TiebaApplication.h().an() == 0) {
                this.t[i2].setImageResource(R.drawable.icon_grade_big_star_s);
            } else {
                this.t[i2].setImageResource(R.drawable.icon_grade_big_star_s_1);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (TiebaApplication.h().an() == 0) {
                this.t[i2].setImageResource(R.drawable.icon_grade_big_star_n);
            } else {
                this.t[i2].setImageResource(R.drawable.icon_grade_big_star_n_1);
            }
            i2++;
        }
        this.i.setText(this.v[i]);
    }

    public TextView f() {
        return this.o;
    }

    public void a(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.j.setVisibility(0);
            this.k.setVisibility(8);
            this.l.setProgress((int) ((i2 / i3) * 100.0f));
            String string = this.c.getString(R.string.grouplevel_active_day_value, new Object[]{String.valueOf(i3)});
            this.m.setText(String.valueOf(i2));
            this.n.setText(string);
        } else if (i >= 3) {
            this.j.setVisibility(8);
            this.k.setVisibility(0);
            this.k.setText(R.string.grouplevel_highest_grade);
        }
    }
}
