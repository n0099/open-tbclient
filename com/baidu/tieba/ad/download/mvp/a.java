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
    private final VIEW eAa;
    private MODEL eAb;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.eAa = view;
        this.eAb = model;
        this.mPage = str;
        View actionBar = this.eAa.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.eAa.bq(view2);
                    a.this.bgx();
                    a.this.a((a) a.this.eAb);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW bgw() {
        return this.eAa;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.eAb = model;
        if (this.eAa != null) {
            bgy();
            this.eAa.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.eAb != null) {
            this.eAa.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                bgy();
            }
        }
    }

    @CallSuper
    public void dm(int i) {
        this.eAa.dm(i);
        if ((this.eAb != null ? this.eAb.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            bgy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgx() {
        MODEL model = this.eAb;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.bgu().a(model.adId(), this.mPage, currentState, model.getPkgName());
                    return;
                default:
                    return;
            }
        }
    }

    private void bgy() {
        if (this.eAa.getRealView().getVisibility() != 0) {
            this.eAa.getRealView().setVisibility(0);
        }
    }
}
