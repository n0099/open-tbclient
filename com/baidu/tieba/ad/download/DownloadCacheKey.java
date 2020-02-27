package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.io.Serializable;
/* loaded from: classes8.dex */
public class DownloadCacheKey implements Serializable {
    public final String mAdId;
    public String mDownloadUrl;
    public String mPackageName;

    private DownloadCacheKey(String str, String str2, String str3) {
        this.mAdId = str;
        this.mDownloadUrl = str2;
        this.mPackageName = str3;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.mAdId) || TextUtils.isEmpty(this.mDownloadUrl)) ? false : true;
    }

    public int hashCode() {
        return (this.mAdId == null ? 0 : this.mAdId.hashCode()) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DownloadCacheKey) {
            DownloadCacheKey downloadCacheKey = (DownloadCacheKey) obj;
            return sameAd(downloadCacheKey.mAdId) || sameUrl(downloadCacheKey.mDownloadUrl);
        }
        return false;
    }

    public String toString() {
        return "DownloadCacheKey{mAdId='" + this.mAdId + "', mDownloadUrl='" + this.mDownloadUrl + "', mPackageName='" + this.mPackageName + "'}";
    }

    public boolean sameAd(String str) {
        return TextUtils.equals(this.mAdId, str);
    }

    public boolean sameUrl(String str) {
        return TextUtils.equals(this.mDownloadUrl, str);
    }

    public boolean samePackage(String str) {
        return TextUtils.equals(this.mPackageName, str);
    }

    public static DownloadCacheKey create(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        return new DownloadCacheKey(str, str2, str3);
    }

    public static DownloadCacheKey create(@NonNull String str, @Nullable String str2) {
        return new DownloadCacheKey(str, str2, null);
    }
}
