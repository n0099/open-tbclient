package com.baidu.tieba.funad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class FunAdNativePicView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public View f16124e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f16125f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16126g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f16127h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f16128i;

    public FunAdNativePicView(Context context) {
        this(context, null);
    }

    private void setImageData(List<String> list) {
        if (ListUtils.getCount(list) != 0) {
            if (list.size() == 1) {
                this.f16124e.setVisibility(8);
                this.f16128i.setVisibility(0);
                c((String) ListUtils.getItem(list, 0));
                return;
            }
            this.f16128i.setVisibility(8);
            this.f16124e.setVisibility(0);
            if (ListUtils.getCount(list) == 2) {
                e((String) ListUtils.getItem(list, 0), this.f16125f);
                e((String) ListUtils.getItem(list, 1), this.f16126g);
                this.f16127h.Q();
                return;
            } else if (ListUtils.getCount(list) >= 3) {
                this.f16126g.setVisibility(0);
                e((String) ListUtils.getItem(list, 0), this.f16125f);
                e((String) ListUtils.getItem(list, 1), this.f16126g);
                e((String) ListUtils.getItem(list, 2), this.f16127h);
                return;
            } else {
                this.f16124e.setVisibility(8);
                return;
            }
        }
        this.f16128i.setVisibility(8);
        this.f16124e.setVisibility(8);
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
        LayoutInflater.from(getContext()).inflate(R.layout.fun_ad_native_pic, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f16124e = findViewById(R.id.fun_ad_img_more_container);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.fun_ad_img_more_one);
        this.f16125f = tbImageView;
        tbImageView.setDrawCorner(true);
        this.f16125f.setPlaceHolder(2);
        this.f16125f.setRadiusById(R.string.J_X12);
        this.f16125f.setConrers(15);
        a(this.f16125f);
        TbImageView tbImageView2 = (TbImageView) findViewById(R.id.fun_ad_img_more_two);
        this.f16126g = tbImageView2;
        tbImageView2.setDrawCorner(false);
        this.f16126g.setPlaceHolder(2);
        this.f16126g.setRadiusById(R.string.J_X02);
        this.f16126g.setConrers(15);
        a(this.f16126g);
        TbImageView tbImageView3 = (TbImageView) findViewById(R.id.fun_ad_img_more_three);
        this.f16127h = tbImageView3;
        tbImageView3.setDrawCorner(true);
        this.f16127h.setPlaceHolder(2);
        this.f16127h.setRadiusById(R.string.J_X11);
        this.f16127h.setConrers(15);
        a(this.f16127h);
        TbImageView tbImageView4 = (TbImageView) findViewById(R.id.fun_ad_img_big_one);
        this.f16128i = tbImageView4;
        tbImageView4.setDrawCorner(true);
        this.f16128i.setPlaceHolder(3);
        this.f16128i.setRadiusById(R.string.J_X05);
        this.f16128i.setConrers(15);
        a(this.f16128i);
    }

    public final void c(String str) {
        if (!StringHelper.equals(str, this.f16128i.getUrl())) {
            this.f16128i.Q();
        }
        this.f16128i.U(str, 10, false);
    }

    public void d() {
        SkinManager.setBackgroundColor(this.f16124e, R.color.CAM_X0205);
        this.f16128i.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f16125f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f16125f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f16125f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
    }

    public final void e(String str, TbImageView tbImageView) {
        if (!StringHelper.equals(str, tbImageView.getUrl())) {
            tbImageView.Q();
        }
        tbImageView.U(str, 10, false);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public void setFunNativeAd(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        setImageData(list);
    }

    public FunAdNativePicView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }
}
