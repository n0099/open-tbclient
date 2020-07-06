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
    private final VIEW eZb;
    private MODEL eZc;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.eZb = view;
        this.eZc = model;
        this.mPage = str;
        View actionBar = this.eZb.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.eZb.bu(view2);
                    a.this.bpj();
                    a.this.a((a) a.this.eZc);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW bpi() {
        return this.eZb;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.eZc = model;
        if (this.eZb != null) {
            bpk();
            this.eZb.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.eZc != null) {
            this.eZb.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                bpk();
            }
        }
    }

    @CallSuper
    public void dE(int i) {
        this.eZb.dE(i);
        if ((this.eZc != null ? this.eZc.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            bpk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpj() {
        MODEL model = this.eZc;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.bpg().a(model.adId(), this.mPage, currentState, model.getPkgName());
                    return;
                default:
                    return;
            }
        }
    }

    private void bpk() {
        if (this.eZb.getRealView().getVisibility() != 0) {
            this.eZb.getRealView().setVisibility(0);
        }
    }
}
