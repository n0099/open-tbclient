package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> buI = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.anK() != null) {
            Iterator<b> it = this.buI.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.anK() != null && next.anK().type == bVar.anK().type) {
                    return;
                }
            }
            this.buI.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.buI;
    }

    public Context getContext() {
        return this.mContext;
    }
}
