package com.baidu.tieba.enterForum.d;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac extends LinearLayout {
    private View YW;
    private ViewEventCenter aCS;
    private List<com.baidu.tieba.enterForum.b.d> aEJ;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aEJ = new ArrayList();
        Ga();
        addView(this.YW);
    }

    public int getItemViewCount() {
        return this.aEJ.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aCS = viewEventCenter;
    }

    public void setDataAndRefreshView(List<com.baidu.tieba.enterForum.b.d> list) {
        setData(list);
        refreshView();
    }

    private void setData(List<com.baidu.tieba.enterForum.b.d> list) {
        this.aEJ.clear();
        if (list != null) {
            this.aEJ.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.d dVar) {
        if (dVar != null) {
            ab abVar = new ab(getContext());
            abVar.setEventCenter(this.aCS);
            abVar.setData(dVar);
            addView(abVar);
        }
    }

    private void Ga() {
        this.YW = com.baidu.adp.lib.g.b.hH().inflate(getContext(), com.baidu.tieba.w.enter_forum_recommendinfo_notice, null);
        this.YW.findViewById(com.baidu.tieba.v.iv_dismiss).setOnClickListener(new ad(this));
        this.YW.findViewById(com.baidu.tieba.v.enterforum_forumrecommendinfo_change).setOnClickListener(new ae(this));
    }

    private void refreshView() {
        int size = this.aEJ.size();
        int i = 0;
        int i2 = 1;
        while (i < size) {
            com.baidu.tieba.enterForum.b.d dVar = this.aEJ.get(i);
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ab) {
                    ((ab) childAt).setData(dVar);
                }
            } else {
                a(dVar);
            }
            i++;
            i2++;
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this.YW);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof ab) {
                    ((ab) getChildAt(i2)).f(tbPageContext);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
