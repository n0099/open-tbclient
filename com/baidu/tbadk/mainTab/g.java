package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class g {
    private ArrayList<b> WB = new ArrayList<>();
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.we() != null) {
            Iterator<b> it = this.WB.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.we() != null && next.we().type == bVar.we().type) {
                    return;
                }
            }
            this.WB.add(bVar);
        }
    }

    public ArrayList<b> wj() {
        return this.WB;
    }

    public Context getContext() {
        return this.mContext;
    }
}
