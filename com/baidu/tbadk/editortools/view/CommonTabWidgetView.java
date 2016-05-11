package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private l BV;
    private CommonTabHorizonScrollView asL;
    private ImageView asM;

    /* loaded from: classes.dex */
    public interface a {
        void ew(int i);
    }

    public CommonTabWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CommonTabWidgetView(Context context) {
        super(context);
        init(context);
    }

    public void setEditorTools(l lVar) {
        this.BV = lVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(t.h.common_tab_widget, (ViewGroup) this, true);
        this.asL = (CommonTabHorizonScrollView) findViewById(t.g.privilege_tab_scroll_view);
        this.asM = (ImageView) findViewById(t.g.privilege_tab_delete);
        this.asM.setOnClickListener(new e(this));
    }

    public void setDatas(ArrayList<b> arrayList) {
        this.asL.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(b.C0041b c0041b) {
        this.asL.c(c0041b);
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
        at.l(this, t.d.editor_tool_container_bg);
        this.asL.cW(i);
        at.c(this.asM, t.f.but_face_close);
        at.l(this.asM, t.d.emotion_delete_bg);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.asM.setVisibility(0);
        } else {
            this.asM.setVisibility(8);
        }
    }
}
