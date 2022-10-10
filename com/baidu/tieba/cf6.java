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
public class cf6 implements ji6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public String b;
    public String c;
    public km8 d;
    public List<MemberGroupInfo> e;
    public MemberGodInfo f;
    public ManagerApplyInfo g;
    public boolean h;
    public boolean i;
    public PriManagerApplyInfo j;
    public ni6 k;
    public boolean l;
    public yi6 m;
    public pb n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public CustomMessageListener q;

    /* loaded from: classes3.dex */
    public class a extends pb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(cf6 cf6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf6Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = cf6Var;
        }

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof ForumMemberHttpResponseMessage;
            if (z || (responsedMessage instanceof ForumMemberSocketResponseMessage)) {
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
                    ni6 ni6Var = this.a.k;
                    yi6 yi6Var = this.a.m;
                    cf6 cf6Var = this.a;
                    ni6Var.a(3, 0, yi6Var, cf6Var.A(cf6Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, this.a.d));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(cf6 cf6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf6Var, Integer.valueOf(i)};
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
            this.a = cf6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ForumMemberReadCacheResponseMessage)) {
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
                    cf6 cf6Var = this.a;
                    ArrayList<Cdo> A = cf6Var.A(cf6Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j);
                    if (A == null || A.size() <= 0) {
                        if (!this.a.l) {
                            this.a.k.a(3, 0, this.a.m, A);
                        }
                    } else {
                        this.a.k.a(3, 0, this.a.m, A);
                    }
                }
                if (this.a.l) {
                    cf6 cf6Var2 = this.a;
                    cf6Var2.z(dh.g(cf6Var2.b, 0L), this.a.c);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(cf6 cf6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf6Var, Integer.valueOf(i)};
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
            this.a = cf6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof km8)) {
                this.a.m.e = customResponsedMessage.getError();
                this.a.m.f = customResponsedMessage.getErrorString();
                this.a.m.g = false;
                this.a.m.i = false;
                this.a.m.h = false;
                this.a.m.b = this.a.b;
                this.a.m.a = this.a.c;
                this.a.m.c = 1;
                km8 km8Var = (km8) customResponsedMessage.getData();
                if (km8Var != null && km8Var.m() == 0 && this.a.d != null) {
                    km8Var.t(this.a.d.c());
                    km8Var.w(this.a.d.i());
                }
                this.a.d = km8Var;
                if (this.a.k != null) {
                    ni6 ni6Var = this.a.k;
                    yi6 yi6Var = this.a.m;
                    cf6 cf6Var = this.a;
                    ni6Var.a(3, 0, yi6Var, cf6Var.A(cf6Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(cf6 cf6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf6Var, Integer.valueOf(i)};
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
            this.a = cf6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                cf6 cf6Var = this.a;
                cf6Var.z(dh.g(cf6Var.b, 0L), this.a.c);
            }
        }
    }

    public cf6() {
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
        this.m = new yi6();
        this.n = new a(this, CmdConfigHttp.FRS_MEMBER_TAB_CMD, 301004);
        this.o = new b(this, 2003009);
        this.p = new c(this, 2001266);
        this.q = new d(this, 2001222);
    }

    public ArrayList<Cdo> A(km8 km8Var, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo, boolean z, boolean z2, PriManagerApplyInfo priManagerApplyInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{km8Var, list, memberGodInfo, managerApplyInfo, Boolean.valueOf(z), Boolean.valueOf(z2), priManagerApplyInfo})) == null) {
            if (km8Var == null) {
                return null;
            }
            ArrayList<Cdo> arrayList = new ArrayList<>();
            if (km8Var.m() == 1) {
                gf6 gf6Var = new gf6();
                gf6Var.h(km8Var);
                gf6Var.f(this.b);
                gf6Var.g(this.c);
                arrayList.add(gf6Var);
            }
            if (list != null && list.size() > 0) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (list.get(i) != null && list.get(i).member_group_num != null && list.get(i).member_group_num.intValue() > 0 && ListUtils.getCount(list.get(i).member_group_list) > 0) {
                        if6 if6Var = new if6();
                        if6Var.c(this.b);
                        if6Var.f(this.c);
                        if6Var.g(list.get(i));
                        if (i == size - 1) {
                            if6Var.h(true);
                        } else {
                            if6Var.h(false);
                        }
                        arrayList.add(if6Var);
                    }
                }
            }
            if (this.h) {
                if (this.i && priManagerApplyInfo != null) {
                    mf6 mf6Var = new mf6();
                    mf6Var.j(priManagerApplyInfo.assist_left_num.intValue());
                    mf6Var.h(priManagerApplyInfo.assist_apply_url);
                    mf6Var.g(priManagerApplyInfo.assist_apply_status.intValue());
                    arrayList.add(mf6Var);
                }
            } else {
                kf6 kf6Var = new kf6();
                if (managerApplyInfo != null) {
                    kf6Var.k(managerApplyInfo.manager_left_num.intValue());
                    kf6Var.j(managerApplyInfo.manager_apply_url);
                    kf6Var.g(managerApplyInfo.assist_left_num.intValue());
                    kf6Var.f(managerApplyInfo.assist_apply_url);
                    kf6Var.h(managerApplyInfo.manager_apply_status.intValue());
                }
                arrayList.add(kf6Var);
                af6 af6Var = new af6();
                af6Var.a = R.string.obfuscated_res_0x7f0f0426;
                af6Var.b = "https://tieba.baidu.com/tb/cms/redpacket/page/complain.html?id=" + this.b;
                arrayList.add(af6Var);
            }
            B(memberGodInfo, arrayList);
            Cdo x = x();
            if (x != null) {
                arrayList.add(x);
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public final void B(MemberGodInfo memberGodInfo, ArrayList<Cdo> arrayList) {
        List<User> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, memberGodInfo, arrayList) == null) || memberGodInfo == null || (list = memberGodInfo.forum_god_list) == null || list.size() <= 0 || arrayList == null) {
            return;
        }
        List<User> list2 = memberGodInfo.forum_god_list;
        if (memberGodInfo.forum_god_num.intValue() == 0 || list2.size() == 0) {
            return;
        }
        we6 we6Var = new we6();
        we6Var.c(memberGodInfo);
        arrayList.add(we6Var);
        boolean z = false;
        for (int i = 0; i < list2.size(); i++) {
            User user = list2.get(i);
            if (user != null && user.god_data.type.intValue() == 2) {
                ye6 ye6Var = new ye6();
                ye6Var.r(user, i);
                arrayList.add(ye6Var);
                if (!z) {
                    z = true;
                }
            }
        }
        if (z) {
            return;
        }
        arrayList.remove(we6Var);
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            yi6 yi6Var = this.m;
            yi6Var.e = 0;
            yi6Var.g = false;
            yi6Var.i = false;
            yi6Var.h = false;
            yi6Var.b = this.b;
            yi6Var.a = this.c;
            yi6Var.c = 1;
            ni6 ni6Var = this.k;
            if (ni6Var != null) {
                ni6Var.a(3, 0, yi6Var, A(this.d, this.e, this.f, this.g, this.i, this.h, this.j));
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            sm8.h(301004, ForumMemberSocketResponseMessage.class, false, false);
            sm8.c(301004, CmdConfigHttp.FRS_MEMBER_TAB_CMD, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
            sm8.b(2003009, df6.class);
        }
    }

    public void E(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.a = bdUniqueId;
    }

    @Override // com.baidu.tieba.ji6
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            D();
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

    @Override // com.baidu.tieba.ji6
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.n);
            MessageManager.getInstance().unRegisterListener(this.o);
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().unRegisterListener(this.q);
        }
    }

    @Override // com.baidu.tieba.ji6
    public void t(int i, int i2, ti6 ti6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, ti6Var) == null) && i == 3 && ti6Var != null) {
            String str = ti6Var.b;
            this.b = str;
            String str2 = ti6Var.a;
            this.c = str2;
            if (this.l) {
                y(str2);
            } else if (ti6Var.c == -1) {
                z(dh.g(str, 0L), ti6Var.a);
            } else {
                C();
            }
        }
    }

    @Override // com.baidu.tieba.ji6
    public void w(ni6 ni6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ni6Var) == null) {
            this.k = ni6Var;
        }
    }

    public final gh6 x() {
        InterceptResult invokeV;
        int f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            List<MemberGroupInfo> list = this.e;
            if (list == null || list.size() <= 0) {
                return null;
            }
            gh6 gh6Var = new gh6();
            int i = ej.i(TbadkCoreApplication.getInst().getContext());
            int f2 = ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07019a);
            int f3 = ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070308);
            int f4 = ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07029e);
            int size = this.e.size();
            if (TbadkCoreApplication.isLogin()) {
                f = ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070299);
            } else {
                f = ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07026c);
            }
            gh6Var.f(i - (((f2 + f3) + f) + (f4 * size)));
            gh6Var.c(R.drawable.obfuscated_res_0x7f081241);
            return gh6Var;
        }
        return (gh6) invokeV.objValue;
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                forumMemberReadCacheRequestMessage.setTag(bdUniqueId);
            }
            forumMemberReadCacheRequestMessage.setForumName(str);
            MessageManager.getInstance().sendMessage(forumMemberReadCacheRequestMessage);
        }
    }

    public void z(long j, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048587, this, j, str) == null) || j <= 0 || StringUtils.isNull(str)) {
            return;
        }
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
