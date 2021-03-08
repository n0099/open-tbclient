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
    private final VIEW gjc;
    private MODEL gjd;
    private final String mPage;

    protected abstract void a(MODEL model);

    protected abstract void b(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.gjc = view;
        b((a<VIEW, MODEL>) model);
        this.gjd = model;
        this.mPage = str;
        View actionBar = this.gjc.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!a.this.gjc.ce(view2)) {
                        a.this.bLF();
                        a.this.a((a) a.this.gjd);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW bLE() {
        return this.gjc;
    }

    @CallSuper
    public void c(@NonNull MODEL model) {
        this.gjd = model;
        if (this.gjc != null) {
            bLG();
            this.gjc.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        MODEL model = this.gjd;
        if (model != null) {
            this.gjc.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                bLG();
            }
            if (downloadStatus == DownloadStatus.STATUS_SUCCESS || downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
                com.baidu.tieba.ad.a.a.bLM().a(downloadStatus, model);
            }
        }
    }

    @CallSuper
    public void fo(int i) {
        this.gjc.fo(i);
        if ((this.gjd != null ? this.gjd.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            bLG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLF() {
        MODEL model = this.gjd;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.bLC().a(model.adId(), this.mPage, currentState, model.getPkgName(), model.getExtInfo());
                    return;
                default:
                    return;
            }
        }
    }

    private void bLG() {
        if (this.gjc.getRealView().getVisibility() != 0) {
            this.gjc.getRealView().setVisibility(0);
        }
    }
}
