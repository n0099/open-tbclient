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
    private EmotionTabHorizonScrollView arX;
    private ImageView arY;
    private View arZ;
    private boolean asa;

    /* loaded from: classes.dex */
    public interface a {
        void dZ(int i);
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
        this.arX = (EmotionTabHorizonScrollView) findViewById(i.f.face_tab_scroll_view);
        this.arY = (ImageView) findViewById(i.f.face_tab_delete);
        this.arZ = findViewById(i.f.vertical_div_line);
        this.arY.setOnClickListener(new l(this));
    }

    public void setFrom(int i) {
        if (this.arX != null) {
            this.arX.setFrom(i);
        }
    }

    public void setDatas(ArrayList<v> arrayList) {
        this.arX.setDatas(arrayList);
    }

    public void c(v vVar) {
        this.arX.c(vVar);
    }

    public void setCurrentTab(int i) {
        this.arX.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.arX.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.arX.reset();
    }

    public void setIsInChat(boolean z) {
        this.asa = z;
        if (this.arX != null) {
            this.arX.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        al.d(this, i.c.write_editor_background, i);
        this.arX.cO(i);
        al.a(this.arY, i.e.but_face_close, i);
        al.d(this.arY, i.c.write_editor_background, i);
        al.d(this.arZ, i.c.emotion_tab_div_line_color, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.arY.setVisibility(0);
        } else {
            this.arY.setVisibility(8);
        }
    }

    public void g(int i, boolean z) {
        this.arX.g(i, z);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.Kz = jVar;
        this.arX.setEditorTools(this.Kz);
    }
}
