package com.baidu.tieba.ad.download.mvp;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tieba.ad.download.d;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes3.dex */
public abstract class a<VIEW extends b, MODEL extends IDownloadModel> {
    private static final String TAG = a.class.getSimpleName();
    private final String aSM;
    private MODEL dhA;
    private final VIEW dhz;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.dhz = view;
        this.dhA = model;
        this.aSM = str;
        View actionBar = this.dhz.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.dhz.bo(view2);
                    a.this.aDJ();
                    a.this.a((a) a.this.dhA);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW aDI() {
        return this.dhz;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.dhA = model;
        if (this.dhz != null) {
            aDK();
            this.dhz.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.dhA != null) {
            this.dhz.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                aDK();
            }
        }
    }

    @CallSuper
    public void cr(int i) {
        this.dhz.cr(i);
        if ((this.dhA != null ? this.dhA.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            aDK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDJ() {
        MODEL model = this.dhA;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.aDG().a(model.adId(), this.aSM, currentState, model.getPkgName());
                    return;
                default:
                    return;
            }
        }
    }

    private void aDK() {
        if (this.dhz.getRealView().getVisibility() != 0) {
            this.dhz.getRealView().setVisibility(0);
        }
    }
}
