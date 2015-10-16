package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private com.baidu.tbadk.editortools.j KA;
    private View aqA;
    private boolean aqB;
    private EmotionTabHorizonScrollView aqy;
    private ImageView aqz;

    /* loaded from: classes.dex */
    public interface a {
        void ea(int i);
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
        this.aqy = (EmotionTabHorizonScrollView) findViewById(i.f.face_tab_scroll_view);
        this.aqz = (ImageView) findViewById(i.f.face_tab_delete);
        this.aqA = findViewById(i.f.vertical_div_line);
        this.aqz.setOnClickListener(new l(this));
    }

    public void setFrom(int i) {
        if (this.aqy != null) {
            this.aqy.setFrom(i);
        }
    }

    public void setDatas(ArrayList<t> arrayList) {
        this.aqy.setDatas(arrayList);
    }

    public void c(t tVar) {
        this.aqy.c(tVar);
    }

    public void setCurrentTab(int i) {
        this.aqy.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aqy.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aqy.reset();
    }

    public void setIsInChat(boolean z) {
        this.aqB = z;
        if (this.aqy != null) {
            this.aqy.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        an.d(this, i.c.write_editor_background, i);
        this.aqy.cP(i);
        an.b(this.aqz, i.e.but_face_close, i);
        an.d(this.aqz, i.c.write_editor_background, i);
        an.d(this.aqA, i.c.emotion_tab_div_line_color, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aqz.setVisibility(0);
        } else {
            this.aqz.setVisibility(8);
        }
    }

    public void g(int i, boolean z) {
        this.aqy.g(i, z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.KA = jVar;
        this.aqy.setEditorTools(this.KA);
    }
}
