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
    private TextView SB;
    private HeadImageView SC;
    private FrameLayout SD;
    private TextView SE;
    private HeadImageView SF;
    private FrameLayout SG;
    private TextView SH;
    private TextView SI;
    private TextView SJ;
    private TextView SK;
    private TextView SL;
    private boolean SM;
    private boolean SN;
    private boolean SO;
    private LinearLayout SP;
    private LinearLayout SQ;
    private TextView SR;
    private TextView SS;
    private TextView ST;
    private TextView SU;
    private TextView SV;
    private TextView SW;
    private TextView SX;
    private boolean SY;
    private int Sz;
    private boolean isFirst;
    private Context mContext;

    public void setHideBaobao(boolean z) {
        this.SY = z;
        if (this.SI != null) {
            if (this.SY) {
                this.SI.setVisibility(4);
            } else {
                this.SI.setVisibility(0);
            }
        }
    }

    public ToolMoreView(Context context) {
        super(context);
        this.Sz = 0;
        this.SM = false;
        this.SN = false;
        this.SO = false;
        this.isFirst = true;
        this.mContext = context;
        init();
    }

    public ToolMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Sz = 0;
        this.SM = false;
        this.SN = false;
        this.SO = false;
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
        if (this.SR != null) {
            if (this.SD != null && this.SD.getVisibility() == 0) {
                int right = this.SD.getRight() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 14.0f);
                int top = this.SD.getTop() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 2.0f);
                this.SR.layout(right, top, this.SR.getMeasuredWidth() + right, this.SR.getMeasuredHeight() + top);
            } else {
                this.SR.layout(0, 0, 0, 0);
            }
        }
        if (this.SW != null) {
            if (this.SG != null && this.SG.getVisibility() == 0) {
                int right2 = this.SG.getRight() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 14.0f);
                int top2 = this.SG.getTop() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 2.0f);
                this.SW.layout(right2, top2, this.SW.getMeasuredWidth() + right2, this.SW.getMeasuredHeight() + top2);
            } else {
                this.SW.layout(0, 0, 0, 0);
            }
        }
        if (this.SS != null) {
            if (this.SA != null && this.SA.getVisibility() == 0) {
                int right3 = this.SA.getRight() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 14.0f);
                int top3 = this.SA.getTop() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 2.0f);
                this.SS.layout(right3, top3, this.SS.getMeasuredWidth() + right3, this.SS.getMeasuredHeight() + top3);
            } else {
                this.SS.layout(0, 0, 0, 0);
            }
        }
        if (this.ST != null) {
            if (this.SK != null && this.SK.getVisibility() == 0) {
                int right4 = this.SK.getRight() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 14.0f);
                int top4 = (this.SK.getTop() + this.SQ.getTop()) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 2.0f);
                this.ST.layout(right4, top4, this.ST.getMeasuredWidth() + right4, this.ST.getMeasuredHeight() + top4);
            } else {
                this.ST.layout(0, 0, 0, 0);
            }
        }
        if (this.SV != null) {
            if (this.SJ != null && this.SJ.getVisibility() == 0) {
                int right5 = this.SJ.getRight() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 14.0f);
                int top5 = this.SJ.getTop() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 4.0f);
                this.SV.layout(right5, top5, this.SV.getMeasuredWidth() + right5, this.SV.getMeasuredHeight() + top5);
            } else {
                this.SV.layout(0, 0, 0, 0);
            }
        }
        if (this.SU != null) {
            if (!this.SY && this.SI != null && this.SI.getVisibility() == 0) {
                int right6 = this.SI.getRight() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 14.0f);
                int top6 = (this.SI.getTop() + this.SQ.getTop()) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 2.0f);
                this.SU.layout(right6, top6, this.SU.getMeasuredWidth() + right6, this.SU.getMeasuredHeight() + top6);
            } else {
                this.SU.layout(0, 0, 0, 0);
            }
        }
        if (this.SX != null) {
            if (this.SL != null && this.SL.getVisibility() == 0) {
                int right7 = this.SL.getRight() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 14.0f);
                int top7 = (this.SL.getTop() + this.SQ.getTop()) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 2.0f);
                this.SX.layout(right7, top7, this.SX.getMeasuredWidth() + right7, this.SX.getMeasuredHeight() + top7);
                return;
            }
            this.SX.layout(0, 0, 0, 0);
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
        if (this.SD.getVisibility() == 0) {
            if (this.SR == null) {
                this.SR = at(true);
            }
            this.SR.setVisibility(0);
            this.SR.setText(str);
        }
    }

    public void rF() {
        if (this.SR != null) {
            this.SR.setVisibility(8);
        }
    }

    public void dj(String str) {
        if (this.SS == null) {
            this.SS = at(true);
        }
        this.SS.setVisibility(0);
        this.SS.setText(str);
    }

    public void rG() {
        if (this.SS != null) {
            this.SS.setVisibility(8);
        }
    }

    public void rH() {
        if (this.SK.getVisibility() == 0) {
            if (this.ST == null) {
                this.ST = at(false);
            }
            this.ST.setVisibility(0);
        }
    }

    public void rI() {
        if (this.ST != null) {
            this.ST.setVisibility(8);
        }
    }

    public boolean rJ() {
        return this.SX != null && this.SX.getVisibility() == 0 && this.SL != null && this.SL.getVisibility() == 0;
    }

    public void rK() {
        if (this.SL.getVisibility() == 0) {
            if (this.SX == null) {
                this.SX = at(false);
            }
            this.SX.setVisibility(0);
        }
    }

    public void rL() {
        if (this.SX != null) {
            this.SX.setVisibility(8);
        }
    }

    public void dk(String str) {
        if (this.SI.getVisibility() == 0) {
            if (this.SU == null) {
                this.SU = at(true);
            }
            this.SU.setVisibility(0);
            this.SU.setText(str);
        }
    }

    public void rM() {
        if (this.SU != null) {
            this.SU.setVisibility(8);
        }
    }

    public void rN() {
        if (this.SJ.getVisibility() == 0) {
            if (this.SV == null) {
                this.SV = at(false);
            }
            this.SV.setVisibility(0);
        }
    }

    public void rO() {
        if (this.SV != null) {
            this.SV.setVisibility(8);
        }
    }

    private void init() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.editor_tool_more, this, true);
        this.SP = (LinearLayout) findViewById(com.baidu.tieba.v.lay_editor_more_line1);
        this.SQ = (LinearLayout) findViewById(com.baidu.tieba.v.lay_editor_more_line2);
        this.SA = (TextView) findViewById(com.baidu.tieba.v.btn_tool_expression);
        this.SB = (TextView) findViewById(com.baidu.tieba.v.btn_tool_image);
        this.SC = (HeadImageView) findViewById(com.baidu.tieba.v.iv_tool_image);
        this.SC.setDrawBorder(false);
        this.SD = (FrameLayout) findViewById(com.baidu.tieba.v.lay_tool_image);
        this.SE = (TextView) findViewById(com.baidu.tieba.v.btn_tool_camera);
        this.SF = (HeadImageView) findViewById(com.baidu.tieba.v.iv_tool_camera);
        this.SF.setDrawBorder(false);
        this.SG = (FrameLayout) findViewById(com.baidu.tieba.v.lay_tool_camera);
        this.SH = (TextView) findViewById(com.baidu.tieba.v.btn_tool_at);
        this.SK = (TextView) findViewById(com.baidu.tieba.v.btn_tool_privilege);
        this.SI = (TextView) findViewById(com.baidu.tieba.v.btn_tool_baobao);
        this.SJ = (TextView) findViewById(com.baidu.tieba.v.btn_tool_record);
        this.SJ.setVisibility(4);
        this.SL = (TextView) findViewById(com.baidu.tieba.v.btn_tool_location);
        if (!TbadkApplication.m251getInst().isBaobaoShouldOpen() || this.SY) {
            this.SI.setVisibility(4);
            this.SI.setEnabled(false);
        }
        if (TbadkApplication.m251getInst().isFaceShopNew()) {
            dj("N");
        } else {
            rG();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.SA.setOnClickListener(onClickListener);
        this.SB.setOnClickListener(onClickListener);
        this.SE.setOnClickListener(onClickListener);
        this.SC.setOnClickListener(onClickListener);
        this.SF.setOnClickListener(onClickListener);
        this.SH.setOnClickListener(onClickListener);
        this.SK.setOnClickListener(onClickListener);
        this.SI.setOnClickListener(onClickListener);
        this.SJ.setOnClickListener(onClickListener);
        this.SL.setOnClickListener(onClickListener);
    }

    public void setImage(Bitmap bitmap) {
        if (this.Sz == 1) {
            if (this.SM) {
                setImageToImage(null);
            }
            setImageToCamera(bitmap);
        } else if (this.Sz == 2) {
            if (this.SN) {
                setImageToCamera(null);
            }
            setImageToImage(bitmap);
        } else if (this.Sz == 0) {
            if (this.SM) {
                setImageToImage(null);
            }
            if (this.SN) {
                setImageToCamera(null);
            }
        }
    }

    private void setImageToImage(Bitmap bitmap) {
        if (bitmap != null) {
            this.SC.setImageBitmap(bitmap);
            this.SC.setVisibility(0);
            this.SB.setVisibility(4);
            this.SM = true;
            return;
        }
        this.SM = false;
        this.SC.setImageDrawable(null);
        this.SC.setVisibility(4);
        this.SB.setVisibility(0);
    }

    private void setImageToCamera(Bitmap bitmap) {
        if (bitmap != null) {
            this.SF.setImageBitmap(bitmap);
            this.SF.setVisibility(0);
            this.SE.setVisibility(4);
            this.SN = true;
            return;
        }
        this.SN = false;
        this.SF.setImageDrawable(null);
        this.SF.setVisibility(4);
        this.SE.setVisibility(0);
    }

    public TextView getmFace() {
        return this.SA;
    }

    public TextView getmImage() {
        return this.SB;
    }

    public TextView getmCamera() {
        return this.SE;
    }

    public View getmIVImage() {
        return this.SC;
    }

    public View getmIVCamera() {
        return this.SF;
    }

    public TextView getmAt() {
        return this.SH;
    }

    public TextView getmPrivilege() {
        return this.SK;
    }

    public TextView getBaobao() {
        return this.SI;
    }

    public TextView getLocation() {
        return this.SL;
    }

    public void setmImagetype(int i) {
        this.Sz = i;
    }

    public void au(boolean z) {
        if (this.isFirst) {
            this.SP.removeView(this.SD);
            this.SP.removeView(this.SG);
            this.SQ.removeView(this.SK);
            this.SQ.removeView(this.SI);
            this.SP.addView(this.SD);
            this.SP.addView(this.SG);
            this.SQ.addView(this.SK, 0);
            this.SQ.addView(this.SI, 1);
            this.SQ.removeView(this.SJ);
            this.SQ.addView(this.SJ);
        }
        this.isFirst = false;
        if (z) {
            this.SD.setVisibility(4);
            this.SG.setVisibility(4);
            this.SK.setVisibility(4);
            this.SL.setVisibility(4);
            if (TbadkApplication.m251getInst().isBaobaoShouldOpen() && !this.SY) {
                this.SI.setVisibility(4);
                this.SI.setEnabled(false);
                return;
            }
            return;
        }
        this.SD.setVisibility(0);
        this.SG.setVisibility(0);
        this.SK.setVisibility(0);
        this.SL.setVisibility(0);
        if (TbadkApplication.m251getInst().isBaobaoShouldOpen() && !this.SY) {
            this.SI.setEnabled(true);
            this.SI.setVisibility(0);
        }
        if (this.SY) {
            this.SQ.removeView(this.SI);
            this.SQ.addView(this.SI);
        }
    }

    public void rP() {
        this.SH.setVisibility(4);
        this.SK.setVisibility(4);
        this.SI.setVisibility(4);
        this.SL.setVisibility(4);
        rM();
        this.SI.setEnabled(false);
    }

    public void rQ() {
        this.SP.removeView(this.SA);
        this.SP.removeView(this.SH);
        this.SQ.removeView(this.SJ);
        this.SP.removeView(this.SG);
        this.SP.addView(this.SJ);
        this.SP.addView(this.SA);
        this.SQ.addView(this.SH);
        this.SP.addView(this.SG);
        this.SG.setVisibility(4);
        this.SJ.setVisibility(0);
        this.SA.setVisibility(4);
        this.SH.setVisibility(4);
        this.SK.setVisibility(4);
        this.SI.setVisibility(4);
        this.SL.setVisibility(4);
        rM();
        this.SI.setEnabled(false);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (TbadkApplication.m251getInst().isFaceShopNew()) {
            dj("N");
        } else {
            rG();
        }
    }

    public View getFaceButton() {
        return this.SA;
    }

    public View getImageButton() {
        return this.SB;
    }

    public View getCameraButton() {
        return this.SE;
    }

    public View getRecordButton() {
        return this.SJ;
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
        a(this.SA, i2, i5, i3, i);
        a(this.SB, i2, i4, i3, i);
        a(this.SE, i2, i6, i3, i);
        a(this.SH, i2, i7, i3, i);
        a(this.SK, i2, i8, i3, i);
        a(this.SI, i2, i9, i3, i);
        a(this.SJ, i2, i10, i3, i);
        a(this.SL, i2, i11, i3, i);
        m(this.SS, i);
        m(this.SR, i);
        m(this.ST, i);
        m(this.SU, i);
        m(this.SV, i);
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
