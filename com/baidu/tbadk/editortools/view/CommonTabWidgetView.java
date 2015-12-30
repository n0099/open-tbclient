package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private k Li;
    private CommonTabHorizonScrollView avl;
    private ImageView avm;

    /* loaded from: classes.dex */
    public interface a {
        void eq(int i);
    }

    public CommonTabWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CommonTabWidgetView(Context context) {
        super(context);
        init(context);
    }

    public void setEditorTools(k kVar) {
        this.Li = kVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(n.h.common_tab_widget, (ViewGroup) this, true);
        this.avl = (CommonTabHorizonScrollView) findViewById(n.g.privilege_tab_scroll_view);
        this.avm = (ImageView) findViewById(n.g.privilege_tab_delete);
        this.avm.setOnClickListener(new d(this));
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.avl.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.avl.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.avl.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.avl.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.avl.reset();
    }

    public void onChangeSkinType(int i) {
        as.j(this, n.d.editor_tool_container_bg);
        this.avl.cR(i);
        as.c(this.avm, n.f.but_face_close);
        as.j(this.avm, n.d.emotion_delete_bg);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.avm.setVisibility(0);
        } else {
            this.avm.setVisibility(8);
        }
    }
}
