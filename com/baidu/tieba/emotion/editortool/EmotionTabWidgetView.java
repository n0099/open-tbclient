package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private com.baidu.tbadk.editortools.j KB;
    private EmotionTabHorizonScrollView aKT;
    private ImageView aKU;
    private View aKV;
    private boolean aKW;

    /* loaded from: classes.dex */
    public interface a {
        void ei(int i);
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
        LayoutInflater.from(context).inflate(i.g.emotion_tab_widget, (ViewGroup) this, true);
        this.aKT = (EmotionTabHorizonScrollView) findViewById(i.f.face_tab_scroll_view);
        this.aKU = (ImageView) findViewById(i.f.face_tab_delete);
        this.aKV = findViewById(i.f.vertical_div_line);
        this.aKU.setOnClickListener(new q(this));
    }

    public void setFrom(int i) {
        if (this.aKT != null) {
            this.aKT.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.aKT.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.aKT.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.aKT.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aKT.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aKT.reset();
    }

    public void setIsInChat(boolean z) {
        this.aKW = z;
        if (this.aKT != null) {
            this.aKT.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        an.d(this, i.c.write_editor_background, i);
        this.aKT.cP(i);
        an.b(this.aKU, i.e.but_face_close, i);
        an.d(this.aKU, i.c.write_editor_background, i);
        an.d(this.aKV, i.c.emotion_tab_div_line_color, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aKU.setVisibility(0);
        } else {
            this.aKU.setVisibility(8);
        }
    }

    public void h(int i, boolean z) {
        this.aKT.h(i, z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.KB = jVar;
        this.aKT.setEditorTools(this.KB);
    }
}
