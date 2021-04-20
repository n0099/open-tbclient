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
import d.b.c.e.p.l;
import d.b.i0.e1.i.a.b.b;
import d.b.i0.e1.l.c.a;
/* loaded from: classes4.dex */
public class OfficialFeedItemImage extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17555e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17556f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f17557g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17558h;
    public TextView i;
    public View j;
    public View k;
    public View l;
    public boolean m;

    public OfficialFeedItemImage(Context context, boolean z) {
        this(context, (AttributeSet) null);
        this.m = z;
    }

    public void a() {
        this.f17556f.setRadius(l.g(this.f17555e, R.dimen.tbds31));
        this.f17556f.setConrers(3);
        ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
        layoutParams.height = l.g(this.f17555e, R.dimen.tbds579);
        this.k.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
        layoutParams2.leftMargin = l.g(this.f17555e, R.dimen.tbds27);
        this.l.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams3.leftMargin = l.g(this.f17555e, R.dimen.tbds30);
        layoutParams3.bottomMargin = l.g(this.f17555e, R.dimen.tbds27);
        this.i.setLayoutParams(layoutParams3);
    }

    public final void b() {
        LayoutInflater.from(this.f17555e).inflate(R.layout.official_feed_item_image, (ViewGroup) this, true);
        this.f17556f = (TbImageView) findViewById(R.id.message_image);
        this.f17557g = (ImageView) findViewById(R.id.message_read_icon);
        this.f17558h = (TextView) findViewById(R.id.message_read_count);
        this.i = (TextView) findViewById(R.id.message_title);
        this.j = findViewById(R.id.black_mask);
        this.f17556f.setConrers(15);
        this.f17556f.setRadius(l.g(this.f17555e, R.dimen.tbds21));
        this.k = findViewById(R.id.image_container);
        this.l = findViewById(R.id.msg_read_container);
        c();
    }

    public void c() {
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f17557g, R.drawable.icon_pure_broadcast_read16_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        DrawableSelector gradientLinear = TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0606);
        if (this.m) {
            gradientLinear.into(this.j);
        } else {
            gradientLinear.blRadius(l.g(getContext(), R.dimen.tbds21)).brRadius(l.g(getContext(), R.dimen.tbds21)).into(this.j);
        }
        SkinManager.setViewTextColor(this.f17558h, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0101);
    }

    public void d(int i) {
        if (i > 0) {
            this.f17558h.setText(this.f17555e.getString(R.string.person_view_num, StringHelper.numberUniformFormatExtraWithRound(i)));
            this.f17558h.setVisibility(0);
            this.f17557g.setVisibility(0);
            return;
        }
        this.f17558h.setVisibility(8);
        this.f17557g.setVisibility(8);
    }

    public void setData(a.C1266a c1266a, int i, b bVar) {
        this.f17556f.W(c1266a.f55431c, 10, false);
        this.i.setText(c1266a.f55429a);
        if (bVar != null) {
            i = bVar.i();
        }
        d(i);
    }

    public OfficialFeedItemImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17555e = context;
        b();
    }
}
