package com.baidu.tieba.ad.download.mvp;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes15.dex */
public interface b {

    /* loaded from: classes15.dex */
    public interface a {
        boolean bC(View view);
    }

    void a(@NonNull DownloadStatus downloadStatus);

    void a(DownloadStatus downloadStatus, int i);

    boolean bC(View view);

    void fy(int i);

    View getActionBar();

    @NonNull
    View getRealView();
}
