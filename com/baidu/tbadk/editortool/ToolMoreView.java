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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class ToolMoreView extends FrameLayout {
    private int ajI;
    private TextView ajJ;
    private TextView ajK;
    private HeadImageView ajL;
    private FrameLayout ajM;
    private TextView ajN;
    private TextView ajO;
    private TextView ajP;
    private TextView ajQ;
    private TextView ajR;
    private boolean ajS;
    private boolean ajT;
    private boolean ajU;
    private LinearLayout ajV;
    private LinearLayout ajW;
    private TextView ajX;
    private TextView ajY;
    private TextView ajZ;
    private TextView aka;
    private TextView akb;
    private TextView akc;
    private boolean akd;
    private boolean isFirst;
    private Context mContext;

    public void setHideBaobao(boolean z) {
        this.akd = z;
        if (this.ajO != null) {
            if (this.akd) {
                this.ajO.setVisibility(4);
            } else {
                this.ajO.setVisibility(0);
            }
        }
    }

    public ToolMoreView(Context context) {
        super(context);
        this.ajI = 0;
        this.ajS = false;
        this.ajT = false;
        this.ajU = false;
        this.isFirst = true;
        this.mContext = context;
        init();
    }

    public ToolMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajI = 0;
        this.ajS = false;
        this.ajT = false;
        this.ajU = false;
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
        if (this.ajX != null) {
            if (this.ajM != null && this.ajM.getVisibility() == 0) {
                int right = this.ajM.getRight() - (this.ajX.getMeasuredWidth() / 2);
                int top = this.ajM.getTop() - (this.ajX.getMeasuredHeight() / 2);
                this.ajX.layout(right, top, this.ajX.getMeasuredWidth() + right, this.ajX.getMeasuredHeight() + top);
            } else {
                this.ajX.layout(0, 0, 0, 0);
            }
        }
        if (this.ajY != null) {
            if (this.ajJ != null && this.ajJ.getVisibility() == 0) {
                int right2 = this.ajJ.getRight() - (this.ajY.getMeasuredWidth() / 2);
                int top2 = this.ajJ.getTop() - (this.ajY.getMeasuredHeight() / 2);
                this.ajY.layout(right2, top2, this.ajY.getMeasuredWidth() + right2, this.ajY.getMeasuredHeight() + top2);
            } else {
                this.ajY.layout(0, 0, 0, 0);
            }
        }
        if (this.ajZ != null) {
            if (this.ajQ != null && this.ajQ.getVisibility() == 0) {
                int right3 = this.ajQ.getRight() - (this.ajZ.getMeasuredWidth() / 2);
                int top3 = (this.ajQ.getTop() + this.ajW.getTop()) - (this.ajZ.getMeasuredHeight() / 2);
                this.ajZ.layout(right3, top3, this.ajZ.getMeasuredWidth() + right3, this.ajZ.getMeasuredHeight() + top3);
            } else {
                this.ajZ.layout(0, 0, 0, 0);
            }
        }
        if (this.akb != null) {
            if (this.ajP != null && this.ajP.getVisibility() == 0) {
                int right4 = this.ajP.getRight() - (this.akb.getMeasuredWidth() / 2);
                int top4 = this.ajP.getTop() - (this.akb.getMeasuredHeight() / 2);
                this.akb.layout(right4, top4, this.akb.getMeasuredWidth() + right4, this.akb.getMeasuredHeight() + top4);
            } else {
                this.akb.layout(0, 0, 0, 0);
            }
        }
        if (this.aka != null) {
            if (!this.akd && this.ajO != null && this.ajO.getVisibility() == 0) {
                int right5 = this.ajO.getRight() - (this.aka.getMeasuredWidth() / 2);
                int top5 = (this.ajO.getTop() + this.ajW.getTop()) - (this.aka.getMeasuredHeight() / 2);
                this.aka.layout(right5, top5, this.aka.getMeasuredWidth() + right5, this.aka.getMeasuredHeight() + top5);
            } else {
                this.aka.layout(0, 0, 0, 0);
            }
        }
        if (this.akc != null) {
            if (this.ajR != null && this.ajR.getVisibility() == 0) {
                int right6 = this.ajR.getRight() - (this.akc.getMeasuredWidth() / 2);
                int top6 = this.ajR.getTop() - (this.akc.getMeasuredHeight() / 2);
                this.akc.layout(right6, top6, this.akc.getMeasuredWidth() + right6, this.akc.getMeasuredHeight() + top6);
                return;
            }
            this.akc.layout(0, 0, 0, 0);
        }
    }

    public TextView aP(boolean z) {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(1, 10.0f);
        ba.b(textView, com.baidu.tieba.s.top_msg_num_day, 1);
        textView.setGravity(17);
        if (z) {
            ba.i((View) textView, com.baidu.tieba.u.icon_news_head_prompt_one);
        } else {
            ba.i((View) textView, com.baidu.tieba.u.icon_news_list_prompt);
        }
        addView(textView, new FrameLayout.LayoutParams(-2, -2));
        return textView;
    }

    public void el(String str) {
        if (this.ajM.getVisibility() == 0) {
            if (this.ajX == null) {
                this.ajX = aP(true);
            }
            this.ajX.setVisibility(0);
            this.ajX.setText(str);
        }
    }

    public void yV() {
        if (this.ajX != null) {
            this.ajX.setVisibility(8);
        }
    }

    public void em(String str) {
        if (this.ajY == null) {
            this.ajY = aP(true);
        }
        this.ajY.setVisibility(0);
        this.ajY.setText(str);
    }

    public void yW() {
        if (this.ajY != null) {
            this.ajY.setVisibility(8);
        }
    }

    public void yX() {
        if (this.ajQ.getVisibility() == 0) {
            if (this.ajZ == null) {
                this.ajZ = aP(false);
            }
            this.ajZ.setVisibility(0);
        }
    }

    public void yY() {
        if (this.ajZ != null) {
            this.ajZ.setVisibility(8);
        }
    }

    public boolean yZ() {
        return this.akc != null && this.akc.getVisibility() == 0 && this.ajR != null && this.ajR.getVisibility() == 0;
    }

    public void za() {
        if (this.ajR.getVisibility() == 0) {
            if (this.akc == null) {
                this.akc = aP(false);
            }
            this.akc.setVisibility(0);
        }
    }

    public void zb() {
        if (this.akc != null) {
            this.akc.setVisibility(8);
        }
    }

    public void en(String str) {
        if (this.ajO.getVisibility() == 0) {
            if (this.aka == null) {
                this.aka = aP(true);
            }
            this.aka.setVisibility(0);
            this.aka.setText(str);
        }
    }

    public void zc() {
        if (this.aka != null) {
            this.aka.setVisibility(8);
        }
    }

    public void zd() {
        if (this.ajP.getVisibility() == 0) {
            if (this.akb == null) {
                this.akb = aP(false);
            }
            this.akb.setVisibility(0);
        }
    }

    public void ze() {
        if (this.akb != null) {
            this.akb.setVisibility(8);
        }
    }

    private void init() {
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.editor_tool_more, this, true);
        this.ajV = (LinearLayout) findViewById(com.baidu.tieba.v.lay_editor_more_line1);
        this.ajW = (LinearLayout) findViewById(com.baidu.tieba.v.lay_editor_more_line2);
        this.ajJ = (TextView) findViewById(com.baidu.tieba.v.btn_tool_expression);
        this.ajK = (TextView) findViewById(com.baidu.tieba.v.btn_tool_image);
        this.ajL = (HeadImageView) findViewById(com.baidu.tieba.v.iv_tool_image);
        this.ajL.setDrawBorder(false);
        this.ajM = (FrameLayout) findViewById(com.baidu.tieba.v.lay_tool_image);
        this.ajN = (TextView) findViewById(com.baidu.tieba.v.btn_tool_at);
        this.ajQ = (TextView) findViewById(com.baidu.tieba.v.btn_tool_privilege);
        this.ajO = (TextView) findViewById(com.baidu.tieba.v.btn_tool_baobao);
        this.ajP = (TextView) findViewById(com.baidu.tieba.v.btn_tool_record);
        this.ajP.setVisibility(4);
        this.ajR = (TextView) findViewById(com.baidu.tieba.v.btn_tool_location);
        if (!TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() || this.akd) {
            this.ajO.setVisibility(4);
            this.ajO.setEnabled(false);
        }
        if (TbadkCoreApplication.m411getInst().isFaceShopNew()) {
            em("N");
        } else {
            yW();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ajJ.setOnClickListener(onClickListener);
        this.ajK.setOnClickListener(onClickListener);
        this.ajL.setOnClickListener(onClickListener);
        this.ajN.setOnClickListener(onClickListener);
        this.ajQ.setOnClickListener(onClickListener);
        this.ajO.setOnClickListener(onClickListener);
        this.ajP.setOnClickListener(onClickListener);
        this.ajR.setOnClickListener(onClickListener);
    }

    public void setImage(Bitmap bitmap) {
        if (this.ajI == 1) {
            if (this.ajS) {
                setImageToImage(null);
            }
            setImageToCamera(bitmap);
        } else if (this.ajI == 2) {
            if (this.ajT) {
                setImageToCamera(null);
            }
            setImageToImage(bitmap);
        } else if (this.ajI == 0) {
            if (this.ajS) {
                setImageToImage(null);
            }
            if (this.ajT) {
                setImageToCamera(null);
            }
        }
    }

    private void setImageToImage(Bitmap bitmap) {
        if (bitmap != null) {
            this.ajL.setImageBitmap(bitmap);
            this.ajL.setVisibility(0);
            this.ajK.setVisibility(4);
            this.ajS = true;
            return;
        }
        this.ajS = false;
        this.ajL.setImageDrawable(null);
        this.ajL.setVisibility(4);
        this.ajK.setVisibility(0);
    }

    private void setImageToCamera(Bitmap bitmap) {
        if (bitmap != null) {
            this.ajT = true;
        } else {
            this.ajT = false;
        }
    }

    public TextView getmFace() {
        return this.ajJ;
    }

    public TextView getmImage() {
        return this.ajK;
    }

    public View getmIVImage() {
        return this.ajL;
    }

    public TextView getmAt() {
        return this.ajN;
    }

    public TextView getmPrivilege() {
        return this.ajQ;
    }

    public TextView getBaobao() {
        return this.ajO;
    }

    public TextView getLocation() {
        return this.ajR;
    }

    public void setmImagetype(int i) {
        this.ajI = i;
    }

    public void aQ(boolean z) {
        if (this.isFirst) {
            this.ajV.removeView(this.ajM);
            this.ajV.addView(this.ajM);
            this.ajW.removeView(this.ajP);
            this.ajW.addView(this.ajP);
        }
        this.isFirst = false;
        if (z) {
            this.ajV.removeView(this.ajR);
            this.ajV.addView(this.ajR);
            this.ajM.setVisibility(4);
            this.ajQ.setVisibility(4);
            this.ajR.setVisibility(4);
            if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && !this.akd) {
                this.ajO.setVisibility(4);
                this.ajO.setEnabled(false);
                return;
            }
            return;
        }
        this.ajM.setVisibility(0);
        this.ajQ.setVisibility(0);
        this.ajR.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && !this.akd) {
            this.ajO.setEnabled(true);
            this.ajO.setVisibility(0);
        }
        if (this.akd) {
            this.ajW.removeView(this.ajO);
            this.ajW.addView(this.ajO);
        }
        if (TbadkCoreApplication.m411getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.ajQ.setEnabled(false);
            this.ajQ.setVisibility(4);
        }
    }

    public void zf() {
        this.ajN.setVisibility(4);
        this.ajQ.setVisibility(4);
        this.ajO.setVisibility(4);
        this.ajR.setVisibility(4);
        zc();
        this.ajO.setEnabled(false);
    }

    public void zg() {
        this.ajV.setVisibility(8);
        this.ajJ.setVisibility(4);
        this.ajN.setVisibility(4);
        if (this.ajW != null) {
            if (this.ajQ != null) {
                this.ajW.removeView(this.ajQ);
                this.ajW.addView(this.ajQ);
                this.ajQ.setVisibility(4);
            }
            if (this.ajP != null) {
                this.ajW.removeView(this.ajP);
                this.ajW.addView(this.ajP, 0);
                this.ajP.setVisibility(0);
            }
        }
        this.ajO.setVisibility(0);
        this.ajR.setVisibility(4);
        this.ajO.setEnabled(true);
        this.ajM.setVisibility(4);
        zc();
        yW();
    }

    public void zh() {
        this.ajV.setVisibility(8);
        this.ajJ.setVisibility(4);
        this.ajN.setVisibility(4);
        if (this.ajW != null) {
            if (this.ajQ != null) {
                this.ajW.removeView(this.ajQ);
                this.ajW.addView(this.ajQ);
                this.ajQ.setVisibility(4);
            }
            if (this.ajP != null) {
                this.ajW.removeView(this.ajP);
                this.ajW.addView(this.ajP);
            }
        }
        this.ajO.setVisibility(0);
        this.ajR.setVisibility(4);
        this.ajO.setEnabled(true);
        this.ajM.setVisibility(4);
        zc();
        yW();
        ze();
    }

    public void zi() {
        this.ajV.setVisibility(8);
        this.ajJ.setVisibility(4);
        this.ajN.setVisibility(4);
        if (this.ajW != null && this.ajQ != null) {
            this.ajW.removeView(this.ajQ);
            this.ajW.addView(this.ajQ);
            this.ajQ.setVisibility(4);
        }
        this.ajP.setVisibility(4);
        this.ajO.setVisibility(0);
        this.ajR.setVisibility(4);
        this.ajO.setEnabled(true);
        this.ajM.setVisibility(4);
        zc();
        yW();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (TbadkCoreApplication.m411getInst().isFaceShopNew()) {
            em("N");
        } else {
            yW();
        }
    }

    public View getFaceButton() {
        return this.ajJ;
    }

    public View getImageButton() {
        return this.ajK;
    }

    public View getRecordButton() {
        return this.ajP;
    }

    public void onChangeSkinType(int i) {
        int i2 = com.baidu.tieba.u.selector_editor_more_btn;
        int i3 = com.baidu.tieba.s.cp_cont_c;
        int i4 = com.baidu.tieba.u.btn_pb_add_pic;
        int i5 = com.baidu.tieba.u.btn_pb_add_expression;
        int i6 = com.baidu.tieba.u.btn_pb_add_add;
        int i7 = com.baidu.tieba.u.btn_pb_add_pao;
        int i8 = com.baidu.tieba.u.btn_pb_add_baobao;
        int i9 = com.baidu.tieba.u.btn_pb_add_microphone;
        int i10 = com.baidu.tieba.u.btn_pb_add_pin;
        a(this.ajJ, i2, i5, i3, i);
        a(this.ajK, i2, i4, i3, i);
        a(this.ajN, i2, i6, i3, i);
        a(this.ajQ, i2, i7, i3, i);
        a(this.ajO, i2, i8, i3, i);
        a(this.ajP, i2, i9, i3, i);
        a(this.ajR, i2, i10, i3, i);
        l(this.ajY, i);
        l(this.ajX, i);
        a(this.ajZ, i, false);
        l(this.aka, i);
        l(this.akb, i);
    }

    private void l(TextView textView, int i) {
        a(textView, i, true);
    }

    private void a(TextView textView, int i, boolean z) {
        if (textView != null) {
            if (i == 1) {
                ba.b(textView, com.baidu.tieba.s.cp_cont_i, 1);
                if (z) {
                    ba.i((View) textView, com.baidu.tieba.u.icon_news_head_prompt_one);
                    return;
                } else {
                    ba.i((View) textView, com.baidu.tieba.u.icon_news_list_prompt);
                    return;
                }
            }
            textView.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_i));
            if (z) {
                textView.setBackgroundResource(com.baidu.tieba.u.icon_news_head_prompt_one);
            } else {
                textView.setBackgroundResource(com.baidu.tieba.u.icon_news_list_prompt);
            }
        }
    }

    private void a(TextView textView, int i, int i2, int i3, int i4) {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.editor_more_btns_paddingtop);
        if (i4 == 1) {
            ba.i((View) textView, i);
            textView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ba.getDrawable(i2), (Drawable) null, (Drawable) null);
            ba.b(textView, i3, 1);
            return;
        }
        textView.setBackgroundResource(i);
        textView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null, (Drawable) null);
        textView.setTextColor(this.mContext.getResources().getColor(i3));
    }
}
