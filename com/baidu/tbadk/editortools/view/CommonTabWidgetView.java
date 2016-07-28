package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private l Cw;
    private CommonTabHorizonScrollView auq;
    private ImageView aur;

    /* loaded from: classes.dex */
    public interface a {
        void eA(int i);
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
        this.Cw = lVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(u.h.common_tab_widget, (ViewGroup) this, true);
        this.auq = (CommonTabHorizonScrollView) findViewById(u.g.privilege_tab_scroll_view);
        this.aur = (ImageView) findViewById(u.g.privilege_tab_delete);
        this.aur.setOnClickListener(new e(this));
    }

    public void setDatas(ArrayList<b> arrayList) {
        this.auq.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(b.C0042b c0042b) {
        this.auq.c(c0042b);
    }

    public void setCurrentTab(int i) {
        this.auq.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.auq.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.auq.reset();
    }

    public void onChangeSkinType(int i) {
        av.l(this, u.d.common_color_10223);
        this.auq.cX(i);
        av.c(this.aur, u.f.but_face_close);
        av.l(this.aur, u.d.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.aur.setVisibility(0);
        } else {
            this.aur.setVisibility(8);
        }
    }
}
