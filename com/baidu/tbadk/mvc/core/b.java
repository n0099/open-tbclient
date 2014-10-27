package com.baidu.tbadk.mvc.core;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends a {
    private final List<a> Xg;

    public b(MvcActivity<?, ?> mvcActivity) {
        super(mvcActivity);
        this.Xg = new ArrayList();
    }

    public boolean a(a aVar) {
        if (this.Xg == null || !this.Xg.add(aVar)) {
            return false;
        }
        aVar.Xd = this;
        aVar.a(this.Xf);
        return true;
    }

    public int getChildCount() {
        if (this.Xg == null) {
            return 0;
        }
        return this.Xg.size();
    }

    public a df(int i) {
        if (this.Xg != null && i >= 0 && i < this.Xg.size()) {
            return this.Xg.get(i);
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
