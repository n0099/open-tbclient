package com.baidu.tbadk.h;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> Rk = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.EP() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.Rk.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.EP() != null && next.EP().type == bVar.EP().type) {
                    return;
                }
            }
            this.Rk.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> om() {
        return this.Rk;
    }

    public Context getContext() {
        return this.mContext;
    }
}
