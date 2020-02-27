package com.baidu.tieba.ad.download.mvp;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tieba.ad.download.d;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes8.dex */
public abstract class a<VIEW extends b, MODEL extends IDownloadModel> {
    private static final String TAG = a.class.getSimpleName();
    private MODEL dZA;
    private final VIEW dZz;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.dZz = view;
        this.dZA = model;
        this.mPage = str;
        View actionBar = this.dZz.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.dZz.bp(view2);
                    a.this.aYl();
                    a.this.a((a) a.this.dZA);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW aYk() {
        return this.dZz;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.dZA = model;
        if (this.dZz != null) {
            aYm();
            this.dZz.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.dZA != null) {
            this.dZz.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                aYm();
            }
        }
    }

    @CallSuper
    public void cX(int i) {
        this.dZz.cX(i);
        if ((this.dZA != null ? this.dZA.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            aYm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYl() {
        MODEL model = this.dZA;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.aYi().a(model.adId(), this.mPage, currentState, model.getPkgName());
                    return;
                default:
                    return;
            }
        }
    }

    private void aYm() {
        if (this.dZz.getRealView().getVisibility() != 0) {
            this.dZz.getRealView().setVisibility(0);
        }
    }
}
