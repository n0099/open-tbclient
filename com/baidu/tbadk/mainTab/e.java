package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e {
    private ArrayList<b> VW = new ArrayList<>();
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.sD() != null) {
            Iterator<b> it = this.VW.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.sD() != null && next.sD().type == bVar.sD().type) {
                    return;
                }
            }
            this.VW.add(bVar);
        }
    }

    public ArrayList<b> sE() {
        return this.VW;
    }

    public Context getContext() {
        return this.mContext;
    }
}
