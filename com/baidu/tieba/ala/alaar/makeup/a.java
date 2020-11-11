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
    private List<InterfaceC0624a<T>> gbc;
    private Runnable gbd;
    private List<b> gbb = new ArrayList();
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

    protected abstract boolean bMA();

    protected abstract boolean bMB();

    public void a(final b bVar) {
        if (!bMA()) {
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
                this.gbb.add(bVar);
            }
            if (this.gbd == null) {
                this.gbd = new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.bMB()) {
                            a.this.bMC();
                        }
                    }
                };
                ThreadPool.aap().execute(this.gbd);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bMC() {
        this.gbd = null;
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.a.3
            @Override // java.lang.Runnable
            public void run() {
                for (b bVar : a.this.gbb) {
                    bVar.c(a.this);
                }
                a.this.gbb.clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bMD() {
        if (this.gbc != null && !this.gbc.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gbc.size()) {
                    InterfaceC0624a<T> interfaceC0624a = this.gbc.get(i2);
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
