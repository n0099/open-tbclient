package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private EditorTools acX;
    private CommonTabHorizonScrollView fCQ;
    private ImageView fCR;

    /* loaded from: classes.dex */
    public interface a {
        void rd(int i);
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
        this.acX = editorTools;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_widget, (ViewGroup) this, true);
        this.fCQ = (CommonTabHorizonScrollView) findViewById(R.id.privilege_tab_scroll_view);
        this.fCR = (ImageView) findViewById(R.id.privilege_tab_delete);
        this.fCR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonTabWidgetView.this.acX != null) {
                    CommonTabWidgetView.this.acX.b(new com.baidu.tbadk.editortools.a(3, 3, null));
                }
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.fCQ.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.fCQ.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.fCQ.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.fCQ.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.fCQ.reset();
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this, R.color.common_color_10223, i);
        this.fCQ.onChangeSkin(i);
        ao.setImageResource(this.fCR, R.drawable.but_face_close, i);
        ao.setBackgroundColor(this.fCR, R.color.common_color_10224, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.fCR.setVisibility(0);
        } else {
            this.fCR.setVisibility(8);
        }
    }
}
