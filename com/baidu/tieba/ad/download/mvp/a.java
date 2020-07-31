package com.baidu.tieba.ad.download.mvp;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tieba.ad.download.d;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes15.dex */
public abstract class a<VIEW extends b, MODEL extends IDownloadModel> {
    private static final String TAG = a.class.getSimpleName();
    private final VIEW fdD;
    private MODEL fdE;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.fdD = view;
        this.fdE = model;
        this.mPage = str;
        View actionBar = this.fdD.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.fdD.bA(view2);
                    a.this.bsl();
                    a.this.a((a) a.this.fdE);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW bsk() {
        return this.fdD;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.fdE = model;
        if (this.fdD != null) {
            bsm();
            this.fdD.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.fdE != null) {
            this.fdD.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                bsm();
            }
        }
    }

    @CallSuper
    public void dE(int i) {
        this.fdD.dE(i);
        if ((this.fdE != null ? this.fdE.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            bsm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsl() {
        MODEL model = this.fdE;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.bsi().a(model.adId(), this.mPage, currentState, model.getPkgName());
                    return;
                default:
                    return;
            }
        }
    }

    private void bsm() {
        if (this.fdD.getRealView().getVisibility() != 0) {
            this.fdD.getRealView().setVisibility(0);
        }
    }
}
