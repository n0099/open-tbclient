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
    private com.baidu.tbadk.editortools.l BV;
    private EmotionTabHorizonScrollView aWd;
    private ImageView aWe;
    private View aWf;
    private boolean aWg;

    /* loaded from: classes.dex */
    public interface a {
        void ev(int i);
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
        this.aWd = (EmotionTabHorizonScrollView) findViewById(t.g.face_tab_scroll_view);
        this.aWe = (ImageView) findViewById(t.g.face_tab_delete);
        this.aWf = findViewById(t.g.vertical_div_line);
        this.aWe.setOnClickListener(new r(this));
    }

    public void setFrom(int i) {
        if (this.aWd != null) {
            this.aWd.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.aWd.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.aWd.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.aWd.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aWd.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aWd.reset();
    }

    public void setIsInChat(boolean z) {
        this.aWg = z;
        if (this.aWd != null) {
            this.aWd.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        at.e(this, t.d.write_editor_background, i);
        this.aWd.cV(i);
        at.b(this.aWe, t.f.but_face_close, i);
        at.e(this.aWe, t.d.write_editor_background, i);
        at.e(this.aWf, t.d.emotion_tab_div_line_color, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aWe.setVisibility(0);
        } else {
            this.aWe.setVisibility(8);
        }
    }

    public void k(int i, boolean z) {
        this.aWd.k(i, z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.l lVar) {
        this.BV = lVar;
        this.aWd.setEditorTools(this.BV);
    }
}
