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
    private EditorTools VO;
    private CommonTabHorizonScrollView clG;
    private ImageView clH;

    /* loaded from: classes.dex */
    public interface a {
        void jG(int i);
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
        this.VO = editorTools;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(d.h.common_tab_widget, (ViewGroup) this, true);
        this.clG = (CommonTabHorizonScrollView) findViewById(d.g.privilege_tab_scroll_view);
        this.clH = (ImageView) findViewById(d.g.privilege_tab_delete);
        this.clH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonTabWidgetView.this.VO != null) {
                    CommonTabWidgetView.this.VO.b(new com.baidu.tbadk.editortools.a(3, 3, null));
                }
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.clG.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.clG.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.clG.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.clG.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.clG.reset();
    }

    public void onChangeSkinType(int i) {
        al.l(this, d.C0277d.common_color_10223);
        this.clG.ii(i);
        al.c(this.clH, d.f.but_face_close);
        al.l(this.clH, d.C0277d.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.clH.setVisibility(0);
        } else {
            this.clH.setVisibility(8);
        }
    }
}
