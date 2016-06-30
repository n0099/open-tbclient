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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private l BW;
    private CommonTabHorizonScrollView atB;
    private ImageView atC;

    /* loaded from: classes.dex */
    public interface a {
        void eA(int i);
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
        this.BW = lVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(u.h.common_tab_widget, (ViewGroup) this, true);
        this.atB = (CommonTabHorizonScrollView) findViewById(u.g.privilege_tab_scroll_view);
        this.atC = (ImageView) findViewById(u.g.privilege_tab_delete);
        this.atC.setOnClickListener(new e(this));
    }

    public void setDatas(ArrayList<b> arrayList) {
        this.atB.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(b.C0041b c0041b) {
        this.atB.c(c0041b);
    }

    public void setCurrentTab(int i) {
        this.atB.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.atB.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.atB.reset();
    }

    public void onChangeSkinType(int i) {
        av.l(this, u.d.common_color_10223);
        this.atB.cX(i);
        av.c(this.atC, u.f.but_face_close);
        av.l(this.atC, u.d.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.atC.setVisibility(0);
        } else {
            this.atC.setVisibility(8);
        }
    }
}
