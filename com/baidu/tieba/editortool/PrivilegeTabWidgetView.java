package com.baidu.tieba.editortool;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PrivilegeTabWidgetView extends LinearLayout {
    private PrivilegeTabHorizonScrollView a;
    private ImageView b;
    private com.baidu.tbadk.editortool.x c;

    public PrivilegeTabWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PrivilegeTabWidgetView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        setVisibility(8);
        removeAllViews();
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.w.privilege_tab_widget, (ViewGroup) this, true);
        this.a = (PrivilegeTabHorizonScrollView) findViewById(com.baidu.tieba.v.privilege_tab_scroll_view);
        this.b = (ImageView) findViewById(com.baidu.tieba.v.privilege_tab_delete);
        this.b.setOnClickListener(new am(this));
    }

    public void setDatas(ArrayList<ag> arrayList) {
        this.a.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void a(ai aiVar) {
        this.a.a(aiVar);
    }

    public void setCurrentTab(int i) {
        this.a.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(an anVar) {
        this.a.setOnTabSelectedListener(anVar);
    }

    public void a() {
        this.a.a();
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

    public void setOnDataSelected(com.baidu.tbadk.editortool.x xVar) {
        this.c = xVar;
    }
}
