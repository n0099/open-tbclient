package com.baidu.tieba.ad.download.mvp;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tieba.ad.download.d;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes20.dex */
public abstract class a<VIEW extends b, MODEL extends IDownloadModel> {
    private static final String TAG = a.class.getSimpleName();
    private final VIEW fSj;
    private MODEL fSk;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.fSj = view;
        this.fSk = model;
        this.mPage = str;
        View actionBar = this.fSj.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!a.this.fSj.bS(view2)) {
                        a.this.bIS();
                        a.this.a((a) a.this.fSk);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW bIR() {
        return this.fSj;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.fSk = model;
        if (this.fSj != null) {
            bIT();
            this.fSj.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.fSk != null) {
            this.fSj.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                bIT();
            }
        }
    }

    @CallSuper
    public void eW(int i) {
        this.fSj.eW(i);
        if ((this.fSk != null ? this.fSk.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            bIT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIS() {
        MODEL model = this.fSk;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.bIP().a(model.adId(), this.mPage, currentState, model.getPkgName(), model.getExtInfo());
                    return;
                default:
                    return;
            }
        }
    }

    private void bIT() {
        if (this.fSj.getRealView().getVisibility() != 0) {
            this.fSj.getRealView().setVisibility(0);
        }
    }
}
