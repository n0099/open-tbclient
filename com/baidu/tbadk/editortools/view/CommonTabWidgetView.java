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
    private i axO;
    private CommonTabHorizonScrollView bsZ;
    private ImageView bta;

    /* loaded from: classes.dex */
    public interface a {
        void hZ(int i);
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
        this.axO = iVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(d.h.common_tab_widget, (ViewGroup) this, true);
        this.bsZ = (CommonTabHorizonScrollView) findViewById(d.g.privilege_tab_scroll_view);
        this.bta = (ImageView) findViewById(d.g.privilege_tab_delete);
        this.bta.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonTabWidgetView.this.axO != null) {
                    CommonTabWidgetView.this.axO.b(new com.baidu.tbadk.editortools.a(3, 3, null));
                }
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.bsZ.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.bsZ.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.bsZ.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.bsZ.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.bsZ.reset();
    }

    public void onChangeSkinType(int i) {
        aj.t(this, d.C0108d.common_color_10223);
        this.bsZ.gC(i);
        aj.c(this.bta, d.f.but_face_close);
        aj.t(this.bta, d.C0108d.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.bta.setVisibility(0);
        } else {
            this.bta.setVisibility(8);
        }
    }
}
