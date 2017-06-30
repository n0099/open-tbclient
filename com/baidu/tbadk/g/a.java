package com.baidu.tbadk.g;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> QX = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Ez() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.QX.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.Ez() != null && next.Ez().type == bVar.Ez().type) {
                    return;
                }
            }
            this.QX.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> oj() {
        return this.QX;
    }

    public Context getContext() {
        return this.mContext;
    }
}
