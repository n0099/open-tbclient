package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e {
    private ArrayList<b> Np = new ArrayList<>();
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.EF() != null) {
            Iterator<b> it = this.Np.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.EF() != null && next.EF().type == bVar.EF().type) {
                    return;
                }
            }
            this.Np.add(bVar);
        }
    }

    public ArrayList<b> og() {
        return this.Np;
    }

    public Context getContext() {
        return this.mContext;
    }
}
