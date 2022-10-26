package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import tbclient.SignActivityInfo;
/* loaded from: classes3.dex */
public class du6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public List<TBSpecificationBtn> b;
    public String c;
    public BdUniqueId d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public SignActivityInfo i;
    public String j;
    public Map<String, Date> k;
    public boolean l;
    public CustomMessageListener m;
    public CustomMessageListener n;
    public AntiHelper.k o;
    public CustomMessageListener p;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ du6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(du6 du6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {du6Var, Integer.valueOf(i)};
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
            this.a = du6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            FrsViewData O0;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            boolean z2;
            boolean z3;
            qh6 j1;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.a == null || !(customResponsedMessage instanceof SignMessage) || (O0 = this.a.a.O0()) == null || O0.getForum() == null || (name = (forum = O0.getForum()).getName()) == null || !name.equals(FrsActivityStatic.c) || customResponsedMessage.getOrginalMessage().getTag() != this.a.d) {
                return;
            }
            TiebaStatic.eventStat(this.a.a.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
            String name2 = forum.getName();
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            if (AntiHelper.m(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                if (signMessage.signData != null) {
                    AntiHelper.t(this.a.a.getActivity(), signMessage.signData.blockPopInfoData, this.a.o);
                } else {
                    AntiHelper.u(this.a.a.getActivity(), signMessage.mSignErrorString);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
                return;
            }
            eu6 n0 = this.a.a.n0();
            boolean z4 = false;
            if (signMessage != null && (signData = signMessage.signData) != null) {
                String str = signData.forumId;
                if (str != null && str.equals(forum.getId())) {
                    if (n0 != null) {
                        n0.d0(name2);
                    }
                    O0.updateSignData(signData);
                    signData.forumId = forum.getId();
                    signData.forumName = forum.getName();
                    z = true;
                } else {
                    return;
                }
            } else {
                signData = null;
                z = false;
            }
            if (z) {
                int user_level = forum.getUser_level();
                if (n0 != null) {
                    z2 = n0.H();
                } else {
                    z2 = false;
                }
                if (z2) {
                    int user_level2 = forum.getUser_level();
                    if (user_level >= user_level2) {
                        user_level2++;
                    }
                    user_level = user_level2;
                }
                TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, user_level);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                try {
                    i = new JSONObject(signData.userInfoJson).getInt("activity_status");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (i == 1 || i == 2) {
                    z3 = true;
                    if (!z3 && this.a.h) {
                        if (signData != null && this.a.i != null) {
                            try {
                                JSONObject jSONObject = new JSONObject(signData.userInfoJson);
                                jSONObject.put("activity_id", this.a.i.activity_id);
                                jSONObject.put("activity_suc_msg", this.a.i.activity_suc_msg);
                                jSONObject.put("activity_fail_msg", this.a.i.activity_fail_msg);
                                jSONObject.put("gift_type", this.a.i.gift_type);
                                jSONObject.put("gift_url", this.a.i.gift_url);
                                jSONObject.put("gift_name", this.a.i.gift_name);
                                jSONObject.put("icon_name", this.a.i.icon_name);
                                jSONObject.put("icon_lifecycle", this.a.i.icon_lifecycle);
                                jSONObject.put("activity_name", this.a.i.activity_name);
                                jSONObject.put("image_url", this.a.i.image_url);
                                s25.c().i(jSONObject.toString());
                            } catch (Exception unused) {
                            }
                        }
                        TbPageContext<?> o = this.a.a.o();
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a.a.getActivity(), "", this.a.j, false, true, true);
                        tbWebViewActivityConfig.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                        o.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
                        gm4.f().j().b();
                        return;
                    } else if (!this.a.n() && signData.contDays > 0) {
                        s25.c().i(signData.userInfoJson);
                        TbPageContext<?> o2 = this.a.a.o();
                        TbWebViewActivityConfig tbWebViewActivityConfig2 = new TbWebViewActivityConfig(this.a.a.getActivity(), "", this.a.c, false, true, true);
                        tbWebViewActivityConfig2.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                        o2.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig2));
                        gm4.f().j().b();
                        return;
                    } else {
                        s25.c().i(null);
                        if (n0 == null && !n0.z()) {
                            this.a.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f076c, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                        } else {
                            this.a.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f076b, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                        }
                        j1 = this.a.a.j1();
                        Date m = this.a.m();
                        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.a.a.o().getContext()).areNotificationsEnabled();
                        if (q25.d().D() && areNotificationsEnabled) {
                            z4 = true;
                        }
                        if (j1 == null && !z4 && this.a.l && p35.g(TbadkCoreApplication.getInst(), 4)) {
                            s25.c().a(1, this.a.a.o(), j1.p0(), true);
                            du6 du6Var = this.a;
                            du6Var.k.put(du6Var.a.k(), m);
                            TbSingleton.getInstance().setHasShowTip(this.a.k);
                            return;
                        }
                        return;
                    }
                }
                z3 = false;
                if (!z3) {
                }
                if (!this.a.n()) {
                }
                s25.c().i(null);
                if (n0 == null) {
                }
                this.a.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f076b, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                j1 = this.a.a.j1();
                Date m2 = this.a.m();
                boolean areNotificationsEnabled2 = NotificationManagerCompat.from(this.a.a.o().getContext()).areNotificationsEnabled();
                if (q25.d().D()) {
                    z4 = true;
                }
                if (j1 == null) {
                    return;
                }
                return;
            }
            if (signMessage.mSignErrorCode == 160002 && n0 != null) {
                n0.m0(1);
            }
            this.a.a.showToast(signMessage.mSignErrorString);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ du6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(du6 du6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {du6Var, Integer.valueOf(i)};
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
            this.a = du6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.a == null) {
                return;
            }
            Date m = this.a.m();
            if (this.a.a.j1() != null && this.a.l && p35.g(TbadkCoreApplication.getInst(), 4)) {
                s25.c().a(1, this.a.a.o(), this.a.a.j1().p0(), false);
                du6 du6Var = this.a;
                du6Var.k.put(du6Var.a.k(), m);
                TbSingleton.getInstance().setHasShowTip(this.a.k);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(du6 du6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {du6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pu4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ du6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(du6 du6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {du6Var, Integer.valueOf(i)};
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
            this.a = du6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            FrsViewData O0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.a != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (O0 = this.a.a.O0()) != null && O0.getForum() != null) {
                ForumData forum = O0.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                String str = signData.forumId;
                if (str != null && str.equals(forum.getId())) {
                    O0.updateSignData(signData);
                    eu6 n0 = this.a.a.n0();
                    boolean z = false;
                    if (n0 != null) {
                        n0.n0(O0);
                        z = n0.H();
                    }
                    if (z) {
                        int user_level2 = forum.getUser_level();
                        if (user_level >= user_level2) {
                            user_level2++;
                        }
                        user_level = user_level2;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, user_level);
                }
            }
        }
    }

    public du6(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.j = "https://tieba.baidu.com/mo/q/signActivityPage";
        this.k = new HashMap();
        this.l = false;
        this.m = new a(this, 2001425);
        this.n = new b(this, 2921738);
        this.o = new c(this);
        this.p = new d(this, 2001222);
        this.a = frsFragment;
        this.d = bdUniqueId;
        this.c = TbSingleton.getInstance().getWalletSignLink();
    }

    public void x(boolean z, String str) {
        String name;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048590, this, z, str) == null) {
            this.h = z;
            TbSingleton.getInstance().setActivityId(str);
            FrsFragment frsFragment = this.a;
            if (frsFragment == null) {
                return;
            }
            FrsViewData O0 = frsFragment.O0();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (O0 != null && O0.getForum() != null) {
                    ForumData forum = O0.getForum();
                    forum.setFromPage("frs");
                    if (forum.getName() == null) {
                        name = "";
                    } else {
                        name = forum.getName();
                    }
                    FrsActivityStatic.c = name;
                    CustomMessage customMessage = new CustomMessage(2001425, forum);
                    customMessage.setTag(this.d);
                    MessageManager.getInstance().sendMessage(customMessage);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage(2002001, new LoginActivityConfig(this.a.getActivity(), true, 11014)));
        }
    }

    public void j(List<TBSpecificationBtn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.b = list;
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z && !this.g) {
            StatisticItem.make("c13560").param("obj_type", 1).eventStat();
            this.g = true;
        }
    }

    public float l(ForumData forumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumData)) == null) {
            if (forumData == null) {
                return 0.0f;
            }
            this.e = forumData.getLevelupScore();
            int curScore = forumData.getCurScore();
            this.f = curScore;
            int i = this.e;
            if (i <= 0) {
                return 0.0f;
            }
            return curScore / i;
        }
        return invokeL.floatValue;
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                r();
            } else if (n()) {
                u();
            } else {
                t();
            }
        }
    }

    public void w(SignActivityInfo signActivityInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, signActivityInfo) == null) {
            this.i = signActivityInfo;
        }
    }

    public Date m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.k == null) {
                this.k = new HashMap();
            } else {
                this.k = TbSingleton.getInstance().getHasShowTip();
            }
            Date date = new Date(System.currentTimeMillis());
            if (this.k.size() != 0 && this.k.containsKey(this.a.k())) {
                if (TimeHelper.getDayDifference(this.k.get(this.a.k()), date) >= 1) {
                    this.l = true;
                }
            } else {
                this.l = true;
            }
            return date;
        }
        return (Date) invokeV.objValue;
    }

    public final void r() {
        TBSpecificationBtn next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Iterator<TBSpecificationBtn> it = this.b.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
                next.getLayoutParams().width = -2;
                next.setPadding(0, 0, 0, 0);
                next.setTextSize(R.dimen.T_X08);
                next.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f11b1));
                TBSpecificationButtonConfig styleConfig = next.getStyleConfig();
                styleConfig.g(dimenPixelSize);
                styleConfig.f(fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
                styleConfig.o(TBSpecificationButtonConfig.WebpType.MASK);
                styleConfig.i(R.drawable.obfuscated_res_0x7f0807f1, 0, TBSpecificationButtonConfig.IconType.WEBP);
                next.k();
            }
        }
    }

    public final void t() {
        TBSpecificationBtn next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            Iterator<TBSpecificationBtn> it = this.b.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
                next.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
                next.setPadding(0, 0, 0, 0);
                next.setTextSize(R.dimen.T_X08);
                next.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f11b1));
                TBSpecificationButtonConfig styleConfig = next.getStyleConfig();
                styleConfig.g(dimenPixelSize);
                styleConfig.i(R.drawable.obfuscated_res_0x7f080958, 0, TBSpecificationButtonConfig.IconType.WEBP);
                styleConfig.o(TBSpecificationButtonConfig.WebpType.PURE);
                next.k();
            }
        }
    }

    public final void u() {
        TBSpecificationBtn next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Iterator<TBSpecificationBtn> it = this.b.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
                next.getLayoutParams().width = -2;
                next.setPadding(0, 0, 0, 0);
                next.setTextSize(R.dimen.T_X08);
                next.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f11b1));
                TBSpecificationButtonConfig styleConfig = next.getStyleConfig();
                styleConfig.g(dimenPixelSize);
                styleConfig.f(fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
                styleConfig.o(TBSpecificationButtonConfig.WebpType.MASK);
                styleConfig.i(R.drawable.obfuscated_res_0x7f0807f2, 0, TBSpecificationButtonConfig.IconType.WEBP);
                next.k();
            }
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return !TextUtils.isEmpty(this.c);
        }
        return invokeV.booleanValue;
    }

    public void p() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (frsFragment = this.a) != null) {
            frsFragment.registerListener(this.m);
            this.a.registerListener(this.p);
            this.a.registerListener(this.n);
        }
    }

    public void o(mu6 mu6Var, SignData signData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, mu6Var, signData) == null) && mu6Var != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.e - this.f) {
                z = true;
                this.e = signData.levelup_score;
            }
            int i2 = this.f + i;
            this.f = i2;
            int i3 = this.e;
            if (i2 > i3) {
                this.f = i3;
            }
            int i4 = this.e;
            if (i4 != 0) {
                f = this.f / i4;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            mu6Var.B(z, f);
        }
    }

    public void q(int i) {
        TBSpecificationBtn next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            Iterator<TBSpecificationBtn> it = this.b.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
                next.getLayoutParams().width = -2;
                next.setPadding(0, 0, 0, 0);
                TBSpecificationButtonConfig styleConfig = next.getStyleConfig();
                styleConfig.g(dimenPixelSize);
                if (i > 0) {
                    next.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0aff), Integer.valueOf(i)));
                    styleConfig.i(R.drawable.obfuscated_res_0x7f080959, 0, TBSpecificationButtonConfig.IconType.WEBP);
                } else {
                    next.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f11d0));
                    styleConfig.i(R.drawable.obfuscated_res_0x7f080958, 0, TBSpecificationButtonConfig.IconType.WEBP);
                }
                styleConfig.o(TBSpecificationButtonConfig.WebpType.PURE);
                next.setTextSize(R.dimen.T_X08);
                next.k();
                next.setVisibility(0);
                next.setTag(R.id.obfuscated_res_0x7f090fcd, Boolean.TRUE);
            }
        }
    }

    public void v(mu6 mu6Var, FrsViewData frsViewData) {
        ForumData forum;
        SignData signData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, mu6Var, frsViewData) != null) || frsViewData == null || frsViewData.getForum() == null || mu6Var == null || (signData = (forum = frsViewData.getForum()).getSignData()) == null) {
            return;
        }
        mu6Var.H(forum, frsViewData);
        mu6Var.L(signData.is_signed);
        if (signData.sign_bonus_point > 0 && mu6Var.m()) {
            o(mu6Var, signData);
            forum.setCurScore(this.f);
            forum.setLevelupScore(this.e);
            mu6Var.H(forum, frsViewData);
        }
    }

    public void y(int i, int i2, int i3) {
        FrsFragment frsFragment;
        FrsViewData O0;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048591, this, i, i2, i3) == null) && (frsFragment = this.a) != null && i > 0 && i2 > 0 && (O0 = frsFragment.O0()) != null && O0.getForum() != null && O0.getSignData() != null) {
            ForumData forum = O0.getForum();
            SignData signData = O0.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            O0.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            eu6 n0 = this.a.n0();
            if (n0 != null) {
                z = n0.H();
            } else {
                z = false;
            }
            int i4 = -1;
            if (z) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
