package com.baidu.tieba.im.nearbygroups;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import java.text.DecimalFormat;
/* loaded from: classes.dex */
public final class l implements a {
    private LinearLayout a;
    private NearbyGroupsActivity b;
    private View c;
    private HeadImageView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private TextView l;
    private TextView m;
    private TextView n;
    private LinearLayout o;
    private TextView p;
    private TextView q;
    private TextView r;
    private DecimalFormat s = new DecimalFormat("#.#");
    private ImageView[] k = new ImageView[4];

    public l(NearbyGroupsActivity nearbyGroupsActivity) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.b = nearbyGroupsActivity;
        this.c = LayoutInflater.from(this.b).inflate(com.baidu.tieba.im.i.im_group_list_item, (ViewGroup) null);
        this.a = (LinearLayout) this.c.findViewById(com.baidu.tieba.im.h.list_item);
        this.p = (TextView) this.c.findViewById(com.baidu.tieba.im.h.isMeizi);
        this.q = (TextView) this.c.findViewById(com.baidu.tieba.im.h.isNewCreate);
        this.r = (TextView) this.c.findViewById(com.baidu.tieba.im.h.isRecentlyReplay);
        this.o = (LinearLayout) this.c.findViewById(com.baidu.tieba.im.h.list_item_content);
        this.l = (TextView) this.c.findViewById(com.baidu.tieba.im.h.tv_im_line_bottom);
        this.m = (TextView) this.c.findViewById(com.baidu.tieba.im.h.tv_distance);
        this.n = (TextView) this.c.findViewById(com.baidu.tieba.im.h.tv_top_distance);
        this.d = (HeadImageView) this.c.findViewById(com.baidu.tieba.im.h.item_head);
        this.e = (TextView) this.c.findViewById(com.baidu.tieba.im.h.item_group_name);
        this.f = (TextView) this.c.findViewById(com.baidu.tieba.im.h.item_group_num);
        this.g = (TextView) this.c.findViewById(com.baidu.tieba.im.h.item_introduce);
        this.h = (ImageView) this.c.findViewById(com.baidu.tieba.im.h.item_grade1);
        this.i = (ImageView) this.c.findViewById(com.baidu.tieba.im.h.item_grade2);
        this.j = (ImageView) this.c.findViewById(com.baidu.tieba.im.h.item_grade3);
        this.k[1] = this.h;
        this.k[2] = this.i;
        this.k[3] = this.j;
        this.o.setOnClickListener(this.b);
        this.l.setVisibility(0);
        this.b.getLayoutMode().a(TbadkApplication.j().l() == 1);
        this.b.getLayoutMode().a(this.a);
    }

    @Override // com.baidu.tieba.im.nearbygroups.a
    public final View a() {
        return this.c;
    }

    @Override // com.baidu.tieba.im.nearbygroups.a
    public final void a(Object obj) {
        String str;
        int i;
        if (obj instanceof com.baidu.tieba.im.data.g) {
            com.baidu.tieba.im.data.g gVar = (com.baidu.tieba.im.data.g) obj;
            this.o.setTag(gVar.c());
            this.e.setText(gVar.d());
            this.f.setText(String.valueOf(gVar.h()) + "/" + gVar.g());
            this.g.setText(gVar.e());
            String f = gVar.f();
            this.d.setTag(null);
            this.d.setDefaultResource(com.baidu.tieba.im.g.avatar_poto_defaul140);
            this.d.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            this.d.setDrawBorder(true);
            this.d.setRadius(com.baidu.adp.lib.util.i.a((Context) this.b, 3.0f));
            if (!TextUtils.isEmpty(f)) {
                this.d.setTag(f);
            }
            if (gVar.m()) {
                ba.a(this.e, com.baidu.tieba.im.e.im_group_vip_text, 1);
            } else {
                this.b.getLayoutMode().a(TbadkApplication.j().l() == 1);
                this.b.getLayoutMode().a(this.e);
            }
            a(this.k, gVar.i(), gVar.m());
            int j = gVar.j();
            if (j < 0 || j >= 1000) {
                str = String.valueOf(this.s.format(j / 1000.0d)) + "km";
            } else {
                str = j / 100 == 9 ? "<1km" : "<" + (i + 1) + "00m";
            }
            this.m.setText(str);
            this.n.setText(str);
            if (gVar.a()) {
                this.p.setVisibility(0);
                this.m.setVisibility(0);
                this.n.setVisibility(8);
            } else {
                this.p.setVisibility(8);
                this.m.setVisibility(8);
                this.n.setVisibility(0);
            }
            if (gVar.k()) {
                this.q.setVisibility(0);
            } else {
                this.q.setVisibility(8);
            }
            if (gVar.l()) {
                this.r.setVisibility(0);
            } else {
                this.r.setVisibility(8);
            }
        }
    }

    private void a(ImageView[] imageViewArr, int i, boolean z) {
        if (z) {
            ba.c(imageViewArr[1], com.baidu.tieba.im.g.icon_vip_grade_big_small_s);
            ba.c(imageViewArr[2], com.baidu.tieba.im.g.icon_vip_grade_big_small_s);
            ba.c(imageViewArr[3], com.baidu.tieba.im.g.icon_vip_grade_big_small_s);
        } else {
            this.b.getLayoutMode().a(imageViewArr[1]);
            this.b.getLayoutMode().a(imageViewArr[2]);
            this.b.getLayoutMode().a(imageViewArr[3]);
        }
        int i2 = i < 0 ? 0 : i;
        if (i2 > 3) {
            i2 = 3;
        }
        for (int i3 = 1; i3 <= 3; i3++) {
            if (i3 <= i2) {
                imageViewArr[i3].setVisibility(0);
            } else {
                imageViewArr[i3].setVisibility(8);
            }
        }
    }
}
