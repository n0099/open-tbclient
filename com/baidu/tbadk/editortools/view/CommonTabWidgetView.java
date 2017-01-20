package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabWidgetView extends LinearLayout {
    private j DX;
    private CommonTabHorizonScrollView aws;
    private ImageView awt;

    /* loaded from: classes.dex */
    public interface a {
        void eS(int i);
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
        this.DX = jVar;
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(r.j.common_tab_widget, (ViewGroup) this, true);
        this.aws = (CommonTabHorizonScrollView) findViewById(r.h.privilege_tab_scroll_view);
        this.awt = (ImageView) findViewById(r.h.privilege_tab_delete);
        this.awt.setOnClickListener(new e(this));
    }

    public void setDatas(ArrayList<b> arrayList) {
        this.aws.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(b.C0042b c0042b) {
        this.aws.c(c0042b);
    }

    public void setCurrentTab(int i) {
        this.aws.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.aws.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.aws.reset();
    }

    public void onChangeSkinType(int i) {
        ap.k(this, r.e.common_color_10223);
        this.aws.dp(i);
        ap.c(this.awt, r.g.but_face_close);
        ap.k(this.awt, r.e.common_color_10224);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.awt.setVisibility(0);
        } else {
            this.awt.setVisibility(8);
        }
    }
}
