package com.baidu.tieba.forumfeed;

import android.support.v4.app.t;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.square.SquareActivity;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.a.e {
    View a;
    private View c;
    private RadioGroup d;
    private RadioButton[] e;
    private NavigationBar f;
    private View g;
    private int h;
    private ViewPager i;
    private HomePagerAdapter j;
    private t k;
    private HomeActivity l;
    private BaseFragmentActivity m;

    public q(BaseFragmentActivity baseFragmentActivity, HomeActivity homeActivity) {
        super(baseFragmentActivity);
        this.g = null;
        this.i = null;
        this.m = baseFragmentActivity;
        this.l = homeActivity;
        this.c = homeActivity.q();
        this.k = homeActivity.l();
        this.j = new HomePagerAdapter(this.k);
        this.f = (NavigationBar) this.c.findViewById(R.id.view_navigation_bar);
        this.g = this.f.a(R.layout.nb_item_home_topview, (View.OnClickListener) null);
        this.d = (RadioGroup) this.g.findViewById(R.id.radioGroup);
        this.e = new RadioButton[]{(RadioButton) this.g.findViewById(R.id.radio_square), (RadioButton) this.g.findViewById(R.id.radio_forumfeed)};
        this.a = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.square_nb_item_allcat, (SquareActivity) this.j.a(0));
        this.i = (ViewPager) this.c.findViewById(R.id.content);
        this.i.setOnPageChangeListener(this.l);
        this.i.setAdapter(this.j);
        this.h = this.e.length;
        this.i.setOffscreenPageLimit(this.h - 1);
        this.d.setOnCheckedChangeListener(this.l);
    }

    public void a(int i) {
        this.m.a().a(i == 1);
        this.m.a().a(this.c);
        this.f.c(i);
    }

    public View a() {
        return this.a;
    }

    public RadioGroup e() {
        return this.d;
    }

    public ViewPager f() {
        return this.i;
    }
}
