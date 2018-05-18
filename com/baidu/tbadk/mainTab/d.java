package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> TP = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Fw() != null) {
            Iterator<b> it = this.TP.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Fw() != null && next.Fw().type == bVar.Fw().type) {
                    return;
                }
            }
            this.TP.add(bVar);
        }
    }

    public ArrayList<b> pw() {
        return this.TP;
    }

    public Context getContext() {
        return this.mContext;
    }
}
