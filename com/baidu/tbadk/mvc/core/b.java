package com.baidu.tbadk.mvc.core;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends a {
    private final List<a> ado;

    public b(e<?, ?, ?> eVar) {
        super(eVar);
        this.ado = new ArrayList();
    }

    public boolean a(a aVar) {
        if (this.ado == null || !this.ado.add(aVar)) {
            return false;
        }
        aVar.adl = this;
        aVar.a(this.adn);
        return true;
    }

    public int getChildCount() {
        if (this.ado == null) {
            return 0;
        }
        return this.ado.size();
    }

    public a dA(int i) {
        if (this.ado != null && i >= 0 && i < this.ado.size()) {
            return this.ado.get(i);
        }
        return null;
    }

    @Override // com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            a dA = dA(i);
            if (dA != null) {
                dA.f(bundle);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.a
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            a dA = dA(i);
            if (dA != null) {
                dA.onSaveInstanceState(bundle);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.a
    void a(e<?, ?, ?> eVar) {
        super.a(eVar);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            a dA = dA(i);
            if (dA != null) {
                dA.a(eVar);
            }
        }
    }
}
