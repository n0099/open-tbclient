package com.baidu.tbadk.mvc.core;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends a {
    private final List<a> Xk;

    public b(MvcActivity<?, ?> mvcActivity) {
        super(mvcActivity);
        this.Xk = new ArrayList();
    }

    public boolean a(a aVar) {
        if (this.Xk == null || !this.Xk.add(aVar)) {
            return false;
        }
        aVar.Xh = this;
        aVar.a(this.Xj);
        return true;
    }

    public int getChildCount() {
        if (this.Xk == null) {
            return 0;
        }
        return this.Xk.size();
    }

    public a df(int i) {
        if (this.Xk != null && i >= 0 && i < this.Xk.size()) {
            return this.Xk.get(i);
        }
        return null;
    }

    @Override // com.baidu.tbadk.mvc.core.a
    public void b(Bundle bundle) {
        super.b(bundle);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            a df = df(i);
            if (df != null) {
                df.b(bundle);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.a
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            a df = df(i);
            if (df != null) {
                df.onSaveInstanceState(bundle);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.a
    void a(MvcActivity<?, ?> mvcActivity) {
        super.a(mvcActivity);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            a df = df(i);
            if (df != null) {
                df.a(mvcActivity);
            }
        }
    }
}
