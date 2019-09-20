package com.baidu.tieba.ad.download.mvp;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes3.dex */
public abstract class a<VIEW extends b, MODEL extends IDownloadModel> {
    private final VIEW cYU;
    private MODEL cYV;

    public a(@NonNull VIEW view, @NonNull MODEL model) {
        this.cYU = view;
        this.cYV = model;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VIEW aDC() {
        return this.cYU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MODEL aDD() {
        return this.cYV;
    }

    @CallSuper
    public void a(@NonNull MODEL model) {
        this.cYV = model;
    }

    @CallSuper
    public void a(@NonNull DownloadStatus downloadStatus) {
        this.cYU.b(downloadStatus);
    }

    @CallSuper
    public void cw(int i) {
        this.cYU.cw(i);
    }
}
