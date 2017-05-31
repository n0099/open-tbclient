package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private com.baidu.tbadk.editortools.j JU;
    private EmotionTabHorizonScrollView bLt;
    private ImageView bLu;
    private View bLv;
    private boolean bLw;

    /* loaded from: classes.dex */
    public interface a {
        void eN(int i);
    }

    public EmotionTabWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public EmotionTabWidgetView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(w.j.emotion_tab_widget, (ViewGroup) this, true);
        this.bLt = (EmotionTabHorizonScrollView) findViewById(w.h.face_tab_scroll_view);
        this.bLu = (ImageView) findViewById(w.h.face_tab_delete);
        this.bLv = findViewById(w.h.vertical_div_line);
        this.bLu.setOnClickListener(new s(this));
    }

    public void setFrom(int i) {
        if (this.bLt != null) {
            this.bLt.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bLt.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bLt.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.bLt.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.bLt.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.bLt.reset();
    }

    public void setIsInChat(boolean z) {
        this.bLw = z;
        if (this.bLt != null) {
            this.bLt.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        aq.e(this, w.e.common_color_10255, i);
        this.bLt.dn(i);
        aq.c(this.bLu, w.g.but_face_close, i);
        aq.e(this.bLu, w.e.common_color_10255, i);
        aq.e(this.bLv, w.e.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.bLu.setVisibility(0);
        } else {
            this.bLu.setVisibility(8);
        }
    }

    public void m(int i, boolean z) {
        this.bLt.m(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.bLt.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.JU = jVar;
        this.bLt.setEditorTools(this.JU);
    }
}
