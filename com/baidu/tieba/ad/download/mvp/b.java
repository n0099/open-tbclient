package com.baidu.tieba.ad.download.mvp;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes20.dex */
public interface b {

    /* loaded from: classes20.dex */
    public interface a {
        boolean bG(View view);
    }

    void a(@NonNull DownloadStatus downloadStatus);

    void a(DownloadStatus downloadStatus, int i);

    boolean bG(View view);

    void eO(int i);

    View getActionBar();

    @NonNull
    View getRealView();
}
