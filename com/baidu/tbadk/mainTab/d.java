package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> aIy = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.MU() != null) {
            Iterator<b> it = this.aIy.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.MU() != null && next.MU().type == bVar.MU().type) {
                    return;
                }
            }
            this.aIy.add(bVar);
        }
    }

    public ArrayList<b> wN() {
        return this.aIy;
    }

    public Context getContext() {
        return this.mContext;
    }
}
