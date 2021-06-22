package com.baidu.tieba.ad.download;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import java.io.Serializable;
import java.util.Objects;
/* loaded from: classes4.dex */
public final class AdDownloadData implements Serializable, IDownloadModel {
    public final String mAdId;
    public String mAppJson;
    public long mContentLength;
    public String mDeeplinkUrl;
    public String mDownloadKey;
    public String mDownloadUrl;
    public String mExtInfo;
    public final AdDownloadExtra mExtra;
    public String mPackageName;
    public String mPage;

    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f13646a;

        /* renamed from: b  reason: collision with root package name */
        public String f13647b;

        /* renamed from: c  reason: collision with root package name */
        public String f13648c;

        /* renamed from: d  reason: collision with root package name */
        public String f13649d;

        public b(@NonNull DownloadCacheKey downloadCacheKey) {
            this.f13646a = downloadCacheKey.mAdId;
            this.f13647b = downloadCacheKey.mDownloadUrl;
            this.f13648c = downloadCacheKey.mPackageName;
        }

        @NonNull
        public AdDownloadData e() {
            return new AdDownloadData(this);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.IDownloadModel
    public String adId() {
        return this.mAdId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DownloadCacheKey) {
            return Objects.equals(this.mAdId, ((DownloadCacheKey) obj).mAdId);
        }
        return false;
    }

    public AdDownloadExtra extra() {
        return this.mExtra;
    }

    @Override // com.baidu.tieba.ad.download.mvp.IDownloadModel
    public String getAppJson() {
        return this.mAppJson;
    }

    public long getContentLength() {
        return this.mContentLength;
    }

    @Override // com.baidu.tieba.ad.download.mvp.IDownloadModel
    @NonNull
    public DownloadStatus getCurrentState() {
        return this.mExtra.getStatus();
    }

    public String getDeeplink() {
        return this.mDeeplinkUrl;
    }

    @Override // com.baidu.tieba.ad.download.mvp.IDownloadModel
    public String getDownloadKey() {
        return this.mDownloadKey;
    }

    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    @Override // com.baidu.tieba.ad.download.mvp.IDownloadModel
    public String getExtInfo() {
        return this.mExtInfo;
    }

    public int getFakePercent() {
        AdDownloadExtra adDownloadExtra = this.mExtra;
        if (adDownloadExtra == null) {
            return 0;
        }
        return adDownloadExtra.getDownloadFakePercent();
    }

    public String getPage() {
        return this.mPage;
    }

    @Override // com.baidu.tieba.ad.download.mvp.IDownloadModel
    public int getPercent() {
        return Math.max(this.mExtra.getPercent(), this.mExtra.getDownloadFakePercent());
    }

    @Override // com.baidu.tieba.ad.download.mvp.IDownloadModel
    public String getPkgName() {
        return this.mPackageName;
    }

    public int hashCode() {
        return Objects.hash(this.mAdId);
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.mAdId) || TextUtils.isEmpty(this.mDownloadUrl)) ? false : true;
    }

    public String pkgName() {
        return this.mPackageName;
    }

    public void setAppJson(String str) {
        this.mAppJson = str;
    }

    public void setContentLength(long j) {
        this.mContentLength = j;
    }

    public void setDeeplinkUrl(String str) {
        this.mDeeplinkUrl = str;
    }

    public void setDownloadKey(String str) {
        this.mDownloadKey = str;
    }

    public void setExtInfo(String str) {
        this.mExtInfo = str;
    }

    public void setFakePercent(int i2) {
        AdDownloadExtra adDownloadExtra = this.mExtra;
        if (adDownloadExtra != null) {
            adDownloadExtra.setDownloadFakePercent(i2);
        }
    }

    public void setPage(String str) {
        this.mPage = str;
    }

    public void setPercent(int i2) {
        this.mExtra.setPercent(i2);
    }

    public void setupDownloadUrl(String str) {
        this.mDownloadUrl = str;
    }

    public void setupPkgName(String str) {
        this.mPackageName = str;
    }

    public AdDownloadData(b bVar) {
        this.mAdId = bVar.f13646a;
        this.mPackageName = bVar.f13648c;
        this.mDownloadUrl = bVar.f13647b;
        this.mDeeplinkUrl = bVar.f13649d;
        this.mExtra = new AdDownloadExtra(this);
    }
}
