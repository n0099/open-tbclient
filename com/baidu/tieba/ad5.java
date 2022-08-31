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
import com.baidu.tieba.tc5;
import com.baidu.tieba.uc5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ad5<Q extends tc5, P extends uc5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<sb5> a;
    public final d9<?> b;
    public final vc5<Q, P> c;
    public final Q d;
    public final P e;
    public final xc5 f;
    public BdUniqueId g;
    public boolean h;
    public bb i;
    public TbHttpMessageTask j;
    public SocketMessageTask k;

    /* loaded from: classes3.dex */
    public class a extends bb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ad5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ad5 ad5Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad5Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = ad5Var;
        }

        @Override // com.baidu.tieba.bb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                jd5.b("TemplateModel-->onMessage");
                this.a.n(responsedMessage);
            }
        }
    }

    public ad5(d9<?> d9Var, vc5<Q, P> vc5Var, xc5 xc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d9Var, vc5Var, xc5Var};
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
        this.b = d9Var;
        this.g = d9Var.getUniqueId();
        this.c = vc5Var;
        this.d = vc5Var.b();
        this.e = this.c.d();
        this.f = xc5Var;
        o(d(), h(), e());
        q(h());
        p(d(), h());
    }

    public void b(sb5 sb5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, sb5Var) == null) || sb5Var == null || this.a.contains(sb5Var)) {
            return;
        }
        this.a.add(sb5Var);
    }

    public final boolean c(ResponsedMessage<?> responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responsedMessage)) == null) ? (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.g) ? false : true : invokeL.booleanValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c.e() : invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c.c() : (String) invokeV.objValue;
    }

    public Q f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d : (Q) invokeV.objValue;
    }

    public P g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e : (P) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.c.a() : invokeV.intValue;
    }

    public boolean i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            jd5.b(" ----requestMessage---- ");
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

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            jd5.b(" ----loadMoreNetRequest---- ");
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

    public void l(Q q, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, q, z) == null) {
            for (sb5 sb5Var : this.a) {
                sb5Var.b(q, z);
            }
        }
    }

    public void m(Q q, P p) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, q, p) == null) {
            for (sb5 sb5Var : this.a) {
                sb5Var.a(q, p);
            }
        }
    }

    public final void n(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, responsedMessage) == null) {
            this.h = false;
            if (c(responsedMessage) && responsedMessage != null && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof TemplateNetMessage)) {
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                if (responsedMessage.getError() == 0 && !responsedMessage.hasError()) {
                    if (responsedMessage instanceof TemplateSocketResponsedMessage) {
                        TemplateSocketResponsedMessage templateSocketResponsedMessage = (TemplateSocketResponsedMessage) responsedMessage;
                        m(f(), g());
                        xc5 xc5Var = this.f;
                        if (xc5Var != null) {
                            xc5Var.onSuccess(templateSocketResponsedMessage.getIResp());
                            return;
                        }
                        return;
                    } else if (responsedMessage instanceof TemplateHttpResponseMessage) {
                        TemplateHttpResponseMessage templateHttpResponseMessage = (TemplateHttpResponseMessage) responsedMessage;
                        m(f(), g());
                        xc5 xc5Var2 = this.f;
                        if (xc5Var2 != null) {
                            xc5Var2.onSuccess(templateHttpResponseMessage.getIResp());
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0488);
                }
                xc5 xc5Var3 = this.f;
                if (xc5Var3 != null) {
                    xc5Var3.onError(error, errorString);
                }
            }
        }
    }

    public final void o(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i, i2, str) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i, pk8.a(str, i2));
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

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            TemplateNetMessage templateNetMessage = new TemplateNetMessage(this.c, this.d, this.e);
            templateNetMessage.setTag(this.g);
            MessageManager.getInstance().sendMessage(templateNetMessage, this.k, this.j);
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
