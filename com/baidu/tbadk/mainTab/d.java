package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> bCN = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.atU() != null) {
            Iterator<b> it = this.bCN.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.atU() != null && next.atU().type == bVar.atU().type) {
                    return;
                }
            }
            this.bCN.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.bCN;
    }

    public Context getContext() {
        return this.mContext;
    }
}
