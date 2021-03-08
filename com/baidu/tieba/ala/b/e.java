package com.baidu.tieba.ala.b;

import android.content.Context;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class e {
    private b gNT = null;
    private b gNU = null;
    private Set<j> gNV = new HashSet();
    private Set<j> gNW = null;
    private boolean gNX = false;
    private Context mContext;

    /* loaded from: classes9.dex */
    public interface a {
        void bTj();

        void onCancel();
    }

    public e(Context context) {
        this.mContext = context;
        bTh();
    }

    private void bTh() {
        this.gNU = new b("so");
        this.gNV.add(this.gNU);
        this.gNT = new b("source");
        this.gNV.add(this.gNT);
    }

    public boolean bTi() {
        if (this.gNW == null) {
            this.gNW = new HashSet();
            for (j jVar : this.gNV) {
                if (!jVar.isReady()) {
                    this.gNW.add(jVar);
                }
            }
            if (this.gNW.size() > 0) {
                this.gNX = true;
            } else {
                this.gNX = false;
            }
        }
        return this.gNX;
    }

    public void a(final a aVar) {
        if (!bTi()) {
            aVar.bTj();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.gNW) {
            jVar.load();
            arrayList.add(jVar.bTa());
        }
        f.a(this.mContext, new com.baidu.tieba.ala.b.a((g[]) arrayList.toArray(new g[0]))).l(new Runnable() { // from class: com.baidu.tieba.ala.b.e.3
            @Override // java.lang.Runnable
            public void run() {
                aVar.bTj();
            }
        }).m(new Runnable() { // from class: com.baidu.tieba.ala.b.e.2
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
