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
    private final VIEW fMM;
    private MODEL fMN;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.fMM = view;
        this.fMN = model;
        this.mPage = str;
        View actionBar = this.fMM.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!a.this.fMM.bL(view2)) {
                        a.this.bHa();
                        a.this.a((a) a.this.fMN);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW bGZ() {
        return this.fMM;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.fMN = model;
        if (this.fMM != null) {
            bHb();
            this.fMM.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.fMN != null) {
            this.fMM.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                bHb();
            }
        }
    }

    @CallSuper
    public void fa(int i) {
        this.fMM.fa(i);
        if ((this.fMN != null ? this.fMN.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            bHb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHa() {
        MODEL model = this.fMN;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.bGX().a(model.adId(), this.mPage, currentState, model.getPkgName(), model.getExtInfo());
                    return;
                default:
                    return;
            }
        }
    }

    private void bHb() {
        if (this.fMM.getRealView().getVisibility() != 0) {
            this.fMM.getRealView().setVisibility(0);
        }
    }
}
