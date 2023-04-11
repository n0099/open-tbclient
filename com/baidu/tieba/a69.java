package com.baidu.tieba;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.personPolymeric.header.PersonIntroductionActivity;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.view.FollowUserSpinnerBtn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes3.dex */
public class a69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public g59 b;
    public UserData c;
    public z59 d;
    public boolean e;
    public r95 f;
    public d59 g;
    public View.OnClickListener h;
    public CustomMessageListener i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        public a(a69 a69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a69Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.d.z()) {
                    this.a.w();
                } else if (view2 == this.a.d.r()) {
                    this.a.r();
                } else if (view2 == this.a.d.v()) {
                    TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "3"));
                    TiebaStatic.log("igift_icon_ck");
                    this.a.D();
                } else if (view2 == this.a.d.D()) {
                    if (this.a.e) {
                        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "7"));
                        this.a.E();
                    }
                } else if (view2 != this.a.d.y() && view2 != this.a.d.x()) {
                    if (view2 == this.a.d.C()) {
                        this.a.z();
                    } else if (view2 == this.a.d.s()) {
                        this.a.s();
                    } else if (view2 == this.a.d.t()) {
                        this.a.t();
                    } else if (view2 == this.a.d.u()) {
                        this.a.u();
                    } else if (view2 == this.a.d.w()) {
                        this.a.v();
                    } else if (view2 == this.a.d.B()) {
                        if (this.a.e) {
                            TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "0"));
                        } else {
                            TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "1"));
                        }
                        this.a.y();
                    } else if (view2 == this.a.d.A()) {
                        this.a.x();
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "14"));
                    if (this.a.e) {
                        if (this.a.c != null && this.a.c.isBaijiahaoUser()) {
                            PersonIntroductionActivity.x1(this.a.a.getPageActivity(), this.a.c.getIntro());
                        }
                        this.a.E();
                        return;
                    }
                    this.a.c.getBaijiahaoInfo();
                    PersonIntroductionActivity.x1(this.a.a.getPageActivity(), this.a.c.getIntro());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a69 a69Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var, Integer.valueOf(i)};
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
            this.a = a69Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().c)) {
                if (updateAttentionMessage.getData().a) {
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(this.a.a.getUniqueId())) {
                        if (updateAttentionMessage.isAttention()) {
                            this.a.c.setLike(true);
                            return;
                        }
                        if (!updateAttentionMessage.getData().g) {
                            this.a.a.showToast(R.string.unlike_success);
                        }
                        this.a.c.setLike(false);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 != null && message2.getTag() != null && message2.getTag().equals(this.a.a.getUniqueId())) {
                    this.a.d.N(this.a.c.isLike());
                    if (updateAttentionMessage.getData() != null && !hi.isEmpty(updateAttentionMessage.getData().b)) {
                        this.a.a.showToast(updateAttentionMessage.getData().b);
                    } else if (this.a.c.getIsLike()) {
                        this.a.a.showToast(R.string.unlike_failure);
                    } else {
                        this.a.a.showToast(R.string.attention_fail);
                    }
                }
            }
        }
    }

    public a69(TbPageContext tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this);
        this.i = new b(this, 2001115);
        this.a = tbPageContext;
        this.e = z;
        this.d = new z59(this.a, this.e, this.h);
        this.a.registerListener(this.i);
        TbPageContext tbPageContext2 = this.a;
        this.g = new d59(tbPageContext2, tbPageContext2.getUniqueId(), z);
    }

    public void A(Intent intent) {
        d59 d59Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, intent) == null) && (d59Var = this.g) != null) {
            d59Var.o(intent);
        }
    }

    public void F(int i) {
        z59 z59Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (z59Var = this.d) != null) {
            z59Var.H(i);
        }
    }

    public void H(v49 v49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, v49Var) == null) {
            this.d.K(v49Var);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.d.L(z);
        }
    }

    public void K(String str) {
        z59 z59Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && (z59Var = this.d) != null) {
            z59Var.O(str);
        }
    }

    public FollowUserSpinnerBtn B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d.r();
        }
        return (FollowUserSpinnerBtn) invokeV.objValue;
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d.E();
        }
        return (View) invokeV.objValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d59 d59Var = this.g;
            if (d59Var != null) {
                d59Var.z();
            }
            z59 z59Var = this.d;
            if (z59Var != null) {
                z59Var.I();
            }
        }
    }

    public void q() {
        d59 d59Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (d59Var = this.g) != null) {
            d59Var.n();
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.a.getPageActivity(), this.c.getUserIdLong(), this.c.getUserName(), this.c.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, giftTabActivityConfig));
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "4"));
            it4.x(this.a.getPageActivity(), this.a.getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.c.getUserId() + "&opacity=0", true, true, true);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || TbadkCoreApplication.getCurrentAccountInfo() == null) {
            return;
        }
        PersonChangeData personChangeData = new PersonChangeData();
        UserData userData = this.c;
        if (userData != null) {
            personChangeData.setPortrait(userData.getPortrait());
            personChangeData.setName(this.c.getUserName());
            personChangeData.setSex(this.c.getSex());
            personChangeData.setIntro(this.c.getIntro());
            personChangeData.setNameShow(this.c.getName_show());
            personChangeData.setMem(this.c.getIsMem());
            personChangeData.setForumAge(this.c.getTb_age());
            personChangeData.setCanModifyAvatar(this.c.canModifyAvatar());
            personChangeData.setCantModifyAvatarDesc(this.c.getCantModifyAvatarDesc());
            personChangeData.setTiebaId(this.c.getmTiebaUid());
            AlaUserInfoData alaUserInfoData = this.c.alaUserData;
            if (alaUserInfoData != null) {
                personChangeData.setAlaId(alaUserInfoData.ala_id);
            }
            NicknameInfo nicknameInfo = this.b.A;
            if (nicknameInfo != null) {
                personChangeData.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (this.c.getBirthdayInfo() != null) {
                personChangeData.setUserAge(this.c.getBirthdayInfo().c);
                personChangeData.setBirthdayTime(this.c.getBirthdayInfo().a);
                personChangeData.setBirthdayShowStatus(this.c.getBirthdayInfo().d);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || !ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
            return;
        }
        if (this.f == null) {
            r95 r95Var = new r95(this.a);
            this.f = r95Var;
            r95Var.f(true);
        }
        this.f.i(!this.c.isLike(), this.c.getPortrait(), this.c.getUserId(), this.c.isGod(), "2", this.a.getUniqueId(), null, "0");
        this.d.N(true ^ this.c.isLike());
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
        statisticItem.param("obj_id", this.c.getUserId());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        TbPageContext tbPageContext = this.a;
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.a.getPageActivity().getIntent() != null) {
            statisticItem.param("nid", this.a.getPageActivity().getIntent().getStringExtra("nid"));
        }
        TbPageContext tbPageContext2 = this.a;
        if (tbPageContext2 != null) {
            kl5.e(tbPageContext2.getPageActivity(), statisticItem);
        }
        TbPageContext tbPageContext3 = this.a;
        if (tbPageContext3 != null && tbPageContext3.getPageActivity() != null && kl5.j(this.a.getPageActivity()) != null && kl5.j(this.a.getPageActivity()).b() != null && !TextUtils.isEmpty(kl5.j(this.a.getPageActivity()).b().locatePage) && "a002".equals(kl5.j(this.a.getPageActivity()).b().locatePage)) {
            statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, kl5.j(this.a.getPageActivity()).b().locatePage);
            statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a011");
        }
        TiebaStatic.log(statisticItem);
    }

    public final void u() {
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13574");
            statisticItem.param("obj_type", this.e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "10"));
            if (!ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                return;
            }
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.c.getUserId());
            int i2 = 1;
            if (this.c.getIsFriend() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (this.c.getPersonPrivate() == null) {
                J(this.c.getSex());
            } else if (this.c.getPersonPrivate().Q() != 1 && !equals && (!z || this.c.getPersonPrivate().Q() != 2)) {
                J(this.c.getSex());
            } else {
                if (TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.c.getUserId())) {
                    i = 1;
                } else {
                    i = 2;
                }
                if (!this.c.isGod()) {
                    i2 = 2;
                }
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 4).param("obj_type", i).param("obj_source", i2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.a.getPageActivity(), this.c.getLike_bars(), this.c.getUserId(), this.c.getSex())));
            }
        }
    }

    public final void J(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            BdToast b2 = BdToast.b(this.a.getPageActivity(), String.format(this.a.getString(R.string.person_privacy_toast), StringHelper.getUserDescByGender(i)));
            b2.g(BdToast.ToastIcon.FAILURE);
            b2.o();
        }
    }

    public void p(g59 g59Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, g59Var) == null) && g59Var != null && g59Var.j() != null) {
            this.b = g59Var;
            this.c = g59Var.j();
            this.d.q(this.b.j(), this.b.g());
            this.g.B(g59Var);
        }
    }

    public final void s() {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13575");
            statisticItem.param("obj_type", this.e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "9"));
            if (!ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                return;
            }
            if (TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.c.getUserId())) {
                i = 1;
            } else {
                i = 2;
            }
            if (this.c.isGod()) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 2).param("obj_type", i).param("obj_source", i2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.a.getPageActivity(), true, this.c.getUserId(), this.c.getSex()).updateFollowNum(this.c.getConcernNum(), this.c.getPortrait())));
        }
    }

    public final void t() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13573");
            statisticItem.param("obj_type", this.e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "8"));
            if (!ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                return;
            }
            int i2 = 2;
            PersonRedTipManager.getInstance().updateRedTipState(2, false, this.e);
            if (TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.c.getUserId())) {
                i = 1;
            } else {
                i = 2;
            }
            if (this.c.isGod()) {
                i2 = 1;
            }
            TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 3).param("obj_type", i).param("obj_source", i2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.a.getPageActivity(), false, this.c.getUserId(), this.c.getSex())));
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            AlaUserInfoData alaUserData = this.c.getAlaUserData();
            if (!this.e && alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                TiebaStatic.log("c12542");
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = alaUserData.live_id;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.a.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION, null, false, "")));
                return;
            }
            cc5 cc5Var = new cc5();
            if (!StringUtils.isNull(this.c.getPortrait()) && this.c.getPortrait().startsWith("http")) {
                cc5Var.d(this.c.getPortrait());
                cc5Var.f(this.c.getPortrait());
                cc5Var.e(true);
            } else {
                cc5Var.d(this.c.getPortraitH());
                cc5Var.f(this.c.getPortrait());
                cc5Var.e(true);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(cc5Var);
            this.g.q(cc5Var, arrayList, 0);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "6"));
            if (this.e) {
                if (!ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.a, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            ArrayList<IconData> tShowInfo = this.c.getTShowInfo();
            if (ListUtils.getItem(tShowInfo, 0) != null) {
                UrlManager.getInstance().dealOneLink(this.a, new String[]{tShowInfo.get(0).getUrl()});
            }
        }
    }

    public final void x() {
        UserData userData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (userData = this.c) != null && userData.getLiveRoomInfo() != null && !TextUtils.isEmpty(this.c.getLiveRoomInfo().jump_url)) {
            UrlManager.getInstance().dealOneLink(this.a, new String[]{this.c.getLiveRoomInfo().jump_url}, true);
        }
    }

    public final void y() {
        g59 g59Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (g59Var = this.b) != null && g59Var.g() != null && !TextUtils.isEmpty(this.b.g().b)) {
            UrlManager.getInstance().dealOneLink(this.a, new String[]{this.b.g().b}, true);
        }
    }
}
