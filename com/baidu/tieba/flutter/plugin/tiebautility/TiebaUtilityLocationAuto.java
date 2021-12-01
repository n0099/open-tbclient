package com.baidu.tieba.flutter.plugin.tiebautility;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class TiebaUtilityLocationAuto {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class AppPosInfoResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String result;

        public AppPosInfoResult() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static AppPosInfoResult fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                AppPosInfoResult appPosInfoResult = new AppPosInfoResult();
                appPosInfoResult.result = (String) hashMap.get("result");
                return appPosInfoResult;
            }
            return (AppPosInfoResult) invokeL.objValue;
        }

        public String getResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.result : (String) invokeV.objValue;
        }

        public void setResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.result = str;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("result", this.result);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class DistanceResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Double result;

        public DistanceResult() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static DistanceResult fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                DistanceResult distanceResult = new DistanceResult();
                distanceResult.result = (Double) hashMap.get("result");
                return distanceResult;
            }
            return (DistanceResult) invokeL.objValue;
        }

        public Double getResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.result : (Double) invokeV.objValue;
        }

        public void setResult(Double d2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2) == null) {
                this.result = d2;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("result", this.result);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public interface HostUtilityLocation {
        void getAppPosInfo(Result<AppPosInfoResult> result);

        void requestDistance(LocationParam locationParam, Result<DistanceResult> result);
    }

    /* loaded from: classes10.dex */
    public static class LocationParam {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Double latitude;
        public Double longitude;

        public LocationParam() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static LocationParam fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                LocationParam locationParam = new LocationParam();
                locationParam.latitude = (Double) hashMap.get("latitude");
                locationParam.longitude = (Double) hashMap.get("longitude");
                return locationParam;
            }
            return (LocationParam) invokeL.objValue;
        }

        public Double getLatitude() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.latitude : (Double) invokeV.objValue;
        }

        public Double getLongitude() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.longitude : (Double) invokeV.objValue;
        }

        public void setLatitude(Double d2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2) == null) {
                this.latitude = d2;
            }
        }

        public void setLongitude(Double d2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, d2) == null) {
                this.longitude = d2;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("latitude", this.latitude);
                hashMap.put("longitude", this.longitude);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public interface Result<T> {
        void success(T t);
    }

    public TiebaUtilityLocationAuto() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static HashMap wrapError(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, exc)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("message", exc.toString());
            hashMap.put("code", exc.getClass().getSimpleName());
            hashMap.put("details", null);
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
