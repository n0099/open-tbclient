package com.baidu.tieba.im.nearbygroups;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bq;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.text.DecimalFormat;
/* loaded from: classes.dex */
public final class j implements a {
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

    public j(NearbyGroupsActivity nearbyGroupsActivity) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.b = nearbyGroupsActivity;
        this.c = LayoutInflater.from(this.b).inflate(R.layout.im_group_list_item, (ViewGroup) null);
        this.a = (LinearLayout) this.c.findViewById(R.id.list_item);
        this.p = (TextView) this.c.findViewById(R.id.isMeizi);
        this.q = (TextView) this.c.findViewById(R.id.isNewCreate);
        this.r = (TextView) this.c.findViewById(R.id.isRecentlyReplay);
        this.o = (LinearLayout) this.c.findViewById(R.id.list_item_content);
        this.l = (TextView) this.c.findViewById(R.id.tv_im_line_bottom);
        this.m = (TextView) this.c.findViewById(R.id.tv_distance);
        this.n = (TextView) this.c.findViewById(R.id.tv_top_distance);
        this.d = (HeadImageView) this.c.findViewById(R.id.item_head);
        this.e = (TextView) this.c.findViewById(R.id.item_group_name);
        this.f = (TextView) this.c.findViewById(R.id.item_group_num);
        this.g = (TextView) this.c.findViewById(R.id.item_introduce);
        this.h = (ImageView) this.c.findViewById(R.id.item_grade1);
        this.i = (ImageView) this.c.findViewById(R.id.item_grade2);
        this.j = (ImageView) this.c.findViewById(R.id.item_grade3);
        this.k[1] = this.h;
        this.k[2] = this.i;
        this.k[3] = this.j;
        this.o.setOnClickListener(this.b);
        this.l.setVisibility(0);
        this.b.getLayoutMode().a(TiebaApplication.g().ae() == 1);
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
        if (obj instanceof com.baidu.tieba.im.data.i) {
            com.baidu.tieba.im.data.i iVar = (com.baidu.tieba.im.data.i) obj;
            this.o.setTag(iVar.c());
            this.e.setText(iVar.d());
            this.f.setText(String.valueOf(iVar.h()) + "/" + iVar.g());
            this.g.setText(iVar.e());
            String f = iVar.f();
            this.d.setTag(null);
            this.d.setDefaultResource(R.drawable.avatar_poto_defaul140);
            this.d.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            this.d.setDrawBorder(true);
            this.d.setRadius(BdUtilHelper.a((Context) this.b, 5.0f));
            if (!TextUtils.isEmpty(f)) {
                this.d.setTag(f);
            }
            if (iVar.m()) {
                bq.a(this.e, R.color.im_group_vip_text, 1);
            } else {
                this.b.getLayoutMode().a(TiebaApplication.g().ae() == 1);
                this.b.getLayoutMode().a(this.e);
            }
            a(this.k, iVar.i(), iVar.m());
            int j = iVar.j();
            if (j < 0 || j >= 1000) {
                str = String.valueOf(this.s.format(j / 1000.0d)) + "km";
            } else {
                str = j / 100 == 9 ? "<1km" : "<" + (i + 1) + "00m";
            }
            this.m.setText(str);
            this.n.setText(str);
            if (iVar.a()) {
                this.p.setVisibility(0);
                this.m.setVisibility(0);
                this.n.setVisibility(8);
            } else {
                this.p.setVisibility(8);
                this.m.setVisibility(8);
                this.n.setVisibility(0);
            }
            if (iVar.k()) {
                this.q.setVisibility(0);
            } else {
                this.q.setVisibility(8);
            }
            if (iVar.l()) {
                this.r.setVisibility(0);
            } else {
                this.r.setVisibility(8);
            }
        }
    }

    private void a(ImageView[] imageViewArr, int i, boolean z) {
        if (z) {
            bq.d(imageViewArr[1], (int) R.drawable.icon_vip_grade_big_small_s);
            bq.d(imageViewArr[2], (int) R.drawable.icon_vip_grade_big_small_s);
            bq.d(imageViewArr[3], (int) R.drawable.icon_vip_grade_big_small_s);
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
