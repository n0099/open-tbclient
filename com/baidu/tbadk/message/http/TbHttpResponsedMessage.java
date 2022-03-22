package com.baidu.tbadk.message.http;

import c.a.d.f.j.b.e;
import c.a.d.f.j.b.f;
import c.a.d.f.p.l;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.NetWorkState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class TbHttpResponsedMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbHttpResponsedMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private int getMode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            if (i != 1) {
                if (i == 2) {
                    return 2;
                }
                if (i == 3) {
                    return 3;
                }
            }
            return 1;
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
        }
    }

    public String getCharset() throws Exception {
        InterceptResult invokeV;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String contentType = getContentType();
            if (contentType == null || (indexOf = contentType.indexOf("charset")) == -1) {
                return IMAudioTransRequest.CHARSET;
            }
            int indexOf2 = contentType.indexOf(32, indexOf);
            if (indexOf2 == -1) {
                return contentType.substring(indexOf + 8);
            }
            return contentType.substring(indexOf + 8, indexOf2);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.HttpResponsedMessage
    public void logStatInBackground(int i, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, fVar) == null) || fVar.d().size() <= 0) {
            return;
        }
        e eVar = fVar.d().get(fVar.d().size() - 1);
        NetWorkState.mErrorNums.addAndGet(fVar.d().size() - 1);
        NetWorkState.StatisticsData statisticsData = new NetWorkState.StatisticsData();
        statisticsData.mMode = getMode(l.I());
        statisticsData.mSize = eVar.f2146b;
        statisticsData.mTime = eVar.f2150f;
        statisticsData.mTimesNum = eVar.f2149e;
        statisticsData.mMethod = fVar.b().i() != HttpMessageTask.HTTP_METHOD.POST ? 2 : 1;
        NetWorkState.addStatisticsData(statisticsData);
    }

    public String parseToString(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            return new String(bArr, getCharset());
        }
        return (String) invokeL.objValue;
    }
}
