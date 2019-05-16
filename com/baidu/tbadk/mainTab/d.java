package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> bBP = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.asK() != null) {
            Iterator<b> it = this.bBP.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.asK() != null && next.asK().type == bVar.asK().type) {
                    return;
                }
            }
            this.bBP.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.bBP;
    }

    public Context getContext() {
        return this.mContext;
    }
}
