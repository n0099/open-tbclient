package com.baidu.tbadk.editortool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class ToolMoreView extends FrameLayout {
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
    private Button k;
    private boolean l;
    private boolean m;
    private boolean n;
    private LinearLayout o;
    private LinearLayout p;
    private TextView q;
    private TextView r;
    private TextView s;

    public ToolMoreView(Context context) {
        super(context);
        this.a = 0;
        this.l = false;
        this.m = false;
        this.b = context;
        f();
    }

    public ToolMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.l = false;
        this.m = false;
        this.b = context;
        f();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.q != null) {
            int right = this.f.getRight() - com.baidu.adp.lib.util.i.a(this.b, 14.0f);
            int top = this.f.getTop() - com.baidu.adp.lib.util.i.a(this.b, 2.0f);
            this.q.layout(right, top, this.q.getMeasuredWidth() + right, this.q.getMeasuredHeight() + top);
        }
        if (this.r != null) {
            int right2 = this.c.getRight() - com.baidu.adp.lib.util.i.a(this.b, 14.0f);
            int top2 = this.c.getTop() - com.baidu.adp.lib.util.i.a(this.b, 2.0f);
            this.r.layout(right2, top2, this.r.getMeasuredWidth() + right2, this.r.getMeasuredHeight() + top2);
        }
        if (this.s != null) {
            int right3 = this.k.getRight() - com.baidu.adp.lib.util.i.a(this.b, 14.0f);
            int top3 = (this.k.getTop() + this.p.getTop()) - com.baidu.adp.lib.util.i.a(this.b, 2.0f);
            this.s.layout(right3, top3, this.s.getMeasuredWidth() + right3, this.s.getMeasuredHeight() + top3);
        }
    }

    private TextView b(boolean z) {
        TextView textView = new TextView(this.b);
        textView.setTextSize(1, 10.0f);
        boolean z2 = TbadkApplication.j().l() == 1;
        textView.setTextColor(this.b.getResources().getColor(z2 ? com.baidu.tbadk.g.top_msg_num_night : com.baidu.tbadk.g.top_msg_num_day));
        textView.setGravity(17);
        if (z) {
            textView.setBackgroundResource(z2 ? com.baidu.tbadk.i.icon_news_head_prompt_one_1 : com.baidu.tbadk.i.icon_news_head_prompt_one);
        } else {
            textView.setBackgroundResource(z2 ? com.baidu.tbadk.i.icon_news_list_prompt_1 : com.baidu.tbadk.i.icon_news_list_prompt);
        }
        addView(textView, new FrameLayout.LayoutParams(-2, -2));
        return textView;
    }

    public final void a(String str) {
        if (this.q == null) {
            this.q = b(true);
        }
        this.q.setVisibility(0);
        this.q.setText(str);
    }

    public final void a() {
        if (this.q != null) {
            this.q.setVisibility(8);
        }
    }

    private void b(String str) {
        if (this.r == null) {
            this.r = b(true);
        }
        this.r.setVisibility(0);
        this.r.setText(str);
    }

    private void e() {
        if (this.r != null) {
            this.r.setVisibility(8);
        }
    }

    public final void b() {
        if (this.s == null) {
            this.s = b(false);
        }
        this.s.setVisibility(0);
    }

    public final void c() {
        if (this.s != null) {
            this.s.setVisibility(8);
        }
    }

    private void f() {
        LayoutInflater.from(this.b).inflate(com.baidu.tbadk.k.editor_tool_more, (ViewGroup) this, true);
        this.o = (LinearLayout) findViewById(com.baidu.tbadk.j.lay_editor_more_line1);
        this.p = (LinearLayout) findViewById(com.baidu.tbadk.j.lay_editor_more_line2);
        this.c = (Button) findViewById(com.baidu.tbadk.j.btn_tool_expression);
        this.d = (Button) findViewById(com.baidu.tbadk.j.btn_tool_image);
        this.e = (HeadImageView) findViewById(com.baidu.tbadk.j.iv_tool_image);
        this.e.setDrawBorder(false);
        this.f = (FrameLayout) findViewById(com.baidu.tbadk.j.lay_tool_image);
        this.g = (Button) findViewById(com.baidu.tbadk.j.btn_tool_camera);
        this.h = (HeadImageView) findViewById(com.baidu.tbadk.j.iv_tool_camera);
        this.h.setDrawBorder(false);
        this.i = (FrameLayout) findViewById(com.baidu.tbadk.j.lay_tool_camera);
        this.j = (Button) findViewById(com.baidu.tbadk.j.btn_tool_at);
        this.k = (Button) findViewById(com.baidu.tbadk.j.btn_tool_privilege);
        if (TbadkApplication.j().ac()) {
            b("N");
        } else {
            e();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.c.setOnClickListener(onClickListener);
        this.d.setOnClickListener(onClickListener);
        this.g.setOnClickListener(onClickListener);
        this.e.setOnClickListener(onClickListener);
        this.h.setOnClickListener(onClickListener);
        this.j.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
    }

    public void setImage(Bitmap bitmap) {
        if (this.a == 1) {
            if (this.l) {
                setImageToImage(null);
            }
            setImageToCamera(bitmap);
        } else if (this.a == 2) {
            if (this.m) {
                setImageToCamera(null);
            }
            setImageToImage(bitmap);
        } else if (this.a == 0) {
            if (this.l) {
                setImageToImage(null);
            }
            if (this.m) {
                setImageToCamera(null);
            }
        }
    }

    private void setImageToImage(Bitmap bitmap) {
        if (bitmap != null) {
            this.e.setImageBitmap(bitmap);
            this.e.setVisibility(0);
            this.d.setVisibility(4);
            this.l = true;
            return;
        }
        this.l = false;
        this.e.setImageBitmap(null);
        this.e.setVisibility(4);
        this.d.setVisibility(0);
    }

    private void setImageToCamera(Bitmap bitmap) {
        if (bitmap != null) {
            this.h.setImageBitmap(bitmap);
            this.h.setVisibility(0);
            this.g.setVisibility(4);
            this.m = true;
            return;
        }
        this.m = false;
        this.h.setImageBitmap(null);
        this.h.setVisibility(4);
        this.g.setVisibility(0);
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

    public Button getmPrivilege() {
        return this.k;
    }

    public void setmImagetype(int i) {
        this.a = i;
    }

    public final void a(boolean z) {
        if (z) {
            this.f.setVisibility(4);
            this.i.setVisibility(4);
            this.k.setVisibility(4);
            if (!this.n) {
                this.o.removeView(this.f);
                this.o.removeView(this.i);
                this.p.removeView(this.k);
                this.o.addView(this.f);
                this.o.addView(this.i);
                this.p.addView(this.k);
                this.n = true;
                return;
            }
            return;
        }
        if (this.n) {
            this.o.addView(this.f, 1);
            this.o.addView(this.i, 2);
            this.p.addView(this.k, 1);
            this.n = false;
        }
        this.f.setVisibility(0);
        this.i.setVisibility(0);
        this.k.setVisibility(0);
    }

    public final void d() {
        this.j.setVisibility(4);
        this.k.setVisibility(4);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (TbadkApplication.j().ac()) {
            b("N");
        } else {
            e();
        }
    }

    public View getFaceButton() {
        return this.c;
    }

    public View getImageButton() {
        return this.d;
    }

    public View getCameraButton() {
        return this.g;
    }

    public final void a(int i) {
        int i2 = i == 1 ? com.baidu.tbadk.i.selector_editor_more_btn_1 : com.baidu.tbadk.i.selector_editor_more_btn;
        int color = getResources().getColor(i == 1 ? com.baidu.tbadk.g.editor_more_btn_text_1 : com.baidu.tbadk.g.editor_more_btn_text);
        int i3 = i == 1 ? com.baidu.tbadk.i.btn_pb_add_photo_n_1 : com.baidu.tbadk.i.btn_pb_add_photo_n;
        int i4 = i == 1 ? com.baidu.tbadk.i.btn_pb_add_expression_n_1 : com.baidu.tbadk.i.btn_pb_add_expression_n;
        int i5 = i == 1 ? com.baidu.tbadk.i.btn_pb_add_camera_n_1 : com.baidu.tbadk.i.btn_pb_add_camera_n;
        int i6 = i == 1 ? com.baidu.tbadk.i.btn_pb_add_a_n_1 : com.baidu.tbadk.i.btn_pb_add_a_n;
        int i7 = i == 1 ? com.baidu.tbadk.i.btn_pb_add_vip_n_1 : com.baidu.tbadk.i.btn_pb_add_vip_n;
        a(this.c, i2, i4, color);
        a(this.d, i2, i3, color);
        a(this.g, i2, i5, color);
        a(this.j, i2, i6, color);
        a(this.k, i2, i7, color);
        a(this.r, i);
        a(this.q, i);
        a(this.s, i);
    }

    private void a(TextView textView, int i) {
        if (textView != null) {
            boolean z = i == 1;
            textView.setTextColor(this.b.getResources().getColor(z ? com.baidu.tbadk.g.top_msg_num_night : com.baidu.tbadk.g.top_msg_num_day));
            textView.setBackgroundResource(z ? com.baidu.tbadk.i.icon_news_head_prompt_one_1 : com.baidu.tbadk.i.icon_news_head_prompt_one);
        }
    }

    private void a(Button button, int i, int i2, int i3) {
        button.setBackgroundResource(i);
        button.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(i2), (Drawable) null, (Drawable) null);
        button.setTextColor(i3);
    }
}
