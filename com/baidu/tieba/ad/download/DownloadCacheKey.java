package com.baidu.tieba.ad.download;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class DownloadCacheKey implements Serializable {
    public final String mAdId;
    public String mDownloadUrl;
    public String mPackageName;

    public DownloadCacheKey(String str, String str2, String str3) {
        this.mAdId = str;
        this.mDownloadUrl = str2;
        this.mPackageName = str3;
    }

    public static DownloadCacheKey create(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        return new DownloadCacheKey(str, str2, str3);
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

    public int hashCode() {
        String str = this.mAdId;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.mAdId) || TextUtils.isEmpty(this.mDownloadUrl)) ? false : true;
    }

    public boolean sameAd(String str) {
        return TextUtils.equals(this.mAdId, str);
    }

    public boolean samePackage(String str) {
        return TextUtils.equals(this.mPackageName, str);
    }

    public boolean sameUrl(String str) {
        return TextUtils.equals(this.mDownloadUrl, str);
    }

    public String toString() {
        return "DownloadCacheKey{mAdId='" + this.mAdId + "', mDownloadUrl='" + this.mDownloadUrl + "', mPackageName='" + this.mPackageName + "'}";
    }

    public static DownloadCacheKey create(@NonNull String str, @Nullable String str2) {
        return new DownloadCacheKey(str, str2, null);
    }
}
