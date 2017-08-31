package com.baidu.tbadk.h;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> RM = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.EV() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.RM.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.EV() != null && next.EV().type == bVar.EV().type) {
                    return;
                }
            }
            this.RM.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> or() {
        return this.RM;
    }

    public Context getContext() {
        return this.mContext;
    }
}
