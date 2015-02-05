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
    protected final List<c> adI;

    public d(e<?, ?, ?> eVar) {
        super(eVar);
        this.adI = new ArrayList();
    }

    public void a(int i, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        a(dH(i), viewGroup, layoutParams);
    }

    public void a(c cVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (cVar != null && this.adI.contains(cVar)) {
            View view = cVar.getView();
            if (view == null) {
                view = cVar.wX();
                cVar.kC();
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
            cVar.wU();
        }
    }

    public void h(int i, boolean z) {
        a(dH(i), z);
    }

    public void a(c cVar, boolean z) {
        View view;
        if (cVar != null && this.adI.contains(cVar) && (view = cVar.getView()) != null) {
            if (z) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            cVar.wV();
        }
    }

    public boolean a(c cVar) {
        if (cVar == null || this.adI == null || !this.adI.add(cVar)) {
            return false;
        }
        cVar.adJ = this;
        cVar.a(this.adH);
        if (cVar.getUniqueId() == null) {
            cVar.setUniqueId(getUniqueId());
        }
        return true;
    }

    public int getChildCount() {
        if (this.adI == null) {
            return 0;
        }
        return this.adI.size();
    }

    public c dH(int i) {
        if (this.adI != null && i >= 0 && i < this.adI.size()) {
            return this.adI.get(i);
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
    public void wK() {
        super.wK();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dH = dH(i);
            if (dH != null) {
                dH.wK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void wL() {
        super.wL();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dH = dH(i);
            if (dH != null) {
                dH.wL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void wN() {
        super.wN();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dH = dH(i);
            if (dH != null) {
                dH.wN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void wP() {
        super.wP();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dH = dH(i);
            if (dH != null) {
                dH.wP();
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
    public void wS() {
        super.wS();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dH = dH(i);
            if (dH != null) {
                dH.wS();
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
    public void wU() {
        super.wU();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dH = dH(i);
            if (dH != null && dH.getView() != null && dH.getView().getParent() != null && dH.getView().getVisibility() == 0) {
                dH.wU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void wV() {
        super.wV();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dH = dH(i);
            if (dH != null && dH.getView() != null && dH.getView().getParent() != null) {
                dH.wV();
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
