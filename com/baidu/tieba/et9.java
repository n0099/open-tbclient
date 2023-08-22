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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.mainentrance.MainEntrance;
import com.baidu.tbadk.core.message.UserGrowthTaskRequestMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.RadiusProgressView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class et9 extends ln6<ns9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView B;
    public TbImageView C;
    public BdListView D;
    public b E;
    public RadiusProgressView F;
    public boolean G;
    public boolean H;
    public ns9 I;
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

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // com.baidu.tieba.ln6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d07d2 : invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class b extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<gh5> a;
        public LayoutInflater b;
        public final /* synthetic */ et9 c;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i : invokeI.longValue;
        }

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gh5 a;
            public final /* synthetic */ b b;

            public a(b bVar, gh5 gh5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, gh5Var};
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
                this.a = gh5Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (!StringUtils.isNotNull(this.a.e())) {
                        this.b.e(this.a);
                    } else {
                        UrlManager.getInstance().dealOneLink(this.b.c.j, new String[]{this.a.e()});
                    }
                }
            }
        }

        /* renamed from: com.baidu.tieba.et9$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0280b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public TbImageView b;
            public TextView c;
            public TextView d;
            public TextView e;
            public TBSpecificationBtn f;

            public C0280b(b bVar) {
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

            public /* synthetic */ C0280b(b bVar, a aVar) {
                this(bVar);
            }
        }

        public b(et9 et9Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et9Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = et9Var;
            this.a = new ArrayList();
            this.b = LayoutInflater.from(tbPageContext.getPageActivity());
        }

        public final void b(C0280b c0280b, View view2, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048576, this, c0280b, view2, i) == null) && c0280b != null && c0280b.a != i) {
                EMManager.from(c0280b.c).setTextColor(R.color.CAM_X0105);
                EMManager.from(c0280b.e).setTextColor(R.color.CAM_X0109);
                EMManager.from(c0280b.d).setTextColor(R.color.CAM_X0118);
                ea5 ea5Var = new ea5();
                ea5Var.u(R.color.CAM_X0118);
                c0280b.f.setConfig(ea5Var);
                c0280b.a = i;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: c */
        public gh5 getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return this.a.get(i);
            }
            return (gh5) invokeI.objValue;
        }

        public void f(List<gh5> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
                this.a.clear();
                if (list != null) {
                    this.a.addAll(list);
                }
                notifyDataSetChanged();
            }
        }

        public final void d() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                        str = "&skin=dark";
                    } else {
                        str = "";
                    }
                    UrlManager.getInstance().dealOneLink(this.c.j, new String[]{TbConfig.VIRTUAL_IMAGE_MAIN_URL + str});
                } catch (Exception e) {
                    BdLog.e("openPageByUrl fail:" + e.toString());
                }
            }
        }

        @Deprecated
        public final void e(gh5 gh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, gh5Var) == null) {
                String a2 = gh5Var.a();
                mt9.a("2");
                if (UserGrowthTaskRequestMessage.SET_USER_AVATAR.equals(a2)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.c.j.getPageActivity(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountNameShow())));
                } else if (UserGrowthTaskRequestMessage.SET_USER_NICK.equals(a2)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.c.j.getPageActivity(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountNameShow())));
                } else if ("set_user_profile".equals(a2)) {
                    d();
                } else if ("page_sign".equals(a2)) {
                    UrlManager.getInstance().dealOneLink(this.c.j, new String[]{TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL});
                } else if ("follow".equals(a2)) {
                    MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this.c.j.getPageActivity()).createNormalCfg(1);
                    createNormalCfg.setSubTab(1, MainEntrance.GO_TO_FORUM_SQUARE);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015002, createNormalCfg));
                } else if ("share_thread".equals(a2)) {
                    UrlManager.getInstance().dealOneLink(this.c.j, new String[]{TbConfig.USER_GROWTH_GUIDE_MAIN_URL});
                } else if ("add_post".equals(a2)) {
                    WriteActivityConfig.newInstance(this.c.j.getPageActivity()).setCallFrom("2").setType(9).setFrom("main_tab").send();
                } else if ("game_rank_statement".equals(a2)) {
                    if (this.c.I != null && this.c.I.c() != null) {
                        StatisticItem statisticItem = new StatisticItem("c15060");
                        statisticItem.addParam("obj_param1", "LV" + this.c.I.c().a()).eventStat();
                    }
                    BrowserHelper.startWebActivity(this.c.c, (String) null, TbConfig.URL_GAME_RANK_STATEMENT, true);
                } else if ("follow_user".equals(a2)) {
                    new PersonListActivityConfig(this.c.c, false, TbadkCoreApplication.getCurrentAccount(), 0).start();
                } else if ("agree_user_profile".equals(a2)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(TbadkCoreApplication.getInst().getApplicationContext(), "PersonVirtualAgreePage", hashMap)));
                } else {
                    UrlManager.getInstance().dealOneLink(this.c.j, new String[]{TbConfig.USER_GROWTH_GUIDE_MAIN_URL});
                }
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.a.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            C0280b c0280b;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view2, viewGroup)) == null) {
                gh5 item = getItem(i);
                if (item == null) {
                    return view2;
                }
                if ("game_rank_statement".equals(item.a()) && this.c.I != null && this.c.I.c() != null) {
                    StatisticItem statisticItem = new StatisticItem("c15059");
                    statisticItem.addParam("obj_param1", "LV" + this.c.I.c().a()).eventStat();
                }
                if (view2 != null && (view2.getTag() instanceof C0280b)) {
                    c0280b = (C0280b) view2.getTag();
                } else {
                    view2 = this.b.inflate(R.layout.obfuscated_res_0x7f0d09c7, (ViewGroup) null);
                    c0280b = new C0280b(this, null);
                    c0280b.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f092842);
                    c0280b.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092844);
                    c0280b.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092845);
                    c0280b.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092841);
                    c0280b.f = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f092840);
                    view2.setTag(c0280b);
                }
                c0280b.b.startLoad(item.f(), 10, false);
                c0280b.c.setText(item.c());
                c0280b.d.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f17c5), Integer.valueOf(item.g())));
                c0280b.e.setText(item.b());
                if (item.d() == 2) {
                    c0280b.f.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f17c7));
                    c0280b.f.setEnabled(false);
                    c0280b.f.setOnClickListener(null);
                } else {
                    c0280b.f.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f17c6));
                    c0280b.f.setEnabled(true);
                    c0280b.f.setOnClickListener(new a(this, item));
                }
                b(c0280b, view2, TbadkCoreApplication.getInst().getSkinType());
                return view2;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public et9(TbPageContext<?> tbPageContext) {
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
        this.I = new ns9();
        this.j = tbPageContext;
        this.i = h();
        int dimens = BdUtilHelper.getDimens(this.c, R.dimen.M_W_X003);
        this.i.setPadding(dimens, 0, dimens, 0);
        this.k = this.i.findViewById(R.id.obfuscated_res_0x7f091bd1);
        this.l = this.i.findViewById(R.id.obfuscated_res_0x7f091bd0);
        this.m = this.i.findViewById(R.id.obfuscated_res_0x7f091bcf);
        View findViewById = this.i.findViewById(R.id.top_container);
        this.n = findViewById;
        findViewById.setOnClickListener(this);
        View findViewById2 = this.i.findViewById(R.id.obfuscated_res_0x7f091775);
        this.o = findViewById2;
        findViewById2.setOnClickListener(this);
        View findViewById3 = this.i.findViewById(R.id.obfuscated_res_0x7f090459);
        this.p = findViewById3;
        findViewById3.setOnClickListener(this);
        View findViewById4 = this.i.findViewById(R.id.obfuscated_res_0x7f09283e);
        this.q = findViewById4;
        findViewById4.setOnClickListener(this);
        this.r = this.i.findViewById(R.id.obfuscated_res_0x7f09283d);
        this.u = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09258f);
        this.v = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0924b0);
        this.w = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090ed1);
        this.x = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0927de);
        this.y = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0925e2);
        this.z = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0927e7);
        this.A = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0927e8);
        this.B = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092846);
        this.s = (ImageView) this.i.findViewById(R.id.img_arrow);
        this.t = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f092847);
        this.D = (BdListView) this.i.findViewById(R.id.obfuscated_res_0x7f092843);
        b bVar = new b(this, this.j);
        this.E = bVar;
        this.D.setAdapter((ListAdapter) bVar);
        TbImageView tbImageView = (TbImageView) this.i.findViewById(R.id.obfuscated_res_0x7f09283b);
        this.C = tbImageView;
        tbImageView.setAutoChangeStyle(true);
        this.C.setDrawCorner(true);
        this.C.setRadiusById(R.string.J_X14);
        this.C.setConrers(3);
        RadiusProgressView radiusProgressView = (RadiusProgressView) this.i.findViewById(R.id.obfuscated_res_0x7f09283f);
        this.F = radiusProgressView;
        radiusProgressView.setOnClickListener(this);
        j(g(), TbadkCoreApplication.getInst().getSkinType());
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.G = z;
            this.H = false;
        }
    }

    @Override // com.baidu.tieba.ln6
    public void j(TbPageContext<?> tbPageContext, int i) {
        SpannableString spannableString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.C.startLoad(String.valueOf((int) R.drawable.obfuscated_res_0x7f080a1c), 24, false);
            if (i == 4) {
                this.C.setAlpha(0.3f);
            } else {
                this.C.setAlpha(1.0f);
            }
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
            EMManager.from(this.m).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            EMManager.from(this.r).setBackGroundColor(R.color.CAM_X0401);
            EMManager.from(this.u).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.v).setTextColor(R.color.CAM_X0118);
            EMManager.from(this.w).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.x).setTextColor(R.color.CAM_X0107);
            EMManager.from(this.y).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.z).setTextColor(R.color.CAM_X0107);
            EMManager.from(this.A).setTextColor(R.color.CAM_X0107);
            if (this.I.c() != null) {
                long b2 = this.I.c().b();
                long c = this.I.c().c();
                long j = c - b2;
                SpannableString spannableString2 = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f17c3), Long.valueOf(b2), Long.valueOf(c)));
                spannableString2.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 4, String.valueOf(b2).length() + 4, 18);
                this.z.setText(spannableString2);
                if (this.I.c().a() == 10) {
                    spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f17c2));
                } else {
                    spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f17c4), Long.valueOf(j)));
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
            EMManager.from(this.B).setTextColor(R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.s, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0118, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.t, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            this.F.setSolidColor(SkinManager.getColor(R.color.CAM_X0201));
            this.F.setProgressColor(SkinManager.getColor(R.color.CAM_X0336));
            this.F.setProgressColorRight(SkinManager.getColor(R.color.CAM_X0336));
            this.F.setProgressColorLeft(gea.a(SkinManager.getColor(R.color.CAM_X0336), 0.4f));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f09283e) {
                UtilHelper.dealUrlWithSkin(this.j, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL);
                mt9.a("2");
            } else if (view2.getId() == R.id.top_container || view2.getId() == R.id.obfuscated_res_0x7f091775 || view2.getId() == R.id.obfuscated_res_0x7f09283f || view2.getId() == R.id.obfuscated_res_0x7f090459) {
                UtilHelper.dealUrlWithSkin(this.j, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL);
                mt9.a("1");
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln6
    /* renamed from: t */
    public void i(ns9 ns9Var) {
        SpannableString spannableString;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, ns9Var) == null) && ns9Var != null && ns9Var.c() != null) {
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
            this.I = ns9Var;
            this.w.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.user_growth_level), Integer.valueOf(ns9Var.c().a())));
            this.y.setText(String.valueOf((int) ns9Var.c().e()));
            long b2 = ns9Var.c().b();
            long c = ns9Var.c().c();
            long j = c - b2;
            SpannableString spannableString2 = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f17c3), Long.valueOf(b2), Long.valueOf(c)));
            spannableString2.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 4, String.valueOf(b2).length() + 4, 18);
            this.z.setText(spannableString2);
            if (this.I.c().a() == 10) {
                spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f17c2));
            } else {
                spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f17c4), Long.valueOf(j)));
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
            this.E.f(ns9Var.c().d());
            j(g(), TbadkCoreApplication.getInst().getSkinType());
            if (this.G && ns9Var != null && !this.H) {
                this.H = true;
                mt9.b();
            }
        }
    }
}
