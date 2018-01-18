package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> aHm = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Mn() != null) {
            Iterator<b> it = this.aHm.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Mn() != null && next.Mn().type == bVar.Mn().type) {
                    return;
                }
            }
            this.aHm.add(bVar);
        }
    }

    public ArrayList<b> vZ() {
        return this.aHm;
    }

    public Context getContext() {
        return this.mContext;
    }
}
