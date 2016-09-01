package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e {
    private ArrayList<b> No = new ArrayList<>();
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.EF() != null) {
            Iterator<b> it = this.No.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.EF() != null && next.EF().type == bVar.EF().type) {
                    return;
                }
            }
            this.No.add(bVar);
        }
    }

    public ArrayList<b> of() {
        return this.No;
    }

    public Context getContext() {
        return this.mContext;
    }
}
