package com.baidu.tieba.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class i extends RelativeLayout {
    private Context a;

    public i(Context context) {
        super(context);
        this.a = context;
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
    }

    public i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
    }

    private boolean d() {
        return TbadkApplication.m252getInst().getSkinType() == 1;
    }

    public TextView a(EditorToolButton editorToolButton, boolean z) {
        TextView textView = new TextView(this.a);
        textView.setTextSize(10.0f);
        textView.setTextColor(this.a.getResources().getColor(d() ? com.baidu.tieba.s.top_msg_num_night : com.baidu.tieba.s.top_msg_num_day));
        textView.setGravity(17);
        if (z) {
            textView.setBackgroundResource(d() ? com.baidu.tieba.u.icon_news_head_prompt_one_1 : com.baidu.tieba.u.icon_news_head_prompt_one);
        } else {
            textView.setBackgroundResource(d() ? com.baidu.tieba.u.icon_news_list_prompt_1 : com.baidu.tieba.u.icon_news_list_prompt);
        }
        editorToolButton.a(textView);
        addView(textView);
        return textView;
    }

    public void a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditorToolButton) {
                ((EditorToolButton) childAt).c();
            }
        }
    }

    public void b() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditorToolButton) {
                ((EditorToolButton) childAt).d();
            }
        }
    }

    public void c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditorToolButton) {
                ((EditorToolButton) childAt).i();
            }
        }
    }
}
