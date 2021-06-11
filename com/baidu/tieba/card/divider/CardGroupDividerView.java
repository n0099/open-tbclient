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
    public static final int f14337i = R.color.CAM_X0204;

    /* renamed from: e  reason: collision with root package name */
    public View f14338e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f14339f;

    /* renamed from: g  reason: collision with root package name */
    public View f14340g;

    /* renamed from: h  reason: collision with root package name */
    public int f14341h;

    public CardGroupDividerView(Context context) {
        super(context);
        this.f14341h = f14337i;
        a();
    }

    private void setDividerColor(int i2) {
        this.f14341h = i2;
        SkinManager.setBackgroundColor(this.f14340g, i2);
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.card_divider_view, (ViewGroup) this, true);
        this.f14338e = findViewById(R.id.card_divider_top_margin);
        this.f14339f = (TextView) findViewById(R.id.card_divider_tv);
        this.f14340g = findViewById(R.id.bottom_line);
        b();
    }

    public void b() {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f14338e, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f14339f, R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.f14340g, this.f14341h);
    }

    public View getBotttomLine() {
        return this.f14340g;
    }

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f14339f;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setTitleText(String str) {
        this.f14339f.setText(str);
    }

    public void setTitleTextSize(int i2, float f2) {
        this.f14339f.setTextSize(i2, f2);
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14341h = f14337i;
        a();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14341h = f14337i;
        a();
    }
}
