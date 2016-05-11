package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e {
    private ArrayList<b> Lc = new ArrayList<>();
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Dd() != null) {
            Iterator<b> it = this.Lc.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Dd() != null && next.Dd().type == bVar.Dd().type) {
                    return;
                }
            }
            this.Lc.add(bVar);
        }
    }

    public ArrayList<b> nA() {
        return this.Lc;
    }

    public Context getContext() {
        return this.mContext;
    }
}
