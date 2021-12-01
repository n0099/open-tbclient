package com.baidu.tieba.ad.download.mvp;

import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import java.io.Serializable;
/* loaded from: classes10.dex */
public interface IDownloadModel extends Serializable {
    String adId();

    String getAppJson();

    @NonNull
    DownloadStatus getCurrentState();

    String getDownloadKey();

    String getExtInfo();

    int getPercent();

    String getPkgName();
}
