package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.o0.e3.c;
/* loaded from: classes4.dex */
public class NEGFeedBackReasonCheckBox extends CheckBox {

    /* renamed from: e  reason: collision with root package name */
    public Context f13553e;

    /* renamed from: f  reason: collision with root package name */
    public int f13554f;

    /* renamed from: g  reason: collision with root package name */
    public GradientDrawable f13555g;

    /* renamed from: h  reason: collision with root package name */
    public GradientDrawable f13556h;

    /* renamed from: i  reason: collision with root package name */
    public GradientDrawable f13557i;
    public StateListDrawable j;
    public CustomMessageListener k;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                NEGFeedBackReasonCheckBox.this.a();
            }
        }
    }

    public NEGFeedBackReasonCheckBox(Context context) {
        super(context);
        this.f13553e = null;
        this.f13554f = 3;
        this.k = new a(2001304);
        this.f13553e = context;
        b();
    }

    public void a() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.f13554f) {
            c(R.string.J_X07, l.g(this.f13553e, R.dimen.L_X01), R.color.CAM_X0902, R.color.CAM_X0302, R.color.CAM_X0902);
            SkinManager.setViewCheckedTextColorSelector(this, R.color.CAM_X0105, R.color.CAM_X0302, R.color.CAM_X0105);
            this.f13554f = skinType;
        }
    }

    public final void b() {
        int g2 = l.g(this.f13553e, R.dimen.ds24);
        setPadding(g2, 0, g2, 0);
        setButtonDrawable((Drawable) null);
    }

    public final void c(int i2, int i3, int i4, int i5, int i6) {
        int parseInt = Integer.parseInt(TbadkCoreApplication.getInst().getResources().getString(i2).split(",")[0]);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f13555g = gradientDrawable;
        gradientDrawable.setShape(0);
        float f2 = parseInt;
        this.f13555g.setCornerRadius(f2);
        this.f13555g.setStroke(i3, SkinManager.getColor(i4));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.f13556h = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.f13556h.setCornerRadius(f2);
        this.f13556h.setStroke(i3, c.a(SkinManager.getColor(i5), SkinManager.RESOURCE_ALPHA_PRESS));
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.f13557i = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.f13557i.setCornerRadius(f2);
        this.f13557i.setStroke(i3, c.a(SkinManager.getColor(i6), SkinManager.RESOURCE_ALPHA_DISABLE));
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.j = stateListDrawable;
        stateListDrawable.addState(new int[]{16842912}, this.f13556h);
        this.j.addState(new int[]{-16842910}, this.f13557i);
        this.j.addState(new int[0], this.f13555g);
        setBackgroundDrawable(this.j);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.k);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.k);
    }

    public NEGFeedBackReasonCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13553e = null;
        this.f13554f = 3;
        this.k = new a(2001304);
        this.f13553e = context;
        b();
    }

    public NEGFeedBackReasonCheckBox(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13553e = null;
        this.f13554f = 3;
        this.k = new a(2001304);
        this.f13553e = context;
        b();
    }
}
