package com.baidu.tieba.editortool;

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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
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
    private boolean k;
    private boolean l;
    private boolean m;
    private LinearLayout n;
    private TextView o;
    private TextView p;

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

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.o != null) {
            int right = this.f.getRight() - BdUtilHelper.a(this.b, 14.0f);
            int top = this.f.getTop() - BdUtilHelper.a(this.b, 2.0f);
            this.o.layout(right, top, this.o.getMeasuredWidth() + right, this.o.getMeasuredHeight() + top);
        }
        if (this.p != null) {
            int right2 = this.c.getRight() - BdUtilHelper.a(this.b, 14.0f);
            int top2 = this.c.getTop() - BdUtilHelper.a(this.b, 2.0f);
            this.p.layout(right2, top2, this.p.getMeasuredWidth() + right2, this.p.getMeasuredHeight() + top2);
        }
    }

    public TextView a(boolean z) {
        TextView textView = new TextView(this.b);
        textView.setTextSize(1, 10.0f);
        boolean z2 = TiebaApplication.g().al() == 1;
        textView.setTextColor(this.b.getResources().getColor(z2 ? R.color.top_msg_num_night : R.color.top_msg_num_day));
        textView.setGravity(17);
        if (z) {
            textView.setBackgroundResource(z2 ? R.drawable.icon_news_head_prompt_one_1 : R.drawable.icon_news_head_prompt_one);
        } else {
            textView.setBackgroundResource(z2 ? R.drawable.icon_news_list_prompt_1 : R.drawable.icon_news_list_prompt);
        }
        addView(textView, new FrameLayout.LayoutParams(-2, -2));
        return textView;
    }

    public void a(String str) {
        if (this.o == null) {
            this.o = a(true);
        }
        this.o.setVisibility(0);
        this.o.setText(str);
    }

    public void a() {
        if (this.o != null) {
            this.o.setVisibility(8);
        }
    }

    public void b(String str) {
        if (this.p == null) {
            this.p = a(true);
        }
        this.p.setVisibility(0);
        this.p.setText(str);
    }

    public void b() {
        if (this.p != null) {
            this.p.setVisibility(8);
        }
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
        if (TiebaApplication.g().bj()) {
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

    public void b(boolean z) {
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

    public void c() {
        this.j.setVisibility(4);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (TiebaApplication.g().bj()) {
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
        int i2 = i == 1 ? R.drawable.selector_editor_more_btn_1 : R.drawable.selector_editor_more_btn;
        int color = getResources().getColor(i == 1 ? R.color.editor_more_btn_text_1 : R.color.editor_more_btn_text);
        int i3 = i == 1 ? R.drawable.btn_pb_add_photo_n_1 : R.drawable.btn_pb_add_photo_n;
        int i4 = i == 1 ? R.drawable.btn_pb_add_expression_n_1 : R.drawable.btn_pb_add_expression_n;
        int i5 = i == 1 ? R.drawable.btn_pb_add_camera_n_1 : R.drawable.btn_pb_add_camera_n;
        int i6 = i == 1 ? R.drawable.btn_pb_add_a_n_1 : R.drawable.btn_pb_add_a_n;
        a(this.c, i2, i4, color);
        a(this.d, i2, i3, color);
        a(this.g, i2, i5, color);
        a(this.j, i2, i6, color);
        a(this.p, i);
        a(this.o, i);
    }

    private void a(TextView textView, int i) {
        if (textView != null) {
            boolean z = i == 1;
            textView.setTextColor(this.b.getResources().getColor(z ? R.color.top_msg_num_night : R.color.top_msg_num_day));
            textView.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_one_1 : R.drawable.icon_news_head_prompt_one);
        }
    }

    private void a(Button button, int i, int i2, int i3) {
        button.setBackgroundResource(i);
        button.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(i2), (Drawable) null, (Drawable) null);
        button.setTextColor(i3);
    }
}
