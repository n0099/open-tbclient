package com.baidu.tieba.ala.b;

import android.content.Context;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class e {
    private b gof = null;
    private b gog = null;
    private Set<j> goh = new HashSet();
    private Set<j> goi = null;
    private boolean goj = false;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void bOb();

        void onCancel();
    }

    public e(Context context) {
        this.mContext = context;
        bNZ();
    }

    private void bNZ() {
        this.gog = new b("so");
        this.goh.add(this.gog);
        this.gof = new b("source");
        this.goh.add(this.gof);
    }

    public boolean bOa() {
        if (this.goi == null) {
            this.goi = new HashSet();
            for (j jVar : this.goh) {
                if (!jVar.isReady()) {
                    this.goi.add(jVar);
                }
            }
            if (this.goi.size() > 0) {
                this.goj = true;
            } else {
                this.goj = false;
            }
        }
        return this.goj;
    }

    public void a(final a aVar) {
        if (!bOa()) {
            aVar.bOb();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.goi) {
            jVar.load();
            arrayList.add(jVar.bNQ());
        }
        f.a(this.mContext, new com.baidu.tieba.ala.b.a((g[]) arrayList.toArray(new g[0]))).p(new Runnable() { // from class: com.baidu.tieba.ala.b.e.3
            @Override // java.lang.Runnable
            public void run() {
                aVar.bOb();
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
