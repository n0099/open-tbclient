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
    private i axH;
    private CommonTabHorizonScrollView bvu;
    private ImageView bvv;

    /* loaded from: classes.dex */
    public interface a {
        void hT(int i);
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
        this.axH = iVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(d.h.common_tab_widget, (ViewGroup) this, true);
        this.bvu = (CommonTabHorizonScrollView) findViewById(d.g.privilege_tab_scroll_view);
        this.bvv = (ImageView) findViewById(d.g.privilege_tab_delete);
        this.bvv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonTabWidgetView.this.axH != null) {
                    CommonTabWidgetView.this.axH.b(new com.baidu.tbadk.editortools.a(3, 3, null));
                }
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.bvu.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.bvu.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.bvu.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.bvu.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.bvu.reset();
    }

    public void onChangeSkinType(int i) {
        aj.t(this, d.C0141d.common_color_10223);
        this.bvu.gB(i);
        aj.c(this.bvv, d.f.but_face_close);
        aj.t(this.bvv, d.C0141d.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.bvv.setVisibility(0);
        } else {
            this.bvv.setVisibility(8);
        }
    }
}
