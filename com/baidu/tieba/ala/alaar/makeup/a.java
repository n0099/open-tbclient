package com.baidu.tieba.ala.alaar.makeup;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.MainThread;
import com.baidu.minivideo.arface.utils.ThreadPool;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public abstract class a<T> {
    private List<InterfaceC0627a<T>> gtv;
    private Runnable gtw;
    private List<b> gtu = new ArrayList();
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.baidu.tieba.ala.alaar.makeup.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0627a<T> {
        void b(a<T> aVar);
    }

    /* loaded from: classes11.dex */
    public interface b<T> {
        @MainThread
        void c(a<T> aVar);
    }

    protected abstract boolean bSd();

    protected abstract boolean bSe();

    public void a(final b bVar) {
        if (!bSd()) {
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
                this.gtu.add(bVar);
            }
            if (this.gtw == null) {
                this.gtw = new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.bSe()) {
                            a.this.bSf();
                        }
                    }
                };
                ThreadPool.aeK().execute(this.gtw);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSf() {
        this.gtw = null;
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.a.3
            @Override // java.lang.Runnable
            public void run() {
                for (b bVar : a.this.gtu) {
                    bVar.c(a.this);
                }
                a.this.gtu.clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSg() {
        if (this.gtv != null && !this.gtv.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gtv.size()) {
                    InterfaceC0627a<T> interfaceC0627a = this.gtv.get(i2);
                    if (interfaceC0627a != null) {
                        interfaceC0627a.b(this);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
