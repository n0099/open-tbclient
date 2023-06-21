package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
import com.baidu.nadcore.player.utils.BdNetUtils;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.oo0;
import com.baidu.tieba.ou0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
/* loaded from: classes5.dex */
public abstract class cu0 extends ou0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int H;
    public BdVideoSeries I;
    public int J;
    public IVideoUpdateStrategy K;
    public u11 L;
    @Nullable
    public kv0 M;
    @Nullable
    public lv0 N;

    @Override // com.baidu.tieba.bu0
    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public abstract void F1(boolean z);

    public final void H1(@NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdVideoSeries) == null) {
        }
    }

    public int j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public int k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cu0(@NonNull ux0 ux0Var, @Nullable Context context) {
        super(ux0Var, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ux0Var, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ux0) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.H = 0;
        this.J = 0;
    }

    public void A1(@NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdVideoSeries) == null) {
            B1(bdVideoSeries, true);
        }
    }

    public void E1(@NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdVideoSeries) == null) {
            n01.b(bdVideoSeries, (Q() || Math.abs(s() - D()) < 3000) ? 0 : 0, s());
        }
    }

    @Override // com.baidu.tieba.bu0
    public void I0(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            super.I0(context);
            d(no0.b());
            if (s1()) {
                d(new g11());
            }
            d(new i11());
        }
    }

    @Override // com.baidu.tieba.ou0
    public void c1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            kv0 kv0Var = this.M;
            if (kv0Var != null && kv0Var.a(i)) {
                return;
            }
            super.c1(i);
        }
    }

    @Override // com.baidu.tieba.ou0
    public void d1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            lv0 lv0Var = this.N;
            if (lv0Var != null && lv0Var.a(i)) {
                return;
            }
            super.d1(i);
        }
    }

    @Override // com.baidu.tieba.bu0
    public void f0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            super.f0(i);
            this.A.cancel();
        }
    }

    public void z1(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, iVideoUpdateStrategy) == null) {
            this.K = iVideoUpdateStrategy;
        }
    }

    public void B1(@NonNull BdVideoSeries bdVideoSeries, boolean z) {
        String str;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, bdVideoSeries, z) == null) {
            f21.g(M0("setVideoSeriesForPrepare(" + System.identityHashCode(bdVideoSeries) + StringUtil.ARRAY_ELEMENT_SEPARATOR + z + SmallTailInfo.EMOTION_SUFFIX));
            if (("series = " + bdVideoSeries) != null) {
                str = bdVideoSeries.toString();
            } else {
                str = null;
            }
            f21.g(M0(str));
            boolean z3 = false;
            x1(false, this.I);
            this.I = bdVideoSeries;
            if (!TextUtils.isEmpty(bdVideoSeries.getNid())) {
                C0(this.I.getNid());
            }
            H1(bdVideoSeries);
            if (bdVideoSeries.getSelectedVideo() != null) {
                C1(bdVideoSeries);
                G1(this.a.b);
                if (b0() && E().d(this, this.b)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2 || D() <= 0) {
                    v1(false, bdVideoSeries);
                }
                q21.r(this.I.getNid(), this.a.b);
                v0(bdVideoSeries.isPlayLoop());
                if (z) {
                    x0(bdVideoSeries.getPlayConf());
                }
                if (bdVideoSeries.getClarityList() != null) {
                    r0(bdVideoSeries.getClarityList().getClarityInfoStr());
                }
                F1(false);
                String str2 = this.a.b;
                if (z && !z2) {
                    z3 = true;
                }
                E0(str2, z3);
            }
        }
    }

    public final void C1(@NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdVideoSeries) == null) {
            BdVideo selectedVideo = bdVideoSeries.getSelectedVideo();
            if (selectedVideo != null) {
                String localSavePath = selectedVideo.getLocalSavePath();
                if (e21.a(localSavePath)) {
                    this.a.b = localSavePath;
                }
                this.a.c = selectedVideo.getTitle();
                this.a.a = selectedVideo.getSourceUrl();
            }
            ClarityUrlList clarityList = bdVideoSeries.getClarityList();
            if (clarityList != null && clarityList.size() > 0) {
                this.a.b = clarityList.getDefaultUrl();
            } else if (selectedVideo != null) {
                this.a.b = selectedVideo.getPlayUrl();
            }
            this.a.e = bdVideoSeries.getDuration();
            if (!s1()) {
                e1(bdVideoSeries);
            }
        }
    }

    public void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BdNetUtils.i(m(), h1());
        }
    }

    @Override // com.baidu.tieba.bu0
    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            w1();
            super.L0();
            this.A.cancel();
        }
    }

    @Override // com.baidu.tieba.ou0, com.baidu.tieba.bu0
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.m = new av0();
        }
    }

    @Override // com.baidu.tieba.ou0, com.baidu.tieba.bu0
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            au0.e(false);
            oo0.a.a().a();
            S0();
        }
    }

    public int f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.H;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ou0, com.baidu.tieba.bu0
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            w1();
            super.g0();
            this.A.cancel();
            O0();
            this.M = null;
            this.N = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ou0, com.baidu.tieba.bu0
    @NonNull
    /* renamed from: g1 */
    public av0 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return (av0) this.m;
        }
        return (av0) invokeV.objValue;
    }

    public String h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            float i1 = i1();
            if (i1 <= 0.0f) {
                return "";
            }
            return new DecimalFormat("#.#").format(i1);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bu0
    @Nullable
    public pz0 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            w1();
            return super.k();
        }
        return (pz0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bu0
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.l();
            this.A.start();
            System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.bu0
    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.l0();
            this.A.start();
        }
    }

    public int l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.J;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bu0
    @NonNull
    /* renamed from: m1 */
    public u11 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.L == null) {
                this.L = new u11();
            }
            return this.L;
        }
        return (u11) invokeV.objValue;
    }

    @NonNull
    public IVideoUpdateStrategy n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (this.K == null) {
                this.K = new t11();
            }
            return this.K;
        }
        return (IVideoUpdateStrategy) invokeV.objValue;
    }

    @Nullable
    public BdVideoSeries o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.I;
        }
        return (BdVideoSeries) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bu0, com.baidu.tieba.dz0
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onCompletion();
            y().p(C(), p(), r());
            this.A.cancel();
        }
    }

    @Override // com.baidu.tieba.bu0, com.baidu.tieba.dz0
    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onSeekComplete();
            this.A.start();
        }
    }

    public final boolean q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (r1() && !ru0.b()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            BdVideoSeries bdVideoSeries = this.I;
            if (bdVideoSeries != null) {
                return bdVideoSeries.isInteractVideo();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            x1(true, this.I);
        }
    }

    public void G1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && BdNetUtils.c()) {
            String a = l71.a().a(str);
            if (!TextUtils.isEmpty(a) && !TextUtils.equals(a, this.a.b)) {
                this.a.b = a;
                t0(true);
            }
        }
    }

    public final boolean t1(BdVideoSeries bdVideoSeries) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, bdVideoSeries)) == null) {
            if (s1() && bdVideoSeries != null && !q1() && D() > 0 && bdVideoSeries.getPositionMs() != D()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.bu0
    public void H0(@Nullable Context context, @Nullable pz0 pz0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, pz0Var) == null) {
            super.H0(context, pz0Var);
            ov0.a(this);
        }
    }

    public void v1(boolean z, @NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048621, this, z, bdVideoSeries) == null) && s1() && !q1()) {
            y1("plugin_event_load_player_history", z, bdVideoSeries);
        }
    }

    public void x1(boolean z, @Nullable BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048623, this, z, bdVideoSeries) != null) || t1(bdVideoSeries)) {
            return;
        }
        E1(bdVideoSeries);
        y1("plugin_event_save_player_history", z, bdVideoSeries);
    }

    @Override // com.baidu.tieba.bu0
    public void K0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || TextUtils.isEmpty(this.a.b)) {
            return;
        }
        if (BdNetUtils.e()) {
            l();
        } else if (BdNetUtils.h()) {
            if (n1().i() != 0) {
                l();
            }
        } else if (BdNetUtils.d()) {
            if (n1().i() == 2) {
                l();
                D1();
                return;
            }
            q().g();
        }
    }

    public float i1() {
        InterceptResult invokeV;
        ClarityUrlList clarityList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            BdVideoSeries bdVideoSeries = this.I;
            if (bdVideoSeries == null || (clarityList = bdVideoSeries.getClarityList()) == null || clarityList.size() <= 0) {
                return 0.0f;
            }
            if (Y() && r() > 0) {
                return (1.0f - ((C() * 1.0f) / r())) * clarityList.getCurrentClarityUrl().k();
            }
            return clarityList.getCurrentClarityUrl().k();
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.ou0
    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.A = new ix0(this);
            fx0 fx0Var = new fx0(au0.b(), 3);
            this.B = fx0Var;
            if (fx0Var.canDetectOrientation()) {
                this.E = true;
                this.B.disable();
                this.B.g(new ou0.a(this));
            }
            this.C = new ex0(this);
        }
    }

    public final void e1(BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bdVideoSeries) == null) {
            try {
                this.a.d = 0;
                this.a.e = 0;
                if (bdVideoSeries.getSelectedVideo() != null) {
                    if (!TextUtils.isEmpty(bdVideoSeries.getSelectedVideo().getCurrentLength())) {
                        this.a.d = b21.c(bdVideoSeries.getSelectedVideo().getCurrentLength());
                    }
                    if (!TextUtils.isEmpty(bdVideoSeries.getSelectedVideo().getTotalLength())) {
                        this.a.e = b21.c(bdVideoSeries.getSelectedVideo().getTotalLength());
                    }
                }
                if (this.a.e < 0 || this.a.d < 0 || this.a.d > this.a.e) {
                    this.a.e = 0;
                    this.a.d = 0;
                }
            } catch (Exception e) {
                f21.f("applyPosition(" + System.identityHashCode(bdVideoSeries) + SmallTailInfo.EMOTION_SUFFIX, e);
            }
        }
    }

    @Override // com.baidu.tieba.bu0, com.baidu.tieba.dz0
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048613, this, i, i2, obj)) == null) {
            this.A.cancel();
            w1();
            return super.onError(i, i2, obj);
        }
        return invokeIIL.booleanValue;
    }

    public final void y1(@NonNull String str, boolean z, @NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{str, Boolean.valueOf(z), bdVideoSeries}) == null) {
            vw0 w = ow0.w(str, z ? 1 : 0);
            w.n(1, bdVideoSeries);
            q0(w);
        }
    }
}
