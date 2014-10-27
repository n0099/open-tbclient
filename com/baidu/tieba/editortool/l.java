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
    private int aqu;
    private boolean aqv;
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
        this.aqv = true;
        this.mContext = context;
        this.tR = new Paint();
        this.tR.setStyle(Paint.Style.FILL);
        this.aqu = com.baidu.adp.lib.util.m.dip2px(this.mContext, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.aqv) {
            this.tR.setColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_bg_line_b));
            canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), this.aqu, this.tR);
        }
    }

    public void setDrawTop(boolean z) {
        this.aqv = z;
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
        if (editorToolButton != null && editorToolButton.Hl != null) {
            if (z) {
                editorToolButton.Hl.setTextSize(10.0f);
                com.baidu.tbadk.core.util.aw.b(editorToolButton.Hl, com.baidu.tieba.s.top_msg_num_day, 1);
                editorToolButton.Hl.setGravity(17);
                com.baidu.tbadk.core.util.aw.h((View) editorToolButton.Hl, com.baidu.tieba.u.icon_news_head_prompt_one);
                return;
            }
            editorToolButton.Hl.setWidth(0);
            editorToolButton.Hl.setHeight(0);
            editorToolButton.Hl.setText("");
            com.baidu.tbadk.core.util.aw.h((View) editorToolButton.Hl, com.baidu.tieba.u.icon_news_down_bar_one);
        }
    }

    public void Be() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditorToolButton) {
                ((EditorToolButton) childAt).enable();
            }
        }
    }

    public void Bf() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditorToolButton) {
                ((EditorToolButton) childAt).disable();
            }
        }
    }

    public void Bg() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditorToolButton) {
                ((EditorToolButton) childAt).Bd();
            }
        }
    }
}
