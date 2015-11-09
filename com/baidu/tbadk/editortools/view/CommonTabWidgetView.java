package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private j KB;
    private CommonTabHorizonScrollView arG;
    private ImageView arH;

    /* loaded from: classes.dex */
    public interface a {
        void ei(int i);
    }

    public CommonTabWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CommonTabWidgetView(Context context) {
        super(context);
        init(context);
    }

    public void setEditorTools(j jVar) {
        this.KB = jVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(i.g.common_tab_widget, (ViewGroup) this, true);
        this.arG = (CommonTabHorizonScrollView) findViewById(i.f.privilege_tab_scroll_view);
        this.arH = (ImageView) findViewById(i.f.privilege_tab_delete);
        this.arH.setOnClickListener(new d(this));
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.arG.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.arG.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.arG.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.arG.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.arG.reset();
    }

    public void onChangeSkinType(int i) {
        an.j(this, i.c.editor_tool_container_bg);
        this.arG.cP(i);
        an.c(this.arH, i.e.but_face_close);
        an.j(this.arH, i.c.emotion_delete_bg);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.arH.setVisibility(0);
        } else {
            this.arH.setVisibility(8);
        }
    }
}
