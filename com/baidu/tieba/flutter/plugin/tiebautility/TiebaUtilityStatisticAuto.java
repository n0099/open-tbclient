package com.baidu.tieba.flutter.plugin.tiebautility;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class TiebaUtilityStatisticAuto {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public interface HostUtilityStatistic {
        void debugLog(StatisticParam statisticParam);

        void statLogEvent(StatisticParam statisticParam);
    }

    /* loaded from: classes10.dex */
    public static class StatisticParam {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String key;
        public HashMap params;

        public StatisticParam() {
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

        public static StatisticParam fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                StatisticParam statisticParam = new StatisticParam();
                statisticParam.key = (String) hashMap.get("key");
                statisticParam.params = (HashMap) hashMap.get("params");
                return statisticParam;
            }
            return (StatisticParam) invokeL.objValue;
        }

        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.key : (String) invokeV.objValue;
        }

        public HashMap getParams() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.params : (HashMap) invokeV.objValue;
        }

        public void setKey(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.key = str;
            }
        }

        public void setParams(HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, hashMap) == null) {
                this.params = hashMap;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("key", this.key);
                hashMap.put("params", this.params);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    public TiebaUtilityStatisticAuto() {
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
