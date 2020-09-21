package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private EditorTools aaS;
    private CommonTabHorizonScrollView eQF;
    private ImageView eQG;

    /* loaded from: classes.dex */
    public interface a {
        void qF(int i);
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
        this.aaS = editorTools;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_widget, (ViewGroup) this, true);
        this.eQF = (CommonTabHorizonScrollView) findViewById(R.id.privilege_tab_scroll_view);
        this.eQG = (ImageView) findViewById(R.id.privilege_tab_delete);
        this.eQG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonTabWidgetView.this.aaS != null) {
                    CommonTabWidgetView.this.aaS.b(new com.baidu.tbadk.editortools.a(3, 3, null));
                }
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.eQF.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.eQF.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.eQF.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.eQF.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.eQF.reset();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.common_color_10223, i);
        this.eQF.onChangeSkin(i);
        ap.setImageResource(this.eQG, R.drawable.but_face_close, i);
        ap.setBackgroundColor(this.eQG, R.color.common_color_10224, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.eQG.setVisibility(0);
        } else {
            this.eQG.setVisibility(8);
        }
    }
}
