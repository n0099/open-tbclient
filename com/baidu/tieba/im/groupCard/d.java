package com.baidu.tieba.im.groupCard;

import android.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.a.e;
import com.baidu.adp.lib.h.f;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d extends e {

    /* renamed from: a  reason: collision with root package name */
    protected NavigationBar f1665a;
    protected View c;
    private GroupCardActivity d;
    private LinearLayout e;
    private LinearLayout f;
    private LinearLayout g;
    private LinearLayout h;
    private ImageView i;
    private ProgressBar j;
    private AlertDialog k;
    private View l;
    private ImageView m;
    private ImageView n;
    private ImageView o;
    private ImageView p;
    private ImageView q;

    public d(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity);
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
        this.q = null;
        this.f1665a = null;
        this.c = null;
        this.d = groupCardActivity;
        l();
    }

    private void l() {
        this.d.setContentView(R.layout.group_card_activity);
        this.c = this.d.findViewById(R.id.parent);
        this.f1665a = (NavigationBar) this.d.findViewById(R.id.view_navigation_bar);
        this.f1665a.a(this.d.getResources().getString(R.string.group_card_name));
        this.i = this.f1665a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.i.setOnClickListener(this.d);
        this.e = (LinearLayout) this.d.findViewById(R.id.groud_card_save);
        this.e.setOnClickListener(this.d);
        this.f = (LinearLayout) this.d.findViewById(R.id.group_card_share);
        this.f.setOnClickListener(this.d);
        this.g = (LinearLayout) this.d.findViewById(R.id.group_card_image);
        this.h = (LinearLayout) this.d.findViewById(R.id.group_card_setting);
        this.j = (ProgressBar) this.d.findViewById(R.id.progress);
        this.m = (ImageView) this.d.findViewById(R.id.group_card_inner_image);
    }

    public void a(int i) {
        this.d.getLayoutMode().a(false);
        this.d.getLayoutMode().a(this.c);
        this.f1665a.c(0);
        bd.b(this.c, 0);
    }

    public void a(com.baidu.adp.widget.ImageView.e eVar) {
        if (eVar != null) {
            eVar.a(this.m);
        }
    }

    public void a(int i, String str) {
        if (str != null) {
            f.a(this.d, str);
            return;
        }
        String a2 = com.baidu.tieba.im.d.e.a(i);
        if (a2 != null && a2.length() > 0) {
            f.a(this.d, a2);
        }
    }

    public void a() {
        this.j.setVisibility(0);
    }

    public void e() {
        this.j.setVisibility(8);
    }

    public void f() {
        this.m.setVisibility(0);
    }

    public View g() {
        return this.e;
    }

    public View h() {
        return this.f;
    }

    public ImageView i() {
        return this.i;
    }

    public View j() {
        return this.f1665a;
    }

    public LinearLayout k() {
        return this.h;
    }
}
