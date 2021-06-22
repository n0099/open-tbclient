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
import d.a.n0.r.u.c;
import d.a.o0.t0.b;
/* loaded from: classes4.dex */
public class FunAdSmallPicView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f16129e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f16130f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f16131g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16132h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16133i;
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
        this.f16129e = (TbImageView) inflate.findViewById(R.id.ad_small_image);
        this.f16133i = (TextView) inflate.findViewById(R.id.ad_small_desc);
        this.j = (TextView) inflate.findViewById(R.id.ad_small_source);
        this.f16132h = (TextView) inflate.findViewById(R.id.ad_small_title);
        this.f16130f = (ImageView) inflate.findViewById(R.id.ad_small_labelIcon);
        this.f16131g = (ImageView) inflate.findViewById(R.id.ad_small_dislike);
        this.f16129e.setRadiusById(R.string.J_X05);
        this.f16129e.setConrers(15);
        a(this.f16129e);
    }

    public void c() {
        WebPManager.setPureDrawable(this.f16131g, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
        c.d(this.f16133i).s(R.color.CAM_X0105);
        c.d(this.f16132h).s(R.color.CAM_X0109);
        c.d(this.j).s(R.color.CAM_X0109);
        this.f16129e.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
    }

    public void setData(FunNativeAd funNativeAd, String str) {
        if (funNativeAd == null) {
            return;
        }
        this.f16132h.setText(funNativeAd.getTitle());
        this.f16133i.setText(funNativeAd.getDescription());
        b.o(this.f16130f, funNativeAd);
        if (!StringHelper.equals(str, this.f16129e.getUrl())) {
            this.f16129e.Q();
        }
        this.f16129e.U(str, 10, false);
    }

    public void setFeedBackListener(View.OnClickListener onClickListener) {
        this.f16131g.setOnClickListener(onClickListener);
    }

    public FunAdSmallPicView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }
}
