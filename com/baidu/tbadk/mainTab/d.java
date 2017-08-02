package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> Rk = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.EP() != null) {
            Iterator<b> it = this.Rk.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.EP() != null && next.EP().type == bVar.EP().type) {
                    return;
                }
            }
            this.Rk.add(bVar);
        }
    }

    public ArrayList<b> om() {
        return this.Rk;
    }

    public Context getContext() {
        return this.mContext;
    }
}
