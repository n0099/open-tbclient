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
    private w c;

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
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.v.emotion_tab_widget, (ViewGroup) this, true);
        this.a = (EmotionTabHorizonScrollView) findViewById(com.baidu.tieba.u.face_tab_scroll_view);
        this.b = (ImageView) findViewById(com.baidu.tieba.u.face_tab_delete);
        this.b.setOnClickListener(new s(this));
    }

    public void setFrom(int i) {
        if (this.a != null) {
            this.a.setFrom(i);
        }
    }

    public void setDatas(ArrayList<ad> arrayList) {
        this.a.setDatas(arrayList);
    }

    public void a(ad adVar) {
        this.a.a(adVar);
    }

    public void setCurrentTab(int i) {
        this.a.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(t tVar) {
        this.a.setOnTabSelectedListener(tVar);
    }

    public void a() {
        this.a.b();
    }

    public void a(int i) {
        setBackgroundColor(getResources().getColor(i == 1 ? com.baidu.tieba.r.editor_tool_container_bg_1 : com.baidu.tieba.r.editor_tool_container_bg));
        Resources resources = getContext().getResources();
        this.a.a(i);
        int i2 = i == 1 ? com.baidu.tieba.t.but_face_close_1 : com.baidu.tieba.t.but_face_close;
        int i3 = i == 1 ? com.baidu.tieba.r.emotion_delete_bg_1 : com.baidu.tieba.r.emotion_delete_bg;
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

    public void setOnDataSelected(w wVar) {
        this.c = wVar;
    }
}
