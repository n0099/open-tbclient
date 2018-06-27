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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private EditorTools Qj;
    private CommonTabHorizonScrollView aPk;
    private ImageView aPl;

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
        this.Qj = editorTools;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(d.i.common_tab_widget, (ViewGroup) this, true);
        this.aPk = (CommonTabHorizonScrollView) findViewById(d.g.privilege_tab_scroll_view);
        this.aPl = (ImageView) findViewById(d.g.privilege_tab_delete);
        this.aPl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonTabWidgetView.this.Qj != null) {
                    CommonTabWidgetView.this.Qj.b(new com.baidu.tbadk.editortools.a(3, 3, null));
                }
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.aPk.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.aPk.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.aPk.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aPk.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aPk.reset();
    }

    public void onChangeSkinType(int i) {
        am.j(this, d.C0142d.common_color_10223);
        this.aPk.dD(i);
        am.c(this.aPl, d.f.but_face_close);
        am.j(this.aPl, d.C0142d.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aPl.setVisibility(0);
        } else {
            this.aPl.setVisibility(8);
        }
    }
}
