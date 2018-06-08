package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> abW = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Jb() != null) {
            Iterator<b> it = this.abW.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Jb() != null && next.Jb().type == bVar.Jb().type) {
                    return;
                }
            }
            this.abW.add(bVar);
        }
    }

    public ArrayList<b> sR() {
        return this.abW;
    }

    public Context getContext() {
        return this.mContext;
    }
}
