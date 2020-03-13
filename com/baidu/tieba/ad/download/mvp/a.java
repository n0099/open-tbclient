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
    private final VIEW dZN;
    private MODEL dZO;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.dZN = view;
        this.dZO = model;
        this.mPage = str;
        View actionBar = this.dZN.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.dZN.bp(view2);
                    a.this.aYo();
                    a.this.a((a) a.this.dZO);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW aYn() {
        return this.dZN;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.dZO = model;
        if (this.dZN != null) {
            aYp();
            this.dZN.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.dZO != null) {
            this.dZN.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                aYp();
            }
        }
    }

    @CallSuper
    public void cX(int i) {
        this.dZN.cX(i);
        if ((this.dZO != null ? this.dZO.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            aYp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYo() {
        MODEL model = this.dZO;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.aYl().a(model.adId(), this.mPage, currentState, model.getPkgName());
                    return;
                default:
                    return;
            }
        }
    }

    private void aYp() {
        if (this.dZN.getRealView().getVisibility() != 0) {
            this.dZN.getRealView().setVisibility(0);
        }
    }
}
