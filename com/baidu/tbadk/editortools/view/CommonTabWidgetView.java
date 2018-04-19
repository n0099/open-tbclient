package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private EditorTools JS;
    private CommonTabHorizonScrollView aFR;
    private ImageView aFS;

    /* loaded from: classes.dex */
    public interface a {
        void eS(int i);
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
        this.JS = editorTools;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(d.i.common_tab_widget, (ViewGroup) this, true);
        this.aFR = (CommonTabHorizonScrollView) findViewById(d.g.privilege_tab_scroll_view);
        this.aFS = (ImageView) findViewById(d.g.privilege_tab_delete);
        this.aFS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (CommonTabWidgetView.this.JS != null) {
                    CommonTabWidgetView.this.JS.b(new com.baidu.tbadk.editortools.a(3, 3, null));
                }
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.aFR.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.aFR.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.aFR.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aFR.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aFR.reset();
    }

    public void onChangeSkinType(int i) {
        ak.j(this, d.C0126d.common_color_10223);
        this.aFR.dz(i);
        ak.c(this.aFS, d.f.but_face_close);
        ak.j(this.aFS, d.C0126d.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aFS.setVisibility(0);
        } else {
            this.aFS.setVisibility(8);
        }
    }
}
