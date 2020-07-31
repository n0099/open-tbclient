package com.baidu.tieba.ala.a;

import android.content.Context;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class e {
    private b fDd = null;
    private b fDe = null;
    private Set<j> fDf = new HashSet();
    private Set<j> fDg = null;
    private boolean fDh = false;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void byD();

        void onCancel();
    }

    public e(Context context) {
        this.mContext = context;
        initResource();
    }

    private void initResource() {
        this.fDe = new b("so");
        this.fDf.add(this.fDe);
        this.fDd = new b("source");
        this.fDf.add(this.fDd);
    }

    public boolean byC() {
        if (this.fDg == null) {
            this.fDg = new HashSet();
            for (j jVar : this.fDf) {
                if (!jVar.isReady()) {
                    this.fDg.add(jVar);
                }
            }
            if (this.fDg.size() > 0) {
                this.fDh = true;
            } else {
                this.fDh = false;
            }
        }
        return this.fDh;
    }

    public void a(final a aVar) {
        if (!byC()) {
            aVar.byD();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.fDg) {
            jVar.load();
            arrayList.add(jVar.byu());
        }
        f.a(this.mContext, new com.baidu.tieba.ala.a.a((g[]) arrayList.toArray(new g[0]))).s(new Runnable() { // from class: com.baidu.tieba.ala.a.e.3
            @Override // java.lang.Runnable
            public void run() {
                aVar.byD();
            }
        }).t(new Runnable() { // from class: com.baidu.tieba.ala.a.e.2
            @Override // java.lang.Runnable
            public void run() {
                aVar.onCancel();
            }
        }).c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.a.e.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
            }
        }).show();
    }
}
