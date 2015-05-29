package com.baidu.tbadk.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ay;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private v ajx;
    private EmotionTabHorizonScrollView akc;
    private ImageView akd;
    private View ake;
    private boolean akf;

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
        com.baidu.adp.lib.g.b.hr().a(context, com.baidu.tieba.r.emotion_tab_widget, this, true);
        this.akc = (EmotionTabHorizonScrollView) findViewById(com.baidu.tieba.q.face_tab_scroll_view);
        this.akd = (ImageView) findViewById(com.baidu.tieba.q.face_tab_delete);
        this.ake = findViewById(com.baidu.tieba.q.vertical_div_line);
        this.akd.setOnClickListener(new r(this));
    }

    public void setFrom(int i) {
        if (this.akc != null) {
            this.akc.setFrom(i);
        }
    }

    public void setDatas(ArrayList<ad> arrayList) {
        this.akc.setDatas(arrayList);
    }

    public void c(ad adVar) {
        this.akc.c(adVar);
    }

    public void setCurrentTab(int i) {
        this.akc.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(s sVar) {
        this.akc.setOnTabSelectedListener(sVar);
    }

    public void reset() {
        this.akc.reset();
    }

    public void setIsInChat(boolean z) {
        this.akf = z;
        if (this.akc != null) {
            this.akc.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        ay.d(this, com.baidu.tieba.n.write_editor_background, i);
        this.akc.cz(i);
        ay.a(this.akd, com.baidu.tieba.p.but_face_close, i);
        ay.d(this.akd, com.baidu.tieba.n.write_editor_background, i);
        ay.d(this.ake, com.baidu.tieba.n.emotion_tab_div_line_color, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.akd.setVisibility(0);
        } else {
            this.akd.setVisibility(8);
        }
    }

    public void f(int i, boolean z) {
        this.akc.f(i, z);
    }

    public void setOnDataSelected(v vVar) {
        this.ajx = vVar;
    }
}
