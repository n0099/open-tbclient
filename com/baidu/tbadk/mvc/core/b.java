package com.baidu.tbadk.mvc.core;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends a {
    private final List<a> adI;

    public b(e<?, ?, ?> eVar) {
        super(eVar);
        this.adI = new ArrayList();
    }

    public boolean a(a aVar) {
        if (this.adI == null || !this.adI.add(aVar)) {
            return false;
        }
        aVar.adF = this;
        aVar.a(this.adH);
        return true;
    }

    public int getChildCount() {
        if (this.adI == null) {
            return 0;
        }
        return this.adI.size();
    }

    public a dG(int i) {
        if (this.adI != null && i >= 0 && i < this.adI.size()) {
            return this.adI.get(i);
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
