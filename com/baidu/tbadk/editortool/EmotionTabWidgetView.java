package com.baidu.tbadk.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ax;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private w XD;
    private EmotionTabHorizonScrollView Ye;
    private ImageView Yf;

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
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.x.emotion_tab_widget, this, true);
        this.Ye = (EmotionTabHorizonScrollView) findViewById(com.baidu.tieba.w.face_tab_scroll_view);
        this.Yf = (ImageView) findViewById(com.baidu.tieba.w.face_tab_delete);
        this.Yf.setOnClickListener(new s(this));
    }

    public void setFrom(int i) {
        if (this.Ye != null) {
            this.Ye.setFrom(i);
        }
    }

    public void setDatas(ArrayList<ae> arrayList) {
        this.Ye.setDatas(arrayList);
    }

    public void d(ae aeVar) {
        this.Ye.d(aeVar);
    }

    public void setCurrentTab(int i) {
        this.Ye.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(t tVar) {
        this.Ye.setOnTabSelectedListener(tVar);
    }

    public void reset() {
        this.Ye.reset();
    }

    public void onChangeSkinType(int i) {
        ax.d(this, com.baidu.tieba.t.editor_tool_container_bg, i);
        this.Ye.cm(i);
        ax.a(this.Yf, com.baidu.tieba.v.but_face_close, i);
        ax.d(this.Yf, com.baidu.tieba.t.emotion_delete_bg, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.Yf.setVisibility(0);
        } else {
            this.Yf.setVisibility(8);
        }
    }

    public void f(int i, boolean z) {
        this.Ye.f(i, z);
    }

    public void setOnDataSelected(w wVar) {
        this.XD = wVar;
    }
}
