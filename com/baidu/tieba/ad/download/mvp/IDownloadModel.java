package com.baidu.tieba.ad.download.mvp;

import android.support.annotation.NonNull;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import java.io.Serializable;
/* loaded from: classes15.dex */
public interface IDownloadModel extends Serializable {
    String adId();

    @NonNull
    DownloadStatus getCurrentState();

    String getExtInfo();

    int getPercent();

    String getPkgName();
}
