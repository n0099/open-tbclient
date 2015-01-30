package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class g {
    private ArrayList<b> Xg = new ArrayList<>();
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.ww() != null) {
            Iterator<b> it = this.Xg.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.ww() != null && next.ww().type == bVar.ww().type) {
                    return;
                }
            }
            this.Xg.add(bVar);
        }
    }

    public ArrayList<b> wz() {
        return this.Xg;
    }

    public Context getContext() {
        return this.mContext;
    }
}
