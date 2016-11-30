package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private l EL;
    private CommonTabHorizonScrollView axR;
    private ImageView axS;

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

    public void setEditorTools(l lVar) {
        this.EL = lVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(r.h.common_tab_widget, (ViewGroup) this, true);
        this.axR = (CommonTabHorizonScrollView) findViewById(r.g.privilege_tab_scroll_view);
        this.axS = (ImageView) findViewById(r.g.privilege_tab_delete);
        this.axS.setOnClickListener(new e(this));
    }

    public void setDatas(ArrayList<b> arrayList) {
        this.axR.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(b.C0042b c0042b) {
        this.axR.c(c0042b);
    }

    public void setCurrentTab(int i) {
        this.axR.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.axR.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.axR.reset();
    }

    public void onChangeSkinType(int i) {
        at.l(this, r.d.common_color_10223);
        this.axR.dm(i);
        at.c(this.axS, r.f.but_face_close);
        at.l(this.axS, r.d.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.axS.setVisibility(0);
        } else {
            this.axS.setVisibility(8);
        }
    }
}
