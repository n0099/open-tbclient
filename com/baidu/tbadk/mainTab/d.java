package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> SK = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.EX() != null) {
            Iterator<b> it = this.SK.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.EX() != null && next.EX().type == bVar.EX().type) {
                    return;
                }
            }
            this.SK.add(bVar);
        }
    }

    public ArrayList<b> ow() {
        return this.SK;
    }

    public Context getContext() {
        return this.mContext;
    }
}
