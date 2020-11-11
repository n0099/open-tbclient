package com.baidu.tieba.ala.b;

import android.content.Context;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class e {
    private b gtS = null;
    private b gtT = null;
    private Set<j> gtU = new HashSet();
    private Set<j> gtV = null;
    private boolean gtW = false;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void bQB();

        void onCancel();
    }

    public e(Context context) {
        this.mContext = context;
        bQz();
    }

    private void bQz() {
        this.gtT = new b("so");
        this.gtU.add(this.gtT);
        this.gtS = new b("source");
        this.gtU.add(this.gtS);
    }

    public boolean bQA() {
        if (this.gtV == null) {
            this.gtV = new HashSet();
            for (j jVar : this.gtU) {
                if (!jVar.isReady()) {
                    this.gtV.add(jVar);
                }
            }
            if (this.gtV.size() > 0) {
                this.gtW = true;
            } else {
                this.gtW = false;
            }
        }
        return this.gtW;
    }

    public void a(final a aVar) {
        if (!bQA()) {
            aVar.bQB();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.gtV) {
            jVar.load();
            arrayList.add(jVar.bQq());
        }
        f.a(this.mContext, new com.baidu.tieba.ala.b.a((g[]) arrayList.toArray(new g[0]))).p(new Runnable() { // from class: com.baidu.tieba.ala.b.e.3
            @Override // java.lang.Runnable
            public void run() {
                aVar.bQB();
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
