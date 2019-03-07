package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> buG = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.anL() != null) {
            Iterator<b> it = this.buG.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.anL() != null && next.anL().type == bVar.anL().type) {
                    return;
                }
            }
            this.buG.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.buG;
    }

    public Context getContext() {
        return this.mContext;
    }
}
