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
    private List<InterfaceC0612a<T>> fVl;
    private Runnable fVm;
    private List<b> fVk = new ArrayList();
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.baidu.tieba.ala.alaar.makeup.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0612a<T> {
        void b(a<T> aVar);
    }

    /* loaded from: classes4.dex */
    public interface b<T> {
        @MainThread
        void c(a<T> aVar);
    }

    protected abstract boolean bKb();

    protected abstract boolean bKc();

    public void a(final b bVar) {
        if (!bKb()) {
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
                this.fVk.add(bVar);
            }
            if (this.fVm == null) {
                this.fVm = new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.bKc()) {
                            a.this.bKd();
                        }
                    }
                };
                ThreadPool.XQ().execute(this.fVm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bKd() {
        this.fVm = null;
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.a.3
            @Override // java.lang.Runnable
            public void run() {
                for (b bVar : a.this.fVk) {
                    bVar.c(a.this);
                }
                a.this.fVk.clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bKe() {
        if (this.fVl != null && !this.fVl.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fVl.size()) {
                    InterfaceC0612a<T> interfaceC0612a = this.fVl.get(i2);
                    if (interfaceC0612a != null) {
                        interfaceC0612a.b(this);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
