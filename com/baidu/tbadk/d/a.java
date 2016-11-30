package com.baidu.tbadk.d;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> Nr = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.EK() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.Nr.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.EK() != null && next.EK().type == bVar.EK().type) {
                    return;
                }
            }
            this.Nr.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> oj() {
        return this.Nr;
    }

    public Context getContext() {
        return this.mContext;
    }
}
