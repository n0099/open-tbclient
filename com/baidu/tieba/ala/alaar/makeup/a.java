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
    private List<InterfaceC0610a<T>> goO;
    private Runnable goP;
    private List<b> goN = new ArrayList();
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.baidu.tieba.ala.alaar.makeup.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0610a<T> {
        void b(a<T> aVar);
    }

    /* loaded from: classes10.dex */
    public interface b<T> {
        @MainThread
        void c(a<T> aVar);
    }

    protected abstract boolean bOm();

    protected abstract boolean bOn();

    public void a(final b bVar) {
        if (!bOm()) {
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
                this.goN.add(bVar);
            }
            if (this.goP == null) {
                this.goP = new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.bOn()) {
                            a.this.bOo();
                        }
                    }
                };
                ThreadPool.aaS().execute(this.goP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bOo() {
        this.goP = null;
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.a.3
            @Override // java.lang.Runnable
            public void run() {
                for (b bVar : a.this.goN) {
                    bVar.c(a.this);
                }
                a.this.goN.clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bOp() {
        if (this.goO != null && !this.goO.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.goO.size()) {
                    InterfaceC0610a<T> interfaceC0610a = this.goO.get(i2);
                    if (interfaceC0610a != null) {
                        interfaceC0610a.b(this);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
