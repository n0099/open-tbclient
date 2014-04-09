package com.baidu.tbadk.mainTab;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class e {
    private ArrayList<b> a = new ArrayList<>();
    private Context b;

    public e(Context context) {
        this.b = context;
    }

    public final void a(b bVar) {
        if (bVar != null && bVar.b() != null) {
            Iterator<b> it = this.a.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.b() != null && next.b().c == bVar.b().c) {
                    return;
                }
            }
            this.a.add(bVar);
        }
    }

    public final ArrayList<b> a() {
        return this.a;
    }

    public final Context b() {
        return this.b;
    }
}
