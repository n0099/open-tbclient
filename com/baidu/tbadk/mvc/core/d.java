package com.baidu.tbadk.mvc.core;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class d extends c {
    protected final List<c> adL;

    public d(e<?, ?, ?> eVar) {
        super(eVar);
        this.adL = new ArrayList();
    }

    public void a(int i, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        a(dH(i), viewGroup, layoutParams);
    }

    public void a(c cVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (cVar != null && this.adL.contains(cVar)) {
            View view = cVar.getView();
            if (view == null) {
                view = cVar.xd();
                cVar.kJ();
                cVar.a(getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
            }
            if (cVar.getView().getParent() == null) {
                if (layoutParams == null) {
                    viewGroup.addView(view);
                } else {
                    viewGroup.addView(view, layoutParams);
                }
            }
            view.setVisibility(0);
            cVar.xa();
        }
    }

    public void h(int i, boolean z) {
        a(dH(i), z);
    }

    public void a(c cVar, boolean z) {
        View view;
        if (cVar != null && this.adL.contains(cVar) && (view = cVar.getView()) != null) {
            if (z) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            cVar.xb();
        }
    }

    public boolean a(c cVar) {
        if (cVar == null || this.adL == null || !this.adL.add(cVar)) {
            return false;
        }
        cVar.adM = this;
        cVar.a(this.adK);
        if (cVar.getUniqueId() == null) {
            cVar.setUniqueId(getUniqueId());
        }
        return true;
    }

    public int getChildCount() {
        if (this.adL == null) {
            return 0;
        }
        return this.adL.size();
    }

    public c dH(int i) {
        if (this.adL != null && i >= 0 && i < this.adL.size()) {
            return this.adL.get(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void i(Bundle bundle) {
        super.i(bundle);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dH = dH(i);
            if (dH != null) {
                dH.i(bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void wQ() {
        super.wQ();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dH = dH(i);
            if (dH != null) {
                dH.wQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void wR() {
        super.wR();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dH = dH(i);
            if (dH != null) {
                dH.wR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void wT() {
        super.wT();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dH = dH(i);
            if (dH != null) {
                dH.wT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void wV() {
        super.wV();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dH = dH(i);
            if (dH != null) {
                dH.wV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void wX() {
        super.wX();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dH = dH(i);
            if (dH != null) {
                dH.wX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void wY() {
        super.wY();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dH = dH(i);
            if (dH != null) {
                dH.wY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public boolean onActivityResult(int i, int i2, Intent intent) {
        boolean onActivityResult = super.onActivityResult(i, i2, intent);
        int childCount = getChildCount();
        boolean z = onActivityResult;
        for (int i3 = 0; i3 < childCount; i3++) {
            c dH = dH(i3);
            if (dH != null && (z = dH.onActivityResult(i, i2, intent))) {
                break;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void xa() {
        super.xa();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dH = dH(i);
            if (dH != null && dH.getView() != null && dH.getView().getParent() != null && dH.getView().getVisibility() == 0) {
                dH.xa();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void xb() {
        super.xb();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dH = dH(i);
            if (dH != null && dH.getView() != null && dH.getView().getParent() != null) {
                dH.xb();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dH = dH(i);
            if (dH != null) {
                dH.onSaveInstanceState(bundle);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        super.a(tbPageContext, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            c dH = dH(i2);
            if (dH != null && dH.getView() != null) {
                dH.a(tbPageContext, i);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(e<?, ?, ?> eVar) {
        super.a(eVar);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dH = dH(i);
            if (dH != null) {
                dH.a(eVar);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dH = dH(i);
            if (dH != null && dH.getUniqueId() == null) {
                dH.setUniqueId(getUniqueId());
            }
        }
    }
}
