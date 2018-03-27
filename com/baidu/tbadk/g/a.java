package com.baidu.tbadk.g;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> aIz = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.MV() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.aIz.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.MV() != null && next.MV().type == bVar.MV().type) {
                    return;
                }
            }
            this.aIz.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> wN() {
        return this.aIz;
    }

    public Context getContext() {
        return this.mContext;
    }
}
