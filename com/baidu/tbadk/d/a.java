package com.baidu.tbadk.d;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private ArrayList<c> Ts;
    private Context arj;

    public ArrayList<c> AS() {
        return this.Ts;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.Ts.add(cVar);
        }
    }

    public Context getContext() {
        return this.arj;
    }
}
