package com.baidu.tbadk.d;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> No = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.EF() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.No.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.EF() != null && next.EF().type == bVar.EF().type) {
                    return;
                }
            }
            this.No.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> of() {
        return this.No;
    }

    public Context getContext() {
        return this.mContext;
    }
}
