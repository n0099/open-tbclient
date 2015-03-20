package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f {
    private ArrayList<b> ahj = new ArrayList<>();
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.zL() != null) {
            Iterator<b> it = this.ahj.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.zL() != null && next.zL().type == bVar.zL().type) {
                    return;
                }
            }
            this.ahj.add(bVar);
        }
    }

    public ArrayList<b> zN() {
        return this.ahj;
    }

    public Context getContext() {
        return this.mContext;
    }
}
