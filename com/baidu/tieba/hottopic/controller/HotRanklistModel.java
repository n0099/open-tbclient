package com.baidu.tieba.hottopic.controller;

import c.a.e.a.f;
import c.a.p0.h1.c.j;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.hottopic.message.RequestHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotRanklistMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class HotRanklistModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f52366e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.e.c.g.a f52367f;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotRanklistModel f52368a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HotRanklistModel hotRanklistModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotRanklistModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52368a = hotRanklistModel;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (((responsedMessage instanceof ResponseHttpHotRanklistMessage) || (responsedMessage instanceof ResponseSocketHotRanklistMessage)) && responsedMessage.getOrginalMessage().getTag() == this.f52368a.getUniqueId()) {
                if (!responsedMessage.hasError()) {
                    this.f52368a.z(responsedMessage);
                } else {
                    this.f52368a.f52366e.loadNetDataCallback(false, null, responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void loadNetDataCallback(boolean z, j jVar, int i2, String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotRanklistModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52366e = null;
        a aVar = new a(this, CmdConfigHttp.CMD_HOT_TOPIC_RANKLIST, 309289);
        this.f52367f = aVar;
        registerListener(aVar);
    }

    public final void A(String str, String str2, String str3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, Long.valueOf(j2)}) == null) {
            RequestHotRanklistMessage requestHotRanklistMessage = new RequestHotRanklistMessage();
            requestHotRanklistMessage.setCallFrom(str);
            requestHotRanklistMessage.setListType(str2);
            requestHotRanklistMessage.setNeedTabList(str3);
            requestHotRanklistMessage.setFid(j2);
            sendMessage(requestHotRanklistMessage);
        }
    }

    public void B(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f52366e = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void y(String str, String str2, String str3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, Long.valueOf(j2)}) == null) {
            A(str, str2, str3, j2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void z(ResponsedMessage<?> responsedMessage) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, responsedMessage) == null) || responsedMessage == null) {
            return;
        }
        j jVar = null;
        if (responsedMessage.getOrginalMessage() != null) {
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (extra instanceof RequestHotRanklistMessage) {
                str = ((RequestHotRanklistMessage) extra).getListType();
                if (responsedMessage instanceof ResponseHttpHotRanklistMessage) {
                    ResponseHttpHotRanklistMessage responseHttpHotRanklistMessage = (ResponseHttpHotRanklistMessage) responsedMessage;
                    if (responseHttpHotRanklistMessage.getHotRanklistData() != null) {
                        jVar = responseHttpHotRanklistMessage.getHotRanklistData();
                    }
                }
                if (responsedMessage instanceof ResponseSocketHotRanklistMessage) {
                    ResponseSocketHotRanklistMessage responseSocketHotRanklistMessage = (ResponseSocketHotRanklistMessage) responsedMessage;
                    if (responseSocketHotRanklistMessage.getHotRanklistData() != null) {
                        jVar = responseSocketHotRanklistMessage.getHotRanklistData();
                    }
                }
                if (!StringUtils.isNull(str) && !ListUtils.isEmpty(jVar.f18306b)) {
                    jVar.f18305a = jVar.f18306b.get(0).f18333f;
                } else {
                    jVar.f18305a = str;
                }
                this.f52366e.loadNetDataCallback(!responsedMessage.hasError(), jVar, responsedMessage.getError(), responsedMessage.getErrorString());
            }
        }
        str = null;
        if (responsedMessage instanceof ResponseHttpHotRanklistMessage) {
        }
        if (responsedMessage instanceof ResponseSocketHotRanklistMessage) {
        }
        if (!StringUtils.isNull(str)) {
        }
        jVar.f18305a = str;
        this.f52366e.loadNetDataCallback(!responsedMessage.hasError(), jVar, responsedMessage.getError(), responsedMessage.getErrorString());
    }
}
