package com.baidu.tbadk.mvc.message;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.data.IResponseData;
import com.baidu.tieba.fi;
import com.baidu.tieba.ne;
import com.baidu.tieba.r45;
import com.baidu.tieba.vh;
import com.baidu.tieba.wq5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.lang.reflect.Field;
import java.util.List;
import protobuf.Error;
/* loaded from: classes4.dex */
public abstract class MvcProtobufHttpResponsedMessage<D extends IResponseData, M extends Message> extends MvcHttpResponsedMessage<D> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract Class<M> getProtobufResponseIdlClass();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MvcProtobufHttpResponsedMessage(int i) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        wq5 wq5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            super.afterDispatchInBackGround(i, (int) bArr);
            if (getError() == 0 && bArr != null) {
                String str = null;
                if (getOrginalMessage() instanceof MvcSocketMessage) {
                    MvcSocketMessage mvcSocketMessage = (MvcSocketMessage) getOrginalMessage();
                    if (mvcSocketMessage.isNeedCache() && (mvcSocketMessage.getData() instanceof wq5)) {
                        wq5Var = (wq5) mvcSocketMessage.getData();
                    }
                    wq5Var = null;
                } else {
                    if (getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof MvcNetMessage)) {
                        MvcNetMessage mvcNetMessage = (MvcNetMessage) getOrginalMessage().getExtra();
                        if (mvcNetMessage.isNeedCache() && (mvcNetMessage.getRequestData() instanceof wq5)) {
                            wq5Var = (wq5) mvcNetMessage.getRequestData();
                        }
                    }
                    wq5Var = null;
                }
                if (wq5Var != null) {
                    String cacheKey = wq5Var.getCacheKey();
                    String cacheTableName = wq5Var.getCacheTableName();
                    if (wq5Var.isNeedUid()) {
                        str = TbadkCoreApplication.getCurrentAccount();
                    }
                    if (cacheKey != null && !TextUtils.isEmpty(cacheTableName) && bArr != null) {
                        r45.k();
                        ne<byte[]> j = r45.j(cacheTableName, str);
                        if (j == null) {
                            return;
                        }
                        j.g(cacheKey, bArr);
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        boolean z;
        List<Field> c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) {
            super.decodeInBackGround(i, bArr);
            Message parseFrom = new Wire(new Class[0]).parseFrom(bArr, getProtobufResponseIdlClass());
            List<Field> c2 = vh.c(parseFrom, Error.class);
            if (c2 != null && c2.size() > 0) {
                z = true;
                Object a = fi.a(parseFrom, c2.get(0));
                if (a instanceof Error) {
                    Error error = (Error) a;
                    setError(error.errorno.intValue());
                    setErrorString(error.usermsg);
                }
            } else {
                z = false;
            }
            if (!z && (c = vh.c(parseFrom, tbclient.Error.class)) != null && c.size() > 0) {
                Object a2 = fi.a(parseFrom, c.get(0));
                if (a2 instanceof tbclient.Error) {
                    tbclient.Error error2 = (tbclient.Error) a2;
                    setError(error2.errorno.intValue());
                    setErrorString(error2.usermsg);
                }
            }
            if (getError() != 0) {
                return;
            }
            Object obj = null;
            if (getOrginalMessage() instanceof MvcHttpMessage) {
                obj = createData(((MvcHttpMessage) getOrginalMessage()).getResponseDataClass());
            } else if (getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof MvcNetMessage)) {
                obj = createData(((MvcNetMessage) getOrginalMessage().getExtra()).getResponseDataClass());
            }
            if (obj instanceof IResponseData) {
                D d = (D) obj;
                this.data = d;
                d.initByProtobuf(parseFrom);
            }
        }
    }
}
