package com.baidu.tieba.ala.alaar.makeup;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.util.Log;
import com.baidu.minivideo.arface.utils.ThreadPool;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class a<T> {
    private List<InterfaceC0624a<T>> gaJ;
    private Runnable gaK;
    private List<b> gaI = new ArrayList();
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.baidu.tieba.ala.alaar.makeup.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0624a<T> {
        void b(a<T> aVar);
    }

    /* loaded from: classes4.dex */
    public interface b<T> {
        @MainThread
        void c(a<T> aVar);
    }

    protected abstract boolean bLT();

    protected abstract boolean bLU();

    public void a(final b bVar) {
        if (!bLT()) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.c(a.this);
                    }
                }
            });
            if (h.isDebug()) {
                Log.d("DataManager<T>", "getAllData: use cache");
                return;
            }
            return;
        }
        synchronized (this) {
            if (bVar != null) {
                this.gaI.add(bVar);
            }
            if (this.gaK == null) {
                this.gaK = new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.bLU()) {
                            a.this.bLV();
                        }
                    }
                };
                ThreadPool.ZG().execute(this.gaK);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bLV() {
        this.gaK = null;
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.a.3
            @Override // java.lang.Runnable
            public void run() {
                for (b bVar : a.this.gaI) {
                    bVar.c(a.this);
                }
                a.this.gaI.clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bLW() {
        if (this.gaJ != null && !this.gaJ.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gaJ.size()) {
                    InterfaceC0624a<T> interfaceC0624a = this.gaJ.get(i2);
                    if (interfaceC0624a != null) {
                        interfaceC0624a.b(this);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
