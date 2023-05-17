package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.immessagecenter.chatgroup.data.RecentlyBotSkillInfoDto;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatRobotFloorView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class da8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GroupChatFragment a;
    public GroupChatRobotFloorView b;
    public e c;
    public f d;
    public List<BotsDTO.BotListDTO> e;
    public List<Object> f;
    public List<Object> g;
    public boolean h;
    public int i;
    public int j;

    /* loaded from: classes5.dex */
    public interface d {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z);

        void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z);
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO);
    }

    /* loaded from: classes5.dex */
    public class a implements GroupChatRobotFloorView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ da8 a;

        public a(da8 da8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {da8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = da8Var;
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatRobotFloorView.f
        public void a(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, str, i, i2) == null) {
                BotsDTO.BotListDTO.UserDTO f = this.a.f(str);
                BotsDTO.BotListDTO.SkillDTO h = this.a.h(str, i);
                if (f != null && h != null && this.a.d != null) {
                    this.a.d.a(f, h);
                    long i22 = this.a.a.i2();
                    long g2 = this.a.a.g2();
                    TiebaStatic.log(new StatisticItem("c15132").param("obj_type", 2).param("obj_name", h.getName()).param("obj_source", i2).param("fid", g2).param("room_id", i22).param("fname", this.a.a.h2()).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ da8 b;

        public b(da8 da8Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {da8Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = da8Var;
            this.a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                if (this.b.b != null) {
                    this.b.b.F();
                }
                d dVar = this.a;
                if (dVar != null) {
                    dVar.a();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ da8 b;

        public c(da8 da8Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {da8Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = da8Var;
            this.a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.b.u(false, 0);
                if (this.b.b != null) {
                    this.b.b.r();
                }
                this.b.a.z2(true);
                d dVar = this.a;
                if (dVar != null) {
                    dVar.a();
                }
            }
        }
    }

    public da8(GroupChatFragment groupChatFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupChatFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.a = groupChatFragment;
        if (groupChatFragment != null) {
            this.i = ri.j(groupChatFragment.getContext());
        }
    }

    public final BotsDTO.BotListDTO.UserDTO f(String str) {
        InterceptResult invokeL;
        BotsDTO.BotListDTO botListDTO;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && !ListUtils.isEmpty(this.e)) {
                for (BotsDTO.BotListDTO botListDTO2 : this.e) {
                    if ((botListDTO2 instanceof BotsDTO.BotListDTO) && (botListDTO = botListDTO2) != null && botListDTO.getUser() != null && str.equals(botListDTO.getUser().getUk())) {
                        return botListDTO.getUser();
                    }
                }
            }
            return null;
        }
        return (BotsDTO.BotListDTO.UserDTO) invokeL.objValue;
    }

    public final BotsDTO.BotListDTO g(String str) {
        InterceptResult invokeL;
        BotsDTO.BotListDTO botListDTO;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && !ListUtils.isEmpty(this.e)) {
                for (BotsDTO.BotListDTO botListDTO2 : this.e) {
                    if ((botListDTO2 instanceof BotsDTO.BotListDTO) && (botListDTO = botListDTO2) != null && botListDTO.getUser() != null && str.equals(botListDTO.getUser().getUk())) {
                        return botListDTO;
                    }
                }
            }
            return null;
        }
        return (BotsDTO.BotListDTO) invokeL.objValue;
    }

    public final void o(Boolean bool) {
        GroupChatRobotFloorView groupChatRobotFloorView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, bool) != null) || (groupChatRobotFloorView = this.b) == null) {
            return;
        }
        if (groupChatRobotFloorView.w() && !this.b.x()) {
            this.b.p();
        }
        if (!this.b.w() && this.b.x()) {
            this.b.E();
        }
        this.b.G();
        this.b.setTabLayoutVisible(!bool.booleanValue());
    }

    @NonNull
    public final List<RecentlyBotSkillInfoDto> i(@NonNull List<BotsDTO.BotListDTO> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            return mb8.f().e(list);
        }
        return (List) invokeL.objValue;
    }

    public void n(boolean z) {
        GroupChatFragment groupChatFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.h = z;
            if (z && (groupChatFragment = this.a) != null) {
                this.j = ng5.d(groupChatFragment.getContext());
            }
        }
    }

    public void p(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            this.c = eVar;
        }
    }

    public void r(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, fVar) == null) {
            this.d = fVar;
        }
    }

    public void s(@Nullable d dVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) && k() && (eVar = this.c) != null) {
            eVar.b(j(), 0, 200L, new c(this, dVar), false);
        }
    }

    public void t(GroupChatRobotFloorView groupChatRobotFloorView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, groupChatRobotFloorView) == null) {
            this.b = groupChatRobotFloorView;
            l();
        }
    }

    public final BotsDTO.BotListDTO.SkillDTO h(@Nullable String str, int i) {
        InterceptResult invokeLI;
        BotsDTO.BotListDTO botListDTO;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i)) == null) {
            if (!TextUtils.isEmpty(str) && !ListUtils.isEmpty(this.e)) {
                for (BotsDTO.BotListDTO botListDTO2 : this.e) {
                    if ((botListDTO2 instanceof BotsDTO.BotListDTO) && (botListDTO = botListDTO2) != null && botListDTO.getUser() != null && str.equals(botListDTO.getUser().getUk()) && !ListUtils.isEmpty(botListDTO.getSkill())) {
                        for (BotsDTO.BotListDTO.SkillDTO skillDTO : botListDTO.getSkill()) {
                            if (i == skillDTO.getType()) {
                                return skillDTO;
                            }
                        }
                        continue;
                    }
                }
            }
            return null;
        }
        return (BotsDTO.BotListDTO.SkillDTO) invokeLI.objValue;
    }

    public void u(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (z) {
                this.b.setVisibility(0);
                this.b.setCallFrom(i);
                TiebaStatic.log(new StatisticItem("c15132").param("obj_type", 1).param("obj_source", i).param("fid", this.a.g2()).param("room_id", this.a.i2()).param("fname", this.a.h2()).param("uid", TbadkCoreApplication.getCurrentAccount()));
                return;
            }
            this.b.setVisibility(8);
        }
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            GroupChatRobotFloorView groupChatRobotFloorView = this.b;
            if (groupChatRobotFloorView != null && this.a != null) {
                int i = ((this.i * 4) / 5) - this.j;
                int robotFloorHeight = groupChatRobotFloorView.getRobotFloorHeight();
                if (robotFloorHeight > i) {
                    return i;
                }
                return robotFloorHeight;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.b.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void l() {
        GroupChatRobotFloorView groupChatRobotFloorView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (groupChatRobotFloorView = this.b) == null) {
            return;
        }
        groupChatRobotFloorView.setOnItemClickListener(new a(this));
    }

    public boolean m(Boolean bool) {
        InterceptResult invokeL;
        GroupChatFragment groupChatFragment;
        BotsDTO.BotListDTO g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bool)) == null) {
            this.b.D();
            if (bool.booleanValue() && (groupChatFragment = this.a) != null && groupChatFragment.l2() != null && this.a.l2().z0() != null && this.a.l2().z0().s() != null) {
                List<String> atUidList = this.a.l2().z0().s().getAtUidList();
                if (ListUtils.getCount(atUidList) != 1 || (g = g(BIMManager.getBdUKFromBdUid(atUidList.get(0)))) == null) {
                    return false;
                }
                this.g.clear();
                this.g.add(g);
                return this.b.z(this.g, bool.booleanValue());
            }
            this.f.clear();
            this.f.addAll(i(this.e));
            this.f.addAll(this.e);
            return this.b.z(this.f, bool.booleanValue());
        }
        return invokeL.booleanValue;
    }

    public void q(BotsDTO botsDTO) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, botsDTO) == null) && botsDTO != null && !ListUtils.isEmpty(botsDTO.getBotList())) {
            this.e = botsDTO.getBotList();
            this.f.clear();
            this.f.addAll(i(this.e));
            this.f.addAll(this.e);
            this.b.setData(this.f, false);
        }
    }

    public void v(@Nullable d dVar, int i, Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048592, this, dVar, i, bool) != null) || k() || this.c == null || this.b == null || this.a.l2() == null || this.a.l2().N0() == null || this.a.l2().N0().e() || !m(bool)) {
            return;
        }
        o(bool);
        u(true, i);
        this.a.z2(true);
        this.c.a(0, j(), 200L, new b(this, dVar), true);
    }
}
