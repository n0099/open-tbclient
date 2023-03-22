package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.tieba.frs.unreadbawu.BawuUnreadRequestMessage;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d97 extends y8<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public FrsHeaderViewContainer b;
    public p97 c;
    public x07 d;
    public boolean e;
    public BdUniqueId f;
    public int g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public ll6 l;
    public FrsTabViewController m;
    public c97 n;
    public b97 o;
    public final View.OnClickListener p;
    public final Runnable q;
    public Runnable r;

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d97 a;

        public a(d97 d97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d97Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f0906e8);
            FrsViewData W0 = this.a.a.W0();
            if (W0 != null && W0.getForum() != null && this.a.c != null && (view2 == this.a.c.f() || view2 == this.a.c.g() || view2 == this.a.c.k() || logicField == LogicField.INFO_AREA)) {
                StatisticItem statisticItem = new StatisticItem("c12046");
                if (this.a.a != null && W0.getForum() != null) {
                    if (this.a.a.c4()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    statisticItem.param("fid", W0.getForum().getId());
                    statisticItem.param("fname", W0.getForum().getName());
                    statisticItem.param("obj_locate", i);
                    i67.a(statisticItem);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (W0.getEntelechyTabInfo() != null && W0.getEntelechyTabInfo().a != null) {
                    for (int i2 = 0; i2 < W0.getEntelechyTabInfo().a.size(); i2++) {
                        arrayList.add(W0.getEntelechyTabInfo().a.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.a.getPageContext().getPageActivity(), W0.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                forumDetailActivityConfig.setServiceAreaListData(W0.serviceAreaFlutterData);
                int baWuNoticeNum = W0.getBaWuNoticeNum();
                forumDetailActivityConfig.setRedPotNum(String.valueOf(baWuNoticeNum));
                if (W0.getUserData() != null) {
                    if (W0.getUserData().getIs_manager() == 1 && baWuNoticeNum > 0) {
                        MessageManager.getInstance().sendMessage(new BawuUnreadRequestMessage(this.a.a.l));
                    }
                    W0.setBaWuNoticeNum(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921721));
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (W0.getUserData().getIs_manager() == 1) {
                        if (baWuNoticeNum > 0) {
                            statisticItem.param("obj_type", 1);
                        } else {
                            statisticItem.param("obj_type", 2);
                        }
                    }
                    if (W0.getUserData().isOtherBawu()) {
                        statisticItem.param("obj_type", 3);
                    } else if (W0.getUserData().isNormal()) {
                        statisticItem.param("obj_type", 4);
                    }
                }
                TiebaStatic.log(statisticItem);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view2.getId();
            if (id != R.id.obfuscated_res_0x7f0925b5 && logicField != LogicField.LIKE_BTN) {
                long j = 0;
                if (id != R.id.obfuscated_res_0x7f0925ff && logicField != LogicField.SIGN_BTN) {
                    if (id == R.id.obfuscated_res_0x7f090c5b) {
                        if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && W0 != null && W0.getGameUrl() != null) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{W0.getGameUrl()}, true);
                        }
                    } else if (id == R.id.obfuscated_res_0x7f090bfc) {
                        if (W0 != null && W0.getUserData() != null && W0.getUserData().isBawu()) {
                            String bawuCenterUrl = W0.getBawuCenterUrl();
                            if (!gi.isEmpty(bawuCenterUrl)) {
                                gt4.s(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (W0.getForum() != null) {
                                    TiebaStatic.log(new StatisticItem("c10502").param("fid", W0.getForum().getId()).param("uid", W0.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id != R.id.obfuscated_res_0x7f09144e && logicField != LogicField.LEVEL_AND_LEVEL_NAME) {
                        if (id == R.id.obfuscated_res_0x7f090c66) {
                            if (W0 != null && W0.getForum() != null && !TextUtils.isEmpty(W0.getForum().getId())) {
                                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                                hotUserRankActivityConfig.setForumId(Long.valueOf(gg.g(W0.getForum().getId(), 0L)));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                                StatisticItem statisticItem2 = new StatisticItem("c13666");
                                statisticItem2.param("fid", W0.getForum().getId());
                                TiebaStatic.log(statisticItem2);
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090cb5) {
                            if (W0 != null && W0.getForum() != null && !TextUtils.isEmpty(W0.getForum().getId())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(W0.getForum().getId()), W0.getForum().getName())));
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090cb4 && ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && W0 != null && W0.getForum() != null && !TextUtils.isEmpty(W0.getForum().getId())) {
                            UrlManager urlManager = UrlManager.getInstance();
                            TbPageContext<?> n = this.a.a.n();
                            urlManager.dealOneLink(n, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + W0.getForum().getId()});
                        }
                    } else if (!this.a.a.G3() && this.a.i == 0 && this.a.L() && this.a.c != null) {
                        this.a.c.U(view2, false);
                    }
                } else if (!this.a.a.G3()) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0d1f);
                    } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                        String C = this.a.C();
                        if (!TextUtils.isEmpty(C)) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{C});
                            if (W0 != null && W0.getForum() != null && W0.getForum().getSignData() != null && W0.getForum().getSignData().chatRoomGuideData != null) {
                                j = W0.getForum().getSignData().chatRoomGuideData.a();
                            }
                            TiebaStatic.log(new StatisticItem("c15205").param("obj_type", 2).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.a.w()).param("fname", this.a.a.v()).param("room_id", j));
                            this.a.H();
                        } else if (!this.a.E()) {
                            this.a.F0();
                            StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), gg.e(this.a.a.w(), 0), 24002)));
                        }
                    }
                }
            } else if (!this.a.a.G3()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0d1f);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.w()));
                } else {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f09113e);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        i67.d(this.a.a.w(), this.a.a.v());
                    }
                    this.a.E0(true);
                    if (!gi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        StatisticItem statisticItem3 = new StatisticItem("c10048");
                        statisticItem3.param("fid", this.a.a.w());
                        statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        TiebaStatic.log(statisticItem3);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d97 a;

        public b(d97 d97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d97Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            kw6 v1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.i == 0 && (v1 = this.a.a.v1()) != null && v1.c0() != null && !v1.c0().l() && !v1.e0() && this.a.b.isShown() && this.a.a.isPrimary() && !this.a.j && this.a.a.i3() && this.a.k == 1 && this.a.L() && this.a.c != null && this.a.c.v()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.a.C0();
                this.a.a.c = true;
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d97 a;

        public c(d97 d97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d97Var;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            if (view2 instanceof pk) {
                ((pk) view2).refresh();
            }
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(viewGroup.getChildAt(i));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.b != null) {
                int childCount = this.a.b.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(this.a.b.getChildAt(i));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d97(FrsFragment frsFragment, x07 x07Var, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, x07Var, frsHeaderViewContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.g = 0;
        this.h = "normal_page";
        this.i = 0;
        this.j = false;
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
        this.a = frsFragment;
        this.d = x07Var;
        this.b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.n = new c97(this.a, gen);
        this.o = new b97(this.a);
        this.l = new ll6();
    }

    public final void A(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, str, i, i2) == null) {
            boolean z = !TextUtils.equals(this.h, str);
            this.k = i2;
            this.h = str;
            j0();
            if (this.c == null || z) {
                p97 p97Var = this.c;
                if (p97Var != null) {
                    p97Var.w();
                    this.c = null;
                }
                p97 e = this.d.e(str, this.a, i);
                this.c = e;
                e.c(this.g);
                this.c.I(this.p);
            }
            c97 c97Var = this.n;
            if (c97Var != null) {
                this.c.S(c97Var);
            }
            b97 b97Var = this.o;
            if (b97Var != null) {
                this.c.Q(b97Var);
            }
            this.b.a(this.c.m());
            B(str);
            D0();
        }
    }

    public static boolean O(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, frsViewData)) == null) {
            if (frsViewData == null || frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().a(), true) || frsViewData.getBookInfo().a().equals("0")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void Q(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            c97 c97Var = this.n;
            if (c97Var != null) {
                c97Var.p();
            }
            b97 b97Var = this.o;
            if (b97Var != null) {
                b97Var.j();
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            if (z) {
                p97 p97Var = this.c;
                if (p97Var != null) {
                    this.b.d(p97Var.h());
                    this.e = false;
                    return;
                }
                return;
            }
            p97 p97Var2 = this.c;
            if (p97Var2 != null && p97Var2.h() != null && !this.e) {
                this.b.b(this.c.h(), this.b.getHeaderViewsCount());
                this.e = true;
            }
        }
    }

    public static boolean P(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, frsViewData)) == null) {
            if (frsViewData == null) {
                return false;
            }
            if ((frsViewData.getStar() == null || frsViewData.getStar().b() != 1) && frsViewData.getHeadSdkData() == null && ((frsViewData.getActivityHeadData() == null || ListUtils.isEmpty(frsViewData.getActivityHeadData().b())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().a(), true))))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void i0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, str) == null) && this.a.Q0() != null && this.a.Q0().p0() != null) {
            int X = this.a.Q0().p0().X();
            int U = this.a.Q0().p0().U();
            int S = this.a.Q0().p0().S();
            ha9 i = ha9.i();
            ha9.i().n(i.g("1~" + str, X, U, S), false);
        }
    }

    public void E0(boolean z) {
        b97 b97Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (b97Var = this.o) != null) {
            p97 p97Var = this.c;
            if (p97Var != null && p97Var.s()) {
                z2 = true;
            } else {
                z2 = false;
            }
            b97Var.m(z2);
            this.o.p(z);
        }
    }

    public final float F(ForumData forumData) {
        InterceptResult invokeL;
        c97 c97Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, forumData)) == null) {
            if (forumData != null && (c97Var = this.n) != null) {
                return c97Var.l(forumData);
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public boolean T(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            this.g = i;
            p97 p97Var = this.c;
            if (p97Var != null) {
                p97Var.c(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void V(boolean z) {
        p97 p97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048600, this, z) == null) && (p97Var = this.c) != null) {
            p97Var.z(z);
        }
    }

    public void X(MotionEvent motionEvent) {
        ll6 ll6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, motionEvent) == null) && (ll6Var = this.l) != null) {
            ll6Var.c(motionEvent);
        }
    }

    public void Y(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, num) == null) {
            u0(num.intValue());
            if (L()) {
                d0();
            }
        }
    }

    public void b0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, frsViewData) == null) && frsViewData != null && L()) {
            a0(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.h)) {
                this.c.b();
            }
        }
    }

    public void c0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048607, this, i) == null) && L()) {
            n0(i);
        }
    }

    public void g0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, frsViewData) == null) && frsViewData != null && this.c != null && L()) {
            this.c.C(F(frsViewData.getForum()));
        }
    }

    public void m0(int i) {
        p97 p97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048616, this, i) == null) && (p97Var = this.c) != null && p97Var.h() != null) {
            View findViewById = this.c.h().findViewById(R.id.divider_bottom);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            this.c.p();
        }
    }

    public void n0(int i) {
        p97 p97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048617, this, i) == null) && (p97Var = this.c) != null) {
            p97Var.L(i);
        }
    }

    public void r0(int i) {
        p97 p97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048620, this, i) == null) && L() && (p97Var = this.c) != null) {
            p97Var.N(i);
        }
    }

    public void s0(FrsViewData frsViewData) {
        c97 c97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, frsViewData) == null) && L() && (c97Var = this.n) != null) {
            c97Var.v(this.c, frsViewData);
        }
    }

    public void u0(int i) {
        p97 p97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048623, this, i) == null) && (p97Var = this.c) != null) {
            p97Var.R(i);
        }
    }

    public void v0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
            if (i > 1) {
                p97 p97Var = this.c;
                if (p97Var != null) {
                    p97Var.P(false);
                    return;
                }
                return;
            }
            p97 p97Var2 = this.c;
            if (p97Var2 != null) {
                p97Var2.P(true);
            }
        }
    }

    public void w0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            this.i = i;
        }
    }

    public void x0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void z0(List<pa9> list) {
        p97 p97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048629, this, list) == null) && (p97Var = this.c) != null) {
            p97Var.V(list);
        }
    }

    public void q0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048619, this, frsViewData, z) == null) && frsViewData != null && L()) {
            p0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void y0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048627, this, str, frsViewData) == null) && frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            A(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public final void B(String str) {
        FrsFragment frsFragment;
        RelativeLayout H;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || this.m == null || (frsFragment = this.a) == null || frsFragment.I3() == null || (H = this.m.H()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.I3().removeHeaderView(H);
            return;
        }
        this.a.I3().removeHeaderView(H);
        this.a.I3().addHeaderView(H, 0);
    }

    public String C() {
        InterceptResult invokeV;
        p97 p97Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (L() && (p97Var = this.c) != null) {
                return p97Var.i();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void C0() {
        p97 p97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && L() && (p97Var = this.c) != null) {
            p97Var.W();
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        p97 p97Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (L() && (p97Var = this.c) != null) {
                return p97Var.o();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            jg.a().postDelayed(this.q, 4000L);
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        p97 p97Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (L() && (p97Var = this.c) != null) {
                return p97Var.j();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public b97 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.o;
        }
        return (b97) invokeV.objValue;
    }

    public void G0() {
        b97 b97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (b97Var = this.o) != null) {
            b97Var.q();
        }
    }

    public void H() {
        p97 p97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && L() && (p97Var = this.c) != null) {
            p97Var.n();
        }
    }

    public void I() {
        p97 p97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (p97Var = this.c) != null) {
            p97Var.p();
        }
    }

    public void J() {
        p97 p97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (p97Var = this.c) != null) {
            p97Var.r();
        }
    }

    public boolean N() {
        InterceptResult invokeV;
        p97 p97Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (L() && (p97Var = this.c) != null) {
                return p97Var.t();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            p97 p97Var = this.c;
            if (p97Var != null) {
                p97Var.w();
            }
            b97 b97Var = this.o;
            if (b97Var != null) {
                b97Var.k();
            }
            if (this.q != null) {
                jg.a().removeCallbacks(this.q);
            }
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            p97 p97Var = this.c;
            if (p97Var != null) {
                p97Var.B();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.r);
            }
        }
    }

    public void U() {
        p97 p97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (p97Var = this.c) != null) {
            p97Var.y();
        }
    }

    public void W() {
        p97 p97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (p97Var = this.c) != null) {
            p97Var.A();
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.c.E();
        }
    }

    public void d0() {
        p97 p97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (p97Var = this.c) != null) {
            p97Var.a0();
        }
    }

    public void e0() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (frsHeaderViewContainer = this.b) != null) {
            frsHeaderViewContainer.removeCallbacks(this.r);
            this.b.postDelayed(this.r, 100L);
        }
    }

    public void h0() {
        p97 p97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (p97Var = this.c) != null) {
            p97Var.F();
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            p97 p97Var = this.c;
            if (p97Var != null) {
                this.b.d(p97Var.m());
                this.b.d(this.c.h());
                k0();
            }
            this.e = false;
        }
    }

    public final void k0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && this.m != null && (frsFragment = this.a) != null && frsFragment.I3() != null) {
            this.a.I3().removeHeaderView(this.m.H());
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && L()) {
            n0(0);
        }
    }

    public void z() {
        p97 p97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && !this.e && (p97Var = this.c) != null) {
            this.b.a(p97Var.h());
            this.e = true;
        }
    }

    public void F0() {
        c97 c97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (c97Var = this.n) != null) {
            p97 p97Var = this.c;
            if (p97Var != null) {
                c97Var.x(p97Var.u(), this.c.e());
            } else {
                c97Var.x(false, "");
            }
            p97 p97Var2 = this.c;
            if (p97Var2 != null) {
                this.n.w(p97Var2.l());
            }
        }
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!"frs_page".equals(this.h) && !"normal_page".equals(this.h) && !"book_page".equals(this.h) && !"brand_page".equals(this.h)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void H0(int i, int i2, int i3) {
        c97 c97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048589, this, i, i2, i3) == null) && (c97Var = this.n) != null) {
            c97Var.y(i, i2, i3);
        }
    }

    public void a0(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, forumData, frsViewData) == null) && forumData != null && frsViewData != null) {
            float F = F(forumData);
            p97 p97Var = this.c;
            if (p97Var == null) {
                return;
            }
            p97Var.J(forumData, frsViewData);
            this.c.M(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), F, false);
            this.c.O(forumData.getSignData());
        }
    }

    public void p0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        p97 p97Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) != null) || (p97Var = this.c) == null) {
            return;
        }
        p97Var.J(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.c.M(i, forumData.getLevelName(), forumData.getUser_level(), F(forumData), z);
        if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
            this.c.a(false);
        }
    }
}
