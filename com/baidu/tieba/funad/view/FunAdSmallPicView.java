package com.baidu.tieba.funad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.fun.ad.sdk.FunNativeAd;
import d.a.i0.r.u.c;
import d.a.j0.s0.b;
/* loaded from: classes4.dex */
public class FunAdSmallPicView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f16767e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f16768f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f16769g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16770h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16771i;
    public TextView j;

    public FunAdSmallPicView(Context context) {
        this(context, null);
    }

    public final void a(TbImageView tbImageView) {
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setIsLongPic(false);
        tbImageView.setIsSmartCrop(false);
        tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.setDrawBorder(true);
        tbImageView.setPlaceHolder(2);
    }

    public final void b() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fun_ad_small_pic, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f16767e = (TbImageView) inflate.findViewById(R.id.ad_small_image);
        this.f16771i = (TextView) inflate.findViewById(R.id.ad_small_desc);
        this.j = (TextView) inflate.findViewById(R.id.ad_small_source);
        this.f16770h = (TextView) inflate.findViewById(R.id.ad_small_title);
        this.f16768f = (ImageView) inflate.findViewById(R.id.ad_small_labelIcon);
        this.f16769g = (ImageView) inflate.findViewById(R.id.ad_small_dislike);
        this.f16767e.setRadiusById(R.string.J_X05);
        this.f16767e.setConrers(15);
        a(this.f16767e);
    }

    public void c() {
        WebPManager.setPureDrawable(this.f16769g, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
        c.d(this.f16771i).q(R.color.CAM_X0105);
        c.d(this.f16770h).q(R.color.CAM_X0109);
        c.d(this.j).q(R.color.CAM_X0109);
        this.f16767e.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
    }

    public void setData(FunNativeAd funNativeAd, String str) {
        if (funNativeAd == null) {
            return;
        }
        this.f16770h.setText(funNativeAd.getTitle());
        this.f16771i.setText(funNativeAd.getDescription());
        b.o(this.f16768f, funNativeAd);
        if (!StringHelper.equals(str, this.f16767e.getUrl())) {
            this.f16767e.Q();
        }
        this.f16767e.V(str, 10, false);
    }

    public void setFeedBackListener(View.OnClickListener onClickListener) {
        this.f16769g.setOnClickListener(onClickListener);
    }

    public FunAdSmallPicView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }
}
