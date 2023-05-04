package com.baidu.tieba;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.RemoveFansController;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.newFriends.RequestDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.u05;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d89 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z39 a;
    public z79 b;
    public uw9 c;
    public TbPageContext d;
    public BlackListModel e;
    public boolean f;
    public String g;
    public long h;
    public String i;
    public h89 j;
    public BdUniqueId k;
    public boolean l;
    public RemoveFansController m;
    public y39 n;
    public final bb o;
    public final bb p;
    public final CustomMessageListener q;
    public final CustomMessageListener r;
    public final bb s;

    /* loaded from: classes4.dex */
    public class a extends bb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d89 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d89 d89Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d89Var, Integer.valueOf(i)};
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
            this.a = d89Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: a */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) && (socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                if (StringUtils.isNull(socketResponsedMessage.getErrorString())) {
                    errorString = this.a.d.getResources().getString(R.string.obfuscated_res_0x7f0f0d30);
                } else {
                    errorString = socketResponsedMessage.getErrorString();
                }
                this.a.d.showToast(errorString);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d89 a;

        public b(d89 d89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d89Var;
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i, String str, long j, boolean z) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
                if (z && i != 2260104) {
                    if (StringUtils.isNull(str)) {
                        TbPageContext tbPageContext = this.a.d;
                        if (i == 0) {
                            i2 = R.string.remove_fans_success;
                        } else {
                            i2 = R.string.remove_fans_fail;
                        }
                        ii.Q(this.a.d.getPageActivity(), tbPageContext.getString(i2));
                    } else {
                        ii.Q(this.a.d.getPageActivity(), str);
                    }
                }
                d89 d89Var = this.a;
                if (j == d89Var.h && i == 0) {
                    d89Var.l = false;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements u05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d89 a;

        public c(d89 d89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d89Var;
        }

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                this.a.m.removeFans(this.a.h);
                u05Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements u05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(d89 d89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                u05Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements u05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d89 a;

        public e(d89 d89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d89Var;
        }

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                d89 d89Var = this.a;
                if (d89Var.h > 0) {
                    if (d89Var.e.getMaskType() == 1) {
                        this.a.e.removeFromBlackList(this.a.h);
                    } else {
                        this.a.e.addToBlackList(this.a.h);
                    }
                }
                u05Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements u05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(d89 d89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                u05Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends bb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d89 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(d89 d89Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d89Var, Integer.valueOf(i)};
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
            this.a = d89Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: a */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            String errorString;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() != 10) {
                    return;
                }
                if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                    this.a.e.setMaskType(1);
                } else {
                    this.a.e.setMaskType(0);
                }
                if (responseUpdateMaskInfoMessage.getError() != 0) {
                    if (StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString())) {
                        errorString = this.a.d.getResources().getString(R.string.obfuscated_res_0x7f0f0d30);
                    } else {
                        errorString = responseUpdateMaskInfoMessage.getErrorString();
                    }
                    this.a.d.showToast(errorString);
                } else if (this.a.e.getMaskType() == 1) {
                    TbPageContext tbPageContext = this.a.d;
                    tbPageContext.showToast(tbPageContext.getString(R.string.obfuscated_res_0x7f0f03cf));
                } else {
                    TbPageContext tbPageContext2 = this.a.d;
                    tbPageContext2.showToast(tbPageContext2.getString(R.string.remove_succ));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends bb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d89 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(d89 d89Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d89Var, Integer.valueOf(i)};
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
            this.a = d89Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: a */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, socketResponsedMessage) != null) || !(socketResponsedMessage instanceof ResponseDeleteFriendMessage)) {
                return;
            }
            ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
            int error = responseDeleteFriendMessage.getError();
            String errorString2 = responseDeleteFriendMessage.getErrorString();
            if (error == 0) {
                this.a.f(false);
            } else {
                if (StringUtils.isNull(responseDeleteFriendMessage.getErrorString())) {
                    errorString = this.a.d.getResources().getString(R.string.obfuscated_res_0x7f0f0d30);
                } else {
                    errorString = responseDeleteFriendMessage.getErrorString();
                }
                errorString2 = errorString;
            }
            this.a.d.showToast(errorString2);
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d89 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(d89 d89Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d89Var, Integer.valueOf(i)};
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
            this.a = d89Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                this.a.f(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d89 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(d89 d89Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d89Var, Integer.valueOf(i)};
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
            this.a = d89Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                return;
            }
            ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
            if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                this.a.f(false);
            } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                this.a.f(true);
            }
        }
    }

    public d89(TbPageContext tbPageContext, z79 z79Var, BlackListModel blackListModel, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, z79Var, blackListModel, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new g(this, 104102);
        this.p = new h(this, 304102);
        this.q = new i(this, 2001174);
        this.r = new j(this, 2001174);
        this.s = new a(this, 304103);
        this.d = tbPageContext;
        this.b = z79Var;
        this.e = blackListModel;
        this.k = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, uw9.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            uw9 uw9Var = (uw9) runTask.getData();
            this.c = uw9Var;
            uw9Var.b(bdUniqueId);
        }
        g();
        RemoveFansController removeFansController = new RemoveFansController(tbPageContext, this.k);
        this.m = removeFansController;
        removeFansController.setResultCallBack(new b(this));
    }

    public final void f(boolean z) {
        BlackListModel blackListModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f = z;
            h89 h89Var = this.j;
            if (h89Var != null) {
                h89Var.x(z);
            }
            z39 z39Var = this.a;
            if (z39Var != null && (blackListModel = this.e) != null) {
                boolean z2 = this.f;
                boolean z3 = true;
                if (blackListModel.getMaskType() != 1) {
                    z3 = false;
                }
                z39Var.E(z2, z3, this.l);
            }
        }
    }

    public void e() {
        BlackListModel blackListModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b != null && (blackListModel = this.e) != null) {
            boolean z = true;
            if (blackListModel.getMaskType() != 1) {
                z = false;
            }
            j(this.f, z, this.b.e(), this.l);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.o.setTag(this.k);
            this.p.setTag(this.k);
            this.s.setTag(this.k);
            this.r.setTag(this.k);
            this.q.setTag(this.k);
            this.d.registerListener(this.o);
            this.d.registerListener(this.p);
            this.d.registerListener(this.s);
            this.d.registerListener(this.r);
            this.d.registerListener(this.q);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || this.h == 0) {
            return;
        }
        u05 u05Var = new u05(this.d.getPageActivity());
        u05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0465, new c(this));
        u05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038b, new d(this));
        u05Var.setMessage(String.format(this.d.getString(R.string.obfuscated_res_0x7f0f10c3), this.g));
        u05Var.create(this.d);
        u05Var.show();
    }

    public void h(h89 h89Var) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, h89Var) == null) && this.e != null && h89Var != null && h89Var.j() != null) {
            this.j = h89Var;
            UserData j2 = h89Var.j();
            this.f = h89Var.l();
            BlackListModel blackListModel = this.e;
            boolean z = false;
            if (j2.isMask()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            blackListModel.setMaskType(i2);
            this.g = j2.getName_show();
            this.h = j2.getUserIdLong();
            this.i = j2.getPortrait();
            if (j2.getIsMyFans() == 1) {
                z = true;
            }
            this.l = z;
        }
    }

    public void i() {
        String format;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.g == null) {
            return;
        }
        u05 u05Var = new u05(this.d.getPageActivity());
        u05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0465, new e(this));
        u05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038b, new f(this));
        if (this.e.getMaskType() == 1) {
            format = String.format(this.d.getString(R.string.obfuscated_res_0x7f0f0325), this.g);
        } else {
            format = String.format(this.d.getString(R.string.obfuscated_res_0x7f0f0327), this.g);
        }
        u05Var.setMessage(format);
        u05Var.create(this.d);
        u05Var.show();
    }

    public final void j(boolean z, boolean z2, int i2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3)}) == null) {
            z39 z39Var = new z39(this.d, this);
            this.a = z39Var;
            z39Var.E(z, z2, z3);
            if (i2 != -1) {
                this.a.D(i2);
            }
            h89 h89Var = this.j;
            if (h89Var != null && h89Var.j() != null) {
                this.a.F(this.j.j().getUserName());
            }
            this.a.a();
            y39 y39Var = new y39(this.d.getPageActivity(), this.a.B());
            this.n = y39Var;
            y39Var.show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, view2) != null) || view2 == null) {
            return;
        }
        lg.a(this.n, this.d.getPageActivity());
        if (this.a.u() != null && view2.getId() == this.a.u().getId()) {
            i();
        } else if (this.a.x() != null && view2.getId() == this.a.x().getId()) {
            if (this.f) {
                RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                requestDeleteFriendMessage.setFriendId(this.h);
                MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.d.getPageActivity(), String.valueOf(this.h), this.g, this.i, null, false, null)));
        } else if (this.a.y() != null && view2.getId() == this.a.y().getId()) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.d.showToast(R.string.obfuscated_res_0x7f0f0d30);
                return;
            }
            z79 z79Var = this.b;
            if (z79Var == null) {
                return;
            }
            if (z79Var.e() == 0) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.h), this.g, null, null, 0, this.b.d(), this.b.f());
                userMuteAddAndDelCustomMessage.mId = this.b.f();
                z79 z79Var2 = this.b;
                z79Var2.j(false, userMuteAddAndDelCustomMessage, z79Var2.d(), this.g);
            } else if (this.b.e() == 1) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.h), this.g, null, null, 0, this.b.d(), this.b.f());
                userMuteAddAndDelCustomMessage2.mId = this.b.f();
                this.b.j(true, userMuteAddAndDelCustomMessage2, null, this.g);
            }
        } else if (this.a.A() != null && view2.getId() == this.a.A().getId()) {
            if (this.c != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_PERSON_TALK_REPORT_CLICK).param("obj_locate", 1));
                this.c.c(String.valueOf(this.h));
            }
        } else if (this.a.z() != null && view2.getId() == this.a.z().getId()) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                ii.P(this.d.getPageActivity(), R.string.obfuscated_res_0x7f0f0d30);
            } else {
                k();
            }
        }
    }
}
