package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private com.baidu.tbadk.editortools.j Kz;
    private EmotionTabHorizonScrollView aqn;
    private ImageView aqo;
    private View aqp;
    private boolean aqq;

    /* loaded from: classes.dex */
    public interface a {
        void dR(int i);
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
        LayoutInflater.from(context).inflate(i.g.emotion_tab_widget, (ViewGroup) this, true);
        this.aqn = (EmotionTabHorizonScrollView) findViewById(i.f.face_tab_scroll_view);
        this.aqo = (ImageView) findViewById(i.f.face_tab_delete);
        this.aqp = findViewById(i.f.vertical_div_line);
        this.aqo.setOnClickListener(new l(this));
    }

    public void setFrom(int i) {
        if (this.aqn != null) {
            this.aqn.setFrom(i);
        }
    }

    public void setDatas(ArrayList<v> arrayList) {
        this.aqn.setDatas(arrayList);
    }

    public void c(v vVar) {
        this.aqn.c(vVar);
    }

    public void setCurrentTab(int i) {
        this.aqn.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aqn.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aqn.reset();
    }

    public void setIsInChat(boolean z) {
        this.aqq = z;
        if (this.aqn != null) {
            this.aqn.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        al.d(this, i.c.write_editor_background, i);
        this.aqn.cI(i);
        al.a(this.aqo, i.e.but_face_close, i);
        al.d(this.aqo, i.c.write_editor_background, i);
        al.d(this.aqp, i.c.emotion_tab_div_line_color, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aqo.setVisibility(0);
        } else {
            this.aqo.setVisibility(8);
        }
    }

    public void f(int i, boolean z) {
        this.aqn.f(i, z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.Kz = jVar;
        this.aqn.setEditorTools(this.Kz);
    }
}
