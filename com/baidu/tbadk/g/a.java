package com.baidu.tbadk.g;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> aHp = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Mp() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.aHp.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.Mp() != null && next.Mp().type == bVar.Mp().type) {
                    return;
                }
            }
            this.aHp.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> wa() {
        return this.aHp;
    }

    public Context getContext() {
        return this.mContext;
    }
}
