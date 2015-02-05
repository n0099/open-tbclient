package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    private ArrayList<e> Xj = new ArrayList<>();
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    public ArrayList<e> ws() {
        return this.Xj;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void a(e eVar) {
        if (this.Xj != null && eVar != null && !this.Xj.contains(eVar)) {
            this.Xj.add(eVar);
        }
    }
}
