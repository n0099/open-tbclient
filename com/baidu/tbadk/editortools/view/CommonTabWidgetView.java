package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private j EM;
    private CommonTabHorizonScrollView axo;
    private ImageView axp;

    /* loaded from: classes.dex */
    public interface a {
        void eR(int i);
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
        this.EM = jVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(r.h.common_tab_widget, (ViewGroup) this, true);
        this.axo = (CommonTabHorizonScrollView) findViewById(r.g.privilege_tab_scroll_view);
        this.axp = (ImageView) findViewById(r.g.privilege_tab_delete);
        this.axp.setOnClickListener(new e(this));
    }

    public void setDatas(ArrayList<b> arrayList) {
        this.axo.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(b.C0042b c0042b) {
        this.axo.c(c0042b);
    }

    public void setCurrentTab(int i) {
        this.axo.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.axo.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.axo.reset();
    }

    public void onChangeSkinType(int i) {
        ar.l(this, r.d.common_color_10223);
        this.axo.m13do(i);
        ar.c(this.axp, r.f.but_face_close);
        ar.l(this.axp, r.d.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.axp.setVisibility(0);
        } else {
            this.axp.setVisibility(8);
        }
    }
}
