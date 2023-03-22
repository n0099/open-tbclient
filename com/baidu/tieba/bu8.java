package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.personExtra.SmartAppBrowseHistoryHttpResponsedMessage;
import com.baidu.tieba.personExtra.SmartAppBrowseHistoryRequestMessage;
import com.baidu.tieba.personExtra.SmartAppBrowseHistorySocketResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class bu8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public b b;
    public za c;

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z, vt8 vt8Var);
    }

    /* loaded from: classes3.dex */
    public class a extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bu8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(bu8 bu8Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu8Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = bu8Var;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.a = false;
                if (responsedMessage != null && responsedMessage.getError() == 0) {
                    if (!(responsedMessage instanceof SmartAppBrowseHistorySocketResponsedMessage)) {
                        if (!(responsedMessage instanceof SmartAppBrowseHistoryHttpResponsedMessage)) {
                            return;
                        }
                        this.a.d(true, ((SmartAppBrowseHistoryHttpResponsedMessage) responsedMessage).getData());
                        return;
                    }
                    this.a.d(true, ((SmartAppBrowseHistorySocketResponsedMessage) responsedMessage).getData());
                    return;
                }
                this.a.d(false, null);
            }
        }
    }

    public bu8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.c = new a(this, CmdConfigHttp.CMD_HISTORY_SWAN, 309638);
        f();
        e();
    }

    public final void d(boolean z, vt8 vt8Var) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, vt8Var) == null) && (bVar = this.b) != null) {
            bVar.a(z, vt8Var);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.c);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().registerListener(this.c);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            jb9.f(309638, SmartAppBrowseHistorySocketResponsedMessage.class, false);
            jb9.c(309638, CmdConfigHttp.CMD_HISTORY_SWAN, TbConfig.URL_HISTORY_SWAN, SmartAppBrowseHistoryHttpResponsedMessage.class, false, false, true, false);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.a) {
            return;
        }
        this.a = true;
        MessageManager.getInstance().sendMessage(new SmartAppBrowseHistoryRequestMessage());
    }

    public void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.b = bVar;
        }
    }
}
