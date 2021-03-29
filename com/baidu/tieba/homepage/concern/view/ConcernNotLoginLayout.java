package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
import d.b.b.e.p.l;
import d.b.h0.r.f0.m.a;
/* loaded from: classes3.dex */
public class ConcernNotLoginLayout extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Context f17044e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f17045f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17046g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f17047h;

    public ConcernNotLoginLayout(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_not_login_layout, (ViewGroup) this, true);
        this.f17044e = context;
        this.f17045f = (ImageView) inflate.findViewById(R.id.iv_concern_not_login_emotion_pic);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_concern_you_not_login);
        this.f17046g = textView;
        textView.setTextSize(0, l.g(context, R.dimen.T_X06));
        this.f17047h = (TBSpecificationBtn) inflate.findViewById(R.id.tv_concern_login_and_see_more);
        a aVar = new a();
        this.f17047h.setText(context.getResources().getString(R.string.concern_login_and_see_more));
        this.f17047h.setTextSize(R.dimen.T_X05);
        this.f17047h.setTextHorizontalCenter(true);
        this.f17047h.setConfig(aVar);
        this.f17047h.setOnClickListener(this);
    }

    public void b(int i) {
        SkinManager.setImageResource(this.f17045f, R.drawable.new_pic_emotion_09);
        SkinManager.setViewTextColor(this.f17046g, R.color.CAM_X0107);
        TBSpecificationBtn tBSpecificationBtn = this.f17047h;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_concern_login_and_see_more) {
            ViewHelper.checkUpIsLogin(this.f17044e);
            HomePageStatic.f16972a = true;
        }
    }

    public ConcernNotLoginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ConcernNotLoginLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
