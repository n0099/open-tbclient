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
import d.b.b.e.p.l;
import d.b.h0.r.d0.b;
import d.b.i0.z0.g.j.e;
import java.util.List;
/* loaded from: classes4.dex */
public class ConcernUnreadTipView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f17287e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17288f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f17289g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17290h;
    public TextView i;
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
        this.f17288f = (TextView) findViewById(R.id.concern_unread_tip_title);
        this.f17287e = (ImageView) findViewById(R.id.concern_unread_tip_close);
        this.f17289g = (LinearLayout) findViewById(R.id.concern_unread_tip_header_box);
        this.f17290h = (TextView) findViewById(R.id.concern_unread_tip_info);
        this.i = (TextView) findViewById(R.id.concern_unread_tip_show);
        this.j = (ImageView) findViewById(R.id.concern_unread_tip_show_arrow);
        setPadding(0, 0, 0, l.g(context, R.dimen.tbds44));
        b();
    }

    public void b() {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f17288f, R.color.CAM_X0105);
        SkinManager.setImageResource(this.f17287e, R.drawable.icon_home_card_delete);
        SkinManager.setViewTextColor(this.f17290h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0109);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.k = bdUniqueId;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.f17287e.setOnClickListener(onClickListener);
    }

    public void setData(e eVar) {
        if (eVar == null) {
            return;
        }
        if (!eVar.a()) {
            setVisibility(8);
            return;
        }
        if (eVar.f63185c > 0) {
            b.i().v(b.m("concern_unread_tip_next_show_time"), System.currentTimeMillis() + eVar.f63185c);
        }
        if (this.f17290h != null && !StringUtils.isNull(eVar.f63186d)) {
            this.f17290h.setText(eVar.f63186d);
        }
        LinearLayout linearLayout = this.f17289g;
        if (linearLayout == null || eVar.f63184b == null) {
            return;
        }
        linearLayout.removeAllViews();
        List<String> list = eVar.f63184b;
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (!StringUtils.isNull(str)) {
                FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.concern_unread_tip_head_group, null);
                int i2 = this.l;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
                if (i > 0) {
                    layoutParams.leftMargin = this.m;
                }
                frameLayout.setLayoutParams(layoutParams);
                HeadImageView headImageView = (HeadImageView) frameLayout.findViewById(R.id.inner_img);
                headImageView.setIsRound(true);
                headImageView.setDrawBorder(false);
                SkinManager.setImageResource((ImageView) frameLayout.findViewById(R.id.out_img), R.drawable.bg_unread_tip_head_border);
                this.f17289g.addView(frameLayout);
                headImageView.setPageId(this.k);
                headImageView.W(str, 12, false);
            }
        }
    }

    public ConcernUnreadTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ConcernUnreadTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
