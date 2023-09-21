package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.base.core.inputtool.InputToolFragment;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatRobotFloorView;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.data.RecentlyBotSkillInfoDto;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class de8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final InputToolFragment a;
    public GroupChatRobotFloorView b;
    public e c;
    public f d;
    public List<BotsDTO.BotListDTO> e;
    public List<Object> f;
    public List<Object> g;
    @Nullable
    public pd8 h;
    @Nullable
    public md8 i;
    public boolean j;
    public int k;
    public int l;

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
        public final /* synthetic */ de8 a;

        public a(de8 de8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = de8Var;
        }

        @Override // com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatRobotFloorView.f
        public void a(String str, int i, int i2) {
            long j;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, str, i, i2) == null) {
                BotsDTO.BotListDTO.UserDTO h = this.a.h(str);
                BotsDTO.BotListDTO.SkillDTO j2 = this.a.j(str, i);
                if (h != null && j2 != null && this.a.d != null) {
                    this.a.d.a(h, j2);
                    long j3 = 0;
                    if (this.a.h != null) {
                        j = this.a.h.d();
                    } else {
                        j = 0;
                    }
                    if (this.a.i != null) {
                        j3 = this.a.i.a();
                    }
                    if (this.a.i != null) {
                        str2 = this.a.i.b();
                    } else {
                        str2 = "";
                    }
                    TiebaStatic.log(new StatisticItem("c15132").param("obj_type", 2).param("obj_name", j2.getName()).param("obj_source", i2).param("fid", j3).param("room_id", j).param("fname", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ de8 b;

        public b(de8 de8Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de8Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = de8Var;
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
        public final /* synthetic */ de8 b;

        public c(de8 de8Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de8Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = de8Var;
            this.a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.b.x(false, 0);
                if (this.b.b != null) {
                    this.b.b.r();
                }
                if (this.b.a.o2() != null && this.b.a.o2().H() != null) {
                    this.b.a.o2().H().d(true);
                }
                d dVar = this.a;
                if (dVar != null) {
                    dVar.a();
                }
            }
        }
    }

    public de8(@NonNull InputToolFragment inputToolFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputToolFragment};
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
        this.a = inputToolFragment;
        this.k = BdUtilHelper.getEquipmentHeight(inputToolFragment.getContext());
    }

    public final BotsDTO.BotListDTO.UserDTO h(String str) {
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

    public final BotsDTO.BotListDTO i(String str) {
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

    public final void r(Boolean bool) {
        GroupChatRobotFloorView groupChatRobotFloorView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, bool) != null) || (groupChatRobotFloorView = this.b) == null) {
            return;
        }
        if (groupChatRobotFloorView.w() && !this.b.x()) {
            this.b.p();
        }
        if (!this.b.w() && this.b.x()) {
            this.b.E();
        }
        this.b.G();
        if (o()) {
            this.b.setTabLayoutVisible(false);
        } else {
            this.b.setTabLayoutVisible(!bool.booleanValue());
        }
    }

    public void z(pd8 pd8Var, md8 md8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, pd8Var, md8Var) == null) {
            this.h = pd8Var;
            this.i = md8Var;
        }
    }

    @NonNull
    public final List<RecentlyBotSkillInfoDto> k(@NonNull List<BotsDTO.BotListDTO> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            return se8.f().e(list);
        }
        return (List) invokeL.objValue;
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.j = z;
            if (z && this.a.getContext() != null) {
                this.l = sk5.d(this.a.getContext());
            }
        }
    }

    public void s(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.c = eVar;
        }
    }

    public void u(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) {
            this.d = fVar;
        }
    }

    public void v(@Nullable d dVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) && m() && (eVar = this.c) != null) {
            eVar.b(l(), 0, 200L, new c(this, dVar), false);
        }
    }

    public void w(GroupChatRobotFloorView groupChatRobotFloorView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, groupChatRobotFloorView) == null) {
            this.b = groupChatRobotFloorView;
            n();
        }
    }

    public final BotsDTO.BotListDTO.SkillDTO j(@Nullable String str, int i) {
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

    public void x(boolean z, int i) {
        long j;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (z) {
                this.b.setVisibility(0);
                this.b.setCallFrom(i);
                pd8 pd8Var = this.h;
                long j2 = 0;
                if (pd8Var != null) {
                    j = pd8Var.d();
                } else {
                    j = 0;
                }
                md8 md8Var = this.i;
                if (md8Var != null) {
                    j2 = md8Var.a();
                }
                md8 md8Var2 = this.i;
                if (md8Var2 != null) {
                    str = md8Var2.b();
                } else {
                    str = "";
                }
                TiebaStatic.log(new StatisticItem("c15132").param("obj_type", 1).param("obj_source", i).param("fid", j2).param("room_id", j).param("fname", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
                return;
            }
            this.b.setVisibility(8);
        }
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            GroupChatRobotFloorView groupChatRobotFloorView = this.b;
            if (groupChatRobotFloorView != null) {
                int i = ((this.k * 4) / 5) - this.l;
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

    public boolean m() {
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

    public final void n() {
        GroupChatRobotFloorView groupChatRobotFloorView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (groupChatRobotFloorView = this.b) == null) {
            return;
        }
        groupChatRobotFloorView.setOnItemClickListener(new a(this));
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.e.size() <= 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean p(Boolean bool) {
        InterceptResult invokeL;
        BotsDTO.BotListDTO i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bool)) == null) {
            this.b.D();
            if (bool.booleanValue() && this.a.r2() != null && this.a.r2().p().C0() != null && this.a.r2().p().C0().s() != null) {
                List<String> atUidList = this.a.r2().p().C0().s().getAtUidList();
                if (ListUtils.getCount(atUidList) != 1 || (i = i(BIMManager.getBdUKFromBdUid(atUidList.get(0)))) == null) {
                    return false;
                }
                this.g.clear();
                this.g.add(i);
                return this.b.z(this.g, bool.booleanValue());
            }
            this.f.clear();
            this.f.addAll(k(this.e));
            this.f.addAll(this.e);
            return this.b.z(this.f, bool.booleanValue());
        }
        return invokeL.booleanValue;
    }

    public void t(BotsDTO botsDTO) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, botsDTO) == null) && botsDTO != null && !ListUtils.isEmpty(botsDTO.getBotList())) {
            this.e = botsDTO.getBotList();
            this.f.clear();
            this.f.addAll(k(this.e));
            this.f.addAll(this.e);
            this.b.setData(this.f, o());
        }
    }

    public void y(@Nullable d dVar, int i, Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048593, this, dVar, i, bool) != null) || m() || this.c == null || this.b == null || this.a.r2() == null || this.a.r2().p().U0() == null || this.a.r2().p().U0().e() || !p(bool)) {
            return;
        }
        r(bool);
        x(true, i);
        if (this.a.o2() != null && this.a.o2().H() != null) {
            this.a.o2().H().d(true);
        }
        this.c.a(0, l(), 200L, new b(this, dVar), true);
    }
}
