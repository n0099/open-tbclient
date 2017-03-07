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
    private j Ll;
    private CommonTabHorizonScrollView aBN;
    private ImageView aBO;

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
        this.Ll = jVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(w.j.common_tab_widget, (ViewGroup) this, true);
        this.aBN = (CommonTabHorizonScrollView) findViewById(w.h.privilege_tab_scroll_view);
        this.aBO = (ImageView) findViewById(w.h.privilege_tab_delete);
        this.aBO.setOnClickListener(new e(this));
    }

    public void setDatas(ArrayList<b> arrayList) {
        this.aBN.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(b.C0041b c0041b) {
        this.aBN.c(c0041b);
    }

    public void setCurrentTab(int i) {
        this.aBN.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aBN.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aBN.reset();
    }

    public void onChangeSkinType(int i) {
        aq.k(this, w.e.common_color_10223);
        this.aBN.dl(i);
        aq.c(this.aBO, w.g.but_face_close);
        aq.k(this.aBO, w.e.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aBO.setVisibility(0);
        } else {
            this.aBO.setVisibility(8);
        }
    }
}
