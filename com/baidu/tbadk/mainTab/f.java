package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f {
    private ArrayList<b> ais = new ArrayList<>();
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.AE() != null) {
            Iterator<b> it = this.ais.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.AE() != null && next.AE().type == bVar.AE().type) {
                    return;
                }
            }
            this.ais.add(bVar);
        }
    }

    public ArrayList<b> AG() {
        return this.ais;
    }

    public Context getContext() {
        return this.mContext;
    }
}
