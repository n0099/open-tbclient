package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.m0.r.d0.b;
import d.a.n0.b1.g.j.e;
import java.util.List;
/* loaded from: classes4.dex */
public class ConcernUnreadTipView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f16465e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16466f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f16467g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16468h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16469i;
    public ImageView j;
    public BdUniqueId k;
    public int l;
    public int m;

    public ConcernUnreadTipView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        this.l = l.g(getContext(), R.dimen.tbds94);
        this.m = 0 - l.g(getContext(), R.dimen.tbds18);
        LayoutInflater.from(context).inflate(R.layout.concern_unread_tip_view_layout, (ViewGroup) this, true);
        this.f16466f = (TextView) findViewById(R.id.concern_unread_tip_title);
        this.f16465e = (ImageView) findViewById(R.id.concern_unread_tip_close);
        this.f16467g = (LinearLayout) findViewById(R.id.concern_unread_tip_header_box);
        this.f16468h = (TextView) findViewById(R.id.concern_unread_tip_info);
        this.f16469i = (TextView) findViewById(R.id.concern_unread_tip_show);
        this.j = (ImageView) findViewById(R.id.concern_unread_tip_show_arrow);
        setPadding(0, 0, 0, l.g(context, R.dimen.tbds44));
        b();
    }

    public void b() {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f16466f, R.color.CAM_X0105);
        SkinManager.setImageResource(this.f16465e, R.drawable.icon_home_card_delete);
        SkinManager.setViewTextColor(this.f16468h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f16469i, R.color.CAM_X0109);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.k = bdUniqueId;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.f16465e.setOnClickListener(onClickListener);
    }

    public void setData(e eVar) {
        if (eVar == null) {
            return;
        }
        if (!eVar.a()) {
            setVisibility(8);
            return;
        }
        if (eVar.f51808c > 0) {
            b.j().w(b.n("concern_unread_tip_next_show_time"), System.currentTimeMillis() + eVar.f51808c);
        }
        if (this.f16468h != null && !StringUtils.isNull(eVar.f51809d)) {
            this.f16468h.setText(eVar.f51809d);
        }
        LinearLayout linearLayout = this.f16467g;
        if (linearLayout == null || eVar.f51807b == null) {
            return;
        }
        linearLayout.removeAllViews();
        List<String> list = eVar.f51807b;
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2);
            if (!StringUtils.isNull(str)) {
                FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.concern_unread_tip_head_group, null);
                int i3 = this.l;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
                if (i2 > 0) {
                    layoutParams.leftMargin = this.m;
                }
                frameLayout.setLayoutParams(layoutParams);
                HeadImageView headImageView = (HeadImageView) frameLayout.findViewById(R.id.inner_img);
                headImageView.setIsRound(true);
                headImageView.setDrawBorder(false);
                SkinManager.setImageResource((ImageView) frameLayout.findViewById(R.id.out_img), R.drawable.bg_unread_tip_head_border);
                this.f16467g.addView(frameLayout);
                headImageView.setPageId(this.k);
                headImageView.V(str, 12, false);
            }
        }
    }

    public ConcernUnreadTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ConcernUnreadTipView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }
}
