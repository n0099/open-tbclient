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
    private com.baidu.tbadk.editortools.j Kg;
    private EmotionTabHorizonScrollView bFE;
    private ImageView bFF;
    private View bFG;
    private boolean bFH;

    /* loaded from: classes.dex */
    public interface a {
        void eM(int i);
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
        this.bFE = (EmotionTabHorizonScrollView) findViewById(w.h.face_tab_scroll_view);
        this.bFF = (ImageView) findViewById(w.h.face_tab_delete);
        this.bFG = findViewById(w.h.vertical_div_line);
        this.bFF.setOnClickListener(new s(this));
    }

    public void setFrom(int i) {
        if (this.bFE != null) {
            this.bFE.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bFE.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bFE.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.bFE.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.bFE.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.bFE.reset();
    }

    public void setIsInChat(boolean z) {
        this.bFH = z;
        if (this.bFE != null) {
            this.bFE.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        aq.e(this, w.e.common_color_10255, i);
        this.bFE.dm(i);
        aq.c(this.bFF, w.g.but_face_close, i);
        aq.e(this.bFF, w.e.common_color_10255, i);
        aq.e(this.bFG, w.e.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.bFF.setVisibility(0);
        } else {
            this.bFF.setVisibility(8);
        }
    }

    public void l(int i, boolean z) {
        this.bFE.l(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.bFE.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.Kg = jVar;
        this.bFE.setEditorTools(this.Kg);
    }
}
