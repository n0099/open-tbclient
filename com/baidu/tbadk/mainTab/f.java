package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    private ArrayList<e> WH = new ArrayList<>();
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    public ArrayList<e> wi() {
        return this.WH;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void a(e eVar) {
        if (this.WH != null && eVar != null && !this.WH.contains(eVar)) {
            this.WH.add(eVar);
        }
    }
}
