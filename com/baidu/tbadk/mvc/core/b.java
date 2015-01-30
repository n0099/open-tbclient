package com.baidu.tbadk.mvc.core;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends a {
    private final List<a> adL;

    public b(e<?, ?, ?> eVar) {
        super(eVar);
        this.adL = new ArrayList();
    }

    public boolean a(a aVar) {
        if (this.adL == null || !this.adL.add(aVar)) {
            return false;
        }
        aVar.adI = this;
        aVar.a(this.adK);
        return true;
    }

    public int getChildCount() {
        if (this.adL == null) {
            return 0;
        }
        return this.adL.size();
    }

    public a dG(int i) {
        if (this.adL != null && i >= 0 && i < this.adL.size()) {
            return this.adL.get(i);
        }
        return null;
    }

    @Override // com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            a dG = dG(i);
            if (dG != null) {
                dG.f(bundle);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.a
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            a dG = dG(i);
            if (dG != null) {
                dG.onSaveInstanceState(bundle);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.a
    void a(e<?, ?, ?> eVar) {
        super.a(eVar);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            a dG = dG(i);
            if (dG != null) {
                dG.a(eVar);
            }
        }
    }
}
