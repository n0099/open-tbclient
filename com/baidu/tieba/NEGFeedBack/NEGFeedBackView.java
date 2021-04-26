package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.i0.r.q.v0;
import d.a.j0.h.c;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class NEGFeedBackView extends AppCompatImageView {

    /* renamed from: e  reason: collision with root package name */
    public Context f14171e;

    /* renamed from: f  reason: collision with root package name */
    public long f14172f;

    /* renamed from: g  reason: collision with root package name */
    public int f14173g;

    /* renamed from: h  reason: collision with root package name */
    public int f14174h;

    /* renamed from: i  reason: collision with root package name */
    public int f14175i;
    public int j;
    public int k;
    public c l;
    public View.OnClickListener m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NEGFeedBackView.this.o();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - NEGFeedBackView.this.f14172f > 500) {
                NEGFeedBackView.this.r(view);
            }
            NEGFeedBackView.this.f14172f = currentTimeMillis;
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onCheckedChanged(v0 v0Var, CompoundButton compoundButton, boolean z);

        void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, v0 v0Var);

        void onNEGFeedbackWindowShow(v0 v0Var);
    }

    public NEGFeedBackView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.f14172f = 0L;
        this.j = R.drawable.icon_pure_card_more22;
        this.k = R.color.CAM_X0111;
        this.m = new a();
        this.f14171e = tbPageContext.getPageActivity();
        p(tbPageContext);
    }

    public void l(ViewGroup viewGroup, int i2, int i3) {
        setPadding(0, i3, i3, 0);
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            viewGroup.addView(this, layoutParams);
        } else if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, i2);
            layoutParams2.gravity = 53;
            viewGroup.addView(this, layoutParams2);
        }
    }

    public void n(ViewGroup viewGroup, int i2, int i3) {
        int g2 = l.g(this.f14171e, R.dimen.tbds24);
        setPadding(i3, 0, i3, 0);
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, i2);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.rightMargin = g2;
            viewGroup.addView(this, layoutParams);
        } else if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, i2);
            layoutParams2.gravity = 53;
            viewGroup.addView(this, layoutParams2);
        }
    }

    public void o() {
        this.l.l();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.l.r();
    }

    public final void p(TbPageContext tbPageContext) {
        this.l = new c(tbPageContext, this);
        setOnClickListener(this.m);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        q();
    }

    public void q() {
        setImageDrawable(WebPManager.getPureDrawable(this.j, SkinManager.getColor(this.k), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public final void r(View view) {
        this.l.B(view);
    }

    public void s(boolean z) {
        this.l.C(z);
    }

    public void setACRotateAnimation() {
    }

    public void setAutoProcess(boolean z) {
        this.l.u(z);
    }

    public void setCWRotateAnimation() {
    }

    public void setData(v0 v0Var) {
        this.l.v(v0Var);
    }

    public void setDefaultLayout() {
        q();
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.l.w(strArr);
    }

    public void setEventCallback(b bVar) {
        this.l.x(bVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.l.y(z);
    }

    public void setHeadText(String str) {
        this.l.z(str);
    }

    public void setLeftPadding(int i2) {
        this.f14173g = i2;
        setPadding(i2, this.f14175i, this.f14174h, 0);
    }

    public void setRightPadding(int i2) {
        this.f14174h = i2;
        setPadding(this.f14173g, this.f14175i, i2, 0);
    }

    public void setTopPadding(int i2) {
        this.f14175i = i2;
        setPadding(this.f14173g, i2, this.f14174h, 0);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.l.A(bdUniqueId);
    }

    public void setWebPResId(int i2, int i3) {
        this.j = i2;
        this.k = i3;
        setImageDrawable(WebPManager.getPureDrawable(i2, SkinManager.getColor(i3), WebPManager.ResourceStateType.NORMAL_PRESS));
    }
}
