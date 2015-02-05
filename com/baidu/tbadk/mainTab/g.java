package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class g {
    private ArrayList<b> Xd = new ArrayList<>();
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.wq() != null) {
            Iterator<b> it = this.Xd.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.wq() != null && next.wq().type == bVar.wq().type) {
                    return;
                }
            }
            this.Xd.add(bVar);
        }
    }

    public ArrayList<b> wt() {
        return this.Xd;
    }

    public Context getContext() {
        return this.mContext;
    }
}
