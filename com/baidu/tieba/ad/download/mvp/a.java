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
    private final VIEW gav;
    private MODEL gaw;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.gav = view;
        this.gaw = model;
        this.mPage = str;
        View actionBar = this.gav.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!a.this.gav.bZ(view2)) {
                        a.this.bMB();
                        a.this.a((a) a.this.gaw);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW bMA() {
        return this.gav;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.gaw = model;
        if (this.gav != null) {
            bMC();
            this.gav.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.gaw != null) {
            this.gav.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                bMC();
            }
        }
    }

    @CallSuper
    public void fu(int i) {
        this.gav.fu(i);
        if ((this.gaw != null ? this.gaw.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            bMC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMB() {
        MODEL model = this.gaw;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.bMy().a(model.adId(), this.mPage, currentState, model.getPkgName(), model.getExtInfo());
                    return;
                default:
                    return;
            }
        }
    }

    private void bMC() {
        if (this.gav.getRealView().getVisibility() != 0) {
            this.gav.getRealView().setVisibility(0);
        }
    }
}
