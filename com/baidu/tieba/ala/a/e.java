package com.baidu.tieba.ala.a;

import android.content.Context;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class e {
    private b eZN = null;
    private b eZO = null;
    private Set<j> eZP = new HashSet();
    private Set<j> eZQ = null;
    private boolean eZR = false;
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void bmY();

        void onCancel();
    }

    public e(Context context) {
        this.mContext = context;
        initResource();
    }

    private void initResource() {
        this.eZO = new b("so");
        this.eZP.add(this.eZO);
        this.eZN = new b("source");
        this.eZP.add(this.eZN);
    }

    public boolean bmX() {
        if (this.eZQ == null) {
            this.eZQ = new HashSet();
            for (j jVar : this.eZP) {
                if (!jVar.isReady()) {
                    this.eZQ.add(jVar);
                }
            }
            if (this.eZQ.size() > 0) {
                this.eZR = true;
            } else {
                this.eZR = false;
            }
        }
        return this.eZR;
    }

    public void a(final a aVar) {
        if (!bmX()) {
            aVar.bmY();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.eZQ) {
            jVar.load();
            arrayList.add(jVar.bmP());
        }
        f.a(this.mContext, new com.baidu.tieba.ala.a.a((g[]) arrayList.toArray(new g[0]))).r(new Runnable() { // from class: com.baidu.tieba.ala.a.e.3
            @Override // java.lang.Runnable
            public void run() {
                aVar.bmY();
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
