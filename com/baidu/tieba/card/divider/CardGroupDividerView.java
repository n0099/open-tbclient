package com.baidu.tieba.card.divider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class CardGroupDividerView extends LinearLayout {

    /* renamed from: i  reason: collision with root package name */
    public static final int f14280i = R.color.CAM_X0204;

    /* renamed from: e  reason: collision with root package name */
    public View f14281e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f14282f;

    /* renamed from: g  reason: collision with root package name */
    public View f14283g;

    /* renamed from: h  reason: collision with root package name */
    public int f14284h;

    public CardGroupDividerView(Context context) {
        super(context);
        this.f14284h = f14280i;
        a();
    }

    private void setDividerColor(int i2) {
        this.f14284h = i2;
        SkinManager.setBackgroundColor(this.f14283g, i2);
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.card_divider_view, (ViewGroup) this, true);
        this.f14281e = findViewById(R.id.card_divider_top_margin);
        this.f14282f = (TextView) findViewById(R.id.card_divider_tv);
        this.f14283g = findViewById(R.id.bottom_line);
        b();
    }

    public void b() {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f14281e, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f14282f, R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.f14283g, this.f14284h);
    }

    public View getBotttomLine() {
        return this.f14283g;
    }

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f14282f;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setTitleText(String str) {
        this.f14282f.setText(str);
    }

    public void setTitleTextSize(int i2, float f2) {
        this.f14282f.setTextSize(i2, f2);
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14284h = f14280i;
        a();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14284h = f14280i;
        a();
    }
}
