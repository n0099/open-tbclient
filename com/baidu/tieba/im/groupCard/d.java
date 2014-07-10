package com.baidu.tieba.im.groupCard;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.i;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class d extends f {
    private View a;
    private GroupCardActivity b;
    private LinearLayout c;
    private LinearLayout d;
    private LinearLayout e;
    private View f;
    private ProgressBar g;
    private NavigationBar h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private ImageView m;

    public d(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity);
        this.a = null;
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
        this.b = groupCardActivity;
        i();
    }

    private void i() {
        this.b.setContentView(w.group_card_activity);
        this.a = this.b.findViewById(v.parent);
        this.c = (LinearLayout) this.b.findViewById(v.groud_card_save);
        this.c.setOnClickListener(this.b);
        this.d = (LinearLayout) this.b.findViewById(v.group_card_share);
        if (i.a(this.b)) {
            this.d.setOnClickListener(this.b);
        } else {
            this.d.setVisibility(8);
        }
        this.e = (LinearLayout) this.b.findViewById(v.group_card_setting);
        this.g = (ProgressBar) this.b.findViewById(v.progress);
        this.i = (ImageView) this.b.findViewById(v.group_card_inner_image);
        this.h = (NavigationBar) this.b.findViewById(v.group_card_topbar);
        this.h.setSystemClickable(false);
        this.h.a(this.b.getResources().getString(y.group_card_name));
        this.f = this.h.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f.setOnClickListener(this.b);
    }

    public void a(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.a(this.i);
        }
    }

    public void a(int i, String str) {
        if (str != null) {
            j.a((Context) this.b, str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            j.a((Context) this.b, errMsg);
        }
    }

    public void a() {
        this.g.setVisibility(0);
    }

    public void b() {
        this.g.setVisibility(8);
    }

    public void c() {
        this.i.setVisibility(0);
    }

    public View d() {
        return this.c;
    }

    public View e() {
        return this.d;
    }

    public View f() {
        return this.f;
    }

    public View g() {
        return this.h;
    }

    public LinearLayout h() {
        return this.e;
    }

    public void a(int i) {
        this.b.getLayoutMode().a(i == 1);
        this.b.getLayoutMode().a(this.a);
        bk.a(this.a, i);
        this.h.c(i);
    }
}
