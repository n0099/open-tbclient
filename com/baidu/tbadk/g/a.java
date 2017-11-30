package com.baidu.tbadk.g;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> SO = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.EZ() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.SO.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.EZ() != null && next.EZ().type == bVar.EZ().type) {
                    return;
                }
            }
            this.SO.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> oz() {
        return this.SO;
    }

    public Context getContext() {
        return this.mContext;
    }
}
