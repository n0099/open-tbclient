package com.baidu.tieba.ad.download.mvp;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tieba.ad.download.d;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes6.dex */
public abstract class a<VIEW extends b, MODEL extends IDownloadModel> {
    private static final String TAG = a.class.getSimpleName();
    private final VIEW dVv;
    private MODEL dVw;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.dVv = view;
        this.dVw = model;
        this.mPage = str;
        View actionBar = this.dVv.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.dVv.bp(view2);
                    a.this.aVW();
                    a.this.a((a) a.this.dVw);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW aVV() {
        return this.dVv;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.dVw = model;
        if (this.dVv != null) {
            aVX();
            this.dVv.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.dVw != null) {
            this.dVv.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                aVX();
            }
        }
    }

    @CallSuper
    public void cH(int i) {
        this.dVv.cH(i);
        if ((this.dVw != null ? this.dVw.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            aVX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVW() {
        MODEL model = this.dVw;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.aVT().a(model.adId(), this.mPage, currentState, model.getPkgName());
                    return;
                default:
                    return;
            }
        }
    }

    private void aVX() {
        if (this.dVv.getRealView().getVisibility() != 0) {
            this.dVv.getRealView().setVisibility(0);
        }
    }
}
