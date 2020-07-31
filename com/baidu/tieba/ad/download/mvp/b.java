package com.baidu.tieba.ad.download.mvp;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes15.dex */
public interface b {

    /* loaded from: classes15.dex */
    public interface a {
        void bA(View view);
    }

    void a(@NonNull DownloadStatus downloadStatus);

    void a(DownloadStatus downloadStatus, int i);

    void bA(View view);

    void dE(int i);

    View getActionBar();

    @NonNull
    View getRealView();
}
