package com.baidu.tieba.ad.download.mvp;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tieba.ad.download.d;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes8.dex */
public abstract class a<VIEW extends b, MODEL extends IDownloadModel> {
    private static final String TAG = a.class.getSimpleName();
    private final VIEW eOQ;
    private MODEL eOR;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.eOQ = view;
        this.eOR = model;
        this.mPage = str;
        View actionBar = this.eOQ.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.eOQ.br(view2);
                    a.this.bmI();
                    a.this.a((a) a.this.eOR);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW bmH() {
        return this.eOQ;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.eOR = model;
        if (this.eOQ != null) {
            bmJ();
            this.eOQ.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.eOR != null) {
            this.eOQ.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                bmJ();
            }
        }
    }

    @CallSuper
    public void dt(int i) {
        this.eOQ.dt(i);
        if ((this.eOR != null ? this.eOR.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            bmJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmI() {
        MODEL model = this.eOR;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.bmF().a(model.adId(), this.mPage, currentState, model.getPkgName());
                    return;
                default:
                    return;
            }
        }
    }

    private void bmJ() {
        if (this.eOQ.getRealView().getVisibility() != 0) {
            this.eOQ.getRealView().setVisibility(0);
        }
    }
}
