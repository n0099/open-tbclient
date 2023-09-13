package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.al7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bl7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wk7 a;
    public TbPageContext b;
    public ve5 c;
    public BdUniqueId d;
    public CustomMessageListener e;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bl7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(bl7 bl7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bl7Var, Integer.valueOf(i)};
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
            this.a = bl7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.UpdateAttentionData data;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || this.a.a == null || (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            if (!data.isSucc) {
                this.a.a.m(updateAttentionMessage.getData().errorString);
            } else {
                this.a.a.o(data.isAttention);
            }
        }
    }

    public bl7(TbPageContext tbPageContext, wk7 wk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, wk7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = BdUniqueId.gen();
        this.e = new a(this, 2001115);
        this.b = tbPageContext;
        this.a = wk7Var;
        this.c = new ve5(tbPageContext);
        this.e.setSelfListener(true);
        this.e.setTag(this.d);
        MessageManager.getInstance().registerListener(this.e);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ve5 ve5Var = this.c;
            if (ve5Var != null) {
                ve5Var.e();
            }
            MessageManager.getInstance().unRegisterListener(this.e);
        }
    }

    public void c(al7 al7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, al7Var) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.b.showToast(R.string.no_network);
            } else if (al7Var == null || al7Var.m == null || this.c == null || !ViewHelper.checkUpIsLogin(this.b.getPageActivity())) {
            } else {
                ve5 ve5Var = this.c;
                al7.b bVar = al7Var.m;
                ve5Var.h(!bVar.e, bVar.d, bVar.a, this.d);
            }
        }
    }

    public void d(al7 al7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, al7Var) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.b.showToast(R.string.no_network);
            } else if (al7Var == null || this.a == null || !ViewHelper.checkUpIsLogin(this.b.getPageActivity())) {
            } else {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
                httpMessage.addParam("thread_id", al7Var.b);
                httpMessage.addParam("op_type", Boolean.valueOf(al7Var.h));
                httpMessage.addParam("obj_type", 3);
                httpMessage.addParam("agree_type", 2);
                httpMessage.addParam("forum_id", al7Var.a);
                httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
                if (!StringUtil.isEmpty(al7Var.i)) {
                    httpMessage.addParam("obj_source", al7Var.i);
                }
                httpMessage.addHeader("needSig", "1");
                MessageManager.getInstance().sendMessage(httpMessage);
                this.a.n();
            }
        }
    }
}
