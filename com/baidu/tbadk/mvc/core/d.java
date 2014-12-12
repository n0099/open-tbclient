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
    protected final List<c> ado;

    public d(e<?, ?, ?> eVar) {
        super(eVar);
        this.ado = new ArrayList();
    }

    public void a(int i, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        a(dB(i), viewGroup, layoutParams);
    }

    public void a(c cVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (cVar != null && this.ado.contains(cVar)) {
            View view = cVar.getView();
            if (view == null) {
                view = cVar.wN();
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
            cVar.wK();
        }
    }

    public void h(int i, boolean z) {
        a(dB(i), z);
    }

    public void a(c cVar, boolean z) {
        View view;
        if (cVar != null && this.ado.contains(cVar) && (view = cVar.getView()) != null) {
            if (z) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            cVar.wL();
        }
    }

    public boolean a(c cVar) {
        if (cVar == null || this.ado == null || !this.ado.add(cVar)) {
            return false;
        }
        cVar.adp = this;
        cVar.a(this.adn);
        if (cVar.getUniqueId() == null) {
            cVar.setUniqueId(getUniqueId());
        }
        return true;
    }

    public int getChildCount() {
        if (this.ado == null) {
            return 0;
        }
        return this.ado.size();
    }

    public c dB(int i) {
        if (this.ado != null && i >= 0 && i < this.ado.size()) {
            return this.ado.get(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void i(Bundle bundle) {
        super.i(bundle);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dB = dB(i);
            if (dB != null) {
                dB.i(bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void wA() {
        super.wA();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dB = dB(i);
            if (dB != null) {
                dB.wA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void wB() {
        super.wB();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dB = dB(i);
            if (dB != null) {
                dB.wB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void wD() {
        super.wD();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dB = dB(i);
            if (dB != null) {
                dB.wD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void wF() {
        super.wF();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dB = dB(i);
            if (dB != null) {
                dB.wF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void wH() {
        super.wH();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dB = dB(i);
            if (dB != null) {
                dB.wH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void wI() {
        super.wI();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dB = dB(i);
            if (dB != null) {
                dB.wI();
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
            c dB = dB(i3);
            if (dB != null && (z = dB.onActivityResult(i, i2, intent))) {
                break;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void wK() {
        super.wK();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dB = dB(i);
            if (dB != null && dB.getView() != null && dB.getView().getParent() != null && dB.getView().getVisibility() == 0) {
                dB.wK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void wL() {
        super.wL();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dB = dB(i);
            if (dB != null && dB.getView() != null && dB.getView().getParent() != null) {
                dB.wL();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dB = dB(i);
            if (dB != null) {
                dB.onSaveInstanceState(bundle);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        super.a(tbPageContext, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            c dB = dB(i2);
            if (dB != null && dB.getView() != null) {
                dB.a(tbPageContext, i);
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
            c dB = dB(i);
            if (dB != null) {
                dB.a(eVar);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dB = dB(i);
            if (dB != null && dB.getUniqueId() == null) {
                dB.setUniqueId(getUniqueId());
            }
        }
    }
}
