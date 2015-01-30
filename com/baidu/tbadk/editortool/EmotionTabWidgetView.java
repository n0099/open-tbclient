package com.baidu.tbadk.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.bc;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EmotionTabHorizonScrollView YK;
    private ImageView YL;
    private w Yj;

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
        this.YK = (EmotionTabHorizonScrollView) findViewById(com.baidu.tieba.w.face_tab_scroll_view);
        this.YL = (ImageView) findViewById(com.baidu.tieba.w.face_tab_delete);
        this.YL.setOnClickListener(new s(this));
    }

    public void setFrom(int i) {
        if (this.YK != null) {
            this.YK.setFrom(i);
        }
    }

    public void setDatas(ArrayList<ae> arrayList) {
        this.YK.setDatas(arrayList);
    }

    public void d(ae aeVar) {
        this.YK.d(aeVar);
    }

    public void setCurrentTab(int i) {
        this.YK.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(t tVar) {
        this.YK.setOnTabSelectedListener(tVar);
    }

    public void reset() {
        this.YK.reset();
    }

    public void onChangeSkinType(int i) {
        bc.d(this, com.baidu.tieba.t.editor_tool_container_bg, i);
        this.YK.ct(i);
        bc.a(this.YL, com.baidu.tieba.v.but_face_close, i);
        bc.d(this.YL, com.baidu.tieba.t.emotion_delete_bg, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.YL.setVisibility(0);
        } else {
            this.YL.setVisibility(8);
        }
    }

    public void f(int i, boolean z) {
        this.YK.f(i, z);
    }

    public void setOnDataSelected(w wVar) {
        this.Yj = wVar;
    }
}
