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
    protected final List<c> amk;

    public d(e<?, ?, ?> eVar) {
        super(eVar);
        this.amk = new ArrayList();
    }

    public d() {
        this.amk = new ArrayList();
    }

    public void a(int i, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        a(dK(i), viewGroup, layoutParams);
    }

    public void a(c cVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (cVar != null && this.amk.contains(cVar)) {
            View view = cVar.getView();
            if (view == null) {
                view = cVar.Ap();
                cVar.ov();
                cVar.a(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
            }
            if (cVar.getView().getParent() == null) {
                if (layoutParams == null) {
                    viewGroup.addView(view);
                } else {
                    viewGroup.addView(view, layoutParams);
                }
            }
            view.setVisibility(0);
            cVar.Am();
        }
    }

    public void h(int i, boolean z) {
        a(dK(i), z);
    }

    public void a(c cVar, boolean z) {
        View view;
        if (cVar != null && this.amk.contains(cVar) && (view = cVar.getView()) != null) {
            if (z) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            cVar.An();
        }
    }

    public boolean a(c cVar) {
        if (cVar == null || this.amk == null || !this.amk.add(cVar)) {
            return false;
        }
        cVar.aml = this;
        cVar.a(this.amj);
        if (cVar.getUniqueId() == null) {
            cVar.setUniqueId(getUniqueId());
        }
        return true;
    }

    public int getChildCount() {
        if (this.amk == null) {
            return 0;
        }
        return this.amk.size();
    }

    public c dK(int i) {
        if (this.amk != null && i >= 0 && i < this.amk.size()) {
            return this.amk.get(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void h(Bundle bundle) {
        super.h(bundle);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dK = dK(i);
            if (dK != null) {
                dK.h(bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void Ac() {
        super.Ac();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dK = dK(i);
            if (dK != null) {
                dK.Ac();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void Ad() {
        super.Ad();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dK = dK(i);
            if (dK != null) {
                dK.Ad();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void Af() {
        super.Af();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dK = dK(i);
            if (dK != null) {
                dK.Af();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void Ah() {
        super.Ah();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dK = dK(i);
            if (dK != null) {
                dK.Ah();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void Aj() {
        super.Aj();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dK = dK(i);
            if (dK != null) {
                dK.Aj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void Ak() {
        super.Ak();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dK = dK(i);
            if (dK != null) {
                dK.Ak();
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
            c dK = dK(i3);
            if (dK != null && (z = dK.onActivityResult(i, i2, intent))) {
                break;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void Am() {
        super.Am();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dK = dK(i);
            if (dK != null && dK.getView() != null && dK.getView().getParent() != null && dK.getView().getVisibility() == 0) {
                dK.Am();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void An() {
        super.An();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dK = dK(i);
            if (dK != null && dK.getView() != null && dK.getView().getParent() != null) {
                dK.An();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dK = dK(i);
            if (dK != null) {
                dK.onSaveInstanceState(bundle);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        super.a(tbPageContext, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            c dK = dK(i2);
            if (dK != null && dK.getView() != null) {
                dK.a(tbPageContext, i);
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
            c dK = dK(i);
            if (dK != null) {
                dK.a(eVar);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dK = dK(i);
            if (dK != null && dK.getUniqueId() == null) {
                dK.setUniqueId(getUniqueId());
            }
        }
    }
}
