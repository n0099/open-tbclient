package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private EditorTools SG;
    private ImageView aSA;
    private CommonTabHorizonScrollView aSz;

    /* loaded from: classes.dex */
    public interface a {
        void fk(int i);
    }

    public CommonTabWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CommonTabWidgetView(Context context) {
        super(context);
        init(context);
    }

    public void setEditorTools(EditorTools editorTools) {
        this.SG = editorTools;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(e.h.common_tab_widget, (ViewGroup) this, true);
        this.aSz = (CommonTabHorizonScrollView) findViewById(e.g.privilege_tab_scroll_view);
        this.aSA = (ImageView) findViewById(e.g.privilege_tab_delete);
        this.aSA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonTabWidgetView.this.SG != null) {
                    CommonTabWidgetView.this.SG.b(new com.baidu.tbadk.editortools.a(3, 3, null));
                }
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.aSz.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.aSz.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.aSz.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aSz.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aSz.reset();
    }

    public void onChangeSkinType(int i) {
        al.j(this, e.d.common_color_10223);
        this.aSz.dQ(i);
        al.c(this.aSA, e.f.but_face_close);
        al.j(this.aSA, e.d.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aSA.setVisibility(0);
        } else {
            this.aSA.setVisibility(8);
        }
    }
}
