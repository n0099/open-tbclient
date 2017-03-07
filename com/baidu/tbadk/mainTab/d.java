package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> RE = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.EG() != null) {
            Iterator<b> it = this.RE.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.EG() != null && next.EG().type == bVar.EG().type) {
                    return;
                }
            }
            this.RE.add(bVar);
        }
    }

    public ArrayList<b> or() {
        return this.RE;
    }

    public Context getContext() {
        return this.mContext;
    }
}
