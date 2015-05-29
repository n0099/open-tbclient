package com.baidu.tbadk.mvc.core;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends a {
    private final List<a> ann;

    public b(e<?, ?, ?> eVar) {
        super(eVar);
        this.ann = new ArrayList();
    }

    public boolean a(a aVar) {
        if (this.ann == null || !this.ann.add(aVar)) {
            return false;
        }
        aVar.ank = this;
        aVar.a(this.anm);
        return true;
    }

    public int getChildCount() {
        if (this.ann == null) {
            return 0;
        }
        return this.ann.size();
    }

    public a dT(int i) {
        if (this.ann != null && i >= 0 && i < this.ann.size()) {
            return this.ann.get(i);
        }
        return null;
    }

    @Override // com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            a dT = dT(i);
            if (dT != null) {
                dT.f(bundle);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.a
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            a dT = dT(i);
            if (dT != null) {
                dT.onSaveInstanceState(bundle);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.a
    void a(e<?, ?, ?> eVar) {
        super.a(eVar);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            a dT = dT(i);
            if (dT != null) {
                dT.a(eVar);
            }
        }
    }
}
