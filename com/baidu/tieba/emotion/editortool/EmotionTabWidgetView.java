package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private com.baidu.tbadk.editortools.j EM;
    private EmotionTabHorizonScrollView bou;
    private ImageView bov;
    private View bow;
    private boolean box;

    /* loaded from: classes.dex */
    public interface a {
        void eR(int i);
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
        LayoutInflater.from(context).inflate(r.h.emotion_tab_widget, (ViewGroup) this, true);
        this.bou = (EmotionTabHorizonScrollView) findViewById(r.g.face_tab_scroll_view);
        this.bov = (ImageView) findViewById(r.g.face_tab_delete);
        this.bow = findViewById(r.g.vertical_div_line);
        this.bov.setOnClickListener(new r(this));
    }

    public void setFrom(int i) {
        if (this.bou != null) {
            this.bou.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bou.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bou.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.bou.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.bou.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.bou.reset();
    }

    public void setIsInChat(boolean z) {
        this.box = z;
        if (this.bou != null) {
            this.bou.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        ar.e(this, r.d.common_color_10255, i);
        this.bou.m16do(i);
        ar.c(this.bov, r.f.but_face_close, i);
        ar.e(this.bov, r.d.common_color_10255, i);
        ar.e(this.bow, r.d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.bov.setVisibility(0);
        } else {
            this.bov.setVisibility(8);
        }
    }

    public void m(int i, boolean z) {
        this.bou.m(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.bou.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.EM = jVar;
        this.bou.setEditorTools(this.EM);
    }
}
