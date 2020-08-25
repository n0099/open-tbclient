package com.baidu.tieba.ala.a;

import android.content.Context;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class e {
    private b fOu = null;
    private b fOv = null;
    private Set<j> fOw = new HashSet();
    private Set<j> fOx = null;
    private boolean fOy = false;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void bHG();

        void onCancel();
    }

    public e(Context context) {
        this.mContext = context;
        bHE();
    }

    private void bHE() {
        this.fOv = new b("so");
        this.fOw.add(this.fOv);
        this.fOu = new b("source");
        this.fOw.add(this.fOu);
    }

    public boolean bHF() {
        if (this.fOx == null) {
            this.fOx = new HashSet();
            for (j jVar : this.fOw) {
                if (!jVar.isReady()) {
                    this.fOx.add(jVar);
                }
            }
            if (this.fOx.size() > 0) {
                this.fOy = true;
            } else {
                this.fOy = false;
            }
        }
        return this.fOy;
    }

    public void a(final a aVar) {
        if (!bHF()) {
            aVar.bHG();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.fOx) {
            jVar.load();
            arrayList.add(jVar.bHv());
        }
        f.a(this.mContext, new com.baidu.tieba.ala.a.a((g[]) arrayList.toArray(new g[0]))).p(new Runnable() { // from class: com.baidu.tieba.ala.a.e.3
            @Override // java.lang.Runnable
            public void run() {
                aVar.bHG();
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
