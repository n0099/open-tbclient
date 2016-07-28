package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e {
    private ArrayList<b> Lb = new ArrayList<>();
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Dl() != null) {
            Iterator<b> it = this.Lb.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Dl() != null && next.Dl().type == bVar.Dl().type) {
                    return;
                }
            }
            this.Lb.add(bVar);
        }
    }

    public ArrayList<b> nk() {
        return this.Lb;
    }

    public Context getContext() {
        return this.mContext;
    }
}
