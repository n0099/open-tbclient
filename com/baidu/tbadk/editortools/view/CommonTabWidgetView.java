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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private EditorTools Qh;
    private CommonTabHorizonScrollView aOo;
    private ImageView aOp;

    /* loaded from: classes.dex */
    public interface a {
        void eX(int i);
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
        this.Qh = editorTools;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(d.i.common_tab_widget, (ViewGroup) this, true);
        this.aOo = (CommonTabHorizonScrollView) findViewById(d.g.privilege_tab_scroll_view);
        this.aOp = (ImageView) findViewById(d.g.privilege_tab_delete);
        this.aOp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonTabWidgetView.this.Qh != null) {
                    CommonTabWidgetView.this.Qh.b(new com.baidu.tbadk.editortools.a(3, 3, null));
                }
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.aOo.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.aOo.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.aOo.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aOo.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aOo.reset();
    }

    public void onChangeSkinType(int i) {
        al.j(this, d.C0141d.common_color_10223);
        this.aOo.dC(i);
        al.c(this.aOp, d.f.but_face_close);
        al.j(this.aOp, d.C0141d.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aOp.setVisibility(0);
        } else {
            this.aOp.setVisibility(8);
        }
    }
}
