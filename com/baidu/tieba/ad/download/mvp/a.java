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
    private final VIEW fEr;
    private MODEL fEs;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.fEr = view;
        this.fEs = model;
        this.mPage = str;
        View actionBar = this.fEr.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!a.this.fEr.bK(view2)) {
                        a.this.bFh();
                        a.this.a((a) a.this.fEs);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW bFg() {
        return this.fEr;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.fEs = model;
        if (this.fEr != null) {
            bFi();
            this.fEr.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.fEs != null) {
            this.fEr.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                bFi();
            }
        }
    }

    @CallSuper
    public void eX(int i) {
        this.fEr.eX(i);
        if ((this.fEs != null ? this.fEs.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            bFi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFh() {
        MODEL model = this.fEs;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.bFe().a(model.adId(), this.mPage, currentState, model.getPkgName(), model.getExtInfo());
                    return;
                default:
                    return;
            }
        }
    }

    private void bFi() {
        if (this.fEr.getRealView().getVisibility() != 0) {
            this.fEr.getRealView().setVisibility(0);
        }
    }
}
