package com.baidu.tieba.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class PbEditorToolButtonContainer extends l {
    protected TextView arA;
    protected EditorToolButton arx;
    protected EditorToolButton ary;
    protected TextView arz;
    protected Context mContext;

    public PbEditorToolButtonContainer(Context context) {
        super(context);
        this.mContext = context;
        ny();
    }

    public PbEditorToolButtonContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        ny();
    }

    public PbEditorToolButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        ny();
    }

    protected void Cm() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.pb_editor_tool_button_container, this, true);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.arx.getTip() != null) {
            TextView tip = this.arx.getTip();
            int right = this.arx.getRight() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 10.0f);
            int top = this.arx.getTop() + com.baidu.adp.lib.util.m.dip2px(this.mContext, 1.0f);
            this.arx.getTip().layout(right, top, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + top);
        }
        if (this.ary.getTip() != null) {
            TextView tip2 = this.ary.getTip();
            int right2 = this.ary.getRight() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 10.0f);
            int top2 = this.ary.getTop() + com.baidu.adp.lib.util.m.dip2px(this.mContext, 1.0f);
            this.ary.getTip().layout(right2, top2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + top2);
        }
    }

    protected void ny() {
        setDrawTop(false);
        Cm();
        this.ary = (EditorToolButton) findViewById(com.baidu.tieba.v.tool_more);
        this.arx = (EditorToolButton) findViewById(com.baidu.tieba.v.tool_audio);
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            View.OnClickListener a = a(wVar);
            this.ary.setOnClickListener(a);
            this.arx.setOnClickListener(a);
        }
    }

    public void setMoreFocusable(boolean z) {
        this.ary.setFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.arx.setFocusable(z);
    }

    public void setMoreEnabled(boolean z) {
        this.ary.setEnabled(z);
    }

    public void setAudioEnabled(boolean z) {
        this.arx.setEnabled(z);
    }

    public void setAudioHardDisabled(boolean z) {
        this.arx.setHardDisabled(z);
    }

    public void Cn() {
        if (this.arz == null) {
            this.arz = a(this.arx, false);
        }
        this.arx.ql();
    }

    public void Co() {
        this.arx.qm();
    }

    public void Cp() {
        if (this.arA == null) {
            this.arA = a(this.ary, false);
        }
        this.ary.ql();
    }

    public void Cq() {
        this.ary.qm();
    }

    public void bA(boolean z) {
        if (z) {
            this.arx.Bc();
        } else {
            this.arx.hide();
        }
    }

    public void changeSkinType(int i) {
        if (this.arz != null) {
            com.baidu.tbadk.core.util.aw.h((View) this.arz, com.baidu.tieba.u.icon_news_list_prompt);
        }
        if (this.arA != null) {
            com.baidu.tbadk.core.util.aw.h((View) this.arA, com.baidu.tieba.u.icon_news_list_prompt);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, com.baidu.tbadk.editortool.w wVar) {
        if (editorToolButton == this.ary) {
            wVar.handleAction(37, null);
        } else if (editorToolButton == this.arx) {
            wVar.handleAction(4, null);
        }
        if (editorToolButton.Bd() && !editorToolButton.isFocused()) {
            Bi();
            editorToolButton.Be();
            if (editorToolButton == this.ary) {
                wVar.handleAction(38, null);
            } else if (editorToolButton == this.arx) {
                wVar.handleAction(5, null);
            }
        }
    }

    protected View.OnClickListener a(com.baidu.tbadk.editortool.w wVar) {
        return new ae(this, wVar);
    }
}
