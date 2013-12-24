package com.baidu.tieba.im.groupCard;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.a.e;
import com.baidu.adp.lib.h.g;
import com.baidu.tieba.im.d.f;
import com.baidu.tieba.util.bb;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d extends e {
    private View a;
    private GroupCardActivity c;
    private LinearLayout d;
    private LinearLayout e;
    private LinearLayout f;
    private LinearLayout g;
    private ImageView h;
    private ProgressBar i;
    private NavigationBar j;
    private View k;
    private ImageView l;
    private ImageView m;
    private ImageView n;
    private ImageView o;
    private ImageView p;

    public d(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity);
        this.a = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.c = groupCardActivity;
        l();
    }

    private void l() {
        this.c.setContentView(R.layout.group_card_activity);
        this.a = this.c.findViewById(R.id.parent);
        this.d = (LinearLayout) this.c.findViewById(R.id.groud_card_save);
        this.d.setOnClickListener(this.c);
        this.e = (LinearLayout) this.c.findViewById(R.id.group_card_share);
        this.e.setOnClickListener(this.c);
        this.f = (LinearLayout) this.c.findViewById(R.id.group_card_image);
        this.g = (LinearLayout) this.c.findViewById(R.id.group_card_setting);
        this.i = (ProgressBar) this.c.findViewById(R.id.progress);
        this.l = (ImageView) this.c.findViewById(R.id.group_card_inner_image);
        this.j = (NavigationBar) this.c.findViewById(R.id.group_card_topbar);
        this.j.setSystemClickable(false);
        this.j.a(this.c.getResources().getString(R.string.group_card_name));
        this.h = this.j.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.h.setOnClickListener(this.c);
    }

    public void a(com.baidu.adp.widget.ImageView.e eVar) {
        if (eVar != null) {
            eVar.a(this.l);
        }
    }

    public void a(int i, String str) {
        if (str != null) {
            g.a((Context) this.c, str);
            return;
        }
        String a = f.a(i);
        if (a != null && a.length() > 0) {
            g.a((Context) this.c, a);
        }
    }

    public void a() {
        this.i.setVisibility(0);
    }

    public void e() {
        this.i.setVisibility(8);
    }

    public void f() {
        this.l.setVisibility(0);
    }

    public View g() {
        return this.d;
    }

    public View h() {
        return this.e;
    }

    public ImageView i() {
        return this.h;
    }

    public View j() {
        return this.j;
    }

    public LinearLayout k() {
        return this.g;
    }

    public void a(int i) {
        this.c.getLayoutMode().a(i == 1);
        this.c.getLayoutMode().a(this.a);
        bb.a(this.a, i);
        this.j.c(i);
    }
}
