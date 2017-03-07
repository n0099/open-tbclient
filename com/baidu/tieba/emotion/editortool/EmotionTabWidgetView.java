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
    private com.baidu.tbadk.editortools.j Ll;
    private EmotionTabHorizonScrollView bDn;
    private ImageView bDo;
    private View bDp;
    private boolean bDq;

    /* loaded from: classes.dex */
    public interface a {
        void eN(int i);
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
        this.bDn = (EmotionTabHorizonScrollView) findViewById(w.h.face_tab_scroll_view);
        this.bDo = (ImageView) findViewById(w.h.face_tab_delete);
        this.bDp = findViewById(w.h.vertical_div_line);
        this.bDo.setOnClickListener(new r(this));
    }

    public void setFrom(int i) {
        if (this.bDn != null) {
            this.bDn.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bDn.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bDn.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.bDn.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.bDn.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.bDn.reset();
    }

    public void setIsInChat(boolean z) {
        this.bDq = z;
        if (this.bDn != null) {
            this.bDn.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        aq.e(this, w.e.common_color_10255, i);
        this.bDn.dl(i);
        aq.c(this.bDo, w.g.but_face_close, i);
        aq.e(this.bDo, w.e.common_color_10255, i);
        aq.e(this.bDp, w.e.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.bDo.setVisibility(0);
        } else {
            this.bDo.setVisibility(8);
        }
    }

    public void l(int i, boolean z) {
        this.bDn.l(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.bDn.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.Ll = jVar;
        this.bDn.setEditorTools(this.Ll);
    }
}
