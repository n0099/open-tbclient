package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.forumMember.member.ForumMemberHttpResponseMessage;
import com.baidu.tieba.forumMember.member.ForumMemberReadCacheRequestMessage;
import com.baidu.tieba.forumMember.member.ForumMemberReadCacheResponseMessage;
import com.baidu.tieba.forumMember.member.ForumMemberRequestMessage;
import com.baidu.tieba.forumMember.member.ForumMemberSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMemberInfo.ManagerApplyInfo;
import tbclient.GetMemberInfo.MemberGodInfo;
import tbclient.MemberGroupInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.User;
/* loaded from: classes3.dex */
public class bi6 implements il6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public String b;
    public String c;
    public lr8 d;
    public List<MemberGroupInfo> e;
    public MemberGodInfo f;
    public ManagerApplyInfo g;
    public boolean h;
    public boolean i;
    public PriManagerApplyInfo j;
    public ml6 k;
    public boolean l;
    public xl6 m;
    public qb n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public CustomMessageListener q;

    /* loaded from: classes3.dex */
    public class a extends qb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bi6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(bi6 bi6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bi6Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = bi6Var;
        }

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof ForumMemberHttpResponseMessage;
            if (!z && !(responsedMessage instanceof ForumMemberSocketResponseMessage)) {
                return;
            }
            if (responsedMessage.getError() == 0) {
                if (z) {
                    ForumMemberHttpResponseMessage forumMemberHttpResponseMessage = (ForumMemberHttpResponseMessage) responsedMessage;
                    this.a.d = forumMemberHttpResponseMessage.getUserInfo();
                    this.a.e = forumMemberHttpResponseMessage.getMemberGroupInfoList();
                    this.a.f = forumMemberHttpResponseMessage.getMemberGodInfo();
                    this.a.g = forumMemberHttpResponseMessage.getManagerApplyInfo();
                    this.a.i = forumMemberHttpResponseMessage.isBawuShow();
                    this.a.h = forumMemberHttpResponseMessage.isPrivateForum();
                    this.a.j = forumMemberHttpResponseMessage.getPrivateMgrApplyInfo();
                } else if (responsedMessage instanceof ForumMemberSocketResponseMessage) {
                    ForumMemberSocketResponseMessage forumMemberSocketResponseMessage = (ForumMemberSocketResponseMessage) responsedMessage;
                    this.a.d = forumMemberSocketResponseMessage.getUserInfo();
                    this.a.e = forumMemberSocketResponseMessage.getMemberGroupInfoList();
                    this.a.f = forumMemberSocketResponseMessage.getMemberGodInfo();
                    this.a.g = forumMemberSocketResponseMessage.getManagerApplyInfo();
                    this.a.i = forumMemberSocketResponseMessage.isBawuShow();
                    this.a.h = forumMemberSocketResponseMessage.isPrivateForum();
                    this.a.j = forumMemberSocketResponseMessage.getPrivateMgrApplyInfo();
                }
            }
            this.a.l = false;
            this.a.m.e = responsedMessage.getError();
            this.a.m.f = responsedMessage.getErrorString();
            this.a.m.g = false;
            this.a.m.i = false;
            this.a.m.h = false;
            this.a.m.b = this.a.b;
            this.a.m.a = this.a.c;
            this.a.m.c = 1;
            if (this.a.k != null) {
                ml6 ml6Var = this.a.k;
                xl6 xl6Var = this.a.m;
                bi6 bi6Var = this.a;
                ml6Var.a(3, 0, xl6Var, bi6Var.y(bi6Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, this.a.d));
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bi6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(bi6 bi6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bi6Var, Integer.valueOf(i)};
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
            this.a = bi6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof ForumMemberReadCacheResponseMessage)) {
                return;
            }
            ForumMemberReadCacheResponseMessage forumMemberReadCacheResponseMessage = (ForumMemberReadCacheResponseMessage) customResponsedMessage;
            if (customResponsedMessage.getError() == 0) {
                this.a.d = forumMemberReadCacheResponseMessage.getUserInfo();
                this.a.e = forumMemberReadCacheResponseMessage.getMemberGroupInfoList();
                this.a.f = forumMemberReadCacheResponseMessage.getMemberGodInfo();
                this.a.g = forumMemberReadCacheResponseMessage.getManagerApplyInfo();
                this.a.i = forumMemberReadCacheResponseMessage.isBawuShow();
                this.a.h = forumMemberReadCacheResponseMessage.isPrivateForum();
                this.a.j = forumMemberReadCacheResponseMessage.getPrivateMgrApplyInfo();
            }
            this.a.m.e = customResponsedMessage.getError();
            this.a.m.f = customResponsedMessage.getErrorString();
            this.a.m.g = false;
            this.a.m.i = false;
            this.a.m.h = false;
            this.a.m.b = this.a.b;
            this.a.m.a = this.a.c;
            this.a.m.c = 1;
            if (this.a.k != null) {
                bi6 bi6Var = this.a;
                ArrayList<xn> y = bi6Var.y(bi6Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j);
                if (y != null && y.size() > 0) {
                    this.a.k.a(3, 0, this.a.m, y);
                } else if (!this.a.l) {
                    this.a.k.a(3, 0, this.a.m, y);
                }
            }
            if (this.a.l) {
                bi6 bi6Var2 = this.a;
                bi6Var2.x(xg.g(bi6Var2.b, 0L), this.a.c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bi6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(bi6 bi6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bi6Var, Integer.valueOf(i)};
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
            this.a = bi6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof lr8)) {
                this.a.m.e = customResponsedMessage.getError();
                this.a.m.f = customResponsedMessage.getErrorString();
                this.a.m.g = false;
                this.a.m.i = false;
                this.a.m.h = false;
                this.a.m.b = this.a.b;
                this.a.m.a = this.a.c;
                this.a.m.c = 1;
                lr8 lr8Var = (lr8) customResponsedMessage.getData();
                if (lr8Var != null && lr8Var.m() == 0 && this.a.d != null) {
                    lr8Var.t(this.a.d.c());
                    lr8Var.w(this.a.d.i());
                }
                this.a.d = lr8Var;
                if (this.a.k != null) {
                    ml6 ml6Var = this.a.k;
                    xl6 xl6Var = this.a.m;
                    bi6 bi6Var = this.a;
                    ml6Var.a(3, 0, xl6Var, bi6Var.y(bi6Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bi6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(bi6 bi6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bi6Var, Integer.valueOf(i)};
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
            this.a = bi6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                bi6 bi6Var = this.a;
                bi6Var.x(xg.g(bi6Var.b, 0L), this.a.c);
            }
        }
    }

    public bi6() {
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
        this.h = false;
        this.i = false;
        this.l = true;
        this.m = new xl6();
        this.n = new a(this, CmdConfigHttp.FRS_MEMBER_TAB_CMD, 301004);
        this.o = new b(this, 2003009);
        this.p = new c(this, 2001266);
        this.q = new d(this, 2001222);
    }

    @Override // com.baidu.tieba.il6
    public void D(ml6 ml6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ml6Var) == null) {
            this.k = ml6Var;
        }
    }

    public void E(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        this.a = bdUniqueId;
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                forumMemberReadCacheRequestMessage.setTag(bdUniqueId);
            }
            forumMemberReadCacheRequestMessage.setForumName(str);
            MessageManager.getInstance().sendMessage(forumMemberReadCacheRequestMessage);
        }
    }

    public final void A(MemberGodInfo memberGodInfo, ArrayList<xn> arrayList) {
        List<User> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, memberGodInfo, arrayList) == null) && memberGodInfo != null && (list = memberGodInfo.forum_god_list) != null && list.size() > 0 && arrayList != null) {
            List<User> list2 = memberGodInfo.forum_god_list;
            if (memberGodInfo.forum_god_num.intValue() != 0 && list2.size() != 0) {
                vh6 vh6Var = new vh6();
                vh6Var.c(memberGodInfo);
                arrayList.add(vh6Var);
                boolean z = false;
                for (int i = 0; i < list2.size(); i++) {
                    User user = list2.get(i);
                    if (user != null && user.god_data.type.intValue() == 2) {
                        xh6 xh6Var = new xh6();
                        xh6Var.q(user, i);
                        arrayList.add(xh6Var);
                        if (!z) {
                            z = true;
                        }
                    }
                }
                if (!z) {
                    arrayList.remove(vh6Var);
                }
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            xl6 xl6Var = this.m;
            xl6Var.e = 0;
            xl6Var.g = false;
            xl6Var.i = false;
            xl6Var.h = false;
            xl6Var.b = this.b;
            xl6Var.a = this.c;
            xl6Var.c = 1;
            ml6 ml6Var = this.k;
            if (ml6Var != null) {
                ml6Var.a(3, 0, xl6Var, y(this.d, this.e, this.f, this.g, this.i, this.h, this.j));
            }
        }
    }

    @Override // com.baidu.tieba.il6
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.n);
            MessageManager.getInstance().unRegisterListener(this.o);
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().unRegisterListener(this.q);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            tr8.h(301004, ForumMemberSocketResponseMessage.class, false, false);
            tr8.c(301004, CmdConfigHttp.FRS_MEMBER_TAB_CMD, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
            tr8.b(2003009, ci6.class);
        }
    }

    @Override // com.baidu.tieba.il6
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            C();
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.o.setTag(bdUniqueId);
                this.n.setTag(this.a);
                this.o.setSelfListener(true);
                if (this.n.getHttpMessageListener() != null) {
                    this.n.getHttpMessageListener().setSelfListener(true);
                }
                if (this.n.getSocketMessageListener() != null) {
                    this.n.getSocketMessageListener().setSelfListener(true);
                }
            }
            MessageManager.getInstance().registerListener(this.o);
            MessageManager.getInstance().registerListener(this.n);
            MessageManager.getInstance().registerListener(this.p);
            MessageManager.getInstance().registerListener(this.q);
        }
    }

    public final fk6 v() {
        InterceptResult invokeV;
        int g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<MemberGroupInfo> list = this.e;
            if (list != null && list.size() > 0) {
                fk6 fk6Var = new fk6();
                int j = yi.j(TbadkCoreApplication.getInst().getContext());
                int g2 = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07019a);
                int g3 = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070308);
                int g4 = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07029e);
                int size = this.e.size();
                if (TbadkCoreApplication.isLogin()) {
                    g = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070299);
                } else {
                    g = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07026c);
                }
                fk6Var.f(j - (((g2 + g3) + g) + (g4 * size)));
                fk6Var.c(R.drawable.transparent_bg);
                return fk6Var;
            }
            return null;
        }
        return (fk6) invokeV.objValue;
    }

    public void x(long j, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(1048585, this, j, str) == null) && j > 0 && !StringUtils.isNull(str)) {
            ForumMemberRequestMessage forumMemberRequestMessage = new ForumMemberRequestMessage();
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                forumMemberRequestMessage.setTag(bdUniqueId);
            }
            forumMemberRequestMessage.setForumId(j);
            forumMemberRequestMessage.setForumName(str);
            MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
        }
    }

    public ArrayList<xn> y(lr8 lr8Var, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo, boolean z, boolean z2, PriManagerApplyInfo priManagerApplyInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{lr8Var, list, memberGodInfo, managerApplyInfo, Boolean.valueOf(z), Boolean.valueOf(z2), priManagerApplyInfo})) == null) {
            if (lr8Var == null) {
                return null;
            }
            ArrayList<xn> arrayList = new ArrayList<>();
            if (lr8Var.m() == 1) {
                fi6 fi6Var = new fi6();
                fi6Var.h(lr8Var);
                fi6Var.f(this.b);
                fi6Var.g(this.c);
                arrayList.add(fi6Var);
            }
            if (list != null && list.size() > 0) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (list.get(i) != null && list.get(i).member_group_num != null && list.get(i).member_group_num.intValue() > 0 && ListUtils.getCount(list.get(i).member_group_list) > 0) {
                        hi6 hi6Var = new hi6();
                        hi6Var.c(this.b);
                        hi6Var.f(this.c);
                        hi6Var.g(list.get(i));
                        if (i == size - 1) {
                            hi6Var.h(true);
                        } else {
                            hi6Var.h(false);
                        }
                        arrayList.add(hi6Var);
                    }
                }
            }
            if (this.h) {
                if (this.i && priManagerApplyInfo != null) {
                    li6 li6Var = new li6();
                    li6Var.i(priManagerApplyInfo.assist_left_num.intValue());
                    li6Var.h(priManagerApplyInfo.assist_apply_url);
                    li6Var.g(priManagerApplyInfo.assist_apply_status.intValue());
                    arrayList.add(li6Var);
                }
            } else {
                ji6 ji6Var = new ji6();
                if (managerApplyInfo != null) {
                    ji6Var.k(managerApplyInfo.manager_left_num.intValue());
                    ji6Var.i(managerApplyInfo.manager_apply_url);
                    ji6Var.g(managerApplyInfo.assist_left_num.intValue());
                    ji6Var.f(managerApplyInfo.assist_apply_url);
                    ji6Var.h(managerApplyInfo.manager_apply_status.intValue());
                }
                arrayList.add(ji6Var);
                zh6 zh6Var = new zh6();
                zh6Var.a = R.string.obfuscated_res_0x7f0f0436;
                zh6Var.b = "https://tieba.baidu.com/tb/cms/redpacket/page/complain.html?id=" + this.b;
                arrayList.add(zh6Var);
            }
            A(memberGodInfo, arrayList);
            xn v = v();
            if (v != null) {
                arrayList.add(v);
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.il6
    public void z(int i, int i2, sl6 sl6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048587, this, i, i2, sl6Var) == null) && i == 3 && sl6Var != null) {
            String str = sl6Var.b;
            this.b = str;
            String str2 = sl6Var.a;
            this.c = str2;
            if (this.l) {
                w(str2);
            } else if (sl6Var.c == -1) {
                x(xg.g(str, 0L), sl6Var.a);
            } else {
                B();
            }
        }
    }
}
