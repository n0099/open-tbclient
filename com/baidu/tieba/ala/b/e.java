package com.baidu.tieba.ala.b;

import android.content.Context;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class e {
    private b gCk = null;
    private b gCl = null;
    private Set<j> gCm = new HashSet();
    private Set<j> gCn = null;
    private boolean gCo = false;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void bTF();

        void onCancel();
    }

    public e(Context context) {
        this.mContext = context;
        bTD();
    }

    private void bTD() {
        this.gCl = new b("so");
        this.gCm.add(this.gCl);
        this.gCk = new b("source");
        this.gCm.add(this.gCk);
    }

    public boolean bTE() {
        if (this.gCn == null) {
            this.gCn = new HashSet();
            for (j jVar : this.gCm) {
                if (!jVar.isReady()) {
                    this.gCn.add(jVar);
                }
            }
            if (this.gCn.size() > 0) {
                this.gCo = true;
            } else {
                this.gCo = false;
            }
        }
        return this.gCo;
    }

    public void a(final a aVar) {
        if (!bTE()) {
            aVar.bTF();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.gCn) {
            jVar.load();
            arrayList.add(jVar.bTw());
        }
        f.a(this.mContext, new com.baidu.tieba.ala.b.a((g[]) arrayList.toArray(new g[0]))).p(new Runnable() { // from class: com.baidu.tieba.ala.b.e.3
            @Override // java.lang.Runnable
            public void run() {
                aVar.bTF();
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
