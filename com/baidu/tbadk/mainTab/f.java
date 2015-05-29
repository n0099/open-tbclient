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
        if (bVar != null && bVar.AD() != null) {
            Iterator<b> it = this.ais.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.AD() != null && next.AD().type == bVar.AD().type) {
                    return;
                }
            }
            this.ais.add(bVar);
        }
    }

    public ArrayList<b> AF() {
        return this.ais;
    }

    public Context getContext() {
        return this.mContext;
    }
}
