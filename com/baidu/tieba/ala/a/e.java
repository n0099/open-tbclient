package com.baidu.tieba.ala.a;

import android.content.Context;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class e {
    private b fmI = null;
    private b fmJ = null;
    private Set<j> fmK = new HashSet();
    private Set<j> fmL = null;
    private boolean fmM = false;
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void bsy();

        void onCancel();
    }

    public e(Context context) {
        this.mContext = context;
        initResource();
    }

    private void initResource() {
        this.fmJ = new b("so");
        this.fmK.add(this.fmJ);
        this.fmI = new b("source");
        this.fmK.add(this.fmI);
    }

    public boolean bsx() {
        if (this.fmL == null) {
            this.fmL = new HashSet();
            for (j jVar : this.fmK) {
                if (!jVar.isReady()) {
                    this.fmL.add(jVar);
                }
            }
            if (this.fmL.size() > 0) {
                this.fmM = true;
            } else {
                this.fmM = false;
            }
        }
        return this.fmM;
    }

    public void a(final a aVar) {
        if (!bsx()) {
            aVar.bsy();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.fmL) {
            jVar.load();
            arrayList.add(jVar.bsp());
        }
        f.a(this.mContext, new com.baidu.tieba.ala.a.a((g[]) arrayList.toArray(new g[0]))).t(new Runnable() { // from class: com.baidu.tieba.ala.a.e.3
            @Override // java.lang.Runnable
            public void run() {
                aVar.bsy();
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
