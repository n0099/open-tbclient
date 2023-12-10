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
public class eq7 implements ot7 {
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
    public st7 k;
    public boolean l;
    public eu7 m;
    public cq7 n;
    public NetMessageListener o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;

    /* loaded from: classes5.dex */
    public class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eq7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(eq7 eq7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eq7Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = eq7Var;
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
                st7 st7Var = this.a.k;
                eu7 eu7Var = this.a.m;
                eq7 eq7Var = this.a;
                st7Var.a(3, 0, eu7Var, eq7Var.A(eq7Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j, this.a.n));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, this.a.d));
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eq7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(eq7 eq7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eq7Var, Integer.valueOf(i)};
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
            this.a = eq7Var;
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
                eq7 eq7Var = this.a;
                ArrayList<pi> A = eq7Var.A(eq7Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j, this.a.n);
                if (A != null && A.size() > 0) {
                    this.a.k.a(3, 0, this.a.m, A);
                } else if (!this.a.l) {
                    this.a.k.a(3, 0, this.a.m, A);
                }
            }
            if (this.a.l) {
                eq7 eq7Var2 = this.a;
                eq7Var2.z(JavaTypesHelper.toLong(eq7Var2.b, 0L), this.a.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eq7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(eq7 eq7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eq7Var, Integer.valueOf(i)};
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
            this.a = eq7Var;
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
                    st7 st7Var = this.a.k;
                    eu7 eu7Var = this.a.m;
                    eq7 eq7Var = this.a;
                    st7Var.a(3, 0, eu7Var, eq7Var.A(eq7Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j, this.a.n));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eq7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(eq7 eq7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eq7Var, Integer.valueOf(i)};
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
            this.a = eq7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                eq7 eq7Var = this.a;
                eq7Var.z(JavaTypesHelper.toLong(eq7Var.b, 0L), this.a.c);
            }
        }
    }

    public eq7() {
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
        this.m = new eu7();
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

    @Override // com.baidu.tieba.ot7
    public void N(st7 st7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, st7Var) == null) {
            this.k = st7Var;
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

    public ArrayList<pi> A(LikeReturnData likeReturnData, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo, boolean z, boolean z2, PriManagerApplyInfo priManagerApplyInfo, @Nullable cq7 cq7Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{likeReturnData, list, memberGodInfo, managerApplyInfo, Boolean.valueOf(z), Boolean.valueOf(z2), priManagerApplyInfo, cq7Var})) == null) {
            if (likeReturnData == null) {
                return null;
            }
            ArrayList<pi> arrayList = new ArrayList<>();
            if (likeReturnData.isLike() == 1) {
                iq7 iq7Var = new iq7();
                iq7Var.f(likeReturnData);
                iq7Var.d(this.b);
                iq7Var.e(this.c);
                arrayList.add(iq7Var);
            }
            if (list != null && list.size() > 0) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (list.get(i) != null && list.get(i).member_group_num != null && list.get(i).member_group_num.intValue() > 0 && ListUtils.getCount(list.get(i).member_group_list) > 0) {
                        kq7 kq7Var = new kq7();
                        kq7Var.c(this.b);
                        kq7Var.d(this.c);
                        kq7Var.e(list.get(i));
                        if (i == size - 1) {
                            kq7Var.f(true);
                        } else {
                            kq7Var.f(false);
                        }
                        arrayList.add(kq7Var);
                    }
                }
            }
            if (this.h) {
                if (this.i && priManagerApplyInfo != null) {
                    oq7 oq7Var = new oq7();
                    oq7Var.g(priManagerApplyInfo.assist_left_num.intValue());
                    oq7Var.f(priManagerApplyInfo.assist_apply_url);
                    oq7Var.e(priManagerApplyInfo.assist_apply_status.intValue());
                    arrayList.add(oq7Var);
                }
            } else {
                mq7 mq7Var = new mq7();
                if (managerApplyInfo != null) {
                    mq7Var.h(managerApplyInfo.manager_left_num.intValue());
                    mq7Var.g(managerApplyInfo.manager_apply_url);
                    mq7Var.e(managerApplyInfo.assist_left_num.intValue());
                    mq7Var.d(managerApplyInfo.assist_apply_url);
                    mq7Var.f(managerApplyInfo.manager_apply_status.intValue());
                }
                arrayList.add(mq7Var);
                if (cq7Var != null) {
                    arrayList.add(cq7Var);
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
                yp7 yp7Var = new yp7();
                yp7Var.c(memberGodInfo);
                arrayList.add(yp7Var);
                boolean z = false;
                for (int i = 0; i < list2.size(); i++) {
                    User user = list2.get(i);
                    if (user != null && user.god_data.type.intValue() == 2) {
                        aq7 aq7Var = new aq7();
                        aq7Var.p(user, i);
                        arrayList.add(aq7Var);
                        if (!z) {
                            z = true;
                        }
                    }
                }
                if (!z) {
                    arrayList.remove(yp7Var);
                }
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            eu7 eu7Var = this.m;
            eu7Var.e = 0;
            eu7Var.g = false;
            eu7Var.i = false;
            eu7Var.h = false;
            eu7Var.b = this.b;
            eu7Var.a = this.c;
            eu7Var.c = 1;
            st7 st7Var = this.k;
            if (st7Var != null) {
                st7Var.a(3, 0, eu7Var, A(this.d, this.e, this.f, this.g, this.i, this.h, this.j, this.n));
            }
        }
    }

    @Override // com.baidu.tieba.ot7
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
            wva.h(301004, ForumMemberSocketResponseMessage.class, false, false);
            wva.c(301004, CmdConfigHttp.FRS_MEMBER_TAB_CMD, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
            wva.b(2003009, fq7.class);
        }
    }

    @Override // com.baidu.tieba.ot7
    public void J(int i, int i2, au7 au7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, au7Var) == null) && i == 3 && au7Var != null) {
            String str = au7Var.b;
            this.b = str;
            String str2 = au7Var.a;
            this.c = str2;
            if (this.l) {
                y(str2);
            } else if (au7Var.c == -1) {
                z(JavaTypesHelper.toLong(str, 0L), au7Var.a);
            } else {
                C();
            }
        }
    }

    @Override // com.baidu.tieba.ot7
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

    public final ks7 x() {
        InterceptResult invokeV;
        int dimens;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            List<MemberGroupInfo> list = this.e;
            if (list != null && list.size() > 0) {
                ks7 ks7Var = new ks7();
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
                ks7Var.d(equipmentHeight - (((dimens2 + dimens3) + dimens) + (dimens4 * size)));
                ks7Var.c(R.drawable.transparent_bg);
                return ks7Var;
            }
            return null;
        }
        return (ks7) invokeV.objValue;
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
