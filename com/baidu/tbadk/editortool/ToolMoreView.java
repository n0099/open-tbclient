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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class ToolMoreView extends FrameLayout {
    private int akH;
    private TextView akI;
    private TextView akJ;
    private HeadImageView akK;
    private FrameLayout akL;
    private TextView akM;
    private TextView akN;
    private TextView akO;
    private TextView akP;
    private TextView akQ;
    private TextView akR;
    private boolean akS;
    private boolean akT;
    private boolean akU;
    private boolean akV;
    private LinearLayout akW;
    private LinearLayout akX;
    private TextView akY;
    private TextView akZ;
    private TextView ala;
    private TextView alb;
    private TextView alc;
    private TextView ald;
    private boolean ale;
    private Context mContext;

    public void setHideBaobao(boolean z) {
        this.ale = z;
        if (this.akN != null) {
            if (this.ale) {
                this.akN.setVisibility(4);
            } else {
                this.akN.setVisibility(0);
            }
        }
    }

    public ToolMoreView(Context context) {
        super(context);
        this.akH = 0;
        this.akS = false;
        this.akT = false;
        this.akU = false;
        this.akV = true;
        this.mContext = context;
        init();
    }

    public ToolMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akH = 0;
        this.akS = false;
        this.akT = false;
        this.akU = false;
        this.akV = true;
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
        if (this.akY != null) {
            if (this.akL != null && this.akL.getVisibility() == 0) {
                int right = this.akL.getRight() - (this.akY.getMeasuredWidth() / 2);
                int top = this.akL.getTop() - (this.akY.getMeasuredHeight() / 2);
                this.akY.layout(right, top, this.akY.getMeasuredWidth() + right, this.akY.getMeasuredHeight() + top);
            } else {
                this.akY.layout(0, 0, 0, 0);
            }
        }
        if (this.akZ != null) {
            if (this.akI != null && this.akI.getVisibility() == 0) {
                int right2 = this.akI.getRight() - (this.akZ.getMeasuredWidth() / 2);
                int top2 = this.akI.getTop() - (this.akZ.getMeasuredHeight() / 2);
                this.akZ.layout(right2, top2, this.akZ.getMeasuredWidth() + right2, this.akZ.getMeasuredHeight() + top2);
            } else {
                this.akZ.layout(0, 0, 0, 0);
            }
        }
        if (this.ala != null) {
            if (this.akP != null && this.akP.getVisibility() == 0) {
                int right3 = this.akP.getRight() - (this.ala.getMeasuredWidth() / 2);
                int top3 = (this.akP.getTop() + this.akX.getTop()) - (this.ala.getMeasuredHeight() / 2);
                this.ala.layout(right3, top3, this.ala.getMeasuredWidth() + right3, this.ala.getMeasuredHeight() + top3);
            } else {
                this.ala.layout(0, 0, 0, 0);
            }
        }
        if (this.alc != null) {
            if (this.akO != null && this.akO.getVisibility() == 0) {
                int right4 = this.akO.getRight() - (this.alc.getMeasuredWidth() / 2);
                int top4 = this.akO.getTop() - (this.alc.getMeasuredHeight() / 2);
                this.alc.layout(right4, top4, this.alc.getMeasuredWidth() + right4, this.alc.getMeasuredHeight() + top4);
            } else {
                this.alc.layout(0, 0, 0, 0);
            }
        }
        if (this.alb != null) {
            if (!this.ale && this.akN != null && this.akN.getVisibility() == 0) {
                int right5 = this.akN.getRight() - (this.alb.getMeasuredWidth() / 2);
                int top5 = (this.akN.getTop() + this.akX.getTop()) - (this.alb.getMeasuredHeight() / 2);
                this.alb.layout(right5, top5, this.alb.getMeasuredWidth() + right5, this.alb.getMeasuredHeight() + top5);
            } else {
                this.alb.layout(0, 0, 0, 0);
            }
        }
        if (this.ald != null) {
            if (this.akQ != null && this.akQ.getVisibility() == 0) {
                int right6 = this.akQ.getRight() - (this.ald.getMeasuredWidth() / 2);
                int top6 = this.akQ.getTop() - (this.ald.getMeasuredHeight() / 2);
                this.ald.layout(right6, top6, this.ald.getMeasuredWidth() + right6, this.ald.getMeasuredHeight() + top6);
                return;
            }
            this.ald.layout(0, 0, 0, 0);
        }
    }

    public TextView aW(boolean z) {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(1, 10.0f);
        ay.b(textView, com.baidu.tieba.n.top_msg_num_day, 1);
        textView.setGravity(17);
        if (z) {
            ay.i((View) textView, com.baidu.tieba.p.icon_news_head_prompt_one);
        } else {
            ay.i((View) textView, com.baidu.tieba.p.icon_news_list_prompt);
        }
        addView(textView, new FrameLayout.LayoutParams(-2, -2));
        return textView;
    }

    public void eC(String str) {
        if (this.akL.getVisibility() == 0) {
            if (this.akY == null) {
                this.akY = aW(true);
            }
            this.akY.setVisibility(0);
            this.akY.setText(str);
        }
    }

    public void zJ() {
        if (this.akY != null) {
            this.akY.setVisibility(8);
        }
    }

    public void eD(String str) {
        if (this.akI != null && this.akI.getVisibility() == 0) {
            if (this.akZ == null) {
                this.akZ = aW(true);
            }
            this.akZ.setVisibility(0);
            this.akZ.setText(str);
        }
    }

    public void zK() {
        if (this.akZ != null) {
            this.akZ.setVisibility(8);
        }
    }

    public void zL() {
        if (this.akP.getVisibility() == 0) {
            if (this.ala == null) {
                this.ala = aW(false);
            }
            this.ala.setVisibility(0);
        }
    }

    public void zM() {
        if (this.ala != null) {
            this.ala.setVisibility(8);
        }
    }

    public boolean zN() {
        return this.ald != null && this.ald.getVisibility() == 0 && this.akQ != null && this.akQ.getVisibility() == 0;
    }

    public void zO() {
        if (this.akQ.getVisibility() == 0) {
            if (this.ald == null) {
                this.ald = aW(false);
            }
            this.ald.setVisibility(0);
        }
    }

    public void zP() {
        if (this.ald != null) {
            this.ald.setVisibility(8);
        }
    }

    public void eE(String str) {
        if (this.akN.getVisibility() == 0) {
            if (this.alb == null) {
                this.alb = aW(true);
            }
            this.alb.setVisibility(0);
            this.alb.setText(str);
        }
    }

    public void zQ() {
        if (this.alb != null) {
            this.alb.setVisibility(8);
        }
    }

    public void zR() {
        if (this.akO.getVisibility() == 0) {
            if (this.alc == null) {
                this.alc = aW(false);
            }
            this.alc.setVisibility(0);
        }
    }

    public void zS() {
        if (this.alc != null) {
            this.alc.setVisibility(8);
        }
    }

    private void init() {
        com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.editor_tool_more, this, true);
        this.akW = (LinearLayout) findViewById(com.baidu.tieba.q.lay_editor_more_line1);
        this.akX = (LinearLayout) findViewById(com.baidu.tieba.q.lay_editor_more_line2);
        this.akI = (TextView) findViewById(com.baidu.tieba.q.btn_tool_expression);
        this.akJ = (TextView) findViewById(com.baidu.tieba.q.btn_tool_image);
        this.akK = (HeadImageView) findViewById(com.baidu.tieba.q.iv_tool_image);
        this.akK.setDrawBorder(false);
        this.akL = (FrameLayout) findViewById(com.baidu.tieba.q.lay_tool_image);
        this.akM = (TextView) findViewById(com.baidu.tieba.q.btn_tool_at);
        this.akP = (TextView) findViewById(com.baidu.tieba.q.btn_tool_privilege);
        this.akN = (TextView) findViewById(com.baidu.tieba.q.btn_tool_baobao);
        this.akO = (TextView) findViewById(com.baidu.tieba.q.btn_tool_record);
        this.akO.setVisibility(4);
        this.akQ = (TextView) findViewById(com.baidu.tieba.q.btn_tool_location);
        this.akR = (TextView) findViewById(com.baidu.tieba.q.temp_text);
        if (!TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() || this.ale) {
            this.akN.setVisibility(4);
            this.akN.setEnabled(false);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.akI.setOnClickListener(onClickListener);
        this.akJ.setOnClickListener(onClickListener);
        this.akK.setOnClickListener(onClickListener);
        this.akM.setOnClickListener(onClickListener);
        this.akP.setOnClickListener(onClickListener);
        this.akN.setOnClickListener(onClickListener);
        this.akO.setOnClickListener(onClickListener);
        this.akQ.setOnClickListener(onClickListener);
    }

    public boolean getHasAudio() {
        return this.akV;
    }

    public void setHasAudio(boolean z) {
        this.akV = z;
    }

    public void setImage(Bitmap bitmap) {
        if (this.akH == 1) {
            if (this.akS) {
                setImageToImage(null);
            }
            setImageToCamera(bitmap);
        } else if (this.akH == 2) {
            if (this.akT) {
                setImageToCamera(null);
            }
            setImageToImage(bitmap);
        } else if (this.akH == 0) {
            if (this.akS) {
                setImageToImage(null);
            }
            if (this.akT) {
                setImageToCamera(null);
            }
        }
    }

    private void setImageToImage(Bitmap bitmap) {
        if (bitmap != null) {
            this.akK.setImageBitmap(bitmap);
            this.akK.setVisibility(0);
            this.akJ.setVisibility(4);
            this.akS = true;
            return;
        }
        this.akS = false;
        this.akK.setImageDrawable(null);
        this.akK.setVisibility(4);
        this.akJ.setVisibility(0);
    }

    private void setImageToCamera(Bitmap bitmap) {
        if (bitmap != null) {
            this.akT = true;
        } else {
            this.akT = false;
        }
    }

    public TextView getmFace() {
        return this.akI;
    }

    public TextView getmImage() {
        return this.akJ;
    }

    public View getmIVImage() {
        return this.akK;
    }

    public TextView getmAt() {
        return this.akM;
    }

    public TextView getmPrivilege() {
        return this.akP;
    }

    public TextView getBaobao() {
        return this.akN;
    }

    public TextView getLocation() {
        return this.akQ;
    }

    public void setmImagetype(int i) {
        this.akH = i;
    }

    public void aX(boolean z) {
        if (z) {
            this.akW.removeAllViews();
            this.akX.removeAllViews();
            this.akW.addView(this.akO);
            this.akW.addView(this.akM);
            this.akW.addView(this.akQ);
            this.akW.addView(this.akL);
            this.akO.setVisibility(0);
            this.akM.setVisibility(0);
            this.akQ.setVisibility(4);
            this.akL.setVisibility(4);
            zJ();
            this.akX.addView(this.akP);
            this.akX.addView(this.akN);
            this.akX.addView(this.akI);
            this.akX.addView(this.akR);
            this.akP.setVisibility(4);
            this.akI.setVisibility(4);
            zK();
            this.akR.setVisibility(4);
            this.akN.setVisibility(4);
            return;
        }
        this.akW.removeAllViews();
        this.akX.removeAllViews();
        this.akW.addView(this.akL);
        this.akW.addView(this.akO);
        this.akW.addView(this.akM);
        this.akW.addView(this.akQ);
        this.akL.setVisibility(0);
        this.akO.setVisibility(0);
        this.akM.setVisibility(0);
        this.akQ.setVisibility(0);
        this.akX.addView(this.akP);
        this.akX.addView(this.akN);
        this.akX.addView(this.akI);
        this.akX.addView(this.akR);
        this.akI.setVisibility(4);
        zK();
        this.akR.setVisibility(4);
        if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && !this.ale) {
            this.akN.setEnabled(true);
            this.akN.setVisibility(0);
        } else {
            this.akN.setVisibility(4);
            zQ();
        }
        if (TbadkCoreApplication.m411getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.akP.setEnabled(false);
            this.akP.setVisibility(4);
            zM();
            return;
        }
        this.akP.setEnabled(true);
        this.akP.setVisibility(0);
    }

    public void zT() {
        this.akM.setVisibility(4);
        this.akP.setVisibility(4);
        zM();
        this.akN.setVisibility(4);
        zQ();
        this.akN.setEnabled(false);
        this.akQ.setVisibility(4);
        zP();
    }

    public void zU() {
        this.akW.setVisibility(8);
        this.akI.setVisibility(4);
        zK();
        this.akM.setVisibility(4);
        if (this.akX != null) {
            if (this.akP != null) {
                this.akX.removeView(this.akP);
                this.akX.addView(this.akP);
                this.akP.setVisibility(4);
            }
            if (this.akO != null) {
                this.akX.removeView(this.akO);
                this.akX.addView(this.akO, 0);
                this.akO.setVisibility(0);
            }
        }
        this.akN.setVisibility(0);
        this.akQ.setVisibility(4);
        this.akN.setEnabled(true);
        this.akL.setVisibility(4);
        zQ();
    }

    public void zV() {
        this.akW.setVisibility(8);
        this.akI.setVisibility(4);
        zK();
        this.akM.setVisibility(4);
        if (this.akX != null) {
            if (this.akP != null) {
                this.akX.removeView(this.akP);
                this.akX.addView(this.akP);
                this.akP.setVisibility(4);
            }
            if (this.akO != null) {
                this.akX.removeView(this.akO);
                this.akX.addView(this.akO);
            }
        }
        this.akN.setVisibility(0);
        this.akQ.setVisibility(4);
        this.akN.setEnabled(true);
        this.akL.setVisibility(4);
        zJ();
        zQ();
        zS();
    }

    public void zW() {
        this.akW.setVisibility(8);
        this.akI.setVisibility(4);
        this.akM.setVisibility(4);
        if (this.akX != null && this.akP != null) {
            this.akX.removeView(this.akP);
            this.akX.addView(this.akP);
            this.akP.setVisibility(4);
        }
        this.akO.setVisibility(4);
        this.akN.setVisibility(0);
        this.akQ.setVisibility(4);
        this.akN.setEnabled(true);
        this.akL.setVisibility(4);
        zQ();
        zK();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (TbadkCoreApplication.m411getInst().isFaceShopNew()) {
            eD("N");
        } else {
            zK();
        }
    }

    public View getFaceButton() {
        return this.akI;
    }

    public View getImageButton() {
        return this.akJ;
    }

    public View getRecordButton() {
        return this.akO;
    }

    public void onChangeSkinType(int i) {
        int i2 = com.baidu.tieba.p.selector_editor_more_btn;
        int i3 = com.baidu.tieba.n.cp_cont_c;
        int i4 = com.baidu.tieba.p.btn_pb_add_pic;
        int i5 = com.baidu.tieba.p.btn_pb_add_expression;
        int i6 = com.baidu.tieba.p.btn_pb_add_add;
        int i7 = com.baidu.tieba.p.btn_pb_add_pao;
        int i8 = com.baidu.tieba.p.btn_pb_add_baobao;
        int i9 = com.baidu.tieba.p.btn_pb_add_microphone;
        int i10 = com.baidu.tieba.p.btn_pb_add_pin;
        a(this.akI, i2, i5, i3, i);
        a(this.akJ, i2, i4, i3, i);
        a(this.akM, i2, i6, i3, i);
        a(this.akP, i2, i7, i3, i);
        a(this.akN, i2, i8, i3, i);
        a(this.akO, i2, i9, i3, i);
        a(this.akQ, i2, i10, i3, i);
        l(this.akZ, i);
        l(this.akY, i);
        a(this.ala, i, false);
        l(this.alb, i);
        l(this.alc, i);
    }

    private void l(TextView textView, int i) {
        a(textView, i, true);
    }

    private void a(TextView textView, int i, boolean z) {
        if (textView != null) {
            if (i == 1) {
                ay.b(textView, com.baidu.tieba.n.cp_cont_i, 1);
                if (z) {
                    ay.i((View) textView, com.baidu.tieba.p.icon_news_head_prompt_one);
                    return;
                } else {
                    ay.i((View) textView, com.baidu.tieba.p.icon_news_list_prompt);
                    return;
                }
            }
            textView.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.n.cp_cont_i));
            if (z) {
                textView.setBackgroundResource(com.baidu.tieba.p.icon_news_head_prompt_one);
            } else {
                textView.setBackgroundResource(com.baidu.tieba.p.icon_news_list_prompt);
            }
        }
    }

    private void a(TextView textView, int i, int i2, int i3, int i4) {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.editor_more_btns_paddingtop);
        if (i4 == 1) {
            ay.i((View) textView, i);
            textView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            textView.setCompoundDrawablePadding(0);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ay.getDrawable(i2), (Drawable) null, (Drawable) null);
            ay.b(textView, i3, 1);
            return;
        }
        textView.setBackgroundResource(i);
        textView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        textView.setCompoundDrawablePadding(0);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null, (Drawable) null);
        textView.setTextColor(this.mContext.getResources().getColor(i3));
    }
}
