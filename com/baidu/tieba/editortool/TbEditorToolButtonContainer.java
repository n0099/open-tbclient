package com.baidu.tieba.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class TbEditorToolButtonContainer extends l {
    protected TextView SR;
    protected TextView ST;
    protected TextView SU;
    protected EditorToolButton arY;
    protected EditorToolButton arZ;
    protected EditorToolButton asa;
    protected EditorToolButton asb;
    protected EditorToolButton asc;
    protected TextView asd;
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
        if (this.asa != null && this.asa.getTip() != null) {
            int intrinsicWidth = this.asa.getDrawable().getIntrinsicWidth();
            int intrinsicHeight = this.asa.getDrawable().getIntrinsicHeight();
            TextView tip = this.asa.getTip();
            int right = (this.asa.getRight() - ((this.asa.getMeasuredWidth() - intrinsicWidth) / 2)) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 7.0f);
            int measuredHeight = (((this.asa.getMeasuredHeight() - intrinsicHeight) / 2) + this.asa.getTop()) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 0.0f);
            tip.layout(right, measuredHeight, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + measuredHeight);
        }
        if (this.asb != null && this.asb.getTip() != null) {
            int intrinsicWidth2 = this.asb.getDrawable().getIntrinsicWidth();
            int intrinsicHeight2 = this.asb.getDrawable().getIntrinsicHeight();
            TextView tip2 = this.asb.getTip();
            int right2 = (this.asb.getRight() - ((this.asb.getMeasuredWidth() - intrinsicWidth2) / 2)) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 9.0f);
            int measuredHeight2 = (((this.asb.getMeasuredHeight() - intrinsicHeight2) / 2) + this.asb.getTop()) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 4.0f);
            tip2.layout(right2, measuredHeight2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + measuredHeight2);
        }
        if (this.asc != null && this.asc.getTip() != null) {
            int intrinsicWidth3 = this.asc.getDrawable().getIntrinsicWidth();
            int intrinsicHeight3 = this.asc.getDrawable().getIntrinsicHeight();
            int measuredWidth = (this.asc.getMeasuredWidth() - intrinsicWidth3) / 2;
            int measuredHeight3 = (this.asc.getMeasuredHeight() - intrinsicHeight3) / 2;
            TextView tip3 = this.asc.getTip();
            if (TextUtils.isEmpty(tip3.getText())) {
                int right3 = (this.asc.getRight() - measuredWidth) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 7.0f);
                int top = (measuredHeight3 + this.asc.getTop()) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 0.0f);
                tip3.layout(right3, top, tip3.getMeasuredWidth() + right3, tip3.getMeasuredHeight() + top);
                return;
            }
            int right4 = (this.asc.getRight() - measuredWidth) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 7.0f);
            int top2 = (measuredHeight3 + this.asc.getTop()) - com.baidu.adp.lib.util.m.dip2px(this.mContext, 7.0f);
            tip3.layout(right4, top2, tip3.getMeasuredWidth() + right4, tip3.getMeasuredHeight() + top2);
        }
    }

    protected void ny() {
        Cm();
        this.arY = (EditorToolButton) findViewById(com.baidu.tieba.v.select_face);
        this.arZ = (EditorToolButton) findViewById(com.baidu.tieba.v.select_at);
        this.asa = (EditorToolButton) findViewById(com.baidu.tieba.v.select_privilege);
        this.asb = (EditorToolButton) findViewById(com.baidu.tieba.v.select_baobao);
        this.asc = (EditorToolButton) findViewById(com.baidu.tieba.v.select_mediacontent);
    }

    protected void Cm() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.write_editor_tool_button_container, this, true);
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            View.OnClickListener a = a(wVar);
            this.arY.setOnClickListener(a);
            this.arZ.setOnClickListener(a);
            this.asa.setOnClickListener(a);
            this.asb.setOnClickListener(a);
            this.asc.setOnClickListener(a);
        }
    }

    public void CB() {
        Bi();
        this.arY.Be();
    }

    public void CC() {
        Bi();
        this.asa.Be();
    }

    public void CD() {
        this.asb.Bf();
    }

    public void CE() {
        Bi();
        this.asb.Be();
    }

    public void CF() {
        Bi();
        this.asc.Be();
    }

    public void CG() {
        this.asc.Bf();
    }

    public void setFaceFocusable(boolean z) {
        this.arY.setFocusable(z);
    }

    public void setAtFocusable(boolean z) {
        this.arZ.setFocusable(z);
    }

    public void setPrivilegeFocusable(boolean z) {
        this.asa.setFocusable(z);
    }

    public void setBaobaoFocusable(boolean z) {
        this.asb.setFocusable(z);
    }

    public void setFaceEnabled(boolean z) {
        this.arY.setEnabled(z);
    }

    public void setAtEnabled(boolean z) {
        this.arZ.setEnabled(z);
    }

    public void setBaobaoEnabled(boolean z) {
        this.asb.setEnabled(z);
    }

    public void setPrivilegeEnable(boolean z) {
        this.asa.setEnabled(z);
    }

    public void setBaobaoEnable(boolean z) {
        this.asb.setEnabled(z);
    }

    public void di(String str) {
        if (this.asd == null) {
            this.asd = a(this.asc, true);
        } else {
            b(this.asc, true);
        }
        this.asc.eG(str);
    }

    public void CH() {
        if (this.asb != null) {
            this.asb.setVisibility(8);
        }
    }

    public void rF() {
        if (this.asd != null) {
            b(this.asc, true);
            this.asc.qm();
        }
    }

    public void Cn() {
        if (this.asd == null) {
            this.asd = a(this.asc, false);
        } else {
            b(this.asc, false);
        }
        this.asc.ql();
    }

    public void Co() {
        if (this.asd != null) {
            b(this.asc, false);
            this.asc.qm();
        }
    }

    public void rH() {
        if (this.ST == null) {
            this.ST = a(this.asa, false);
        }
        this.asa.ql();
    }

    public void rI() {
        this.asa.qm();
    }

    public void dk(String str) {
        if (this.SU == null) {
            this.SU = a(this.asb, true);
        }
        this.asb.eG(str);
    }

    public void rM() {
        this.asb.qm();
    }

    public void bB(boolean z) {
        if (z) {
            this.asa.Bc();
        } else {
            this.asa.hide();
        }
    }

    public void changeSkinType(int i) {
        if (this.SR != null) {
            com.baidu.tbadk.core.util.aw.h((View) this.SR, com.baidu.tieba.u.icon_news_head_prompt_one);
        }
        if (this.ST != null) {
            com.baidu.tbadk.core.util.aw.h((View) this.ST, com.baidu.tieba.u.icon_news_down_bar_one);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, com.baidu.tbadk.editortool.w wVar) {
        if (editorToolButton == this.arY) {
            wVar.handleAction(1, null);
        } else if (editorToolButton == this.arZ) {
            wVar.handleAction(0, null);
        } else if (editorToolButton == this.asa) {
            wVar.handleAction(43, null);
        } else if (editorToolButton == this.asb) {
            wVar.handleAction(48, null);
        } else if (editorToolButton == this.asc) {
            wVar.handleAction(37, null);
        }
        if (editorToolButton.Bd()) {
            if (editorToolButton.isFocused()) {
                Bi();
                if (editorToolButton == this.arY) {
                    wVar.handleAction(3, null);
                } else if (editorToolButton == this.arZ) {
                    wVar.handleAction(16, null);
                } else if (editorToolButton == this.asa) {
                    wVar.handleAction(45, null);
                } else if (editorToolButton == this.asb) {
                    wVar.handleAction(49, null);
                } else if (editorToolButton == this.asc) {
                    wVar.handleAction(39, null);
                }
            } else if (editorToolButton == this.arY) {
                wVar.handleAction(2, null);
            } else if (editorToolButton == this.arZ) {
                wVar.handleAction(17, null);
                wVar.handleAction(5, null);
            } else if (editorToolButton == this.asa) {
                wVar.handleAction(44, null);
            } else if (editorToolButton == this.asb) {
                wVar.handleAction(50, null);
            } else if (editorToolButton == this.asc) {
                wVar.handleAction(38, null);
            }
        }
    }

    protected View.OnClickListener a(com.baidu.tbadk.editortool.w wVar) {
        return new aw(this, wVar);
    }

    public void refresh() {
        if (TextUtils.isEmpty(TbadkApplication.m251getInst().getDefaultBubble())) {
            rI();
        } else {
            rH();
        }
    }
}
