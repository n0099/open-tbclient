package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> bDl = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.aug() != null) {
            Iterator<b> it = this.bDl.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.aug() != null && next.aug().type == bVar.aug().type) {
                    return;
                }
            }
            this.bDl.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.bDl;
    }

    public Context getContext() {
        return this.mContext;
    }
}
