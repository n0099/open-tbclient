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
    private com.baidu.tbadk.editortools.k KS;
    private EmotionTabHorizonScrollView aPt;
    private ImageView aPu;
    private View aPv;
    private boolean aPw;

    /* loaded from: classes.dex */
    public interface a {
        void ew(int i);
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
        LayoutInflater.from(context).inflate(n.g.emotion_tab_widget, (ViewGroup) this, true);
        this.aPt = (EmotionTabHorizonScrollView) findViewById(n.f.face_tab_scroll_view);
        this.aPu = (ImageView) findViewById(n.f.face_tab_delete);
        this.aPv = findViewById(n.f.vertical_div_line);
        this.aPu.setOnClickListener(new r(this));
    }

    public void setFrom(int i) {
        if (this.aPt != null) {
            this.aPt.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.aPt.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.aPt.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.aPt.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aPt.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aPt.reset();
    }

    public void setIsInChat(boolean z) {
        this.aPw = z;
        if (this.aPt != null) {
            this.aPt.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        as.d(this, n.c.write_editor_background, i);
        this.aPt.cX(i);
        as.b(this.aPu, n.e.but_face_close, i);
        as.d(this.aPu, n.c.write_editor_background, i);
        as.d(this.aPv, n.c.emotion_tab_div_line_color, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aPu.setVisibility(0);
        } else {
            this.aPu.setVisibility(8);
        }
    }

    public void h(int i, boolean z) {
        this.aPt.h(i, z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.k kVar) {
        this.KS = kVar;
        this.aPt.setEditorTools(this.KS);
    }
}
