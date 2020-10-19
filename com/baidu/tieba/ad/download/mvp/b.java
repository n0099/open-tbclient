package com.baidu.tieba.ad.download.mvp;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes21.dex */
public interface b {

    /* loaded from: classes21.dex */
    public interface a {
        boolean bK(View view);
    }

    void a(@NonNull DownloadStatus downloadStatus);

    void a(DownloadStatus downloadStatus, int i);

    boolean bK(View view);

    void eX(int i);

    View getActionBar();

    @NonNull
    View getRealView();
}
