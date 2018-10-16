package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> ajf = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.MC() != null) {
            Iterator<b> it = this.ajf.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.MC() != null && next.MC().type == bVar.MC().type) {
                    return;
                }
            }
            this.ajf.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.ajf;
    }

    public Context getContext() {
        return this.mContext;
    }
}
