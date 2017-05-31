package com.baidu.tbadk.g;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> Rd = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Ec() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.Rd.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.Ec() != null && next.Ec().type == bVar.Ec().type) {
                    return;
                }
            }
            this.Rd.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> on() {
        return this.Rd;
    }

    public Context getContext() {
        return this.mContext;
    }
}
