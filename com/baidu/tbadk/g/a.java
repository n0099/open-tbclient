package com.baidu.tbadk.g;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> RZ = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Fe() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.RZ.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.Fe() != null && next.Fe().type == bVar.Fe().type) {
                    return;
                }
            }
            this.RZ.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> oO() {
        return this.RZ;
    }

    public Context getContext() {
        return this.mContext;
    }
}
