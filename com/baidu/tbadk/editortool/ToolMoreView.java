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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class ToolMoreView extends FrameLayout {
    private int YA;
    private TextView YB;
    private TextView YC;
    private HeadImageView YD;
    private FrameLayout YE;
    private TextView YF;
    private HeadImageView YG;
    private FrameLayout YH;
    private TextView YI;
    private TextView YJ;
    private TextView YK;
    private TextView YL;
    private TextView YM;
    private boolean YN;
    private boolean YO;
    private boolean YP;
    private LinearLayout YQ;
    private LinearLayout YR;
    private TextView YS;
    private TextView YT;
    private TextView YU;
    private TextView YV;
    private TextView YW;
    private TextView YX;
    private TextView YY;
    private boolean YZ;
    private boolean isFirst;
    private Context mContext;

    public void setHideBaobao(boolean z) {
        this.YZ = z;
        if (this.YJ != null) {
            if (this.YZ) {
                this.YJ.setVisibility(4);
            } else {
                this.YJ.setVisibility(0);
            }
        }
    }

    public ToolMoreView(Context context) {
        super(context);
        this.YA = 0;
        this.YN = false;
        this.YO = false;
        this.YP = false;
        this.isFirst = true;
        this.mContext = context;
        init();
    }

    public ToolMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YA = 0;
        this.YN = false;
        this.YO = false;
        this.YP = false;
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
        if (this.YS != null) {
            if (this.YE != null && this.YE.getVisibility() == 0) {
                int right = this.YE.getRight() - com.baidu.adp.lib.util.l.dip2px(this.mContext, 14.0f);
                int top = this.YE.getTop() - com.baidu.adp.lib.util.l.dip2px(this.mContext, 2.0f);
                this.YS.layout(right, top, this.YS.getMeasuredWidth() + right, this.YS.getMeasuredHeight() + top);
            } else {
                this.YS.layout(0, 0, 0, 0);
            }
        }
        if (this.YX != null) {
            if (this.YH != null && this.YH.getVisibility() == 0) {
                int right2 = this.YH.getRight() - com.baidu.adp.lib.util.l.dip2px(this.mContext, 14.0f);
                int top2 = this.YH.getTop() - com.baidu.adp.lib.util.l.dip2px(this.mContext, 2.0f);
                this.YX.layout(right2, top2, this.YX.getMeasuredWidth() + right2, this.YX.getMeasuredHeight() + top2);
            } else {
                this.YX.layout(0, 0, 0, 0);
            }
        }
        if (this.YT != null) {
            if (this.YB != null && this.YB.getVisibility() == 0) {
                int right3 = this.YB.getRight() - com.baidu.adp.lib.util.l.dip2px(this.mContext, 14.0f);
                int top3 = this.YB.getTop() - com.baidu.adp.lib.util.l.dip2px(this.mContext, 2.0f);
                this.YT.layout(right3, top3, this.YT.getMeasuredWidth() + right3, this.YT.getMeasuredHeight() + top3);
            } else {
                this.YT.layout(0, 0, 0, 0);
            }
        }
        if (this.YU != null) {
            if (this.YL != null && this.YL.getVisibility() == 0) {
                int right4 = this.YL.getRight() - com.baidu.adp.lib.util.l.dip2px(this.mContext, 14.0f);
                int top4 = (this.YL.getTop() + this.YR.getTop()) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 2.0f);
                this.YU.layout(right4, top4, this.YU.getMeasuredWidth() + right4, this.YU.getMeasuredHeight() + top4);
            } else {
                this.YU.layout(0, 0, 0, 0);
            }
        }
        if (this.YW != null) {
            if (this.YK != null && this.YK.getVisibility() == 0) {
                int right5 = this.YK.getRight() - com.baidu.adp.lib.util.l.dip2px(this.mContext, 14.0f);
                int top5 = this.YK.getTop() - com.baidu.adp.lib.util.l.dip2px(this.mContext, 4.0f);
                this.YW.layout(right5, top5, this.YW.getMeasuredWidth() + right5, this.YW.getMeasuredHeight() + top5);
            } else {
                this.YW.layout(0, 0, 0, 0);
            }
        }
        if (this.YV != null) {
            if (!this.YZ && this.YJ != null && this.YJ.getVisibility() == 0) {
                int right6 = this.YJ.getRight() - com.baidu.adp.lib.util.l.dip2px(this.mContext, 14.0f);
                int top6 = (this.YJ.getTop() + this.YR.getTop()) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 2.0f);
                this.YV.layout(right6, top6, this.YV.getMeasuredWidth() + right6, this.YV.getMeasuredHeight() + top6);
            } else {
                this.YV.layout(0, 0, 0, 0);
            }
        }
        if (this.YY != null) {
            if (this.YM != null && this.YM.getVisibility() == 0) {
                int right7 = this.YM.getRight() - com.baidu.adp.lib.util.l.dip2px(this.mContext, 14.0f);
                int top7 = (this.YM.getTop() + this.YR.getTop()) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 2.0f);
                this.YY.layout(right7, top7, this.YY.getMeasuredWidth() + right7, this.YY.getMeasuredHeight() + top7);
                return;
            }
            this.YY.layout(0, 0, 0, 0);
        }
    }

    public TextView aH(boolean z) {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(1, 10.0f);
        ax.b(textView, com.baidu.tieba.t.top_msg_num_day, 1);
        textView.setGravity(17);
        if (z) {
            ax.i((View) textView, com.baidu.tieba.v.icon_news_head_prompt_one);
        } else {
            ax.i((View) textView, com.baidu.tieba.v.icon_news_list_prompt);
        }
        addView(textView, new FrameLayout.LayoutParams(-2, -2));
        return textView;
    }

    public void ee(String str) {
        if (this.YE.getVisibility() == 0) {
            if (this.YS == null) {
                this.YS = aH(true);
            }
            this.YS.setVisibility(0);
            this.YS.setText(str);
        }
    }

    public void vg() {
        if (this.YS != null) {
            this.YS.setVisibility(8);
        }
    }

    public void ef(String str) {
        if (this.YT == null) {
            this.YT = aH(true);
        }
        this.YT.setVisibility(0);
        this.YT.setText(str);
    }

    public void vh() {
        if (this.YT != null) {
            this.YT.setVisibility(8);
        }
    }

    public void vi() {
        if (this.YL.getVisibility() == 0) {
            if (this.YU == null) {
                this.YU = aH(false);
            }
            this.YU.setVisibility(0);
        }
    }

    public void vj() {
        if (this.YU != null) {
            this.YU.setVisibility(8);
        }
    }

    public boolean vk() {
        return this.YY != null && this.YY.getVisibility() == 0 && this.YM != null && this.YM.getVisibility() == 0;
    }

    public void vl() {
        if (this.YM.getVisibility() == 0) {
            if (this.YY == null) {
                this.YY = aH(false);
            }
            this.YY.setVisibility(0);
        }
    }

    public void vm() {
        if (this.YY != null) {
            this.YY.setVisibility(8);
        }
    }

    public void eg(String str) {
        if (this.YJ.getVisibility() == 0) {
            if (this.YV == null) {
                this.YV = aH(true);
            }
            this.YV.setVisibility(0);
            this.YV.setText(str);
        }
    }

    public void vn() {
        if (this.YV != null) {
            this.YV.setVisibility(8);
        }
    }

    public void vo() {
        if (this.YK.getVisibility() == 0) {
            if (this.YW == null) {
                this.YW = aH(false);
            }
            this.YW.setVisibility(0);
        }
    }

    public void vp() {
        if (this.YW != null) {
            this.YW.setVisibility(8);
        }
    }

    private void init() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.x.editor_tool_more, this, true);
        this.YQ = (LinearLayout) findViewById(com.baidu.tieba.w.lay_editor_more_line1);
        this.YR = (LinearLayout) findViewById(com.baidu.tieba.w.lay_editor_more_line2);
        this.YB = (TextView) findViewById(com.baidu.tieba.w.btn_tool_expression);
        this.YC = (TextView) findViewById(com.baidu.tieba.w.btn_tool_image);
        this.YD = (HeadImageView) findViewById(com.baidu.tieba.w.iv_tool_image);
        this.YD.setDrawBorder(false);
        this.YE = (FrameLayout) findViewById(com.baidu.tieba.w.lay_tool_image);
        this.YF = (TextView) findViewById(com.baidu.tieba.w.btn_tool_camera);
        this.YG = (HeadImageView) findViewById(com.baidu.tieba.w.iv_tool_camera);
        this.YG.setDrawBorder(false);
        this.YH = (FrameLayout) findViewById(com.baidu.tieba.w.lay_tool_camera);
        this.YI = (TextView) findViewById(com.baidu.tieba.w.btn_tool_at);
        this.YL = (TextView) findViewById(com.baidu.tieba.w.btn_tool_privilege);
        this.YJ = (TextView) findViewById(com.baidu.tieba.w.btn_tool_baobao);
        this.YK = (TextView) findViewById(com.baidu.tieba.w.btn_tool_record);
        this.YK.setVisibility(4);
        this.YM = (TextView) findViewById(com.baidu.tieba.w.btn_tool_location);
        if (!TbadkCoreApplication.m255getInst().isBaobaoShouldOpen() || this.YZ) {
            this.YJ.setVisibility(4);
            this.YJ.setEnabled(false);
        }
        if (TbadkCoreApplication.m255getInst().isFaceShopNew()) {
            ef("N");
        } else {
            vh();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.YB.setOnClickListener(onClickListener);
        this.YC.setOnClickListener(onClickListener);
        this.YF.setOnClickListener(onClickListener);
        this.YD.setOnClickListener(onClickListener);
        this.YG.setOnClickListener(onClickListener);
        this.YI.setOnClickListener(onClickListener);
        this.YL.setOnClickListener(onClickListener);
        this.YJ.setOnClickListener(onClickListener);
        this.YK.setOnClickListener(onClickListener);
        this.YM.setOnClickListener(onClickListener);
    }

    public void setImage(Bitmap bitmap) {
        if (this.YA == 1) {
            if (this.YN) {
                setImageToImage(null);
            }
            setImageToCamera(bitmap);
        } else if (this.YA == 2) {
            if (this.YO) {
                setImageToCamera(null);
            }
            setImageToImage(bitmap);
        } else if (this.YA == 0) {
            if (this.YN) {
                setImageToImage(null);
            }
            if (this.YO) {
                setImageToCamera(null);
            }
        }
    }

    private void setImageToImage(Bitmap bitmap) {
        if (bitmap != null) {
            this.YD.setImageBitmap(bitmap);
            this.YD.setVisibility(0);
            this.YC.setVisibility(4);
            this.YN = true;
            return;
        }
        this.YN = false;
        this.YD.setImageDrawable(null);
        this.YD.setVisibility(4);
        this.YC.setVisibility(0);
    }

    private void setImageToCamera(Bitmap bitmap) {
        if (bitmap != null) {
            this.YG.setImageBitmap(bitmap);
            this.YG.setVisibility(0);
            this.YF.setVisibility(4);
            this.YO = true;
            return;
        }
        this.YO = false;
        this.YG.setImageDrawable(null);
        this.YG.setVisibility(4);
        this.YF.setVisibility(0);
    }

    public TextView getmFace() {
        return this.YB;
    }

    public TextView getmImage() {
        return this.YC;
    }

    public TextView getmCamera() {
        return this.YF;
    }

    public View getmIVImage() {
        return this.YD;
    }

    public View getmIVCamera() {
        return this.YG;
    }

    public TextView getmAt() {
        return this.YI;
    }

    public TextView getmPrivilege() {
        return this.YL;
    }

    public TextView getBaobao() {
        return this.YJ;
    }

    public TextView getLocation() {
        return this.YM;
    }

    public void setmImagetype(int i) {
        this.YA = i;
    }

    public void aI(boolean z) {
        if (this.isFirst) {
            this.YQ.removeView(this.YE);
            this.YQ.removeView(this.YH);
            this.YR.removeView(this.YL);
            this.YR.removeView(this.YJ);
            this.YQ.addView(this.YE);
            this.YQ.addView(this.YH);
            if (TbadkCoreApplication.m255getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
                this.YR.addView(this.YL, 0);
                this.YR.addView(this.YJ, 1);
                this.YR.removeView(this.YK);
                this.YR.addView(this.YK);
            } else {
                this.YR.addView(this.YJ, 0);
                this.YR.removeView(this.YK);
                this.YR.addView(this.YK);
                this.YR.addView(this.YL);
            }
        }
        this.isFirst = false;
        if (z) {
            this.YE.setVisibility(4);
            this.YH.setVisibility(4);
            this.YL.setVisibility(4);
            this.YM.setVisibility(4);
            if (TbadkCoreApplication.m255getInst().isBaobaoShouldOpen() && !this.YZ) {
                this.YJ.setVisibility(4);
                this.YJ.setEnabled(false);
                return;
            }
            return;
        }
        this.YE.setVisibility(0);
        this.YH.setVisibility(0);
        this.YL.setVisibility(0);
        this.YM.setVisibility(0);
        if (TbadkCoreApplication.m255getInst().isBaobaoShouldOpen() && !this.YZ) {
            this.YJ.setEnabled(true);
            this.YJ.setVisibility(0);
        }
        if (this.YZ) {
            this.YR.removeView(this.YJ);
            this.YR.addView(this.YJ);
        }
        if (TbadkCoreApplication.m255getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.YL.setEnabled(false);
            this.YL.setVisibility(4);
        }
    }

    public void vq() {
        this.YI.setVisibility(4);
        this.YL.setVisibility(4);
        this.YJ.setVisibility(4);
        this.YM.setVisibility(4);
        vn();
        this.YJ.setEnabled(false);
    }

    public void vr() {
        this.YQ.removeView(this.YB);
        this.YQ.removeView(this.YI);
        this.YR.removeView(this.YK);
        this.YQ.removeView(this.YH);
        this.YQ.addView(this.YK);
        this.YQ.addView(this.YB);
        this.YR.addView(this.YI);
        this.YQ.addView(this.YH);
        this.YH.setVisibility(4);
        this.YK.setVisibility(0);
        this.YB.setVisibility(4);
        this.YI.setVisibility(4);
        this.YL.setVisibility(4);
        this.YJ.setVisibility(4);
        this.YM.setVisibility(4);
        vn();
        this.YJ.setEnabled(false);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (TbadkCoreApplication.m255getInst().isFaceShopNew()) {
            ef("N");
        } else {
            vh();
        }
    }

    public View getFaceButton() {
        return this.YB;
    }

    public View getImageButton() {
        return this.YC;
    }

    public View getCameraButton() {
        return this.YF;
    }

    public View getRecordButton() {
        return this.YK;
    }

    public void onChangeSkinType(int i) {
        int i2 = com.baidu.tieba.v.selector_editor_more_btn;
        int i3 = com.baidu.tieba.t.editor_more_btn_text;
        int i4 = com.baidu.tieba.v.btn_pb_add_pic;
        int i5 = com.baidu.tieba.v.btn_pb_add_expression;
        int i6 = com.baidu.tieba.v.btn_pb_add_camera;
        int i7 = com.baidu.tieba.v.btn_pb_add_add;
        int i8 = com.baidu.tieba.v.btn_pb_add_crown;
        int i9 = com.baidu.tieba.v.btn_pb_add_baobao;
        int i10 = com.baidu.tieba.v.btn_pb_add_microphone;
        int i11 = com.baidu.tieba.v.btn_pb_add_pin;
        a(this.YB, i2, i5, i3, i);
        a(this.YC, i2, i4, i3, i);
        a(this.YF, i2, i6, i3, i);
        a(this.YI, i2, i7, i3, i);
        a(this.YL, i2, i8, i3, i);
        a(this.YJ, i2, i9, i3, i);
        a(this.YK, i2, i10, i3, i);
        a(this.YM, i2, i11, i3, i);
        l(this.YT, i);
        l(this.YS, i);
        l(this.YU, i);
        l(this.YV, i);
        l(this.YW, i);
    }

    private void l(TextView textView, int i) {
        if (textView != null) {
            if (i == 1) {
                ax.b(textView, com.baidu.tieba.t.top_msg_num_day, 1);
                ax.i((View) textView, com.baidu.tieba.v.icon_news_head_prompt_one);
                return;
            }
            textView.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.top_msg_num_day));
            textView.setBackgroundResource(com.baidu.tieba.v.icon_news_head_prompt_one);
        }
    }

    private void a(TextView textView, int i, int i2, int i3, int i4) {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.editor_more_btns_paddingtop);
        if (i4 == 1) {
            ax.i((View) textView, i);
            textView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ax.getDrawable(i2), (Drawable) null, (Drawable) null);
            ax.b(textView, i3, 1);
            return;
        }
        textView.setBackgroundResource(i);
        textView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null, (Drawable) null);
        textView.setTextColor(this.mContext.getResources().getColor(i3));
    }
}
