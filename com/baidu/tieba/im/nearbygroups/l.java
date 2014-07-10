package com.baidu.tieba.im.nearbygroups;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.text.DecimalFormat;
/* loaded from: classes.dex */
public class l implements a {
    private NearbyGroupsActivity b;
    private HeadImageView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private ImageView[] k;
    private TextView l;
    private TextView m;
    private TextView n;
    private LinearLayout o;
    private TextView p;
    private TextView q;
    private TextView r;
    private LinearLayout a = null;
    private View c = null;
    private DecimalFormat s = new DecimalFormat("#.#");

    public l(NearbyGroupsActivity nearbyGroupsActivity) {
        this.b = null;
        this.b = nearbyGroupsActivity;
        b();
    }

    @Override // com.baidu.tieba.im.nearbygroups.a
    public View a() {
        return this.c;
    }

    @Override // com.baidu.tieba.im.nearbygroups.a
    public void a(int i, Object obj) {
        if (obj instanceof com.baidu.tieba.im.data.j) {
            com.baidu.tieba.im.data.j jVar = (com.baidu.tieba.im.data.j) obj;
            this.o.setTag(jVar.c());
            this.e.setText(jVar.d());
            this.f.setText(String.valueOf(jVar.h()) + "/" + jVar.g());
            this.g.setText(jVar.e());
            String f = jVar.f();
            this.d.setTag(null);
            this.d.setDefaultResource(u.avatar_poto_defaul140);
            this.d.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            this.d.setDrawBorder(true);
            if (!TextUtils.isEmpty(f)) {
                this.d.setTag(f);
            }
            this.d.a(f, 10, false);
            if (jVar.m()) {
                bk.a(this.e, s.im_group_vip_text, 1);
            } else {
                this.b.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
                this.b.getLayoutMode().a(this.e);
            }
            a(this.k, jVar.i(), jVar.m());
            String b = b(jVar.j());
            this.m.setText(b);
            this.n.setText(b);
            if (jVar.a()) {
                this.p.setVisibility(0);
                this.m.setVisibility(0);
                this.n.setVisibility(8);
            } else {
                this.p.setVisibility(8);
                this.m.setVisibility(8);
                this.n.setVisibility(0);
            }
            if (jVar.k()) {
                this.q.setVisibility(0);
            } else {
                this.q.setVisibility(8);
            }
            if (jVar.l()) {
                this.r.setVisibility(0);
            } else {
                this.r.setVisibility(8);
            }
        }
    }

    private String b(int i) {
        if (i >= 0 && i < 1000) {
            int i2 = i / 100;
            if (i2 == 9) {
                return "<1km";
            }
            return "<" + (i2 + 1) + "00m";
        }
        return String.valueOf(this.s.format(i / 1000.0d)) + "km";
    }

    private void a(ImageView[] imageViewArr, int i, boolean z) {
        if (z) {
            bk.c(imageViewArr[1], u.icon_vip_grade_big_small_s);
            bk.c(imageViewArr[2], u.icon_vip_grade_big_small_s);
            bk.c(imageViewArr[3], u.icon_vip_grade_big_small_s);
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

    public void b() {
        this.c = LayoutInflater.from(this.b).inflate(w.im_group_list_item, (ViewGroup) null);
        this.a = (LinearLayout) this.c.findViewById(v.list_item);
        this.p = (TextView) this.c.findViewById(v.isMeizi);
        this.q = (TextView) this.c.findViewById(v.isNewCreate);
        this.r = (TextView) this.c.findViewById(v.isRecentlyReplay);
        this.o = (LinearLayout) this.c.findViewById(v.list_item_content);
        this.l = (TextView) this.c.findViewById(v.tv_im_line_bottom);
        this.m = (TextView) this.c.findViewById(v.tv_distance);
        this.n = (TextView) this.c.findViewById(v.tv_top_distance);
        this.d = (HeadImageView) this.c.findViewById(v.item_head);
        this.e = (TextView) this.c.findViewById(v.item_group_name);
        this.f = (TextView) this.c.findViewById(v.item_group_num);
        this.g = (TextView) this.c.findViewById(v.item_introduce);
        this.h = (ImageView) this.c.findViewById(v.item_grade1);
        this.i = (ImageView) this.c.findViewById(v.item_grade2);
        this.j = (ImageView) this.c.findViewById(v.item_grade3);
        this.k = new ImageView[4];
        this.k[1] = this.h;
        this.k[2] = this.i;
        this.k[3] = this.j;
        this.o.setOnClickListener(this.b);
        this.l.setVisibility(0);
        c();
    }

    public void a(int i) {
        this.b.getLayoutMode().a(i == 1);
        this.b.getLayoutMode().a((View) this.a);
    }

    public void c() {
        a(TbadkApplication.m252getInst().getSkinType());
    }
}
