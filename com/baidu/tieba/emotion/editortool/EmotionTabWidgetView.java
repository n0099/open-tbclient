package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private com.baidu.tbadk.editortools.j JT;
    private EmotionTabHorizonScrollView bRS;
    private ImageView bRT;
    private ImageView bRU;
    private View bRV;
    private boolean bRW;

    /* loaded from: classes.dex */
    public interface a {
        void eP(int i);
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
        this.bRS = (EmotionTabHorizonScrollView) findViewById(w.h.face_tab_scroll_view);
        this.bRT = (ImageView) findViewById(w.h.face_tab_delete);
        this.bRU = (ImageView) findViewById(w.h.face_tab_setting);
        this.bRV = findViewById(w.h.vertical_div_line);
        this.bRT.setOnClickListener(new t(this));
        this.bRU.setOnClickListener(new u(this));
        this.bRU.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.bRS != null) {
            this.bRS.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bRS.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bRS.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.bRS.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.bRS.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.bRS.reset();
    }

    public void setIsInChat(boolean z) {
        this.bRW = z;
        if (this.bRS != null) {
            this.bRS.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        as.e(this, w.e.common_color_10255, i);
        this.bRS.dp(i);
        as.c(this.bRT, w.g.emotion_delete, i);
        as.e(this.bRT, w.e.common_color_10255, i);
        as.c(this.bRU, w.g.icon_sett_s, i);
        as.e(this.bRU, w.e.common_color_10255, i);
        as.e(this.bRV, w.e.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.bRT.setVisibility(0);
        } else {
            this.bRT.setVisibility(8);
        }
    }

    public void m(int i, boolean z) {
        this.bRS.m(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.bRS.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.JT = jVar;
        this.bRS.setEditorTools(this.JT);
    }
}
