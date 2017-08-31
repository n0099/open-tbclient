package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> RM = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.EV() != null) {
            Iterator<b> it = this.RM.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.EV() != null && next.EV().type == bVar.EV().type) {
                    return;
                }
            }
            this.RM.add(bVar);
        }
    }

    public ArrayList<b> or() {
        return this.RM;
    }

    public Context getContext() {
        return this.mContext;
    }
}
