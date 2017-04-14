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
    private com.baidu.tbadk.editortools.j KM;
    private EmotionTabHorizonScrollView bDg;
    private ImageView bDh;
    private View bDi;
    private boolean bDj;

    /* loaded from: classes.dex */
    public interface a {
        void eQ(int i);
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
        this.bDg = (EmotionTabHorizonScrollView) findViewById(w.h.face_tab_scroll_view);
        this.bDh = (ImageView) findViewById(w.h.face_tab_delete);
        this.bDi = findViewById(w.h.vertical_div_line);
        this.bDh.setOnClickListener(new s(this));
    }

    public void setFrom(int i) {
        if (this.bDg != null) {
            this.bDg.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bDg.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bDg.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.bDg.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.bDg.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.bDg.reset();
    }

    public void setIsInChat(boolean z) {
        this.bDj = z;
        if (this.bDg != null) {
            this.bDg.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        aq.e(this, w.e.common_color_10255, i);
        this.bDg.m16do(i);
        aq.c(this.bDh, w.g.but_face_close, i);
        aq.e(this.bDh, w.e.common_color_10255, i);
        aq.e(this.bDi, w.e.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.bDh.setVisibility(0);
        } else {
            this.bDh.setVisibility(8);
        }
    }

    public void l(int i, boolean z) {
        this.bDg.l(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.bDg.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.KM = jVar;
        this.bDg.setEditorTools(this.KM);
    }
}
