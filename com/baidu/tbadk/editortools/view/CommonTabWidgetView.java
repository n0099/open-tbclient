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
    private j KA;
    private CommonTabHorizonScrollView asT;
    private ImageView asU;

    /* loaded from: classes.dex */
    public interface a {
        void ea(int i);
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
        this.KA = jVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(i.g.common_tab_widget, (ViewGroup) this, true);
        this.asT = (CommonTabHorizonScrollView) findViewById(i.f.privilege_tab_scroll_view);
        this.asU = (ImageView) findViewById(i.f.privilege_tab_delete);
        this.asU.setOnClickListener(new d(this));
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.asT.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.asT.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.asT.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.asT.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.asT.reset();
    }

    public void onChangeSkinType(int i) {
        an.j(this, i.c.editor_tool_container_bg);
        this.asT.cP(i);
        an.c(this.asU, i.e.but_face_close);
        an.j(this.asU, i.c.emotion_delete_bg);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.asU.setVisibility(0);
        } else {
            this.asU.setVisibility(8);
        }
    }
}
