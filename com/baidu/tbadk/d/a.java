package com.baidu.tbadk.d;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> MB = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.En() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.MB.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.En() != null && next.En().type == bVar.En().type) {
                    return;
                }
            }
            this.MB.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> od() {
        return this.MB;
    }

    public Context getContext() {
        return this.mContext;
    }
}
