package com.baidu.tbadk.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.bc;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EmotionTabHorizonScrollView YH;
    private ImageView YI;
    private w Yg;

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
        com.baidu.adp.lib.g.b.ei().a(context, com.baidu.tieba.x.emotion_tab_widget, this, true);
        this.YH = (EmotionTabHorizonScrollView) findViewById(com.baidu.tieba.w.face_tab_scroll_view);
        this.YI = (ImageView) findViewById(com.baidu.tieba.w.face_tab_delete);
        this.YI.setOnClickListener(new s(this));
    }

    public void setFrom(int i) {
        if (this.YH != null) {
            this.YH.setFrom(i);
        }
    }

    public void setDatas(ArrayList<ae> arrayList) {
        this.YH.setDatas(arrayList);
    }

    public void d(ae aeVar) {
        this.YH.d(aeVar);
    }

    public void setCurrentTab(int i) {
        this.YH.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(t tVar) {
        this.YH.setOnTabSelectedListener(tVar);
    }

    public void reset() {
        this.YH.reset();
    }

    public void onChangeSkinType(int i) {
        bc.d(this, com.baidu.tieba.t.editor_tool_container_bg, i);
        this.YH.ct(i);
        bc.a(this.YI, com.baidu.tieba.v.but_face_close, i);
        bc.d(this.YI, com.baidu.tieba.t.emotion_delete_bg, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.YI.setVisibility(0);
        } else {
            this.YI.setVisibility(8);
        }
    }

    public void f(int i, boolean z) {
        this.YH.f(i, z);
    }

    public void setOnDataSelected(w wVar) {
        this.Yg = wVar;
    }
}
