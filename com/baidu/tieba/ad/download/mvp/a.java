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
    private final VIEW gjM;
    private MODEL gjN;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.gjM = view;
        this.gjN = model;
        this.mPage = str;
        View actionBar = this.gjM.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!a.this.gjM.ci(view2)) {
                        a.this.bOU();
                        a.this.a((a) a.this.gjN);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW bOT() {
        return this.gjM;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.gjN = model;
        if (this.gjM != null) {
            bOV();
            this.gjM.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.gjN != null) {
            this.gjM.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                bOV();
            }
        }
    }

    @CallSuper
    public void fu(int i) {
        this.gjM.fu(i);
        if ((this.gjN != null ? this.gjN.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            bOV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOU() {
        MODEL model = this.gjN;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.bOR().a(model.adId(), this.mPage, currentState, model.getPkgName(), model.getExtInfo());
                    return;
                default:
                    return;
            }
        }
    }

    private void bOV() {
        if (this.gjM.getRealView().getVisibility() != 0) {
            this.gjM.getRealView().setVisibility(0);
        }
    }
}
