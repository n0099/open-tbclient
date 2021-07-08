package com.baidu.tieba.flutter.plugin.tiebautility;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class TiebaUtilityVideoCreationCenterAuto {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface HostUtilityVideoCreationCenter {
        void sendThread(VideoCreationCenterSendParams videoCreationCenterSendParams);
    }

    /* loaded from: classes4.dex */
    public static class VideoCreationCenterSendParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String objLocate;

        public VideoCreationCenterSendParams() {
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

        public static VideoCreationCenterSendParams fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                VideoCreationCenterSendParams videoCreationCenterSendParams = new VideoCreationCenterSendParams();
                videoCreationCenterSendParams.objLocate = (String) hashMap.get("objLocate");
                return videoCreationCenterSendParams;
            }
            return (VideoCreationCenterSendParams) invokeL.objValue;
        }

        public String getObjLocate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.objLocate : (String) invokeV.objValue;
        }

        public void setObjLocate(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.objLocate = str;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("objLocate", this.objLocate);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    public TiebaUtilityVideoCreationCenterAuto() {
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
