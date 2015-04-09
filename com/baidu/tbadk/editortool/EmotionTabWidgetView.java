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
    private v aix;
    private EmotionTabHorizonScrollView ajd;
    private ImageView aje;
    private View ajf;
    private boolean ajg;

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
        this.ajd = (EmotionTabHorizonScrollView) findViewById(com.baidu.tieba.v.face_tab_scroll_view);
        this.aje = (ImageView) findViewById(com.baidu.tieba.v.face_tab_delete);
        this.ajf = findViewById(com.baidu.tieba.v.vertical_div_line);
        this.aje.setOnClickListener(new r(this));
    }

    public void setFrom(int i) {
        if (this.ajd != null) {
            this.ajd.setFrom(i);
        }
    }

    public void setDatas(ArrayList<ad> arrayList) {
        this.ajd.setDatas(arrayList);
    }

    public void c(ad adVar) {
        this.ajd.c(adVar);
    }

    public void setCurrentTab(int i) {
        this.ajd.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(s sVar) {
        this.ajd.setOnTabSelectedListener(sVar);
    }

    public void reset() {
        this.ajd.reset();
    }

    public void setIsInChat(boolean z) {
        this.ajg = z;
        if (this.ajd != null) {
            this.ajd.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        ba.d(this, com.baidu.tieba.s.write_editor_background, i);
        this.ajd.cu(i);
        ba.a(this.aje, com.baidu.tieba.u.but_face_close, i);
        ba.d(this.aje, com.baidu.tieba.s.write_editor_background, i);
        ba.d(this.ajf, com.baidu.tieba.s.emotion_tab_div_line_color, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aje.setVisibility(0);
        } else {
            this.aje.setVisibility(8);
        }
    }

    public void f(int i, boolean z) {
        this.ajd.f(i, z);
    }

    public void setOnDataSelected(v vVar) {
        this.aix = vVar;
    }
}
