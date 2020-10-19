package com.baidu.tieba.ala.b;

import android.content.Context;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class e {
    private b geb = null;
    private b gec = null;
    private Set<j> ged = new HashSet();
    private Set<j> gee = null;
    private boolean gef = false;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void bLz();

        void onCancel();
    }

    public e(Context context) {
        this.mContext = context;
        bLx();
    }

    private void bLx() {
        this.gec = new b("so");
        this.ged.add(this.gec);
        this.geb = new b("source");
        this.ged.add(this.geb);
    }

    public boolean bLy() {
        if (this.gee == null) {
            this.gee = new HashSet();
            for (j jVar : this.ged) {
                if (!jVar.isReady()) {
                    this.gee.add(jVar);
                }
            }
            if (this.gee.size() > 0) {
                this.gef = true;
            } else {
                this.gef = false;
            }
        }
        return this.gef;
    }

    public void a(final a aVar) {
        if (!bLy()) {
            aVar.bLz();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.gee) {
            jVar.load();
            arrayList.add(jVar.bLo());
        }
        f.a(this.mContext, new com.baidu.tieba.ala.b.a((g[]) arrayList.toArray(new g[0]))).p(new Runnable() { // from class: com.baidu.tieba.ala.b.e.3
            @Override // java.lang.Runnable
            public void run() {
                aVar.bLz();
            }
        }).q(new Runnable() { // from class: com.baidu.tieba.ala.b.e.2
            @Override // java.lang.Runnable
            public void run() {
                aVar.onCancel();
            }
        }).d(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.b.e.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
            }
        }).show();
    }
}
