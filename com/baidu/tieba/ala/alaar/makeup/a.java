package com.baidu.tieba.ala.alaar.makeup;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.MainThread;
import com.baidu.minivideo.arface.utils.ThreadPool;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class a<T> {
    private List<InterfaceC0616a<T>> gtu;
    private Runnable gtv;
    private List<b> gtt = new ArrayList();
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.baidu.tieba.ala.alaar.makeup.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0616a<T> {
        void b(a<T> aVar);
    }

    /* loaded from: classes10.dex */
    public interface b<T> {
        @MainThread
        void c(a<T> aVar);
    }

    protected abstract boolean bPd();

    protected abstract boolean bPe();

    public void a(final b bVar) {
        if (!bPd()) {
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
                this.gtt.add(bVar);
            }
            if (this.gtv == null) {
                this.gtv = new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.bPe()) {
                            a.this.bPf();
                        }
                    }
                };
                ThreadPool.acJ().execute(this.gtv);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bPf() {
        this.gtv = null;
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.a.3
            @Override // java.lang.Runnable
            public void run() {
                for (b bVar : a.this.gtt) {
                    bVar.c(a.this);
                }
                a.this.gtt.clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bPg() {
        if (this.gtu != null && !this.gtu.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gtu.size()) {
                    InterfaceC0616a<T> interfaceC0616a = this.gtu.get(i2);
                    if (interfaceC0616a != null) {
                        interfaceC0616a.b(this);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
