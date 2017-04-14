package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> RX = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Fe() != null) {
            Iterator<b> it = this.RX.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Fe() != null && next.Fe().type == bVar.Fe().type) {
                    return;
                }
            }
            this.RX.add(bVar);
        }
    }

    public ArrayList<b> oO() {
        return this.RX;
    }

    public Context getContext() {
        return this.mContext;
    }
}
