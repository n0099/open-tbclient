package com.baidu.tbadk.d;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private ArrayList<c> Lc;
    private Context apb;

    public ArrayList<c> AR() {
        return this.Lc;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.Lc.add(cVar);
        }
    }

    public Context getContext() {
        return this.apb;
    }
}
