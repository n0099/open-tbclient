package com.baidu.tbadk.mvc.core;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class d extends c {
    private final List<c> Xk;

    public d(MvcActivity<?, ?> mvcActivity) {
        super(mvcActivity);
        this.Xk = new ArrayList();
    }

    public void a(int i, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        a(dh(i), viewGroup, layoutParams);
    }

    public void a(c cVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (cVar != null && this.Xk.contains(cVar)) {
            View view = cVar.getView();
            if (view == null) {
                view = cVar.th();
                cVar.ti();
            }
            if (cVar.getView().getParent() == null) {
                if (layoutParams == null) {
                    viewGroup.addView(view);
                } else {
                    viewGroup.addView(view, layoutParams);
                }
            }
            view.setVisibility(0);
            cVar.tf();
        }
    }

    public void h(int i, boolean z) {
        a(dh(i), z);
    }

    public void a(c cVar, boolean z) {
        if (cVar != null && this.Xk.contains(cVar)) {
            View view = cVar.getView();
            if (view != null) {
                if (z) {
                    view.setVisibility(8);
                } else {
                    view.setVisibility(0);
                }
            }
            cVar.tg();
        }
    }

    public boolean a(c cVar) {
        if (this.Xk == null || !this.Xk.add(cVar)) {
            return false;
        }
        cVar.Xl = this;
        cVar.a(this.Xj);
        return true;
    }

    public int getChildCount() {
        if (this.Xk == null) {
            return 0;
        }
        return this.Xk.size();
    }

    public c dh(int i) {
        if (this.Xk != null && i >= 0 && i < this.Xk.size()) {
            return this.Xk.get(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void c(Bundle bundle) {
        super.c(bundle);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dh = dh(i);
            if (dh != null) {
                dh.c(bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void nv() {
        super.nv();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dh = dh(i);
            if (dh != null) {
                dh.nv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void tc() {
        super.tc();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dh = dh(i);
            if (dh != null) {
                dh.tc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void td() {
        super.td();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dh = dh(i);
            if (dh != null) {
                dh.td();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void te() {
        super.te();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dh = dh(i);
            if (dh != null) {
                dh.te();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dh = dh(i);
            if (dh != null) {
                dh.onActivityStop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityDestroy() {
        super.onActivityDestroy();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dh = dh(i);
            if (dh != null) {
                dh.onActivityDestroy();
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
            c dh = dh(i3);
            if (dh != null && (z = dh.onActivityResult(i, i2, intent))) {
                break;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void tf() {
        super.tf();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dh = dh(i);
            if (dh != null && dh.getView() != null && dh.getView().getParent() != null && dh.getView().getVisibility() == 0) {
                dh.tf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void tg() {
        super.tg();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dh = dh(i);
            if (dh != null && dh.getView() != null && dh.getView().getParent() != null) {
                dh.tg();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dh = dh(i);
            if (dh != null) {
                dh.onSaveInstanceState(bundle);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.e.a
    public boolean dg(int i) {
        super.dg(i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            c dh = dh(i2);
            if (dh != null && dh.getView() != null) {
                dh.dg(i);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(MvcActivity<?, ?> mvcActivity) {
        super.a(mvcActivity);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c dh = dh(i);
            if (dh != null) {
                dh.a(mvcActivity);
            }
        }
    }
}
