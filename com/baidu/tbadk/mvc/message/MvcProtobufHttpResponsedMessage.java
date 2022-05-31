package com.baidu.tbadk.mvc.message;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bi;
import com.repackage.cq4;
import com.repackage.d65;
import com.repackage.ni;
import com.repackage.qe;
import com.repackage.z55;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.lang.reflect.Field;
import java.util.List;
import protobuf.Error;
/* loaded from: classes3.dex */
public abstract class MvcProtobufHttpResponsedMessage<D extends d65, M extends Message> extends MvcHttpResponsedMessage<D> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    public abstract Class<M> getProtobufResponseIdlClass();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        z55 z55Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            super.afterDispatchInBackGround(i, (int) bArr);
            if (getError() != 0 || bArr == null) {
                return;
            }
            if (getOrginalMessage() instanceof MvcSocketMessage) {
                MvcSocketMessage mvcSocketMessage = (MvcSocketMessage) getOrginalMessage();
                if (mvcSocketMessage.isNeedCache() && (mvcSocketMessage.getData() instanceof z55)) {
                    z55Var = (z55) mvcSocketMessage.getData();
                }
                z55Var = null;
            } else {
                if (getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof MvcNetMessage)) {
                    MvcNetMessage mvcNetMessage = (MvcNetMessage) getOrginalMessage().getExtra();
                    if (mvcNetMessage.isNeedCache() && (mvcNetMessage.getRequestData() instanceof z55)) {
                        z55Var = (z55) mvcNetMessage.getRequestData();
                    }
                }
                z55Var = null;
            }
            if (z55Var != null) {
                String cacheKey = z55Var.getCacheKey();
                String x = z55Var.x();
                String currentAccount = z55Var.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(x) || bArr == null) {
                    return;
                }
                cq4.f();
                qe<byte[]> e = cq4.e(x, currentAccount);
                if (e == null) {
                    return;
                }
                e.g(cacheKey, bArr);
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
            List<Field> c2 = bi.c(parseFrom, Error.class);
            if (c2 == null || c2.size() <= 0) {
                z = false;
            } else {
                z = true;
                Object a = ni.a(parseFrom, c2.get(0));
                if (a instanceof Error) {
                    Error error = (Error) a;
                    setError(error.errorno.intValue());
                    setErrorString(error.usermsg);
                }
            }
            if (!z && (c = bi.c(parseFrom, tbclient.Error.class)) != null && c.size() > 0) {
                Object a2 = ni.a(parseFrom, c.get(0));
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
            if (obj instanceof d65) {
                D d = (D) obj;
                this.data = d;
                d.initByProtobuf(parseFrom);
            }
        }
    }
}
