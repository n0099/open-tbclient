package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import java.io.Serializable;
import java.util.Objects;
/* loaded from: classes15.dex */
public final class AdDownloadData implements IDownloadModel, Serializable {
    private final String mAdId;
    private String mDownloadUrl;
    private final AdDownloadExtra mExtra;
    private int mFakeDownloadPercent;
    private int mFakeDownloadTime;
    private String mPackageName;

    private AdDownloadData(a aVar) {
        this.mAdId = aVar.mAdId;
        this.mPackageName = aVar.mPackageName;
        this.mDownloadUrl = aVar.mDownloadUrl;
        this.mFakeDownloadTime = aVar.mFakeDownloadTime;
        this.mFakeDownloadPercent = aVar.mFakeDownloadPercent;
        this.mExtra = new AdDownloadExtra(this);
    }

    @Override // com.baidu.tieba.ad.download.mvp.IDownloadModel
    public String adId() {
        return this.mAdId;
    }

    public String pkgName() {
        return this.mPackageName;
    }

    public void setupPkgName(String str) {
        this.mPackageName = str;
    }

    public void setupDownloadUrl(String str) {
        this.mDownloadUrl = str;
    }

    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public AdDownloadExtra extra() {
        return this.mExtra;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.mAdId) || TextUtils.isEmpty(this.mDownloadUrl)) ? false : true;
    }

    public int hashCode() {
        return Objects.hash(this.mAdId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadCacheKey)) {
            return false;
        }
        return Objects.equals(this.mAdId, ((DownloadCacheKey) obj).mAdId);
    }

    @Override // com.baidu.tieba.ad.download.mvp.IDownloadModel
    public int getPercent() {
        return this.mExtra.getPercent();
    }

    @Override // com.baidu.tieba.ad.download.mvp.IDownloadModel
    @NonNull
    public DownloadStatus getCurrentState() {
        return this.mExtra.getStatus();
    }

    @Override // com.baidu.tieba.ad.download.mvp.IDownloadModel
    public String getPkgName() {
        return this.mPackageName;
    }

    /* loaded from: classes15.dex */
    public static final class a {
        private final String mAdId;
        private String mDownloadUrl;
        private int mFakeDownloadPercent;
        private int mFakeDownloadTime;
        private String mPackageName;

        public a(@NonNull DownloadCacheKey downloadCacheKey) {
            this.mAdId = downloadCacheKey.mAdId;
            this.mDownloadUrl = downloadCacheKey.mDownloadUrl;
            this.mPackageName = downloadCacheKey.mPackageName;
        }

        @NonNull
        public AdDownloadData bsh() {
            return new AdDownloadData(this);
        }
    }
}
