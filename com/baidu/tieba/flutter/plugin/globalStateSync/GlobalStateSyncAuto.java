package com.baidu.tieba.flutter.plugin.globalStateSync;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.flutter.plugin.globalStateSync.GlobalStateSyncAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
/* loaded from: classes12.dex */
public class GlobalStateSyncAuto {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes12.dex */
    public static class AllStateData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HashMap commonStates;
        public HashMap loginUserInfo;
        public HashMap netStates;
        public HashMap syncData;
        public HashMap themeData;

        public AllStateData() {
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

        public static AllStateData fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                AllStateData allStateData = new AllStateData();
                allStateData.themeData = (HashMap) hashMap.get("themeData");
                allStateData.loginUserInfo = (HashMap) hashMap.get("loginUserInfo");
                allStateData.syncData = (HashMap) hashMap.get("syncData");
                allStateData.commonStates = (HashMap) hashMap.get("commonStates");
                allStateData.netStates = (HashMap) hashMap.get("netStates");
                return allStateData;
            }
            return (AllStateData) invokeL.objValue;
        }

        public HashMap getCommonStates() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.commonStates : (HashMap) invokeV.objValue;
        }

        public HashMap getLoginUserInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.loginUserInfo : (HashMap) invokeV.objValue;
        }

        public HashMap getNetStates() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.netStates : (HashMap) invokeV.objValue;
        }

        public HashMap getSyncData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.syncData : (HashMap) invokeV.objValue;
        }

        public HashMap getThemeData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.themeData : (HashMap) invokeV.objValue;
        }

        public void setCommonStates(HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, hashMap) == null) {
                this.commonStates = hashMap;
            }
        }

        public void setLoginUserInfo(HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, hashMap) == null) {
                this.loginUserInfo = hashMap;
            }
        }

        public void setNetStates(HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, hashMap) == null) {
                this.netStates = hashMap;
            }
        }

        public void setSyncData(HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hashMap) == null) {
                this.syncData = hashMap;
            }
        }

        public void setThemeData(HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, hashMap) == null) {
                this.themeData = hashMap;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("themeData", this.themeData);
                hashMap.put("loginUserInfo", this.loginUserInfo);
                hashMap.put("syncData", this.syncData);
                hashMap.put("commonStates", this.commonStates);
                hashMap.put("netStates", this.netStates);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class FlutterGlobalStateSync {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BinaryMessenger binaryMessenger;

        /* loaded from: classes12.dex */
        public interface Reply<T> {
            void reply(T t);
        }

        public FlutterGlobalStateSync(BinaryMessenger binaryMessenger) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {binaryMessenger};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.binaryMessenger = binaryMessenger;
        }

        public void writeToFlutter(SingleTypeStateData singleTypeStateData, final Reply<WriteResult> reply) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, singleTypeStateData, reply) == null) {
                new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterGlobalStateSync.writeToFlutter", new StandardMessageCodec()).send(singleTypeStateData.toMap(), new BasicMessageChannel.Reply() { // from class: c.a.t0.a1.a.b.a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                    public final void reply(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            GlobalStateSyncAuto.FlutterGlobalStateSync.Reply.this.reply(GlobalStateSyncAuto.WriteResult.fromMap((HashMap) obj));
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface HostGlobalStateSync {
        void readAllState(Result<AllStateData> result);

        void readStateForType(readParam readparam, Result<SingleTypeStateData> result);

        void write(SingleTypeStateData singleTypeStateData);
    }

    /* loaded from: classes12.dex */
    public interface Result<T> {
        void success(T t);
    }

    /* loaded from: classes12.dex */
    public static class SingleTypeStateData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HashMap data;
        public Long subType;
        public Long type;

        public SingleTypeStateData() {
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

        public static SingleTypeStateData fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Long valueOf;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                SingleTypeStateData singleTypeStateData = new SingleTypeStateData();
                Object obj = hashMap.get("type");
                Long l = null;
                if (obj == null) {
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
                }
                singleTypeStateData.type = valueOf;
                Object obj2 = hashMap.get("subType");
                if (obj2 != null) {
                    l = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
                }
                singleTypeStateData.subType = l;
                singleTypeStateData.data = (HashMap) hashMap.get("data");
                return singleTypeStateData;
            }
            return (SingleTypeStateData) invokeL.objValue;
        }

        public HashMap getData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.data : (HashMap) invokeV.objValue;
        }

        public Long getSubType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.subType : (Long) invokeV.objValue;
        }

        public Long getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.type : (Long) invokeV.objValue;
        }

        public void setData(HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, hashMap) == null) {
                this.data = hashMap;
            }
        }

        public void setSubType(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, l) == null) {
                this.subType = l;
            }
        }

        public void setType(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, l) == null) {
                this.type = l;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("type", this.type);
                hashMap.put("subType", this.subType);
                hashMap.put("data", this.data);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class WriteResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Boolean result;

        public WriteResult() {
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

        public static WriteResult fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                WriteResult writeResult = new WriteResult();
                writeResult.result = (Boolean) hashMap.get("result");
                return writeResult;
            }
            return (WriteResult) invokeL.objValue;
        }

        public Boolean getResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.result : (Boolean) invokeV.objValue;
        }

        public void setResult(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                this.result = bool;
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

    /* loaded from: classes12.dex */
    public static class readParam {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Long type;

        public readParam() {
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

        public static readParam fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Long valueOf;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                readParam readparam = new readParam();
                Object obj = hashMap.get("type");
                if (obj == null) {
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
                }
                readparam.type = valueOf;
                return readparam;
            }
            return (readParam) invokeL.objValue;
        }

        public Long getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.type : (Long) invokeV.objValue;
        }

        public void setType(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l) == null) {
                this.type = l;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("type", this.type);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    public GlobalStateSyncAuto() {
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
