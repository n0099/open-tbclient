package com.baidu.tieba.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class TbEditorToolButtonContainer extends l {
    protected TextView SN;
    protected TextView SP;
    protected TextView SQ;
    protected EditorToolButton arP;
    protected EditorToolButton arQ;
    protected EditorToolButton arR;
    protected EditorToolButton arS;
    protected EditorToolButton arT;
    protected TextView arU;
    protected Context mContext;

    public TbEditorToolButtonContainer(Context context) {
        super(context);
        this.mContext = context;
        ny();
    }

    public TbEditorToolButtonContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        ny();
    }

    public TbEditorToolButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        ny();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.arR != null && this.arR.getTip() != null) {
            int intrinsicWidth = this.arR.getDrawable().getIntrinsicWidth();
            int intrinsicHeight = this.arR.getDrawable().getIntrinsicHeight();
            TextView tip = this.arR.getTip();
            int right = (this.arR.getRight() - ((this.arR.getMeasuredWidth() - intrinsicWidth) / 2)) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 7.0f);
            int measuredHeight = (((this.arR.getMeasuredHeight() - intrinsicHeight) / 2) + this.arR.getTop()) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 0.0f);
            tip.layout(right, measuredHeight, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + measuredHeight);
        }
        if (this.arS != null && this.arS.getTip() != null) {
            int intrinsicWidth2 = this.arS.getDrawable().getIntrinsicWidth();
            int intrinsicHeight2 = this.arS.getDrawable().getIntrinsicHeight();
            TextView tip2 = this.arS.getTip();
            int right2 = (this.arS.getRight() - ((this.arS.getMeasuredWidth() - intrinsicWidth2) / 2)) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 9.0f);
            int measuredHeight2 = (((this.arS.getMeasuredHeight() - intrinsicHeight2) / 2) + this.arS.getTop()) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 4.0f);
            tip2.layout(right2, measuredHeight2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + measuredHeight2);
        }
        if (this.arT != null && this.arT.getTip() != null) {
            int intrinsicWidth3 = this.arT.getDrawable().getIntrinsicWidth();
            int intrinsicHeight3 = this.arT.getDrawable().getIntrinsicHeight();
            int measuredWidth = (this.arT.getMeasuredWidth() - intrinsicWidth3) / 2;
            int measuredHeight3 = (this.arT.getMeasuredHeight() - intrinsicHeight3) / 2;
            TextView tip3 = this.arT.getTip();
            if (TextUtils.isEmpty(tip3.getText())) {
                int right3 = (this.arT.getRight() - measuredWidth) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 7.0f);
                int top = (measuredHeight3 + this.arT.getTop()) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 0.0f);
                tip3.layout(right3, top, tip3.getMeasuredWidth() + right3, tip3.getMeasuredHeight() + top);
                return;
            }
            int right4 = (this.arT.getRight() - measuredWidth) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 7.0f);
            int top2 = (measuredHeight3 + this.arT.getTop()) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 7.0f);
            tip3.layout(right4, top2, tip3.getMeasuredWidth() + right4, tip3.getMeasuredHeight() + top2);
        }
    }

    protected void ny() {
        Ck();
        this.arP = (EditorToolButton) findViewById(com.baidu.tieba.v.select_face);
        this.arQ = (EditorToolButton) findViewById(com.baidu.tieba.v.select_at);
        this.arR = (EditorToolButton) findViewById(com.baidu.tieba.v.select_privilege);
        this.arS = (EditorToolButton) findViewById(com.baidu.tieba.v.select_baobao);
        this.arT = (EditorToolButton) findViewById(com.baidu.tieba.v.select_mediacontent);
    }

    protected void Ck() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.write_editor_tool_button_container, this, true);
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            View.OnClickListener a = a(wVar);
            this.arP.setOnClickListener(a);
            this.arQ.setOnClickListener(a);
            this.arR.setOnClickListener(a);
            this.arS.setOnClickListener(a);
            this.arT.setOnClickListener(a);
        }
    }

    public void Cz() {
        Bg();
        this.arP.Bc();
    }

    public void CA() {
        Bg();
        this.arR.Bc();
    }

    public void CB() {
        this.arS.Bd();
    }

    public void CC() {
        Bg();
        this.arS.Bc();
    }

    public void CD() {
        Bg();
        this.arT.Bc();
    }

    public void CE() {
        this.arT.Bd();
    }

    public void setFaceFocusable(boolean z) {
        this.arP.setFocusable(z);
    }

    public void setAtFocusable(boolean z) {
        this.arQ.setFocusable(z);
    }

    public void setPrivilegeFocusable(boolean z) {
        this.arR.setFocusable(z);
    }

    public void setBaobaoFocusable(boolean z) {
        this.arS.setFocusable(z);
    }

    public void setFaceEnabled(boolean z) {
        this.arP.setEnabled(z);
    }

    public void setAtEnabled(boolean z) {
        this.arQ.setEnabled(z);
    }

    public void setBaobaoEnabled(boolean z) {
        this.arS.setEnabled(z);
    }

    public void setPrivilegeEnable(boolean z) {
        this.arR.setEnabled(z);
    }

    public void setBaobaoEnable(boolean z) {
        this.arS.setEnabled(z);
    }

    public void di(String str) {
        if (this.arU == null) {
            this.arU = a(this.arT, true);
        } else {
            b(this.arT, true);
        }
        this.arT.eG(str);
    }

    public void CF() {
        if (this.arS != null) {
            this.arS.setVisibility(8);
        }
    }

    public void rD() {
        if (this.arU != null) {
            b(this.arT, true);
            this.arT.qk();
        }
    }

    public void Cl() {
        if (this.arU == null) {
            this.arU = a(this.arT, false);
        } else {
            b(this.arT, false);
        }
        this.arT.qj();
    }

    public void Cm() {
        if (this.arU != null) {
            b(this.arT, false);
            this.arT.qk();
        }
    }

    public void rF() {
        if (this.SP == null) {
            this.SP = a(this.arR, false);
        }
        this.arR.qj();
    }

    public void rG() {
        this.arR.qk();
    }

    public void dk(String str) {
        if (this.SQ == null) {
            this.SQ = a(this.arS, true);
        }
        this.arS.eG(str);
    }

    public void rK() {
        this.arS.qk();
    }

    public void bB(boolean z) {
        if (z) {
            this.arR.Ba();
        } else {
            this.arR.hide();
        }
    }

    public void changeSkinType(int i) {
        if (this.SN != null) {
            com.baidu.tbadk.core.util.aw.h((View) this.SN, com.baidu.tieba.u.icon_news_head_prompt_one);
        }
        if (this.SP != null) {
            com.baidu.tbadk.core.util.aw.h((View) this.SP, com.baidu.tieba.u.icon_news_down_bar_one);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, com.baidu.tbadk.editortool.w wVar) {
        if (editorToolButton == this.arP) {
            wVar.handleAction(1, null);
        } else if (editorToolButton == this.arQ) {
            wVar.handleAction(0, null);
        } else if (editorToolButton == this.arR) {
            wVar.handleAction(43, null);
        } else if (editorToolButton == this.arS) {
            wVar.handleAction(48, null);
        } else if (editorToolButton == this.arT) {
            wVar.handleAction(37, null);
        }
        if (editorToolButton.Bb()) {
            if (editorToolButton.isFocused()) {
                Bg();
                if (editorToolButton == this.arP) {
                    wVar.handleAction(3, null);
                } else if (editorToolButton == this.arQ) {
                    wVar.handleAction(16, null);
                } else if (editorToolButton == this.arR) {
                    wVar.handleAction(45, null);
                } else if (editorToolButton == this.arS) {
                    wVar.handleAction(49, null);
                } else if (editorToolButton == this.arT) {
                    wVar.handleAction(39, null);
                }
            } else if (editorToolButton == this.arP) {
                wVar.handleAction(2, null);
            } else if (editorToolButton == this.arQ) {
                wVar.handleAction(17, null);
                wVar.handleAction(5, null);
            } else if (editorToolButton == this.arR) {
                wVar.handleAction(44, null);
            } else if (editorToolButton == this.arS) {
                wVar.handleAction(50, null);
            } else if (editorToolButton == this.arT) {
                wVar.handleAction(38, null);
            }
        }
    }

    protected View.OnClickListener a(com.baidu.tbadk.editortool.w wVar) {
        return new aw(this, wVar);
    }

    public void refresh() {
        if (TextUtils.isEmpty(TbadkApplication.m251getInst().getDefaultBubble())) {
            rG();
        } else {
            rF();
        }
    }
}
