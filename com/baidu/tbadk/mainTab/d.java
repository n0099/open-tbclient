package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> bVG = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.avz() != null) {
            Iterator<b> it = this.bVG.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.avz() != null && next.avz().type == bVar.avz().type) {
                    return;
                }
            }
            this.bVG.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.bVG;
    }

    public Context getContext() {
        return this.mContext;
    }
}
