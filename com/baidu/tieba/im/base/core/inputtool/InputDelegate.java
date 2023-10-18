package com.baidu.tieba.im.base.core.inputtool;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.room.Room;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.a88;
import com.baidu.tieba.b98;
import com.baidu.tieba.da8;
import com.baidu.tieba.ea8;
import com.baidu.tieba.f78;
import com.baidu.tieba.im.base.core.inputtool.consts.BotSourceType;
import com.baidu.tieba.im.base.core.inputtool.data.InputBanData;
import com.baidu.tieba.im.base.core.inputtool.data.PaddingContentData;
import com.baidu.tieba.im.base.core.inputtool.keyboardtool.PanelType;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.data.UserReplyInfoData;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.tieba.j78;
import com.baidu.tieba.mf8;
import com.baidu.tieba.n78;
import com.baidu.tieba.o78;
import com.baidu.tieba.o88;
import com.baidu.tieba.p78;
import com.baidu.tieba.q78;
import com.baidu.tieba.s78;
import com.baidu.tieba.x6c;
import com.baidu.tieba.x78;
import com.baidu.tieba.z78;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class InputDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final InputToolFragment a;
    @NonNull
    public GroupInputTool b;
    @NonNull
    public final GroupInputViewController c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class SOURCE {
        public static final /* synthetic */ SOURCE[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SOURCE ROOM;
        public static final SOURCE UGC;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(249020655, "Lcom/baidu/tieba/im/base/core/inputtool/InputDelegate$SOURCE;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(249020655, "Lcom/baidu/tieba/im/base/core/inputtool/InputDelegate$SOURCE;");
                    return;
                }
            }
            ROOM = new SOURCE(Room.LOG_TAG, 0);
            SOURCE source = new SOURCE("UGC", 1);
            UGC = source;
            $VALUES = new SOURCE[]{ROOM, source};
        }

        public SOURCE(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SOURCE valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (SOURCE) Enum.valueOf(SOURCE.class, str);
            }
            return (SOURCE) invokeL.objValue;
        }

        public static SOURCE[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (SOURCE[]) $VALUES.clone();
            }
            return (SOURCE[]) invokeV.objValue;
        }
    }

    public InputDelegate(SOURCE source, @NonNull InputToolFragment inputToolFragment, @NonNull GroupInputTool groupInputTool, @Nullable ea8 ea8Var, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {source, inputToolFragment, groupInputTool, ea8Var, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        SOURCE source2 = SOURCE.ROOM;
        this.a = inputToolFragment;
        this.b = groupInputTool;
        GroupInputViewController groupInputViewController = new GroupInputViewController(inputToolFragment, ea8Var, j);
        this.c = groupInputViewController;
        groupInputViewController.J1(j2);
        E();
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return StringUtils.isNotNull(this.c.N0());
        }
        return invokeV.booleanValue;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c.e1();
            this.c.d1();
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.getLifecycle().addObserver(this.c);
        }
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.c.P0() != null) {
                return this.c.P0().c0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.c.I1();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.c.i0();
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.c.o0();
        }
        return invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.c.p0();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.c.q0();
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.c.Y0().d();
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.c.B0();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.c.C0();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.c.D0();
        }
    }

    @Nullable
    public f78 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.c.E0();
        }
        return (f78) invokeV.objValue;
    }

    @Nullable
    public mf8 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.c.Y0().h();
        }
        return (mf8) invokeV.objValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.c.I0();
        }
        return invokeV.intValue;
    }

    public BotSourceType p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.c.a1();
        }
        return (BotSourceType) invokeV.objValue;
    }

    @NonNull
    public GroupInputViewController q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.c;
        }
        return (GroupInputViewController) invokeV.objValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (this.c.W0() != null && this.c.W0().e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.c.N0();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.c.O0();
        }
        return (String) invokeV.objValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            if (this.c.X0() != null && this.c.X0().e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (this.c.R0() != null && this.c.R0().n()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public j78 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.c.U0();
        }
        return (j78) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.c.V0();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public b98 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.c.Y0();
        }
        return (b98) invokeV.objValue;
    }

    @Nullable
    public VoiceManager z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.c.Z0();
        }
        return (VoiceManager) invokeV.objValue;
    }

    public void B(List<PaddingContentData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.c.b1(list);
        }
    }

    public void C(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.c.c1(str);
        }
    }

    public boolean G(@NonNull List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            return this.c.p1(list);
        }
        return invokeL.booleanValue;
    }

    public void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.c.onChangeSkinType(i);
        }
    }

    public void J(@Nullable o78 o78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, o78Var) == null) {
            this.c.v1(o78Var);
        }
    }

    public void M(da8 da8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, da8Var) == null) {
            this.c.D1(da8Var);
        }
    }

    public void N(BotsDTO botsDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, botsDTO) == null) {
            this.c.E1(botsDTO);
        }
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.c.F1(str);
        }
    }

    public void Q(s78 s78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, s78Var) == null) {
            this.b.j0(s78Var);
        }
    }

    public void R(List<InputBanData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            this.c.K1(list);
        }
    }

    public void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.c.O1(str);
        }
    }

    public void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.c.P1(str);
        }
    }

    public void U(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.c.Q1(str);
        }
    }

    public void X(x6c<PanelType, PanelType, Float, Float> x6cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, x6cVar) == null) {
            this.c.W1(x6cVar);
        }
    }

    public void Y(@Nullable o88.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, dVar) == null) && this.c.R0() != null) {
            this.c.R0().w(dVar);
        }
    }

    public void Z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.c.X1(i);
        }
    }

    public void a0(@Nullable p78 p78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, p78Var) == null) {
            this.c.e2(p78Var);
        }
    }

    public void b(@NonNull mf8 mf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, mf8Var) == null) {
            this.c.Y0().c(mf8Var);
        }
    }

    public void c(@NonNull List<mf8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, list) == null) {
            this.c.Y0().f(list);
        }
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.c.i2(z);
        }
    }

    public void f0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.c.Y0().e(i);
        }
    }

    public void H(int i, int i2, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, intent) == null) {
            this.c.u1(i, i2, intent);
        }
    }

    public void W(BotSourceType botSourceType, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{botSourceType, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.c.T1(botSourceType, z, z2);
        }
    }

    public void a(@NonNull AtSelectData atSelectData, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{atSelectData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.c.f0(atSelectData, z, z2);
        }
    }

    public void b0(int i, @NonNull Object obj, @NonNull z78 z78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048605, this, i, obj, z78Var) == null) {
            this.c.g2(i, obj, z78Var);
        }
    }

    public void L(@NonNull UserReplyInfoData userReplyInfoData, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, userReplyInfoData, obj) == null) {
            this.c.x1(userReplyInfoData, obj);
        }
    }

    public void V(PanelType panelType, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, panelType, i) == null) {
            this.c.R1(panelType, i);
        }
    }

    public void e0(a88 a88Var, x78 x78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, a88Var, x78Var) == null) {
            this.c.t2(a88Var, x78Var);
        }
    }

    public void g0(@NonNull String str, @NonNull n78 n78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, str, n78Var) == null) {
            this.c.v2(str, n78Var);
        }
    }

    public boolean h(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048616, this, i, i2)) == null) {
            return this.c.v0(i, i2);
        }
        return invokeII.booleanValue;
    }

    public void h0(@NonNull String str, @NonNull q78 q78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, str, q78Var) == null) {
            this.c.w2(str, q78Var);
        }
    }

    public void P(@Nullable Object obj, @Nullable BotsDTO.BotListDTO.UserDTO userDTO, @Nullable BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{obj, userDTO, skillDTO, Boolean.valueOf(z)}) == null) {
            this.c.G1(obj, userDTO, skillDTO, z);
        }
    }

    public void d0(@NonNull a88 a88Var, @NonNull BotsDTO botsDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, a88Var, botsDTO) == null) {
            f0(a88Var.e());
            if (a88Var.b() != null && ListUtils.isNotEmpty(a88Var.b())) {
                c(a88Var.b());
            }
            N(botsDTO);
            if (botsDTO.getGuide() != null) {
                O(botsDTO.getGuide());
            }
        }
    }
}
