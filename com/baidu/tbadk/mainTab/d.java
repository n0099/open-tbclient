package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> anx = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.CA() != null) {
            Iterator<b> it = this.anx.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.CA() != null && next.CA().type == bVar.CA().type) {
                    return;
                }
            }
            this.anx.add(bVar);
        }
    }

    public ArrayList<b> CB() {
        return this.anx;
    }

    public Context getContext() {
        return this.mContext;
    }
}
