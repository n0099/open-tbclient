package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private j JT;
    private CommonTabHorizonScrollView aCU;
    private ImageView aCV;

    /* loaded from: classes.dex */
    public interface a {
        void eP(int i);
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
        this.JT = jVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(w.j.common_tab_widget, (ViewGroup) this, true);
        this.aCU = (CommonTabHorizonScrollView) findViewById(w.h.privilege_tab_scroll_view);
        this.aCV = (ImageView) findViewById(w.h.privilege_tab_delete);
        this.aCV.setOnClickListener(new e(this));
    }

    public void setDatas(ArrayList<b> arrayList) {
        this.aCU.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(b.C0046b c0046b) {
        this.aCU.c(c0046b);
    }

    public void setCurrentTab(int i) {
        this.aCU.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aCU.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aCU.reset();
    }

    public void onChangeSkinType(int i) {
        as.k(this, w.e.common_color_10223);
        this.aCU.dp(i);
        as.c(this.aCV, w.g.but_face_close);
        as.k(this.aCV, w.e.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aCV.setVisibility(0);
        } else {
            this.aCV.setVisibility(8);
        }
    }
}
