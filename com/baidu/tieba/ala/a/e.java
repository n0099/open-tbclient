package com.baidu.tieba.ala.a;

import android.content.Context;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class e {
    private b eZI = null;
    private b eZJ = null;
    private Set<j> eZK = new HashSet();
    private Set<j> eZL = null;
    private boolean eZM = false;
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void bna();

        void onCancel();
    }

    public e(Context context) {
        this.mContext = context;
        initResource();
    }

    private void initResource() {
        this.eZJ = new b("so");
        this.eZK.add(this.eZJ);
        this.eZI = new b("source");
        this.eZK.add(this.eZI);
    }

    public boolean bmZ() {
        if (this.eZL == null) {
            this.eZL = new HashSet();
            for (j jVar : this.eZK) {
                if (!jVar.isReady()) {
                    this.eZL.add(jVar);
                }
            }
            if (this.eZL.size() > 0) {
                this.eZM = true;
            } else {
                this.eZM = false;
            }
        }
        return this.eZM;
    }

    public void a(final a aVar) {
        if (!bmZ()) {
            aVar.bna();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.eZL) {
            jVar.load();
            arrayList.add(jVar.bmR());
        }
        f.a(this.mContext, new com.baidu.tieba.ala.a.a((g[]) arrayList.toArray(new g[0]))).r(new Runnable() { // from class: com.baidu.tieba.ala.a.e.3
            @Override // java.lang.Runnable
            public void run() {
                aVar.bna();
            }
        }).s(new Runnable() { // from class: com.baidu.tieba.ala.a.e.2
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
