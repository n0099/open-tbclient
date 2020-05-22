package com.baidu.tieba.ad.download.mvp;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes8.dex */
public interface b {

    /* loaded from: classes8.dex */
    public interface a {
        void br(View view);
    }

    void a(@NonNull DownloadStatus downloadStatus);

    void a(DownloadStatus downloadStatus, int i);

    void br(View view);

    void dr(int i);

    View getActionBar();

    @NonNull
    View getRealView();
}
