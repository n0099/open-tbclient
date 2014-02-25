package com.baidu.tieba.e;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.baidu.tieba.square.am;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.a.e {
    private View a;
    private RadioGroup c;
    private RadioButton[] d;
    private NavigationBar e;
    private View f;
    private int g;
    private ViewPager h;
    private r i;
    private FragmentManager j;
    private p k;
    private com.baidu.tieba.k l;

    public s(com.baidu.tieba.k kVar, p pVar) {
        super(kVar);
        this.f = null;
        this.h = null;
        this.l = kVar;
        this.k = pVar;
        this.a = pVar.getView();
        this.j = pVar.getChildFragmentManager();
        this.i = new r(this.j);
        this.e = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.f = this.e.a(R.layout.nb_item_home_topview, (View.OnClickListener) null);
        this.c = (RadioGroup) this.f.findViewById(R.id.radioGroup);
        this.d = new RadioButton[]{(RadioButton) this.f.findViewById(R.id.radio_square), (RadioButton) this.f.findViewById(R.id.radio_forumfeed)};
        am amVar = (am) this.i.getItem(0);
        this.h = (ViewPager) this.a.findViewById(R.id.content);
        this.h.setOnPageChangeListener(this.k);
        this.h.setAdapter(this.i);
        this.g = this.d.length;
        this.h.setOffscreenPageLimit(this.g - 1);
        this.c.setOnCheckedChangeListener(this.k);
    }

    public void a(int i) {
        this.l.a().a(i == 1);
        this.l.a().a(this.a);
        this.e.c(i);
        if (this.i != null) {
            int count = this.i.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.i.getItem(i2);
                if (item != null && (item instanceof com.baidu.tieba.j)) {
                    ((com.baidu.tieba.j) item).c(i);
                }
            }
        }
    }

    public RadioGroup a() {
        return this.c;
    }

    public ViewPager e() {
        return this.h;
    }

    public r f() {
        return this.i;
    }
}
