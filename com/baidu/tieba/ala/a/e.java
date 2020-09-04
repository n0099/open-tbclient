package com.baidu.tieba.ala.a;

import android.content.Context;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class e {
    private Context mContext;
    private b fOy = null;
    private b fOz = null;
    private Set<j> fOA = new HashSet();
    private Set<j> fOB = null;
    private boolean fOC = false;

    /* loaded from: classes4.dex */
    public interface a {
        void bHH();

        void onCancel();
    }

    public e(Context context) {
        this.mContext = context;
        bHF();
    }

    private void bHF() {
        this.fOz = new b("so");
        this.fOA.add(this.fOz);
        this.fOy = new b("source");
        this.fOA.add(this.fOy);
    }

    public boolean bHG() {
        if (this.fOB == null) {
            this.fOB = new HashSet();
            for (j jVar : this.fOA) {
                if (!jVar.isReady()) {
                    this.fOB.add(jVar);
                }
            }
            if (this.fOB.size() > 0) {
                this.fOC = true;
            } else {
                this.fOC = false;
            }
        }
        return this.fOC;
    }

    public void a(final a aVar) {
        if (!bHG()) {
            aVar.bHH();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.fOB) {
            jVar.load();
            arrayList.add(jVar.bHw());
        }
        f.a(this.mContext, new com.baidu.tieba.ala.a.a((g[]) arrayList.toArray(new g[0]))).p(new Runnable() { // from class: com.baidu.tieba.ala.a.e.3
            @Override // java.lang.Runnable
            public void run() {
                aVar.bHH();
            }
        }).q(new Runnable() { // from class: com.baidu.tieba.ala.a.e.2
            @Override // java.lang.Runnable
            public void run() {
                aVar.onCancel();
            }
        }).d(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.a.e.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
            }
        }).show();
    }
}
