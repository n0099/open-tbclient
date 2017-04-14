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
    private j KM;
    private CommonTabHorizonScrollView aCd;
    private ImageView aCe;

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
        this.KM = jVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(w.j.common_tab_widget, (ViewGroup) this, true);
        this.aCd = (CommonTabHorizonScrollView) findViewById(w.h.privilege_tab_scroll_view);
        this.aCe = (ImageView) findViewById(w.h.privilege_tab_delete);
        this.aCe.setOnClickListener(new e(this));
    }

    public void setDatas(ArrayList<b> arrayList) {
        this.aCd.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(b.C0040b c0040b) {
        this.aCd.c(c0040b);
    }

    public void setCurrentTab(int i) {
        this.aCd.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aCd.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aCd.reset();
    }

    public void onChangeSkinType(int i) {
        aq.k(this, w.e.common_color_10223);
        this.aCd.m13do(i);
        aq.c(this.aCe, w.g.but_face_close);
        aq.k(this.aCe, w.e.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aCe.setVisibility(0);
        } else {
            this.aCe.setVisibility(8);
        }
    }
}
