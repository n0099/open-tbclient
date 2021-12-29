package com.baidu.tieba.hottopic.controller;

import c.a.d.a.f;
import c.a.d.f.p.n;
import c.a.s0.s.k;
import c.a.t0.q1.l.e;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.hottopic.message.RequestHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotTopicMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class HotTopicModel extends BdBaseModel<BaseActivity<?>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SORT_TYPE_HOT = 1;
    public static final int SORT_TYPE_NEW = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity<?> f46361e;

    /* renamed from: f  reason: collision with root package name */
    public b f46362f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.c.g.a f46363g;

    /* loaded from: classes12.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HotTopicModel hotTopicModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.a = hotTopicModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (((responsedMessage instanceof ResponseHttpHotTopicMessage) || (responsedMessage instanceof ResponseSocketHotTopicMessage)) && responsedMessage.getOrginalMessage().getTag() == this.a.getUniqueId()) {
                if (!responsedMessage.hasError()) {
                    this.a.A(responsedMessage);
                    return;
                }
                if (!StringUtils.isNull(responsedMessage.getErrorString())) {
                    this.a.f46361e.showToast(responsedMessage.getErrorString());
                }
                this.a.f46362f.hotTopicDataCallback(false, null);
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface b {
        void hotTopicDataCallback(boolean z, e eVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicModel(BaseActivity<?> baseActivity) {
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
        this.f46362f = null;
        a aVar = new a(this, CmdConfigHttp.CMD_HOT_TOPIC, 303050);
        this.f46363g = aVar;
        this.f46361e = baseActivity;
        registerListener(aVar);
    }

    public final void A(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
            return;
        }
        e eVar = null;
        if (responsedMessage instanceof ResponseHttpHotTopicMessage) {
            ResponseHttpHotTopicMessage responseHttpHotTopicMessage = (ResponseHttpHotTopicMessage) responsedMessage;
            if (responseHttpHotTopicMessage.getHotTopicData() != null) {
                eVar = responseHttpHotTopicMessage.getHotTopicData();
            }
        }
        if (responsedMessage instanceof ResponseSocketHotTopicMessage) {
            ResponseSocketHotTopicMessage responseSocketHotTopicMessage = (ResponseSocketHotTopicMessage) responsedMessage;
            if (responseSocketHotTopicMessage.getHotTopicData() != null) {
                eVar = responseSocketHotTopicMessage.getHotTopicData();
            }
        }
        if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
            eVar.s = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
        }
        this.f46362f.hotTopicDataCallback(!responsedMessage.hasError(), eVar);
    }

    public final void B(long j2, String str, int i2, long j3, String str2, String str3, String str4, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), str, Integer.valueOf(i2), Long.valueOf(j3), str2, str3, str4, Long.valueOf(j4)}) == null) {
            RequestHotTopicMessage requestHotTopicMessage = new RequestHotTopicMessage();
            int k2 = n.k(TbadkCoreApplication.getInst().getApp());
            int i3 = n.i(TbadkCoreApplication.getInst().getApp());
            requestHotTopicMessage.setTopicId(Long.valueOf(j2));
            requestHotTopicMessage.setCall_from(D(str4));
            requestHotTopicMessage.setTopicName(str);
            requestHotTopicMessage.setScrH(Integer.valueOf(i3));
            requestHotTopicMessage.setTopic_tid(j4);
            requestHotTopicMessage.setScrW(Integer.valueOf(k2));
            requestHotTopicMessage.setSrcDip(Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density));
            requestHotTopicMessage.setFid(Long.valueOf(j3));
            requestHotTopicMessage.setFirst_dir(str2);
            requestHotTopicMessage.setSecond_dir(str3);
            requestHotTopicMessage.setQType(Integer.valueOf(k.c().e()));
            requestHotTopicMessage.setSort_type(Integer.valueOf(i2));
            if (requestHotTopicMessage.getHttpMessage() != null) {
                requestHotTopicMessage.getHttpMessage().setExtra(Integer.valueOf(i2));
                requestHotTopicMessage.getHttpMessage().setTag(getUniqueId());
            }
            if (requestHotTopicMessage.getSocketMessage() != null) {
                requestHotTopicMessage.getSocketMessage().setExtra(Integer.valueOf(i2));
                requestHotTopicMessage.getSocketMessage().setTag(getUniqueId());
            }
            sendMessage(requestHotTopicMessage);
        }
    }

    public void C(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f46362f = bVar;
        }
    }

    public final int D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if ("1".equals(str)) {
                return 1;
            }
            if ("2".equals(str)) {
                return 2;
            }
            if ("3".equals(str)) {
                return 3;
            }
            if ("4".equals(str)) {
                return 4;
            }
            return "5".equals(str) ? 5 : 1;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void z(String str, String str2, int i2, long j2, String str3, String str4, String str5, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i2), Long.valueOf(j2), str3, str4, str5, Long.valueOf(j3)}) == null) {
            B(c.a.d.f.m.b.g(str, 0L), str2, i2, j2 < 0 ? 0L : j2, StringUtils.isNull(str3) ? "" : str3, StringUtils.isNull(str4) ? "" : str4, str5, j3);
        }
    }
}
