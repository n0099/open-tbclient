package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> Rq = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Ei() != null) {
            Iterator<b> it = this.Rq.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Ei() != null && next.Ei().type == bVar.Ei().type) {
                    return;
                }
            }
            this.Rq.add(bVar);
        }
    }

    public ArrayList<b> ov() {
        return this.Rq;
    }

    public Context getContext() {
        return this.mContext;
    }
}
