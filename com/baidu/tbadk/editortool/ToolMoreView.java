package com.baidu.tbadk.editortool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class ToolMoreView extends FrameLayout {
    private TextView SA;
    private HeadImageView SB;
    private FrameLayout SC;
    private TextView SD;
    private TextView SE;
    private TextView SF;
    private TextView SG;
    private TextView SH;
    private boolean SI;
    private boolean SJ;
    private boolean SK;
    private LinearLayout SL;
    private LinearLayout SM;
    private TextView SN;
    private TextView SO;
    private TextView SP;
    private TextView SQ;
    private TextView SR;
    private TextView SS;
    private TextView ST;
    private boolean SU;
    private int Sv;
    private TextView Sw;
    private TextView Sx;
    private HeadImageView Sy;
    private FrameLayout Sz;
    private boolean isFirst;
    private Context mContext;

    public void setHideBaobao(boolean z) {
        this.SU = z;
        if (this.SE != null) {
            if (this.SU) {
                this.SE.setVisibility(4);
            } else {
                this.SE.setVisibility(0);
            }
        }
    }

    public ToolMoreView(Context context) {
        super(context);
        this.Sv = 0;
        this.SI = false;
        this.SJ = false;
        this.SK = false;
        this.isFirst = true;
        this.mContext = context;
        init();
    }

    public ToolMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Sv = 0;
        this.SI = false;
        this.SJ = false;
        this.SK = false;
        this.isFirst = true;
        this.mContext = context;
        init();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.SN != null) {
            if (this.Sz != null && this.Sz.getVisibility() == 0) {
                int right = this.Sz.getRight() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 14.0f);
                int top = this.Sz.getTop() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 2.0f);
                this.SN.layout(right, top, this.SN.getMeasuredWidth() + right, this.SN.getMeasuredHeight() + top);
            } else {
                this.SN.layout(0, 0, 0, 0);
            }
        }
        if (this.SS != null) {
            if (this.SC != null && this.SC.getVisibility() == 0) {
                int right2 = this.SC.getRight() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 14.0f);
                int top2 = this.SC.getTop() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 2.0f);
                this.SS.layout(right2, top2, this.SS.getMeasuredWidth() + right2, this.SS.getMeasuredHeight() + top2);
            } else {
                this.SS.layout(0, 0, 0, 0);
            }
        }
        if (this.SO != null) {
            if (this.Sw != null && this.Sw.getVisibility() == 0) {
                int right3 = this.Sw.getRight() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 14.0f);
                int top3 = this.Sw.getTop() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 2.0f);
                this.SO.layout(right3, top3, this.SO.getMeasuredWidth() + right3, this.SO.getMeasuredHeight() + top3);
            } else {
                this.SO.layout(0, 0, 0, 0);
            }
        }
        if (this.SP != null) {
            if (this.SG != null && this.SG.getVisibility() == 0) {
                int right4 = this.SG.getRight() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 14.0f);
                int top4 = (this.SG.getTop() + this.SM.getTop()) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 2.0f);
                this.SP.layout(right4, top4, this.SP.getMeasuredWidth() + right4, this.SP.getMeasuredHeight() + top4);
            } else {
                this.SP.layout(0, 0, 0, 0);
            }
        }
        if (this.SR != null) {
            if (this.SF != null && this.SF.getVisibility() == 0) {
                int right5 = this.SF.getRight() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 14.0f);
                int top5 = this.SF.getTop() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 4.0f);
                this.SR.layout(right5, top5, this.SR.getMeasuredWidth() + right5, this.SR.getMeasuredHeight() + top5);
            } else {
                this.SR.layout(0, 0, 0, 0);
            }
        }
        if (this.SQ != null) {
            if (!this.SU && this.SE != null && this.SE.getVisibility() == 0) {
                int right6 = this.SE.getRight() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 14.0f);
                int top6 = (this.SE.getTop() + this.SM.getTop()) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 2.0f);
                this.SQ.layout(right6, top6, this.SQ.getMeasuredWidth() + right6, this.SQ.getMeasuredHeight() + top6);
            } else {
                this.SQ.layout(0, 0, 0, 0);
            }
        }
        if (this.ST != null) {
            if (this.SH != null && this.SH.getVisibility() == 0) {
                int right7 = this.SH.getRight() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 14.0f);
                int top7 = (this.SH.getTop() + this.SM.getTop()) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 2.0f);
                this.ST.layout(right7, top7, this.ST.getMeasuredWidth() + right7, this.ST.getMeasuredHeight() + top7);
                return;
            }
            this.ST.layout(0, 0, 0, 0);
        }
    }

    public TextView at(boolean z) {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(1, 10.0f);
        aw.b(textView, com.baidu.tieba.s.top_msg_num_day, 1);
        textView.setGravity(17);
        if (z) {
            aw.h((View) textView, com.baidu.tieba.u.icon_news_head_prompt_one);
        } else {
            aw.h((View) textView, com.baidu.tieba.u.icon_news_list_prompt);
        }
        addView(textView, new FrameLayout.LayoutParams(-2, -2));
        return textView;
    }

    public void di(String str) {
        if (this.Sz.getVisibility() == 0) {
            if (this.SN == null) {
                this.SN = at(true);
            }
            this.SN.setVisibility(0);
            this.SN.setText(str);
        }
    }

    public void rD() {
        if (this.SN != null) {
            this.SN.setVisibility(8);
        }
    }

    public void dj(String str) {
        if (this.SO == null) {
            this.SO = at(true);
        }
        this.SO.setVisibility(0);
        this.SO.setText(str);
    }

    public void rE() {
        if (this.SO != null) {
            this.SO.setVisibility(8);
        }
    }

    public void rF() {
        if (this.SG.getVisibility() == 0) {
            if (this.SP == null) {
                this.SP = at(false);
            }
            this.SP.setVisibility(0);
        }
    }

    public void rG() {
        if (this.SP != null) {
            this.SP.setVisibility(8);
        }
    }

    public boolean rH() {
        return this.ST != null && this.ST.getVisibility() == 0 && this.SH != null && this.SH.getVisibility() == 0;
    }

    public void rI() {
        if (this.SH.getVisibility() == 0) {
            if (this.ST == null) {
                this.ST = at(false);
            }
            this.ST.setVisibility(0);
        }
    }

    public void rJ() {
        if (this.ST != null) {
            this.ST.setVisibility(8);
        }
    }

    public void dk(String str) {
        if (this.SE.getVisibility() == 0) {
            if (this.SQ == null) {
                this.SQ = at(true);
            }
            this.SQ.setVisibility(0);
            this.SQ.setText(str);
        }
    }

    public void rK() {
        if (this.SQ != null) {
            this.SQ.setVisibility(8);
        }
    }

    public void rL() {
        if (this.SF.getVisibility() == 0) {
            if (this.SR == null) {
                this.SR = at(false);
            }
            this.SR.setVisibility(0);
        }
    }

    public void rM() {
        if (this.SR != null) {
            this.SR.setVisibility(8);
        }
    }

    private void init() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.editor_tool_more, this, true);
        this.SL = (LinearLayout) findViewById(com.baidu.tieba.v.lay_editor_more_line1);
        this.SM = (LinearLayout) findViewById(com.baidu.tieba.v.lay_editor_more_line2);
        this.Sw = (TextView) findViewById(com.baidu.tieba.v.btn_tool_expression);
        this.Sx = (TextView) findViewById(com.baidu.tieba.v.btn_tool_image);
        this.Sy = (HeadImageView) findViewById(com.baidu.tieba.v.iv_tool_image);
        this.Sy.setDrawBorder(false);
        this.Sz = (FrameLayout) findViewById(com.baidu.tieba.v.lay_tool_image);
        this.SA = (TextView) findViewById(com.baidu.tieba.v.btn_tool_camera);
        this.SB = (HeadImageView) findViewById(com.baidu.tieba.v.iv_tool_camera);
        this.SB.setDrawBorder(false);
        this.SC = (FrameLayout) findViewById(com.baidu.tieba.v.lay_tool_camera);
        this.SD = (TextView) findViewById(com.baidu.tieba.v.btn_tool_at);
        this.SG = (TextView) findViewById(com.baidu.tieba.v.btn_tool_privilege);
        this.SE = (TextView) findViewById(com.baidu.tieba.v.btn_tool_baobao);
        this.SF = (TextView) findViewById(com.baidu.tieba.v.btn_tool_record);
        this.SF.setVisibility(4);
        this.SH = (TextView) findViewById(com.baidu.tieba.v.btn_tool_location);
        if (!TbadkApplication.m251getInst().isBaobaoShouldOpen() || this.SU) {
            this.SE.setVisibility(4);
            this.SE.setEnabled(false);
        }
        if (TbadkApplication.m251getInst().isFaceShopNew()) {
            dj("N");
        } else {
            rE();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.Sw.setOnClickListener(onClickListener);
        this.Sx.setOnClickListener(onClickListener);
        this.SA.setOnClickListener(onClickListener);
        this.Sy.setOnClickListener(onClickListener);
        this.SB.setOnClickListener(onClickListener);
        this.SD.setOnClickListener(onClickListener);
        this.SG.setOnClickListener(onClickListener);
        this.SE.setOnClickListener(onClickListener);
        this.SF.setOnClickListener(onClickListener);
        this.SH.setOnClickListener(onClickListener);
    }

    public void setImage(Bitmap bitmap) {
        if (this.Sv == 1) {
            if (this.SI) {
                setImageToImage(null);
            }
            setImageToCamera(bitmap);
        } else if (this.Sv == 2) {
            if (this.SJ) {
                setImageToCamera(null);
            }
            setImageToImage(bitmap);
        } else if (this.Sv == 0) {
            if (this.SI) {
                setImageToImage(null);
            }
            if (this.SJ) {
                setImageToCamera(null);
            }
        }
    }

    private void setImageToImage(Bitmap bitmap) {
        if (bitmap != null) {
            this.Sy.setImageBitmap(bitmap);
            this.Sy.setVisibility(0);
            this.Sx.setVisibility(4);
            this.SI = true;
            return;
        }
        this.SI = false;
        this.Sy.setImageDrawable(null);
        this.Sy.setVisibility(4);
        this.Sx.setVisibility(0);
    }

    private void setImageToCamera(Bitmap bitmap) {
        if (bitmap != null) {
            this.SB.setImageBitmap(bitmap);
            this.SB.setVisibility(0);
            this.SA.setVisibility(4);
            this.SJ = true;
            return;
        }
        this.SJ = false;
        this.SB.setImageDrawable(null);
        this.SB.setVisibility(4);
        this.SA.setVisibility(0);
    }

    public TextView getmFace() {
        return this.Sw;
    }

    public TextView getmImage() {
        return this.Sx;
    }

    public TextView getmCamera() {
        return this.SA;
    }

    public View getmIVImage() {
        return this.Sy;
    }

    public View getmIVCamera() {
        return this.SB;
    }

    public TextView getmAt() {
        return this.SD;
    }

    public TextView getmPrivilege() {
        return this.SG;
    }

    public TextView getBaobao() {
        return this.SE;
    }

    public TextView getLocation() {
        return this.SH;
    }

    public void setmImagetype(int i) {
        this.Sv = i;
    }

    public void au(boolean z) {
        if (this.isFirst) {
            this.SL.removeView(this.Sz);
            this.SL.removeView(this.SC);
            this.SM.removeView(this.SG);
            this.SM.removeView(this.SE);
            this.SL.addView(this.Sz);
            this.SL.addView(this.SC);
            this.SM.addView(this.SG, 0);
            this.SM.addView(this.SE, 1);
            this.SM.removeView(this.SF);
            this.SM.addView(this.SF);
        }
        this.isFirst = false;
        if (z) {
            this.Sz.setVisibility(4);
            this.SC.setVisibility(4);
            this.SG.setVisibility(4);
            this.SH.setVisibility(4);
            if (TbadkApplication.m251getInst().isBaobaoShouldOpen() && !this.SU) {
                this.SE.setVisibility(4);
                this.SE.setEnabled(false);
                return;
            }
            return;
        }
        this.Sz.setVisibility(0);
        this.SC.setVisibility(0);
        this.SG.setVisibility(0);
        this.SH.setVisibility(0);
        if (TbadkApplication.m251getInst().isBaobaoShouldOpen() && !this.SU) {
            this.SE.setEnabled(true);
            this.SE.setVisibility(0);
        }
        if (this.SU) {
            this.SM.removeView(this.SE);
            this.SM.addView(this.SE);
        }
    }

    public void rN() {
        this.SD.setVisibility(4);
        this.SG.setVisibility(4);
        this.SE.setVisibility(4);
        this.SH.setVisibility(4);
        rK();
        this.SE.setEnabled(false);
    }

    public void rO() {
        this.SL.removeView(this.Sw);
        this.SL.removeView(this.SD);
        this.SM.removeView(this.SF);
        this.SL.removeView(this.SC);
        this.SL.addView(this.SF);
        this.SL.addView(this.Sw);
        this.SM.addView(this.SD);
        this.SL.addView(this.SC);
        this.SC.setVisibility(4);
        this.SF.setVisibility(0);
        this.Sw.setVisibility(4);
        this.SD.setVisibility(4);
        this.SG.setVisibility(4);
        this.SE.setVisibility(4);
        this.SH.setVisibility(4);
        rK();
        this.SE.setEnabled(false);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (TbadkApplication.m251getInst().isFaceShopNew()) {
            dj("N");
        } else {
            rE();
        }
    }

    public View getFaceButton() {
        return this.Sw;
    }

    public View getImageButton() {
        return this.Sx;
    }

    public View getCameraButton() {
        return this.SA;
    }

    public View getRecordButton() {
        return this.SF;
    }

    public void onChangeSkinType(int i) {
        int i2 = com.baidu.tieba.u.selector_editor_more_btn;
        int i3 = com.baidu.tieba.s.editor_more_btn_text;
        int i4 = com.baidu.tieba.u.btn_pb_add_pic;
        int i5 = com.baidu.tieba.u.btn_pb_add_expression;
        int i6 = com.baidu.tieba.u.btn_pb_add_camera;
        int i7 = com.baidu.tieba.u.btn_pb_add_add;
        int i8 = com.baidu.tieba.u.btn_pb_add_crown;
        int i9 = com.baidu.tieba.u.btn_pb_add_baobao;
        int i10 = com.baidu.tieba.u.btn_pb_add_microphone;
        int i11 = com.baidu.tieba.u.btn_pb_add_pin;
        a(this.Sw, i2, i5, i3, i);
        a(this.Sx, i2, i4, i3, i);
        a(this.SA, i2, i6, i3, i);
        a(this.SD, i2, i7, i3, i);
        a(this.SG, i2, i8, i3, i);
        a(this.SE, i2, i9, i3, i);
        a(this.SF, i2, i10, i3, i);
        a(this.SH, i2, i11, i3, i);
        m(this.SO, i);
        m(this.SN, i);
        m(this.SP, i);
        m(this.SQ, i);
        m(this.SR, i);
    }

    private void m(TextView textView, int i) {
        if (textView != null) {
            if (i == 1) {
                aw.b(textView, com.baidu.tieba.s.top_msg_num_day, 1);
                aw.h((View) textView, com.baidu.tieba.u.icon_news_head_prompt_one);
                return;
            }
            textView.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.top_msg_num_day));
            textView.setBackgroundResource(com.baidu.tieba.u.icon_news_head_prompt_one);
        }
    }

    private void a(TextView textView, int i, int i2, int i3, int i4) {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.editor_more_btns_paddingtop);
        if (i4 == 1) {
            aw.h((View) textView, i);
            textView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aw.getDrawable(i2), (Drawable) null, (Drawable) null);
            aw.b(textView, i3, 1);
            return;
        }
        textView.setBackgroundResource(i);
        textView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null, (Drawable) null);
        textView.setTextColor(this.mContext.getResources().getColor(i3));
    }
}
