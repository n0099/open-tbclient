package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> abG = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Jo() != null) {
            Iterator<b> it = this.abG.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Jo() != null && next.Jo().type == bVar.Jo().type) {
                    return;
                }
            }
            this.abG.add(bVar);
        }
    }

    public ArrayList<b> sE() {
        return this.abG;
    }

    public Context getContext() {
        return this.mContext;
    }
}
