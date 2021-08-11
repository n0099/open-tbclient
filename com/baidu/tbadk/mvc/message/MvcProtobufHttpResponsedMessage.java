package com.baidu.tbadk.mvc.message;

import android.text.TextUtils;
import c.a.e.e.d.l;
import c.a.e.e.p.b;
import c.a.e.e.p.n;
import c.a.o0.i0.b.d;
import c.a.o0.i0.b.h;
import c.a.o0.s.r.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.lang.reflect.Field;
import java.util.List;
import protobuf.Error;
/* loaded from: classes6.dex */
public abstract class MvcProtobufHttpResponsedMessage<D extends h, M extends Message> extends MvcHttpResponsedMessage<D> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MvcProtobufHttpResponsedMessage(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        d dVar;
        l<byte[]> e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            super.afterDispatchInBackGround(i2, (int) bArr);
            if (getError() != 0 || bArr == null) {
                return;
            }
            if (getOrginalMessage() instanceof MvcSocketMessage) {
                MvcSocketMessage mvcSocketMessage = (MvcSocketMessage) getOrginalMessage();
                if (mvcSocketMessage.isNeedCache() && (mvcSocketMessage.getData() instanceof d)) {
                    dVar = (d) mvcSocketMessage.getData();
                }
                dVar = null;
            } else {
                if (getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof MvcNetMessage)) {
                    MvcNetMessage mvcNetMessage = (MvcNetMessage) getOrginalMessage().getExtra();
                    if (mvcNetMessage.isNeedCache() && (mvcNetMessage.getRequestData() instanceof d)) {
                        dVar = (d) mvcNetMessage.getRequestData();
                    }
                }
                dVar = null;
            }
            if (dVar != null) {
                String cacheKey = dVar.getCacheKey();
                String v = dVar.v();
                String currentAccount = dVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(v) || bArr == null || (e2 = a.f().e(v, currentAccount)) == null) {
                    return;
                }
                e2.g(cacheKey, bArr);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        boolean z;
        List<Field> c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, bArr) == null) {
            super.decodeInBackGround(i2, bArr);
            Message parseFrom = new Wire(new Class[0]).parseFrom(bArr, getProtobufResponseIdlClass());
            List<Field> c3 = b.c(parseFrom, Error.class);
            if (c3 == null || c3.size() <= 0) {
                z = false;
            } else {
                z = true;
                Object a2 = n.a(parseFrom, c3.get(0));
                if (a2 instanceof Error) {
                    Error error = (Error) a2;
                    setError(error.errorno.intValue());
                    setErrorString(error.usermsg);
                }
            }
            if (!z && (c2 = b.c(parseFrom, tbclient.Error.class)) != null && c2.size() > 0) {
                Object a3 = n.a(parseFrom, c2.get(0));
                if (a3 instanceof tbclient.Error) {
                    tbclient.Error error2 = (tbclient.Error) a3;
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
            if (obj instanceof h) {
                D d2 = (D) obj;
                this.data = d2;
                d2.initByProtobuf(parseFrom);
            }
        }
    }
}
