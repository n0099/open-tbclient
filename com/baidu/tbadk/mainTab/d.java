package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> QX = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Ez() != null) {
            Iterator<b> it = this.QX.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Ez() != null && next.Ez().type == bVar.Ez().type) {
                    return;
                }
            }
            this.QX.add(bVar);
        }
    }

    public ArrayList<b> oj() {
        return this.QX;
    }

    public Context getContext() {
        return this.mContext;
    }
}
