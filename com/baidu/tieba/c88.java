package com.baidu.tieba;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.message.UserGrowthTaskRequestMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.RadiusProgressView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c88 extends z26<m78> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView B;
    public TbImageView C;
    public BdListView D;
    public b E;
    public RadiusProgressView F;
    public m78 G;
    public View i;
    public TbPageContext j;
    public View k;
    public View l;
    public View m;
    public View n;
    public View o;
    public View p;
    public View q;
    public View r;
    public ImageView s;
    public ImageView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public TextView z;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // com.baidu.tieba.z26
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0718 : invokeV.intValue;
    }

    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<t55> a;
        public LayoutInflater b;
        public final /* synthetic */ c88 c;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
        }

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ t55 a;
            public final /* synthetic */ b b;

            public a(b bVar, t55 t55Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, t55Var};
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
                this.a = t55Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    String a = this.a.a();
                    k88.a("2");
                    if (UserGrowthTaskRequestMessage.SET_USER_AVATAR.equals(a)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.b.c.j.getPageActivity(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountNameShow())));
                    } else if (UserGrowthTaskRequestMessage.SET_USER_NICK.equals(a)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.b.c.j.getPageActivity(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountNameShow())));
                    } else if ("set_user_profile".equals(a)) {
                        this.b.d();
                    } else if ("page_sign".equals(a)) {
                        UrlManager.getInstance().dealOneLink(this.b.c.j, new String[]{TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL});
                    } else if ("follow".equals(a)) {
                        MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this.b.c.j.getPageActivity()).createNormalCfg(1);
                        createNormalCfg.setSubTab(1, "吧广场");
                        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, createNormalCfg));
                    } else if (UserGrowthTaskRequestMessage.SHARE_THREAD.equals(a)) {
                        UrlManager.getInstance().dealOneLink(this.b.c.j, new String[]{TbConfig.USER_GROWTH_GUIDE_MAIN_URL});
                    } else if ("add_post".equals(a)) {
                        WriteActivityConfig.newInstance(this.b.c.j.getPageActivity()).setCallFrom("2").setType(9).setFrom("main_tab").send();
                    } else if ("game_rank_statement".equals(a)) {
                        if (this.b.c.G != null && this.b.c.G.c() != null) {
                            StatisticItem statisticItem = new StatisticItem("c15060");
                            statisticItem.addParam("obj_param1", "LV" + this.b.c.G.c().a()).eventStat();
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.b.c.c, null, TbConfig.URL_GAME_RANK_STATEMENT, true)));
                    } else {
                        UrlManager.getInstance().dealOneLink(this.b.c.j, new String[]{TbConfig.USER_GROWTH_GUIDE_MAIN_URL});
                    }
                }
            }
        }

        /* renamed from: com.baidu.tieba.c88$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0224b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public TbImageView b;
            public TextView c;
            public TextView d;
            public TextView e;
            public TBSpecificationBtn f;

            public C0224b(b bVar) {
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
                this.a = 3;
            }

            public /* synthetic */ C0224b(b bVar, a aVar) {
                this(bVar);
            }
        }

        public b(c88 c88Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c88Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = c88Var;
            this.a = new ArrayList();
            this.b = LayoutInflater.from(tbPageContext.getPageActivity());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: c */
        public t55 getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return this.a.get(i);
            }
            return (t55) invokeI.objValue;
        }

        public void e(List<t55> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.a.clear();
                if (list != null) {
                    this.a.addAll(list);
                }
                notifyDataSetChanged();
            }
        }

        public final void b(C0224b c0224b, View view2, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048576, this, c0224b, view2, i) == null) && c0224b != null && c0224b.a != i) {
                kw4.d(c0224b.c).v(R.color.CAM_X0105);
                kw4.d(c0224b.e).v(R.color.CAM_X0109);
                kw4.d(c0224b.d).v(R.color.CAM_X0118);
                jz4 jz4Var = new jz4();
                jz4Var.r(R.color.CAM_X0118);
                c0224b.f.setConfig(jz4Var);
                c0224b.a = i;
            }
        }

        public final void d() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 4) {
                        str = "&skin=dart";
                    } else if (skinType == 1) {
                        str = "&skin=night";
                    } else {
                        str = "";
                    }
                    UrlManager.getInstance().dealOneLink(this.c.j, new String[]{TbConfig.VIRTUAL_IMAGE_MAIN_URL + str});
                } catch (Exception e) {
                    BdLog.e("openPageByUrl fail:" + e.toString());
                }
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            C0224b c0224b;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
                t55 item = getItem(i);
                if (item == null) {
                    return view2;
                }
                if ("game_rank_statement".equals(item.a()) && this.c.G != null && this.c.G.c() != null) {
                    StatisticItem statisticItem = new StatisticItem("c15059");
                    statisticItem.addParam("obj_param1", "LV" + this.c.G.c().a()).eventStat();
                }
                if (view2 != null && (view2.getTag() instanceof C0224b)) {
                    c0224b = (C0224b) view2.getTag();
                } else {
                    view2 = this.b.inflate(R.layout.obfuscated_res_0x7f0d08ce, (ViewGroup) null);
                    c0224b = new C0224b(this, null);
                    c0224b.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0924d9);
                    c0224b.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924db);
                    c0224b.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924dc);
                    c0224b.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924d8);
                    c0224b.f = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f0924d7);
                    view2.setTag(c0224b);
                }
                c0224b.b.K(item.e(), 10, false);
                c0224b.c.setText(item.c());
                c0224b.d.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f153d), Integer.valueOf(item.f())));
                c0224b.e.setText(item.b());
                if (item.d() == 2) {
                    c0224b.f.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f153f));
                    c0224b.f.setUseDisableState(true);
                } else {
                    c0224b.f.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f153e));
                    c0224b.f.setUseDisableState(false);
                    c0224b.f.setOnClickListener(new a(this, item));
                }
                b(c0224b, view2, TbadkCoreApplication.getInst().getSkinType());
                return view2;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c88(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.G = new m78();
        this.j = tbPageContext;
        this.i = k();
        int g = xi.g(this.c, R.dimen.M_W_X003);
        this.i.setPadding(g, 0, g, 0);
        this.k = this.i.findViewById(R.id.obfuscated_res_0x7f091946);
        this.l = this.i.findViewById(R.id.obfuscated_res_0x7f091945);
        this.m = this.i.findViewById(R.id.obfuscated_res_0x7f091944);
        View findViewById = this.i.findViewById(R.id.obfuscated_res_0x7f0922d6);
        this.n = findViewById;
        findViewById.setOnClickListener(this);
        View findViewById2 = this.i.findViewById(R.id.obfuscated_res_0x7f091562);
        this.o = findViewById2;
        findViewById2.setOnClickListener(this);
        View findViewById3 = this.i.findViewById(R.id.obfuscated_res_0x7f0903f6);
        this.p = findViewById3;
        findViewById3.setOnClickListener(this);
        View findViewById4 = this.i.findViewById(R.id.obfuscated_res_0x7f0924d5);
        this.q = findViewById4;
        findViewById4.setOnClickListener(this);
        this.r = this.i.findViewById(R.id.obfuscated_res_0x7f0924d4);
        this.u = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092256);
        this.v = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092178);
        this.w = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090d2e);
        this.x = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09247a);
        this.y = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0922a6);
        this.z = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092483);
        this.A = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092484);
        this.B = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0924dd);
        this.s = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f090ef5);
        this.t = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f0924de);
        this.D = (BdListView) this.i.findViewById(R.id.obfuscated_res_0x7f0924da);
        b bVar = new b(this, this.j);
        this.E = bVar;
        this.D.setAdapter((ListAdapter) bVar);
        TbImageView tbImageView = (TbImageView) this.i.findViewById(R.id.obfuscated_res_0x7f0924d2);
        this.C = tbImageView;
        tbImageView.setAutoChangeStyle(true);
        this.C.setDrawCorner(true);
        this.C.setRadiusById(R.string.J_X14);
        this.C.setConrers(3);
        RadiusProgressView radiusProgressView = (RadiusProgressView) this.i.findViewById(R.id.obfuscated_res_0x7f0924d6);
        this.F = radiusProgressView;
        radiusProgressView.setOnClickListener(this);
        m(g(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.z26
    public void m(TbPageContext<?> tbPageContext, int i) {
        SpannableString spannableString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.C.K(String.valueOf((int) R.drawable.obfuscated_res_0x7f080849), 24, false);
            if (i != 1 && i != 4) {
                this.C.setAlpha(1.0f);
            } else {
                this.C.setAlpha(0.3f);
            }
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
            kw4 d = kw4.d(this.m);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            kw4.d(this.r).f(R.color.CAM_X0401);
            kw4.d(this.u).v(R.color.CAM_X0105);
            kw4.d(this.v).v(R.color.CAM_X0118);
            kw4.d(this.w).v(R.color.CAM_X0105);
            kw4.d(this.x).v(R.color.CAM_X0107);
            kw4.d(this.y).v(R.color.CAM_X0105);
            kw4.d(this.z).v(R.color.CAM_X0107);
            kw4.d(this.A).v(R.color.CAM_X0107);
            if (this.G.c() != null) {
                long b2 = this.G.c().b();
                long c = this.G.c().c();
                long j = c - b2;
                SpannableString spannableString2 = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f153b), Long.valueOf(b2), Long.valueOf(c)));
                spannableString2.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 4, String.valueOf(b2).length() + 4, 18);
                this.z.setText(spannableString2);
                if (this.G.c().a() == 10) {
                    spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f153a));
                } else {
                    spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f153c), Long.valueOf(j)));
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 9, String.valueOf(j).length() + 9, 18);
                }
                this.A.setText(spannableString);
                if (b2 > 0) {
                    if (b2 < c) {
                        this.F.setProgress((int) ((b2 * 100) / c));
                    } else {
                        this.F.setProgress(100);
                    }
                } else {
                    this.F.setProgress(0);
                }
            }
            kw4.d(this.B).v(R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.s, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0118, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.t, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            this.F.setSolidColor(SkinManager.getColor(R.color.CAM_X0201));
            this.F.setProgressColor(SkinManager.getColor(R.color.CAM_X0336));
            this.F.setProgressColorRight(SkinManager.getColor(R.color.CAM_X0336));
            this.F.setProgressColorLeft(fn8.a(SkinManager.getColor(R.color.CAM_X0336), 0.4f));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f0924d5) {
                UrlManager.getInstance().dealOneLink(this.j, new String[]{TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL});
                k88.a("2");
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0922d6 || view2.getId() == R.id.obfuscated_res_0x7f091562 || view2.getId() == R.id.obfuscated_res_0x7f0924d6 || view2.getId() == R.id.obfuscated_res_0x7f0903f6) {
                UrlManager.getInstance().dealOneLink(this.j, new String[]{TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL});
                k88.a("1");
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.z26
    /* renamed from: t */
    public void l(m78 m78Var) {
        SpannableString spannableString;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, m78Var) == null) && m78Var != null && m78Var.c() != null) {
            if (TbSingleton.getInstance().isUserGrowthOpen()) {
                this.k.setVisibility(0);
                this.m.setVisibility(0);
                this.l.setVisibility(0);
                this.C.setVisibility(0);
            } else {
                this.k.setVisibility(8);
                this.m.setVisibility(8);
                this.l.setVisibility(8);
                this.C.setVisibility(8);
            }
            this.G = m78Var;
            this.w.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1539), Integer.valueOf(m78Var.c().a())));
            this.y.setText(String.valueOf((int) m78Var.c().e()));
            long b2 = m78Var.c().b();
            long c = m78Var.c().c();
            long j = c - b2;
            SpannableString spannableString2 = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f153b), Long.valueOf(b2), Long.valueOf(c)));
            spannableString2.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 4, String.valueOf(b2).length() + 4, 18);
            this.z.setText(spannableString2);
            if (this.G.c().a() == 10) {
                spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f153a));
            } else {
                spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f153c), Long.valueOf(j)));
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 9, String.valueOf(j).length() + 9, 18);
            }
            this.A.setText(spannableString);
            if (b2 > 0) {
                if (b2 < c) {
                    this.F.setProgress((int) ((b2 * 100) / c));
                } else {
                    this.F.setProgress(100);
                }
            } else {
                this.F.setProgress(0);
            }
            this.E.e(m78Var.c().d());
            m(g(), TbadkCoreApplication.getInst().getSkinType());
            if (m78Var != null) {
                k88.b();
            }
        }
    }
}
