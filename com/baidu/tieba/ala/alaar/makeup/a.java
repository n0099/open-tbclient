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
    private List<InterfaceC0636a<T>> giU;
    private Runnable giV;
    private List<b> giT = new ArrayList();
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.baidu.tieba.ala.alaar.makeup.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0636a<T> {
        void b(a<T> aVar);
    }

    /* loaded from: classes4.dex */
    public interface b<T> {
        @MainThread
        void c(a<T> aVar);
    }

    protected abstract boolean bPC();

    protected abstract boolean bPD();

    public void a(final b bVar) {
        if (!bPC()) {
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
                this.giT.add(bVar);
            }
            if (this.giV == null) {
                this.giV = new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.bPD()) {
                            a.this.bPE();
                        }
                    }
                };
                ThreadPool.acO().execute(this.giV);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bPE() {
        this.giV = null;
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.a.3
            @Override // java.lang.Runnable
            public void run() {
                for (b bVar : a.this.giT) {
                    bVar.c(a.this);
                }
                a.this.giT.clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bPF() {
        if (this.giU != null && !this.giU.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.giU.size()) {
                    InterfaceC0636a<T> interfaceC0636a = this.giU.get(i2);
                    if (interfaceC0636a != null) {
                        interfaceC0636a.b(this);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
