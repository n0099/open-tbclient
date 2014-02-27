package com.baidu.tieba.im.groupCard;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.a.e;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.im.util.n;
import com.baidu.tieba.util.bq;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.widget.share.g;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class d extends e {
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

    public d(GroupCardActivity groupCardActivity) {
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
        this.c.setContentView(R.layout.group_card_activity);
        this.a = this.c.findViewById(R.id.parent);
        this.d = (LinearLayout) this.c.findViewById(R.id.groud_card_save);
        this.d.setOnClickListener(this.c);
        this.e = (LinearLayout) this.c.findViewById(R.id.group_card_share);
        if (g.a(this.c)) {
            this.e.setOnClickListener(this.c);
        } else {
            this.e.setVisibility(8);
        }
        this.f = (LinearLayout) this.c.findViewById(R.id.group_card_setting);
        this.h = (ProgressBar) this.c.findViewById(R.id.progress);
        this.j = (ImageView) this.c.findViewById(R.id.group_card_inner_image);
        this.i = (NavigationBar) this.c.findViewById(R.id.group_card_topbar);
        this.i.setSystemClickable(false);
        this.i.a(this.c.getResources().getString(R.string.group_card_name));
        this.g = this.i.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.g.setOnClickListener(this.c);
    }

    public final void a(com.baidu.adp.widget.ImageView.b bVar) {
        if (bVar != null) {
            bVar.a(this.j);
        }
    }

    public final void a(int i, String str) {
        if (str != null) {
            BdUtilHelper.a((Context) this.c, str);
            return;
        }
        String a = n.a(0);
        if (a != null && a.length() > 0) {
            BdUtilHelper.a((Context) this.c, a);
        }
    }

    public final void a() {
        this.h.setVisibility(0);
    }

    public final void d() {
        this.h.setVisibility(8);
    }

    public final void e() {
        this.j.setVisibility(0);
    }

    public final View f() {
        return this.d;
    }

    public final View g() {
        return this.e;
    }

    public final ImageView h() {
        return this.g;
    }

    public final View i() {
        return this.i;
    }

    public final LinearLayout j() {
        return this.f;
    }

    public final void a(int i) {
        this.c.getLayoutMode().a(i == 1);
        this.c.getLayoutMode().a(this.a);
        bq.a(this.a, i);
        this.i.b(i);
    }
}
