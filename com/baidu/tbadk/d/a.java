package com.baidu.tbadk.d;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private ArrayList<c> Lb;
    private Context apR;

    public ArrayList<c> AR() {
        return this.Lb;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.Lb.add(cVar);
        }
    }

    public Context getContext() {
        return this.apR;
    }
}
