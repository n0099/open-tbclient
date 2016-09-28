package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private com.baidu.tbadk.editortools.l EJ;
    private boolean bFA;
    private EmotionTabHorizonScrollView bFx;
    private ImageView bFy;
    private View bFz;

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
        LayoutInflater.from(context).inflate(r.h.emotion_tab_widget, (ViewGroup) this, true);
        this.bFx = (EmotionTabHorizonScrollView) findViewById(r.g.face_tab_scroll_view);
        this.bFy = (ImageView) findViewById(r.g.face_tab_delete);
        this.bFz = findViewById(r.g.vertical_div_line);
        this.bFy.setOnClickListener(new r(this));
    }

    public void setFrom(int i) {
        if (this.bFx != null) {
            this.bFx.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bFx.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bFx.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.bFx.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.bFx.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.bFx.reset();
    }

    public void setIsInChat(boolean z) {
        this.bFA = z;
        if (this.bFx != null) {
            this.bFx.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        av.e(this, r.d.common_color_10255, i);
        this.bFx.dl(i);
        av.c(this.bFy, r.f.but_face_close, i);
        av.e(this.bFy, r.d.common_color_10255, i);
        av.e(this.bFz, r.d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.bFy.setVisibility(0);
        } else {
            this.bFy.setVisibility(8);
        }
    }

    public void z(int i, boolean z) {
        this.bFx.z(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.bFx.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.l lVar) {
        this.EJ = lVar;
        this.bFx.setEditorTools(this.EJ);
    }
}
