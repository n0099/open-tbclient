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
    protected final List<c> amc;

    public d(e<?, ?, ?> eVar) {
        super(eVar);
        this.amc = new ArrayList();
    }

    public d() {
        this.amc = new ArrayList();
    }

    public void a(int i, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        a(dK(i), viewGroup, layoutParams);
    }

    public void a(c cVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (cVar != null && this.amc.contains(cVar)) {
            View view = cVar.getView();
            if (view == null) {
                view = cVar.Aj();
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
            cVar.Ag();
        }
    }

    public void h(int i, boolean z) {
        a(dK(i), z);
    }

    public void a(c cVar, boolean z) {
        View view;
        if (cVar != null && this.amc.contains(cVar) && (view = cVar.getView()) != null) {
            if (z) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            cVar.Ah();
        }
    }

    public boolean a(c cVar) {
        if (cVar == null || this.amc == null || !this.amc.add(cVar)) {
            return false;
        }
        cVar.amd = this;
        cVar.a(this.amb);
        if (cVar.getUniqueId() == null) {
            cVar.setUniqueId(getUniqueId());
        }
        return true;
    }

    public int getChildCount() {
        if (this.amc == null) {
            return 0;
        }
        return this.amc.size();
    }

    public c dK(int i) {
        if (this.amc != null && i >= 0 && i < this.amc.size()) {
            return this.amc.get(i);
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
    public void zW() {
        super.zW();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dK = dK(i);
            if (dK != null) {
                dK.zW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void zX() {
        super.zX();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dK = dK(i);
            if (dK != null) {
                dK.zX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void zZ() {
        super.zZ();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dK = dK(i);
            if (dK != null) {
                dK.zZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void Ab() {
        super.Ab();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dK = dK(i);
            if (dK != null) {
                dK.Ab();
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
    public void Ae() {
        super.Ae();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dK = dK(i);
            if (dK != null) {
                dK.Ae();
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
    public void Ag() {
        super.Ag();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dK = dK(i);
            if (dK != null && dK.getView() != null && dK.getView().getParent() != null && dK.getView().getVisibility() == 0) {
                dK.Ag();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void Ah() {
        super.Ah();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dK = dK(i);
            if (dK != null && dK.getView() != null && dK.getView().getParent() != null) {
                dK.Ah();
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
