package com.baidu.tieba.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class PbEditorToolButtonContainer extends l {
    protected EditorToolButton aro;
    protected EditorToolButton arp;
    protected TextView arq;
    protected TextView arr;
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

    protected void Ck() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.pb_editor_tool_button_container, this, true);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aro.getTip() != null) {
            TextView tip = this.aro.getTip();
            int right = this.aro.getRight() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 10.0f);
            int top = this.aro.getTop() + com.baidu.adp.lib.util.m.dip2px(this.mContext, 1.0f);
            this.aro.getTip().layout(right, top, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + top);
        }
        if (this.arp.getTip() != null) {
            TextView tip2 = this.arp.getTip();
            int right2 = this.arp.getRight() - com.baidu.adp.lib.util.m.dip2px(this.mContext, 10.0f);
            int top2 = this.arp.getTop() + com.baidu.adp.lib.util.m.dip2px(this.mContext, 1.0f);
            this.arp.getTip().layout(right2, top2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + top2);
        }
    }

    protected void ny() {
        setDrawTop(false);
        Ck();
        this.arp = (EditorToolButton) findViewById(com.baidu.tieba.v.tool_more);
        this.aro = (EditorToolButton) findViewById(com.baidu.tieba.v.tool_audio);
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            View.OnClickListener a = a(wVar);
            this.arp.setOnClickListener(a);
            this.aro.setOnClickListener(a);
        }
    }

    public void setMoreFocusable(boolean z) {
        this.arp.setFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.aro.setFocusable(z);
    }

    public void setMoreEnabled(boolean z) {
        this.arp.setEnabled(z);
    }

    public void setAudioEnabled(boolean z) {
        this.aro.setEnabled(z);
    }

    public void setAudioHardDisabled(boolean z) {
        this.aro.setHardDisabled(z);
    }

    public void Cl() {
        if (this.arq == null) {
            this.arq = a(this.aro, false);
        }
        this.aro.qj();
    }

    public void Cm() {
        this.aro.qk();
    }

    public void Cn() {
        if (this.arr == null) {
            this.arr = a(this.arp, false);
        }
        this.arp.qj();
    }

    public void Co() {
        this.arp.qk();
    }

    public void bA(boolean z) {
        if (z) {
            this.aro.Ba();
        } else {
            this.aro.hide();
        }
    }

    public void changeSkinType(int i) {
        if (this.arq != null) {
            com.baidu.tbadk.core.util.aw.h((View) this.arq, com.baidu.tieba.u.icon_news_list_prompt);
        }
        if (this.arr != null) {
            com.baidu.tbadk.core.util.aw.h((View) this.arr, com.baidu.tieba.u.icon_news_list_prompt);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, com.baidu.tbadk.editortool.w wVar) {
        if (editorToolButton == this.arp) {
            wVar.handleAction(37, null);
        } else if (editorToolButton == this.aro) {
            wVar.handleAction(4, null);
        }
        if (editorToolButton.Bb() && !editorToolButton.isFocused()) {
            Bg();
            editorToolButton.Bc();
            if (editorToolButton == this.arp) {
                wVar.handleAction(38, null);
            } else if (editorToolButton == this.aro) {
                wVar.handleAction(5, null);
            }
        }
    }

    protected View.OnClickListener a(com.baidu.tbadk.editortool.w wVar) {
        return new ae(this, wVar);
    }
}
