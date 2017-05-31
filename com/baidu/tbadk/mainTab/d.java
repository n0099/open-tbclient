package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> Rd = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Ec() != null) {
            Iterator<b> it = this.Rd.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Ec() != null && next.Ec().type == bVar.Ec().type) {
                    return;
                }
            }
            this.Rd.add(bVar);
        }
    }

    public ArrayList<b> on() {
        return this.Rd;
    }

    public Context getContext() {
        return this.mContext;
    }
}
