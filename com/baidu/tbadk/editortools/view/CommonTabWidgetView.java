package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private j Kz;
    private CommonTabHorizonScrollView asL;
    private ImageView asM;

    /* loaded from: classes.dex */
    public interface a {
        void dR(int i);
    }

    public CommonTabWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CommonTabWidgetView(Context context) {
        super(context);
        init(context);
    }

    public void setEditorTools(j jVar) {
        this.Kz = jVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(i.g.common_tab_widget, (ViewGroup) this, true);
        this.asL = (CommonTabHorizonScrollView) findViewById(i.f.privilege_tab_scroll_view);
        this.asM = (ImageView) findViewById(i.f.privilege_tab_delete);
        this.asM.setOnClickListener(new d(this));
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.asL.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.asL.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.asL.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.asL.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.asL.reset();
    }

    public void onChangeSkinType(int i) {
        al.j(this, i.c.editor_tool_container_bg);
        this.asL.cI(i);
        al.c(this.asM, i.e.but_face_close);
        al.j(this.asM, i.c.emotion_delete_bg);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.asM.setVisibility(0);
        } else {
            this.asM.setVisibility(8);
        }
    }
}
