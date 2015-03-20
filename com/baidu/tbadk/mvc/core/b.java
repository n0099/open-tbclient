package com.baidu.tbadk.mvc.core;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends a {
    private final List<a> amc;

    public b(e<?, ?, ?> eVar) {
        super(eVar);
        this.amc = new ArrayList();
    }

    public boolean a(a aVar) {
        if (this.amc == null || !this.amc.add(aVar)) {
            return false;
        }
        aVar.alZ = this;
        aVar.a(this.amb);
        return true;
    }

    public int getChildCount() {
        if (this.amc == null) {
            return 0;
        }
        return this.amc.size();
    }

    public a dJ(int i) {
        if (this.amc != null && i >= 0 && i < this.amc.size()) {
            return this.amc.get(i);
        }
        return null;
    }

    @Override // com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            a dJ = dJ(i);
            if (dJ != null) {
                dJ.f(bundle);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.a
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            a dJ = dJ(i);
            if (dJ != null) {
                dJ.onSaveInstanceState(bundle);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.a
    void a(e<?, ?, ?> eVar) {
        super.a(eVar);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            a dJ = dJ(i);
            if (dJ != null) {
                dJ.a(eVar);
            }
        }
    }
}
