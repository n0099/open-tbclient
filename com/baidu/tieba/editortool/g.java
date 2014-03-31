package com.baidu.tieba.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class g extends RelativeLayout {
    private Context a;

    public g(Context context) {
        super(context);
        this.a = context;
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
    }

    private static boolean d() {
        return TbadkApplication.j().l() == 1;
    }

    public final TextView a(EditorToolButton editorToolButton, boolean z) {
        TextView textView = new TextView(this.a);
        textView.setTextSize(10.0f);
        textView.setTextColor(this.a.getResources().getColor(d() ? com.baidu.tieba.a.e.top_msg_num_night : com.baidu.tieba.a.e.top_msg_num_day));
        textView.setGravity(17);
        if (z) {
            textView.setBackgroundResource(d() ? com.baidu.tieba.a.g.icon_news_head_prompt_one_1 : com.baidu.tieba.a.g.icon_news_head_prompt_one);
        } else {
            textView.setBackgroundResource(d() ? com.baidu.tieba.a.g.icon_news_list_prompt_1 : com.baidu.tieba.a.g.icon_news_list_prompt);
        }
        editorToolButton.a(textView);
        addView(textView);
        return textView;
    }

    public final void a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditorToolButton) {
                ((EditorToolButton) childAt).c();
            }
        }
    }

    public final void b() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditorToolButton) {
                ((EditorToolButton) childAt).d();
            }
        }
    }

    public final void c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditorToolButton) {
                ((EditorToolButton) childAt).i();
            }
        }
    }
}
