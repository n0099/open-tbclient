package com.baidu.tieba.ad.download;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Objects;
/* loaded from: classes9.dex */
public final class AdDownloadData implements Serializable, IDownloadModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f46682a;

        /* renamed from: b  reason: collision with root package name */
        public String f46683b;

        /* renamed from: c  reason: collision with root package name */
        public String f46684c;

        /* renamed from: d  reason: collision with root package name */
        public String f46685d;

        public b(@NonNull DownloadCacheKey downloadCacheKey) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadCacheKey};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46682a = downloadCacheKey.mAdId;
            this.f46683b = downloadCacheKey.mDownloadUrl;
            this.f46684c = downloadCacheKey.mPackageName;
        }

        @NonNull
        public AdDownloadData e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new AdDownloadData(this, null) : (AdDownloadData) invokeV.objValue;
        }
    }

    public /* synthetic */ AdDownloadData(b bVar, a aVar) {
        this(bVar);
    }

    @Override // com.baidu.tieba.ad.download.mvp.IDownloadModel
    public String adId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAdId : (String) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DownloadCacheKey) {
                return Objects.equals(this.mAdId, ((DownloadCacheKey) obj).mAdId);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public AdDownloadExtra extra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mExtra : (AdDownloadExtra) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ad.download.mvp.IDownloadModel
    public String getAppJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAppJson : (String) invokeV.objValue;
    }

    public long getContentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mContentLength : invokeV.longValue;
    }

    @Override // com.baidu.tieba.ad.download.mvp.IDownloadModel
    @NonNull
    public DownloadStatus getCurrentState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mExtra.getStatus() : (DownloadStatus) invokeV.objValue;
    }

    public String getDeeplink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mDeeplinkUrl : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ad.download.mvp.IDownloadModel
    public String getDownloadKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mDownloadKey : (String) invokeV.objValue;
    }

    public String getDownloadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mDownloadUrl : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ad.download.mvp.IDownloadModel
    public String getExtInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mExtInfo : (String) invokeV.objValue;
    }

    public int getFakePercent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            AdDownloadExtra adDownloadExtra = this.mExtra;
            if (adDownloadExtra == null) {
                return 0;
            }
            return adDownloadExtra.getDownloadFakePercent();
        }
        return invokeV.intValue;
    }

    public String getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mPage : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ad.download.mvp.IDownloadModel
    public int getPercent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? Math.max(this.mExtra.getPercent(), this.mExtra.getDownloadFakePercent()) : invokeV.intValue;
    }

    @Override // com.baidu.tieba.ad.download.mvp.IDownloadModel
    public String getPkgName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mPackageName : (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? Objects.hash(this.mAdId) : invokeV.intValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (TextUtils.isEmpty(this.mAdId) || TextUtils.isEmpty(this.mDownloadUrl)) ? false : true : invokeV.booleanValue;
    }

    public String pkgName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mPackageName : (String) invokeV.objValue;
    }

    public void setAppJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.mAppJson = str;
        }
    }

    public void setContentLength(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.mContentLength = j;
        }
    }

    public void setDeeplinkUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.mDeeplinkUrl = str;
        }
    }

    public void setDownloadKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.mDownloadKey = str;
        }
    }

    public void setExtInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.mExtInfo = str;
        }
    }

    public void setFakePercent(int i2) {
        AdDownloadExtra adDownloadExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || (adDownloadExtra = this.mExtra) == null) {
            return;
        }
        adDownloadExtra.setDownloadFakePercent(i2);
    }

    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.mPage = str;
        }
    }

    public void setPercent(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.mExtra.setPercent(i2);
        }
    }

    public void setupDownloadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.mDownloadUrl = str;
        }
    }

    public void setupPkgName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.mPackageName = str;
        }
    }

    public AdDownloadData(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAdId = bVar.f46682a;
        this.mPackageName = bVar.f46684c;
        this.mDownloadUrl = bVar.f46683b;
        this.mDeeplinkUrl = bVar.f46685d;
        this.mExtra = new AdDownloadExtra(this);
    }
}
