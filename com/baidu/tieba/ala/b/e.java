package com.baidu.tieba.ala.b;

import android.content.Context;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public class e {
    private b gNW = null;
    private b gNX = null;
    private Set<j> gNY = new HashSet();
    private Set<j> gNZ = null;
    private boolean gOa = false;
    private Context mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void bWl();

        void onCancel();
    }

    public e(Context context) {
        this.mContext = context;
        bWj();
    }

    private void bWj() {
        this.gNX = new b("so");
        this.gNY.add(this.gNX);
        this.gNW = new b("source");
        this.gNY.add(this.gNW);
    }

    public boolean bWk() {
        if (this.gNZ == null) {
            this.gNZ = new HashSet();
            for (j jVar : this.gNY) {
                if (!jVar.isReady()) {
                    this.gNZ.add(jVar);
                }
            }
            if (this.gNZ.size() > 0) {
                this.gOa = true;
            } else {
                this.gOa = false;
            }
        }
        return this.gOa;
    }

    public void a(final a aVar) {
        if (!bWk()) {
            aVar.bWl();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.gNZ) {
            jVar.load();
            arrayList.add(jVar.bWc());
        }
        f.a(this.mContext, new com.baidu.tieba.ala.b.a((g[]) arrayList.toArray(new g[0]))).o(new Runnable() { // from class: com.baidu.tieba.ala.b.e.3
            @Override // java.lang.Runnable
            public void run() {
                aVar.bWl();
            }
        }).p(new Runnable() { // from class: com.baidu.tieba.ala.b.e.2
            @Override // java.lang.Runnable
            public void run() {
                aVar.onCancel();
            }
        }).e(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.b.e.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
            }
        }).show();
    }
}
