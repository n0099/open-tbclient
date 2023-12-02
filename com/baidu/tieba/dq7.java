package com.baidu.tieba;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.tbadkCore.LikeReturnData;
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
/* loaded from: classes5.dex */
public class dq7 implements nt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public String b;
    public String c;
    public LikeReturnData d;
    public List<MemberGroupInfo> e;
    public MemberGodInfo f;
    public ManagerApplyInfo g;
    public boolean h;
    public boolean i;
    public PriManagerApplyInfo j;
    public rt7 k;
    public boolean l;
    public du7 m;
    public bq7 n;
    public NetMessageListener o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;

    /* loaded from: classes5.dex */
    public class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(dq7 dq7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq7Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = dq7Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
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
                    this.a.n = forumMemberHttpResponseMessage.getComplaintBarlordData();
                } else if (responsedMessage instanceof ForumMemberSocketResponseMessage) {
                    ForumMemberSocketResponseMessage forumMemberSocketResponseMessage = (ForumMemberSocketResponseMessage) responsedMessage;
                    this.a.d = forumMemberSocketResponseMessage.getUserInfo();
                    this.a.e = forumMemberSocketResponseMessage.getMemberGroupInfoList();
                    this.a.f = forumMemberSocketResponseMessage.getMemberGodInfo();
                    this.a.g = forumMemberSocketResponseMessage.getManagerApplyInfo();
                    this.a.i = forumMemberSocketResponseMessage.isBawuShow();
                    this.a.h = forumMemberSocketResponseMessage.isPrivateForum();
                    this.a.n = forumMemberSocketResponseMessage.getComplaintBarlordData();
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
                rt7 rt7Var = this.a.k;
                du7 du7Var = this.a.m;
                dq7 dq7Var = this.a;
                rt7Var.a(3, 0, du7Var, dq7Var.A(dq7Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j, this.a.n));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, this.a.d));
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(dq7 dq7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq7Var, Integer.valueOf(i)};
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
            this.a = dq7Var;
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
                this.a.n = forumMemberReadCacheResponseMessage.getComplaintBarlordData();
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
                dq7 dq7Var = this.a;
                ArrayList<pi> A = dq7Var.A(dq7Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j, this.a.n);
                if (A != null && A.size() > 0) {
                    this.a.k.a(3, 0, this.a.m, A);
                } else if (!this.a.l) {
                    this.a.k.a(3, 0, this.a.m, A);
                }
            }
            if (this.a.l) {
                dq7 dq7Var2 = this.a;
                dq7Var2.z(JavaTypesHelper.toLong(dq7Var2.b, 0L), this.a.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(dq7 dq7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq7Var, Integer.valueOf(i)};
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
            this.a = dq7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof LikeReturnData)) {
                this.a.m.e = customResponsedMessage.getError();
                this.a.m.f = customResponsedMessage.getErrorString();
                this.a.m.g = false;
                this.a.m.i = false;
                this.a.m.h = false;
                this.a.m.b = this.a.b;
                this.a.m.a = this.a.c;
                this.a.m.c = 1;
                LikeReturnData likeReturnData = (LikeReturnData) customResponsedMessage.getData();
                if (likeReturnData != null && likeReturnData.isLike() == 0 && this.a.d != null) {
                    likeReturnData.setCurScore(this.a.d.getCurScore());
                    likeReturnData.setLevelupScore(this.a.d.getLevelupScore());
                }
                this.a.d = likeReturnData;
                if (this.a.k != null) {
                    rt7 rt7Var = this.a.k;
                    du7 du7Var = this.a.m;
                    dq7 dq7Var = this.a;
                    rt7Var.a(3, 0, du7Var, dq7Var.A(dq7Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j, this.a.n));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(dq7 dq7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq7Var, Integer.valueOf(i)};
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
            this.a = dq7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                dq7 dq7Var = this.a;
                dq7Var.z(JavaTypesHelper.toLong(dq7Var.b, 0L), this.a.c);
            }
        }
    }

    public dq7() {
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
        this.m = new du7();
        this.o = new a(this, CmdConfigHttp.FRS_MEMBER_TAB_CMD, 301004);
        this.p = new b(this, 2003009);
        this.q = new c(this, 2001266);
        this.r = new d(this, 2001222);
    }

    public void E(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        this.a = bdUniqueId;
    }

    @Override // com.baidu.tieba.nt7
    public void N(rt7 rt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rt7Var) == null) {
            this.k = rt7Var;
        }
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

    public ArrayList<pi> A(LikeReturnData likeReturnData, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo, boolean z, boolean z2, PriManagerApplyInfo priManagerApplyInfo, @Nullable bq7 bq7Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{likeReturnData, list, memberGodInfo, managerApplyInfo, Boolean.valueOf(z), Boolean.valueOf(z2), priManagerApplyInfo, bq7Var})) == null) {
            if (likeReturnData == null) {
                return null;
            }
            ArrayList<pi> arrayList = new ArrayList<>();
            if (likeReturnData.isLike() == 1) {
                hq7 hq7Var = new hq7();
                hq7Var.f(likeReturnData);
                hq7Var.d(this.b);
                hq7Var.e(this.c);
                arrayList.add(hq7Var);
            }
            if (list != null && list.size() > 0) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (list.get(i) != null && list.get(i).member_group_num != null && list.get(i).member_group_num.intValue() > 0 && ListUtils.getCount(list.get(i).member_group_list) > 0) {
                        jq7 jq7Var = new jq7();
                        jq7Var.c(this.b);
                        jq7Var.d(this.c);
                        jq7Var.e(list.get(i));
                        if (i == size - 1) {
                            jq7Var.f(true);
                        } else {
                            jq7Var.f(false);
                        }
                        arrayList.add(jq7Var);
                    }
                }
            }
            if (this.h) {
                if (this.i && priManagerApplyInfo != null) {
                    nq7 nq7Var = new nq7();
                    nq7Var.g(priManagerApplyInfo.assist_left_num.intValue());
                    nq7Var.f(priManagerApplyInfo.assist_apply_url);
                    nq7Var.e(priManagerApplyInfo.assist_apply_status.intValue());
                    arrayList.add(nq7Var);
                }
            } else {
                lq7 lq7Var = new lq7();
                if (managerApplyInfo != null) {
                    lq7Var.h(managerApplyInfo.manager_left_num.intValue());
                    lq7Var.g(managerApplyInfo.manager_apply_url);
                    lq7Var.e(managerApplyInfo.assist_left_num.intValue());
                    lq7Var.d(managerApplyInfo.assist_apply_url);
                    lq7Var.f(managerApplyInfo.manager_apply_status.intValue());
                }
                arrayList.add(lq7Var);
                if (bq7Var != null) {
                    arrayList.add(bq7Var);
                }
            }
            B(memberGodInfo, arrayList);
            pi x = x();
            if (x != null) {
                arrayList.add(x);
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public final void B(MemberGodInfo memberGodInfo, ArrayList<pi> arrayList) {
        List<User> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, memberGodInfo, arrayList) == null) && memberGodInfo != null && (list = memberGodInfo.forum_god_list) != null && list.size() > 0 && arrayList != null) {
            List<User> list2 = memberGodInfo.forum_god_list;
            if (memberGodInfo.forum_god_num.intValue() != 0 && list2.size() != 0) {
                xp7 xp7Var = new xp7();
                xp7Var.c(memberGodInfo);
                arrayList.add(xp7Var);
                boolean z = false;
                for (int i = 0; i < list2.size(); i++) {
                    User user = list2.get(i);
                    if (user != null && user.god_data.type.intValue() == 2) {
                        zp7 zp7Var = new zp7();
                        zp7Var.p(user, i);
                        arrayList.add(zp7Var);
                        if (!z) {
                            z = true;
                        }
                    }
                }
                if (!z) {
                    arrayList.remove(xp7Var);
                }
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            du7 du7Var = this.m;
            du7Var.e = 0;
            du7Var.g = false;
            du7Var.i = false;
            du7Var.h = false;
            du7Var.b = this.b;
            du7Var.a = this.c;
            du7Var.c = 1;
            rt7 rt7Var = this.k;
            if (rt7Var != null) {
                rt7Var.a(3, 0, du7Var, A(this.d, this.e, this.f, this.g, this.i, this.h, this.j, this.n));
            }
        }
    }

    @Override // com.baidu.tieba.nt7
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.o);
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().unRegisterListener(this.q);
            MessageManager.getInstance().unRegisterListener(this.r);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            vva.h(301004, ForumMemberSocketResponseMessage.class, false, false);
            vva.c(301004, CmdConfigHttp.FRS_MEMBER_TAB_CMD, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
            vva.b(2003009, eq7.class);
        }
    }

    @Override // com.baidu.tieba.nt7
    public void J(int i, int i2, zt7 zt7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, zt7Var) == null) && i == 3 && zt7Var != null) {
            String str = zt7Var.b;
            this.b = str;
            String str2 = zt7Var.a;
            this.c = str2;
            if (this.l) {
                y(str2);
            } else if (zt7Var.c == -1) {
                z(JavaTypesHelper.toLong(str, 0L), zt7Var.a);
            } else {
                C();
            }
        }
    }

    @Override // com.baidu.tieba.nt7
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            D();
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.p.setTag(bdUniqueId);
                this.o.setTag(this.a);
                this.p.setSelfListener(true);
                if (this.o.getHttpMessageListener() != null) {
                    this.o.getHttpMessageListener().setSelfListener(true);
                }
                if (this.o.getSocketMessageListener() != null) {
                    this.o.getSocketMessageListener().setSelfListener(true);
                }
            }
            MessageManager.getInstance().registerListener(this.p);
            MessageManager.getInstance().registerListener(this.o);
            MessageManager.getInstance().registerListener(this.q);
            MessageManager.getInstance().registerListener(this.r);
        }
    }

    public final js7 x() {
        InterceptResult invokeV;
        int dimens;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            List<MemberGroupInfo> list = this.e;
            if (list != null && list.size() > 0) {
                js7 js7Var = new js7();
                int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst().getContext());
                int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07019a);
                int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070423);
                int dimens4 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0703bd);
                int size = this.e.size();
                if (TbadkCoreApplication.isLogin()) {
                    dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0703b8);
                } else {
                    dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070390);
                }
                js7Var.d(equipmentHeight - (((dimens2 + dimens3) + dimens) + (dimens4 * size)));
                js7Var.c(R.drawable.transparent_bg);
                return js7Var;
            }
            return null;
        }
        return (js7) invokeV.objValue;
    }

    public void z(long j, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(1048587, this, j, str) == null) && j > 0 && !StringUtils.isNull(str)) {
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
}
