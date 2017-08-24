package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> SL = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.EX() != null) {
            Iterator<b> it = this.SL.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.EX() != null && next.EX().type == bVar.EX().type) {
                    return;
                }
            }
            this.SL.add(bVar);
        }
    }

    public ArrayList<b> ox() {
        return this.SL;
    }

    public Context getContext() {
        return this.mContext;
    }
}
