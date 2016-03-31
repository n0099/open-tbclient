package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private l LE;
    private CommonTabHorizonScrollView awK;
    private ImageView awL;

    /* loaded from: classes.dex */
    public interface a {
        void eQ(int i);
    }

    public CommonTabWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CommonTabWidgetView(Context context) {
        super(context);
        init(context);
    }

    public void setEditorTools(l lVar) {
        this.LE = lVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(t.h.common_tab_widget, (ViewGroup) this, true);
        this.awK = (CommonTabHorizonScrollView) findViewById(t.g.privilege_tab_scroll_view);
        this.awL = (ImageView) findViewById(t.g.privilege_tab_delete);
        this.awL.setOnClickListener(new e(this));
    }

    public void setDatas(ArrayList<b> arrayList) {
        this.awK.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(b.C0050b c0050b) {
        this.awK.c(c0050b);
    }

    public void setCurrentTab(int i) {
        this.awK.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.awK.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.awK.reset();
    }

    public void onChangeSkinType(int i) {
        at.l(this, t.d.editor_tool_container_bg);
        this.awK.dn(i);
        at.c(this.awL, t.f.but_face_close);
        at.l(this.awL, t.d.emotion_delete_bg);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.awL.setVisibility(0);
        } else {
            this.awL.setVisibility(8);
        }
    }
}
