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
    private int ajA;
    private TextView ajB;
    private TextView ajC;
    private HeadImageView ajD;
    private FrameLayout ajE;
    private TextView ajF;
    private TextView ajG;
    private TextView ajH;
    private TextView ajI;
    private TextView ajJ;
    private boolean ajK;
    private boolean ajL;
    private boolean ajM;
    private LinearLayout ajN;
    private LinearLayout ajO;
    private TextView ajP;
    private TextView ajQ;
    private TextView ajR;
    private TextView ajS;
    private TextView ajT;
    private TextView ajU;
    private boolean ajV;
    private boolean isFirst;
    private Context mContext;

    public void setHideBaobao(boolean z) {
        this.ajV = z;
        if (this.ajG != null) {
            if (this.ajV) {
                this.ajG.setVisibility(4);
            } else {
                this.ajG.setVisibility(0);
            }
        }
    }

    public ToolMoreView(Context context) {
        super(context);
        this.ajA = 0;
        this.ajK = false;
        this.ajL = false;
        this.ajM = false;
        this.isFirst = true;
        this.mContext = context;
        init();
    }

    public ToolMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajA = 0;
        this.ajK = false;
        this.ajL = false;
        this.ajM = false;
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
        if (this.ajP != null) {
            if (this.ajE != null && this.ajE.getVisibility() == 0) {
                int right = this.ajE.getRight() - (this.ajP.getMeasuredWidth() / 2);
                int top = this.ajE.getTop() - (this.ajP.getMeasuredHeight() / 2);
                this.ajP.layout(right, top, this.ajP.getMeasuredWidth() + right, this.ajP.getMeasuredHeight() + top);
            } else {
                this.ajP.layout(0, 0, 0, 0);
            }
        }
        if (this.ajQ != null) {
            if (this.ajB != null && this.ajB.getVisibility() == 0) {
                int right2 = this.ajB.getRight() - (this.ajQ.getMeasuredWidth() / 2);
                int top2 = this.ajB.getTop() - (this.ajQ.getMeasuredHeight() / 2);
                this.ajQ.layout(right2, top2, this.ajQ.getMeasuredWidth() + right2, this.ajQ.getMeasuredHeight() + top2);
            } else {
                this.ajQ.layout(0, 0, 0, 0);
            }
        }
        if (this.ajR != null) {
            if (this.ajI != null && this.ajI.getVisibility() == 0) {
                int right3 = this.ajI.getRight() - (this.ajR.getMeasuredWidth() / 2);
                int top3 = (this.ajI.getTop() + this.ajO.getTop()) - (this.ajR.getMeasuredHeight() / 2);
                this.ajR.layout(right3, top3, this.ajR.getMeasuredWidth() + right3, this.ajR.getMeasuredHeight() + top3);
            } else {
                this.ajR.layout(0, 0, 0, 0);
            }
        }
        if (this.ajT != null) {
            if (this.ajH != null && this.ajH.getVisibility() == 0) {
                int right4 = this.ajH.getRight() - (this.ajT.getMeasuredWidth() / 2);
                int top4 = this.ajH.getTop() - (this.ajT.getMeasuredHeight() / 2);
                this.ajT.layout(right4, top4, this.ajT.getMeasuredWidth() + right4, this.ajT.getMeasuredHeight() + top4);
            } else {
                this.ajT.layout(0, 0, 0, 0);
            }
        }
        if (this.ajS != null) {
            if (!this.ajV && this.ajG != null && this.ajG.getVisibility() == 0) {
                int right5 = this.ajG.getRight() - (this.ajS.getMeasuredWidth() / 2);
                int top5 = (this.ajG.getTop() + this.ajO.getTop()) - (this.ajS.getMeasuredHeight() / 2);
                this.ajS.layout(right5, top5, this.ajS.getMeasuredWidth() + right5, this.ajS.getMeasuredHeight() + top5);
            } else {
                this.ajS.layout(0, 0, 0, 0);
            }
        }
        if (this.ajU != null) {
            if (this.ajJ != null && this.ajJ.getVisibility() == 0) {
                int right6 = this.ajJ.getRight() - (this.ajU.getMeasuredWidth() / 2);
                int top6 = this.ajJ.getTop() - (this.ajU.getMeasuredHeight() / 2);
                this.ajU.layout(right6, top6, this.ajU.getMeasuredWidth() + right6, this.ajU.getMeasuredHeight() + top6);
                return;
            }
            this.ajU.layout(0, 0, 0, 0);
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

    public void ei(String str) {
        if (this.ajE.getVisibility() == 0) {
            if (this.ajP == null) {
                this.ajP = aP(true);
            }
            this.ajP.setVisibility(0);
            this.ajP.setText(str);
        }
    }

    public void yP() {
        if (this.ajP != null) {
            this.ajP.setVisibility(8);
        }
    }

    public void ej(String str) {
        if (this.ajQ == null) {
            this.ajQ = aP(true);
        }
        this.ajQ.setVisibility(0);
        this.ajQ.setText(str);
    }

    public void yQ() {
        if (this.ajQ != null) {
            this.ajQ.setVisibility(8);
        }
    }

    public void yR() {
        if (this.ajI.getVisibility() == 0) {
            if (this.ajR == null) {
                this.ajR = aP(false);
            }
            this.ajR.setVisibility(0);
        }
    }

    public void yS() {
        if (this.ajR != null) {
            this.ajR.setVisibility(8);
        }
    }

    public boolean yT() {
        return this.ajU != null && this.ajU.getVisibility() == 0 && this.ajJ != null && this.ajJ.getVisibility() == 0;
    }

    public void yU() {
        if (this.ajJ.getVisibility() == 0) {
            if (this.ajU == null) {
                this.ajU = aP(false);
            }
            this.ajU.setVisibility(0);
        }
    }

    public void yV() {
        if (this.ajU != null) {
            this.ajU.setVisibility(8);
        }
    }

    public void ek(String str) {
        if (this.ajG.getVisibility() == 0) {
            if (this.ajS == null) {
                this.ajS = aP(true);
            }
            this.ajS.setVisibility(0);
            this.ajS.setText(str);
        }
    }

    public void yW() {
        if (this.ajS != null) {
            this.ajS.setVisibility(8);
        }
    }

    public void yX() {
        if (this.ajH.getVisibility() == 0) {
            if (this.ajT == null) {
                this.ajT = aP(false);
            }
            this.ajT.setVisibility(0);
        }
    }

    public void yY() {
        if (this.ajT != null) {
            this.ajT.setVisibility(8);
        }
    }

    private void init() {
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.editor_tool_more, this, true);
        this.ajN = (LinearLayout) findViewById(com.baidu.tieba.v.lay_editor_more_line1);
        this.ajO = (LinearLayout) findViewById(com.baidu.tieba.v.lay_editor_more_line2);
        this.ajB = (TextView) findViewById(com.baidu.tieba.v.btn_tool_expression);
        this.ajC = (TextView) findViewById(com.baidu.tieba.v.btn_tool_image);
        this.ajD = (HeadImageView) findViewById(com.baidu.tieba.v.iv_tool_image);
        this.ajD.setDrawBorder(false);
        this.ajE = (FrameLayout) findViewById(com.baidu.tieba.v.lay_tool_image);
        this.ajF = (TextView) findViewById(com.baidu.tieba.v.btn_tool_at);
        this.ajI = (TextView) findViewById(com.baidu.tieba.v.btn_tool_privilege);
        this.ajG = (TextView) findViewById(com.baidu.tieba.v.btn_tool_baobao);
        this.ajH = (TextView) findViewById(com.baidu.tieba.v.btn_tool_record);
        this.ajH.setVisibility(4);
        this.ajJ = (TextView) findViewById(com.baidu.tieba.v.btn_tool_location);
        if (!TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() || this.ajV) {
            this.ajG.setVisibility(4);
            this.ajG.setEnabled(false);
        }
        if (TbadkCoreApplication.m411getInst().isFaceShopNew()) {
            ej("N");
        } else {
            yQ();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ajB.setOnClickListener(onClickListener);
        this.ajC.setOnClickListener(onClickListener);
        this.ajD.setOnClickListener(onClickListener);
        this.ajF.setOnClickListener(onClickListener);
        this.ajI.setOnClickListener(onClickListener);
        this.ajG.setOnClickListener(onClickListener);
        this.ajH.setOnClickListener(onClickListener);
        this.ajJ.setOnClickListener(onClickListener);
    }

    public void setImage(Bitmap bitmap) {
        if (this.ajA == 1) {
            if (this.ajK) {
                setImageToImage(null);
            }
            setImageToCamera(bitmap);
        } else if (this.ajA == 2) {
            if (this.ajL) {
                setImageToCamera(null);
            }
            setImageToImage(bitmap);
        } else if (this.ajA == 0) {
            if (this.ajK) {
                setImageToImage(null);
            }
            if (this.ajL) {
                setImageToCamera(null);
            }
        }
    }

    private void setImageToImage(Bitmap bitmap) {
        if (bitmap != null) {
            this.ajD.setImageBitmap(bitmap);
            this.ajD.setVisibility(0);
            this.ajC.setVisibility(4);
            this.ajK = true;
            return;
        }
        this.ajK = false;
        this.ajD.setImageDrawable(null);
        this.ajD.setVisibility(4);
        this.ajC.setVisibility(0);
    }

    private void setImageToCamera(Bitmap bitmap) {
        if (bitmap != null) {
            this.ajL = true;
        } else {
            this.ajL = false;
        }
    }

    public TextView getmFace() {
        return this.ajB;
    }

    public TextView getmImage() {
        return this.ajC;
    }

    public View getmIVImage() {
        return this.ajD;
    }

    public TextView getmAt() {
        return this.ajF;
    }

    public TextView getmPrivilege() {
        return this.ajI;
    }

    public TextView getBaobao() {
        return this.ajG;
    }

    public TextView getLocation() {
        return this.ajJ;
    }

    public void setmImagetype(int i) {
        this.ajA = i;
    }

    public void aQ(boolean z) {
        if (this.isFirst) {
            this.ajN.removeView(this.ajE);
            this.ajN.addView(this.ajE);
            this.ajO.removeView(this.ajH);
            this.ajO.addView(this.ajH);
        }
        this.isFirst = false;
        if (z) {
            this.ajN.removeView(this.ajJ);
            this.ajN.addView(this.ajJ);
            this.ajE.setVisibility(4);
            this.ajI.setVisibility(4);
            this.ajJ.setVisibility(4);
            if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && !this.ajV) {
                this.ajG.setVisibility(4);
                this.ajG.setEnabled(false);
                return;
            }
            return;
        }
        this.ajE.setVisibility(0);
        this.ajI.setVisibility(0);
        this.ajJ.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && !this.ajV) {
            this.ajG.setEnabled(true);
            this.ajG.setVisibility(0);
        }
        if (this.ajV) {
            this.ajO.removeView(this.ajG);
            this.ajO.addView(this.ajG);
        }
        if (TbadkCoreApplication.m411getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.ajI.setEnabled(false);
            this.ajI.setVisibility(4);
        }
    }

    public void yZ() {
        this.ajF.setVisibility(4);
        this.ajI.setVisibility(4);
        this.ajG.setVisibility(4);
        this.ajJ.setVisibility(4);
        yW();
        this.ajG.setEnabled(false);
    }

    public void za() {
        this.ajN.setVisibility(8);
        this.ajB.setVisibility(4);
        this.ajF.setVisibility(4);
        if (this.ajO != null) {
            if (this.ajI != null) {
                this.ajO.removeView(this.ajI);
                this.ajO.addView(this.ajI);
                this.ajI.setVisibility(4);
            }
            if (this.ajH != null) {
                this.ajO.removeView(this.ajH);
                this.ajO.addView(this.ajH, 0);
                this.ajH.setVisibility(0);
            }
        }
        this.ajG.setVisibility(0);
        this.ajJ.setVisibility(4);
        this.ajG.setEnabled(true);
        this.ajE.setVisibility(4);
        yW();
        yQ();
    }

    public void zb() {
        this.ajN.setVisibility(8);
        this.ajB.setVisibility(4);
        this.ajF.setVisibility(4);
        if (this.ajO != null) {
            if (this.ajI != null) {
                this.ajO.removeView(this.ajI);
                this.ajO.addView(this.ajI);
                this.ajI.setVisibility(4);
            }
            if (this.ajH != null) {
                this.ajO.removeView(this.ajH);
                this.ajO.addView(this.ajH);
            }
        }
        this.ajG.setVisibility(0);
        this.ajJ.setVisibility(4);
        this.ajG.setEnabled(true);
        this.ajE.setVisibility(4);
        yW();
        yQ();
        yY();
    }

    public void zc() {
        this.ajN.setVisibility(8);
        this.ajB.setVisibility(4);
        this.ajF.setVisibility(4);
        if (this.ajO != null && this.ajI != null) {
            this.ajO.removeView(this.ajI);
            this.ajO.addView(this.ajI);
            this.ajI.setVisibility(4);
        }
        this.ajH.setVisibility(4);
        this.ajG.setVisibility(0);
        this.ajJ.setVisibility(4);
        this.ajG.setEnabled(true);
        this.ajE.setVisibility(4);
        yW();
        yQ();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (TbadkCoreApplication.m411getInst().isFaceShopNew()) {
            ej("N");
        } else {
            yQ();
        }
    }

    public View getFaceButton() {
        return this.ajB;
    }

    public View getImageButton() {
        return this.ajC;
    }

    public View getRecordButton() {
        return this.ajH;
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
        a(this.ajB, i2, i5, i3, i);
        a(this.ajC, i2, i4, i3, i);
        a(this.ajF, i2, i6, i3, i);
        a(this.ajI, i2, i7, i3, i);
        a(this.ajG, i2, i8, i3, i);
        a(this.ajH, i2, i9, i3, i);
        a(this.ajJ, i2, i10, i3, i);
        l(this.ajQ, i);
        l(this.ajP, i);
        a(this.ajR, i, false);
        l(this.ajS, i);
        l(this.ajT, i);
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
