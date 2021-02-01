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
    private final VIEW ghs;
    private MODEL ght;
    private final String mPage;

    protected abstract void a(MODEL model);

    public a(@NonNull VIEW view, @NonNull MODEL model, @NonNull String str) {
        this.ghs = view;
        this.ght = model;
        this.mPage = str;
        View actionBar = this.ghs.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.download.mvp.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.ad.download.mvp.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!a.this.ghs.ce(view2)) {
                        a.this.bLw();
                        a.this.a((a) a.this.ght);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW bLv() {
        return this.ghs;
    }

    @CallSuper
    public void b(@NonNull MODEL model) {
        this.ght = model;
        if (this.ghs != null) {
            bLx();
            this.ghs.a(model.getCurrentState(), model.getPercent());
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        if (this.ght != null) {
            this.ghs.a(downloadStatus);
            if (downloadStatus != DownloadStatus.STATUS_NONE) {
                bLx();
            }
        }
    }

    @CallSuper
    public void fn(int i) {
        this.ghs.fn(i);
        if ((this.ght != null ? this.ght.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            bLx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLw() {
        MODEL model = this.ght;
        if (model != null) {
            DownloadStatus currentState = model.getCurrentState();
            switch (currentState) {
                case STATUS_NONE:
                case STATUS_DOWNLOADING:
                case STATUS_PAUSED:
                case STATUS_SUCCESS:
                case STATUS_INSTALL_SUCCESS:
                    d.bLt().a(model.adId(), this.mPage, currentState, model.getPkgName(), model.getExtInfo());
                    return;
                default:
                    return;
            }
        }
    }

    private void bLx() {
        if (this.ghs.getRealView().getVisibility() != 0) {
            this.ghs.getRealView().setVisibility(0);
        }
    }
}
