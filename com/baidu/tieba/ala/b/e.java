package com.baidu.tieba.ala.b;

import android.content.Context;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public class e {
    private b gLW = null;
    private b gLX = null;
    private Set<j> gLY = new HashSet();
    private Set<j> gLZ = null;
    private boolean gMa = false;
    private Context mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void bSW();

        void onCancel();
    }

    public e(Context context) {
        this.mContext = context;
        bSU();
    }

    private void bSU() {
        this.gLX = new b("so");
        this.gLY.add(this.gLX);
        this.gLW = new b("source");
        this.gLY.add(this.gLW);
    }

    public boolean bSV() {
        if (this.gLZ == null) {
            this.gLZ = new HashSet();
            for (j jVar : this.gLY) {
                if (!jVar.isReady()) {
                    this.gLZ.add(jVar);
                }
            }
            if (this.gLZ.size() > 0) {
                this.gMa = true;
            } else {
                this.gMa = false;
            }
        }
        return this.gMa;
    }

    public void a(final a aVar) {
        if (!bSV()) {
            aVar.bSW();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.gLZ) {
            jVar.load();
            arrayList.add(jVar.bSN());
        }
        f.a(this.mContext, new com.baidu.tieba.ala.b.a((g[]) arrayList.toArray(new g[0]))).m(new Runnable() { // from class: com.baidu.tieba.ala.b.e.3
            @Override // java.lang.Runnable
            public void run() {
                aVar.bSW();
            }
        }).n(new Runnable() { // from class: com.baidu.tieba.ala.b.e.2
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
