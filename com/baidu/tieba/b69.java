package com.baidu.tieba;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.immessagecenter.mention.DelReplyAtMsg.DelReplyAtMsgResMsg;
import com.baidu.tieba.p05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdPageContext a;
    public n05 b;
    public p05 c;
    public List<l05> d;
    public l05 e;
    public a69 f;
    public c g;
    public p05.e h;

    /* loaded from: classes5.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes5.dex */
    public class a implements p05.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b69 a;

        public a(b69 b69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b69Var;
        }

        @Override // com.baidu.tieba.p05.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements p05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b69 a;

        public b(b69 b69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b69Var;
        }

        @Override // com.baidu.tieba.p05.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
                if (this.a.g != null) {
                    this.a.g.a();
                }
                this.a.d();
            }
        }
    }

    public b69(BdPageContext bdPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new b(this);
        this.a = bdPageContext;
        this.c = new p05(bdPageContext.getPageActivity());
        l05 l05Var = new l05(bdPageContext.getString(R.string.obfuscated_res_0x7f0f055b), this.c);
        this.e = l05Var;
        l05Var.n(this.h);
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        arrayList.add(this.e);
        this.c.p(new a(this));
        this.c.m(this.d);
        this.b = new n05(bdPageContext, this.c);
        e();
        g();
    }

    public void h(a69 a69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, a69Var) == null) {
            this.f = a69Var;
        }
    }

    public void i(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.g = cVar;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.f == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
        httpMessage.addParam("type", this.f.a);
        httpMessage.addParam("thread_id", this.f.b);
        httpMessage.addParam("post_id", this.f.c);
        httpMessage.addParam("ori_ugc_nid", this.f.d);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void d() {
        n05 n05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (n05Var = this.b) != null && n05Var.isShowing()) {
            this.b.dismiss();
        }
    }

    public void e() {
        p05 p05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (p05Var = this.c) != null) {
            p05Var.k();
        }
    }

    public void j() {
        n05 n05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (n05Var = this.b) != null) {
            n05Var.show();
        }
    }

    public void f() {
        BdPageContext bdPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (bdPageContext = this.a) != null && this.b != null) {
            Display defaultDisplay = bdPageContext.getPageActivity().getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            WindowManager.LayoutParams attributes = this.b.getWindow().getAttributes();
            attributes.width = displayMetrics.widthPixels;
            this.b.getWindow().setAttributes(attributes);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG, TbConfig.SERVER_ADDRESS + TbConfig.URL_DELETE_REPLY_AT_MSG);
            tbHttpMessageTask.setResponsedClass(DelReplyAtMsgResMsg.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }
}
