package com.baidu.tieba.ad.download.mvp;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes21.dex */
public interface b {

    /* loaded from: classes21.dex */
    public interface a {
        boolean bZ(View view);
    }

    void a(@NonNull DownloadStatus downloadStatus);

    void a(DownloadStatus downloadStatus, int i);

    boolean bZ(View view);

    void fu(int i);

    View getActionBar();

    @NonNull
    View getRealView();
}
