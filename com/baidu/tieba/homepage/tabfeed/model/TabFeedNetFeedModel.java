package com.baidu.tieba.homepage.tabfeed.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.tabfeed.message.TabFeedListHttpResponsedMessage;
import com.baidu.tieba.homepage.tabfeed.message.TabFeedListRequestMessage;
import com.baidu.tieba.homepage.tabfeed.message.TabFeedListSocketResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d9;
import com.repackage.t07;
import com.repackage.w07;
import com.repackage.wh8;
import com.repackage.wz6;
import com.repackage.xz6;
import com.repackage.za;
import java.util.List;
/* loaded from: classes3.dex */
public class TabFeedNetFeedModel extends BdBaseModel implements xz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public int c;
    public String d;
    public String e;
    public wz6 f;
    public w07 g;
    public za h;

    /* loaded from: classes3.dex */
    public class a extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TabFeedNetFeedModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TabFeedNetFeedModel tabFeedNetFeedModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabFeedNetFeedModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = tabFeedNetFeedModel;
        }

        @Override // com.repackage.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.b = false;
                if (responsedMessage == null) {
                    return;
                }
                t07 t07Var = null;
                if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                    t07Var = ((TabFeedListHttpResponsedMessage) responsedMessage).tabFeedData;
                } else if (responsedMessage instanceof TabFeedListSocketResponsedMessage) {
                    t07Var = ((TabFeedListSocketResponsedMessage) responsedMessage).tabFeedData;
                }
                this.a.mErrorCode = responsedMessage.getError();
                this.a.mErrorString = responsedMessage.getErrorString();
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.a.mErrorCode);
                errorData.setError_msg(this.a.mErrorString);
                if (this.a.f == null) {
                    return;
                }
                if (this.a.mErrorCode != 0 || t07Var == null) {
                    this.a.f.f(errorData);
                } else {
                    this.a.J(t07Var);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabFeedNetFeedModel(TbPageContext tbPageContext, wz6 wz6Var) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, wz6Var};
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
        this.a = true;
        this.b = false;
        this.c = 1;
        this.h = new a(this, CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST, 309655);
        wh8.h(309655, TabFeedListSocketResponsedMessage.class, false, false);
        wh8.c(309655, CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST, TbConfig.URL_TAB_ACTIVITY_TAB, TabFeedListHttpResponsedMessage.class, false, false, true, false);
        this.g = new w07();
        this.f = wz6Var;
    }

    public final void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
            tabFeedListRequestMessage.loadType = i;
            tabFeedListRequestMessage.tabCode = this.e;
            tabFeedListRequestMessage.tabName = this.d;
            if (i == 2) {
                tabFeedListRequestMessage.pn = this.c + 1;
            } else if (i != 1) {
                return;
            } else {
                tabFeedListRequestMessage.pn = 1;
            }
            this.b = true;
            tabFeedListRequestMessage.setTag(getUniqueId());
            sendMessage(tabFeedListRequestMessage);
        }
    }

    public final void J(t07 t07Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t07Var) == null) {
            if (t07Var != null) {
                this.c = t07Var.b();
            }
            if (this.f != null) {
                this.f.m0(this.g.a(this.a, t07Var));
            }
        }
    }

    @Override // com.repackage.xz6
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.b) {
            return;
        }
        this.a = false;
        I(2);
    }

    @Override // com.repackage.xz6
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            w07 w07Var = this.g;
            if (w07Var == null) {
                return false;
            }
            return w07Var.c();
        }
        return invokeV.booleanValue;
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
    public void cancelMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.cancelMessage();
            this.b = false;
        }
    }

    @Override // com.repackage.xz6
    public void d(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            setUniqueId(bdUniqueId);
            MessageManager.getInstance().unRegisterListener(this.h);
            this.h.getHttpMessageListener().setSelfListener(true);
            this.h.getSocketMessageListener().setSelfListener(true);
            registerListener(this.h);
        }
    }

    @Override // com.repackage.xz6
    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.h);
            this.b = false;
            this.a = true;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.xz6
    public List<ThreadData> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            w07 w07Var = this.g;
            if (w07Var == null) {
                return null;
            }
            return w07Var.b();
        }
        return (List) invokeV.objValue;
    }

    @Override // com.repackage.xz6
    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.b) {
            return;
        }
        this.a = true;
        I(1);
    }

    @Override // com.repackage.xz6
    public void s(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048587, this, str, str2, i) == null) {
            this.e = str;
            this.d = str2;
        }
    }
}
