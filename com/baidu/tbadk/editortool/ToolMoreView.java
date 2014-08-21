package com.baidu.tbadk.editortool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
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
    private Button l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private LinearLayout q;
    private LinearLayout r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private boolean w;

    public void setHideBaobao(boolean z) {
        this.w = z;
        if (this.k != null) {
            if (this.w) {
                this.k.setVisibility(4);
            } else {
                this.k.setVisibility(0);
            }
        }
    }

    public ToolMoreView(Context context) {
        super(context);
        this.a = 0;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = true;
        this.b = context;
        g();
    }

    public ToolMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = true;
        this.b = context;
        g();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.s != null) {
            int right = this.f.getRight() - com.baidu.adp.lib.util.j.a(this.b, 14.0f);
            int top = this.f.getTop() - com.baidu.adp.lib.util.j.a(this.b, 2.0f);
            this.s.layout(right, top, this.s.getMeasuredWidth() + right, this.s.getMeasuredHeight() + top);
        }
        if (this.t != null) {
            int right2 = this.c.getRight() - com.baidu.adp.lib.util.j.a(this.b, 14.0f);
            int top2 = this.c.getTop() - com.baidu.adp.lib.util.j.a(this.b, 2.0f);
            this.t.layout(right2, top2, this.t.getMeasuredWidth() + right2, this.t.getMeasuredHeight() + top2);
        }
        if (this.u != null) {
            int right3 = this.l.getRight() - com.baidu.adp.lib.util.j.a(this.b, 14.0f);
            int top3 = (this.l.getTop() + this.r.getTop()) - com.baidu.adp.lib.util.j.a(this.b, 2.0f);
            this.u.layout(right3, top3, this.u.getMeasuredWidth() + right3, this.u.getMeasuredHeight() + top3);
        }
        if (this.v != null && !this.w) {
            int right4 = this.k.getRight() - com.baidu.adp.lib.util.j.a(this.b, 14.0f);
            int top4 = (this.k.getTop() + this.r.getTop()) - com.baidu.adp.lib.util.j.a(this.b, 2.0f);
            this.v.layout(right4, top4, this.v.getMeasuredWidth() + right4, this.v.getMeasuredHeight() + top4);
        }
    }

    public TextView a(boolean z) {
        TextView textView = new TextView(this.b);
        textView.setTextSize(1, 10.0f);
        boolean z2 = TbadkApplication.m252getInst().getSkinType() == 1;
        textView.setTextColor(this.b.getResources().getColor(z2 ? com.baidu.tieba.r.top_msg_num_night : com.baidu.tieba.r.top_msg_num_day));
        textView.setGravity(17);
        if (z) {
            textView.setBackgroundResource(z2 ? com.baidu.tieba.t.icon_news_head_prompt_one_1 : com.baidu.tieba.t.icon_news_head_prompt_one);
        } else {
            textView.setBackgroundResource(z2 ? com.baidu.tieba.t.icon_news_list_prompt_1 : com.baidu.tieba.t.icon_news_list_prompt);
        }
        addView(textView, new FrameLayout.LayoutParams(-2, -2));
        return textView;
    }

    public void a(String str) {
        if (this.f.getVisibility() == 0) {
            if (this.s == null) {
                this.s = a(true);
            }
            this.s.setVisibility(0);
            this.s.setText(str);
        }
    }

    public void a() {
        if (this.s != null) {
            this.s.setVisibility(8);
        }
    }

    public void b(String str) {
        if (this.t == null) {
            this.t = a(true);
        }
        this.t.setVisibility(0);
        this.t.setText(str);
    }

    public void b() {
        if (this.t != null) {
            this.t.setVisibility(8);
        }
    }

    public void c() {
        if (this.l.getVisibility() == 0) {
            if (this.u == null) {
                this.u = a(false);
            }
            this.u.setVisibility(0);
        }
    }

    public void d() {
        if (this.u != null) {
            this.u.setVisibility(8);
        }
    }

    public void c(String str) {
        if (this.k.getVisibility() == 0) {
            if (this.v == null) {
                this.v = a(true);
            }
            this.v.setVisibility(0);
            this.v.setText(str);
        }
    }

    public void e() {
        if (this.v != null) {
            this.v.setVisibility(8);
        }
    }

    private void g() {
        com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.editor_tool_more, this, true);
        this.q = (LinearLayout) findViewById(com.baidu.tieba.u.lay_editor_more_line1);
        this.r = (LinearLayout) findViewById(com.baidu.tieba.u.lay_editor_more_line2);
        this.c = (Button) findViewById(com.baidu.tieba.u.btn_tool_expression);
        this.d = (Button) findViewById(com.baidu.tieba.u.btn_tool_image);
        this.e = (HeadImageView) findViewById(com.baidu.tieba.u.iv_tool_image);
        this.e.setDrawBorder(false);
        this.f = (FrameLayout) findViewById(com.baidu.tieba.u.lay_tool_image);
        this.g = (Button) findViewById(com.baidu.tieba.u.btn_tool_camera);
        this.h = (HeadImageView) findViewById(com.baidu.tieba.u.iv_tool_camera);
        this.h.setDrawBorder(false);
        this.i = (FrameLayout) findViewById(com.baidu.tieba.u.lay_tool_camera);
        this.j = (Button) findViewById(com.baidu.tieba.u.btn_tool_at);
        this.l = (Button) findViewById(com.baidu.tieba.u.btn_tool_privilege);
        this.k = (Button) findViewById(com.baidu.tieba.u.btn_tool_baobao);
        if (!TbadkApplication.m252getInst().isBaobaoShouldOpen() || this.w) {
            this.k.setVisibility(4);
            this.k.setEnabled(false);
        }
        if (TbadkApplication.m252getInst().isFaceShopNew()) {
            b("N");
        } else {
            b();
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
        this.l.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
    }

    public void setImage(Bitmap bitmap) {
        if (this.a == 1) {
            if (this.m) {
                setImageToImage(null);
            }
            setImageToCamera(bitmap);
        } else if (this.a == 2) {
            if (this.n) {
                setImageToCamera(null);
            }
            setImageToImage(bitmap);
        } else if (this.a == 0) {
            if (this.m) {
                setImageToImage(null);
            }
            if (this.n) {
                setImageToCamera(null);
            }
        }
    }

    private void setImageToImage(Bitmap bitmap) {
        if (bitmap != null) {
            this.e.setImageBitmap(bitmap);
            this.e.setVisibility(0);
            this.d.setVisibility(4);
            this.m = true;
            return;
        }
        this.m = false;
        this.e.setImageDrawable(null);
        this.e.setVisibility(4);
        this.d.setVisibility(0);
    }

    private void setImageToCamera(Bitmap bitmap) {
        if (bitmap != null) {
            this.h.setImageBitmap(bitmap);
            this.h.setVisibility(0);
            this.g.setVisibility(4);
            this.n = true;
            return;
        }
        this.n = false;
        this.h.setImageDrawable(null);
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
        return this.l;
    }

    public Button getBaobao() {
        return this.k;
    }

    public void setmImagetype(int i) {
        this.a = i;
    }

    public void b(boolean z) {
        if (this.p) {
            this.q.removeView(this.f);
            this.q.removeView(this.i);
            this.r.removeView(this.l);
            this.r.removeView(this.k);
            this.q.addView(this.f);
            this.q.addView(this.i);
            this.r.addView(this.l, 0);
            this.r.addView(this.k, 1);
        }
        this.p = false;
        if (z) {
            this.f.setVisibility(4);
            this.i.setVisibility(4);
            this.l.setVisibility(4);
            if (TbadkApplication.m252getInst().isBaobaoShouldOpen() && !this.w) {
                this.k.setVisibility(4);
                this.k.setEnabled(false);
                return;
            }
            return;
        }
        this.f.setVisibility(0);
        this.i.setVisibility(0);
        this.l.setVisibility(0);
        if (TbadkApplication.m252getInst().isBaobaoShouldOpen() && !this.w) {
            this.k.setEnabled(true);
            this.k.setVisibility(0);
        }
    }

    public void f() {
        this.j.setVisibility(4);
        this.l.setVisibility(4);
        this.k.setVisibility(4);
        e();
        this.k.setEnabled(false);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (TbadkApplication.m252getInst().isFaceShopNew()) {
            b("N");
        } else {
            b();
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

    public void a(int i) {
        int i2 = i == 1 ? com.baidu.tieba.t.selector_editor_more_btn_1 : com.baidu.tieba.t.selector_editor_more_btn;
        int color = getResources().getColor(i == 1 ? com.baidu.tieba.r.editor_more_btn_text_1 : com.baidu.tieba.r.editor_more_btn_text);
        int i3 = i == 1 ? com.baidu.tieba.t.btn_pb_add_photo_n_1 : com.baidu.tieba.t.btn_pb_add_photo_n;
        int i4 = i == 1 ? com.baidu.tieba.t.btn_pb_add_expression_n_1 : com.baidu.tieba.t.btn_pb_add_expression_n;
        int i5 = i == 1 ? com.baidu.tieba.t.btn_pb_add_camera_n_1 : com.baidu.tieba.t.btn_pb_add_camera_n;
        int i6 = i == 1 ? com.baidu.tieba.t.btn_pb_add_a_n_1 : com.baidu.tieba.t.btn_pb_add_a_n;
        int i7 = i == 1 ? com.baidu.tieba.t.btn_pb_add_vip_n_1 : com.baidu.tieba.t.btn_pb_add_vip_n;
        int i8 = i == 1 ? com.baidu.tieba.t.btn_pb_add_baobao_n_1 : com.baidu.tieba.t.btn_pb_add_baobao_n;
        a(this.c, i2, i4, color);
        a(this.d, i2, i3, color);
        a(this.g, i2, i5, color);
        a(this.j, i2, i6, color);
        a(this.l, i2, i7, color);
        a(this.k, i2, i8, color);
        a(this.t, i);
        a(this.s, i);
        a(this.u, i);
    }

    private void a(TextView textView, int i) {
        if (textView != null) {
            boolean z = i == 1;
            textView.setTextColor(this.b.getResources().getColor(z ? com.baidu.tieba.r.top_msg_num_night : com.baidu.tieba.r.top_msg_num_day));
            textView.setBackgroundResource(z ? com.baidu.tieba.t.icon_news_head_prompt_one_1 : com.baidu.tieba.t.icon_news_head_prompt_one);
        }
    }

    private void a(Button button, int i, int i2, int i3) {
        int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.editor_more_btns_paddingtop);
        button.setBackgroundResource(i);
        button.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        button.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(i2), (Drawable) null, (Drawable) null);
        button.setTextColor(i3);
    }
}
