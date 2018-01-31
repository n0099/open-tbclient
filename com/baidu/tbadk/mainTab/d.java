package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> aHp = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Mp() != null) {
            Iterator<b> it = this.aHp.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Mp() != null && next.Mp().type == bVar.Mp().type) {
                    return;
                }
            }
            this.aHp.add(bVar);
        }
    }

    public ArrayList<b> wa() {
        return this.aHp;
    }

    public Context getContext() {
        return this.mContext;
    }
}
