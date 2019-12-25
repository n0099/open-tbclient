package com.baidu.tieba.ad.download.mvp;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tieba.ad.download.d;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes5.dex */
public abstract class a<VIEW extends b, MODEL extends IDownloadModel> {
    private static final String TAG = a.class.getSimpleName();
    private final VIEW dVm;
    private MODEL dVn;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.dVm = view;
        this.dVn = model;
        this.mPage = str;
        View actionBar = this.dVm.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.dVm.bl(view2);
                    a.this.aVD();
                    a.this.a((a) a.this.dVn);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW aVC() {
        return this.dVm;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.dVn = model;
        if (this.dVm != null) {
            aVE();
            this.dVm.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.dVn != null) {
            this.dVm.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                aVE();
            }
        }
    }

    @CallSuper
    public void cG(int i) {
        this.dVm.cG(i);
        if ((this.dVn != null ? this.dVn.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            aVE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVD() {
        MODEL model = this.dVn;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.aVA().a(model.adId(), this.mPage, currentState, model.getPkgName());
                    return;
                default:
                    return;
            }
        }
    }

    private void aVE() {
        if (this.dVm.getRealView().getVisibility() != 0) {
            this.dVm.getRealView().setVisibility(0);
        }
    }
}
