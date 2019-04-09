package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ArrayList<b> buM = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.anH() != null) {
            Iterator<b> it = this.buM.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.anH() != null && next.anH().type == bVar.anH().type) {
                    return;
                }
            }
            this.buM.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.buM;
    }

    public Context getContext() {
        return this.mContext;
    }
}
