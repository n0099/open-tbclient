package com.baidu.tbadk.editortool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class ToolMoreView extends FrameLayout {
    private int Zd;
    private TextView Ze;
    private TextView Zf;
    private HeadImageView Zg;
    private FrameLayout Zh;
    private TextView Zi;
    private TextView Zj;
    private TextView Zk;
    private TextView Zl;
    private TextView Zm;
    private boolean Zn;
    private boolean Zo;
    private boolean Zp;
    private LinearLayout Zq;
    private LinearLayout Zr;
    private TextView Zs;
    private TextView Zt;
    private TextView Zu;
    private TextView Zv;
    private TextView Zw;
    private TextView Zx;
    private boolean isFirst;
    private Context mContext;

    public ToolMoreView(Context context) {
        super(context);
        this.Zd = 0;
        this.isFirst = true;
        this.mContext = context;
        init();
    }

    public ToolMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Zd = 0;
        this.isFirst = true;
        this.mContext = context;
        init();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.Zs != null) {
            if (this.Zh != null && this.Zh.getVisibility() == 0) {
                int right = this.Zh.getRight() - (this.Zs.getMeasuredWidth() / 2);
                int top = this.Zh.getTop() - (this.Zs.getMeasuredHeight() / 2);
                this.Zs.layout(right, top, this.Zs.getMeasuredWidth() + right, this.Zs.getMeasuredHeight() + top);
            } else {
                this.Zs.layout(0, 0, 0, 0);
            }
        }
        if (this.Zt != null) {
            if (this.Ze != null && this.Ze.getVisibility() == 0) {
                int right2 = this.Ze.getRight() - (this.Zt.getMeasuredWidth() / 2);
                int top2 = this.Ze.getTop() - (this.Zt.getMeasuredHeight() / 2);
                this.Zt.layout(right2, top2, this.Zt.getMeasuredWidth() + right2, this.Zt.getMeasuredHeight() + top2);
            } else {
                this.Zt.layout(0, 0, 0, 0);
            }
        }
        if (this.Zu != null) {
            if (this.Zl != null && this.Zl.getVisibility() == 0) {
                int right3 = this.Zl.getRight() - (this.Zu.getMeasuredWidth() / 2);
                int top3 = (this.Zl.getTop() + this.Zr.getTop()) - (this.Zu.getMeasuredHeight() / 2);
                this.Zu.layout(right3, top3, this.Zu.getMeasuredWidth() + right3, this.Zu.getMeasuredHeight() + top3);
            } else {
                this.Zu.layout(0, 0, 0, 0);
            }
        }
        if (this.Zw != null) {
            if (this.Zk != null && this.Zk.getVisibility() == 0) {
                int right4 = this.Zk.getRight() - (this.Zw.getMeasuredWidth() / 2);
                int top4 = this.Zk.getTop() - (this.Zw.getMeasuredHeight() / 2);
                this.Zw.layout(right4, top4, this.Zw.getMeasuredWidth() + right4, this.Zw.getMeasuredHeight() + top4);
            } else {
                this.Zw.layout(0, 0, 0, 0);
            }
        }
        if (this.Zv != null) {
            if (!this.Zp && this.Zj != null && this.Zj.getVisibility() == 0) {
                int right5 = this.Zj.getRight() - (this.Zv.getMeasuredWidth() / 2);
                int top5 = (this.Zj.getTop() + this.Zr.getTop()) - (this.Zv.getMeasuredHeight() / 2);
                this.Zv.layout(right5, top5, this.Zv.getMeasuredWidth() + right5, this.Zv.getMeasuredHeight() + top5);
            } else {
                this.Zv.layout(0, 0, 0, 0);
            }
        }
        if (this.Zx != null) {
            if (this.Zm != null && this.Zm.getVisibility() == 0) {
                int right6 = this.Zm.getRight() - (this.Zx.getMeasuredWidth() / 2);
                int top6 = this.Zm.getTop() - (this.Zx.getMeasuredHeight() / 2);
                this.Zx.layout(right6, top6, this.Zx.getMeasuredWidth() + right6, this.Zx.getMeasuredHeight() + top6);
                return;
            }
            this.Zx.layout(0, 0, 0, 0);
        }
    }

    public TextView aJ(boolean z) {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(1, 10.0f);
        bc.b(textView, com.baidu.tieba.t.top_msg_num_day, 1);
        textView.setGravity(17);
        if (z) {
            bc.i((View) textView, com.baidu.tieba.v.icon_news_head_prompt_one);
        } else {
            bc.i((View) textView, com.baidu.tieba.v.icon_news_list_prompt);
        }
        addView(textView, new FrameLayout.LayoutParams(-2, -2));
        return textView;
    }

    public void setHideBaobao(boolean z) {
        this.Zp = z;
        if (this.Zj != null) {
            if (this.Zp) {
                this.Zj.setVisibility(4);
            } else {
                this.Zj.setVisibility(0);
            }
        }
    }

    public void eb(String str) {
        if (this.Zh.getVisibility() == 0) {
            if (this.Zs == null) {
                this.Zs = aJ(true);
            }
            this.Zs.setVisibility(0);
            this.Zs.setText(str);
        }
    }

    public void vr() {
        if (this.Zs != null) {
            this.Zs.setVisibility(8);
        }
    }

    public void ec(String str) {
        if (this.Zt == null) {
            this.Zt = aJ(true);
        }
        this.Zt.setVisibility(0);
        this.Zt.setText(str);
    }

    public void vs() {
        if (this.Zt != null) {
            this.Zt.setVisibility(8);
        }
    }

    public void vt() {
        if (this.Zl.getVisibility() == 0) {
            if (this.Zu == null) {
                this.Zu = aJ(false);
            }
            this.Zu.setVisibility(0);
        }
    }

    public void vu() {
        if (this.Zu != null) {
            this.Zu.setVisibility(8);
        }
    }

    public boolean vv() {
        return this.Zx != null && this.Zx.getVisibility() == 0 && this.Zm != null && this.Zm.getVisibility() == 0;
    }

    public void vw() {
        if (this.Zm.getVisibility() == 0) {
            if (this.Zx == null) {
                this.Zx = aJ(false);
            }
            this.Zx.setVisibility(0);
        }
    }

    public void vx() {
        if (this.Zx != null) {
            this.Zx.setVisibility(8);
        }
    }

    public void ed(String str) {
        if (this.Zj.getVisibility() == 0) {
            if (this.Zv == null) {
                this.Zv = aJ(true);
            }
            this.Zv.setVisibility(0);
            this.Zv.setText(str);
        }
    }

    public void vy() {
        if (this.Zv != null) {
            this.Zv.setVisibility(8);
        }
    }

    public void vz() {
        if (this.Zk.getVisibility() == 0) {
            if (this.Zw == null) {
                this.Zw = aJ(false);
            }
            this.Zw.setVisibility(0);
        }
    }

    public void vA() {
        if (this.Zw != null) {
            this.Zw.setVisibility(8);
        }
    }

    private void init() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.editor_tool_more, this, true);
        this.Zq = (LinearLayout) findViewById(com.baidu.tieba.w.lay_editor_more_line1);
        this.Zr = (LinearLayout) findViewById(com.baidu.tieba.w.lay_editor_more_line2);
        this.Ze = (TextView) findViewById(com.baidu.tieba.w.btn_tool_expression);
        this.Zf = (TextView) findViewById(com.baidu.tieba.w.btn_tool_image);
        this.Zg = (HeadImageView) findViewById(com.baidu.tieba.w.iv_tool_image);
        this.Zg.setDrawBorder(false);
        this.Zh = (FrameLayout) findViewById(com.baidu.tieba.w.lay_tool_image);
        this.Zi = (TextView) findViewById(com.baidu.tieba.w.btn_tool_at);
        this.Zl = (TextView) findViewById(com.baidu.tieba.w.btn_tool_privilege);
        this.Zj = (TextView) findViewById(com.baidu.tieba.w.btn_tool_baobao);
        this.Zk = (TextView) findViewById(com.baidu.tieba.w.btn_tool_record);
        this.Zk.setVisibility(4);
        this.Zm = (TextView) findViewById(com.baidu.tieba.w.btn_tool_location);
        if (!TbadkCoreApplication.m255getInst().isBaobaoShouldOpen() || this.Zp) {
            this.Zj.setVisibility(4);
            this.Zj.setEnabled(false);
        }
        if (TbadkCoreApplication.m255getInst().isFaceShopNew()) {
            ec("N");
        } else {
            vs();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.Ze.setOnClickListener(onClickListener);
        this.Zf.setOnClickListener(onClickListener);
        this.Zg.setOnClickListener(onClickListener);
        this.Zi.setOnClickListener(onClickListener);
        this.Zl.setOnClickListener(onClickListener);
        this.Zj.setOnClickListener(onClickListener);
        this.Zk.setOnClickListener(onClickListener);
        this.Zm.setOnClickListener(onClickListener);
    }

    public void setImage(Bitmap bitmap) {
        if (this.Zd == 1) {
            if (this.Zn) {
                setImageToImage(null);
            }
            setImageToCamera(bitmap);
        } else if (this.Zd == 2) {
            if (this.Zo) {
                setImageToCamera(null);
            }
            setImageToImage(bitmap);
        } else if (this.Zd == 0) {
            if (this.Zn) {
                setImageToImage(null);
            }
            if (this.Zo) {
                setImageToCamera(null);
            }
        }
    }

    private void setImageToImage(Bitmap bitmap) {
        if (bitmap != null) {
            this.Zg.setImageBitmap(bitmap);
            this.Zg.setVisibility(0);
            this.Zf.setVisibility(4);
            this.Zn = true;
            return;
        }
        this.Zn = false;
        this.Zg.setImageDrawable(null);
        this.Zg.setVisibility(4);
        this.Zf.setVisibility(0);
    }

    private void setImageToCamera(Bitmap bitmap) {
        if (bitmap != null) {
            this.Zo = true;
        } else {
            this.Zo = false;
        }
    }

    public TextView getmFace() {
        return this.Ze;
    }

    public TextView getmImage() {
        return this.Zf;
    }

    public View getmIVImage() {
        return this.Zg;
    }

    public TextView getmAt() {
        return this.Zi;
    }

    public TextView getmPrivilege() {
        return this.Zl;
    }

    public TextView getBaobao() {
        return this.Zj;
    }

    public TextView getLocation() {
        return this.Zm;
    }

    public void setmImagetype(int i) {
        this.Zd = i;
    }

    public void aK(boolean z) {
        if (this.isFirst) {
            this.Zq.removeView(this.Zh);
            this.Zq.addView(this.Zh);
            this.Zr.removeView(this.Zk);
            this.Zr.addView(this.Zk);
        }
        this.isFirst = false;
        if (z) {
            this.Zq.removeView(this.Zm);
            this.Zq.addView(this.Zm);
            this.Zh.setVisibility(4);
            this.Zl.setVisibility(4);
            this.Zm.setVisibility(4);
            if (TbadkCoreApplication.m255getInst().isBaobaoShouldOpen() && !this.Zp) {
                this.Zj.setVisibility(4);
                this.Zj.setEnabled(false);
                return;
            }
            return;
        }
        this.Zh.setVisibility(0);
        this.Zl.setVisibility(0);
        this.Zm.setVisibility(0);
        if (TbadkCoreApplication.m255getInst().isBaobaoShouldOpen() && !this.Zp) {
            this.Zj.setEnabled(true);
            this.Zj.setVisibility(0);
        }
        if (this.Zp) {
            this.Zr.removeView(this.Zj);
            this.Zr.addView(this.Zj);
        }
        if (TbadkCoreApplication.m255getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.Zl.setEnabled(false);
            this.Zl.setVisibility(4);
        }
    }

    public void vB() {
        this.Zi.setVisibility(4);
        this.Zl.setVisibility(4);
        this.Zj.setVisibility(4);
        this.Zm.setVisibility(4);
        vy();
        this.Zj.setEnabled(false);
    }

    public void vC() {
        this.Zq.setVisibility(8);
        this.Ze.setVisibility(4);
        this.Zi.setVisibility(4);
        if (this.Zr != null) {
            if (this.Zl != null) {
                this.Zr.removeView(this.Zl);
                this.Zr.addView(this.Zl);
                this.Zl.setVisibility(4);
            }
            if (this.Zk != null) {
                this.Zr.removeView(this.Zk);
                this.Zr.addView(this.Zk, 0);
                this.Zk.setVisibility(0);
            }
        }
        this.Zj.setVisibility(0);
        this.Zm.setVisibility(4);
        this.Zj.setEnabled(true);
        this.Zh.setVisibility(4);
        vy();
        vs();
    }

    public void vD() {
        this.Zq.setVisibility(8);
        this.Ze.setVisibility(4);
        this.Zi.setVisibility(4);
        if (this.Zr != null && this.Zl != null) {
            this.Zr.removeView(this.Zl);
            this.Zr.addView(this.Zl);
            this.Zl.setVisibility(4);
        }
        this.Zk.setVisibility(4);
        this.Zj.setVisibility(0);
        this.Zm.setVisibility(4);
        this.Zj.setEnabled(true);
        this.Zh.setVisibility(4);
        vy();
        vs();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (TbadkCoreApplication.m255getInst().isFaceShopNew()) {
            ec("N");
        } else {
            vs();
        }
    }

    public View getFaceButton() {
        return this.Ze;
    }

    public View getImageButton() {
        return this.Zf;
    }

    public View getRecordButton() {
        return this.Zk;
    }

    public void onChangeSkinType(int i) {
        int i2 = com.baidu.tieba.v.selector_editor_more_btn;
        int i3 = com.baidu.tieba.t.cp_cont_c;
        int i4 = com.baidu.tieba.v.btn_pb_add_pic;
        int i5 = com.baidu.tieba.v.btn_pb_add_expression;
        int i6 = com.baidu.tieba.v.btn_pb_add_add;
        int i7 = com.baidu.tieba.v.btn_pb_add_pao;
        int i8 = com.baidu.tieba.v.btn_pb_add_baobao;
        int i9 = com.baidu.tieba.v.btn_pb_add_microphone;
        int i10 = com.baidu.tieba.v.btn_pb_add_pin;
        a(this.Ze, i2, i5, i3, i);
        a(this.Zf, i2, i4, i3, i);
        a(this.Zi, i2, i6, i3, i);
        a(this.Zl, i2, i7, i3, i);
        a(this.Zj, i2, i8, i3, i);
        a(this.Zk, i2, i9, i3, i);
        a(this.Zm, i2, i10, i3, i);
        l(this.Zt, i);
        l(this.Zs, i);
        a(this.Zu, i, false);
        l(this.Zv, i);
        l(this.Zw, i);
    }

    private void l(TextView textView, int i) {
        a(textView, i, true);
    }

    private void a(TextView textView, int i, boolean z) {
        if (textView != null) {
            if (i == 1) {
                bc.b(textView, com.baidu.tieba.t.cp_cont_i, 1);
                if (z) {
                    bc.i((View) textView, com.baidu.tieba.v.icon_news_head_prompt_one);
                    return;
                } else {
                    bc.i((View) textView, com.baidu.tieba.v.icon_news_list_prompt);
                    return;
                }
            }
            textView.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_i));
            if (z) {
                textView.setBackgroundResource(com.baidu.tieba.v.icon_news_head_prompt_one);
            } else {
                textView.setBackgroundResource(com.baidu.tieba.v.icon_news_list_prompt);
            }
        }
    }

    private void a(TextView textView, int i, int i2, int i3, int i4) {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.editor_more_btns_paddingtop);
        if (i4 == 1) {
            bc.i((View) textView, i);
            textView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, bc.getDrawable(i2), (Drawable) null, (Drawable) null);
            bc.b(textView, i3, 1);
            return;
        }
        textView.setBackgroundResource(i);
        textView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null, (Drawable) null);
        textView.setTextColor(this.mContext.getResources().getColor(i3));
    }
}
