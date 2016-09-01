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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private l EJ;
    private CommonTabHorizonScrollView axx;
    private ImageView axy;

    /* loaded from: classes.dex */
    public interface a {
        void eO(int i);
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
        LayoutInflater.from(context).inflate(t.h.common_tab_widget, (ViewGroup) this, true);
        this.axx = (CommonTabHorizonScrollView) findViewById(t.g.privilege_tab_scroll_view);
        this.axy = (ImageView) findViewById(t.g.privilege_tab_delete);
        this.axy.setOnClickListener(new e(this));
    }

    public void setDatas(ArrayList<b> arrayList) {
        this.axx.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(b.C0042b c0042b) {
        this.axx.c(c0042b);
    }

    public void setCurrentTab(int i) {
        this.axx.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.axx.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.axx.reset();
    }

    public void onChangeSkinType(int i) {
        av.l(this, t.d.common_color_10223);
        this.axx.dl(i);
        av.c(this.axy, t.f.but_face_close);
        av.l(this.axy, t.d.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.axy.setVisibility(0);
        } else {
            this.axy.setVisibility(8);
        }
    }
}
