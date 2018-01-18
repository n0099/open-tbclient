package com.baidu.tbadk.g;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> aHm = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Mn() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.aHm.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.Mn() != null && next.Mn().type == bVar.Mn().type) {
                    return;
                }
            }
            this.aHm.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> vZ() {
        return this.aHm;
    }

    public Context getContext() {
        return this.mContext;
    }
}
