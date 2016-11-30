package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private com.baidu.tbadk.editortools.l EL;
    private EmotionTabHorizonScrollView bIr;
    private ImageView bIs;
    private View bIt;
    private boolean bIu;

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
        LayoutInflater.from(context).inflate(r.h.emotion_tab_widget, (ViewGroup) this, true);
        this.bIr = (EmotionTabHorizonScrollView) findViewById(r.g.face_tab_scroll_view);
        this.bIs = (ImageView) findViewById(r.g.face_tab_delete);
        this.bIt = findViewById(r.g.vertical_div_line);
        this.bIs.setOnClickListener(new r(this));
    }

    public void setFrom(int i) {
        if (this.bIr != null) {
            this.bIr.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bIr.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bIr.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.bIr.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.bIr.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.bIr.reset();
    }

    public void setIsInChat(boolean z) {
        this.bIu = z;
        if (this.bIr != null) {
            this.bIr.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        at.e(this, r.d.common_color_10255, i);
        this.bIr.dm(i);
        at.c(this.bIs, r.f.but_face_close, i);
        at.e(this.bIs, r.d.common_color_10255, i);
        at.e(this.bIt, r.d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.bIs.setVisibility(0);
        } else {
            this.bIs.setVisibility(8);
        }
    }

    public void z(int i, boolean z) {
        this.bIr.z(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.bIr.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.l lVar) {
        this.EL = lVar;
        this.bIr.setEditorTools(this.EL);
    }
}
