package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private l EJ;
    private CommonTabHorizonScrollView axa;
    private ImageView axb;

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

    public void setEditorTools(l lVar) {
        this.EJ = lVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(r.h.common_tab_widget, (ViewGroup) this, true);
        this.axa = (CommonTabHorizonScrollView) findViewById(r.g.privilege_tab_scroll_view);
        this.axb = (ImageView) findViewById(r.g.privilege_tab_delete);
        this.axb.setOnClickListener(new e(this));
    }

    public void setDatas(ArrayList<b> arrayList) {
        this.axa.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(b.C0042b c0042b) {
        this.axa.c(c0042b);
    }

    public void setCurrentTab(int i) {
        this.axa.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.axa.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.axa.reset();
    }

    public void onChangeSkinType(int i) {
        av.l(this, r.d.common_color_10223);
        this.axa.dl(i);
        av.c(this.axb, r.f.but_face_close);
        av.l(this.axb, r.d.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.axb.setVisibility(0);
        } else {
            this.axb.setVisibility(8);
        }
    }
}
