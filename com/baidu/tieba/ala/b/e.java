package com.baidu.tieba.ala.b;

import android.content.Context;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class e {
    private b gJq = null;
    private b gJr = null;
    private Set<j> gJs = new HashSet();
    private Set<j> gJt = null;
    private boolean gJu = false;
    private Context mContext;

    /* loaded from: classes9.dex */
    public interface a {
        void bSt();

        void onCancel();
    }

    public e(Context context) {
        this.mContext = context;
        bSr();
    }

    private void bSr() {
        this.gJr = new b("so");
        this.gJs.add(this.gJr);
        this.gJq = new b("source");
        this.gJs.add(this.gJq);
    }

    public boolean bSs() {
        if (this.gJt == null) {
            this.gJt = new HashSet();
            for (j jVar : this.gJs) {
                if (!jVar.isReady()) {
                    this.gJt.add(jVar);
                }
            }
            if (this.gJt.size() > 0) {
                this.gJu = true;
            } else {
                this.gJu = false;
            }
        }
        return this.gJu;
    }

    public void a(final a aVar) {
        if (!bSs()) {
            aVar.bSt();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.gJt) {
            jVar.load();
            arrayList.add(jVar.bSk());
        }
        f.a(this.mContext, new com.baidu.tieba.ala.b.a((g[]) arrayList.toArray(new g[0]))).o(new Runnable() { // from class: com.baidu.tieba.ala.b.e.3
            @Override // java.lang.Runnable
            public void run() {
                aVar.bSt();
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
