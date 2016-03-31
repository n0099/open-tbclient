package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> Ql = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Fl() != null) {
            Iterator<b> it = this.Ql.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Fl() != null && next.Fl().type == bVar.Fl().type) {
                    return;
                }
            }
            this.Ql.add(bVar);
        }
    }

    public ArrayList<b> qe() {
        return this.Ql;
    }

    public Context getContext() {
        return this.mContext;
    }
}
