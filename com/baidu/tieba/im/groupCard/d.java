package com.baidu.tieba.im.groupCard;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.a.e;
import com.baidu.adp.lib.g.g;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d extends e {
    private View a;
    private GroupCardActivity c;
    private LinearLayout d;
    private LinearLayout e;
    private LinearLayout f;
    private ImageView g;
    private ProgressBar h;
    private NavigationBar i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private ImageView m;
    private ImageView n;

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
        this.f = (LinearLayout) this.c.findViewById(R.id.group_card_setting);
        this.h = (ProgressBar) this.c.findViewById(R.id.progress);
        this.j = (ImageView) this.c.findViewById(R.id.group_card_inner_image);
        this.i = (NavigationBar) this.c.findViewById(R.id.group_card_topbar);
        this.i.setSystemClickable(false);
        this.i.a(this.c.getResources().getString(R.string.group_card_name));
        this.g = this.i.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.g.setOnClickListener(this.c);
    }

    public void a(com.baidu.adp.widget.ImageView.d dVar) {
        if (dVar != null) {
            dVar.a(this.j);
        }
    }

    public void a(int i, String str) {
        if (str != null) {
            g.a((Context) this.c, str);
            return;
        }
        String a = com.baidu.tieba.im.d.g.a(i);
        if (a != null && a.length() > 0) {
            g.a((Context) this.c, a);
        }
    }

    public void a() {
        this.h.setVisibility(0);
    }

    public void e() {
        this.h.setVisibility(8);
    }

    public void f() {
        this.j.setVisibility(0);
    }

    public View g() {
        return this.d;
    }

    public View h() {
        return this.e;
    }

    public ImageView i() {
        return this.g;
    }

    public View j() {
        return this.i;
    }

    public LinearLayout k() {
        return this.f;
    }

    public void a(int i) {
        this.c.getLayoutMode().a(i == 1);
        this.c.getLayoutMode().a(this.a);
        bs.a(this.a, i);
        this.i.c(i);
    }
}
