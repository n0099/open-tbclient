package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> anu = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.NQ() != null) {
            Iterator<b> it = this.anu.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.NQ() != null && next.NQ().type == bVar.NQ().type) {
                    return;
                }
            }
            this.anu.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.anu;
    }

    public Context getContext() {
        return this.mContext;
    }
}
