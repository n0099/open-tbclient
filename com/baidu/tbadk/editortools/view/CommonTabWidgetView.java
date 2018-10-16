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
    private EditorTools SY;
    private CommonTabHorizonScrollView aWZ;
    private ImageView aXa;

    /* loaded from: classes.dex */
    public interface a {
        void ft(int i);
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
        this.SY = editorTools;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(e.h.common_tab_widget, (ViewGroup) this, true);
        this.aWZ = (CommonTabHorizonScrollView) findViewById(e.g.privilege_tab_scroll_view);
        this.aXa = (ImageView) findViewById(e.g.privilege_tab_delete);
        this.aXa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonTabWidgetView.this.SY != null) {
                    CommonTabWidgetView.this.SY.b(new com.baidu.tbadk.editortools.a(3, 3, null));
                }
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.aWZ.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.aWZ.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.aWZ.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aWZ.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aWZ.reset();
    }

    public void onChangeSkinType(int i) {
        al.j(this, e.d.common_color_10223);
        this.aWZ.ea(i);
        al.c(this.aXa, e.f.but_face_close);
        al.j(this.aXa, e.d.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aXa.setVisibility(0);
        } else {
            this.aXa.setVisibility(8);
        }
    }
}
