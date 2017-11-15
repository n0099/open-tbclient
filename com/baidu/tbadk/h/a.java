package com.baidu.tbadk.h;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> Sf = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.ES() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.Sf.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.ES() != null && next.ES().type == bVar.ES().type) {
                    return;
                }
            }
            this.Sf.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> os() {
        return this.Sf;
    }

    public Context getContext() {
        return this.mContext;
    }
}
