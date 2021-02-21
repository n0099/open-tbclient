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
    private final VIEW ghy;
    private MODEL ghz;
    private final String mPage;

    protected abstract void a(MODEL model);

    protected abstract void b(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.ghy = view;
        b((a<VIEW, MODEL>) model);
        this.ghz = model;
        this.mPage = str;
        View actionBar = this.ghy.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!a.this.ghy.ce(view2)) {
                        a.this.bLB();
                        a.this.a((a) a.this.ghz);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW bLA() {
        return this.ghy;
    }

    @CallSuper
    public void c(@NonNull MODEL model) {
        this.ghz = model;
        if (this.ghy != null) {
            bLC();
            this.ghy.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        MODEL model = this.ghz;
        if (model != null) {
            this.ghy.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                bLC();
            }
            if (downloadStatus == DownloadStatus.STATUS_SUCCESS || downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
                com.baidu.tieba.ad.a.a.bLI().a(downloadStatus, model);
            }
        }
    }

    @CallSuper
    public void fn(int i) {
        this.ghy.fn(i);
        if ((this.ghz != null ? this.ghz.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            bLC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLB() {
        MODEL model = this.ghz;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.bLy().a(model.adId(), this.mPage, currentState, model.getPkgName(), model.getExtInfo());
                    return;
                default:
                    return;
            }
        }
    }

    private void bLC() {
        if (this.ghy.getRealView().getVisibility() != 0) {
            this.ghy.getRealView().setVisibility(0);
        }
    }
}
