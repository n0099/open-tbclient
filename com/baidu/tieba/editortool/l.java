package com.baidu.tieba.editortool;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class l extends RelativeLayout {
    private int aqD;
    private boolean aqE;
    private Context mContext;
    private Paint tR;

    public l(Context context) {
        this(context, null);
    }

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aqE = true;
        this.mContext = context;
        this.tR = new Paint();
        this.tR.setStyle(Paint.Style.FILL);
        this.aqD = com.baidu.adp.lib.util.m.dip2px(this.mContext, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.aqE) {
            this.tR.setColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_bg_line_b));
            canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), this.aqD, this.tR);
        }
    }

    public void setDrawTop(boolean z) {
        this.aqE = z;
    }

    public TextView a(EditorToolButton editorToolButton, boolean z) {
        TextView textView = new TextView(this.mContext);
        com.baidu.tbadk.core.util.aw.b(textView, com.baidu.tieba.s.top_msg_num_day, 1);
        textView.setGravity(17);
        if (z) {
            textView.setTextSize(10.0f);
            com.baidu.tbadk.core.util.aw.h((View) textView, com.baidu.tieba.u.icon_news_head_prompt_one);
        } else {
            textView.setWidth(0);
            textView.setHeight(0);
            com.baidu.tbadk.core.util.aw.h((View) textView, com.baidu.tieba.u.icon_news_down_bar_one);
        }
        editorToolButton.f(textView);
        addView(textView);
        return textView;
    }

    public void b(EditorToolButton editorToolButton, boolean z) {
        if (editorToolButton != null && editorToolButton.Hm != null) {
            if (z) {
                editorToolButton.Hm.setTextSize(10.0f);
                com.baidu.tbadk.core.util.aw.b(editorToolButton.Hm, com.baidu.tieba.s.top_msg_num_day, 1);
                editorToolButton.Hm.setGravity(17);
                com.baidu.tbadk.core.util.aw.h((View) editorToolButton.Hm, com.baidu.tieba.u.icon_news_head_prompt_one);
                return;
            }
            editorToolButton.Hm.setWidth(0);
            editorToolButton.Hm.setHeight(0);
            editorToolButton.Hm.setText("");
            com.baidu.tbadk.core.util.aw.h((View) editorToolButton.Hm, com.baidu.tieba.u.icon_news_down_bar_one);
        }
    }

    public void Bg() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditorToolButton) {
                ((EditorToolButton) childAt).enable();
            }
        }
    }

    public void Bh() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditorToolButton) {
                ((EditorToolButton) childAt).disable();
            }
        }
    }

    public void Bi() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditorToolButton) {
                ((EditorToolButton) childAt).Bf();
            }
        }
    }
}
