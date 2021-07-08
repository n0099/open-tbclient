package com.baidu.tieba.im.forum.broadcast.model;

import androidx.core.view.InputDeviceCompat;
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
import d.a.c.a.f;
/* loaded from: classes4.dex */
public class ForumBroadCastMajorHistoryModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.p0.i1.i.a.a f17483e;

    /* renamed from: f  reason: collision with root package name */
    public final String f17484f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17485g;

    /* renamed from: h  reason: collision with root package name */
    public long f17486h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f17487i;
    public d.a.p0.i1.i.a.b.a j;
    public d.a.c.c.g.a k;
    public HttpMessageListener l;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumBroadCastMajorHistoryModel f17488a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumBroadCastMajorHistoryModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f17488a = forumBroadCastMajorHistoryModel;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f17488a.f17485g = false;
                if (responsedMessage == null) {
                    return;
                }
                d.a.p0.i1.i.a.b.a aVar = null;
                if (responsedMessage instanceof ResponseHttpMajorHistoryMessage) {
                    aVar = ((ResponseHttpMajorHistoryMessage) responsedMessage).getData();
                } else if (responsedMessage instanceof ResponseSocketMajorHistoryMessage) {
                    aVar = ((ResponseSocketMajorHistoryMessage) responsedMessage).getData();
                }
                this.f17488a.mErrorCode = responsedMessage.getError();
                this.f17488a.mErrorString = responsedMessage.getErrorString();
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.f17488a.mErrorCode);
                errorData.setError_msg(this.f17488a.mErrorString);
                if (this.f17488a.f17483e == null) {
                    return;
                }
                if (this.f17488a.mErrorCode != 0 || aVar == null) {
                    this.f17488a.f17483e.onServerError(errorData);
                    return;
                }
                this.f17488a.j = aVar;
                this.f17488a.I();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumBroadCastMajorHistoryModel f17489a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ForumBroadCastMajorHistoryModel forumBroadCastMajorHistoryModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumBroadCastMajorHistoryModel, Integer.valueOf(i2)};
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
            this.f17489a = forumBroadCastMajorHistoryModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null) {
                return;
            }
            ForumBroadcastMajorResidueData data = httpResponsedMessage instanceof ResponseHttpMajorResidueMessage ? ((ResponseHttpMajorResidueMessage) httpResponsedMessage).getData() : null;
            if (this.f17489a.f17483e != null) {
                this.f17489a.f17483e.netResidueCallback(data);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumBroadCastMajorHistoryModel(TbPageContext tbPageContext, d.a.p0.i1.i.a.a aVar, String str) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {tbPageContext, aVar, str};
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
        this.f17486h = 0L;
        this.j = null;
        this.k = new a(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, 309669);
        this.l = new b(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE);
        d.a.p0.h3.d0.a.h(309669, ResponseSocketMajorHistoryMessage.class, false, false);
        d.a.p0.h3.d0.a.c(309669, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, TbConfig.URL_FORUM_BROADCAST_HISTORY, ResponseHttpMajorHistoryMessage.class, true, false, true, false);
        d.a.p0.h3.d0.a.e(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE, "c/f/forum/getForumMangerRights", ResponseHttpMajorResidueMessage.class, true, true, true, true);
        registerListener(this.k);
        registerListener(this.l);
        this.f17483e = aVar;
        this.f17484f = str;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
            httpMessage.addParam("forum_id", this.f17484f);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void G(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            BroadcastMajorHistoryRequestMessage broadcastMajorHistoryRequestMessage = new BroadcastMajorHistoryRequestMessage();
            broadcastMajorHistoryRequestMessage.queryType = 1;
            broadcastMajorHistoryRequestMessage.needCount = 15;
            try {
                broadcastMajorHistoryRequestMessage.forumId = Long.parseLong(this.f17484f);
            } catch (Exception unused) {
                broadcastMajorHistoryRequestMessage.forumId = 0L;
            }
            if (i2 == 2) {
                broadcastMajorHistoryRequestMessage.lastId = this.f17486h;
            } else if (i2 != 1) {
                return;
            } else {
                broadcastMajorHistoryRequestMessage.lastId = 0L;
            }
            this.f17485g = true;
            sendMessage(broadcastMajorHistoryRequestMessage);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.j = null;
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.j.b() != null && this.j.b().size() > 1) {
                this.f17486h = this.j.b().get(this.j.b().size() - 1).b();
            }
            this.j.e(this.f17487i);
            this.f17483e.netCallback(this.j);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
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

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d.a.p0.i1.i.a.b.a aVar = this.j;
            if (aVar == null) {
                return false;
            }
            return !ListUtils.isEmpty(aVar.b());
        }
        return invokeV.booleanValue;
    }

    public void loadMore() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f17485g) {
            return;
        }
        this.f17487i = false;
        G(2);
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f17485g) {
            return;
        }
        this.f17487i = true;
        G(1);
    }
}
