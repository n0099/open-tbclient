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
    private final VIEW dZA;
    private MODEL dZB;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.dZA = view;
        this.dZB = model;
        this.mPage = str;
        View actionBar = this.dZA.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.dZA.bp(view2);
                    a.this.aYn();
                    a.this.a((a) a.this.dZB);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW aYm() {
        return this.dZA;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.dZB = model;
        if (this.dZA != null) {
            aYo();
            this.dZA.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.dZB != null) {
            this.dZA.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                aYo();
            }
        }
    }

    @CallSuper
    public void cX(int i) {
        this.dZA.cX(i);
        if ((this.dZB != null ? this.dZB.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            aYo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYn() {
        MODEL model = this.dZB;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.aYk().a(model.adId(), this.mPage, currentState, model.getPkgName());
                    return;
                default:
                    return;
            }
        }
    }

    private void aYo() {
        if (this.dZA.getRealView().getVisibility() != 0) {
            this.dZA.getRealView().setVisibility(0);
        }
    }
}
