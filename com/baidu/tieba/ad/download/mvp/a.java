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
    private final String aTe;
    private final VIEW diq;
    private MODEL dir;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.diq = view;
        this.dir = model;
        this.aTe = str;
        View actionBar = this.diq.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.diq.bo(view2);
                    a.this.aDL();
                    a.this.a((a) a.this.dir);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW aDK() {
        return this.diq;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.dir = model;
        if (this.diq != null) {
            aDM();
            this.diq.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.dir != null) {
            this.diq.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                aDM();
            }
        }
    }

    @CallSuper
    public void cr(int i) {
        this.diq.cr(i);
        if ((this.dir != null ? this.dir.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            aDM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDL() {
        MODEL model = this.dir;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.aDI().a(model.adId(), this.aTe, currentState, model.getPkgName());
                    return;
                default:
                    return;
            }
        }
    }

    private void aDM() {
        if (this.diq.getRealView().getVisibility() != 0) {
            this.diq.getRealView().setVisibility(0);
        }
    }
}
