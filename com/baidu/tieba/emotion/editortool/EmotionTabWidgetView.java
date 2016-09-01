package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private com.baidu.tbadk.editortools.l EJ;
    private EmotionTabHorizonScrollView bFm;
    private ImageView bFn;
    private View bFo;
    private boolean bFp;

    /* loaded from: classes.dex */
    public interface a {
        void eO(int i);
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
        this.bFm = (EmotionTabHorizonScrollView) findViewById(t.g.face_tab_scroll_view);
        this.bFn = (ImageView) findViewById(t.g.face_tab_delete);
        this.bFo = findViewById(t.g.vertical_div_line);
        this.bFn.setOnClickListener(new r(this));
    }

    public void setFrom(int i) {
        if (this.bFm != null) {
            this.bFm.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bFm.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bFm.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.bFm.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.bFm.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.bFm.reset();
    }

    public void setIsInChat(boolean z) {
        this.bFp = z;
        if (this.bFm != null) {
            this.bFm.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        av.e(this, t.d.common_color_10255, i);
        this.bFm.dl(i);
        av.c(this.bFn, t.f.but_face_close, i);
        av.e(this.bFn, t.d.common_color_10255, i);
        av.e(this.bFo, t.d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.bFn.setVisibility(0);
        } else {
            this.bFn.setVisibility(8);
        }
    }

    public void z(int i, boolean z) {
        this.bFm.z(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.bFm.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.l lVar) {
        this.EJ = lVar;
        this.bFm.setEditorTools(this.EJ);
    }
}
