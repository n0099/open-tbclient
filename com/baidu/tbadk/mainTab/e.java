package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e {
    private ArrayList<b> Wa = new ArrayList<>();
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.sF() != null) {
            Iterator<b> it = this.Wa.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.sF() != null && next.sF().type == bVar.sF().type) {
                    return;
                }
            }
            this.Wa.add(bVar);
        }
    }

    public ArrayList<b> sG() {
        return this.Wa;
    }

    public Context getContext() {
        return this.mContext;
    }
}
