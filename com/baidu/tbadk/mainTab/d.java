package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> TT = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Fy() != null) {
            Iterator<b> it = this.TT.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Fy() != null && next.Fy().type == bVar.Fy().type) {
                    return;
                }
            }
            this.TT.add(bVar);
        }
    }

    public ArrayList<b> px() {
        return this.TT;
    }

    public Context getContext() {
        return this.mContext;
    }
}
