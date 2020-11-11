package com.baidu.tieba.ad.download.mvp;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tieba.ad.download.d;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes21.dex */
public abstract class a<VIEW extends b, MODEL extends IDownloadModel> {
    private static final String TAG = a.class.getSimpleName();
    private final VIEW fSC;
    private MODEL fSD;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.fSC = view;
        this.fSD = model;
        this.mPage = str;
        View actionBar = this.fSC.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!a.this.fSC.bP(view2)) {
                        a.this.bJz();
                        a.this.a((a) a.this.fSD);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW bJy() {
        return this.fSC;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.fSD = model;
        if (this.fSC != null) {
            bJA();
            this.fSC.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.fSD != null) {
            this.fSC.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                bJA();
            }
        }
    }

    @CallSuper
    public void fa(int i) {
        this.fSC.fa(i);
        if ((this.fSD != null ? this.fSD.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            bJA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJz() {
        MODEL model = this.fSD;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.bJw().a(model.adId(), this.mPage, currentState, model.getPkgName(), model.getExtInfo());
                    return;
                default:
                    return;
            }
        }
    }

    private void bJA() {
        if (this.fSC.getRealView().getVisibility() != 0) {
            this.fSC.getRealView().setVisibility(0);
        }
    }
}
