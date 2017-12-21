package com.baidu.tbadk.g;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> SL = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Fa() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.SL.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.Fa() != null && next.Fa().type == bVar.Fa().type) {
                    return;
                }
            }
            this.SL.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> ox() {
        return this.SL;
    }

    public Context getContext() {
        return this.mContext;
    }
}
