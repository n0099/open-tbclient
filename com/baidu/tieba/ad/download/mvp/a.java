package com.baidu.tieba.ad.download.mvp;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tieba.ad.download.d;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes21.dex */
public abstract class a<VIEW extends b, MODEL extends IDownloadModel> {
    private static final String TAG = a.class.getSimpleName();
    private final VIEW gat;
    private MODEL gau;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.gat = view;
        this.gau = model;
        this.mPage = str;
        View actionBar = this.gat.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!a.this.gat.bZ(view2)) {
                        a.this.bMA();
                        a.this.a((a) a.this.gau);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW bMz() {
        return this.gat;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.gau = model;
        if (this.gat != null) {
            bMB();
            this.gat.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.gau != null) {
            this.gat.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                bMB();
            }
        }
    }

    @CallSuper
    public void fu(int i) {
        this.gat.fu(i);
        if ((this.gau != null ? this.gau.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            bMB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMA() {
        MODEL model = this.gau;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.bMx().a(model.adId(), this.mPage, currentState, model.getPkgName(), model.getExtInfo());
                    return;
                default:
                    return;
            }
        }
    }

    private void bMB() {
        if (this.gat.getRealView().getVisibility() != 0) {
            this.gat.getRealView().setVisibility(0);
        }
    }
}
