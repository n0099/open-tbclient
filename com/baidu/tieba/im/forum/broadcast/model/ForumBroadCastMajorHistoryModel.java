package com.baidu.tieba.im.forum.broadcast.model;

import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.im.forum.broadcast.data.BroadcastMajorHistoryRequestMessage;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
import com.baidu.tieba.im.forum.broadcast.data.ResponseHttpMajorHistoryMessage;
import com.baidu.tieba.im.forum.broadcast.data.ResponseHttpMajorResidueMessage;
import com.baidu.tieba.im.forum.broadcast.data.ResponseSocketMajorHistoryMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ForumBroadCastMajorHistoryModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.p0.u1.i.a.a a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33792b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33793c;

    /* renamed from: d  reason: collision with root package name */
    public long f33794d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33795e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.u1.i.a.b.a f33796f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.c.g.a f33797g;

    /* renamed from: h  reason: collision with root package name */
    public HttpMessageListener f33798h;

    /* loaded from: classes5.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumBroadCastMajorHistoryModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumBroadCastMajorHistoryModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumBroadCastMajorHistoryModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.f33793c = false;
                if (responsedMessage == null) {
                    return;
                }
                c.a.p0.u1.i.a.b.a aVar = null;
                if (responsedMessage instanceof ResponseHttpMajorHistoryMessage) {
                    aVar = ((ResponseHttpMajorHistoryMessage) responsedMessage).getData();
                } else if (responsedMessage instanceof ResponseSocketMajorHistoryMessage) {
                    aVar = ((ResponseSocketMajorHistoryMessage) responsedMessage).getData();
                }
                this.a.mErrorCode = responsedMessage.getError();
                this.a.mErrorString = responsedMessage.getErrorString();
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.a.mErrorCode);
                errorData.setError_msg(this.a.mErrorString);
                if (this.a.a == null) {
                    return;
                }
                if (this.a.mErrorCode != 0 || aVar == null) {
                    this.a.a.onServerError(errorData);
                    return;
                }
                this.a.f33796f = aVar;
                this.a.K();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumBroadCastMajorHistoryModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumBroadCastMajorHistoryModel, Integer.valueOf(i)};
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
            this.a = forumBroadCastMajorHistoryModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null) {
                return;
            }
            ForumBroadcastMajorResidueData data = httpResponsedMessage instanceof ResponseHttpMajorResidueMessage ? ((ResponseHttpMajorResidueMessage) httpResponsedMessage).getData() : null;
            if (this.a.a != null) {
                this.a.a.netResidueCallback(data);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumBroadCastMajorHistoryModel(TbPageContext tbPageContext, c.a.p0.u1.i.a.a aVar, String str) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {tbPageContext, aVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33794d = 0L;
        this.f33796f = null;
        this.f33797g = new a(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, 309669);
        this.f33798h = new b(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE);
        c.a.p0.a4.g0.a.h(309669, ResponseSocketMajorHistoryMessage.class, false, false);
        c.a.p0.a4.g0.a.c(309669, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, TbConfig.URL_FORUM_BROADCAST_HISTORY, ResponseHttpMajorHistoryMessage.class, true, false, true, false);
        c.a.p0.a4.g0.a.e(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE, "c/f/forum/getForumMangerRights", ResponseHttpMajorResidueMessage.class, true, true, true, true);
        registerListener(this.f33797g);
        registerListener(this.f33798h);
        this.a = aVar;
        this.f33792b = str;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
            httpMessage.addParam("forum_id", this.f33792b);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            BroadcastMajorHistoryRequestMessage broadcastMajorHistoryRequestMessage = new BroadcastMajorHistoryRequestMessage();
            broadcastMajorHistoryRequestMessage.queryType = 1;
            broadcastMajorHistoryRequestMessage.needCount = 15;
            try {
                broadcastMajorHistoryRequestMessage.forumId = Long.parseLong(this.f33792b);
            } catch (Exception unused) {
                broadcastMajorHistoryRequestMessage.forumId = 0L;
            }
            if (i == 2) {
                broadcastMajorHistoryRequestMessage.lastId = this.f33794d;
            } else if (i != 1) {
                return;
            } else {
                broadcastMajorHistoryRequestMessage.lastId = 0L;
            }
            this.f33793c = true;
            sendMessage(broadcastMajorHistoryRequestMessage);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f33796f = null;
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f33796f.b() != null && this.f33796f.b().size() > 1) {
                this.f33794d = this.f33796f.b().get(this.f33796f.b().size() - 1).b();
            }
            this.f33796f.e(this.f33795e);
            this.a.netCallback(this.f33796f);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.p0.u1.i.a.b.a aVar = this.f33796f;
            if (aVar == null) {
                return false;
            }
            return !ListUtils.isEmpty(aVar.b());
        }
        return invokeV.booleanValue;
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

    public void loadMore() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f33793c) {
            return;
        }
        this.f33795e = false;
        I(2);
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f33793c) {
            return;
        }
        this.f33795e = true;
        I(1);
    }
}
