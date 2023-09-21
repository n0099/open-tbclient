package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
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
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
import com.baidu.tieba.homepagecore.data.ForumSignInResultRespondedMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.wa8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class hx7 extends BdBaseView<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public FrsHeaderViewContainer b;
    public tx7 c;
    public pn7 d;
    public boolean e;
    public BdUniqueId f;
    public int g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public lz6 l;
    public FrsTabViewController m;
    public gx7 n;
    public fx7 o;
    public final View.OnClickListener p;
    public final Runnable q;
    public final HttpMessageListener r;
    public Runnable s;

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hx7 a;

        public a(hx7 hx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f090715);
            FrsViewData t1 = this.a.a.t1();
            if (t1 != null && t1.getForum() != null && this.a.c != null && (view2 == this.a.c.g() || view2 == this.a.c.h() || view2 == this.a.c.l() || logicField == LogicField.INFO_AREA)) {
                StatisticItem statisticItem = new StatisticItem("c12046");
                if (this.a.a != null && t1.getForum() != null) {
                    if (this.a.a.G4()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    statisticItem.param("fid", t1.getForum().getId());
                    statisticItem.param("fname", t1.getForum().getName());
                    statisticItem.param("obj_locate", i);
                    ct7.a(statisticItem);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (t1.getEntelechyTabInfo() != null && t1.getEntelechyTabInfo().a != null) {
                    for (int i2 = 0; i2 < t1.getEntelechyTabInfo().a.size(); i2++) {
                        arrayList.add(t1.getEntelechyTabInfo().a.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.a.getPageContext().getPageActivity(), t1.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                forumDetailActivityConfig.setServiceAreaListData(t1.serviceAreaFlutterData);
                int baWuNoticeNum = t1.getBaWuNoticeNum();
                forumDetailActivityConfig.setRedPotNum(String.valueOf(baWuNoticeNum));
                if (t1.getUserData() != null) {
                    if (t1.getUserData().getIs_manager() == 1 && baWuNoticeNum > 0) {
                        MessageManager.getInstance().sendMessage(new BawuUnreadRequestMessage(this.a.a.l));
                    }
                    t1.setBaWuNoticeNum(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921721));
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (t1.getUserData().getIs_manager() == 1) {
                        if (baWuNoticeNum > 0) {
                            statisticItem.param("obj_type", 1);
                        } else {
                            statisticItem.param("obj_type", 2);
                        }
                    }
                    if (t1.getUserData().isOtherBawu()) {
                        statisticItem.param("obj_type", 3);
                    } else if (t1.getUserData().isNormal()) {
                        statisticItem.param("obj_type", 4);
                    }
                }
                TiebaStatic.log(statisticItem);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view2.getId();
            if (id != R.id.obfuscated_res_0x7f092756 && logicField != LogicField.LIKE_BTN) {
                long j = 0;
                if (id != R.id.obfuscated_res_0x7f0927a2 && logicField != LogicField.SIGN_BTN) {
                    if (id == R.id.obfuscated_res_0x7f090cc2) {
                        if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && t1 != null && t1.getGameUrl() != null) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{t1.getGameUrl()}, true);
                        }
                    } else if (id == R.id.obfuscated_res_0x7f090c63) {
                        if (t1 != null && t1.getUserData() != null && t1.getUserData().isBawu()) {
                            String bawuCenterUrl = t1.getBawuCenterUrl();
                            if (!di.isEmpty(bawuCenterUrl)) {
                                BrowserHelper.startWebActivity(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (t1.getForum() != null) {
                                    TiebaStatic.log(new StatisticItem("c10502").param("fid", t1.getForum().getId()).param("uid", t1.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id != R.id.obfuscated_res_0x7f0914fa && logicField != LogicField.LEVEL_AND_LEVEL_NAME) {
                        if (id == R.id.obfuscated_res_0x7f090ccd) {
                            if (t1 != null && t1.getForum() != null && !TextUtils.isEmpty(t1.getForum().getId())) {
                                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                                hotUserRankActivityConfig.setForumId(Long.valueOf(JavaTypesHelper.toLong(t1.getForum().getId(), 0L)));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                                StatisticItem statisticItem2 = new StatisticItem("c13666");
                                statisticItem2.param("fid", t1.getForum().getId());
                                TiebaStatic.log(statisticItem2);
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090d1c) {
                            if (t1 != null && t1.getForum() != null && !TextUtils.isEmpty(t1.getForum().getId())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(t1.getForum().getId()), t1.getForum().getName())));
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090d1b && ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && t1 != null && t1.getForum() != null && !TextUtils.isEmpty(t1.getForum().getId())) {
                            UrlManager urlManager = UrlManager.getInstance();
                            TbPageContext<?> C = this.a.a.C();
                            urlManager.dealOneLink(C, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + t1.getForum().getId()});
                        }
                    } else if (!this.a.a.h4() && this.a.i == 0 && this.a.V() && this.a.c != null) {
                        ly5.d(t1.getForum().getId(), t1.getUserData().getPortrait(), "1", this.a.mContext.getPageActivity());
                        my5.c("c15281", t1.getForum().getId(), "1");
                    }
                } else if (!this.a.a.h4()) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0e42);
                    } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                        String M = this.a.M();
                        if (!TextUtils.isEmpty(M)) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{M});
                            if (t1 != null && t1.getForum() != null && t1.getForum().getSignData() != null && t1.getForum().getSignData().chatRoomGuideData != null) {
                                j = t1.getForum().getSignData().chatRoomGuideData.a();
                            }
                            TiebaStatic.log(new StatisticItem("c15205").param("obj_type", 2).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.a.w()).param("fname", this.a.a.v()).param("room_id", j));
                            this.a.S();
                        } else if (!this.a.O()) {
                            this.a.M0();
                            StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), JavaTypesHelper.toInt(this.a.a.w(), 0), 24002)));
                        }
                    }
                }
            } else if (!this.a.a.h4()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0e42);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.w()));
                } else {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f0911e0);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        ct7.d(this.a.a.w(), this.a.a.v());
                    }
                    this.a.L0(true);
                    if (!di.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        StatisticItem statisticItem3 = new StatisticItem("c10048");
                        statisticItem3.param("fid", this.a.a.w());
                        statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        TiebaStatic.log(statisticItem3);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hx7 a;

        public b(hx7 hx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hx7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            vi7 R1;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.a == null || this.a.i != 0 || (R1 = this.a.a.R1()) == null || R1.c0() == null || R1.c0().m() || R1.e0() || !this.a.b.isShown() || !this.a.a.isPrimary()) {
                return;
            }
            if ((R1.b0() == null || !R1.b0().p()) && !this.a.j && this.a.a.K3() && this.a.k == 1 && this.a.V() && this.a.c != null && this.a.c.w()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.a.J0();
                this.a.a.c = true;
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hx7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(hx7 hx7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hx7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003577 && (httpResponsedMessage instanceof ForumSignInResultRespondedMessage)) {
                if (!httpResponsedMessage.hasError()) {
                    wa8 data = ((ForumSignInResultRespondedMessage) httpResponsedMessage).getData();
                    if (this.a.a != null && this.a.a.t1() != null) {
                        FrsViewData t1 = this.a.a.t1();
                        wa8.b L = this.a.L(t1, data);
                        if (L != null) {
                            wa8.d c = L.b().c();
                            wa8.a a = L.b().a();
                            boolean b = L.b().b();
                            SignData signData = t1.getSignData();
                            if (signData != null) {
                                signData.miss_sign_num = c.a();
                                signData.is_signed = c.b() ? 1 : 0;
                                if (b) {
                                    signData.showGuideToChatRoom = true;
                                    signData.chatRoomGuideData = new y15(a.a(), a.c(), a.b());
                                }
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (this.a.o != null) {
                    this.a.o.i();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hx7 a;

        public d(hx7 hx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hx7Var;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            if (view2 instanceof kk) {
                ((kk) view2).refresh();
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
    public hx7(FrsFragment frsFragment, pn7 pn7Var, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, pn7Var, frsHeaderViewContainer};
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
        this.r = new c(this, CmdConfigHttp.CMD_HTTP_FORUM_SIGN_IN_RESULT);
        this.s = new d(this);
        this.a = frsFragment;
        this.d = pn7Var;
        this.b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.n = new gx7(this.a, gen);
        this.o = new fx7(this.a);
        this.l = new lz6();
    }

    public final void J(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048586, this, str, i, i2) == null) {
            boolean z = !TextUtils.equals(this.h, str);
            this.k = i2;
            this.h = str;
            t0();
            if (this.c == null || z) {
                tx7 tx7Var = this.c;
                if (tx7Var != null) {
                    tx7Var.x();
                    this.c = null;
                }
                tx7 e = this.d.e(str, this.a, i);
                this.c = e;
                e.c(this.g);
                this.c.J(this.p);
            }
            gx7 gx7Var = this.n;
            if (gx7Var != null) {
                this.c.S(gx7Var);
            }
            fx7 fx7Var = this.o;
            if (fx7Var != null) {
                this.c.Q(fx7Var);
            }
            this.b.a(this.c.n());
            K(str);
            K0();
        }
    }

    public void A0(int i) {
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && V() && (tx7Var = this.c) != null) {
            tx7Var.N(i);
        }
    }

    public void B0(FrsViewData frsViewData) {
        gx7 gx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsViewData) == null) && V() && (gx7Var = this.n) != null) {
            gx7Var.v(this.c, frsViewData);
        }
    }

    public void D0(int i) {
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (tx7Var = this.c) != null) {
            tx7Var.R(i);
        }
    }

    public void E0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (i > 1) {
                tx7 tx7Var = this.c;
                if (tx7Var != null) {
                    tx7Var.P(false);
                    return;
                }
                return;
            }
            tx7 tx7Var2 = this.c;
            if (tx7Var2 != null) {
                tx7Var2.P(true);
            }
        }
    }

    public void F0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.i = i;
        }
    }

    public void G0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void I0(List<oia> list) {
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, list) == null) && (tx7Var = this.c) != null) {
            tx7Var.U(list);
        }
    }

    public void L0(boolean z) {
        fx7 fx7Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && (fx7Var = this.o) != null) {
            tx7 tx7Var = this.c;
            if (tx7Var != null && tx7Var.t()) {
                z2 = true;
            } else {
                z2 = false;
            }
            fx7Var.s(z2);
            this.o.v(z);
        }
    }

    public final float Q(ForumData forumData) {
        InterceptResult invokeL;
        gx7 gx7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, forumData)) == null) {
            if (forumData != null && (gx7Var = this.n) != null) {
                return gx7Var.l(forumData);
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public boolean e0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i)) == null) {
            this.g = i;
            tx7 tx7Var = this.c;
            if (tx7Var != null) {
                tx7Var.c(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void g0(boolean z) {
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048612, this, z) == null) && (tx7Var = this.c) != null) {
            tx7Var.A(z);
        }
    }

    public void i0(MotionEvent motionEvent) {
        lz6 lz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, motionEvent) == null) && (lz6Var = this.l) != null) {
            lz6Var.c(motionEvent);
        }
    }

    public void j0(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, num) == null) {
            D0(num.intValue());
            if (V()) {
                o0();
            }
        }
    }

    public void m0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, frsViewData) == null) && frsViewData != null && V()) {
            l0(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.h)) {
                this.c.b();
            }
        }
    }

    public void n0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048619, this, i) == null) && V()) {
            x0(i);
        }
    }

    public void q0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, frsViewData) == null) && frsViewData != null && this.c != null && V()) {
            this.c.D(Q(frsViewData.getForum()));
        }
    }

    public void w0(int i) {
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048628, this, i) == null) && (tx7Var = this.c) != null && tx7Var.i() != null) {
            View findViewById = this.c.i().findViewById(R.id.divider_bottom);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            this.c.q();
        }
    }

    public void x0(int i) {
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048629, this, i) == null) && (tx7Var = this.c) != null) {
            tx7Var.L(i);
        }
    }

    public static boolean Y(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, frsViewData)) == null) {
            if (frsViewData == null || frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().a(), true) || frsViewData.getBookInfo().a().equals("0")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void v0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            if (z) {
                tx7 tx7Var = this.c;
                if (tx7Var != null) {
                    this.b.d(tx7Var.i());
                    this.e = false;
                    return;
                }
                return;
            }
            tx7 tx7Var2 = this.c;
            if (tx7Var2 != null && tx7Var2.i() != null && !this.e) {
                this.b.b(this.c.i(), this.b.getHeaderViewsCount());
                this.e = true;
            }
        }
    }

    public static boolean Z(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, frsViewData)) == null) {
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

    public void s0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, str) == null) && this.a.m1() != null && this.a.m1().k0() != null) {
            int S = this.a.m1().k0().S();
            int P = this.a.m1().k0().P();
            int N = this.a.m1().k0().N();
            gia i = gia.i();
            gia.i().n(i.g("1~" + str, S, P, N), false);
        }
    }

    public void H0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, frsViewData) == null) && frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            J(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public void z0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048631, this, frsViewData, z) == null) && frsViewData != null && V()) {
            y0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void O0(int i, int i2, int i3) {
        gx7 gx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048597, this, i, i2, i3) == null) && (gx7Var = this.n) != null) {
            gx7Var.y(i, i2, i3);
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && V()) {
            x0(0);
        }
    }

    public void I() {
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && !this.e && (tx7Var = this.c) != null) {
            this.b.a(tx7Var.i());
            this.e = true;
        }
    }

    public final void J0() {
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && V() && (tx7Var = this.c) != null) {
            tx7Var.V();
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            SafeHandler.getInst().postDelayed(this.q, 4000L);
        }
    }

    public String M() {
        InterceptResult invokeV;
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (V() && (tx7Var = this.c) != null) {
                return tx7Var.j();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (V() && (tx7Var = this.c) != null) {
                return tx7Var.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void N0() {
        fx7 fx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (fx7Var = this.o) != null) {
            fx7Var.w();
        }
    }

    public boolean O() {
        InterceptResult invokeV;
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (V() && (tx7Var = this.c) != null) {
                return tx7Var.k();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public tx7 P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.c;
        }
        return (tx7) invokeV.objValue;
    }

    public fx7 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.o;
        }
        return (fx7) invokeV.objValue;
    }

    public void S() {
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && V() && (tx7Var = this.c) != null) {
            tx7Var.o();
        }
    }

    public void T() {
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (tx7Var = this.c) != null) {
            tx7Var.q();
        }
    }

    public void U() {
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (tx7Var = this.c) != null) {
            tx7Var.s();
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (V() && (tx7Var = this.c) != null) {
                return tx7Var.u();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            tx7 tx7Var = this.c;
            if (tx7Var != null) {
                tx7Var.x();
            }
            fx7 fx7Var = this.o;
            if (fx7Var != null) {
                fx7Var.p();
            }
            if (this.q != null) {
                SafeHandler.getInst().removeCallbacks(this.q);
            }
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            tx7 tx7Var = this.c;
            if (tx7Var != null) {
                tx7Var.C();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.s);
            }
        }
    }

    public void f0() {
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (tx7Var = this.c) != null) {
            tx7Var.z();
        }
    }

    public void h0() {
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && (tx7Var = this.c) != null) {
            tx7Var.B();
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.c.F();
        }
    }

    public void o0() {
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && (tx7Var = this.c) != null) {
            tx7Var.Z();
        }
    }

    public void p0() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && (frsHeaderViewContainer = this.b) != null) {
            frsHeaderViewContainer.removeCallbacks(this.s);
            this.b.postDelayed(this.s, 100L);
        }
    }

    public void r0() {
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && (tx7Var = this.c) != null) {
            tx7Var.G();
        }
    }

    public final void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            tx7 tx7Var = this.c;
            if (tx7Var != null) {
                this.b.d(tx7Var.n());
                this.b.d(this.c.i());
                u0();
            }
            this.e = false;
        }
    }

    public final void u0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && this.m != null && (frsFragment = this.a) != null && frsFragment.k4() != null) {
            this.a.k4().removeHeaderView(this.m.H());
        }
    }

    public final void K(String str) {
        FrsFragment frsFragment;
        RelativeLayout H;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, str) != null) || this.m == null || (frsFragment = this.a) == null || frsFragment.k4() == null || (H = this.m.H()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.k4().removeHeaderView(H);
            return;
        }
        this.a.k4().removeHeaderView(H);
        this.a.k4().addHeaderView(H, 0);
    }

    public void b0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bundle) == null) {
            gx7 gx7Var = this.n;
            if (gx7Var != null) {
                gx7Var.p();
            }
            fx7 fx7Var = this.o;
            if (fx7Var != null) {
                fx7Var.o();
            }
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                frsFragment.registerListener(this.r);
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    @Nullable
    public final wa8.b L(FrsViewData frsViewData, wa8 wa8Var) {
        InterceptResult invokeLL;
        String id;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, frsViewData, wa8Var)) == null) {
            if (frsViewData != null && wa8Var != null && !ListUtils.isEmpty(wa8Var.a())) {
                if (frsViewData.getForum() == null) {
                    id = "";
                } else {
                    id = frsViewData.getForum().getId();
                }
                List<wa8.b> a2 = wa8Var.a();
                for (int i = 0; i < a2.size(); i++) {
                    wa8.b bVar = a2.get(i);
                    if (id.equals(String.valueOf(bVar.a()))) {
                        return bVar;
                    }
                }
            }
            return null;
        }
        return (wa8.b) invokeLL.objValue;
    }

    public void M0() {
        gx7 gx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (gx7Var = this.n) != null) {
            tx7 tx7Var = this.c;
            if (tx7Var != null) {
                gx7Var.x(tx7Var.v(), this.c.f());
            } else {
                gx7Var.x(false, "");
            }
            tx7 tx7Var2 = this.c;
            if (tx7Var2 != null) {
                this.n.w(tx7Var2.m());
            }
        }
    }

    public final boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (!"frs_page".equals(this.h) && !"normal_page".equals(this.h) && !"book_page".equals(this.h) && !"brand_page".equals(this.h)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void l0(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048617, this, forumData, frsViewData) == null) && forumData != null && frsViewData != null) {
            float Q = Q(forumData);
            tx7 tx7Var = this.c;
            if (tx7Var == null) {
                return;
            }
            tx7Var.K(forumData, frsViewData);
            this.c.M(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), Q, false);
            this.c.O(forumData.getSignData());
        }
    }

    public void y0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048630, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) != null) || (tx7Var = this.c) == null) {
            return;
        }
        tx7Var.K(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.c.M(i, forumData.getLevelName(), forumData.getUser_level(), Q(forumData), z);
        this.c.O(forumData.getSignData());
        if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
            this.c.a(false);
        }
    }
}
