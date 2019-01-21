package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> anX = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Oh() != null) {
            Iterator<b> it = this.anX.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Oh() != null && next.Oh().type == bVar.Oh().type) {
                    return;
                }
            }
            this.anX.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.anX;
    }

    public Context getContext() {
        return this.mContext;
    }
}
