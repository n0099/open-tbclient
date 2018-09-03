package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private EditorTools Qg;
    private CommonTabHorizonScrollView aPh;
    private ImageView aPi;

    /* loaded from: classes.dex */
    public interface a {
        void eY(int i);
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
        this.Qg = editorTools;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(f.h.common_tab_widget, (ViewGroup) this, true);
        this.aPh = (CommonTabHorizonScrollView) findViewById(f.g.privilege_tab_scroll_view);
        this.aPi = (ImageView) findViewById(f.g.privilege_tab_delete);
        this.aPi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonTabWidgetView.this.Qg != null) {
                    CommonTabWidgetView.this.Qg.b(new com.baidu.tbadk.editortools.a(3, 3, null));
                }
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.aPh.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.aPh.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.aPh.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aPh.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aPh.reset();
    }

    public void onChangeSkinType(int i) {
        am.j(this, f.d.common_color_10223);
        this.aPh.dF(i);
        am.c(this.aPi, f.C0146f.but_face_close);
        am.j(this.aPi, f.d.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aPi.setVisibility(0);
        } else {
            this.aPi.setVisibility(8);
        }
    }
}
