package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private i JT;
    private CommonTabHorizonScrollView aDT;
    private ImageView aDU;

    /* loaded from: classes.dex */
    public interface a {
        void eR(int i);
    }

    public CommonTabWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CommonTabWidgetView(Context context) {
        super(context);
        init(context);
    }

    public void setEditorTools(i iVar) {
        this.JT = iVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(d.j.common_tab_widget, (ViewGroup) this, true);
        this.aDT = (CommonTabHorizonScrollView) findViewById(d.h.privilege_tab_scroll_view);
        this.aDU = (ImageView) findViewById(d.h.privilege_tab_delete);
        this.aDU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonTabWidgetView.this.JT != null) {
                    CommonTabWidgetView.this.JT.b(new com.baidu.tbadk.editortools.a(3, 3, null));
                }
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.aDT.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.aDT.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.aDT.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aDT.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aDT.reset();
    }

    public void onChangeSkinType(int i) {
        ai.k(this, d.e.common_color_10223);
        this.aDT.dr(i);
        ai.c(this.aDU, d.g.but_face_close);
        ai.k(this.aDU, d.e.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aDU.setVisibility(0);
        } else {
            this.aDU.setVisibility(8);
        }
    }
}
