package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.browser.BrowserHelper;
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
/* loaded from: classes5.dex */
public class fx7 extends BdBaseView<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public FrsHeaderViewContainer b;
    public rx7 c;
    public fn7 d;
    public boolean e;
    public BdUniqueId f;
    public int g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public fz6 l;
    public FrsTabViewController m;
    public ex7 n;
    public dx7 o;
    public final View.OnClickListener p;
    public final Runnable q;
    public Runnable r;

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fx7 a;

        public a(fx7 fx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f09071e);
            FrsViewData m1 = this.a.a.m1();
            if (m1 != null && m1.getForum() != null && this.a.c != null && (view2 == this.a.c.g() || view2 == this.a.c.h() || view2 == this.a.c.l() || logicField == LogicField.INFO_AREA)) {
                StatisticItem statisticItem = new StatisticItem("c12046");
                if (this.a.a != null && m1.getForum() != null) {
                    if (this.a.a.A4()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    statisticItem.param("fid", m1.getForum().getId());
                    statisticItem.param("fname", m1.getForum().getName());
                    statisticItem.param("obj_locate", i);
                    bt7.a(statisticItem);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (m1.getEntelechyTabInfo() != null && m1.getEntelechyTabInfo().a != null) {
                    for (int i2 = 0; i2 < m1.getEntelechyTabInfo().a.size(); i2++) {
                        arrayList.add(m1.getEntelechyTabInfo().a.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.a.getPageContext().getPageActivity(), m1.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                forumDetailActivityConfig.setServiceAreaListData(m1.serviceAreaFlutterData);
                int baWuNoticeNum = m1.getBaWuNoticeNum();
                forumDetailActivityConfig.setRedPotNum(String.valueOf(baWuNoticeNum));
                if (m1.getUserData() != null) {
                    if (m1.getUserData().getIs_manager() == 1 && baWuNoticeNum > 0) {
                        MessageManager.getInstance().sendMessage(new BawuUnreadRequestMessage(this.a.a.l));
                    }
                    m1.setBaWuNoticeNum(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921721));
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (m1.getUserData().getIs_manager() == 1) {
                        if (baWuNoticeNum > 0) {
                            statisticItem.param("obj_type", 1);
                        } else {
                            statisticItem.param("obj_type", 2);
                        }
                    }
                    if (m1.getUserData().isOtherBawu()) {
                        statisticItem.param("obj_type", 3);
                    } else if (m1.getUserData().isNormal()) {
                        statisticItem.param("obj_type", 4);
                    }
                }
                TiebaStatic.log(statisticItem);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view2.getId();
            if (id != R.id.obfuscated_res_0x7f09278b && logicField != LogicField.LIKE_BTN) {
                long j = 0;
                if (id != R.id.obfuscated_res_0x7f0927d7 && logicField != LogicField.SIGN_BTN) {
                    if (id == R.id.obfuscated_res_0x7f090ccf) {
                        if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && m1 != null && m1.getGameUrl() != null) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{m1.getGameUrl()}, true);
                        }
                    } else if (id == R.id.obfuscated_res_0x7f090c70) {
                        if (m1 != null && m1.getUserData() != null && m1.getUserData().isBawu()) {
                            String bawuCenterUrl = m1.getBawuCenterUrl();
                            if (!ei.isEmpty(bawuCenterUrl)) {
                                BrowserHelper.startWebActivity(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (m1.getForum() != null) {
                                    TiebaStatic.log(new StatisticItem("c10502").param("fid", m1.getForum().getId()).param("uid", m1.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id != R.id.obfuscated_res_0x7f09150f && logicField != LogicField.LEVEL_AND_LEVEL_NAME) {
                        if (id == R.id.obfuscated_res_0x7f090cda) {
                            if (m1 != null && m1.getForum() != null && !TextUtils.isEmpty(m1.getForum().getId())) {
                                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                                hotUserRankActivityConfig.setForumId(Long.valueOf(JavaTypesHelper.toLong(m1.getForum().getId(), 0L)));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                                StatisticItem statisticItem2 = new StatisticItem("c13666");
                                statisticItem2.param("fid", m1.getForum().getId());
                                TiebaStatic.log(statisticItem2);
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090d29) {
                            if (m1 != null && m1.getForum() != null && !TextUtils.isEmpty(m1.getForum().getId())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(m1.getForum().getId()), m1.getForum().getName())));
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090d28 && ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && m1 != null && m1.getForum() != null && !TextUtils.isEmpty(m1.getForum().getId())) {
                            UrlManager urlManager = UrlManager.getInstance();
                            TbPageContext<?> u = this.a.a.u();
                            urlManager.dealOneLink(u, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + m1.getForum().getId()});
                        }
                    } else if (!this.a.a.b4() && this.a.i == 0 && this.a.Y() && this.a.c != null) {
                        ky5.d(m1.getForum().getId(), m1.getUserData().getPortrait(), "1", this.a.mContext.getPageActivity());
                        ly5.c("c15281", m1.getForum().getId(), "1");
                    }
                } else if (!this.a.a.b4()) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0e40);
                    } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                        String O = this.a.O();
                        if (!TextUtils.isEmpty(O)) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{O});
                            if (m1 != null && m1.getForum() != null && m1.getForum().getSignData() != null && m1.getForum().getSignData().chatRoomGuideData != null) {
                                j = m1.getForum().getSignData().chatRoomGuideData.a();
                            }
                            TiebaStatic.log(new StatisticItem("c15205").param("obj_type", 2).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.a.w()).param("fname", this.a.a.v()).param("room_id", j));
                            this.a.U();
                        } else if (!this.a.Q()) {
                            this.a.Q0();
                            StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), JavaTypesHelper.toInt(this.a.a.w(), 0), 24002)));
                        }
                    }
                }
            } else if (!this.a.a.b4()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0e40);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.w()));
                } else {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f0911ef);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        bt7.d(this.a.a.w(), this.a.a.v());
                    }
                    this.a.P0(true);
                    if (!ei.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        StatisticItem statisticItem3 = new StatisticItem("c10048");
                        statisticItem3.param("fid", this.a.a.w());
                        statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        TiebaStatic.log(statisticItem3);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fx7 a;

        public b(fx7 fx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fx7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            li7 N1;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.a == null || this.a.i != 0 || (N1 = this.a.a.N1()) == null || N1.c0() == null || N1.c0().m() || N1.e0() || !this.a.b.isShown() || !this.a.a.isPrimary()) {
                return;
            }
            if ((N1.b0() == null || !N1.b0().p()) && !this.a.j && this.a.a.E3() && this.a.k == 1 && this.a.Y() && this.a.c != null && this.a.c.w()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.a.N0();
                this.a.a.c = true;
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fx7 a;

        public c(fx7 fx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fx7Var;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            if (view2 instanceof lk) {
                ((lk) view2).refresh();
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
    public fx7(FrsFragment frsFragment, fn7 fn7Var, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, fn7Var, frsHeaderViewContainer};
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
        this.e = false;
        this.g = 0;
        this.h = "normal_page";
        this.i = 0;
        this.j = false;
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
        this.a = frsFragment;
        this.d = fn7Var;
        this.b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.n = new ex7(this.a, gen);
        this.o = new dx7(this.a);
        this.l = new fz6();
    }

    public final void M(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048588, this, str, i, i2) == null) {
            boolean z = !TextUtils.equals(this.h, str);
            this.k = i2;
            this.h = str;
            w0();
            if (this.c == null || z) {
                rx7 rx7Var = this.c;
                if (rx7Var != null) {
                    rx7Var.x();
                    this.c = null;
                }
                rx7 e = this.d.e(str, this.a, i);
                this.c = e;
                e.c(this.g);
                this.c.J(this.p);
            }
            ex7 ex7Var = this.n;
            if (ex7Var != null) {
                this.c.S(ex7Var);
            }
            dx7 dx7Var = this.o;
            if (dx7Var != null) {
                this.c.Q(dx7Var);
            }
            this.b.a(this.c.n());
            N(str);
            O0();
        }
    }

    public void A0(int i) {
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (rx7Var = this.c) != null) {
            rx7Var.L(i);
        }
    }

    public void E0(int i) {
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && Y() && (rx7Var = this.c) != null) {
            rx7Var.N(i);
        }
    }

    public void F0(FrsViewData frsViewData) {
        ex7 ex7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, frsViewData) == null) && Y() && (ex7Var = this.n) != null) {
            ex7Var.v(this.c, frsViewData);
        }
    }

    public void H0(int i) {
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && (rx7Var = this.c) != null) {
            rx7Var.R(i);
        }
    }

    public void I0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            if (i > 1) {
                rx7 rx7Var = this.c;
                if (rx7Var != null) {
                    rx7Var.P(false);
                    return;
                }
                return;
            }
            rx7 rx7Var2 = this.c;
            if (rx7Var2 != null) {
                rx7Var2.P(true);
            }
        }
    }

    public void J0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.i = i;
        }
    }

    public void K0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void M0(List<iga> list) {
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, list) == null) && (rx7Var = this.c) != null) {
            rx7Var.U(list);
        }
    }

    public void P0(boolean z) {
        dx7 dx7Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z) == null) && (dx7Var = this.o) != null) {
            rx7 rx7Var = this.c;
            if (rx7Var != null && rx7Var.t()) {
                z2 = true;
            } else {
                z2 = false;
            }
            dx7Var.m(z2);
            this.o.p(z);
        }
    }

    public final float S(ForumData forumData) {
        InterceptResult invokeL;
        ex7 ex7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, forumData)) == null) {
            if (forumData != null && (ex7Var = this.n) != null) {
                return ex7Var.l(forumData);
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public boolean g0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i)) == null) {
            this.g = i;
            rx7 rx7Var = this.c;
            if (rx7Var != null) {
                rx7Var.c(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void i0(boolean z) {
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048614, this, z) == null) && (rx7Var = this.c) != null) {
            rx7Var.A(z);
        }
    }

    public void k0(MotionEvent motionEvent) {
        fz6 fz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048616, this, motionEvent) == null) && (fz6Var = this.l) != null) {
            fz6Var.c(motionEvent);
        }
    }

    public void l0(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, num) == null) {
            H0(num.intValue());
            if (Y()) {
                q0();
            }
        }
    }

    public void o0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, frsViewData) == null) && frsViewData != null && Y()) {
            n0(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.h)) {
                this.c.b();
            }
        }
    }

    public void p0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048621, this, i) == null) && Y()) {
            A0(i);
        }
    }

    public void s0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, frsViewData) == null) && frsViewData != null && this.c != null && Y()) {
            this.c.D(S(frsViewData.getForum()));
        }
    }

    public void z0(int i) {
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048630, this, i) == null) && (rx7Var = this.c) != null && rx7Var.i() != null) {
            View findViewById = this.c.i().findViewById(R.id.divider_bottom);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            this.c.q();
        }
    }

    public static boolean b0(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, frsViewData)) == null) {
            if (frsViewData == null || frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().a(), true) || frsViewData.getBookInfo().a().equals("0")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void d0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            ex7 ex7Var = this.n;
            if (ex7Var != null) {
                ex7Var.p();
            }
            dx7 dx7Var = this.o;
            if (dx7Var != null) {
                dx7Var.j();
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void y0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            if (z) {
                rx7 rx7Var = this.c;
                if (rx7Var != null) {
                    this.b.d(rx7Var.i());
                    this.e = false;
                    return;
                }
                return;
            }
            rx7 rx7Var2 = this.c;
            if (rx7Var2 != null && rx7Var2.i() != null && !this.e) {
                this.b.b(this.c.i(), this.b.getHeaderViewsCount());
                this.e = true;
            }
        }
    }

    public static boolean c0(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, frsViewData)) == null) {
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

    public void v0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, str) == null) && this.a.f1() != null && this.a.f1().k0() != null) {
            int S = this.a.f1().k0().S();
            int P = this.a.f1().k0().P();
            int N = this.a.f1().k0().N();
            aga i = aga.i();
            aga.i().n(i.g("1~" + str, S, P, N), false);
        }
    }

    public void D0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, frsViewData, z) == null) && frsViewData != null && Y()) {
            B0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void L0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, str, frsViewData) == null) && frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            M(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public void B0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) != null) || (rx7Var = this.c) == null) {
            return;
        }
        rx7Var.K(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.c.M(i, forumData.getLevelName(), forumData.getUser_level(), S(forumData), z);
        if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
            this.c.a(false);
        }
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && Y()) {
            A0(0);
        }
    }

    public void L() {
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && !this.e && (rx7Var = this.c) != null) {
            this.b.a(rx7Var.i());
            this.e = true;
        }
    }

    public final void N0() {
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && Y() && (rx7Var = this.c) != null) {
            rx7Var.V();
        }
    }

    public String O() {
        InterceptResult invokeV;
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (Y() && (rx7Var = this.c) != null) {
                return rx7Var.j();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            SafeHandler.getInst().postDelayed(this.q, 4000L);
        }
    }

    public boolean P() {
        InterceptResult invokeV;
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (Y() && (rx7Var = this.c) != null) {
                return rx7Var.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean Q() {
        InterceptResult invokeV;
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (Y() && (rx7Var = this.c) != null) {
                return rx7Var.k();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public rx7 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.c;
        }
        return (rx7) invokeV.objValue;
    }

    public void S0() {
        dx7 dx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (dx7Var = this.o) != null) {
            dx7Var.q();
        }
    }

    public dx7 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.o;
        }
        return (dx7) invokeV.objValue;
    }

    public void U() {
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && Y() && (rx7Var = this.c) != null) {
            rx7Var.o();
        }
    }

    public void W() {
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (rx7Var = this.c) != null) {
            rx7Var.q();
        }
    }

    public void X() {
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (rx7Var = this.c) != null) {
            rx7Var.s();
        }
    }

    public boolean a0() {
        InterceptResult invokeV;
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (Y() && (rx7Var = this.c) != null) {
                return rx7Var.u();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            rx7 rx7Var = this.c;
            if (rx7Var != null) {
                rx7Var.x();
            }
            dx7 dx7Var = this.o;
            if (dx7Var != null) {
                dx7Var.k();
            }
            if (this.q != null) {
                SafeHandler.getInst().removeCallbacks(this.q);
            }
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            rx7 rx7Var = this.c;
            if (rx7Var != null) {
                rx7Var.C();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.r);
            }
        }
    }

    public void h0() {
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && (rx7Var = this.c) != null) {
            rx7Var.z();
        }
    }

    public void j0() {
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && (rx7Var = this.c) != null) {
            rx7Var.B();
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.c.F();
        }
    }

    public void q0() {
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (rx7Var = this.c) != null) {
            rx7Var.Z();
        }
    }

    public void r0() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && (frsHeaderViewContainer = this.b) != null) {
            frsHeaderViewContainer.removeCallbacks(this.r);
            this.b.postDelayed(this.r, 100L);
        }
    }

    public void u0() {
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && (rx7Var = this.c) != null) {
            rx7Var.G();
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            rx7 rx7Var = this.c;
            if (rx7Var != null) {
                this.b.d(rx7Var.n());
                this.b.d(this.c.i());
                x0();
            }
            this.e = false;
        }
    }

    public final void x0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && this.m != null && (frsFragment = this.a) != null && frsFragment.e4() != null) {
            this.a.e4().removeHeaderView(this.m.H());
        }
    }

    public final void N(String str) {
        FrsFragment frsFragment;
        RelativeLayout H;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, str) != null) || this.m == null || (frsFragment = this.a) == null || frsFragment.e4() == null || (H = this.m.H()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.e4().removeHeaderView(H);
            return;
        }
        this.a.e4().removeHeaderView(H);
        this.a.e4().addHeaderView(H, 0);
    }

    public void Q0() {
        ex7 ex7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (ex7Var = this.n) != null) {
            rx7 rx7Var = this.c;
            if (rx7Var != null) {
                ex7Var.x(rx7Var.v(), this.c.f());
            } else {
                ex7Var.x(false, "");
            }
            rx7 rx7Var2 = this.c;
            if (rx7Var2 != null) {
                this.n.w(rx7Var2.m());
            }
        }
    }

    public final boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (!"frs_page".equals(this.h) && !"normal_page".equals(this.h) && !"book_page".equals(this.h) && !"brand_page".equals(this.h)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void U0(int i, int i2, int i3) {
        ex7 ex7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048603, this, i, i2, i3) == null) && (ex7Var = this.n) != null) {
            ex7Var.y(i, i2, i3);
        }
    }

    public void n0(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048619, this, forumData, frsViewData) == null) && forumData != null && frsViewData != null) {
            float S = S(forumData);
            rx7 rx7Var = this.c;
            if (rx7Var == null) {
                return;
            }
            rx7Var.K(forumData, frsViewData);
            this.c.M(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), S, false);
            this.c.O(forumData.getSignData());
        }
    }
}
