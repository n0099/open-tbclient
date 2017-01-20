package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e {
    private ArrayList<b> MB = new ArrayList<>();
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.En() != null) {
            Iterator<b> it = this.MB.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.En() != null && next.En().type == bVar.En().type) {
                    return;
                }
            }
            this.MB.add(bVar);
        }
    }

    public ArrayList<b> od() {
        return this.MB;
    }

    public Context getContext() {
        return this.mContext;
    }
}
