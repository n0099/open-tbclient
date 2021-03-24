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
import d.b.b.e.p.l;
import d.b.h0.r.q.v0;
import d.b.i0.h.c;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class NEGFeedBackView extends AppCompatImageView {

    /* renamed from: e  reason: collision with root package name */
    public Context f14436e;

    /* renamed from: f  reason: collision with root package name */
    public long f14437f;

    /* renamed from: g  reason: collision with root package name */
    public int f14438g;

    /* renamed from: h  reason: collision with root package name */
    public int f14439h;
    public int i;
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
            if (currentTimeMillis - NEGFeedBackView.this.f14437f > 500) {
                NEGFeedBackView.this.r(view);
            }
            NEGFeedBackView.this.f14437f = currentTimeMillis;
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
        this.f14437f = 0L;
        this.j = R.drawable.icon_pure_card_more22;
        this.k = R.color.CAM_X0111;
        this.m = new a();
        this.f14436e = tbPageContext.getPageActivity();
        p(tbPageContext);
    }

    public void g(ViewGroup viewGroup, int i, int i2) {
        setPadding(0, i2, i2, 0);
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            viewGroup.addView(this, layoutParams);
        } else if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
            layoutParams2.gravity = 53;
            viewGroup.addView(this, layoutParams2);
        }
    }

    public void n(ViewGroup viewGroup, int i, int i2) {
        int g2 = l.g(this.f14436e, R.dimen.tbds24);
        setPadding(i2, 0, i2, 0);
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, i);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.rightMargin = g2;
            viewGroup.addView(this, layoutParams);
        } else if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
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

    public void setLeftPadding(int i) {
        this.f14438g = i;
        setPadding(i, this.i, this.f14439h, 0);
    }

    public void setRightPadding(int i) {
        this.f14439h = i;
        setPadding(this.f14438g, this.i, i, 0);
    }

    public void setTopPadding(int i) {
        this.i = i;
        setPadding(this.f14438g, i, this.f14439h, 0);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.l.A(bdUniqueId);
    }

    public void setWebPResId(int i, int i2) {
        this.j = i;
        this.k = i2;
        setImageDrawable(WebPManager.getPureDrawable(i, SkinManager.getColor(i2), WebPManager.ResourceStateType.NORMAL_PRESS));
    }
}
