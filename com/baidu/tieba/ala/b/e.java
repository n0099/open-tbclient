package com.baidu.tieba.ala.b;

import android.content.Context;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class e {
    private b gCi = null;
    private b gCj = null;
    private Set<j> gCk = new HashSet();
    private Set<j> gCl = null;
    private boolean gCm = false;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void bTE();

        void onCancel();
    }

    public e(Context context) {
        this.mContext = context;
        bTC();
    }

    private void bTC() {
        this.gCj = new b("so");
        this.gCk.add(this.gCj);
        this.gCi = new b("source");
        this.gCk.add(this.gCi);
    }

    public boolean bTD() {
        if (this.gCl == null) {
            this.gCl = new HashSet();
            for (j jVar : this.gCk) {
                if (!jVar.isReady()) {
                    this.gCl.add(jVar);
                }
            }
            if (this.gCl.size() > 0) {
                this.gCm = true;
            } else {
                this.gCm = false;
            }
        }
        return this.gCm;
    }

    public void a(final a aVar) {
        if (!bTD()) {
            aVar.bTE();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.gCl) {
            jVar.load();
            arrayList.add(jVar.bTv());
        }
        f.a(this.mContext, new com.baidu.tieba.ala.b.a((g[]) arrayList.toArray(new g[0]))).p(new Runnable() { // from class: com.baidu.tieba.ala.b.e.3
            @Override // java.lang.Runnable
            public void run() {
                aVar.bTE();
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
