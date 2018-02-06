package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> aIJ = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.MV() != null) {
            Iterator<b> it = this.aIJ.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.MV() != null && next.MV().type == bVar.MV().type) {
                    return;
                }
            }
            this.aIJ.add(bVar);
        }
    }

    public ArrayList<b> wN() {
        return this.aIJ;
    }

    public Context getContext() {
        return this.mContext;
    }
}
