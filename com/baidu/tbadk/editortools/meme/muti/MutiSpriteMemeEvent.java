package com.baidu.tbadk.editortools.meme.muti;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.editortools.meme.SpriteMemeShowConfigData;
import com.baidu.tbadk.mutiprocess.SerializableEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/tbadk/editortools/meme/muti/MutiSpriteMemeEvent;", "Lcom/baidu/tbadk/mutiprocess/SerializableEvent;", "accountId", "", "configData", "Lcom/baidu/tbadk/editortools/meme/SpriteMemeShowConfigData;", "(Ljava/lang/String;Lcom/baidu/tbadk/editortools/meme/SpriteMemeShowConfigData;)V", "getAccountId", "()Ljava/lang/String;", "getConfigData", "()Lcom/baidu/tbadk/editortools/meme/SpriteMemeShowConfigData;", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MutiSpriteMemeEvent extends SerializableEvent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String accountId;
    public final SpriteMemeShowConfigData configData;

    public MutiSpriteMemeEvent(String str, SpriteMemeShowConfigData configData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, configData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(configData, "configData");
        this.accountId = str;
        this.configData = configData;
    }

    public final String getAccountId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.accountId;
        }
        return (String) invokeV.objValue;
    }

    public final SpriteMemeShowConfigData getConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.configData;
        }
        return (SpriteMemeShowConfigData) invokeV.objValue;
    }
}
