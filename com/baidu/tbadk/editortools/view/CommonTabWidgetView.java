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
    private EditorTools FO;
    private CommonTabHorizonScrollView dAf;
    private ImageView dAg;

    /* loaded from: classes.dex */
    public interface a {
        void mC(int i);
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
        this.FO = editorTools;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_widget, (ViewGroup) this, true);
        this.dAf = (CommonTabHorizonScrollView) findViewById(R.id.privilege_tab_scroll_view);
        this.dAg = (ImageView) findViewById(R.id.privilege_tab_delete);
        this.dAg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonTabWidgetView.this.FO != null) {
                    CommonTabWidgetView.this.FO.b(new com.baidu.tbadk.editortools.a(3, 3, null));
                }
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.dAf.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.dAf.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.dAf.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dAf.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.dAf.reset();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, R.color.common_color_10223);
        this.dAf.onChangeSkin(i);
        am.setImageResource(this.dAg, R.drawable.but_face_close);
        am.setBackgroundColor(this.dAg, R.color.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.dAg.setVisibility(0);
        } else {
            this.dAg.setVisibility(8);
        }
    }
}
