package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> bxd = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.aNf() != null) {
            Iterator<b> it = this.bxd.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.aNf() != null && next.aNf().type == bVar.aNf().type) {
                    return;
                }
            }
            this.bxd.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.bxd;
    }

    public Context getContext() {
        return this.mContext;
    }
}
