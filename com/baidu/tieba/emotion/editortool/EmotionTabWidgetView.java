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
    private com.baidu.tbadk.editortools.l Cw;
    private EmotionTabHorizonScrollView btZ;
    private ImageView bua;
    private View bub;
    private boolean buc;

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
        this.btZ = (EmotionTabHorizonScrollView) findViewById(u.g.face_tab_scroll_view);
        this.bua = (ImageView) findViewById(u.g.face_tab_delete);
        this.bub = findViewById(u.g.vertical_div_line);
        this.bua.setOnClickListener(new r(this));
    }

    public void setFrom(int i) {
        if (this.btZ != null) {
            this.btZ.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.btZ.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.btZ.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.btZ.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.btZ.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.btZ.reset();
    }

    public void setIsInChat(boolean z) {
        this.buc = z;
        if (this.btZ != null) {
            this.btZ.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        av.e(this, u.d.common_color_10255, i);
        this.btZ.cX(i);
        av.c(this.bua, u.f.but_face_close, i);
        av.e(this.bua, u.d.common_color_10255, i);
        av.e(this.bub, u.d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.bua.setVisibility(0);
        } else {
            this.bua.setVisibility(8);
        }
    }

    public void z(int i, boolean z) {
        this.btZ.z(i, z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.l lVar) {
        this.Cw = lVar;
        this.btZ.setEditorTools(this.Cw);
    }
}
