package com.baidu.tieba.ad.download.mvp;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes.dex */
public interface b {

    /* loaded from: classes.dex */
    public interface a {
        boolean ci(View view);
    }

    void a(@NonNull DownloadStatus downloadStatus);

    void a(DownloadStatus downloadStatus, int i);

    boolean ci(View view);

    void dO(int i);

    View getActionBar();

    @NonNull
    View getRealView();
}
