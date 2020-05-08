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
    private final VIEW eAf;
    private MODEL eAg;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.eAf = view;
        this.eAg = model;
        this.mPage = str;
        View actionBar = this.eAf.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.eAf.bq(view2);
                    a.this.bgv();
                    a.this.a((a) a.this.eAg);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW bgu() {
        return this.eAf;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.eAg = model;
        if (this.eAf != null) {
            bgw();
            this.eAf.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.eAg != null) {
            this.eAf.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                bgw();
            }
        }
    }

    @CallSuper
    public void dm(int i) {
        this.eAf.dm(i);
        if ((this.eAg != null ? this.eAg.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            bgw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgv() {
        MODEL model = this.eAg;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.bgs().a(model.adId(), this.mPage, currentState, model.getPkgName());
                    return;
                default:
                    return;
            }
        }
    }

    private void bgw() {
        if (this.eAf.getRealView().getVisibility() != 0) {
            this.eAf.getRealView().setVisibility(0);
        }
    }
}
