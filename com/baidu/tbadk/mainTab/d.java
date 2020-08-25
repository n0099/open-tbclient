package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class d {
    private ArrayList<b> ahU = new ArrayList<>();
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            Iterator<b> it = this.ahU.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.getFragmentTabStructure() != null && next.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.ahU.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.ahU;
    }

    public Context getContext() {
        return this.mContext;
    }
}
