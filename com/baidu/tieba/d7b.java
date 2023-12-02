package com.baidu.tieba;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.p05;
import com.baidu.tieba.video.editvideo.EditVideoActivity;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class d7b extends BdBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public NavigationBar b;
    public MaskVideoView c;
    public l6b d;
    public Resources e;
    public n05 f;
    public f7b g;
    public h7b h;
    public g7b i;
    public FrameLayout j;
    public FragmentTabWidget k;
    public int l;
    public MediaPlayer m;
    public boolean n;
    public fp9 o;
    public p05.f p;

    /* loaded from: classes5.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d7b a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.g.N();
                }
            }
        }

        /* renamed from: com.baidu.tieba.d7b$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0250b implements MediaPlayer.OnInfoListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public C0250b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i, i2)) == null) {
                    if (i == 3) {
                        d7b d7bVar = this.a.a;
                        if (d7bVar.l == 0) {
                            d7bVar.c.pause();
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return invokeLII.booleanValue;
            }
        }

        public b(d7b d7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d7bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d7bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0052  */
        @Override // android.media.MediaPlayer.OnPreparedListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, mediaPlayer) != null) {
                return;
            }
            this.a.m = mediaPlayer;
            if (!this.a.n) {
                d7b d7bVar = this.a;
                if (d7bVar.l != 0) {
                    d7bVar.m.setVolume(1.0f, 1.0f);
                    SafeHandler.getInst().postDelayed(new a(this), 200L);
                    if (Build.VERSION.SDK_INT < 17) {
                        this.a.c.start();
                        mediaPlayer.setOnInfoListener(new C0250b(this));
                        return;
                    }
                    this.a.c.seekTo(this.a.g.getCurrentPosition());
                    return;
                }
            }
            this.a.m.setVolume(0.0f, 0.0f);
            SafeHandler.getInst().postDelayed(new a(this), 200L);
            if (Build.VERSION.SDK_INT < 17) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements FragmentTabWidget.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d7b a;

        public a(d7b d7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d7bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d7bVar;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
        public void onTabSelectionChanged(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                d7b d7bVar = this.a;
                if (i == d7bVar.l) {
                    return;
                }
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            d7bVar.h.O().setVisibility(0);
                            this.a.g.D().setVisibility(8);
                            this.a.i.A().setVisibility(8);
                            this.a.g.L(false);
                            this.a.h.V(true);
                            this.a.i.G(false);
                        }
                    } else {
                        d7bVar.i.A().setVisibility(0);
                        this.a.h.O().setVisibility(8);
                        this.a.g.D().setVisibility(8);
                        this.a.g.L(false);
                        if (TextUtils.isEmpty(this.a.h.N())) {
                            this.a.h.V(false);
                        } else {
                            this.a.h.V(true);
                        }
                        this.a.i.G(true);
                    }
                } else {
                    d7bVar.g.D().setVisibility(0);
                    this.a.h.O().setVisibility(8);
                    this.a.i.A().setVisibility(8);
                    this.a.g.L(true);
                    this.a.h.V(false);
                    this.a.i.G(false);
                }
                d7b d7bVar2 = this.a;
                d7bVar2.l = i;
                d7bVar2.k.setCurrentTab(this.a.l, true, true);
                this.a.s0();
                this.a.X();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d7b a;

        public c(d7b d7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d7bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d7bVar;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                d7b d7bVar = this.a;
                if (d7bVar.l != 0) {
                    d7bVar.f0();
                    this.a.h.a0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d7b a;

        public d(d7b d7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d7bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d7bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.r0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d7b a;

        public e(d7b d7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d7bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d7bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.g.F();
                if (this.a.d != null) {
                    this.a.d.onNext();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d7b a;

        public f(d7b d7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d7bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d7bVar;
        }

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 p05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                if (i != 0) {
                    if (i == 1 && this.a.d != null) {
                        this.a.d.d();
                    }
                } else if (this.a.d != null) {
                    this.a.d.f();
                }
                if (this.a.f != null && this.a.f.isShowing() && this.a.getPageContext() != null) {
                    this.a.f.dismiss();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d7b(BdPageContext bdPageContext, l6b l6bVar, View view2, fp9 fp9Var) {
        super(bdPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext, l6bVar, view2, fp9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 0;
        this.p = new f(this);
        this.d = l6bVar;
        this.a = view2;
        this.o = fp9Var;
        this.e = view2.getResources();
        this.g = new f7b(this.mContext, this);
        this.h = new h7b(this.mContext, this, this.o);
        this.i = new g7b(this.mContext, this);
        this.g.G(this.a);
        this.h.P(this.a);
        this.i.C(this.a);
        T();
        s0();
    }

    public Bitmap J(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmap)) == null) {
            return this.g.A(bitmap);
        }
        return (Bitmap) invokeL.objValue;
    }

    public y6b M(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (this.i != null && !rd.isEmpty(str)) {
                return this.i.z(str);
            }
            return null;
        }
        return (y6b) invokeL.objValue;
    }

    public void i0(q6b q6bVar) {
        g7b g7bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, q6bVar) == null) && (g7bVar = this.i) != null) {
            g7bVar.I(q6bVar);
        }
    }

    public void j0(MaskVideoView.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, fVar) == null) && fVar != null && Q() != null) {
            Q().setGenMaskCoverListener(fVar);
        }
    }

    public void k0(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, list) == null) {
            this.h.c0(list);
        }
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.n = z;
            if (this.m == null) {
                return;
            }
            f0();
        }
    }

    public void m0(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, list) == null) {
            this.g.P(list);
        }
    }

    public void n0(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, intent) == null) {
            this.h.e0(intent);
        }
    }

    public void p0(y6b y6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, y6bVar) == null) {
            MaskVideoView maskVideoView = this.c;
            if (maskVideoView != null) {
                maskVideoView.setFilter(y6bVar);
            }
            g7b g7bVar = this.i;
            if (g7bVar != null) {
                g7bVar.H(y6bVar);
            }
        }
    }

    public void q0(boolean z) {
        h7b h7bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048610, this, z) == null) && (h7bVar = this.h) != null) {
            h7bVar.d0(z);
            l0(!z);
        }
    }

    public void Z(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) {
            this.h.S(str, str2);
        }
    }

    public void o0(String str, String str2) {
        h7b h7bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048608, this, str, str2) == null) && (h7bVar = this.h) != null) {
            h7bVar.f0(str, str2);
        }
    }

    public void K() {
        l6b l6bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (l6bVar = this.d) != null) {
            l6bVar.l();
        }
    }

    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h.M();
        }
        return (String) invokeV.objValue;
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h.N();
        }
        return (String) invokeV.objValue;
    }

    public View O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g.E();
        }
        return (String) invokeV.objValue;
    }

    public MaskVideoView Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (MaskVideoView) invokeV.objValue;
    }

    public final boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public void W() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (maskVideoView = this.c) != null) {
            maskVideoView.m(this.g.getCurrentPosition());
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.l == 0) {
                c0();
                g0();
                return;
            }
            f0();
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            c0();
            this.g.J();
            this.h.T();
            this.i.E();
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.c.onResume();
            if (this.l != 0) {
                this.c.r();
            }
            this.g.K();
            this.h.U();
            this.i.F();
        }
    }

    public void c0() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (maskVideoView = this.c) != null) {
            maskVideoView.p();
        }
    }

    public void d0() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (maskVideoView = this.c) != null) {
            maskVideoView.onPause();
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            f7b f7bVar = this.g;
            if (f7bVar != null) {
                f7bVar.M();
            }
            MaskVideoView maskVideoView = this.c;
            if (maskVideoView != null) {
                maskVideoView.stopPlayback();
            }
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            c0();
            MediaPlayer mediaPlayer = this.m;
            if (mediaPlayer != null) {
                if (this.n) {
                    mediaPlayer.setVolume(0.0f, 0.0f);
                } else {
                    mediaPlayer.setVolume(1.0f, 1.0f);
                }
            }
            this.c.start();
            this.c.seekTo(0);
        }
    }

    public void g0() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (maskVideoView = this.c) != null) {
            maskVideoView.seekTo(this.g.getCurrentPosition());
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            MaskVideoView maskVideoView = this.c;
            if (maskVideoView == null) {
                return 0;
            }
            return maskVideoView.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public final void s0() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c12424");
            if (this.l == 0) {
                i = 1;
            } else {
                i = 3;
            }
            statisticItem.param("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.b.setCenterTextTitle(this.e.getString(R.string.obfuscated_res_0x7f0f1392));
            this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
            SkinManager.setViewTextColor(this.b.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.e.getString(R.string.obfuscated_res_0x7f0f1393), new e(this)), (int) R.color.CAM_X0106);
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String[] stringArray = this.e.getStringArray(R.array.obfuscated_res_0x7f030013);
            for (int i = 0; i < stringArray.length; i++) {
                FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
                fragmentTabIndicator.setText(stringArray[i]);
                fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
                fragmentTabIndicator.setTextSize(0, this.e.getDimension(R.dimen.obfuscated_res_0x7f07045b));
                this.k.addView(fragmentTabIndicator, i);
            }
            if (!U() && this.k.getChildAt(1) != null) {
                this.k.getChildAt(1).setVisibility(8);
            }
            this.k.setDiverColor(this.e.getColor(R.color.CAM_X0105));
            this.k.setCurrentTab(this.l, true, false);
            this.k.setBackGroundDrawableResId(R.color.CAM_X0201);
            this.k.setDviderRectWidth(BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.obfuscated_res_0x7f070258));
            this.k.setTabSelectionListener(new a(this));
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b = (NavigationBar) this.a.findViewById(R.id.navigation_bar);
            MaskVideoView maskVideoView = (MaskVideoView) this.a.findViewById(R.id.video_view);
            this.c = maskVideoView;
            maskVideoView.setPreserveEGLContextOnPause(true);
            this.c.setZOrderMediaOverlay(true);
            this.c.setPostMonitorManager(this.o);
            FrameLayout frameLayout = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0909c7);
            this.j = frameLayout;
            frameLayout.addView(this.g.D());
            this.k = (FragmentTabWidget) this.a.findViewById(R.id.obfuscated_res_0x7f09247b);
            R();
            S();
            this.j.addView(this.h.O());
            this.j.addView(this.i.A());
            this.h.O().setVisibility(8);
            this.i.A().setVisibility(8);
        }
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && StringHelper.equals(((EditVideoActivity) this.mContext.getPageActivity()).R0(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
                this.d.d();
                return;
            }
            if (this.f == null) {
                String[] strArr = {getPageContext().getString(R.string.obfuscated_res_0x7f0f1328), getPageContext().getString(R.string.not_save)};
                n05 n05Var = new n05(getPageContext());
                this.f = n05Var;
                n05Var.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
                this.f.i(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.p);
            }
            this.f.l();
        }
    }

    public void Y(BdPageContext bdPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, bdPageContext, i) == null) {
            this.b.onChangeSkinType(bdPageContext, i);
            this.k.j(i);
            this.k.setDiverColor(SkinManager.getColor(i, (int) R.color.CAM_X0105));
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            f7b f7bVar = this.g;
            if (f7bVar != null) {
                f7bVar.I(bdPageContext, i);
            }
            h7b h7bVar = this.h;
            if (h7bVar != null) {
                h7bVar.R(bdPageContext, i);
            }
        }
    }

    public void h0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048601, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.g.O(str);
            this.c.setVideoPath(str);
            this.c.setOnPreparedListener(new b(this));
            this.c.setOnCompletionListener(new c(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
