package com.baidu.tieba.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f1272a;

    public a(Context context) {
        super(context);
        this.f1272a = context;
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1272a = context;
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1272a = context;
    }

    private boolean d() {
        return TiebaApplication.h().an() == 1;
    }

    public TextView a(EditorToolButton editorToolButton, boolean z) {
        TextView textView = new TextView(this.f1272a);
        textView.setTextSize(10.0f);
        textView.setTextColor(this.f1272a.getResources().getColor(d() ? R.color.top_msg_num_night : R.color.top_msg_num_day));
        textView.setGravity(17);
        if (z) {
            textView.setBackgroundResource(d() ? R.drawable.icon_news_prompt_1 : R.drawable.icon_news_prompt);
        } else {
            textView.setBackgroundResource(d() ? R.drawable.icon_news_content_prompt_1 : R.drawable.icon_news_content_prompt);
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
