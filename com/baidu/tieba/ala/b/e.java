package com.baidu.tieba.ala.b;

import android.content.Context;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class e {
    private Context mContext;
    private b gtz = null;
    private b gtA = null;
    private Set<j> gtB = new HashSet();
    private Set<j> gtC = null;
    private boolean gtD = false;

    /* loaded from: classes4.dex */
    public interface a {
        void bPU();

        void onCancel();
    }

    public e(Context context) {
        this.mContext = context;
        bPS();
    }

    private void bPS() {
        this.gtA = new b("so");
        this.gtB.add(this.gtA);
        this.gtz = new b("source");
        this.gtB.add(this.gtz);
    }

    public boolean bPT() {
        if (this.gtC == null) {
            this.gtC = new HashSet();
            for (j jVar : this.gtB) {
                if (!jVar.isReady()) {
                    this.gtC.add(jVar);
                }
            }
            if (this.gtC.size() > 0) {
                this.gtD = true;
            } else {
                this.gtD = false;
            }
        }
        return this.gtD;
    }

    public void a(final a aVar) {
        if (!bPT()) {
            aVar.bPU();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.gtC) {
            jVar.load();
            arrayList.add(jVar.bPJ());
        }
        f.a(this.mContext, new com.baidu.tieba.ala.b.a((g[]) arrayList.toArray(new g[0]))).p(new Runnable() { // from class: com.baidu.tieba.ala.b.e.3
            @Override // java.lang.Runnable
            public void run() {
                aVar.bPU();
            }
        }).q(new Runnable() { // from class: com.baidu.tieba.ala.b.e.2
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
