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
    protected final List<c> ann;

    public d(e<?, ?, ?> eVar) {
        super(eVar);
        this.ann = new ArrayList();
    }

    public d() {
        this.ann = new ArrayList();
    }

    public void a(int i, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        a(dU(i), viewGroup, layoutParams);
    }

    public void a(c cVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (cVar != null && this.ann.contains(cVar)) {
            View view = cVar.getView();
            if (view == null) {
                view = cVar.Bb();
                cVar.oL();
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
            cVar.AY();
        }
    }

    public void h(int i, boolean z) {
        a(dU(i), z);
    }

    public void a(c cVar, boolean z) {
        View view;
        if (cVar != null && this.ann.contains(cVar) && (view = cVar.getView()) != null) {
            if (z) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            cVar.AZ();
        }
    }

    public boolean a(c cVar) {
        if (cVar == null || this.ann == null || !this.ann.add(cVar)) {
            return false;
        }
        cVar.ano = this;
        cVar.a(this.anm);
        if (cVar.getUniqueId() == null) {
            cVar.setUniqueId(getUniqueId());
        }
        return true;
    }

    public int getChildCount() {
        if (this.ann == null) {
            return 0;
        }
        return this.ann.size();
    }

    public c dU(int i) {
        if (this.ann != null && i >= 0 && i < this.ann.size()) {
            return this.ann.get(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void h(Bundle bundle) {
        super.h(bundle);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dU = dU(i);
            if (dU != null) {
                dU.h(bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void AO() {
        super.AO();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dU = dU(i);
            if (dU != null) {
                dU.AO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void AP() {
        super.AP();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dU = dU(i);
            if (dU != null) {
                dU.AP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void AR() {
        super.AR();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dU = dU(i);
            if (dU != null) {
                dU.AR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void AT() {
        super.AT();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dU = dU(i);
            if (dU != null) {
                dU.AT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void AV() {
        super.AV();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dU = dU(i);
            if (dU != null) {
                dU.AV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void AW() {
        super.AW();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dU = dU(i);
            if (dU != null) {
                dU.AW();
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
            c dU = dU(i3);
            if (dU != null && (z = dU.onActivityResult(i, i2, intent))) {
                break;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void AY() {
        super.AY();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dU = dU(i);
            if (dU != null && dU.getView() != null && dU.getView().getParent() != null && dU.getView().getVisibility() == 0) {
                dU.AY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void AZ() {
        super.AZ();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dU = dU(i);
            if (dU != null && dU.getView() != null && dU.getView().getParent() != null) {
                dU.AZ();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dU = dU(i);
            if (dU != null) {
                dU.onSaveInstanceState(bundle);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        super.a(tbPageContext, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            c dU = dU(i2);
            if (dU != null && dU.getView() != null) {
                dU.a(tbPageContext, i);
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
            c dU = dU(i);
            if (dU != null) {
                dU.a(eVar);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dU = dU(i);
            if (dU != null && dU.getUniqueId() == null) {
                dU.setUniqueId(getUniqueId());
            }
        }
    }
}
