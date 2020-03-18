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
    private final VIEW ead;
    private MODEL eae;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.ead = view;
        this.eae = model;
        this.mPage = str;
        View actionBar = this.ead.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.ead.bp(view2);
                    a.this.aYs();
                    a.this.a((a) a.this.eae);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW aYr() {
        return this.ead;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.eae = model;
        if (this.ead != null) {
            aYt();
            this.ead.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.eae != null) {
            this.ead.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                aYt();
            }
        }
    }

    @CallSuper
    public void cX(int i) {
        this.ead.cX(i);
        if ((this.eae != null ? this.eae.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            aYt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYs() {
        MODEL model = this.eae;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.aYp().a(model.adId(), this.mPage, currentState, model.getPkgName());
                    return;
                default:
                    return;
            }
        }
    }

    private void aYt() {
        if (this.ead.getRealView().getVisibility() != 0) {
            this.ead.getRealView().setVisibility(0);
        }
    }
}
