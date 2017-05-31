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
    private j JU;
    private CommonTabHorizonScrollView aBR;
    private ImageView aBS;

    /* loaded from: classes.dex */
    public interface a {
        void eN(int i);
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
        this.JU = jVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(w.j.common_tab_widget, (ViewGroup) this, true);
        this.aBR = (CommonTabHorizonScrollView) findViewById(w.h.privilege_tab_scroll_view);
        this.aBS = (ImageView) findViewById(w.h.privilege_tab_delete);
        this.aBS.setOnClickListener(new e(this));
    }

    public void setDatas(ArrayList<b> arrayList) {
        this.aBR.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(b.C0044b c0044b) {
        this.aBR.c(c0044b);
    }

    public void setCurrentTab(int i) {
        this.aBR.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aBR.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aBR.reset();
    }

    public void onChangeSkinType(int i) {
        aq.k(this, w.e.common_color_10223);
        this.aBR.dn(i);
        aq.c(this.aBS, w.g.but_face_close);
        aq.k(this.aBS, w.e.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aBS.setVisibility(0);
        } else {
            this.aBS.setVisibility(8);
        }
    }
}
