package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.o0.f1.i.a.b.b;
import d.a.o0.f1.l.c.a;
/* loaded from: classes4.dex */
public class OfficialFeedItemImage extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17263e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17264f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f17265g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17266h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17267i;
    public View j;
    public View k;
    public View l;
    public boolean m;

    public OfficialFeedItemImage(Context context, boolean z) {
        this(context, (AttributeSet) null);
        this.m = z;
    }

    public void a() {
        this.f17264f.setRadius(l.g(this.f17263e, R.dimen.tbds31));
        this.f17264f.setConrers(3);
        ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
        layoutParams.height = l.g(this.f17263e, R.dimen.tbds579);
        this.k.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
        layoutParams2.leftMargin = l.g(this.f17263e, R.dimen.tbds27);
        this.l.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f17267i.getLayoutParams();
        layoutParams3.leftMargin = l.g(this.f17263e, R.dimen.tbds30);
        layoutParams3.bottomMargin = l.g(this.f17263e, R.dimen.tbds27);
        this.f17267i.setLayoutParams(layoutParams3);
    }

    public final void b() {
        LayoutInflater.from(this.f17263e).inflate(R.layout.official_feed_item_image, (ViewGroup) this, true);
        this.f17264f = (TbImageView) findViewById(R.id.message_image);
        this.f17265g = (ImageView) findViewById(R.id.message_read_icon);
        this.f17266h = (TextView) findViewById(R.id.message_read_count);
        this.f17267i = (TextView) findViewById(R.id.message_title);
        this.j = findViewById(R.id.black_mask);
        this.f17264f.setConrers(15);
        this.f17264f.setRadius(l.g(this.f17263e, R.dimen.tbds21));
        this.k = findViewById(R.id.image_container);
        this.l = findViewById(R.id.msg_read_container);
        c();
    }

    public void c() {
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f17265g, R.drawable.icon_pure_broadcast_read16_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        DrawableSelector gradientLinear = TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0606);
        if (this.m) {
            gradientLinear.into(this.j);
        } else {
            gradientLinear.blRadius(l.g(getContext(), R.dimen.tbds21)).brRadius(l.g(getContext(), R.dimen.tbds21)).into(this.j);
        }
        SkinManager.setViewTextColor(this.f17266h, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f17267i, R.color.CAM_X0101);
    }

    public void d(int i2) {
        if (i2 > 0) {
            this.f17266h.setText(this.f17263e.getString(R.string.person_view_num, StringHelper.numberUniformFormatExtraWithRound(i2)));
            this.f17266h.setVisibility(0);
            this.f17265g.setVisibility(0);
            return;
        }
        this.f17266h.setVisibility(8);
        this.f17265g.setVisibility(8);
    }

    public void setData(a.C1378a c1378a, int i2, b bVar) {
        this.f17264f.U(c1378a.f58423c, 10, false);
        this.f17267i.setText(c1378a.f58421a);
        if (bVar != null) {
            i2 = bVar.i();
        }
        d(i2);
    }

    public OfficialFeedItemImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17263e = context;
        b();
    }
}
