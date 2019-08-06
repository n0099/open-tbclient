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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private EditorTools TU;
    private CommonTabHorizonScrollView cvl;
    private ImageView cvm;

    /* loaded from: classes.dex */
    public interface a {
        void kB(int i);
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
        this.TU = editorTools;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_widget, (ViewGroup) this, true);
        this.cvl = (CommonTabHorizonScrollView) findViewById(R.id.privilege_tab_scroll_view);
        this.cvm = (ImageView) findViewById(R.id.privilege_tab_delete);
        this.cvm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonTabWidgetView.this.TU != null) {
                    CommonTabWidgetView.this.TU.b(new com.baidu.tbadk.editortools.a(3, 3, null));
                }
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.cvl.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.cvl.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.cvl.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.cvl.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.cvl.reset();
    }

    public void onChangeSkinType(int i) {
        am.l(this, R.color.common_color_10223);
        this.cvl.jd(i);
        am.c(this.cvm, (int) R.drawable.but_face_close);
        am.l(this.cvm, R.color.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.cvm.setVisibility(0);
        } else {
            this.cvm.setVisibility(8);
        }
    }
}
