package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private k Lx;
    private CommonTabHorizonScrollView awd;
    private ImageView awe;

    /* loaded from: classes.dex */
    public interface a {
        void eK(int i);
    }

    public CommonTabWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CommonTabWidgetView(Context context) {
        super(context);
        init(context);
    }

    public void setEditorTools(k kVar) {
        this.Lx = kVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(t.h.common_tab_widget, (ViewGroup) this, true);
        this.awd = (CommonTabHorizonScrollView) findViewById(t.g.privilege_tab_scroll_view);
        this.awe = (ImageView) findViewById(t.g.privilege_tab_delete);
        this.awe.setOnClickListener(new d(this));
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.awd.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.awd.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.awd.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.awd.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.awd.reset();
    }

    public void onChangeSkinType(int i) {
        ar.l(this, t.d.editor_tool_container_bg);
        this.awd.dk(i);
        ar.c(this.awe, t.f.but_face_close);
        ar.l(this.awe, t.d.emotion_delete_bg);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.awe.setVisibility(0);
        } else {
            this.awe.setVisibility(8);
        }
    }
}
