package com.baidu.tieba.ad.download.mvp;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tieba.ad.download.d;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes20.dex */
public abstract class a<VIEW extends b, MODEL extends IDownloadModel> {
    private static final String TAG = a.class.getSimpleName();
    private final VIEW fsg;
    private MODEL fsh;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.fsg = view;
        this.fsh = model;
        this.mPage = str;
        View actionBar = this.fsg.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!a.this.fsg.bG(view2)) {
                        a.this.bCv();
                        a.this.a((a) a.this.fsh);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW bCu() {
        return this.fsg;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.fsh = model;
        if (this.fsg != null) {
            bCw();
            this.fsg.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.fsh != null) {
            this.fsg.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                bCw();
            }
        }
    }

    @CallSuper
    public void eO(int i) {
        this.fsg.eO(i);
        if ((this.fsh != null ? this.fsh.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            bCw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCv() {
        MODEL model = this.fsh;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.bCs().a(model.adId(), this.mPage, currentState, model.getPkgName(), model.getExtInfo());
                    return;
                default:
                    return;
            }
        }
    }

    private void bCw() {
        if (this.fsg.getRealView().getVisibility() != 0) {
            this.fsg.getRealView().setVisibility(0);
        }
    }
}
