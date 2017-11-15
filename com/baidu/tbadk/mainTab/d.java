package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> Sf = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.ES() != null) {
            Iterator<b> it = this.Sf.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.ES() != null && next.ES().type == bVar.ES().type) {
                    return;
                }
            }
            this.Sf.add(bVar);
        }
    }

    public ArrayList<b> os() {
        return this.Sf;
    }

    public Context getContext() {
        return this.mContext;
    }
}
