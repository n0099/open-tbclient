package com.baidu.tbadk.d;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> RE = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.EG() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.RE.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.EG() != null && next.EG().type == bVar.EG().type) {
                    return;
                }
            }
            this.RE.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> or() {
        return this.RE;
    }

    public Context getContext() {
        return this.mContext;
    }
}
