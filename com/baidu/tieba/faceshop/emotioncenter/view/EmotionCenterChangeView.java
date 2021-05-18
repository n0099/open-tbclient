package com.baidu.tieba.faceshop.emotioncenter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
import com.baidu.tieba.faceshop.emotioncenter.model.EmotionChangeModel;
import d.a.k0.l0.y.d.b;
import java.util.List;
/* loaded from: classes4.dex */
public class EmotionCenterChangeView extends LinearLayout implements View.OnClickListener, b {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f14914e;

    /* renamed from: f  reason: collision with root package name */
    public EmotionHorizontalView f14915f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionHorizontalView f14916g;

    /* renamed from: h  reason: collision with root package name */
    public EmotionHorizontalView f14917h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f14918i;
    public LinearLayout j;
    public RelativeLayout k;
    public View l;
    public TextView m;
    public TextView n;
    public EmotionChangeModel o;
    public Animation p;
    public List<EmotionPackageData> q;

    public EmotionCenterChangeView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.p = null;
        this.f14914e = tbPageContext;
        b();
    }

    private Animation getClickRotateAnimation() {
        if (this.p == null) {
            this.p = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.p.setInterpolator(new LinearInterpolator());
            this.p.setFillAfter(true);
        }
        return this.p;
    }

    @Override // d.a.k0.l0.y.d.b
    public void T(EmotionCenterData emotionCenterData) {
    }

    public void a() {
        ImageView imageView = this.f14918i;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    @Override // d.a.k0.l0.y.d.b
    public void a0(EmotionCenterData emotionCenterData) {
        a();
        if (emotionCenterData == null || ListUtils.isEmpty(emotionCenterData.package_list)) {
            return;
        }
        setData(emotionCenterData.package_list);
    }

    public final void b() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.emotion_category_layout, this);
        this.f14915f = new EmotionHorizontalView(this.f14914e);
        this.f14916g = new EmotionHorizontalView(this.f14914e);
        this.f14917h = new EmotionHorizontalView(this.f14914e);
        this.f14915f.f(TbadkCoreApplication.getInst().getSkinType());
        this.f14916g.f(TbadkCoreApplication.getInst().getSkinType());
        this.f14917h.f(TbadkCoreApplication.getInst().getSkinType());
        addView(this.f14915f);
        addView(this.f14916g);
        addView(this.f14917h);
        this.f14915f.setVisibility(8);
        this.f14916g.setVisibility(8);
        this.f14917h.setVisibility(8);
        this.j = (LinearLayout) findViewById(R.id.emotion_change_item);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.change_head_layout);
        this.k = relativeLayout;
        relativeLayout.setVisibility(8);
        ImageView imageView = (ImageView) findViewById(R.id.emotion_change_iv);
        this.f14918i = imageView;
        imageView.setOnClickListener(this);
        this.l = findViewById(R.id.category_line_top);
        this.m = (TextView) findViewById(R.id.emotion_title);
        TextView textView = (TextView) findViewById(R.id.emotion_function);
        this.n = textView;
        textView.setOnClickListener(this);
        this.o = new EmotionChangeModel(this.f14914e);
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(int i2) {
        SkinManager.setBackgroundColor(this.l, R.color.common_color_10312);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0107);
        SkinManager.setImageResource(this.f14918i, R.drawable.emotion_icon_refresh);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
    }

    public void d() {
        EmotionChangeModel emotionChangeModel = this.o;
        if (emotionChangeModel != null) {
            emotionChangeModel.s(this);
        }
    }

    public void e() {
        ImageView imageView = this.f14918i;
        if (imageView != null) {
            imageView.startAnimation(getClickRotateAnimation());
        }
    }

    public void f(EmotionPackageData emotionPackageData) {
        if (emotionPackageData == null || ListUtils.isEmpty(this.q)) {
            return;
        }
        for (EmotionPackageData emotionPackageData2 : this.q) {
            if (emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                setData(this.q);
                return;
            }
        }
    }

    public List<EmotionPackageData> getDataList() {
        return this.q;
    }

    @Override // d.a.k0.l0.y.d.b
    public void h0(EmotionCenterData emotionCenterData) {
        a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EmotionChangeModel emotionChangeModel;
        if ((view == this.f14918i || view == this.n) && (emotionChangeModel = this.o) != null) {
            emotionChangeModel.s(this);
            e();
        }
    }

    public void setData(List<EmotionPackageData> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.q = list;
        this.j.setVisibility(0);
        this.k.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            this.f14915f.setVisibility(0);
            this.f14915f.setData(list.get(0));
            this.f14916g.setVisibility(8);
            this.f14917h.setVisibility(8);
        } else if (size == 2) {
            this.f14915f.setVisibility(0);
            this.f14915f.setData(list.get(0));
            this.f14916g.setVisibility(0);
            this.f14916g.setData(list.get(1));
            this.f14917h.setVisibility(8);
        } else {
            this.f14915f.setVisibility(0);
            this.f14915f.setData(list.get(0));
            this.f14916g.setVisibility(0);
            this.f14916g.setData(list.get(1));
            this.f14917h.setVisibility(0);
            this.f14917h.setData(list.get(2));
        }
    }

    public EmotionCenterChangeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = null;
        b();
    }

    public EmotionCenterChangeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.p = null;
        b();
    }
}
