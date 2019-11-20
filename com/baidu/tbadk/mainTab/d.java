package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> bUP = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.avx() != null) {
            Iterator<b> it = this.bUP.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.avx() != null && next.avx().type == bVar.avx().type) {
                    return;
                }
            }
            this.bUP.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.bUP;
    }

    public Context getContext() {
        return this.mContext;
    }
}
