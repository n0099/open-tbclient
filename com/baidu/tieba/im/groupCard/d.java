package com.baidu.tieba.im.groupCard;

import android.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.a.e;
import com.baidu.adp.lib.h.f;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d extends e {

    /* renamed from: a  reason: collision with root package name */
    private GroupCardActivity f1587a;
    private LinearLayout c;
    private LinearLayout d;
    private LinearLayout e;
    private LinearLayout f;
    private LinearLayout g;
    private ImageView h;
    private ProgressBar i;
    private AlertDialog j;
    private View k;
    private ImageView l;
    private ImageView m;
    private ImageView n;
    private ImageView o;
    private ImageView p;

    public d(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity);
        this.c = null;
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
        this.f1587a = groupCardActivity;
        l();
    }

    private void l() {
        this.f1587a.setContentView(R.layout.group_card_activity);
        this.c = (LinearLayout) this.f1587a.findViewById(R.id.groud_card_save);
        this.c.setOnClickListener(this.f1587a);
        this.d = (LinearLayout) this.f1587a.findViewById(R.id.group_card_share);
        this.d.setOnClickListener(this.f1587a);
        this.e = (LinearLayout) this.f1587a.findViewById(R.id.group_card_image);
        this.f = (LinearLayout) this.f1587a.findViewById(R.id.title_bar);
        this.g = (LinearLayout) this.f1587a.findViewById(R.id.group_card_setting);
        this.h = (ImageView) this.f1587a.findViewById(R.id.title_back);
        this.h.setOnClickListener(this.f1587a);
        this.i = (ProgressBar) this.f1587a.findViewById(R.id.progress);
        this.l = (ImageView) this.f1587a.findViewById(R.id.group_card_inner_image);
    }

    public void a(com.baidu.adp.widget.ImageView.e eVar) {
        if (eVar != null) {
            eVar.a(this.l);
        }
    }

    public void a(int i, String str) {
        if (str != null) {
            f.a(this.f1587a, str);
            return;
        }
        String a2 = com.baidu.tieba.im.d.e.a(i);
        if (a2 != null && a2.length() > 0) {
            f.a(this.f1587a, a2);
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
        return this.c;
    }

    public View h() {
        return this.d;
    }

    public ImageView i() {
        return this.h;
    }

    public LinearLayout j() {
        return this.f;
    }

    public LinearLayout k() {
        return this.g;
    }
}
