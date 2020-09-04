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
    private final VIEW foZ;
    private MODEL fpa;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.foZ = view;
        this.fpa = model;
        this.mPage = str;
        View actionBar = this.foZ.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!a.this.foZ.bC(view2)) {
                        a.this.bBj();
                        a.this.a((a) a.this.fpa);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW bBi() {
        return this.foZ;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.fpa = model;
        if (this.foZ != null) {
            bBk();
            this.foZ.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.fpa != null) {
            this.foZ.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                bBk();
            }
        }
    }

    @CallSuper
    public void fy(int i) {
        this.foZ.fy(i);
        if ((this.fpa != null ? this.fpa.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            bBk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBj() {
        MODEL model = this.fpa;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.bBg().a(model.adId(), this.mPage, currentState, model.getPkgName(), model.getExtInfo());
                    return;
                default:
                    return;
            }
        }
    }

    private void bBk() {
        if (this.foZ.getRealView().getVisibility() != 0) {
            this.foZ.getRealView().setVisibility(0);
        }
    }
}
