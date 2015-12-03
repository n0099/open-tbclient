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
    private k KS;
    private CommonTabHorizonScrollView atH;
    private ImageView atI;

    /* loaded from: classes.dex */
    public interface a {
        void ew(int i);
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
        this.KS = kVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(n.g.common_tab_widget, (ViewGroup) this, true);
        this.atH = (CommonTabHorizonScrollView) findViewById(n.f.privilege_tab_scroll_view);
        this.atI = (ImageView) findViewById(n.f.privilege_tab_delete);
        this.atI.setOnClickListener(new d(this));
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.view.a> arrayList) {
        this.atH.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(a.b bVar) {
        this.atH.c(bVar);
    }

    public void setCurrentTab(int i) {
        this.atH.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.atH.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.atH.reset();
    }

    public void onChangeSkinType(int i) {
        as.j(this, n.c.editor_tool_container_bg);
        this.atH.cX(i);
        as.c(this.atI, n.e.but_face_close);
        as.j(this.atI, n.c.emotion_delete_bg);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.atI.setVisibility(0);
        } else {
            this.atI.setVisibility(8);
        }
    }
}
