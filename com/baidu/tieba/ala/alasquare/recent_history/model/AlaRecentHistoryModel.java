package com.baidu.tieba.ala.alasquare.recent_history.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.alasquare.recent_history.message.AlaRecentHistoryResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaRecentHistoryModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.p0.v.d.e.b.b> f14062e;

    /* renamed from: f  reason: collision with root package name */
    public b f14063f;

    /* renamed from: g  reason: collision with root package name */
    public int f14064g;

    /* renamed from: h  reason: collision with root package name */
    public int f14065h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14066i;
    public boolean j;
    public BdUniqueId k;
    public HttpMessageListener l;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaRecentHistoryModel f14067a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaRecentHistoryModel alaRecentHistoryModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecentHistoryModel, Integer.valueOf(i2)};
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
            this.f14067a = alaRecentHistoryModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021082 && (httpResponsedMessage instanceof AlaRecentHistoryResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == this.f14067a.k) {
                AlaRecentHistoryResponseMessage alaRecentHistoryResponseMessage = (AlaRecentHistoryResponseMessage) httpResponsedMessage;
                if (!alaRecentHistoryResponseMessage.isSuccess()) {
                    if (this.f14067a.f14063f != null) {
                        this.f14067a.f14063f.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.f14067a.j);
                    }
                } else {
                    d.a.p0.v.d.e.b.a recentHistoryData = alaRecentHistoryResponseMessage.getRecentHistoryData();
                    if (recentHistoryData == null) {
                        return;
                    }
                    this.f14067a.f14066i = recentHistoryData.f64490a;
                    List<d.a.p0.v.d.e.b.b> list = recentHistoryData.f64491b;
                    if (!this.f14067a.j) {
                        this.f14067a.f14062e.clear();
                        if (!ListUtils.isEmpty(list)) {
                            this.f14067a.f14062e.addAll(list);
                        }
                    } else if (!ListUtils.isEmpty(list)) {
                        AlaRecentHistoryModel.B(this.f14067a);
                        this.f14067a.f14062e.addAll(list);
                    }
                    if (this.f14067a.f14063f != null) {
                        this.f14067a.f14063f.a(this.f14067a.f14066i, this.f14067a.f14062e);
                    }
                }
                this.f14067a.j = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, List<d.a.p0.v.d.e.b.b> list);

        void b(int i2, String str, boolean z);
    }

    public AlaRecentHistoryModel(TbPageContext tbPageContext, int i2, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2), bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14064g = i2;
        this.f14063f = bVar;
        this.k = BdUniqueId.gen();
        this.f14062e = new ArrayList();
        registerListener();
        registerTask();
    }

    public static /* synthetic */ int B(AlaRecentHistoryModel alaRecentHistoryModel) {
        int i2 = alaRecentHistoryModel.f14065h;
        alaRecentHistoryModel.f14065h = i2 + 1;
        return i2;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public List<d.a.p0.v.d.e.b.b> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14062e : (List) invokeV.objValue;
    }

    public void loadMore() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f14066i && !this.j) {
            this.j = true;
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_RECENT_HISTORY_LIST);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
            httpMessage.addParam("type", this.f14064g);
            httpMessage.addParam(Config.PACKAGE_NAME, this.f14065h + 1);
            httpMessage.setTag(this.k);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_GET_RECENT_HISTORY_LIST);
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.j = false;
            this.f14065h = 0;
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_RECENT_HISTORY_LIST);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
            httpMessage.addParam("type", this.f14064g);
            httpMessage.addParam(Config.PACKAGE_NAME, this.f14065h);
            httpMessage.setTag(this.k);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l = new a(this, AlaCmdConfigHttp.CMD_ALA_GET_RECENT_HISTORY_LIST);
            MessageManager.getInstance().registerListener(this.l);
        }
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_RECENT_HISTORY_LIST, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GET_RECENT_HISTORY_LIST);
            tbHttpMessageTask.setResponsedClass(AlaRecentHistoryResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }
}
