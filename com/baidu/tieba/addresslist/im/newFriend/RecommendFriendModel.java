package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b9;
import com.repackage.dj5;
import com.repackage.mc5;
import com.repackage.pc5;
import com.repackage.tb5;
import java.util.List;
/* loaded from: classes3.dex */
public class RecommendFriendModel extends BdBaseModel<NewFriendsActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static final String c;
    public static TbHttpMessageTask d;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public final HttpMessageListener b;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFriendModel a;

        /* renamed from: com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0177a extends mc5<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ List a;

            public C0177a(a aVar, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.mc5
            /* renamed from: a */
            public Void doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    List list = this.a;
                    if (list == null || list.size() <= 0) {
                        return null;
                    }
                    dj5.f().m(this.a);
                    return null;
                }
                return (Void) invokeV.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public class b implements tb5<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ a b;

            public b(a aVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = str;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.tb5
            /* renamed from: a */
            public void onReturnDataInUI(Void r5) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
                    this.b.a.a.a(this.a);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RecommendFriendModel recommendFriendModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendFriendModel, Integer.valueOf(i)};
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
            this.a = recommendFriendModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001900) {
                if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof RecommendFriendResponseMessage)) {
                    if (this.a.a != null) {
                        this.a.a.onLoadFailed(null);
                        return;
                    }
                    return;
                }
                RecommendFriendResponseMessage recommendFriendResponseMessage = (RecommendFriendResponseMessage) httpResponsedMessage;
                String errMsg = recommendFriendResponseMessage.getErrMsg();
                if (recommendFriendResponseMessage.getError() != 0) {
                    if (this.a.a != null) {
                        this.a.a.onLoadFailed(errMsg);
                        return;
                    }
                    return;
                }
                pc5.c(new C0177a(this, recommendFriendResponseMessage.getDatas()), new b(this, errMsg));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str);

        void onLoadFailed(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1347569861, "Lcom/baidu/tieba/addresslist/im/newFriend/RecommendFriendModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1347569861, "Lcom/baidu/tieba/addresslist/im/newFriend/RecommendFriendModel;");
                return;
            }
        }
        String str = TbConfig.SERVER_ADDRESS + "c/r/friend/getRecommendList";
        c = str;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.RECOMMOEND_FRIEND_CMD, str);
        d = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(RecommendFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(d);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendFriendModel(NewFriendsActivity newFriendsActivity, b bVar) {
        super(newFriendsActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newFriendsActivity, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = new a(this, CmdConfigHttp.RECOMMOEND_FRIEND_CMD);
        this.a = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            registerListener(this.b);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            sendMessage(new HttpMessage(CmdConfigHttp.RECOMMOEND_FRIEND_CMD));
        }
    }
}
