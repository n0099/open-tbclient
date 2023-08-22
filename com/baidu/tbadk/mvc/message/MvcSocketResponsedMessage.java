package com.baidu.tbadk.mvc.message;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tbadk.mvc.data.IResponseData;
import com.baidu.tieba.fi;
import com.baidu.tieba.ne;
import com.baidu.tieba.r45;
import com.baidu.tieba.vh;
import com.baidu.tieba.wq5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.lang.reflect.Field;
import java.util.List;
import protobuf.Error;
/* loaded from: classes4.dex */
public abstract class MvcSocketResponsedMessage<D extends IResponseData, M extends Message> extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public D data;

    public abstract Class<M> getProtobufResponseIdlClass();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MvcSocketResponsedMessage(int i) {
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

    public Object createData(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls)) == null) {
            try {
                return cls.newInstance();
            } catch (ExceptionInInitializerError e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return invokeL.objValue;
    }

    public void setData(D d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, d) == null) {
            this.data = d;
        }
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        boolean z;
        List<Field> c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, bArr)) == null) {
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
                return parseFrom;
            }
            Object obj = null;
            if (getOrginalMessage() instanceof MvcSocketMessage) {
                obj = createData(((MvcSocketMessage) getOrginalMessage()).getResponseDataClass());
            } else if (getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof MvcNetMessage)) {
                obj = createData(((MvcNetMessage) getOrginalMessage().getExtra()).getResponseDataClass());
            }
            if (obj instanceof IResponseData) {
                D d = (D) obj;
                this.data = d;
                d.initByProtobuf(parseFrom);
            }
            return parseFrom;
        }
        return invokeIL.objValue;
    }

    public D getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.data;
        }
        return (D) invokeV.objValue;
    }
}
