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
import com.repackage.d9;
import com.repackage.j67;
import com.repackage.k67;
import com.repackage.wh8;
import com.repackage.za;
/* loaded from: classes3.dex */
public class ForumBroadCastMajorHistoryModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final j67 a;
    public final String b;
    public boolean c;
    public long d;
    public boolean e;
    public k67 f;
    public za g;
    public HttpMessageListener h;

    /* loaded from: classes3.dex */
    public class a extends za {
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

        @Override // com.repackage.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.c = false;
                if (responsedMessage == null) {
                    return;
                }
                k67 k67Var = null;
                if (responsedMessage instanceof ResponseHttpMajorHistoryMessage) {
                    k67Var = ((ResponseHttpMajorHistoryMessage) responsedMessage).getData();
                } else if (responsedMessage instanceof ResponseSocketMajorHistoryMessage) {
                    k67Var = ((ResponseSocketMajorHistoryMessage) responsedMessage).getData();
                }
                this.a.mErrorCode = responsedMessage.getError();
                this.a.mErrorString = responsedMessage.getErrorString();
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.a.mErrorCode);
                errorData.setError_msg(this.a.mErrorString);
                if (this.a.a == null) {
                    return;
                }
                if (this.a.mErrorCode != 0 || k67Var == null) {
                    this.a.a.f(errorData);
                    return;
                }
                this.a.f = k67Var;
                this.a.M();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.a.B0(data);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumBroadCastMajorHistoryModel(TbPageContext tbPageContext, j67 j67Var, String str) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {tbPageContext, j67Var, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 0L;
        this.f = null;
        this.g = new a(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, 309669);
        this.h = new b(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE);
        wh8.h(309669, ResponseSocketMajorHistoryMessage.class, false, false);
        wh8.c(309669, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, TbConfig.URL_FORUM_BROADCAST_HISTORY, ResponseHttpMajorHistoryMessage.class, true, false, true, false);
        wh8.e(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE, "c/f/forum/getForumMangerRights", ResponseHttpMajorResidueMessage.class, true, true, true, true);
        registerListener(this.g);
        registerListener(this.h);
        this.a = j67Var;
        this.b = str;
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
            httpMessage.addParam("forum_id", this.b);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void K(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            BroadcastMajorHistoryRequestMessage broadcastMajorHistoryRequestMessage = new BroadcastMajorHistoryRequestMessage();
            broadcastMajorHistoryRequestMessage.queryType = 1;
            broadcastMajorHistoryRequestMessage.needCount = 15;
            try {
                broadcastMajorHistoryRequestMessage.forumId = Long.parseLong(this.b);
            } catch (Exception unused) {
                broadcastMajorHistoryRequestMessage.forumId = 0L;
            }
            if (i == 2) {
                broadcastMajorHistoryRequestMessage.lastId = this.d;
            } else if (i != 1) {
                return;
            } else {
                broadcastMajorHistoryRequestMessage.lastId = 0L;
            }
            this.c = true;
            sendMessage(broadcastMajorHistoryRequestMessage);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f = null;
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f.b() != null && this.f.b().size() > 1) {
                this.d = this.f.b().get(this.f.b().size() - 1).b();
            }
            this.f.e(this.e);
            this.a.c0(this.f);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.c) {
            return;
        }
        this.e = false;
        K(2);
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            k67 k67Var = this.f;
            if (k67Var == null) {
                return false;
            }
            return !ListUtils.isEmpty(k67Var.b());
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.c) {
            return;
        }
        this.e = true;
        K(1);
    }
}
