package com.baidu.tbadk.editortool;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EmotionTabHorizonScrollView a;
    private ImageView b;
    private x c;

    public EmotionTabWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public EmotionTabWidgetView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        removeAllViews();
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.w.emotion_tab_widget, (ViewGroup) this, true);
        this.a = (EmotionTabHorizonScrollView) findViewById(com.baidu.tieba.v.face_tab_scroll_view);
        this.b = (ImageView) findViewById(com.baidu.tieba.v.face_tab_delete);
        this.b.setOnClickListener(new t(this));
    }

    public void setFrom(int i) {
        if (this.a != null) {
            this.a.setFrom(i);
        }
    }

    public void setDatas(ArrayList<af> arrayList) {
        this.a.setDatas(arrayList);
    }

    public void a(af afVar) {
        this.a.a(afVar);
    }

    public void setCurrentTab(int i) {
        this.a.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(u uVar) {
        this.a.setOnTabSelectedListener(uVar);
    }

    public void a() {
        this.a.b();
    }

    public void a(int i) {
        setBackgroundColor(getResources().getColor(i == 1 ? com.baidu.tieba.s.editor_tool_container_bg_1 : com.baidu.tieba.s.editor_tool_container_bg));
        Resources resources = getContext().getResources();
        this.a.a(i);
        int i2 = i == 1 ? com.baidu.tieba.u.but_face_close_1 : com.baidu.tieba.u.but_face_close;
        int i3 = i == 1 ? com.baidu.tieba.s.emotion_delete_bg_1 : com.baidu.tieba.s.emotion_delete_bg;
        this.b.setImageResource(i2);
        this.b.setBackgroundColor(resources.getColor(i3));
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
    }

    public void a(int i, boolean z) {
        this.a.a(i, z);
    }

    public void setOnDataSelected(x xVar) {
        this.c = xVar;
    }
}
