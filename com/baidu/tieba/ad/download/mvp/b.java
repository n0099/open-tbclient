package com.baidu.tieba.ad.download.mvp;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes.dex */
public interface b {

    /* loaded from: classes.dex */
    public interface a {
        boolean ce(View view);
    }

    void a(@NonNull DownloadStatus downloadStatus);

    void a(DownloadStatus downloadStatus, int i);

    boolean ce(View view);

    void fo(int i);

    View getActionBar();

    @NonNull
    View getRealView();
}
