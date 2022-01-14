package com.baidu.tieba.hottopic.controller;

import c.a.d.a.f;
import c.a.d.f.p.n;
import c.a.s0.s.k;
import c.a.s0.s.q.b1;
import c.a.t0.q1.l.d;
import c.a.t0.q1.l.e;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.hottopic.message.RequestGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketGetTopicRelateThreadMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class HotRelateThreadModel extends BdBaseModel<BaseActivity<?>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity<?> f44646e;

    /* renamed from: f  reason: collision with root package name */
    public c f44647f;

    /* renamed from: g  reason: collision with root package name */
    public b f44648g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.d.c.g.a f44649h;

    /* loaded from: classes12.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotRelateThreadModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HotRelateThreadModel hotRelateThreadModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotRelateThreadModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.a = hotRelateThreadModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (this.a.f44648g != null) {
                    this.a.f44648g.complete();
                }
                if (responsedMessage == null) {
                    return;
                }
                if (((responsedMessage instanceof ResponseHttpGetTopicRelateThreadMessage) || (responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage)) && responsedMessage.getOrginalMessage().getTag() == this.a.getUniqueId()) {
                    int i2 = 1;
                    if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
                        i2 = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                    }
                    if (!responsedMessage.hasError()) {
                        this.a.B(responsedMessage);
                        return;
                    }
                    if (!StringUtils.isNull(responsedMessage.getErrorString())) {
                        this.a.f44646e.showToast(responsedMessage.getErrorString());
                    }
                    this.a.f44647f.hotRelateThreadCallback(false, null, i2);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface b {
        void complete();
    }

    /* loaded from: classes12.dex */
    public interface c {
        void hotRelateThreadCallback(boolean z, d dVar, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotRelateThreadModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
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
        a aVar = new a(this, CmdConfigHttp.CMD_TOPIC_RELATE_THREAD, 309005);
        this.f44649h = aVar;
        this.f44646e = baseActivity;
        registerListener(aVar);
    }

    public void A(e eVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, eVar, i2) == null) || eVar == null) {
            return;
        }
        C(eVar, i2);
    }

    public final void B(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responsedMessage) == null) || responsedMessage == null) {
            return;
        }
        d dVar = null;
        if (responsedMessage instanceof ResponseHttpGetTopicRelateThreadMessage) {
            ResponseHttpGetTopicRelateThreadMessage responseHttpGetTopicRelateThreadMessage = (ResponseHttpGetTopicRelateThreadMessage) responsedMessage;
            if (responseHttpGetTopicRelateThreadMessage.getHotThreadItemListData() != null) {
                dVar = responseHttpGetTopicRelateThreadMessage.getHotThreadItemListData();
            }
        }
        if (responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage) {
            ResponseSocketGetTopicRelateThreadMessage responseSocketGetTopicRelateThreadMessage = (ResponseSocketGetTopicRelateThreadMessage) responsedMessage;
            if (responseSocketGetTopicRelateThreadMessage.getHotThreadItemListData() != null) {
                dVar = responseSocketGetTopicRelateThreadMessage.getHotThreadItemListData();
            }
        }
        this.f44647f.hotRelateThreadCallback(!responsedMessage.hasError(), dVar, (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) ? 1 : ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue());
    }

    public final void C(e eVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, eVar, i2) == null) {
            c.a.t0.q1.l.f h2 = eVar.h();
            b1 j2 = eVar.j();
            if (h2 == null || j2 == null) {
                return;
            }
            RequestGetTopicRelateThreadMessage requestGetTopicRelateThreadMessage = new RequestGetTopicRelateThreadMessage();
            double d2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int k = n.k(TbadkCoreApplication.getInst().getApp());
            int i3 = n.i(TbadkCoreApplication.getInst().getApp());
            requestGetTopicRelateThreadMessage.setTopicId(Long.valueOf(c.a.d.f.m.b.g(h2.f21543e, 0L)));
            requestGetTopicRelateThreadMessage.setTopicName(h2.f21544f);
            Long l = h2.p;
            if (l != null && h2.q != null) {
                requestGetTopicRelateThreadMessage.setPmy_topic_id(l);
                requestGetTopicRelateThreadMessage.setPmy_source(h2.q);
            }
            requestGetTopicRelateThreadMessage.setScrH(Integer.valueOf(i3));
            requestGetTopicRelateThreadMessage.setScrW(Integer.valueOf(k));
            requestGetTopicRelateThreadMessage.setScrDip(Double.valueOf(d2));
            requestGetTopicRelateThreadMessage.setRn(10);
            requestGetTopicRelateThreadMessage.setPageNo(Integer.valueOf(j2.a() + 1));
            requestGetTopicRelateThreadMessage.setQType(Integer.valueOf(k.c().e()));
            requestGetTopicRelateThreadMessage.setSort_type(Integer.valueOf(i2));
            if (requestGetTopicRelateThreadMessage.getHttpMessage() != null) {
                requestGetTopicRelateThreadMessage.getHttpMessage().setExtra(Integer.valueOf(i2));
                requestGetTopicRelateThreadMessage.getHttpMessage().setTag(getUniqueId());
            }
            if (requestGetTopicRelateThreadMessage.getSocketMessage() != null) {
                requestGetTopicRelateThreadMessage.getSocketMessage().setExtra(Integer.valueOf(i2));
                requestGetTopicRelateThreadMessage.getSocketMessage().setTag(getUniqueId());
            }
            sendMessage(requestGetTopicRelateThreadMessage);
        }
    }

    public void D(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f44647f = cVar;
        }
    }

    public void E(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f44648g = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
