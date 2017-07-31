package com.baidu.tbadk.h;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> SI = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.EX() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.SI.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.EX() != null && next.EX().type == bVar.EX().type) {
                    return;
                }
            }
            this.SI.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> ow() {
        return this.SI;
    }

    public Context getContext() {
        return this.mContext;
    }
}
