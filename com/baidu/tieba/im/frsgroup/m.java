package com.baidu.tieba.im.frsgroup;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private GroupLevelActivity f1568a;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private ImageView f;
    private TextView g;
    private ViewGroup h;
    private TextView i;
    private ProgressBar j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private ProgressBar q;
    private ImageView[] r;
    private TextView[] s;
    private String[] t;

    public m(GroupLevelActivity groupLevelActivity) {
        super(groupLevelActivity);
        this.r = new ImageView[4];
        this.s = new TextView[4];
        this.t = new String[4];
        this.f1568a = groupLevelActivity;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        a(groupLevelActivity);
        b(groupLevelActivity);
    }

    private void a(GroupLevelActivity groupLevelActivity) {
        this.c = (ImageView) groupLevelActivity.findViewById(R.id.title_back);
        this.c.setOnClickListener(groupLevelActivity);
    }

    private void b(GroupLevelActivity groupLevelActivity) {
        this.q = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.d = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.e = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.f = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.g = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.h = (ViewGroup) groupLevelActivity.findViewById(R.id.grouplevel_active);
        this.i = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.j = (ProgressBar) groupLevelActivity.findViewById(R.id.active_progress);
        this.k = (TextView) groupLevelActivity.findViewById(R.id.active_day_cur);
        this.l = (TextView) groupLevelActivity.findViewById(R.id.active_day_total);
        this.m = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.n = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.o = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.p = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.r[1] = this.d;
        this.r[2] = this.e;
        this.r[3] = this.f;
        this.t[1] = groupLevelActivity.getString(R.string.grouplevel_level_1);
        this.t[2] = groupLevelActivity.getString(R.string.grouplevel_level_2);
        this.t[3] = groupLevelActivity.getString(R.string.grouplevel_level_3);
        this.s[1] = this.n;
        this.s[2] = this.o;
        this.s[3] = this.p;
    }

    public ImageView a() {
        return this.c;
    }

    public TextView[] e() {
        return this.s;
    }

    public void a(boolean z) {
        this.q.setVisibility(z ? 0 : 8);
    }

    public void a(int i) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        while (i2 <= i) {
            this.r[i2].setImageResource(R.drawable.icon_grade_big_star_s);
            i2++;
        }
        while (i2 <= 3) {
            this.r[i2].setImageResource(R.drawable.icon_grade_big_star_n);
            i2++;
        }
        this.g.setText(this.t[i]);
    }

    public TextView f() {
        return this.m;
    }

    public void a(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.h.setVisibility(0);
            this.i.setVisibility(8);
            this.j.setProgress((int) ((i2 / i3) * 100.0f));
            String string = this.f1568a.getString(R.string.grouplevel_active_day_value, new Object[]{String.valueOf(i3)});
            this.k.setText(String.valueOf(i2));
            this.l.setText(string);
        } else if (i >= 3) {
            this.h.setVisibility(8);
            this.i.setVisibility(0);
            this.i.setText(R.string.grouplevel_highest_grade);
        }
    }
}
