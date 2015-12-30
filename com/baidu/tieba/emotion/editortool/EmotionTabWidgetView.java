package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private com.baidu.tbadk.editortools.k Li;
    private EmotionTabHorizonScrollView aTl;
    private ImageView aTm;
    private View aTn;
    private boolean aTo;

    /* loaded from: classes.dex */
    public interface a {
        void eq(int i);
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
        LayoutInflater.from(context).inflate(n.h.emotion_tab_widget, (ViewGroup) this, true);
        this.aTl = (EmotionTabHorizonScrollView) findViewById(n.g.face_tab_scroll_view);
        this.aTm = (ImageView) findViewById(n.g.face_tab_delete);
        this.aTn = findViewById(n.g.vertical_div_line);
        this.aTm.setOnClickListener(new r(this));
    }

    public void setFrom(int i) {
        if (this.aTl != null) {
            this.aTl.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.aTl.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.aTl.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.aTl.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aTl.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aTl.reset();
    }

    public void setIsInChat(boolean z) {
        this.aTo = z;
        if (this.aTl != null) {
            this.aTl.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        as.d(this, n.d.write_editor_background, i);
        this.aTl.cR(i);
        as.b(this.aTm, n.f.but_face_close, i);
        as.d(this.aTm, n.d.write_editor_background, i);
        as.d(this.aTn, n.d.emotion_tab_div_line_color, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aTm.setVisibility(0);
        } else {
            this.aTm.setVisibility(8);
        }
    }

    public void h(int i, boolean z) {
        this.aTl.h(i, z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.k kVar) {
        this.Li = kVar;
        this.aTl.setEditorTools(this.Li);
    }
}
