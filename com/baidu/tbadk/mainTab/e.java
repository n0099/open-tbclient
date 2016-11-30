package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e {
    private ArrayList<b> Nr = new ArrayList<>();
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.EK() != null) {
            Iterator<b> it = this.Nr.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.EK() != null && next.EK().type == bVar.EK().type) {
                    return;
                }
            }
            this.Nr.add(bVar);
        }
    }

    public ArrayList<b> oj() {
        return this.Nr;
    }

    public Context getContext() {
        return this.mContext;
    }
}
