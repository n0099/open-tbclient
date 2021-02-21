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
    private List<InterfaceC0610a<T>> grL;
    private Runnable grM;
    private List<b> grK = new ArrayList();
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.baidu.tieba.ala.alaar.makeup.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0610a<T> {
        void b(a<T> aVar);
    }

    /* loaded from: classes11.dex */
    public interface b<T> {
        @MainThread
        void c(a<T> aVar);
    }

    protected abstract boolean bOX();

    protected abstract boolean bOY();

    public void a(final b bVar) {
        if (!bOX()) {
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
                this.grK.add(bVar);
            }
            if (this.grM == null) {
                this.grM = new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.bOY()) {
                            a.this.bOZ();
                        }
                    }
                };
                ThreadPool.acG().execute(this.grM);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bOZ() {
        this.grM = null;
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.a.3
            @Override // java.lang.Runnable
            public void run() {
                for (b bVar : a.this.grK) {
                    bVar.c(a.this);
                }
                a.this.grK.clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bPa() {
        if (this.grL != null && !this.grL.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.grL.size()) {
                    InterfaceC0610a<T> interfaceC0610a = this.grL.get(i2);
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
