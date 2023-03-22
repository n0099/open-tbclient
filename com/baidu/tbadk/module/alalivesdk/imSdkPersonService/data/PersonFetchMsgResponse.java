package com.baidu.tbadk.module.alalivesdk.imSdkPersonService.data;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.response.FetchMsgResponse;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class PersonFetchMsgResponse implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long beginId;
    public int category;
    public long contacter;
    public int count;
    public long endId;
    public int errorCode;
    public int fetchReason;
    public boolean hasMore;
    public boolean isFirstSync;
    public String listenerKey;
    public long maxMsgId;
    public List<ChatMsg> msgs;
    public int realCount;
    public String strMsg;
    public String uuid;

    public PersonFetchMsgResponse(@NonNull FetchMsgResponse fetchMsgResponse) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fetchMsgResponse};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isFirstSync = false;
        this.isFirstSync = fetchMsgResponse.isFirstSync;
        this.errorCode = fetchMsgResponse.errorCode;
        this.strMsg = fetchMsgResponse.strMsg;
        this.category = fetchMsgResponse.category;
        this.contacter = fetchMsgResponse.contacter;
        this.beginId = fetchMsgResponse.beginId;
        this.endId = fetchMsgResponse.endId;
        this.count = fetchMsgResponse.count;
        this.realCount = fetchMsgResponse.realCount;
        this.maxMsgId = fetchMsgResponse.maxMsgid;
        this.uuid = fetchMsgResponse.uuid;
        this.msgs = fetchMsgResponse.msgs;
        this.listenerKey = fetchMsgResponse.listenerkey;
        this.fetchReason = fetchMsgResponse.fetchReason;
        this.hasMore = fetchMsgResponse.hasMore;
    }

    public List<ChatMsg> getMsgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.msgs;
        }
        return (List) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "FetchMsgResponse{hasMore=" + this.hasMore + "isFirstSync=" + this.isFirstSync + ", errorCode=" + this.errorCode + ", strMsg='" + this.strMsg + "', category=" + this.category + ", contacter=" + this.contacter + ", beginId=" + this.beginId + ", endId=" + this.endId + ", count=" + this.count + ", realCount=" + this.realCount + ", maxMsgid=" + this.maxMsgId + ", uuid='" + this.uuid + "', msgs=" + this.msgs + ", listenerkey='" + this.listenerKey + "', fetchReason = " + this.fetchReason + '}';
        }
        return (String) invokeV.objValue;
    }
}
