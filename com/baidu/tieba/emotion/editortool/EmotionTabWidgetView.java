package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private com.baidu.tbadk.editortools.k Lx;
    private EmotionTabHorizonScrollView aVr;
    private ImageView aVs;
    private View aVt;
    private boolean aVu;

    /* loaded from: classes.dex */
    public interface a {
        void eK(int i);
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
        LayoutInflater.from(context).inflate(t.h.emotion_tab_widget, (ViewGroup) this, true);
        this.aVr = (EmotionTabHorizonScrollView) findViewById(t.g.face_tab_scroll_view);
        this.aVs = (ImageView) findViewById(t.g.face_tab_delete);
        this.aVt = findViewById(t.g.vertical_div_line);
        this.aVs.setOnClickListener(new r(this));
    }

    public void setFrom(int i) {
        if (this.aVr != null) {
            this.aVr.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.aVr.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.aVr.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.aVr.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aVr.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aVr.reset();
    }

    public void setIsInChat(boolean z) {
        this.aVu = z;
        if (this.aVr != null) {
            this.aVr.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        ar.d(this, t.d.write_editor_background, i);
        this.aVr.dk(i);
        ar.b(this.aVs, t.f.but_face_close, i);
        ar.d(this.aVs, t.d.write_editor_background, i);
        ar.d(this.aVt, t.d.emotion_tab_div_line_color, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aVs.setVisibility(0);
        } else {
            this.aVs.setVisibility(8);
        }
    }

    public void h(int i, boolean z) {
        this.aVr.h(i, z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.k kVar) {
        this.Lx = kVar;
        this.aVr.setEditorTools(this.Lx);
    }
}
