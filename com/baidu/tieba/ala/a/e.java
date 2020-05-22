package com.baidu.tieba.ala.a;

import android.content.Context;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class e {
    private Context mContext;
    private b fmx = null;
    private b fmy = null;
    private Set<j> fmz = new HashSet();
    private Set<j> fmA = null;
    private boolean fmB = false;

    /* loaded from: classes3.dex */
    public interface a {
        void bsw();

        void onCancel();
    }

    public e(Context context) {
        this.mContext = context;
        initResource();
    }

    private void initResource() {
        this.fmy = new b("so");
        this.fmz.add(this.fmy);
        this.fmx = new b("source");
        this.fmz.add(this.fmx);
    }

    public boolean bsv() {
        if (this.fmA == null) {
            this.fmA = new HashSet();
            for (j jVar : this.fmz) {
                if (!jVar.isReady()) {
                    this.fmA.add(jVar);
                }
            }
            if (this.fmA.size() > 0) {
                this.fmB = true;
            } else {
                this.fmB = false;
            }
        }
        return this.fmB;
    }

    public void a(final a aVar) {
        if (!bsv()) {
            aVar.bsw();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.fmA) {
            jVar.load();
            arrayList.add(jVar.bsn());
        }
        f.a(this.mContext, new com.baidu.tieba.ala.a.a((g[]) arrayList.toArray(new g[0]))).t(new Runnable() { // from class: com.baidu.tieba.ala.a.e.3
            @Override // java.lang.Runnable
            public void run() {
                aVar.bsw();
            }
        }).u(new Runnable() { // from class: com.baidu.tieba.ala.a.e.2
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
