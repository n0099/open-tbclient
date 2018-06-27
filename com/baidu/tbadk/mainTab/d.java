package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> acb = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Jt() != null) {
            Iterator<b> it = this.acb.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Jt() != null && next.Jt().type == bVar.Jt().type) {
                    return;
                }
            }
            this.acb.add(bVar);
        }
    }

    public ArrayList<b> sT() {
        return this.acb;
    }

    public Context getContext() {
        return this.mContext;
    }
}
