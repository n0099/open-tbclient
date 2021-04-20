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
import d.b.h0.w.a;
import d.b.h0.w.h;
import d.b.h0.w.m;
/* loaded from: classes3.dex */
public class BLauncher extends ImageView implements h {

    /* renamed from: e  reason: collision with root package name */
    public TextView f13491e;

    /* renamed from: f  reason: collision with root package name */
    public int f13492f;

    /* renamed from: g  reason: collision with root package name */
    public int f13493g;

    /* renamed from: h  reason: collision with root package name */
    public m f13494h;
    public Drawable i;
    public boolean j;

    public BLauncher(Context context, m mVar) {
        super(context);
        this.f13493g = 0;
        this.j = false;
        if (mVar == null) {
            return;
        }
        this.f13494h = mVar;
        setIcon();
        setToolId(mVar.f51950c);
    }

    public void a(String str) {
        if (getVisibility() == 8 || TextUtils.isEmpty(str)) {
            return;
        }
        TextView textView = this.f13491e;
        if (textView == null) {
            TextView textView2 = new TextView(getContext());
            this.f13491e = textView2;
            textView2.setTag("tip");
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).addView(this.f13491e);
            }
        } else if (textView.getParent() == null) {
            ViewParent parent2 = getParent();
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).addView(this.f13491e);
            }
        }
        SkinManager.setViewTextColor(this.f13491e, R.color.CAM_X0111, 1, this.f13493g);
        this.f13491e.setGravity(17);
        if (!str.equals(" ")) {
            this.f13491e.setTextSize(10.0f);
            this.f13491e.setText(str);
            SkinManager.setBackgroundResource(this.f13491e, R.drawable.icon_news_red_dot, this.f13493g);
            this.f13491e.setVisibility(0);
            return;
        }
        this.f13491e.setVisibility(8);
        this.f13494h.o = true;
        invalidate();
    }

    @Override // d.b.h0.w.h
    public void b() {
        setVisibility(0);
    }

    public void c() {
        TextView textView = this.f13491e;
        if (textView != null) {
            textView.setVisibility(8);
            e();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f13494h.o) {
            this.i = SkinManager.getDrawable(R.drawable.icon_news_red_dot);
            int width = getWidth();
            int intrinsicHeight = this.i.getIntrinsicHeight();
            this.i.setBounds(getWidth() - this.i.getIntrinsicWidth(), 0, width, intrinsicHeight);
            this.i.draw(canvas);
        }
    }

    @Override // d.b.h0.w.h
    public void e() {
        this.f13494h.o = false;
        invalidate();
    }

    public boolean getIsOutSetVisibility() {
        return this.j;
    }

    public TextView getNotice() {
        return this.f13491e;
    }

    @Override // d.b.h0.w.h
    public int getToolId() {
        return this.f13492f;
    }

    @Override // d.b.h0.w.h
    public void hide() {
        c();
        setVisibility(8);
    }

    @Override // d.b.h0.w.b
    public void onAction(a aVar) {
        if (aVar != null && aVar.f51942a == 2) {
            Object obj = aVar.f51944c;
            if (obj == null) {
                c();
            } else if (obj instanceof String) {
                a((String) obj);
            }
        }
    }

    @Override // d.b.h0.w.h
    public void onChangeSkinType(int i) {
        this.f13493g = i;
        setIcon();
        TextView textView = this.f13491e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0111, 1, i);
            if (!TextUtils.isEmpty(this.f13491e.getText()) && !TextUtils.isEmpty(this.f13491e.getText().toString().trim())) {
                SkinManager.setBackgroundResource(this.f13491e, R.drawable.icon_news_head_prompt_one, i);
            } else {
                SkinManager.setBackgroundResource(this.f13491e, R.drawable.icon_news_down_bar_one, i);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        TextView textView = this.f13491e;
        if (textView != null && textView.getVisibility() == 0 && this.f13491e.getParent() == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).addView(this.f13491e);
            }
        }
    }

    public void setIcon() {
        m mVar = this.f13494h;
        if (mVar == null) {
            return;
        }
        if (mVar.f51954g) {
            SvgManager svgManager = SvgManager.getInstance();
            m mVar2 = this.f13494h;
            setImageDrawable(svgManager.getSeletableDrawableForEditorTools(mVar2.f51951d, mVar2.f51952e, this.f13493g));
        } else if (mVar.f51955h) {
            setImageDrawable(WebPManager.getSeletableDrawableForEditorToolsEM(mVar.f51951d, mVar.f51952e, this.f13493g));
        } else {
            SkinManager.setImageResource(this, mVar.f51951d, this.f13493g);
        }
        if (this.f13494h.d()) {
            return;
        }
        setEnabled(false);
    }

    @Override // d.b.h0.w.h
    public void setName(String str) {
    }

    public void setOutSetVisibilty(boolean z) {
        this.j = z;
    }

    public void setToolId(int i) {
        this.f13492f = i;
    }
}
