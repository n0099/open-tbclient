package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> aHo = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Mz() != null) {
            Iterator<b> it = this.aHo.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Mz() != null && next.Mz().type == bVar.Mz().type) {
                    return;
                }
            }
            this.aHo.add(bVar);
        }
    }

    public ArrayList<b> wa() {
        return this.aHo;
    }

    public Context getContext() {
        return this.mContext;
    }
}
