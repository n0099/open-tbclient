package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    private ArrayList<e> Xm = new ArrayList<>();
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    public ArrayList<e> wy() {
        return this.Xm;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void a(e eVar) {
        if (this.Xm != null && eVar != null && !this.Xm.contains(eVar)) {
            this.Xm.add(eVar);
        }
    }
}
