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
    private EditorTools abj;
    private CommonTabHorizonScrollView fcN;
    private ImageView fcO;

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
        this.abj = editorTools;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_widget, (ViewGroup) this, true);
        this.fcN = (CommonTabHorizonScrollView) findViewById(R.id.privilege_tab_scroll_view);
        this.fcO = (ImageView) findViewById(R.id.privilege_tab_delete);
        this.fcO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonTabWidgetView.this.abj != null) {
                    CommonTabWidgetView.this.abj.b(new com.baidu.tbadk.editortools.a(3, 3, null));
                }
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.fcN.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.fcN.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.fcN.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.fcN.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.fcN.reset();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.common_color_10223, i);
        this.fcN.onChangeSkin(i);
        ap.setImageResource(this.fcO, R.drawable.but_face_close, i);
        ap.setBackgroundColor(this.fcO, R.color.common_color_10224, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.fcO.setVisibility(0);
        } else {
            this.fcO.setVisibility(8);
        }
    }
}
