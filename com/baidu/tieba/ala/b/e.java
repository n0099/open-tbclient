package com.baidu.tieba.ala.b;

import android.content.Context;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public class e {
    private b gMk = null;
    private b gMl = null;
    private Set<j> gMm = new HashSet();
    private Set<j> gMn = null;
    private boolean gMo = false;
    private Context mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void bTd();

        void onCancel();
    }

    public e(Context context) {
        this.mContext = context;
        bTb();
    }

    private void bTb() {
        this.gMl = new b("so");
        this.gMm.add(this.gMl);
        this.gMk = new b("source");
        this.gMm.add(this.gMk);
    }

    public boolean bTc() {
        if (this.gMn == null) {
            this.gMn = new HashSet();
            for (j jVar : this.gMm) {
                if (!jVar.isReady()) {
                    this.gMn.add(jVar);
                }
            }
            if (this.gMn.size() > 0) {
                this.gMo = true;
            } else {
                this.gMo = false;
            }
        }
        return this.gMo;
    }

    public void a(final a aVar) {
        if (!bTc()) {
            aVar.bTd();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.gMn) {
            jVar.load();
            arrayList.add(jVar.bSU());
        }
        f.a(this.mContext, new com.baidu.tieba.ala.b.a((g[]) arrayList.toArray(new g[0]))).m(new Runnable() { // from class: com.baidu.tieba.ala.b.e.3
            @Override // java.lang.Runnable
            public void run() {
                aVar.bTd();
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
