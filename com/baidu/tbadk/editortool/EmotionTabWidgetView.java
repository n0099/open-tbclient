package com.baidu.tbadk.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aw;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private w RG;
    private EmotionTabHorizonScrollView Si;
    private ImageView Sj;

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
        this.Si = (EmotionTabHorizonScrollView) findViewById(com.baidu.tieba.v.face_tab_scroll_view);
        this.Sj = (ImageView) findViewById(com.baidu.tieba.v.face_tab_delete);
        this.Sj.setOnClickListener(new s(this));
    }

    public void setFrom(int i) {
        if (this.Si != null) {
            this.Si.setFrom(i);
        }
    }

    public void setDatas(ArrayList<ad> arrayList) {
        this.Si.setDatas(arrayList);
    }

    public void d(ad adVar) {
        this.Si.d(adVar);
    }

    public void setCurrentTab(int i) {
        this.Si.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(t tVar) {
        this.Si.setOnTabSelectedListener(tVar);
    }

    public void reset() {
        this.Si.reset();
    }

    public void onChangeSkinType(int i) {
        aw.d(this, com.baidu.tieba.s.editor_tool_container_bg, i);
        this.Si.bN(i);
        aw.a(this.Sj, com.baidu.tieba.u.but_face_close, i);
        aw.d(this.Sj, com.baidu.tieba.s.emotion_delete_bg, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.Sj.setVisibility(0);
        } else {
            this.Sj.setVisibility(8);
        }
    }

    public void f(int i, boolean z) {
        this.Si.f(i, z);
    }

    public void setOnDataSelected(w wVar) {
        this.RG = wVar;
    }
}
