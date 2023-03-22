package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
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
/* loaded from: classes4.dex */
public class ew7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GroupChatFragment a;
    public GroupChatRobotFloorView b;
    public e c;
    public f d;
    public List<BotsDTO.BotListDTO> e;
    public boolean f;
    public int g;
    public int h;

    /* loaded from: classes4.dex */
    public interface d {
        void a();
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z);

        void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO);
    }

    /* loaded from: classes4.dex */
    public class a implements GroupChatRobotFloorView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ew7 a;

        public a(ew7 ew7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ew7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ew7Var;
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatRobotFloorView.d
        public void a(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, str, i, i2) == null) {
                BotsDTO.BotListDTO.UserDTO e = this.a.e(str);
                BotsDTO.BotListDTO.SkillDTO f = this.a.f(str, i);
                if (this.a.d != null && e != null && f != null) {
                    this.a.d.a(e, f);
                }
                if (f != null) {
                    long h2 = this.a.a.h2();
                    long f2 = this.a.a.f2();
                    TiebaStatic.log(new StatisticItem("c15132").param("obj_type", 2).param("obj_name", f.getName()).param("obj_source", i2).param("fid", f2).param("room_id", h2).param("fname", this.a.a.g2()).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(ew7 ew7Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ew7Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                d dVar = this.a;
                if (dVar != null) {
                    dVar.a();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ ew7 b;

        public c(ew7 ew7Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ew7Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ew7Var;
            this.a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.b.p(false, 0);
                this.b.a.q2(true);
                d dVar = this.a;
                if (dVar != null) {
                    dVar.a();
                }
            }
        }
    }

    public ew7(GroupChatFragment groupChatFragment) {
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
        this.a = groupChatFragment;
        if (groupChatFragment != null) {
            this.g = hi.j(groupChatFragment.getContext());
        }
    }

    public void j(boolean z) {
        GroupChatFragment groupChatFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f = z;
            if (z && (groupChatFragment = this.a) != null) {
                this.h = gd5.d(groupChatFragment.getContext());
            }
        }
    }

    public void k(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.c = eVar;
        }
    }

    public void l(BotsDTO botsDTO) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, botsDTO) == null) && botsDTO != null && !ListUtils.isEmpty(botsDTO.getBotList())) {
            this.e = botsDTO.getBotList();
            this.b.setData(botsDTO.getBotList());
        }
    }

    public void m(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.d = fVar;
        }
    }

    public void n(@Nullable d dVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) && h() && (eVar = this.c) != null) {
            eVar.b(g(), 0, 200L, new c(this, dVar), false);
        }
    }

    public void o(GroupChatRobotFloorView groupChatRobotFloorView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, groupChatRobotFloorView) == null) {
            this.b = groupChatRobotFloorView;
            i();
        }
    }

    public final BotsDTO.BotListDTO.UserDTO e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && !ListUtils.isEmpty(this.e)) {
                for (BotsDTO.BotListDTO botListDTO : this.e) {
                    if (botListDTO != null && botListDTO.getUser() != null && str.equals(botListDTO.getUser().getUk())) {
                        return botListDTO.getUser();
                    }
                }
            }
            return null;
        }
        return (BotsDTO.BotListDTO.UserDTO) invokeL.objValue;
    }

    public final BotsDTO.BotListDTO.SkillDTO f(@Nullable String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            if (!TextUtils.isEmpty(str) && !ListUtils.isEmpty(this.e)) {
                for (BotsDTO.BotListDTO botListDTO : this.e) {
                    if (botListDTO != null && botListDTO.getUser() != null && str.equals(botListDTO.getUser().getUk()) && !ListUtils.isEmpty(botListDTO.getSkill())) {
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

    public void p(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (z) {
                this.b.setVisibility(0);
                this.b.setCallFrom(i);
                TiebaStatic.log(new StatisticItem("c15132").param("obj_type", 1).param("obj_source", i).param("fid", this.a.f2()).param("room_id", this.a.h2()).param("fname", this.a.g2()).param("uid", TbadkCoreApplication.getCurrentAccount()));
                return;
            }
            this.b.setVisibility(8);
        }
    }

    public void q(@Nullable d dVar, int i) {
        GroupChatRobotFloorView groupChatRobotFloorView;
        GroupChatFragment groupChatFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048588, this, dVar, i) == null) && !h() && this.c != null && (groupChatRobotFloorView = this.b) != null && groupChatRobotFloorView.getRobotItemDataAdapter() != null && this.b.getRobotItemDataAdapter().l() != 0 && (groupChatFragment = this.a) != null && groupChatFragment.e2() != null && !this.a.e2().G() && this.a.k2() != null && this.a.k2().p0() != null && !this.a.k2().p0().e()) {
            p(true, i);
            this.a.q2(true);
            this.c.a(0, g(), 200L, new b(this, dVar), true);
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            GroupChatRobotFloorView groupChatRobotFloorView = this.b;
            if (groupChatRobotFloorView != null && this.a != null) {
                int i = ((this.g * 4) / 5) - this.h;
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

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.b.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        GroupChatRobotFloorView groupChatRobotFloorView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (groupChatRobotFloorView = this.b) == null) {
            return;
        }
        groupChatRobotFloorView.setOnItemClickListener(new a(this));
    }
}
