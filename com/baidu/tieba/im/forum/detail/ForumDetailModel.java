package com.baidu.tieba.im.forum.detail;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.lr8;
import com.baidu.tieba.qb;
import com.baidu.tieba.r9;
import com.baidu.tieba.sb;
import com.baidu.tieba.xg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ForumDetailModel extends BdBaseModel<ForumDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumDetailActivity a;
    public f b;

    /* loaded from: classes4.dex */
    public interface f {
        void K0(BarEmotionResponseMessage barEmotionResponseMessage);

        void M0(boolean z);

        void O0(ForumDetailSocketResponse forumDetailSocketResponse);

        void d(String str);

        void l1(ForumDetailHttpResponse forumDetailHttpResponse);

        void p1(boolean z);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumDetailModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ForumDetailModel forumDetailModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailModel, Integer.valueOf(i)};
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
            this.a = forumDetailModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof lr8)) {
                boolean z = true;
                if (((lr8) customResponsedMessage.getData()).m() != 1) {
                    z = false;
                }
                this.a.a.I1(z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends qb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumDetailModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ForumDetailModel forumDetailModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = forumDetailModel;
        }

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage == null) {
                    if (this.a.b != null) {
                        this.a.b.d(null);
                    }
                } else if (responsedMessage.hasError()) {
                    if (this.a.b != null) {
                        this.a.b.d(responsedMessage.getErrorString());
                    }
                } else {
                    if (responsedMessage instanceof ForumDetailHttpResponse) {
                        this.a.b.l1((ForumDetailHttpResponse) responsedMessage);
                    }
                    if (responsedMessage instanceof ForumDetailSocketResponse) {
                        this.a.b.O0((ForumDetailSocketResponse) responsedMessage);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends sb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumDetailModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ForumDetailModel forumDetailModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailModel, Integer.valueOf(i)};
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
            this.a = forumDetailModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) != null) || !(socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage)) {
                return;
            }
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
            Message<?> orginalMessage = responseUpdateMaskInfoMessage.getOrginalMessage();
            if (!(orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                return;
            }
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
            if (requestUpdateMaskInfoMessage.getMaskType() != 12) {
                return;
            }
            if (responseUpdateMaskInfoMessage.getError() != 0) {
                if (StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString())) {
                    errorString = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0cb8);
                } else {
                    errorString = responseUpdateMaskInfoMessage.getErrorString();
                }
                this.a.a.showToast(errorString);
                if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                    this.a.b.M0(false);
                } else {
                    this.a.b.p1(false);
                }
            } else if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                this.a.b.M0(true);
            } else {
                this.a.b.p1(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumDetailModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ForumDetailModel forumDetailModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailModel, Integer.valueOf(i)};
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
            this.a = forumDetailModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001151) {
                this.a.a.showToast(R.string.delete_success);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumDetailModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ForumDetailModel forumDetailModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailModel, Integer.valueOf(i)};
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
            this.a = forumDetailModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002510 && ((z = httpResponsedMessage instanceof BarEmotionResponseMessage))) {
                if (httpResponsedMessage.hasError()) {
                    if (this.a.b != null) {
                        this.a.b.d(httpResponsedMessage.getErrorString());
                    }
                } else if (z && httpResponsedMessage.getCmd() == 1002510) {
                    this.a.b.K0((BarEmotionResponseMessage) httpResponsedMessage);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumDetailModel(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumDetailActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = forumDetailActivity;
        this.b = forumDetailActivity;
        L();
        M();
        I();
        N();
        J();
        K();
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && !TextUtils.isEmpty(str)) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.MSG_FORUM_EMOTION_CMD);
            httpMessage.addParam("forum_id", str);
            sendMessage(httpMessage);
        }
    }

    public void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            ForumDetailRequestMessage forumDetailRequestMessage = new ForumDetailRequestMessage();
            forumDetailRequestMessage.setForumId(xg.g(str, 0L));
            sendMessage(forumDetailRequestMessage);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            registerListener(new d(this, 2001151));
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            registerListener(new e(this, CmdConfigHttp.MSG_FORUM_EMOTION_CMD));
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            registerListener(new b(this, CmdConfigHttp.MSG_FORUM_DETAIL_CMD, 303021));
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            registerListener(new c(this, 104102));
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            registerListener(new a(this, 2001266));
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.MSG_FORUM_EMOTION_CMD);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_FORUM_EMOTION_CMD, TbConfig.SERVER_ADDRESS + "c/e/meme/checkForumPkg");
            tbHttpMessageTask.setResponsedClass(BarEmotionResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void subscribeBar(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048586, this, z, str) == null) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
            if (z) {
                requestUpdateMaskInfoMessage.setIsMask(0);
            } else {
                requestUpdateMaskInfoMessage.setIsMask(1);
            }
            requestUpdateMaskInfoMessage.setMaskType(12);
            requestUpdateMaskInfoMessage.setList(str);
            sendMessage(requestUpdateMaskInfoMessage);
        }
    }
}
