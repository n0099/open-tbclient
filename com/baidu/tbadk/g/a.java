package com.baidu.tbadk.g;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> aHo = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Mz() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.aHo.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.Mz() != null && next.Mz().type == bVar.Mz().type) {
                    return;
                }
            }
            this.aHo.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> wa() {
        return this.aHo;
    }

    public Context getContext() {
        return this.mContext;
    }
}
