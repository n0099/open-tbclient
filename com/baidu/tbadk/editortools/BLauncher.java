package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import d.a.i0.w.a;
import d.a.i0.w.h;
import d.a.i0.w.m;
/* loaded from: classes3.dex */
public class BLauncher extends ImageView implements h {

    /* renamed from: e  reason: collision with root package name */
    public TextView f13483e;

    /* renamed from: f  reason: collision with root package name */
    public int f13484f;

    /* renamed from: g  reason: collision with root package name */
    public int f13485g;

    /* renamed from: h  reason: collision with root package name */
    public m f13486h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f13487i;
    public boolean j;

    public BLauncher(Context context, m mVar) {
        super(context);
        this.f13485g = 0;
        this.j = false;
        if (mVar == null) {
            return;
        }
        this.f13486h = mVar;
        setIcon();
        setToolId(mVar.f49957c);
    }

    public void a(String str) {
        if (getVisibility() == 8 || TextUtils.isEmpty(str)) {
            return;
        }
        TextView textView = this.f13483e;
        if (textView == null) {
            TextView textView2 = new TextView(getContext());
            this.f13483e = textView2;
            textView2.setTag("tip");
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).addView(this.f13483e);
            }
        } else if (textView.getParent() == null) {
            ViewParent parent2 = getParent();
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).addView(this.f13483e);
            }
        }
        SkinManager.setViewTextColor(this.f13483e, R.color.CAM_X0111, 1, this.f13485g);
        this.f13483e.setGravity(17);
        if (!str.equals(" ")) {
            this.f13483e.setTextSize(10.0f);
            this.f13483e.setText(str);
            SkinManager.setBackgroundResource(this.f13483e, R.drawable.icon_news_red_dot, this.f13485g);
            this.f13483e.setVisibility(0);
            return;
        }
        this.f13483e.setVisibility(8);
        this.f13486h.o = true;
        invalidate();
    }

    @Override // d.a.i0.w.h
    public void b() {
        setVisibility(0);
    }

    public void c() {
        TextView textView = this.f13483e;
        if (textView != null) {
            textView.setVisibility(8);
            e();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f13486h.o) {
            this.f13487i = SkinManager.getDrawable(R.drawable.icon_news_red_dot);
            int width = getWidth();
            int intrinsicHeight = this.f13487i.getIntrinsicHeight();
            this.f13487i.setBounds(getWidth() - this.f13487i.getIntrinsicWidth(), 0, width, intrinsicHeight);
            this.f13487i.draw(canvas);
        }
    }

    @Override // d.a.i0.w.h
    public void e() {
        this.f13486h.o = false;
        invalidate();
    }

    public boolean getIsOutSetVisibility() {
        return this.j;
    }

    public TextView getNotice() {
        return this.f13483e;
    }

    @Override // d.a.i0.w.h
    public int getToolId() {
        return this.f13484f;
    }

    @Override // d.a.i0.w.h
    public void hide() {
        c();
        setVisibility(8);
    }

    @Override // d.a.i0.w.b
    public void onAction(a aVar) {
        if (aVar != null && aVar.f49949a == 2) {
            Object obj = aVar.f49951c;
            if (obj == null) {
                c();
            } else if (obj instanceof String) {
                a((String) obj);
            }
        }
    }

    @Override // d.a.i0.w.h
    public void onChangeSkinType(int i2) {
        this.f13485g = i2;
        setIcon();
        TextView textView = this.f13483e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0111, 1, i2);
            if (!TextUtils.isEmpty(this.f13483e.getText()) && !TextUtils.isEmpty(this.f13483e.getText().toString().trim())) {
                SkinManager.setBackgroundResource(this.f13483e, R.drawable.icon_news_head_prompt_one, i2);
            } else {
                SkinManager.setBackgroundResource(this.f13483e, R.drawable.icon_news_down_bar_one, i2);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        TextView textView = this.f13483e;
        if (textView != null && textView.getVisibility() == 0 && this.f13483e.getParent() == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).addView(this.f13483e);
            }
        }
    }

    public void setIcon() {
        m mVar = this.f13486h;
        if (mVar == null) {
            return;
        }
        if (mVar.f49961g) {
            SvgManager svgManager = SvgManager.getInstance();
            m mVar2 = this.f13486h;
            setImageDrawable(svgManager.getSeletableDrawableForEditorTools(mVar2.f49958d, mVar2.f49959e, this.f13485g));
        } else if (mVar.f49962h) {
            setImageDrawable(WebPManager.getSeletableDrawableForEditorToolsEM(mVar.f49958d, mVar.f49959e, this.f13485g));
        } else {
            SkinManager.setImageResource(this, mVar.f49958d, this.f13485g);
        }
        if (this.f13486h.d()) {
            return;
        }
        setEnabled(false);
    }

    @Override // d.a.i0.w.h
    public void setName(String str) {
    }

    public void setOutSetVisibilty(boolean z) {
        this.j = z;
    }

    public void setToolId(int i2) {
        this.f13484f = i2;
    }
}
