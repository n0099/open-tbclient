package com.baidu.tieba;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.fk6;
import com.baidu.tieba.sa8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ak6 extends p16 implements bk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fk6 A;
    public int B;
    public gk6 C;
    public kb8 D;
    public kb8 E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public Animation J;
    public Animation K;
    public ScaleAnimation L;
    public boolean M;
    public boolean N;
    public FrameLayout i;
    public FrameLayout j;
    public TextView k;
    public TextView l;
    public FrameLayout m;
    public TextView n;
    public TextView o;
    public HeadImageView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public ImageView u;
    public ImageView v;
    public LinearLayout w;
    public LinearLayout x;
    public sa8 y;
    public TbPageContext z;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p16
    /* renamed from: C */
    public void l(fk6 fk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fk6Var) == null) {
        }
    }

    @Override // com.baidu.tieba.p16
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? R.layout.obfuscated_res_0x7f0d01c1 : invokeV.intValue;
    }

    /* loaded from: classes3.dex */
    public class a implements sa8.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ak6 a;

        public a(ak6 ak6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ak6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ak6Var;
        }

        @Override // com.baidu.tieba.sa8.t
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.y.R0()) {
                this.a.l.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.sa8.t
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.y.R0()) {
                    this.a.l.setVisibility(8);
                }
                if (this.a.I) {
                    this.a.y.T1();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements sa8.c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ak6 a;

        public b(ak6 ak6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ak6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ak6Var;
        }

        @Override // com.baidu.tieba.sa8.c0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.setVisibility(8);
                ak6 ak6Var = this.a;
                ak6Var.onClick(ak6Var.i);
            }
        }

        @Override // com.baidu.tieba.sa8.c0
        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.I = false;
                this.a.l.setVisibility(8);
                ak6 ak6Var = this.a;
                if (ak6Var.M) {
                    str = "1";
                } else {
                    str = "2";
                }
                ak6Var.K(str);
                ak6 ak6Var2 = this.a;
                ak6Var2.onClick(ak6Var2.j);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements sa8.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ak6 a;

        public c(ak6 ak6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ak6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ak6Var;
        }

        @Override // com.baidu.tieba.sa8.w
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.z.showToast(this.a.n.getText().toString());
                    ak6 ak6Var = this.a;
                    sa8 sa8Var = ak6Var.y;
                    fk6 fk6Var = ak6Var.A;
                    sa8Var.M1(fk6Var.n.d, fk6Var.b);
                    this.a.l.setVisibility(8);
                    this.a.K("2");
                } else {
                    this.a.m.setVisibility(0);
                }
                ak6 ak6Var2 = this.a;
                ak6Var2.onClick(ak6Var2.j);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements sa8.u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ak6 a;

        public d(ak6 ak6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ak6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ak6Var;
        }

        @Override // com.baidu.tieba.sa8.u
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.y.R0()) {
                    this.a.k.setVisibility(0);
                } else if (z) {
                    if (this.a.k.getVisibility() == 0) {
                        this.a.k.setVisibility(8);
                        ak6 ak6Var = this.a;
                        ak6Var.k.startAnimation(ak6Var.J);
                    }
                } else if (this.a.k.getVisibility() == 8) {
                    this.a.k.setVisibility(0);
                    ak6 ak6Var2 = this.a;
                    ak6Var2.k.startAnimation(ak6Var2.K);
                }
            }
        }

        @Override // com.baidu.tieba.sa8.u
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!this.a.y.R0()) {
                    this.a.k.setVisibility(0);
                } else if (this.a.k.getVisibility() == 0) {
                    this.a.k.setVisibility(8);
                    ak6 ak6Var = this.a;
                    ak6Var.k.startAnimation(ak6Var.J);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zj6 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ak6 c;

        public e(ak6 ak6Var, zj6 zj6Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ak6Var, zj6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ak6Var;
            this.a = zj6Var;
            this.b = i;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.H) {
                    this.c.I = true;
                    this.c.G = false;
                }
                if (this.a != null && !this.c.H) {
                    this.a.a(this.b);
                    this.c.y.X0();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zj6 a;
        public final /* synthetic */ ak6 b;

        public f(ak6 ak6Var, zj6 zj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ak6Var, zj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ak6Var;
            this.a = zj6Var;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, obj)) == null) {
                fk6 fk6Var = this.b.A;
                if (fk6Var != null && fk6Var.n != null) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", this.b.A.n.d);
                }
                zj6 zj6Var = this.a;
                if (zj6Var != null) {
                    zj6Var.cancel();
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements sa8.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ak6 a;

        public g(ak6 ak6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ak6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ak6Var;
        }

        @Override // com.baidu.tieba.sa8.z
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak6(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.G = true;
        this.N = z;
        View k = k();
        this.z = tbPageContext;
        this.i = (FrameLayout) k.findViewById(R.id.obfuscated_res_0x7f0924f4);
        FrameLayout frameLayout = (FrameLayout) k.findViewById(R.id.obfuscated_res_0x7f092500);
        this.j = frameLayout;
        sa8 sa8Var = new sa8(tbPageContext, frameLayout, false);
        this.y = sa8Var;
        sa8Var.z1("2005");
        this.k = (TextView) k.findViewById(R.id.obfuscated_res_0x7f092203);
        this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090869);
        this.m = (FrameLayout) k.findViewById(R.id.obfuscated_res_0x7f091536);
        this.n = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091538);
        this.o = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091537);
        this.p = (HeadImageView) k.findViewById(R.id.obfuscated_res_0x7f092491);
        this.q = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0924a1);
        this.r = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0902d4);
        this.w = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f092191);
        this.x = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f090161);
        this.s = (TextView) k.findViewById(R.id.obfuscated_res_0x7f092194);
        this.t = (TextView) k.findViewById(R.id.obfuscated_res_0x7f092199);
        this.u = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f092193);
        this.v = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f092198);
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        k.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.B = fj.k(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.height = (int) (this.B * 0.5625f);
        this.i.setLayoutParams(layoutParams);
        this.p.setIsRound(true);
        this.C = new gk6(this.z, this);
        this.J = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.obfuscated_res_0x7f010034);
        this.K = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.obfuscated_res_0x7f01002b);
    }

    public boolean G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return this.y.b1(i);
        }
        return invokeI.booleanValue;
    }

    public void N(fk6 fk6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, fk6Var) != null) || fk6Var == null) {
            return;
        }
        SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0106);
        this.u.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
        this.s.setText(StringHelper.numFormatOverWan(fk6Var.d));
    }

    public String Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (str.indexOf(".") > 0) {
                return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bk6
    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.z.showToast(str);
        }
    }

    @Override // com.baidu.tieba.bk6
    public void j(boolean z) {
        fk6 fk6Var;
        fk6.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048596, this, z) == null) && (fk6Var = this.A) != null && (bVar = fk6Var.m) != null) {
            bVar.e = z;
            L(fk6Var);
        }
    }

    public final Animation A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.L == null) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
                this.L = scaleAnimation;
                scaleAnimation.setDuration(200L);
            }
            return this.L;
        }
        return (Animation) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bk6
    public void i() {
        fk6 fk6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || (fk6Var = this.A) == null) {
            return;
        }
        boolean z = !fk6Var.h;
        fk6Var.h = z;
        if (z) {
            fk6Var.e++;
        } else {
            fk6Var.e--;
        }
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.startAnimation(A());
        }
        O(this.A);
    }

    public final void B(fk6 fk6Var, int i, zj6 zj6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fk6Var, i, zj6Var) == null) && fk6Var != null && fk6Var.n != null) {
            this.y.T1();
            this.y.j1(true);
            this.y.n1(new a(this));
            this.y.u1(new b(this));
            this.y.p1(new c(this));
            this.y.i1(false);
            kb8 kb8Var = new kb8();
            this.D = kb8Var;
            kb8Var.c = fk6Var.b;
            kb8Var.d = fk6Var.a;
            kb8Var.e = TbadkCoreApplication.getCurrentAccount();
            kb8 kb8Var2 = new kb8();
            this.E = kb8Var2;
            kb8Var2.c = fk6Var.b;
            kb8Var2.d = fk6Var.a;
            kb8Var2.e = TbadkCoreApplication.getCurrentAccount();
            if (this.N) {
                StatisticItem statisticItem = new StatisticItem("c12590");
                statisticItem.param("tid", fk6Var.b);
                statisticItem.param("nid", fk6Var.c);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, fk6Var.c());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", fk6Var.a);
                statisticItem.param("obj_locate", i);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(statisticItem);
                kb8 kb8Var3 = this.D;
                kb8Var3.g = "auto_midpage";
                kb8Var3.a = "13";
                kb8Var3.i = "1";
                kb8 kb8Var4 = this.E;
                kb8Var4.g = "auto_midpage";
                kb8Var4.a = "auto_midpage";
                kb8Var4.i = "1";
            } else {
                kb8 kb8Var5 = this.D;
                kb8Var5.i = "frs_bavideotab";
                kb8Var5.a = "12";
                kb8 kb8Var6 = this.E;
                kb8Var6.i = "frs_bavideotab";
                kb8Var6.a = "frs_bavideotab";
            }
            fk6.c cVar = fk6Var.n;
            if (cVar != null) {
                kb8 kb8Var7 = this.D;
                String str = cVar.c;
                kb8Var7.m = str;
                this.E.m = str;
            }
            this.y.H0().setVideoStatData(this.D);
            this.y.q0();
            this.y.o1(new d(this));
            this.y.v1(new e(this, zj6Var, i));
            this.y.w1(new f(this, zj6Var));
            this.y.D1(fk6Var.n.j);
            this.y.H1(fk6Var.n.d, fk6Var.b);
            this.y.G1(fk6Var.l);
            this.y.r1(new g(this));
            this.y.X0();
            this.y.J1();
            if (fk6Var.s) {
                onClick(this.j);
                this.I = false;
                this.y.R1(fk6Var.n.d, fk6Var.b, null, new Object[0]);
            }
            this.I = false;
        }
    }

    public void D(fk6 fk6Var, int i, zj6 zj6Var) {
        String format;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048579, this, fk6Var, i, zj6Var) == null) && fk6Var != null && fk6Var.n != null) {
            this.A = fk6Var;
            this.M = fk6Var.s;
            this.k.setVisibility(0);
            this.k.setText(fk6Var.l);
            this.l.setVisibility(0);
            this.l.setText(StringHelper.stringForVideoTime(fk6Var.n.e * 1000));
            long j = fk6Var.n.h;
            if (j == 0) {
                format = this.z.getString(R.string.obfuscated_res_0x7f0f155c);
            } else {
                format = String.format(this.z.getString(R.string.obfuscated_res_0x7f0f155b), Q(String.format("%.1f", Float.valueOf(((float) j) / 1048576.0f))));
            }
            this.n.setText(format);
            this.m.setVisibility(8);
            B(fk6Var, i, zj6Var);
            M(fk6Var);
            m(this.z, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void E(Configuration configuration) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, configuration) == null) && this.y != null && this.j != null && (tbPageContext = this.z) != null && tbPageContext.getPageActivity() != null && this.z.getPageActivity().getWindow() != null && (this.z.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.z.getPageActivity().getWindow().getDecorView();
            if (this.G) {
                this.y.g1();
            }
            if (configuration.orientation == 2) {
                this.H = true;
                if (this.j.getParent() != null) {
                    if (this.j.getParent() == frameLayout) {
                        frameLayout.removeView(this.j);
                    } else {
                        ViewParent parent = this.j.getParent();
                        FrameLayout frameLayout2 = this.i;
                        if (parent == frameLayout2) {
                            frameLayout2.removeView(this.j);
                        }
                    }
                }
                if (this.j.getParent() != null) {
                    return;
                }
                frameLayout.addView(this.j);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.j.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.j.setLayoutParams(layoutParams);
            } else {
                this.H = false;
                if (this.j.getParent() != null) {
                    if (this.j.getParent() == frameLayout) {
                        frameLayout.removeView(this.j);
                    } else {
                        ViewParent parent2 = this.j.getParent();
                        FrameLayout frameLayout3 = this.i;
                        if (parent2 == frameLayout3) {
                            frameLayout3.removeView(this.j);
                        }
                    }
                }
                if (this.j.getParent() != null) {
                    return;
                }
                this.i.addView(this.j, 0);
                int i = this.B;
                this.j.setLayoutParams(new FrameLayout.LayoutParams(i, (int) (i * 0.5625f)));
                this.y.q0();
                this.G = true;
            }
            this.y.S0(this.z, configuration);
            this.l.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        fk6.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            if (e() != null) {
                view2.setTag(this);
                e().a(view2, this.A);
            }
            if (view2 != this.p && view2 != this.q) {
                if (view2 != this.w && view2 != this.k && view2 != k()) {
                    if (view2 == this.o) {
                        fk6 fk6Var = this.A;
                        if (fk6Var != null && fk6Var.n != null) {
                            this.m.setVisibility(8);
                            this.y.f1();
                            sa8 sa8Var = this.y;
                            fk6 fk6Var2 = this.A;
                            sa8Var.M1(fk6Var2.n.d, fk6Var2.b);
                            K("2");
                            return;
                        }
                        return;
                    } else if (view2 == this.r) {
                        fk6 fk6Var3 = this.A;
                        if (!fk6Var3.m.e) {
                            this.C.c(fk6Var3);
                            return;
                        }
                        return;
                    } else if (view2 == this.x) {
                        tc5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                        if (currentVisiblePageExtra != null) {
                            this.A.i = currentVisiblePageExtra.a();
                        }
                        this.C.d(this.A);
                        return;
                    } else {
                        return;
                    }
                } else if (this.A == null) {
                    return;
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.c);
                    pbActivityConfig.createNormalCfg(this.A.b, null, null);
                    if (!this.N) {
                        pbActivityConfig.setVideo_source("bavideotab");
                    } else {
                        pbActivityConfig.setVideo_source("auto_midpage");
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
                    return;
                }
            }
            boolean z = false;
            fk6 fk6Var4 = this.A;
            if (fk6Var4 != null && (bVar = fk6Var4.m) != null && !TextUtils.isEmpty(bVar.a)) {
                if (TbadkCoreApplication.isLogin() && this.A.m.a.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.z.getPageActivity()).createNormalConfig(eh.g(this.A.m.a, 0L), z, this.A.m.f)));
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            I();
            gk6 gk6Var = this.C;
            if (gk6Var != null) {
                gk6Var.b();
            }
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !isPlaying()) {
            return;
        }
        this.y.T0();
    }

    public void I() {
        sa8 sa8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (sa8Var = this.y) != null) {
            sa8Var.v0();
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.m.setVisibility(8);
            this.y.T1();
            TextView textView = this.k;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.l;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        }
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.y.R0();
        }
        return invokeV.booleanValue;
    }

    public final void K(String str) {
        fk6 fk6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && (fk6Var = this.A) != null && fk6Var.n != null) {
            if ("1".equals(str) || "2".equals(str)) {
                za8.e(this.A.n.c, "", str, this.E, this.y.H0().getPcdnState());
            }
        }
    }

    public void L(fk6 fk6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, fk6Var) == null) && fk6Var != null && fk6Var.m != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(fk6Var.m.a) && TbadkCoreApplication.getCurrentAccount().equals(fk6Var.m.a)) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
            }
            if (fk6Var.m.e) {
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
                this.r.setCompoundDrawables(null, null, null, null);
                this.r.setText(this.z.getString(R.string.obfuscated_res_0x7f0f0fef));
                return;
            }
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
            Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, fj.f(this.c, R.dimen.obfuscated_res_0x7f0701d5), fj.f(this.c, R.dimen.obfuscated_res_0x7f0701d5));
            this.r.setCompoundDrawables(drawable, null, null, null);
            this.r.setText(this.z.getString(R.string.obfuscated_res_0x7f0f02b0));
        }
    }

    public void M(fk6 fk6Var) {
        fk6.b bVar;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, fk6Var) == null) && fk6Var != null && (bVar = fk6Var.m) != null) {
            TextView textView = this.q;
            if (TextUtils.isEmpty(bVar.c)) {
                str = fk6Var.m.b;
            } else {
                str = fk6Var.m.c;
            }
            textView.setText(str);
            this.p.L(fk6Var.m.d, 12, false);
            this.p.setShowV(fk6Var.m.f);
            this.p.setIsBigV(fk6Var.m.f);
            L(fk6Var);
            O(fk6Var);
            N(fk6Var);
        }
    }

    public void O(fk6 fk6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, fk6Var) != null) || fk6Var == null) {
            return;
        }
        if (fk6Var.h) {
            this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_s));
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0301);
        } else {
            this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_n));
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0106);
        }
        this.t.setText(StringHelper.numFormatOverWan(fk6Var.e));
    }

    @Override // com.baidu.tieba.p16
    public void m(TbPageContext tbPageContext, int i) {
        fk6.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, tbPageContext, i) == null) {
            if (this.a != i) {
                zp4 layoutMode = tbPageContext.getLayoutMode();
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                layoutMode.l(z);
                tbPageContext.getLayoutMode().k(k());
                SkinManager.setBackgroundColor(k(), R.color.CAM_X0201);
                fk6 fk6Var = this.A;
                if (fk6Var != null && (bVar = fk6Var.m) != null) {
                    if (bVar.e) {
                        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
                        this.r.setCompoundDrawables(null, null, null, null);
                    } else {
                        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
                        Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
                        drawable.setBounds(0, 0, fj.f(this.c, R.dimen.obfuscated_res_0x7f0701d5), fj.f(this.c, R.dimen.obfuscated_res_0x7f0701d5));
                        this.r.setCompoundDrawables(drawable, null, null, null);
                    }
                }
                fk6 fk6Var2 = this.A;
                if (fk6Var2 != null) {
                    if (fk6Var2.h) {
                        this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_s));
                        SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0301);
                    } else {
                        this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_n));
                        SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0106);
                    }
                }
                SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0106);
                this.u.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
            }
            this.a = i;
        }
    }
}
