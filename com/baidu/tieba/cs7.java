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
/* loaded from: classes5.dex */
public class cs7 extends j9<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public FrsHeaderViewContainer b;
    public os7 c;
    public li7 d;
    public boolean e;
    public BdUniqueId f;
    public int g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public vw6 l;
    public FrsTabViewController m;
    public bs7 n;
    public as7 o;
    public final View.OnClickListener p;
    public final Runnable q;
    public Runnable r;

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cs7 a;

        public a(cs7 cs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cs7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f090714);
            FrsViewData c1 = this.a.a.c1();
            if (c1 != null && c1.getForum() != null && this.a.c != null && (view2 == this.a.c.f() || view2 == this.a.c.g() || view2 == this.a.c.k() || logicField == LogicField.INFO_AREA)) {
                StatisticItem statisticItem = new StatisticItem("c12046");
                if (this.a.a != null && c1.getForum() != null) {
                    if (this.a.a.h4()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    statisticItem.param("fid", c1.getForum().getId());
                    statisticItem.param("fname", c1.getForum().getName());
                    statisticItem.param("obj_locate", i);
                    fo7.a(statisticItem);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (c1.getEntelechyTabInfo() != null && c1.getEntelechyTabInfo().a != null) {
                    for (int i2 = 0; i2 < c1.getEntelechyTabInfo().a.size(); i2++) {
                        arrayList.add(c1.getEntelechyTabInfo().a.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.a.getPageContext().getPageActivity(), c1.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                forumDetailActivityConfig.setServiceAreaListData(c1.serviceAreaFlutterData);
                int baWuNoticeNum = c1.getBaWuNoticeNum();
                forumDetailActivityConfig.setRedPotNum(String.valueOf(baWuNoticeNum));
                if (c1.getUserData() != null) {
                    if (c1.getUserData().getIs_manager() == 1 && baWuNoticeNum > 0) {
                        MessageManager.getInstance().sendMessage(new BawuUnreadRequestMessage(this.a.a.l));
                    }
                    c1.setBaWuNoticeNum(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921721));
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (c1.getUserData().getIs_manager() == 1) {
                        if (baWuNoticeNum > 0) {
                            statisticItem.param("obj_type", 1);
                        } else {
                            statisticItem.param("obj_type", 2);
                        }
                    }
                    if (c1.getUserData().isOtherBawu()) {
                        statisticItem.param("obj_type", 3);
                    } else if (c1.getUserData().isNormal()) {
                        statisticItem.param("obj_type", 4);
                    }
                }
                TiebaStatic.log(statisticItem);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view2.getId();
            if (id != R.id.obfuscated_res_0x7f0926d4 && logicField != LogicField.LIKE_BTN) {
                long j = 0;
                if (id != R.id.obfuscated_res_0x7f09271e && logicField != LogicField.SIGN_BTN) {
                    if (id == R.id.obfuscated_res_0x7f090ca8) {
                        if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && c1 != null && c1.getGameUrl() != null) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{c1.getGameUrl()}, true);
                        }
                    } else if (id == R.id.obfuscated_res_0x7f090c49) {
                        if (c1 != null && c1.getUserData() != null && c1.getUserData().isBawu()) {
                            String bawuCenterUrl = c1.getBawuCenterUrl();
                            if (!wi.isEmpty(bawuCenterUrl)) {
                                ux4.s(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (c1.getForum() != null) {
                                    TiebaStatic.log(new StatisticItem("c10502").param("fid", c1.getForum().getId()).param("uid", c1.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id != R.id.obfuscated_res_0x7f0914c9 && logicField != LogicField.LEVEL_AND_LEVEL_NAME) {
                        if (id == R.id.obfuscated_res_0x7f090cb3) {
                            if (c1 != null && c1.getForum() != null && !TextUtils.isEmpty(c1.getForum().getId())) {
                                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                                hotUserRankActivityConfig.setForumId(Long.valueOf(vg.g(c1.getForum().getId(), 0L)));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                                StatisticItem statisticItem2 = new StatisticItem("c13666");
                                statisticItem2.param("fid", c1.getForum().getId());
                                TiebaStatic.log(statisticItem2);
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090d02) {
                            if (c1 != null && c1.getForum() != null && !TextUtils.isEmpty(c1.getForum().getId())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(c1.getForum().getId()), c1.getForum().getName())));
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090d01 && ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && c1 != null && c1.getForum() != null && !TextUtils.isEmpty(c1.getForum().getId())) {
                            UrlManager urlManager = UrlManager.getInstance();
                            TbPageContext<?> t = this.a.a.t();
                            urlManager.dealOneLink(t, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + c1.getForum().getId()});
                        }
                    } else if (!this.a.a.K3() && this.a.i == 0 && this.a.X() && this.a.c != null) {
                        fy5.d(c1.getForum().getId(), c1.getUserData().getPortrait(), "1", this.a.mContext.getPageActivity());
                        gy5.c("c15281", c1.getForum().getId(), "1");
                    }
                } else if (!this.a.a.K3()) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0e0f);
                    } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                        String P = this.a.P();
                        if (!TextUtils.isEmpty(P)) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{P});
                            if (c1 != null && c1.getForum() != null && c1.getForum().getSignData() != null && c1.getForum().getSignData().chatRoomGuideData != null) {
                                j = c1.getForum().getSignData().chatRoomGuideData.a();
                            }
                            TiebaStatic.log(new StatisticItem("c15205").param("obj_type", 2).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.a.w()).param("fname", this.a.a.v()).param("room_id", j));
                            this.a.U();
                        } else if (!this.a.R()) {
                            this.a.R0();
                            StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), vg.e(this.a.a.w(), 0), 24002)));
                        }
                    }
                }
            } else if (!this.a.a.K3()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0e0f);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.w()));
                } else {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f0911ae);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        fo7.d(this.a.a.w(), this.a.a.v());
                    }
                    this.a.Q0(true);
                    if (!wi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
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
        public final /* synthetic */ cs7 a;

        public b(cs7 cs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cs7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            yd7 y1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.i == 0 && (y1 = this.a.a.y1()) != null && y1.c0() != null && !y1.c0().l() && !y1.e0() && this.a.b.isShown() && this.a.a.isPrimary() && !this.a.j && this.a.a.n3() && this.a.k == 1 && this.a.X() && this.a.c != null && this.a.c.v()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.a.O0();
                this.a.a.c = true;
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cs7 a;

        public c(cs7 cs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cs7Var;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            if (view2 instanceof fl) {
                ((fl) view2).refresh();
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
    public cs7(FrsFragment frsFragment, li7 li7Var, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, li7Var, frsHeaderViewContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((l9) newInitContext.callArgs[0]);
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
        this.d = li7Var;
        this.b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.n = new bs7(this.a, gen);
        this.o = new as7(this.a);
        this.l = new vw6();
    }

    public final void N(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048588, this, str, i, i2) == null) {
            boolean z = !TextUtils.equals(this.h, str);
            this.k = i2;
            this.h = str;
            w0();
            if (this.c == null || z) {
                os7 os7Var = this.c;
                if (os7Var != null) {
                    os7Var.w();
                    this.c = null;
                }
                os7 e = this.d.e(str, this.a, i);
                this.c = e;
                e.c(this.g);
                this.c.I(this.p);
            }
            bs7 bs7Var = this.n;
            if (bs7Var != null) {
                this.c.R(bs7Var);
            }
            as7 as7Var = this.o;
            if (as7Var != null) {
                this.c.P(as7Var);
            }
            this.b.a(this.c.m());
            O(str);
            P0();
        }
    }

    public void C0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, frsViewData, z) == null) && frsViewData != null && X()) {
            B0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void M0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, str, frsViewData) == null) && frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            N(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public void A0(int i) {
        os7 os7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (os7Var = this.c) != null) {
            os7Var.K(i);
        }
    }

    public void D0(int i) {
        os7 os7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && X() && (os7Var = this.c) != null) {
            os7Var.M(i);
        }
    }

    public void E0(FrsViewData frsViewData) {
        bs7 bs7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, frsViewData) == null) && X() && (bs7Var = this.n) != null) {
            bs7Var.v(this.c, frsViewData);
        }
    }

    public void G0(int i) {
        os7 os7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && (os7Var = this.c) != null) {
            os7Var.Q(i);
        }
    }

    public void I0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            if (i > 1) {
                os7 os7Var = this.c;
                if (os7Var != null) {
                    os7Var.O(false);
                    return;
                }
                return;
            }
            os7 os7Var2 = this.c;
            if (os7Var2 != null) {
                os7Var2.O(true);
            }
        }
    }

    public void K0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.i = i;
        }
    }

    public void L0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void N0(List<b3a> list) {
        os7 os7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, list) == null) && (os7Var = this.c) != null) {
            os7Var.T(list);
        }
    }

    public void Q0(boolean z) {
        as7 as7Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z) == null) && (as7Var = this.o) != null) {
            os7 os7Var = this.c;
            if (os7Var != null && os7Var.s()) {
                z2 = true;
            } else {
                z2 = false;
            }
            as7Var.m(z2);
            this.o.p(z);
        }
    }

    public final float S(ForumData forumData) {
        InterceptResult invokeL;
        bs7 bs7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, forumData)) == null) {
            if (forumData != null && (bs7Var = this.n) != null) {
                return bs7Var.l(forumData);
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public boolean f0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) {
            this.g = i;
            os7 os7Var = this.c;
            if (os7Var != null) {
                os7Var.c(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void h0(boolean z) {
        os7 os7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048613, this, z) == null) && (os7Var = this.c) != null) {
            os7Var.z(z);
        }
    }

    public void j0(MotionEvent motionEvent) {
        vw6 vw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048615, this, motionEvent) == null) && (vw6Var = this.l) != null) {
            vw6Var.c(motionEvent);
        }
    }

    public void k0(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, num) == null) {
            G0(num.intValue());
            if (X()) {
                q0();
            }
        }
    }

    public void o0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, frsViewData) == null) && frsViewData != null && X()) {
            n0(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.h)) {
                this.c.b();
            }
        }
    }

    public void p0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048620, this, i) == null) && X()) {
            A0(i);
        }
    }

    public void s0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, frsViewData) == null) && frsViewData != null && this.c != null && X()) {
            this.c.C(S(frsViewData.getForum()));
        }
    }

    public void z0(int i) {
        os7 os7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048629, this, i) == null) && (os7Var = this.c) != null && os7Var.h() != null) {
            View findViewById = this.c.h().findViewById(R.id.divider_bottom);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            this.c.p();
        }
    }

    public static boolean a0(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, frsViewData)) == null) {
            if (frsViewData == null || frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().a(), true) || frsViewData.getBookInfo().a().equals("0")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void c0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            bs7 bs7Var = this.n;
            if (bs7Var != null) {
                bs7Var.p();
            }
            as7 as7Var = this.o;
            if (as7Var != null) {
                as7Var.j();
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void y0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            if (z) {
                os7 os7Var = this.c;
                if (os7Var != null) {
                    this.b.d(os7Var.h());
                    this.e = false;
                    return;
                }
                return;
            }
            os7 os7Var2 = this.c;
            if (os7Var2 != null && os7Var2.h() != null && !this.e) {
                this.b.b(this.c.h(), this.b.getHeaderViewsCount());
                this.e = true;
            }
        }
    }

    public static boolean b0(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, frsViewData)) == null) {
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
        if ((interceptable == null || interceptable.invokeL(1048625, this, str) == null) && this.a.V0() != null && this.a.V0().s0() != null) {
            int a0 = this.a.V0().s0().a0();
            int X = this.a.V0().s0().X();
            int V = this.a.V0().s0().V();
            t2a i = t2a.i();
            t2a.i().n(i.g("1~" + str, a0, X, V), false);
        }
    }

    public void B0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        os7 os7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) != null) || (os7Var = this.c) == null) {
            return;
        }
        os7Var.J(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.c.L(i, forumData.getLevelName(), forumData.getUser_level(), S(forumData), z);
        if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
            this.c.a(false);
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && X()) {
            A0(0);
        }
    }

    public void M() {
        os7 os7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && !this.e && (os7Var = this.c) != null) {
            this.b.a(os7Var.h());
            this.e = true;
        }
    }

    public final void O0() {
        os7 os7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && X() && (os7Var = this.c) != null) {
            os7Var.U();
        }
    }

    public String P() {
        InterceptResult invokeV;
        os7 os7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (X() && (os7Var = this.c) != null) {
                return os7Var.i();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            yg.a().postDelayed(this.q, 4000L);
        }
    }

    public boolean Q() {
        InterceptResult invokeV;
        os7 os7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (X() && (os7Var = this.c) != null) {
                return os7Var.o();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        os7 os7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (X() && (os7Var = this.c) != null) {
                return os7Var.j();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void S0() {
        as7 as7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (as7Var = this.o) != null) {
            as7Var.q();
        }
    }

    public as7 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.o;
        }
        return (as7) invokeV.objValue;
    }

    public void U() {
        os7 os7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && X() && (os7Var = this.c) != null) {
            os7Var.n();
        }
    }

    public void V() {
        os7 os7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (os7Var = this.c) != null) {
            os7Var.p();
        }
    }

    public void W() {
        os7 os7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (os7Var = this.c) != null) {
            os7Var.r();
        }
    }

    public boolean Z() {
        InterceptResult invokeV;
        os7 os7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (X() && (os7Var = this.c) != null) {
                return os7Var.t();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            os7 os7Var = this.c;
            if (os7Var != null) {
                os7Var.w();
            }
            as7 as7Var = this.o;
            if (as7Var != null) {
                as7Var.k();
            }
            if (this.q != null) {
                yg.a().removeCallbacks(this.q);
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            os7 os7Var = this.c;
            if (os7Var != null) {
                os7Var.B();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.r);
            }
        }
    }

    public void g0() {
        os7 os7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (os7Var = this.c) != null) {
            os7Var.y();
        }
    }

    public void i0() {
        os7 os7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && (os7Var = this.c) != null) {
            os7Var.A();
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.c.E();
        }
    }

    public void q0() {
        os7 os7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && (os7Var = this.c) != null) {
            os7Var.Y();
        }
    }

    public void r0() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (frsHeaderViewContainer = this.b) != null) {
            frsHeaderViewContainer.removeCallbacks(this.r);
            this.b.postDelayed(this.r, 100L);
        }
    }

    public void u0() {
        os7 os7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && (os7Var = this.c) != null) {
            os7Var.F();
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            os7 os7Var = this.c;
            if (os7Var != null) {
                this.b.d(os7Var.m());
                this.b.d(this.c.h());
                x0();
            }
            this.e = false;
        }
    }

    public final void x0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && this.m != null && (frsFragment = this.a) != null && frsFragment.M3() != null) {
            this.a.M3().removeHeaderView(this.m.H());
        }
    }

    public final void O(String str) {
        FrsFragment frsFragment;
        RelativeLayout H;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, str) != null) || this.m == null || (frsFragment = this.a) == null || frsFragment.M3() == null || (H = this.m.H()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.M3().removeHeaderView(H);
            return;
        }
        this.a.M3().removeHeaderView(H);
        this.a.M3().addHeaderView(H, 0);
    }

    public void R0() {
        bs7 bs7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (bs7Var = this.n) != null) {
            os7 os7Var = this.c;
            if (os7Var != null) {
                bs7Var.x(os7Var.u(), this.c.e());
            } else {
                bs7Var.x(false, "");
            }
            os7 os7Var2 = this.c;
            if (os7Var2 != null) {
                this.n.w(os7Var2.l());
            }
        }
    }

    public final boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (!"frs_page".equals(this.h) && !"normal_page".equals(this.h) && !"book_page".equals(this.h) && !"brand_page".equals(this.h)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void T0(int i, int i2, int i3) {
        bs7 bs7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048601, this, i, i2, i3) == null) && (bs7Var = this.n) != null) {
            bs7Var.y(i, i2, i3);
        }
    }

    public void n0(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048618, this, forumData, frsViewData) == null) && forumData != null && frsViewData != null) {
            float S = S(forumData);
            os7 os7Var = this.c;
            if (os7Var == null) {
                return;
            }
            os7Var.J(forumData, frsViewData);
            this.c.L(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), S, false);
            this.c.N(forumData.getSignData());
        }
    }
}
