package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private i IS;
    private CommonTabHorizonScrollView aFh;
    private ImageView aFi;

    /* loaded from: classes.dex */
    public interface a {
        void fb(int i);
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
        this.IS = iVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(d.h.common_tab_widget, (ViewGroup) this, true);
        this.aFh = (CommonTabHorizonScrollView) findViewById(d.g.privilege_tab_scroll_view);
        this.aFi = (ImageView) findViewById(d.g.privilege_tab_delete);
        this.aFi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonTabWidgetView.this.IS != null) {
                    CommonTabWidgetView.this.IS.b(new com.baidu.tbadk.editortools.a(3, 3, null));
                }
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.aFh.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.aFh.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.aFh.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aFh.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aFh.reset();
    }

    public void onChangeSkinType(int i) {
        aj.k(this, d.C0095d.common_color_10223);
        this.aFh.dE(i);
        aj.c(this.aFi, d.f.but_face_close);
        aj.k(this.aFi, d.C0095d.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aFi.setVisibility(0);
        } else {
            this.aFi.setVisibility(8);
        }
    }
}
