package com.baidu.tieba.ad.download.mvp;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes5.dex */
public interface b {

    /* loaded from: classes5.dex */
    public interface a {
        void bl(View view);
    }

    void a(@NonNull DownloadStatus downloadStatus);

    void a(DownloadStatus downloadStatus, int i);

    void bl(View view);

    void cG(int i);

    View getActionBar();

    @NonNull
    View getRealView();
}
