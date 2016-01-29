package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> SO = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Ey() != null) {
            Iterator<b> it = this.SO.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Ey() != null && next.Ey().type == bVar.Ey().type) {
                    return;
                }
            }
            this.SO.add(bVar);
        }
    }

    public ArrayList<b> qN() {
        return this.SO;
    }

    public Context getContext() {
        return this.mContext;
    }
}
