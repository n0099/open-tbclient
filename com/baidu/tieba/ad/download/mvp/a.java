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
    private final VIEW foV;
    private MODEL foW;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.foV = view;
        this.foW = model;
        this.mPage = str;
        View actionBar = this.foV.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!a.this.foV.bC(view2)) {
                        a.this.bBi();
                        a.this.a((a) a.this.foW);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW bBh() {
        return this.foV;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.foW = model;
        if (this.foV != null) {
            bBj();
            this.foV.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.foW != null) {
            this.foV.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                bBj();
            }
        }
    }

    @CallSuper
    public void fy(int i) {
        this.foV.fy(i);
        if ((this.foW != null ? this.foW.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            bBj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBi() {
        MODEL model = this.foW;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.bBf().a(model.adId(), this.mPage, currentState, model.getPkgName());
                    return;
                default:
                    return;
            }
        }
    }

    private void bBj() {
        if (this.foV.getRealView().getVisibility() != 0) {
            this.foV.getRealView().setVisibility(0);
        }
    }
}
