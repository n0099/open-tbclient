package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.template.message.TemplateHttpResponseMessage;
import com.baidu.tbadk.template.message.TemplateNetMessage;
import com.baidu.tbadk.template.message.TemplateSocketResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class cg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List a;
    public final r9 b;
    public final xf5 c;
    public final vf5 d;
    public final wf5 e;
    public final zf5 f;
    public BdUniqueId g;
    public boolean h;
    public qb i;
    public TbHttpMessageTask j;
    public SocketMessageTask k;

    /* loaded from: classes3.dex */
    public class a extends qb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cg5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(cg5 cg5Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cg5Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = cg5Var;
        }

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                lg5.b("TemplateModel-->onMessage");
                this.a.n(responsedMessage);
            }
        }
    }

    public cg5(r9 r9Var, xf5 xf5Var, zf5 zf5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r9Var, xf5Var, zf5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.h = false;
        this.b = r9Var;
        this.g = r9Var.getUniqueId();
        this.c = xf5Var;
        this.d = xf5Var.b();
        this.e = this.c.d();
        this.f = zf5Var;
        o(d(), h(), e());
        q(h());
        p(d(), h());
    }

    public void l(vf5 vf5Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, vf5Var, z) == null) {
            for (ue5 ue5Var : this.a) {
                ue5Var.b(vf5Var, z);
            }
        }
    }

    public void m(vf5 vf5Var, wf5 wf5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, vf5Var, wf5Var) == null) {
            for (ue5 ue5Var : this.a) {
                ue5Var.a(vf5Var, wf5Var);
            }
        }
    }

    public void b(ue5 ue5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ue5Var) == null) && ue5Var != null && !this.a.contains(ue5Var)) {
            this.a.add(ue5Var);
        }
    }

    public final boolean c(ResponsedMessage responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responsedMessage)) == null) {
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.g) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            lg5.b(" ----requestMessage---- ");
            if (this.h) {
                return false;
            }
            this.h = true;
            l(f(), true);
            r();
            return true;
        }
        return invokeZ.booleanValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c.e();
        }
        return invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c.c();
        }
        return (String) invokeV.objValue;
    }

    public vf5 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (vf5) invokeV.objValue;
    }

    public wf5 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (wf5) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c.a();
        }
        return invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            lg5.b(" ----loadMoreNetRequest---- ");
            if (this.h) {
                return false;
            }
            this.h = true;
            l(f(), false);
            r();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.i);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            TemplateNetMessage templateNetMessage = new TemplateNetMessage(this.c, this.d, this.e);
            templateNetMessage.setTag(this.g);
            MessageManager.getInstance().sendMessage(templateNetMessage, this.k, this.j);
        }
    }

    public final void n(ResponsedMessage responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, responsedMessage) == null) {
            this.h = false;
            if (!c(responsedMessage) || responsedMessage == null || responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof TemplateNetMessage)) {
                return;
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            if (responsedMessage.getError() == 0 && !responsedMessage.hasError()) {
                if (responsedMessage instanceof TemplateSocketResponsedMessage) {
                    TemplateSocketResponsedMessage templateSocketResponsedMessage = (TemplateSocketResponsedMessage) responsedMessage;
                    m(f(), g());
                    zf5 zf5Var = this.f;
                    if (zf5Var != null) {
                        zf5Var.onSuccess(templateSocketResponsedMessage.getIResp());
                        return;
                    }
                    return;
                } else if (responsedMessage instanceof TemplateHttpResponseMessage) {
                    TemplateHttpResponseMessage templateHttpResponseMessage = (TemplateHttpResponseMessage) responsedMessage;
                    m(f(), g());
                    zf5 zf5Var2 = this.f;
                    if (zf5Var2 != null) {
                        zf5Var2.onSuccess(templateHttpResponseMessage.getIResp());
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            if (TextUtils.isEmpty(errorString)) {
                errorString = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0494);
            }
            zf5 zf5Var3 = this.f;
            if (zf5Var3 != null) {
                zf5Var3.onError(error, errorString);
            }
        }
    }

    public final void o(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i, i2, str) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i, zm8.a(str, i2));
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(TemplateHttpResponseMessage.class);
            MessageManager.getInstance().unRegisterTask(i);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.j = tbHttpMessageTask;
        }
    }

    public final void p(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i, i2) == null) {
            if (this.i == null) {
                this.i = new a(this, i, i2);
            }
            this.i.setTag(this.g);
            this.i.getSocketMessageListener().isSelfListener();
            this.i.getHttpMessageListener().isSelfListener();
            MessageManager.getInstance().registerListener(this.i);
        }
    }

    public final void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            SocketMessageTask socketMessageTask = new SocketMessageTask(i);
            socketMessageTask.g(true);
            socketMessageTask.h(false);
            socketMessageTask.setNeedEncrypt(false);
            socketMessageTask.setResponsedClass(TemplateSocketResponsedMessage.class);
            MessageManager.getInstance().unRegisterTask(i);
            MessageManager.getInstance().registerTask(socketMessageTask);
            this.k = socketMessageTask;
        }
    }

    public void s(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            this.g = bdUniqueId;
            o(d(), h(), e());
            q(h());
            p(d(), h());
        }
    }
}
