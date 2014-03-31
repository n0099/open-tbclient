package com.baidu.tieba.forumfeed;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public final class s extends com.baidu.adp.a.f {
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
    private com.baidu.tbadk.core.e l;

    public s(com.baidu.tbadk.core.e eVar, p pVar) {
        super(eVar);
        this.f = null;
        this.h = null;
        this.l = eVar;
        this.k = pVar;
        this.a = pVar.getView();
        this.j = pVar.getChildFragmentManager();
        this.i = new r(this.j);
        this.e = (NavigationBar) this.a.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.f = this.e.a(com.baidu.tieba.a.i.nb_item_home_topview, (View.OnClickListener) null);
        this.c = (RadioGroup) this.f.findViewById(com.baidu.tieba.a.h.radioGroup);
        this.d = new RadioButton[]{(RadioButton) this.f.findViewById(com.baidu.tieba.a.h.radio_square), (RadioButton) this.f.findViewById(com.baidu.tieba.a.h.radio_forumfeed)};
        this.h = (ViewPager) this.a.findViewById(com.baidu.tieba.a.h.content);
        this.h.setOnPageChangeListener(this.k);
        this.h.setAdapter(this.i);
        this.g = this.d.length;
        this.h.setOffscreenPageLimit(this.g - 1);
        this.c.setOnCheckedChangeListener(this.k);
    }

    public final void a(int i) {
        this.l.b().a(i == 1);
        this.l.b().a(this.a);
        this.e.b(i);
        if (this.i != null) {
            int count = this.i.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.i.getItem(i2);
                if (item != null && (item instanceof com.baidu.tbadk.core.d)) {
                    ((com.baidu.tbadk.core.d) item).onChangeSkinType(i);
                }
            }
        }
    }

    public final RadioGroup a() {
        return this.c;
    }

    public final ViewPager d() {
        return this.h;
    }

    public final r e() {
        return this.i;
    }
}
