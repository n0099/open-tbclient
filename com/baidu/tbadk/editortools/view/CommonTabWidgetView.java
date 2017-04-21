package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private j KO;
    private CommonTabHorizonScrollView aCf;
    private ImageView aCg;

    /* loaded from: classes.dex */
    public interface a {
        void eQ(int i);
    }

    public CommonTabWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CommonTabWidgetView(Context context) {
        super(context);
        init(context);
    }

    public void setEditorTools(j jVar) {
        this.KO = jVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(w.j.common_tab_widget, (ViewGroup) this, true);
        this.aCf = (CommonTabHorizonScrollView) findViewById(w.h.privilege_tab_scroll_view);
        this.aCg = (ImageView) findViewById(w.h.privilege_tab_delete);
        this.aCg.setOnClickListener(new e(this));
    }

    public void setDatas(ArrayList<b> arrayList) {
        this.aCf.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(b.C0040b c0040b) {
        this.aCf.c(c0040b);
    }

    public void setCurrentTab(int i) {
        this.aCf.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aCf.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aCf.reset();
    }

    public void onChangeSkinType(int i) {
        aq.k(this, w.e.common_color_10223);
        this.aCf.m13do(i);
        aq.c(this.aCg, w.g.but_face_close);
        aq.k(this.aCg, w.e.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aCg.setVisibility(0);
        } else {
            this.aCg.setVisibility(8);
        }
    }
}
