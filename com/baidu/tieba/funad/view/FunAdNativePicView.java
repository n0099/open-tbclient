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
    public View f15980e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f15981f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f15982g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f15983h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f15984i;

    public FunAdNativePicView(Context context) {
        this(context, null);
    }

    private void setImageData(List<String> list) {
        if (ListUtils.getCount(list) != 0) {
            if (list.size() == 1) {
                this.f15980e.setVisibility(8);
                this.f15984i.setVisibility(0);
                c((String) ListUtils.getItem(list, 0));
                return;
            }
            this.f15984i.setVisibility(8);
            this.f15980e.setVisibility(0);
            if (ListUtils.getCount(list) == 2) {
                e((String) ListUtils.getItem(list, 0), this.f15981f);
                e((String) ListUtils.getItem(list, 1), this.f15982g);
                this.f15983h.Q();
                return;
            } else if (ListUtils.getCount(list) >= 3) {
                this.f15982g.setVisibility(0);
                e((String) ListUtils.getItem(list, 0), this.f15981f);
                e((String) ListUtils.getItem(list, 1), this.f15982g);
                e((String) ListUtils.getItem(list, 2), this.f15983h);
                return;
            } else {
                this.f15980e.setVisibility(8);
                return;
            }
        }
        this.f15984i.setVisibility(8);
        this.f15980e.setVisibility(8);
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
        this.f15980e = findViewById(R.id.fun_ad_img_more_container);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.fun_ad_img_more_one);
        this.f15981f = tbImageView;
        tbImageView.setDrawCorner(true);
        this.f15981f.setPlaceHolder(2);
        this.f15981f.setRadiusById(R.string.J_X12);
        this.f15981f.setConrers(15);
        a(this.f15981f);
        TbImageView tbImageView2 = (TbImageView) findViewById(R.id.fun_ad_img_more_two);
        this.f15982g = tbImageView2;
        tbImageView2.setDrawCorner(false);
        this.f15982g.setPlaceHolder(2);
        this.f15982g.setRadiusById(R.string.J_X02);
        this.f15982g.setConrers(15);
        a(this.f15982g);
        TbImageView tbImageView3 = (TbImageView) findViewById(R.id.fun_ad_img_more_three);
        this.f15983h = tbImageView3;
        tbImageView3.setDrawCorner(true);
        this.f15983h.setPlaceHolder(2);
        this.f15983h.setRadiusById(R.string.J_X11);
        this.f15983h.setConrers(15);
        a(this.f15983h);
        TbImageView tbImageView4 = (TbImageView) findViewById(R.id.fun_ad_img_big_one);
        this.f15984i = tbImageView4;
        tbImageView4.setDrawCorner(true);
        this.f15984i.setPlaceHolder(3);
        this.f15984i.setRadiusById(R.string.J_X05);
        this.f15984i.setConrers(15);
        a(this.f15984i);
    }

    public final void c(String str) {
        if (!StringHelper.equals(str, this.f15984i.getUrl())) {
            this.f15984i.Q();
        }
        this.f15984i.V(str, 10, false);
    }

    public void d() {
        SkinManager.setBackgroundColor(this.f15980e, R.color.CAM_X0205);
        this.f15984i.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f15981f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f15981f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f15981f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
    }

    public final void e(String str, TbImageView tbImageView) {
        if (!StringHelper.equals(str, tbImageView.getUrl())) {
            tbImageView.Q();
        }
        tbImageView.V(str, 10, false);
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
