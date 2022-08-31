package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishManager;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.view.FrsAnomalyImg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
/* loaded from: classes4.dex */
public abstract class gz8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TbPageContext b;
    public mz8 c;
    public View.OnClickListener d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gz8 a;

        public a(gz8 gz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gz8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            mz8 mz8Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (mz8Var = this.a.c) == null) {
                return;
            }
            if (mz8Var.g() != 0) {
                UtilHelper.setNavigationBarBackground(this.a.b.getPageActivity(), this.a.c.g());
            }
            this.a.c.m(true);
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends gz8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View A;
        public View B;
        public View C;
        public int D;
        public LinearLayout E;
        public ImageView F;
        public TextView G;
        public View H;
        public View e;
        public LinearLayout f;
        public LinearLayout g;
        public LinearLayout h;
        public LinearLayout i;
        public LinearLayout j;
        public LinearLayout k;
        public LinearLayout l;
        public ImageView m;
        public ImageView n;
        public ImageView o;
        public ImageView p;
        public ImageView q;
        public ImageView r;
        public TextView s;
        public TextView t;
        public TextView u;
        public TextView v;
        public TextView w;
        public TextView x;
        public View y;
        public View z;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
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

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                mz8 mz8Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (mz8Var = this.a.c) == null) {
                    return;
                }
                mz8Var.r(mz8Var.k());
            }
        }

        /* renamed from: com.baidu.tieba.gz8$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0273b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public View$OnClickListenerC0273b(b bVar) {
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

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                mz8 mz8Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (mz8Var = this.a.c) == null) {
                    return;
                }
                mz8Var.q();
            }
        }

        /* loaded from: classes4.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public c(b bVar) {
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

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.c == null) {
                    return;
                }
                WorkPublishManager.setObjLocate("");
                this.a.c.v(WorkPublishOpenHelper.OPEN_WORK_PUBLISH_FROM_HOME_VIDEO);
            }
        }

        /* loaded from: classes4.dex */
        public class d implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public d(b bVar) {
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

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                mz8 mz8Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (mz8Var = this.a.c) == null) {
                    return;
                }
                mz8Var.p();
            }
        }

        /* loaded from: classes4.dex */
        public class e implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public e(b bVar) {
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

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                mz8 mz8Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (mz8Var = this.a.c) == null) {
                    return;
                }
                mz8Var.x(mz8Var.k());
            }
        }

        /* loaded from: classes4.dex */
        public class f implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ de5 a;
            public final /* synthetic */ b b;

            public f(b bVar, de5 de5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, de5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = de5Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.n(false);
                    mz8 mz8Var = this.b.c;
                    if (mz8Var != null) {
                        mz8Var.y();
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public class g implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public g(b bVar) {
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

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                mz8 mz8Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (mz8Var = this.a.c) == null) {
                    return;
                }
                mz8Var.w(null, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TbPageContext tbPageContext, mz8 mz8Var) {
            super(tbPageContext, mz8Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, mz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((TbPageContext) objArr2[0], (mz8) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = this.a.findViewById(R.id.obfuscated_res_0x7f092546);
            this.f = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0923f4);
            this.g = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f092162);
            this.m = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f092163);
            this.s = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092164);
            this.h = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f092152);
            this.n = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f092153);
            this.t = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092156);
            this.i = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09216d);
            this.o = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09216e);
            this.u = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092170);
            d();
            this.j = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09211d);
            this.p = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09211e);
            this.v = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09211f);
            this.j.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            this.j.setVisibility(TbSingleton.getInstance().isAuditPackageSwitchOn() ? 0 : 8);
            this.k = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f092177);
            this.q = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f092178);
            this.w = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092179);
            this.l = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09215a);
            this.r = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09215b);
            this.x = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09215c);
            this.y = this.a.findViewById(R.id.obfuscated_res_0x7f0912ed);
            this.z = this.a.findViewById(R.id.obfuscated_res_0x7f0912ee);
            this.A = this.a.findViewById(R.id.obfuscated_res_0x7f0912ef);
            this.B = this.a.findViewById(R.id.obfuscated_res_0x7f0912f0);
            this.C = this.a.findViewById(R.id.obfuscated_res_0x7f0912f1);
            this.B.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            this.s.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0769));
            this.t.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0861));
            this.u.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0862));
            this.v.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0224));
            this.w.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f076b));
            this.x.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f110c));
            this.e.setOnClickListener(this.d);
            this.g.setOnClickListener(new a(this));
            this.h.setOnClickListener(new View$OnClickListenerC0273b(this));
            this.i.setOnClickListener(new c(this));
            this.j.setOnClickListener(new d(this));
            this.k.setOnClickListener(new e(this));
            de5 c2 = de5.c(this.b.getPageActivity());
            c2.h(BadgeDrawable.TOP_END);
            c2.g(-65536);
            c2.m(R.dimen.tbds30, false);
            c2.k(R.dimen.tbds24, true);
            c2.i(R.dimen.tbds9);
            c2.f(false);
            c2.l("HomePageTestViweHolder.sendHelp");
            c2.b(this.x);
            this.l.setOnClickListener(new f(this, c2));
            this.D = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            c(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // com.baidu.tieba.gz8
        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0391, (ViewGroup) null) : (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.gz8
        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                super.c(i);
                SkinManager.setBackgroundColor(this.e, R.color.CAM_X0603);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(this.D).defaultColor(R.color.CAM_X0701).into(this.f);
                this.m.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08080c, WebPManager.ResourceStateType.NORMAL));
                this.n.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080801, WebPManager.ResourceStateType.NORMAL));
                this.o.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080808, WebPManager.ResourceStateType.NORMAL));
                this.F.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080837, WebPManager.ResourceStateType.NORMAL));
                this.p.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080805, WebPManager.ResourceStateType.NORMAL));
                this.q.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080812, WebPManager.ResourceStateType.NORMAL));
                this.r.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08080a, WebPManager.ResourceStateType.NORMAL));
                SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.u, (int) R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.G, (int) R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.x, (int) R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).tlRadius(this.D).trRadius(this.D).into(this.g);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).into(this.h);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).into(this.i);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).into(this.E);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).into(this.j);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).blRadius(this.D).brRadius(this.D).into(this.k);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).blRadius(this.D).brRadius(this.D).into(this.l);
                SkinManager.setBackgroundColor(this.y, R.color.CAM_X0613);
                SkinManager.setBackgroundColor(this.z, R.color.CAM_X0613);
                SkinManager.setBackgroundColor(this.A, R.color.CAM_X0613);
                SkinManager.setBackgroundColor(this.B, R.color.CAM_X0613);
                SkinManager.setBackgroundColor(this.C, R.color.CAM_X0613);
                SkinManager.setBackgroundColor(this.H, R.color.CAM_X0613);
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.E = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f092174);
                this.F = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f092175);
                this.G = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092176);
                this.H = this.a.findViewById(R.id.obfuscated_res_0x7f0912fd);
                e(TbSingleton.getInstance().getVoiceRoomConfig().a());
                this.G.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0864));
                this.E.setOnClickListener(new g(this));
            }
        }

        public final void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                int i = z ? 0 : 8;
                this.E.setVisibility(i);
                this.H.setVisibility(i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends gz8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout A;
        public ImageView B;
        public TextView C;
        public LinearLayout D;
        public ImageView E;
        public TextView F;
        public OvalActionButton G;
        public GridLayout H;
        public TBLottieAnimationView I;
        public View e;
        public View f;
        public LinearLayout g;
        public ImageView h;
        public TextView i;
        public LinearLayout j;
        public ImageView k;
        public TextView l;
        public LinearLayout m;
        public ImageView n;
        public TextView o;
        public LinearLayout p;
        public ImageView q;
        public TextView r;
        public FrsAnomalyImg s;
        public TextView t;
        public LinearLayout u;
        public ImageView v;
        public TextView w;
        public LinearLayout x;
        public ImageView y;
        public TextView z;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                mz8 mz8Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (mz8Var = this.a.c) == null) {
                    return;
                }
                mz8Var.r(mz8Var.k());
            }
        }

        /* loaded from: classes4.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.c == null) {
                    return;
                }
                WorkPublishManager.setObjLocate("");
                this.a.c.v(WorkPublishOpenHelper.OPEN_WORK_PUBLISH_FROM_FRS_VIDEO);
            }
        }

        /* renamed from: com.baidu.tieba.gz8$c$c  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0274c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public View$OnClickListenerC0274c(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                mz8 mz8Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (mz8Var = this.a.c) == null) {
                    return;
                }
                mz8Var.q();
            }
        }

        /* loaded from: classes4.dex */
        public class d implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public d(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                mz8 mz8Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (mz8Var = this.a.c) == null) {
                    return;
                }
                mz8Var.p();
            }
        }

        /* loaded from: classes4.dex */
        public class e implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public e(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                mz8 mz8Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (mz8Var = this.a.c) == null) {
                    return;
                }
                mz8Var.x(mz8Var.k());
            }
        }

        /* loaded from: classes4.dex */
        public class f implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ de5 a;
            public final /* synthetic */ c b;

            public f(c cVar, de5 de5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, de5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = de5Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.n(false);
                    mz8 mz8Var = this.b.c;
                    if (mz8Var != null) {
                        mz8Var.y();
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public class g implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public g(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                mz8 mz8Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (mz8Var = this.a.c) == null) {
                    return;
                }
                mz8Var.t();
            }
        }

        /* loaded from: classes4.dex */
        public class h implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ cz4 a;
            public final /* synthetic */ c b;

            public h(c cVar, cz4 cz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, cz4Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = cz4Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.b.b.getPageActivity(), null, this.a.b(), true)));
                    StatisticItem statisticItem = new StatisticItem("c14500");
                    statisticItem.param("aid", this.a.b());
                    statisticItem.eventStat();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class i implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ mz8 a;
            public final /* synthetic */ c b;

            public i(c cVar, mz8 mz8Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, mz8Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = mz8Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    ForumWriteData h = this.a.h();
                    mz8 mz8Var = this.b.c;
                    if (mz8Var == null || h == null) {
                        return;
                    }
                    mz8Var.w(h.forumId, h.forumName);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TbPageContext tbPageContext, mz8 mz8Var) {
            super(tbPageContext, mz8Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, mz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((TbPageContext) objArr2[0], (mz8) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (tbPageContext == null) {
                return;
            }
            e();
            this.j = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090d90);
            this.k = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090d91);
            this.l = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090d92);
            this.g = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090d99);
            this.h = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090d9a);
            this.i = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090d9b);
            this.m = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090d8d);
            this.n = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090d8e);
            this.o = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090d8f);
            this.p = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090d96);
            this.q = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090d97);
            this.r = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090d98);
            this.p.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            d(mz8Var);
            this.x = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090d9c);
            this.y = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090d9d);
            this.z = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090d9e);
            ((LinearLayout.LayoutParams) this.y.getLayoutParams()).topMargin = TbSingleton.getInstance().isShowStartLiveEntry() ? ((LinearLayout.LayoutParams) this.y.getLayoutParams()).topMargin : 0;
            this.A = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090d83);
            this.B = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090d84);
            this.C = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090d85);
            this.D = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090d93);
            this.E = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090d94);
            this.F = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090d95);
            this.G = (OvalActionButton) this.a.findViewById(R.id.obfuscated_res_0x7f092652);
            mz8 mz8Var2 = this.c;
            if (mz8Var2 != null && "frs".equals(mz8Var2.i())) {
                this.G.setIsCircle(true);
                this.G.setHasShadow(false);
            }
            this.f = this.a.findViewById(R.id.obfuscated_res_0x7f092548);
            this.e = this.a.findViewById(R.id.obfuscated_res_0x7f092547);
            GridLayout gridLayout = (GridLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0923f4);
            this.H = gridLayout;
            gridLayout.setMeasureAllChild(true);
            this.H.setVerNum(2);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.a.findViewById(R.id.obfuscated_res_0x7f0903d1);
            this.I = tBLottieAnimationView;
            tBLottieAnimationView.setSpeed(1.2f);
            a();
            this.e.setOnClickListener(this.d);
            this.e.setClickable(true);
            this.k.setOnClickListener(new a(this));
            this.h.setOnClickListener(new b(this));
            this.n.setOnClickListener(new View$OnClickListenerC0274c(this));
            this.q.setOnClickListener(new d(this));
            this.x.setOnClickListener(new e(this));
            de5 c = de5.c(this.b.getPageActivity());
            c.h(BadgeDrawable.TOP_END);
            c.g(-65536);
            c.m(R.dimen.tbds15, false);
            c.k(R.dimen.tbds15, false);
            c.i(R.dimen.tbds12);
            c.l("NormalViewHolder.sendHelp");
            c.b(this.B);
            this.A.setOnClickListener(new f(this, c));
            this.D.setOnClickListener(new g(this));
        }

        @Override // com.baidu.tieba.gz8
        public void a() {
            int f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                float k = ri.k(this.b.getPageActivity());
                int i2 = (int) (0.13518518f * k);
                f(this.k, i2);
                f(this.h, i2);
                f(this.n, i2);
                f(this.q, i2);
                f(this.v, i2);
                f(this.y, i2);
                f(this.B, i2);
                f(this.E, i2);
                float f3 = (k * 1.0f) / ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
                ViewGroup.LayoutParams layoutParams = this.H.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds423) * f3);
                    this.H.setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams2 = this.s.getLayoutParams();
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).bottomMargin = (int) (ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds932) * f3);
                    this.s.setLayoutParams(layoutParams2);
                }
                ViewGroup.LayoutParams layoutParams3 = this.f.getLayoutParams();
                if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                    if (TbSingleton.getInstance().getVideoEventsConfig() != null && TbSingleton.getInstance().getVideoEventsConfig().d()) {
                        f2 = (int) (ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds1162) * f3);
                        if (f2 <= 0) {
                            f2 = 1162;
                        }
                    } else {
                        f2 = (int) (ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds1023) * f3);
                        if (f2 <= 0) {
                            f2 = 1023;
                        }
                    }
                    ((RelativeLayout.LayoutParams) layoutParams3).height = f2;
                    this.f.setLayoutParams(layoutParams3);
                }
                ViewGroup.LayoutParams layoutParams4 = this.I.getLayoutParams();
                if (layoutParams4 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams4).height = (int) ((ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds800) * f3) - ((ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds135) * f3) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                    this.I.setLayoutParams(layoutParams4);
                }
            }
        }

        @Override // com.baidu.tieba.gz8
        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d015f, (ViewGroup) null) : (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.gz8
        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.G.e(i2);
                SkinManager.setLottieAnimation(this.I, R.raw.bottom_bar_bg);
                SkinManager.setBackgroundResource(this.f, R.drawable.write_tab_background);
                SkinManager.setImageResource(this.h, R.drawable.obfuscated_res_0x7f080809);
                SkinManager.setImageResource(this.k, R.drawable.obfuscated_res_0x7f08080d);
                SkinManager.setImageResource(this.n, R.drawable.obfuscated_res_0x7f080802);
                SkinManager.setImageResource(this.q, R.drawable.obfuscated_res_0x7f080806);
                SkinManager.setImageResource(this.v, R.drawable.obfuscated_res_0x7f080838);
                SkinManager.setImageResource(this.y, R.drawable.obfuscated_res_0x7f080813);
                SkinManager.setImageResource(this.B, R.drawable.obfuscated_res_0x7f08080b);
                SkinManager.setImageResource(this.E, R.drawable.obfuscated_res_0x7f080800);
                SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.C, (int) R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.F, (int) R.color.CAM_X0107);
                ns4 d2 = ns4.d(this.t);
                d2.v(R.color.CAM_X0101);
                d2.A(R.string.F_X01);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0301);
                FrsAnomalyImg frsAnomalyImg = this.s;
                if (frsAnomalyImg != null) {
                    frsAnomalyImg.m();
                }
            }
        }

        public final void d(@NonNull mz8 mz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, mz8Var) == null) {
                this.u = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090d8a);
                this.v = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090d8b);
                this.w = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090d8c);
                boolean a2 = mz8Var.j().a();
                this.u.setVisibility(a2 ? 0 : 8);
                if (a2) {
                    ((LinearLayout.LayoutParams) this.q.getLayoutParams()).topMargin = ri.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X008);
                }
                this.v.setOnClickListener(new i(this, mz8Var));
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.s = (FrsAnomalyImg) this.a.findViewById(R.id.obfuscated_res_0x7f09266b);
                this.t = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0923ca);
                FrsAnomalyImg.b bVar = new FrsAnomalyImg.b();
                bVar.a(40);
                bVar.b(640);
                bVar.c(40);
                bVar.d(18);
                FrsAnomalyImg frsAnomalyImg = this.s;
                frsAnomalyImg.o(33);
                frsAnomalyImg.p(bVar);
                cz4 videoEventsConfig = TbSingleton.getInstance().getVideoEventsConfig();
                if (videoEventsConfig == null) {
                    return;
                }
                this.s.setOnClickListener(new h(this, videoEventsConfig));
                this.t.setVisibility(videoEventsConfig.d() ? 0 : 8);
                this.s.setVisibility(videoEventsConfig.d() ? 0 : 8);
                this.s.setVisible(Boolean.valueOf(videoEventsConfig.d()));
                this.s.q(videoEventsConfig.c(), this.b.getUniqueId());
                StatisticItem statisticItem = new StatisticItem("c14501");
                statisticItem.param("aid", videoEventsConfig.b());
                statisticItem.eventStat();
            }
        }

        public final void f(ImageView imageView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048581, this, imageView, i2) == null) || imageView == null || i2 <= 0) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = i2;
            imageView.setLayoutParams(layoutParams);
        }

        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            }
        }
    }

    public gz8(TbPageContext tbPageContext, mz8 mz8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, mz8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new a(this);
        this.b = tbPageContext;
        this.c = mz8Var;
        this.a = b();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public abstract View b();

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
        }
    }
}
