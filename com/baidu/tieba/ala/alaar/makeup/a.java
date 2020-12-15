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
    private List<InterfaceC0636a<T>> giW;
    private Runnable giX;
    private List<b> giV = new ArrayList();
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

    protected abstract boolean bPD();

    protected abstract boolean bPE();

    public void a(final b bVar) {
        if (!bPD()) {
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
                this.giV.add(bVar);
            }
            if (this.giX == null) {
                this.giX = new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.bPE()) {
                            a.this.bPF();
                        }
                    }
                };
                ThreadPool.acO().execute(this.giX);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bPF() {
        this.giX = null;
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.a.3
            @Override // java.lang.Runnable
            public void run() {
                for (b bVar : a.this.giV) {
                    bVar.c(a.this);
                }
                a.this.giV.clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bPG() {
        if (this.giW != null && !this.giW.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.giW.size()) {
                    InterfaceC0636a<T> interfaceC0636a = this.giW.get(i2);
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
