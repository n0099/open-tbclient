package com.baidu.tbadk.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aw;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private w RC;
    private EmotionTabHorizonScrollView Se;
    private ImageView Sf;

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
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.w.emotion_tab_widget, this, true);
        this.Se = (EmotionTabHorizonScrollView) findViewById(com.baidu.tieba.v.face_tab_scroll_view);
        this.Sf = (ImageView) findViewById(com.baidu.tieba.v.face_tab_delete);
        this.Sf.setOnClickListener(new s(this));
    }

    public void setFrom(int i) {
        if (this.Se != null) {
            this.Se.setFrom(i);
        }
    }

    public void setDatas(ArrayList<ad> arrayList) {
        this.Se.setDatas(arrayList);
    }

    public void d(ad adVar) {
        this.Se.d(adVar);
    }

    public void setCurrentTab(int i) {
        this.Se.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(t tVar) {
        this.Se.setOnTabSelectedListener(tVar);
    }

    public void reset() {
        this.Se.reset();
    }

    public void onChangeSkinType(int i) {
        aw.d(this, com.baidu.tieba.s.editor_tool_container_bg, i);
        this.Se.bN(i);
        aw.a(this.Sf, com.baidu.tieba.u.but_face_close, i);
        aw.d(this.Sf, com.baidu.tieba.s.emotion_delete_bg, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.Sf.setVisibility(0);
        } else {
            this.Sf.setVisibility(8);
        }
    }

    public void f(int i, boolean z) {
        this.Se.f(i, z);
    }

    public void setOnDataSelected(w wVar) {
        this.RC = wVar;
    }
}
