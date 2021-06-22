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
import d.a.n0.w.a;
import d.a.n0.w.h;
import d.a.n0.w.m;
/* loaded from: classes3.dex */
public class BLauncher extends ImageView implements h {

    /* renamed from: e  reason: collision with root package name */
    public TextView f12874e;

    /* renamed from: f  reason: collision with root package name */
    public int f12875f;

    /* renamed from: g  reason: collision with root package name */
    public int f12876g;

    /* renamed from: h  reason: collision with root package name */
    public m f12877h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f12878i;
    public boolean j;

    public BLauncher(Context context, m mVar) {
        super(context);
        this.f12876g = 0;
        this.j = false;
        if (mVar == null) {
            return;
        }
        this.f12877h = mVar;
        setIcon();
        setToolId(mVar.f54633c);
    }

    public void a(String str) {
        if (getVisibility() == 8 || TextUtils.isEmpty(str)) {
            return;
        }
        TextView textView = this.f12874e;
        if (textView == null) {
            TextView textView2 = new TextView(getContext());
            this.f12874e = textView2;
            textView2.setTag("tip");
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).addView(this.f12874e);
            }
        } else if (textView.getParent() == null) {
            ViewParent parent2 = getParent();
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).addView(this.f12874e);
            }
        }
        SkinManager.setViewTextColor(this.f12874e, R.color.CAM_X0111, 1, this.f12876g);
        this.f12874e.setGravity(17);
        if (!str.equals(" ")) {
            this.f12874e.setTextSize(10.0f);
            this.f12874e.setText(str);
            SkinManager.setBackgroundResource(this.f12874e, R.drawable.icon_news_red_dot, this.f12876g);
            this.f12874e.setVisibility(0);
            return;
        }
        this.f12874e.setVisibility(8);
        this.f12877h.o = true;
        invalidate();
    }

    @Override // d.a.n0.w.h
    public void b() {
        setVisibility(0);
    }

    public void c() {
        TextView textView = this.f12874e;
        if (textView != null) {
            textView.setVisibility(8);
            e();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f12877h.o) {
            this.f12878i = SkinManager.getDrawable(R.drawable.icon_news_red_dot);
            int width = getWidth();
            int intrinsicHeight = this.f12878i.getIntrinsicHeight();
            this.f12878i.setBounds(getWidth() - this.f12878i.getIntrinsicWidth(), 0, width, intrinsicHeight);
            this.f12878i.draw(canvas);
        }
    }

    @Override // d.a.n0.w.h
    public void e() {
        this.f12877h.o = false;
        invalidate();
    }

    public boolean getIsOutSetVisibility() {
        return this.j;
    }

    public TextView getNotice() {
        return this.f12874e;
    }

    @Override // d.a.n0.w.h
    public int getToolId() {
        return this.f12875f;
    }

    @Override // d.a.n0.w.h
    public void hide() {
        c();
        setVisibility(8);
    }

    @Override // d.a.n0.w.b
    public void onAction(a aVar) {
        if (aVar != null && aVar.f54625a == 2) {
            Object obj = aVar.f54627c;
            if (obj == null) {
                c();
            } else if (obj instanceof String) {
                a((String) obj);
            }
        }
    }

    @Override // d.a.n0.w.h
    public void onChangeSkinType(int i2) {
        this.f12876g = i2;
        setIcon();
        TextView textView = this.f12874e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0111, 1, i2);
            if (!TextUtils.isEmpty(this.f12874e.getText()) && !TextUtils.isEmpty(this.f12874e.getText().toString().trim())) {
                SkinManager.setBackgroundResource(this.f12874e, R.drawable.icon_news_head_prompt_one, i2);
            } else {
                SkinManager.setBackgroundResource(this.f12874e, R.drawable.icon_news_down_bar_one, i2);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        TextView textView = this.f12874e;
        if (textView != null && textView.getVisibility() == 0 && this.f12874e.getParent() == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).addView(this.f12874e);
            }
        }
    }

    public void setIcon() {
        m mVar = this.f12877h;
        if (mVar == null) {
            return;
        }
        if (mVar.f54637g) {
            SvgManager svgManager = SvgManager.getInstance();
            m mVar2 = this.f12877h;
            setImageDrawable(svgManager.getSeletableDrawableForEditorTools(mVar2.f54634d, mVar2.f54635e, this.f12876g));
        } else if (mVar.f54638h) {
            setImageDrawable(WebPManager.getSeletableDrawableForEditorToolsEM(mVar.f54634d, mVar.f54635e, this.f12876g));
        } else {
            SkinManager.setImageResource(this, mVar.f54634d, this.f12876g);
        }
        if (this.f12877h.d()) {
            return;
        }
        setEnabled(false);
    }

    @Override // d.a.n0.w.h
    public void setName(String str) {
    }

    public void setOutSetVisibilty(boolean z) {
        this.j = z;
    }

    public void setToolId(int i2) {
        this.f12875f = i2;
    }
}
