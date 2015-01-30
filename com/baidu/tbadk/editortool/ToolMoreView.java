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
    private TextView ZA;
    private int Zg;
    private TextView Zh;
    private TextView Zi;
    private HeadImageView Zj;
    private FrameLayout Zk;
    private TextView Zl;
    private TextView Zm;
    private TextView Zn;
    private TextView Zo;
    private TextView Zp;
    private boolean Zq;
    private boolean Zr;
    private boolean Zs;
    private LinearLayout Zt;
    private LinearLayout Zu;
    private TextView Zv;
    private TextView Zw;
    private TextView Zx;
    private TextView Zy;
    private TextView Zz;
    private boolean isFirst;
    private Context mContext;

    public ToolMoreView(Context context) {
        super(context);
        this.Zg = 0;
        this.isFirst = true;
        this.mContext = context;
        init();
    }

    public ToolMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Zg = 0;
        this.isFirst = true;
        this.mContext = context;
        init();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.Zv != null) {
            if (this.Zk != null && this.Zk.getVisibility() == 0) {
                int right = this.Zk.getRight() - (this.Zv.getMeasuredWidth() / 2);
                int top = this.Zk.getTop() - (this.Zv.getMeasuredHeight() / 2);
                this.Zv.layout(right, top, this.Zv.getMeasuredWidth() + right, this.Zv.getMeasuredHeight() + top);
            } else {
                this.Zv.layout(0, 0, 0, 0);
            }
        }
        if (this.Zw != null) {
            if (this.Zh != null && this.Zh.getVisibility() == 0) {
                int right2 = this.Zh.getRight() - (this.Zw.getMeasuredWidth() / 2);
                int top2 = this.Zh.getTop() - (this.Zw.getMeasuredHeight() / 2);
                this.Zw.layout(right2, top2, this.Zw.getMeasuredWidth() + right2, this.Zw.getMeasuredHeight() + top2);
            } else {
                this.Zw.layout(0, 0, 0, 0);
            }
        }
        if (this.Zx != null) {
            if (this.Zo != null && this.Zo.getVisibility() == 0) {
                int right3 = this.Zo.getRight() - (this.Zx.getMeasuredWidth() / 2);
                int top3 = (this.Zo.getTop() + this.Zu.getTop()) - (this.Zx.getMeasuredHeight() / 2);
                this.Zx.layout(right3, top3, this.Zx.getMeasuredWidth() + right3, this.Zx.getMeasuredHeight() + top3);
            } else {
                this.Zx.layout(0, 0, 0, 0);
            }
        }
        if (this.Zz != null) {
            if (this.Zn != null && this.Zn.getVisibility() == 0) {
                int right4 = this.Zn.getRight() - (this.Zz.getMeasuredWidth() / 2);
                int top4 = this.Zn.getTop() - (this.Zz.getMeasuredHeight() / 2);
                this.Zz.layout(right4, top4, this.Zz.getMeasuredWidth() + right4, this.Zz.getMeasuredHeight() + top4);
            } else {
                this.Zz.layout(0, 0, 0, 0);
            }
        }
        if (this.Zy != null) {
            if (!this.Zs && this.Zm != null && this.Zm.getVisibility() == 0) {
                int right5 = this.Zm.getRight() - (this.Zy.getMeasuredWidth() / 2);
                int top5 = (this.Zm.getTop() + this.Zu.getTop()) - (this.Zy.getMeasuredHeight() / 2);
                this.Zy.layout(right5, top5, this.Zy.getMeasuredWidth() + right5, this.Zy.getMeasuredHeight() + top5);
            } else {
                this.Zy.layout(0, 0, 0, 0);
            }
        }
        if (this.ZA != null) {
            if (this.Zp != null && this.Zp.getVisibility() == 0) {
                int right6 = this.Zp.getRight() - (this.ZA.getMeasuredWidth() / 2);
                int top6 = this.Zp.getTop() - (this.ZA.getMeasuredHeight() / 2);
                this.ZA.layout(right6, top6, this.ZA.getMeasuredWidth() + right6, this.ZA.getMeasuredHeight() + top6);
                return;
            }
            this.ZA.layout(0, 0, 0, 0);
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
        this.Zs = z;
        if (this.Zm != null) {
            if (this.Zs) {
                this.Zm.setVisibility(4);
            } else {
                this.Zm.setVisibility(0);
            }
        }
    }

    public void ee(String str) {
        if (this.Zk.getVisibility() == 0) {
            if (this.Zv == null) {
                this.Zv = aJ(true);
            }
            this.Zv.setVisibility(0);
            this.Zv.setText(str);
        }
    }

    public void vx() {
        if (this.Zv != null) {
            this.Zv.setVisibility(8);
        }
    }

    public void ef(String str) {
        if (this.Zw == null) {
            this.Zw = aJ(true);
        }
        this.Zw.setVisibility(0);
        this.Zw.setText(str);
    }

    public void vy() {
        if (this.Zw != null) {
            this.Zw.setVisibility(8);
        }
    }

    public void vz() {
        if (this.Zo.getVisibility() == 0) {
            if (this.Zx == null) {
                this.Zx = aJ(false);
            }
            this.Zx.setVisibility(0);
        }
    }

    public void vA() {
        if (this.Zx != null) {
            this.Zx.setVisibility(8);
        }
    }

    public boolean vB() {
        return this.ZA != null && this.ZA.getVisibility() == 0 && this.Zp != null && this.Zp.getVisibility() == 0;
    }

    public void vC() {
        if (this.Zp.getVisibility() == 0) {
            if (this.ZA == null) {
                this.ZA = aJ(false);
            }
            this.ZA.setVisibility(0);
        }
    }

    public void vD() {
        if (this.ZA != null) {
            this.ZA.setVisibility(8);
        }
    }

    public void eg(String str) {
        if (this.Zm.getVisibility() == 0) {
            if (this.Zy == null) {
                this.Zy = aJ(true);
            }
            this.Zy.setVisibility(0);
            this.Zy.setText(str);
        }
    }

    public void vE() {
        if (this.Zy != null) {
            this.Zy.setVisibility(8);
        }
    }

    public void vF() {
        if (this.Zn.getVisibility() == 0) {
            if (this.Zz == null) {
                this.Zz = aJ(false);
            }
            this.Zz.setVisibility(0);
        }
    }

    public void vG() {
        if (this.Zz != null) {
            this.Zz.setVisibility(8);
        }
    }

    private void init() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.editor_tool_more, this, true);
        this.Zt = (LinearLayout) findViewById(com.baidu.tieba.w.lay_editor_more_line1);
        this.Zu = (LinearLayout) findViewById(com.baidu.tieba.w.lay_editor_more_line2);
        this.Zh = (TextView) findViewById(com.baidu.tieba.w.btn_tool_expression);
        this.Zi = (TextView) findViewById(com.baidu.tieba.w.btn_tool_image);
        this.Zj = (HeadImageView) findViewById(com.baidu.tieba.w.iv_tool_image);
        this.Zj.setDrawBorder(false);
        this.Zk = (FrameLayout) findViewById(com.baidu.tieba.w.lay_tool_image);
        this.Zl = (TextView) findViewById(com.baidu.tieba.w.btn_tool_at);
        this.Zo = (TextView) findViewById(com.baidu.tieba.w.btn_tool_privilege);
        this.Zm = (TextView) findViewById(com.baidu.tieba.w.btn_tool_baobao);
        this.Zn = (TextView) findViewById(com.baidu.tieba.w.btn_tool_record);
        this.Zn.setVisibility(4);
        this.Zp = (TextView) findViewById(com.baidu.tieba.w.btn_tool_location);
        if (!TbadkCoreApplication.m255getInst().isBaobaoShouldOpen() || this.Zs) {
            this.Zm.setVisibility(4);
            this.Zm.setEnabled(false);
        }
        if (TbadkCoreApplication.m255getInst().isFaceShopNew()) {
            ef("N");
        } else {
            vy();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.Zh.setOnClickListener(onClickListener);
        this.Zi.setOnClickListener(onClickListener);
        this.Zj.setOnClickListener(onClickListener);
        this.Zl.setOnClickListener(onClickListener);
        this.Zo.setOnClickListener(onClickListener);
        this.Zm.setOnClickListener(onClickListener);
        this.Zn.setOnClickListener(onClickListener);
        this.Zp.setOnClickListener(onClickListener);
    }

    public void setImage(Bitmap bitmap) {
        if (this.Zg == 1) {
            if (this.Zq) {
                setImageToImage(null);
            }
            setImageToCamera(bitmap);
        } else if (this.Zg == 2) {
            if (this.Zr) {
                setImageToCamera(null);
            }
            setImageToImage(bitmap);
        } else if (this.Zg == 0) {
            if (this.Zq) {
                setImageToImage(null);
            }
            if (this.Zr) {
                setImageToCamera(null);
            }
        }
    }

    private void setImageToImage(Bitmap bitmap) {
        if (bitmap != null) {
            this.Zj.setImageBitmap(bitmap);
            this.Zj.setVisibility(0);
            this.Zi.setVisibility(4);
            this.Zq = true;
            return;
        }
        this.Zq = false;
        this.Zj.setImageDrawable(null);
        this.Zj.setVisibility(4);
        this.Zi.setVisibility(0);
    }

    private void setImageToCamera(Bitmap bitmap) {
        if (bitmap != null) {
            this.Zr = true;
        } else {
            this.Zr = false;
        }
    }

    public TextView getmFace() {
        return this.Zh;
    }

    public TextView getmImage() {
        return this.Zi;
    }

    public View getmIVImage() {
        return this.Zj;
    }

    public TextView getmAt() {
        return this.Zl;
    }

    public TextView getmPrivilege() {
        return this.Zo;
    }

    public TextView getBaobao() {
        return this.Zm;
    }

    public TextView getLocation() {
        return this.Zp;
    }

    public void setmImagetype(int i) {
        this.Zg = i;
    }

    public void aK(boolean z) {
        if (this.isFirst) {
            this.Zt.removeView(this.Zk);
            this.Zt.addView(this.Zk);
            this.Zu.removeView(this.Zn);
            this.Zu.addView(this.Zn);
        }
        this.isFirst = false;
        if (z) {
            this.Zt.removeView(this.Zp);
            this.Zt.addView(this.Zp);
            this.Zk.setVisibility(4);
            this.Zo.setVisibility(4);
            this.Zp.setVisibility(4);
            if (TbadkCoreApplication.m255getInst().isBaobaoShouldOpen() && !this.Zs) {
                this.Zm.setVisibility(4);
                this.Zm.setEnabled(false);
                return;
            }
            return;
        }
        this.Zk.setVisibility(0);
        this.Zo.setVisibility(0);
        this.Zp.setVisibility(0);
        if (TbadkCoreApplication.m255getInst().isBaobaoShouldOpen() && !this.Zs) {
            this.Zm.setEnabled(true);
            this.Zm.setVisibility(0);
        }
        if (this.Zs) {
            this.Zu.removeView(this.Zm);
            this.Zu.addView(this.Zm);
        }
        if (TbadkCoreApplication.m255getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.Zo.setEnabled(false);
            this.Zo.setVisibility(4);
        }
    }

    public void vH() {
        this.Zl.setVisibility(4);
        this.Zo.setVisibility(4);
        this.Zm.setVisibility(4);
        this.Zp.setVisibility(4);
        vE();
        this.Zm.setEnabled(false);
    }

    public void vI() {
        this.Zt.setVisibility(8);
        this.Zh.setVisibility(4);
        this.Zl.setVisibility(4);
        if (this.Zu != null) {
            if (this.Zo != null) {
                this.Zu.removeView(this.Zo);
                this.Zu.addView(this.Zo);
                this.Zo.setVisibility(4);
            }
            if (this.Zn != null) {
                this.Zu.removeView(this.Zn);
                this.Zu.addView(this.Zn, 0);
                this.Zn.setVisibility(0);
            }
        }
        this.Zm.setVisibility(0);
        this.Zp.setVisibility(4);
        this.Zm.setEnabled(true);
        this.Zk.setVisibility(4);
        vE();
        vy();
    }

    public void vJ() {
        this.Zt.setVisibility(8);
        this.Zh.setVisibility(4);
        this.Zl.setVisibility(4);
        if (this.Zu != null && this.Zo != null) {
            this.Zu.removeView(this.Zo);
            this.Zu.addView(this.Zo);
            this.Zo.setVisibility(4);
        }
        this.Zn.setVisibility(4);
        this.Zm.setVisibility(0);
        this.Zp.setVisibility(4);
        this.Zm.setEnabled(true);
        this.Zk.setVisibility(4);
        vE();
        vy();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (TbadkCoreApplication.m255getInst().isFaceShopNew()) {
            ef("N");
        } else {
            vy();
        }
    }

    public View getFaceButton() {
        return this.Zh;
    }

    public View getImageButton() {
        return this.Zi;
    }

    public View getRecordButton() {
        return this.Zn;
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
        a(this.Zh, i2, i5, i3, i);
        a(this.Zi, i2, i4, i3, i);
        a(this.Zl, i2, i6, i3, i);
        a(this.Zo, i2, i7, i3, i);
        a(this.Zm, i2, i8, i3, i);
        a(this.Zn, i2, i9, i3, i);
        a(this.Zp, i2, i10, i3, i);
        l(this.Zw, i);
        l(this.Zv, i);
        a(this.Zx, i, false);
        l(this.Zy, i);
        l(this.Zz, i);
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
