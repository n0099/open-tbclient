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
    public static final int f15062i = R.color.CAM_X0204;

    /* renamed from: e  reason: collision with root package name */
    public View f15063e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15064f;

    /* renamed from: g  reason: collision with root package name */
    public View f15065g;

    /* renamed from: h  reason: collision with root package name */
    public int f15066h;

    public CardGroupDividerView(Context context) {
        super(context);
        this.f15066h = f15062i;
        a();
    }

    private void setDividerColor(int i2) {
        this.f15066h = i2;
        SkinManager.setBackgroundColor(this.f15065g, i2);
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.card_divider_view, (ViewGroup) this, true);
        this.f15063e = findViewById(R.id.card_divider_top_margin);
        this.f15064f = (TextView) findViewById(R.id.card_divider_tv);
        this.f15065g = findViewById(R.id.bottom_line);
        b();
    }

    public void b() {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f15063e, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f15064f, R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.f15065g, this.f15066h);
    }

    public View getBotttomLine() {
        return this.f15065g;
    }

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f15064f;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setTitleText(String str) {
        this.f15064f.setText(str);
    }

    public void setTitleTextSize(int i2, float f2) {
        this.f15064f.setTextSize(i2, f2);
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15066h = f15062i;
        a();
    }

    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15066h = f15062i;
        a();
    }
}
