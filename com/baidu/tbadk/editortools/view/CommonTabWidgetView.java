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
    private i Lt;
    private CommonTabHorizonScrollView aFk;
    private ImageView aFl;

    /* loaded from: classes.dex */
    public interface a {
        void eT(int i);
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
        this.Lt = iVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(d.j.common_tab_widget, (ViewGroup) this, true);
        this.aFk = (CommonTabHorizonScrollView) findViewById(d.h.privilege_tab_scroll_view);
        this.aFl = (ImageView) findViewById(d.h.privilege_tab_delete);
        this.aFl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonTabWidgetView.this.Lt != null) {
                    CommonTabWidgetView.this.Lt.b(new com.baidu.tbadk.editortools.a(3, 3, null));
                }
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.aFk.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.aFk.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.aFk.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aFk.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aFk.reset();
    }

    public void onChangeSkinType(int i) {
        ai.k(this, d.e.common_color_10223);
        this.aFk.dt(i);
        ai.c(this.aFl, d.g.but_face_close);
        ai.k(this.aFl, d.e.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aFl.setVisibility(0);
        } else {
            this.aFl.setVisibility(8);
        }
    }
}
