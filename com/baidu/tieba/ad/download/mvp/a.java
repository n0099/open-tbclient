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
    private final VIEW eOF;
    private MODEL eOG;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.eOF = view;
        this.eOG = model;
        this.mPage = str;
        View actionBar = this.eOF.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.eOF.br(view2);
                    a.this.bmG();
                    a.this.a((a) a.this.eOG);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW bmF() {
        return this.eOF;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.eOG = model;
        if (this.eOF != null) {
            bmH();
            this.eOF.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.eOG != null) {
            this.eOF.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                bmH();
            }
        }
    }

    @CallSuper
    public void dr(int i) {
        this.eOF.dr(i);
        if ((this.eOG != null ? this.eOG.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            bmH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmG() {
        MODEL model = this.eOG;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.bmD().a(model.adId(), this.mPage, currentState, model.getPkgName());
                    return;
                default:
                    return;
            }
        }
    }

    private void bmH() {
        if (this.eOF.getRealView().getVisibility() != 0) {
            this.eOF.getRealView().setVisibility(0);
        }
    }
}
