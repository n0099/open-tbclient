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
    private EditorTools acZ;
    private CommonTabHorizonScrollView fHx;
    private ImageView fHy;

    /* loaded from: classes.dex */
    public interface a {
        void sJ(int i);
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
        this.acZ = editorTools;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_widget, (ViewGroup) this, true);
        this.fHx = (CommonTabHorizonScrollView) findViewById(R.id.privilege_tab_scroll_view);
        this.fHy = (ImageView) findViewById(R.id.privilege_tab_delete);
        this.fHy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonTabWidgetView.this.acZ != null) {
                    CommonTabWidgetView.this.acZ.b(new com.baidu.tbadk.editortools.a(3, 3, null));
                }
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.fHx.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.fHx.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.fHx.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.fHx.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.fHx.reset();
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this, R.color.common_color_10223, i);
        this.fHx.onChangeSkin(i);
        ao.setImageResource(this.fHy, R.drawable.but_face_close, i);
        ao.setBackgroundColor(this.fHy, R.color.common_color_10224, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.fHy.setVisibility(0);
        } else {
            this.fHy.setVisibility(8);
        }
    }
}
