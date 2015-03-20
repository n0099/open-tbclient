package com.baidu.tbadk.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ba;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EmotionTabHorizonScrollView aiV;
    private ImageView aiW;
    private View aiX;
    private boolean aiY;
    private v aip;

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
        com.baidu.adp.lib.g.b.hH().a(context, com.baidu.tieba.w.emotion_tab_widget, this, true);
        this.aiV = (EmotionTabHorizonScrollView) findViewById(com.baidu.tieba.v.face_tab_scroll_view);
        this.aiW = (ImageView) findViewById(com.baidu.tieba.v.face_tab_delete);
        this.aiX = findViewById(com.baidu.tieba.v.vertical_div_line);
        this.aiW.setOnClickListener(new r(this));
    }

    public void setFrom(int i) {
        if (this.aiV != null) {
            this.aiV.setFrom(i);
        }
    }

    public void setDatas(ArrayList<ad> arrayList) {
        this.aiV.setDatas(arrayList);
    }

    public void c(ad adVar) {
        this.aiV.c(adVar);
    }

    public void setCurrentTab(int i) {
        this.aiV.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(s sVar) {
        this.aiV.setOnTabSelectedListener(sVar);
    }

    public void reset() {
        this.aiV.reset();
    }

    public void setIsInChat(boolean z) {
        this.aiY = z;
        if (this.aiV != null) {
            this.aiV.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        ba.d(this, com.baidu.tieba.s.write_editor_background, i);
        this.aiV.cu(i);
        ba.a(this.aiW, com.baidu.tieba.u.but_face_close, i);
        ba.d(this.aiW, com.baidu.tieba.s.write_editor_background, i);
        ba.d(this.aiX, com.baidu.tieba.s.emotion_tab_div_line_color, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aiW.setVisibility(0);
        } else {
            this.aiW.setVisibility(8);
        }
    }

    public void f(int i, boolean z) {
        this.aiV.f(i, z);
    }

    public void setOnDataSelected(v vVar) {
        this.aip = vVar;
    }
}
