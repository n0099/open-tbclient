package com.baidu.tieba.ad.download.mvp;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.d;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes.dex */
public abstract class a<VIEW extends b, MODEL extends IDownloadModel> {
    private static final String TAG = a.class.getSimpleName();
    private final VIEW gfe;
    private MODEL gff;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.gfe = view;
        this.gff = model;
        this.mPage = str;
        View actionBar = this.gfe.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!a.this.gfe.ci(view2)) {
                        a.this.bLc();
                        a.this.a((a) a.this.gff);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW bLb() {
        return this.gfe;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.gff = model;
        if (this.gfe != null) {
            bLd();
            this.gfe.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.gff != null) {
            this.gfe.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                bLd();
            }
        }
    }

    @CallSuper
    public void dO(int i) {
        this.gfe.dO(i);
        if ((this.gff != null ? this.gff.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            bLd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLc() {
        MODEL model = this.gff;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.bKZ().a(model.adId(), this.mPage, currentState, model.getPkgName(), model.getExtInfo());
                    return;
                default:
                    return;
            }
        }
    }

    private void bLd() {
        if (this.gfe.getRealView().getVisibility() != 0) {
            this.gfe.getRealView().setVisibility(0);
        }
    }
}
