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
    public String mDeeplinkUrl;
    public String mDownloadKey;
    public String mDownloadUrl;
    public String mExtInfo;
    public final AdDownloadExtra mExtra;
    public int mFakeDownloadPercent;
    public int mFakeDownloadTime;
    public String mPackageName;
    public String mPage;

    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f14258a;

        /* renamed from: b  reason: collision with root package name */
        public String f14259b;

        /* renamed from: c  reason: collision with root package name */
        public String f14260c;

        /* renamed from: d  reason: collision with root package name */
        public int f14261d;

        /* renamed from: e  reason: collision with root package name */
        public int f14262e;

        /* renamed from: f  reason: collision with root package name */
        public String f14263f;

        public b(@NonNull DownloadCacheKey downloadCacheKey) {
            this.f14258a = downloadCacheKey.mAdId;
            this.f14259b = downloadCacheKey.mDownloadUrl;
            this.f14260c = downloadCacheKey.mPackageName;
        }

        @NonNull
        public AdDownloadData g() {
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

    public String getPage() {
        return this.mPage;
    }

    @Override // com.baidu.tieba.ad.download.mvp.IDownloadModel
    public int getPercent() {
        return this.mExtra.getPercent();
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

    public void setDeeplinkUrl(String str) {
        this.mDeeplinkUrl = str;
    }

    public void setDownloadKey(String str) {
        this.mDownloadKey = str;
    }

    public void setExtInfo(String str) {
        this.mExtInfo = str;
    }

    public void setPage(String str) {
        this.mPage = str;
    }

    public void setupDownloadUrl(String str) {
        this.mDownloadUrl = str;
    }

    public void setupPkgName(String str) {
        this.mPackageName = str;
    }

    public AdDownloadData(b bVar) {
        this.mAdId = bVar.f14258a;
        this.mPackageName = bVar.f14260c;
        this.mDownloadUrl = bVar.f14259b;
        this.mFakeDownloadTime = bVar.f14261d;
        this.mFakeDownloadPercent = bVar.f14262e;
        this.mDeeplinkUrl = bVar.f14263f;
        this.mExtra = new AdDownloadExtra(this);
    }
}
