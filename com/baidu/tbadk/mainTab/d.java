package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> ajS = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.ML() != null) {
            Iterator<b> it = this.ajS.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.ML() != null && next.ML().type == bVar.ML().type) {
                    return;
                }
            }
            this.ajS.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.ajS;
    }

    public Context getContext() {
        return this.mContext;
    }
}
