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
    public View f16518e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f16519f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16520g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f16521h;
    public TbImageView i;

    public FunAdNativePicView(Context context) {
        this(context, null);
    }

    private void setImageData(List<String> list) {
        if (ListUtils.getCount(list) != 0) {
            if (list.size() == 1) {
                this.f16518e.setVisibility(8);
                this.i.setVisibility(0);
                c((String) ListUtils.getItem(list, 0));
                return;
            }
            this.i.setVisibility(8);
            this.f16518e.setVisibility(0);
            if (ListUtils.getCount(list) == 2) {
                e((String) ListUtils.getItem(list, 0), this.f16519f);
                e((String) ListUtils.getItem(list, 1), this.f16520g);
                this.f16521h.S();
                return;
            } else if (ListUtils.getCount(list) >= 3) {
                this.f16520g.setVisibility(0);
                e((String) ListUtils.getItem(list, 0), this.f16519f);
                e((String) ListUtils.getItem(list, 1), this.f16520g);
                e((String) ListUtils.getItem(list, 2), this.f16521h);
                return;
            } else {
                this.f16518e.setVisibility(8);
                return;
            }
        }
        this.i.setVisibility(8);
        this.f16518e.setVisibility(8);
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
        this.f16518e = findViewById(R.id.fun_ad_img_more_container);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.fun_ad_img_more_one);
        this.f16519f = tbImageView;
        tbImageView.setDrawCorner(true);
        this.f16519f.setPlaceHolder(2);
        this.f16519f.setRadiusById(R.string.J_X12);
        this.f16519f.setConrers(15);
        a(this.f16519f);
        TbImageView tbImageView2 = (TbImageView) findViewById(R.id.fun_ad_img_more_two);
        this.f16520g = tbImageView2;
        tbImageView2.setDrawCorner(false);
        this.f16520g.setPlaceHolder(2);
        this.f16520g.setRadiusById(R.string.J_X02);
        this.f16520g.setConrers(15);
        a(this.f16520g);
        TbImageView tbImageView3 = (TbImageView) findViewById(R.id.fun_ad_img_more_three);
        this.f16521h = tbImageView3;
        tbImageView3.setDrawCorner(true);
        this.f16521h.setPlaceHolder(2);
        this.f16521h.setRadiusById(R.string.J_X11);
        this.f16521h.setConrers(15);
        a(this.f16521h);
        TbImageView tbImageView4 = (TbImageView) findViewById(R.id.fun_ad_img_big_one);
        this.i = tbImageView4;
        tbImageView4.setDrawCorner(true);
        this.i.setPlaceHolder(3);
        this.i.setRadiusById(R.string.J_X05);
        this.i.setConrers(15);
        a(this.i);
    }

    public final void c(String str) {
        if (!StringHelper.equals(str, this.i.getUrl())) {
            this.i.S();
        }
        this.i.W(str, 10, false);
    }

    public void d() {
        SkinManager.setBackgroundColor(this.f16518e, R.color.CAM_X0205);
        this.i.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f16519f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f16519f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f16519f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
    }

    public final void e(String str, TbImageView tbImageView) {
        if (!StringHelper.equals(str, tbImageView.getUrl())) {
            tbImageView.S();
        }
        tbImageView.W(str, 10, false);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
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
