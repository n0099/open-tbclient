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
import com.baidu.tieba.adc;
import com.baidu.tieba.cd8;
import com.baidu.tieba.cl8;
import com.baidu.tieba.dd8;
import com.baidu.tieba.de8;
import com.baidu.tieba.ed8;
import com.baidu.tieba.fd8;
import com.baidu.tieba.hd8;
import com.baidu.tieba.im.base.core.inputtool.consts.BotSourceType;
import com.baidu.tieba.im.base.core.inputtool.data.InputBanData;
import com.baidu.tieba.im.base.core.inputtool.data.PaddingContentData;
import com.baidu.tieba.im.base.core.inputtool.keyboardtool.PanelType;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.data.UserReplyInfoData;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.tieba.md8;
import com.baidu.tieba.od8;
import com.baidu.tieba.pd8;
import com.baidu.tieba.qe8;
import com.baidu.tieba.sf8;
import com.baidu.tieba.tf8;
import com.baidu.tieba.uc8;
import com.baidu.tieba.yc8;
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

    public InputDelegate(SOURCE source, @NonNull InputToolFragment inputToolFragment, @NonNull GroupInputTool groupInputTool, @Nullable tf8 tf8Var, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {source, inputToolFragment, groupInputTool, tf8Var, Long.valueOf(j), Long.valueOf(j2)};
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
        GroupInputViewController groupInputViewController = new GroupInputViewController(inputToolFragment, tf8Var, j);
        this.c = groupInputViewController;
        groupInputViewController.F1(j2);
        D();
    }

    public void A(List<PaddingContentData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.c.Y0(list);
        }
    }

    public void B(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.c.Z0(str);
        }
    }

    public boolean F(@NonNull List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            return this.c.m1(list);
        }
        return invokeL.booleanValue;
    }

    public void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.c.onChangeSkinType(i);
        }
    }

    public void I(@Nullable dd8 dd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dd8Var) == null) {
            this.c.s1(dd8Var);
        }
    }

    public void K(sf8 sf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, sf8Var) == null) {
            this.c.A1(sf8Var);
        }
    }

    public void L(BotsDTO botsDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, botsDTO) == null) {
            this.c.B1(botsDTO);
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.c.C1(str);
        }
    }

    public void O(hd8 hd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, hd8Var) == null) {
            this.b.h0(hd8Var);
        }
    }

    public void P(List<InputBanData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.c.G1(list);
        }
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.c.K1(str);
        }
    }

    public void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.c.L1(str);
        }
    }

    public void S(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.c.M1(str);
        }
    }

    public void T(PanelType panelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, panelType) == null) {
            this.c.N1(panelType);
        }
    }

    public void V(adc<PanelType, PanelType, Float, Float> adcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, adcVar) == null) {
            this.c.S1(adcVar);
        }
    }

    public void W(@Nullable de8.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, dVar) == null) && this.c.O0() != null) {
            this.c.O0().v(dVar);
        }
    }

    public void X(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.c.T1(i);
        }
    }

    public void Y(@Nullable ed8 ed8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, ed8Var) == null) {
            this.c.a2(ed8Var);
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.c.e2(z);
        }
    }

    public void b(@NonNull cl8 cl8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, cl8Var) == null) {
            this.c.V0().c(cl8Var);
        }
    }

    public void c(@NonNull List<cl8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, list) == null) {
            this.c.V0().f(list);
        }
    }

    public void d0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.c.V0().e(i);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.b1();
            this.c.a1();
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.getLifecycle().addObserver(this.c);
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.c.M0() != null) {
                return this.c.M0().a0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.c.g0();
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.c.m0();
        }
        return invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.c.n0();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.c.o0();
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.c.V0().d();
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.c.z0();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.c.A0();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.c.B0();
        }
    }

    @Nullable
    public uc8 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.c.C0();
        }
        return (uc8) invokeV.objValue;
    }

    @Nullable
    public cl8 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.c.V0().h();
        }
        return (cl8) invokeV.objValue;
    }

    public BotSourceType o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.c.X0();
        }
        return (BotSourceType) invokeV.objValue;
    }

    @NonNull
    public GroupInputViewController p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.c;
        }
        return (GroupInputViewController) invokeV.objValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (this.c.T0() != null && this.c.T0().e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.c.K0();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.c.L0();
        }
        return (String) invokeV.objValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (this.c.U0() != null && this.c.U0().e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (this.c.O0() != null && this.c.O0().m()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public yc8 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.c.R0();
        }
        return (yc8) invokeV.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.c.S0();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public qe8 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.c.V0();
        }
        return (qe8) invokeV.objValue;
    }

    @Nullable
    public VoiceManager y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.c.W0();
        }
        return (VoiceManager) invokeV.objValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return StringUtils.isNotNull(this.c.K0());
        }
        return invokeV.booleanValue;
    }

    public void G(int i, int i2, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) {
            this.c.r1(i, i2, intent);
        }
    }

    public void U(BotSourceType botSourceType, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{botSourceType, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.c.P1(botSourceType, z, z2);
        }
    }

    public void Z(int i, @NonNull Object obj, @NonNull od8 od8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048601, this, i, obj, od8Var) == null) {
            this.c.c2(i, obj, od8Var);
        }
    }

    public void a(@NonNull AtSelectData atSelectData, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{atSelectData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.c.d0(atSelectData, z, z2);
        }
    }

    public void J(@NonNull UserReplyInfoData userReplyInfoData, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, userReplyInfoData, obj) == null) {
            this.c.u1(userReplyInfoData, obj);
        }
    }

    public void c0(pd8 pd8Var, md8 md8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, pd8Var, md8Var) == null) {
            this.c.p2(pd8Var, md8Var);
        }
    }

    public void e0(@NonNull String str, @NonNull cd8 cd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, str, cd8Var) == null) {
            this.c.r2(str, cd8Var);
        }
    }

    public void f0(@NonNull String str, @NonNull fd8 fd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, fd8Var) == null) {
            this.c.s2(str, fd8Var);
        }
    }

    public boolean h(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048615, this, i, i2)) == null) {
            return this.c.t0(i, i2);
        }
        return invokeII.booleanValue;
    }

    public void N(@Nullable Object obj, @Nullable BotsDTO.BotListDTO.UserDTO userDTO, @Nullable BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{obj, userDTO, skillDTO, Boolean.valueOf(z)}) == null) {
            this.c.D1(obj, userDTO, skillDTO, z);
        }
    }

    public void b0(@NonNull pd8 pd8Var, @NonNull BotsDTO botsDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, pd8Var, botsDTO) == null) {
            d0(pd8Var.e());
            if (pd8Var.b() != null && ListUtils.isNotEmpty(pd8Var.b())) {
                c(pd8Var.b());
            }
            L(botsDTO);
            if (botsDTO.getGuide() != null) {
                M(botsDTO.getGuide());
            }
        }
    }
}
