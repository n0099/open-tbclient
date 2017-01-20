package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private com.baidu.tbadk.editortools.j DX;
    private EmotionTabHorizonScrollView bwh;
    private ImageView bwi;
    private View bwj;
    private boolean bwk;

    /* loaded from: classes.dex */
    public interface a {
        void eS(int i);
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
        LayoutInflater.from(context).inflate(r.j.emotion_tab_widget, (ViewGroup) this, true);
        this.bwh = (EmotionTabHorizonScrollView) findViewById(r.h.face_tab_scroll_view);
        this.bwi = (ImageView) findViewById(r.h.face_tab_delete);
        this.bwj = findViewById(r.h.vertical_div_line);
        this.bwi.setOnClickListener(new r(this));
    }

    public void setFrom(int i) {
        if (this.bwh != null) {
            this.bwh.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bwh.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bwh.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.bwh.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.bwh.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.bwh.reset();
    }

    public void setIsInChat(boolean z) {
        this.bwk = z;
        if (this.bwh != null) {
            this.bwh.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        ap.e(this, r.e.common_color_10255, i);
        this.bwh.dp(i);
        ap.c(this.bwi, r.g.but_face_close, i);
        ap.e(this.bwi, r.e.common_color_10255, i);
        ap.e(this.bwj, r.e.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.bwi.setVisibility(0);
        } else {
            this.bwi.setVisibility(8);
        }
    }

    public void l(int i, boolean z) {
        this.bwh.l(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.bwh.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.DX = jVar;
        this.bwh.setEditorTools(this.DX);
    }
}
