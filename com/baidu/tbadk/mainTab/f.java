package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f {
    private ArrayList<b> ahr = new ArrayList<>();
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.zR() != null) {
            Iterator<b> it = this.ahr.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.zR() != null && next.zR().type == bVar.zR().type) {
                    return;
                }
            }
            this.ahr.add(bVar);
        }
    }

    public ArrayList<b> zT() {
        return this.ahr;
    }

    public Context getContext() {
        return this.mContext;
    }
}
