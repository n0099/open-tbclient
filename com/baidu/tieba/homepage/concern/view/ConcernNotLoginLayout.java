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
import d.b.c.e.p.l;
import d.b.h0.r.f0.m.a;
/* loaded from: classes4.dex */
public class ConcernNotLoginLayout extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Context f16717e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f16718f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16719g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f16720h;

    public ConcernNotLoginLayout(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_not_login_layout, (ViewGroup) this, true);
        this.f16717e = context;
        this.f16718f = (ImageView) inflate.findViewById(R.id.iv_concern_not_login_emotion_pic);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_concern_you_not_login);
        this.f16719g = textView;
        textView.setTextSize(0, l.g(context, R.dimen.T_X06));
        this.f16720h = (TBSpecificationBtn) inflate.findViewById(R.id.tv_concern_login_and_see_more);
        a aVar = new a();
        this.f16720h.setText(context.getResources().getString(R.string.concern_login_and_see_more));
        this.f16720h.setTextSize(R.dimen.T_X05);
        this.f16720h.setTextHorizontalCenter(true);
        this.f16720h.setConfig(aVar);
        this.f16720h.setOnClickListener(this);
    }

    public void b(int i) {
        SkinManager.setImageResource(this.f16718f, R.drawable.new_pic_emotion_09);
        SkinManager.setViewTextColor(this.f16719g, R.color.CAM_X0107);
        TBSpecificationBtn tBSpecificationBtn = this.f16720h;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_concern_login_and_see_more) {
            ViewHelper.checkUpIsLogin(this.f16717e);
            HomePageStatic.f16645a = true;
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
