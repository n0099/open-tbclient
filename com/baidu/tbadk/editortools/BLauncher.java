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
import d.a.m0.w.a;
import d.a.m0.w.h;
import d.a.m0.w.m;
/* loaded from: classes3.dex */
public class BLauncher extends ImageView implements h {

    /* renamed from: e  reason: collision with root package name */
    public TextView f12727e;

    /* renamed from: f  reason: collision with root package name */
    public int f12728f;

    /* renamed from: g  reason: collision with root package name */
    public int f12729g;

    /* renamed from: h  reason: collision with root package name */
    public m f12730h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f12731i;
    public boolean j;

    public BLauncher(Context context, m mVar) {
        super(context);
        this.f12729g = 0;
        this.j = false;
        if (mVar == null) {
            return;
        }
        this.f12730h = mVar;
        setIcon();
        setToolId(mVar.f50849c);
    }

    public void a(String str) {
        if (getVisibility() == 8 || TextUtils.isEmpty(str)) {
            return;
        }
        TextView textView = this.f12727e;
        if (textView == null) {
            TextView textView2 = new TextView(getContext());
            this.f12727e = textView2;
            textView2.setTag("tip");
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).addView(this.f12727e);
            }
        } else if (textView.getParent() == null) {
            ViewParent parent2 = getParent();
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).addView(this.f12727e);
            }
        }
        SkinManager.setViewTextColor(this.f12727e, R.color.CAM_X0111, 1, this.f12729g);
        this.f12727e.setGravity(17);
        if (!str.equals(" ")) {
            this.f12727e.setTextSize(10.0f);
            this.f12727e.setText(str);
            SkinManager.setBackgroundResource(this.f12727e, R.drawable.icon_news_red_dot, this.f12729g);
            this.f12727e.setVisibility(0);
            return;
        }
        this.f12727e.setVisibility(8);
        this.f12730h.o = true;
        invalidate();
    }

    @Override // d.a.m0.w.h
    public void b() {
        setVisibility(0);
    }

    public void c() {
        TextView textView = this.f12727e;
        if (textView != null) {
            textView.setVisibility(8);
            e();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f12730h.o) {
            this.f12731i = SkinManager.getDrawable(R.drawable.icon_news_red_dot);
            int width = getWidth();
            int intrinsicHeight = this.f12731i.getIntrinsicHeight();
            this.f12731i.setBounds(getWidth() - this.f12731i.getIntrinsicWidth(), 0, width, intrinsicHeight);
            this.f12731i.draw(canvas);
        }
    }

    @Override // d.a.m0.w.h
    public void e() {
        this.f12730h.o = false;
        invalidate();
    }

    public boolean getIsOutSetVisibility() {
        return this.j;
    }

    public TextView getNotice() {
        return this.f12727e;
    }

    @Override // d.a.m0.w.h
    public int getToolId() {
        return this.f12728f;
    }

    @Override // d.a.m0.w.h
    public void hide() {
        c();
        setVisibility(8);
    }

    @Override // d.a.m0.w.b
    public void onAction(a aVar) {
        if (aVar != null && aVar.f50841a == 2) {
            Object obj = aVar.f50843c;
            if (obj == null) {
                c();
            } else if (obj instanceof String) {
                a((String) obj);
            }
        }
    }

    @Override // d.a.m0.w.h
    public void onChangeSkinType(int i2) {
        this.f12729g = i2;
        setIcon();
        TextView textView = this.f12727e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0111, 1, i2);
            if (!TextUtils.isEmpty(this.f12727e.getText()) && !TextUtils.isEmpty(this.f12727e.getText().toString().trim())) {
                SkinManager.setBackgroundResource(this.f12727e, R.drawable.icon_news_head_prompt_one, i2);
            } else {
                SkinManager.setBackgroundResource(this.f12727e, R.drawable.icon_news_down_bar_one, i2);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        TextView textView = this.f12727e;
        if (textView != null && textView.getVisibility() == 0 && this.f12727e.getParent() == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).addView(this.f12727e);
            }
        }
    }

    public void setIcon() {
        m mVar = this.f12730h;
        if (mVar == null) {
            return;
        }
        if (mVar.f50853g) {
            SvgManager svgManager = SvgManager.getInstance();
            m mVar2 = this.f12730h;
            setImageDrawable(svgManager.getSeletableDrawableForEditorTools(mVar2.f50850d, mVar2.f50851e, this.f12729g));
        } else if (mVar.f50854h) {
            setImageDrawable(WebPManager.getSeletableDrawableForEditorToolsEM(mVar.f50850d, mVar.f50851e, this.f12729g));
        } else {
            SkinManager.setImageResource(this, mVar.f50850d, this.f12729g);
        }
        if (this.f12730h.d()) {
            return;
        }
        setEnabled(false);
    }

    @Override // d.a.m0.w.h
    public void setName(String str) {
    }

    public void setOutSetVisibilty(boolean z) {
        this.j = z;
    }

    public void setToolId(int i2) {
        this.f12728f = i2;
    }
}
