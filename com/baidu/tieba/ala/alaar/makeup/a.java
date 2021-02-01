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
    private List<InterfaceC0609a<T>> grx;
    private Runnable gry;
    private List<b> grw = new ArrayList();
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.baidu.tieba.ala.alaar.makeup.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0609a<T> {
        void b(a<T> aVar);
    }

    /* loaded from: classes11.dex */
    public interface b<T> {
        @MainThread
        void c(a<T> aVar);
    }

    protected abstract boolean bOQ();

    protected abstract boolean bOR();

    public void a(final b bVar) {
        if (!bOQ()) {
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
                this.grw.add(bVar);
            }
            if (this.gry == null) {
                this.gry = new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.bOR()) {
                            a.this.bOS();
                        }
                    }
                };
                ThreadPool.acG().execute(this.gry);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bOS() {
        this.gry = null;
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.a.3
            @Override // java.lang.Runnable
            public void run() {
                for (b bVar : a.this.grw) {
                    bVar.c(a.this);
                }
                a.this.grw.clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bOT() {
        if (this.grx != null && !this.grx.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.grx.size()) {
                    InterfaceC0609a<T> interfaceC0609a = this.grx.get(i2);
                    if (interfaceC0609a != null) {
                        interfaceC0609a.b(this);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
