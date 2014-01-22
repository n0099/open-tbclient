package com.baidu.tieba.editortool;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ToolMoreView extends LinearLayout {
    private int a;
    private Context b;
    private Button c;
    private Button d;
    private HeadImageView e;
    private FrameLayout f;
    private Button g;
    private HeadImageView h;
    private FrameLayout i;
    private Button j;
    private boolean k;
    private boolean l;
    private boolean m;
    private LinearLayout n;

    public ToolMoreView(Context context) {
        super(context);
        this.a = 0;
        this.k = false;
        this.l = false;
        this.b = context;
        d();
    }

    public ToolMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.k = false;
        this.l = false;
        this.b = context;
        d();
    }

    private void d() {
        LayoutInflater.from(this.b).inflate(R.layout.editor_tool_more, (ViewGroup) this, true);
        this.n = (LinearLayout) findViewById(R.id.lay_editor_more);
        this.c = (Button) findViewById(R.id.btn_tool_expression);
        this.d = (Button) findViewById(R.id.btn_tool_image);
        this.e = (HeadImageView) findViewById(R.id.iv_tool_image);
        this.e.setDrawBorder(false);
        this.f = (FrameLayout) findViewById(R.id.lay_tool_image);
        this.g = (Button) findViewById(R.id.btn_tool_camera);
        this.h = (HeadImageView) findViewById(R.id.iv_tool_camera);
        this.h.setDrawBorder(false);
        this.i = (FrameLayout) findViewById(R.id.lay_tool_camera);
        this.j = (Button) findViewById(R.id.btn_tool_at);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.c.setOnClickListener(onClickListener);
        this.d.setOnClickListener(onClickListener);
        this.g.setOnClickListener(onClickListener);
        this.e.setOnClickListener(onClickListener);
        this.h.setOnClickListener(onClickListener);
        this.j.setOnClickListener(onClickListener);
    }

    public boolean a() {
        return c() || b();
    }

    public void setImage(Bitmap bitmap) {
        if (this.a == 1) {
            if (this.k) {
                setImageToImage(null);
            }
            setImageToCamera(bitmap);
        } else if (this.a == 2) {
            if (this.l) {
                setImageToCamera(null);
            }
            setImageToImage(bitmap);
        } else if (this.a == 0) {
            if (this.k) {
                setImageToImage(null);
            }
            if (this.l) {
                setImageToCamera(null);
            }
        }
    }

    private void setImageToImage(Bitmap bitmap) {
        if (bitmap != null) {
            this.e.setImageBitmap(bitmap);
            this.e.setVisibility(0);
            this.d.setVisibility(4);
            this.k = true;
            return;
        }
        this.k = false;
        this.e.setImageBitmap(null);
        this.e.setVisibility(4);
        this.d.setVisibility(0);
    }

    private void setImageToCamera(Bitmap bitmap) {
        if (bitmap != null) {
            this.h.setImageBitmap(bitmap);
            this.h.setVisibility(0);
            this.g.setVisibility(4);
            this.l = true;
            return;
        }
        this.l = false;
        this.h.setImageBitmap(null);
        this.h.setVisibility(4);
        this.g.setVisibility(0);
    }

    public boolean b() {
        return this.k;
    }

    public boolean c() {
        return this.l;
    }

    public Button getmFace() {
        return this.c;
    }

    public Button getmImage() {
        return this.d;
    }

    public Button getmCamera() {
        return this.g;
    }

    public View getmIVImage() {
        return this.e;
    }

    public View getmIVCamera() {
        return this.h;
    }

    public Button getmAt() {
        return this.j;
    }

    public void setmImagetype(int i) {
        this.a = i;
    }

    public void a(boolean z) {
        if (z) {
            this.f.setVisibility(4);
            this.i.setVisibility(4);
            if (!this.m) {
                this.n.removeView(this.f);
                this.n.removeView(this.i);
                this.n.addView(this.f);
                this.n.addView(this.i);
                this.m = true;
                return;
            }
            return;
        }
        if (this.m) {
            this.n.addView(this.f, 1);
            this.n.addView(this.i, 2);
            this.m = false;
        }
        this.f.setVisibility(0);
        this.i.setVisibility(0);
    }
}
