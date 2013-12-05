package com.baidu.tieba.im.nearbygroups;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.text.DecimalFormat;
/* loaded from: classes.dex */
public class j implements a {
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

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f1850a = null;
    private View c = null;
    private DecimalFormat q = new DecimalFormat("#.#");

    public j(NearbyGroupsActivity nearbyGroupsActivity) {
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
        if (obj instanceof com.baidu.tieba.im.data.e) {
            com.baidu.tieba.im.data.e eVar = (com.baidu.tieba.im.data.e) obj;
            this.o.setTag(eVar.c());
            this.e.setText(eVar.d());
            this.f.setText(eVar.h() + "/" + eVar.g());
            this.g.setText(eVar.e());
            String f = eVar.f();
            this.d.setTag(null);
            this.d.setDefaultResource(R.drawable.avatar_poto_defaul140);
            this.d.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            this.d.setDrawBorder(true);
            this.d.setRadius(com.baidu.adp.lib.h.g.a((Context) this.b, 5.0f));
            if (!TextUtils.isEmpty(f)) {
                this.d.setTag(f);
            }
            a(this.k, eVar.i());
            String b = b(eVar.j());
            this.m.setText(b);
            this.n.setText(b);
            if (eVar.a()) {
                this.p.setVisibility(0);
                this.m.setVisibility(0);
                this.n.setVisibility(8);
                return;
            }
            this.p.setVisibility(8);
            this.m.setVisibility(8);
            this.n.setVisibility(0);
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
        return this.q.format(i / 1000.0d) + "km";
    }

    private void a(ImageView[] imageViewArr, int i) {
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
        this.c = LayoutInflater.from(this.b).inflate(R.layout.im_group_list_item, (ViewGroup) null);
        this.f1850a = (LinearLayout) this.c.findViewById(R.id.list_item);
        this.p = (TextView) this.c.findViewById(R.id.isMeizi);
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
        this.b.getLayoutMode().a(this.f1850a);
    }

    public void c() {
        a(TiebaApplication.h().an());
    }
}
