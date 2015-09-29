package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private com.baidu.tbadk.editortools.j Kz;
    private boolean aqA;
    private EmotionTabHorizonScrollView aqx;
    private ImageView aqy;
    private View aqz;

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
        this.aqx = (EmotionTabHorizonScrollView) findViewById(i.f.face_tab_scroll_view);
        this.aqy = (ImageView) findViewById(i.f.face_tab_delete);
        this.aqz = findViewById(i.f.vertical_div_line);
        this.aqy.setOnClickListener(new l(this));
    }

    public void setFrom(int i) {
        if (this.aqx != null) {
            this.aqx.setFrom(i);
        }
    }

    public void setDatas(ArrayList<t> arrayList) {
        this.aqx.setDatas(arrayList);
    }

    public void c(t tVar) {
        this.aqx.c(tVar);
    }

    public void setCurrentTab(int i) {
        this.aqx.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aqx.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aqx.reset();
    }

    public void setIsInChat(boolean z) {
        this.aqA = z;
        if (this.aqx != null) {
            this.aqx.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        am.d(this, i.c.write_editor_background, i);
        this.aqx.cP(i);
        am.b(this.aqy, i.e.but_face_close, i);
        am.d(this.aqy, i.c.write_editor_background, i);
        am.d(this.aqz, i.c.emotion_tab_div_line_color, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aqy.setVisibility(0);
        } else {
            this.aqy.setVisibility(8);
        }
    }

    public void g(int i, boolean z) {
        this.aqx.g(i, z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.Kz = jVar;
        this.aqx.setEditorTools(this.Kz);
    }
}
