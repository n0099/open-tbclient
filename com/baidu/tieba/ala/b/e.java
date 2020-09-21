package com.baidu.tieba.ala.b;

import android.content.Context;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class e {
    private b fRJ = null;
    private b fRK = null;
    private Set<j> fRL = new HashSet();
    private Set<j> fRM = null;
    private boolean fRN = false;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void bIP();

        void onCancel();
    }

    public e(Context context) {
        this.mContext = context;
        bIN();
    }

    private void bIN() {
        this.fRK = new b("so");
        this.fRL.add(this.fRK);
        this.fRJ = new b("source");
        this.fRL.add(this.fRJ);
    }

    public boolean bIO() {
        if (this.fRM == null) {
            this.fRM = new HashSet();
            for (j jVar : this.fRL) {
                if (!jVar.isReady()) {
                    this.fRM.add(jVar);
                }
            }
            if (this.fRM.size() > 0) {
                this.fRN = true;
            } else {
                this.fRN = false;
            }
        }
        return this.fRN;
    }

    public void a(final a aVar) {
        if (!bIO()) {
            aVar.bIP();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.fRM) {
            jVar.load();
            arrayList.add(jVar.bIE());
        }
        f.a(this.mContext, new com.baidu.tieba.ala.b.a((g[]) arrayList.toArray(new g[0]))).p(new Runnable() { // from class: com.baidu.tieba.ala.b.e.3
            @Override // java.lang.Runnable
            public void run() {
                aVar.bIP();
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
