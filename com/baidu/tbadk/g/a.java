package com.baidu.tbadk.g;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> aIy = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.MU() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.aIy.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.MU() != null && next.MU().type == bVar.MU().type) {
                    return;
                }
            }
            this.aIy.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> wN() {
        return this.aIy;
    }

    public Context getContext() {
        return this.mContext;
    }
}
