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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private EditorTools TB;
    private CommonTabHorizonScrollView ctO;
    private ImageView ctP;

    /* loaded from: classes.dex */
    public interface a {
        void ku(int i);
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
        this.TB = editorTools;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_widget, (ViewGroup) this, true);
        this.ctO = (CommonTabHorizonScrollView) findViewById(R.id.privilege_tab_scroll_view);
        this.ctP = (ImageView) findViewById(R.id.privilege_tab_delete);
        this.ctP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonTabWidgetView.this.TB != null) {
                    CommonTabWidgetView.this.TB.b(new com.baidu.tbadk.editortools.a(3, 3, null));
                }
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.ctO.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.ctO.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.ctO.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.ctO.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.ctO.reset();
    }

    public void onChangeSkinType(int i) {
        al.l(this, R.color.common_color_10223);
        this.ctO.iW(i);
        al.c(this.ctP, (int) R.drawable.but_face_close);
        al.l(this.ctP, R.color.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.ctP.setVisibility(0);
        } else {
            this.ctP.setVisibility(8);
        }
    }
}
