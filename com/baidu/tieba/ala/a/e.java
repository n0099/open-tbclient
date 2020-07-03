package com.baidu.tieba.ala.a;

import android.content.Context;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class e {
    private b fxW = null;
    private b fxX = null;
    private Set<j> fxY = new HashSet();
    private Set<j> fxZ = null;
    private boolean fya = false;
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void bvt();

        void onCancel();
    }

    public e(Context context) {
        this.mContext = context;
        initResource();
    }

    private void initResource() {
        this.fxX = new b("so");
        this.fxY.add(this.fxX);
        this.fxW = new b("source");
        this.fxY.add(this.fxW);
    }

    public boolean bvs() {
        if (this.fxZ == null) {
            this.fxZ = new HashSet();
            for (j jVar : this.fxY) {
                if (!jVar.isReady()) {
                    this.fxZ.add(jVar);
                }
            }
            if (this.fxZ.size() > 0) {
                this.fya = true;
            } else {
                this.fya = false;
            }
        }
        return this.fya;
    }

    public void a(final a aVar) {
        if (!bvs()) {
            aVar.bvt();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.fxZ) {
            jVar.load();
            arrayList.add(jVar.bvk());
        }
        f.a(this.mContext, new com.baidu.tieba.ala.a.a((g[]) arrayList.toArray(new g[0]))).t(new Runnable() { // from class: com.baidu.tieba.ala.a.e.3
            @Override // java.lang.Runnable
            public void run() {
                aVar.bvt();
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
