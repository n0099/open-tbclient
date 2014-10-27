package com.baidu.tieba.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PrivilegeTabWidgetView extends LinearLayout {
    private com.baidu.tbadk.editortool.w RC;
    private PrivilegeTabHorizonScrollView arM;
    private ImageView arN;

    public PrivilegeTabWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public PrivilegeTabWidgetView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setVisibility(8);
        removeAllViews();
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.w.privilege_tab_widget, this, true);
        this.arM = (PrivilegeTabHorizonScrollView) findViewById(com.baidu.tieba.v.privilege_tab_scroll_view);
        this.arN = (ImageView) findViewById(com.baidu.tieba.v.privilege_tab_delete);
        this.arN.setOnClickListener(new au(this));
    }

    public void setDatas(ArrayList<an> arrayList) {
        this.arM.setDatas(arrayList);
        if (arrayList == null || arrayList.size() <= 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(ap apVar) {
        this.arM.c(apVar);
    }

    public void setCurrentTab(int i) {
        this.arM.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(av avVar) {
        this.arM.setOnTabSelectedListener(avVar);
    }

    public void reset() {
        this.arM.reset();
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.util.aw.i(this, com.baidu.tieba.s.editor_tool_container_bg);
        getContext().getResources();
        this.arM.bN(i);
        com.baidu.tbadk.core.util.aw.c(this.arN, com.baidu.tieba.u.but_face_close);
        com.baidu.tbadk.core.util.aw.i(this.arN, com.baidu.tieba.s.emotion_delete_bg);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.arN.setVisibility(0);
        } else {
            this.arN.setVisibility(8);
        }
    }

    public void setOnDataSelected(com.baidu.tbadk.editortool.w wVar) {
        this.RC = wVar;
    }
}
