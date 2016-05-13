package com.baidu.tbadk.d;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private ArrayList<c> Lc;
    private Context aon;

    public ArrayList<c> AI() {
        return this.Lc;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.Lc.add(cVar);
        }
    }

    public Context getContext() {
        return this.aon;
    }
}
