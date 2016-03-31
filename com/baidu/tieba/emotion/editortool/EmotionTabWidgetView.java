package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private com.baidu.tbadk.editortools.l LE;
    private EmotionTabHorizonScrollView aZZ;
    private ImageView baa;
    private View bab;
    private boolean bac;

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
        LayoutInflater.from(context).inflate(t.h.emotion_tab_widget, (ViewGroup) this, true);
        this.aZZ = (EmotionTabHorizonScrollView) findViewById(t.g.face_tab_scroll_view);
        this.baa = (ImageView) findViewById(t.g.face_tab_delete);
        this.bab = findViewById(t.g.vertical_div_line);
        this.baa.setOnClickListener(new r(this));
    }

    public void setFrom(int i) {
        if (this.aZZ != null) {
            this.aZZ.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.aZZ.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.aZZ.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.aZZ.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aZZ.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aZZ.reset();
    }

    public void setIsInChat(boolean z) {
        this.bac = z;
        if (this.aZZ != null) {
            this.aZZ.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        at.d(this, t.d.write_editor_background, i);
        this.aZZ.dn(i);
        at.b(this.baa, t.f.but_face_close, i);
        at.d(this.baa, t.d.write_editor_background, i);
        at.d(this.bab, t.d.emotion_tab_div_line_color, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.baa.setVisibility(0);
        } else {
            this.baa.setVisibility(8);
        }
    }

    public void h(int i, boolean z) {
        this.aZZ.h(i, z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.l lVar) {
        this.LE = lVar;
        this.aZZ.setEditorTools(this.LE);
    }
}
