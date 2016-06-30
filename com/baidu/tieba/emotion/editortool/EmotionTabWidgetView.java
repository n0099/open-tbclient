package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private com.baidu.tbadk.editortools.l BW;
    private EmotionTabHorizonScrollView brK;
    private ImageView brL;
    private View brM;
    private boolean brN;

    /* loaded from: classes.dex */
    public interface a {
        void eA(int i);
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
        LayoutInflater.from(context).inflate(u.h.emotion_tab_widget, (ViewGroup) this, true);
        this.brK = (EmotionTabHorizonScrollView) findViewById(u.g.face_tab_scroll_view);
        this.brL = (ImageView) findViewById(u.g.face_tab_delete);
        this.brM = findViewById(u.g.vertical_div_line);
        this.brL.setOnClickListener(new r(this));
    }

    public void setFrom(int i) {
        if (this.brK != null) {
            this.brK.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.brK.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.brK.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.brK.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.brK.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.brK.reset();
    }

    public void setIsInChat(boolean z) {
        this.brN = z;
        if (this.brK != null) {
            this.brK.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        av.e(this, u.d.common_color_10255, i);
        this.brK.cX(i);
        av.b(this.brL, u.f.but_face_close, i);
        av.e(this.brL, u.d.common_color_10255, i);
        av.e(this.brM, u.d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.brL.setVisibility(0);
        } else {
            this.brL.setVisibility(8);
        }
    }

    public void y(int i, boolean z) {
        this.brK.y(i, z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.l lVar) {
        this.BW = lVar;
        this.brK.setEditorTools(this.BW);
    }
}
