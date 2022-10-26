package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.basic.AdAppStateManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.flow.data.ApkDownloadInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import com.baidu.tieba.personCenter.data.PersonVipCardData;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tbclient.BannerImage;
import tbclient.CreationData;
import tbclient.DuxiaomanEntry;
import tbclient.Personal.PersonalResIdl;
import tbclient.Profile.DataRes;
import tbclient.Profile.Duxiaoman;
import tbclient.Profile.ProfileResIdl;
import tbclient.Profile.UserGodInfo;
import tbclient.Profile.VipBanner;
import tbclient.SmartApp;
import tbclient.TbBookrack;
import tbclient.UcCard;
import tbclient.User;
import tbclient.UserGrowth;
import tbclient.UserMap;
/* loaded from: classes3.dex */
public class a68 implements m48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList a;
    public UserData b;
    public List c;
    public PersonUserGodInfo d;
    public z58 e;
    public b68 f;
    public c68 g;
    public e68 h;
    public e68 i;
    public e68 j;
    public e68 k;
    public f68 l;
    public PersonMoreData m;
    public l68 n;
    public m68 o;
    public i68 p;
    public d68 q;
    public w58 r;
    public PersonVipCardData s;
    public bi5 t;
    public h68 u;

    public a68() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.a = new ArrayList();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            z58 z58Var = this.e;
            if (z58Var != null) {
                this.a.add(z58Var);
            } else if (this.b == null) {
            } else {
                this.e = new z58();
                this.b.getFansNum();
                this.e.a = this.b.getConcern_num();
                this.e.b = this.b.getLike_bars();
                this.e.c = this.b.getThreadNum();
                z58 z58Var2 = this.e;
                z58Var2.e = this.b;
                this.a.add(z58Var2);
            }
        }
    }

    public final void A(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.m = new PersonMoreData();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            UserMap userMap = (UserMap) it.next();
            if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                String replaceAll = userMap.url.replaceAll("amp;", "");
                PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                personMoreItemData.mId = userMap.id.intValue();
                personMoreItemData.mName = userMap.name;
                personMoreItemData.mUrl = replaceAll;
                Log.e("Anthony", "Title is " + personMoreItemData.mName);
                PrintStream printStream = System.out;
                printStream.println("Anthony: Title is " + personMoreItemData.mName);
                this.m.mUrlMaps.add(personMoreItemData);
            }
        }
    }

    public final void B(User user, UserGodInfo userGodInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, user, userGodInfo) == null) {
            if (this.b == null) {
                this.b = new UserData();
            }
            this.b.parserProtobuf(user);
            if (this.d == null && userGodInfo != null) {
                this.d = new PersonUserGodInfo();
            }
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.b.setIsBigV(true);
                PersonUserGodInfo personUserGodInfo = this.d;
                if (personUserGodInfo != null) {
                    personUserGodInfo.parserProtobuf(userGodInfo);
                }
            }
            this.l.a = this.b;
        }
    }

    public void C(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, userPendantData) == null) {
            this.b.setPendantData(userPendantData);
        }
    }

    public void d(boolean z) {
        e68 e68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048582, this, z) == null) && (e68Var = this.j) != null) {
            if (e68Var.i == null) {
                e68Var.i = new g68();
            }
            this.j.i.a = z;
        }
    }

    public void e(boolean z) {
        z58 z58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (z58Var = this.e) != null) {
            z58Var.d = z;
        }
    }

    public void f(boolean z) {
        e68 e68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (e68Var = this.k) != null) {
            if (e68Var.i == null) {
                e68Var.i = new g68();
            }
            this.k.i.a = z;
        }
    }

    public void g(boolean z) {
        e68 e68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (e68Var = this.h) != null) {
            if (e68Var.i == null) {
                e68Var.i = new g68();
            }
            this.h.i.a = z;
        }
    }

    public final void k(DuxiaomanEntry duxiaomanEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, duxiaomanEntry) == null) {
            b68 b68Var = this.f;
            if (b68Var != null) {
                this.a.add(b68Var);
                return;
            }
            b68 b68Var2 = new b68();
            this.f = b68Var2;
            b68Var2.f(duxiaomanEntry);
            this.a.add(this.f);
        }
    }

    public final void y(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, tbBookrack) == null) && tbBookrack != null) {
            y48 y48Var = new y48();
            y48Var.a(tbBookrack);
            new b58(true, y48Var);
        }
    }

    public final void z(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, ucCard) == null) {
            new r48().a(ucCard);
        }
    }

    @Override // com.baidu.tieba.m48
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, personalResIdl) == null) && personalResIdl != null && personalResIdl.data != null) {
            if (this.b == null) {
                this.b = new UserData();
            }
            this.b.parserProtobuf(personalResIdl.data.user);
            f68 f68Var = new f68();
            this.l = f68Var;
            f68Var.a = this.b;
            this.a.add(f68Var);
            h();
            n();
            PersonRedTipManager.getInstance().syncRedTipState(true);
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                TbadkCoreApplication.getCurrentAccountObj().setSex(this.b.getSex());
            }
        }
    }

    public final void p(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.p == null) {
            i68 i68Var = new i68();
            this.p = i68Var;
            this.a.add(i68Var);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                SmartApp smartApp = (SmartApp) it.next();
                if (smartApp != null) {
                    arrayList.add(new k68(smartApp));
                }
            }
        }
        this.p.f(arrayList);
    }

    @Override // com.baidu.tieba.m48
    public void b(ProfileResIdl profileResIdl) {
        UserGrowth userGrowth;
        DuxiaomanEntry duxiaomanEntry;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, profileResIdl) == null) && profileResIdl != null && profileResIdl.data != null) {
            this.l = new f68();
            DataRes dataRes = profileResIdl.data;
            this.c = dataRes.banner;
            Duxiaoman duxiaoman = dataRes.duxiaoman;
            B(dataRes.user, dataRes.user_god_info);
            y(profileResIdl.data.tbbookrack);
            z(profileResIdl.data.uc_card);
            A(profileResIdl.data.url_map);
            if (profileResIdl.data.bubble_info != null) {
                w58 w58Var = new w58();
                this.r = w58Var;
                w58Var.c(profileResIdl.data.bubble_info);
            }
            this.a.clear();
            this.a.add(this.l);
            h();
            w(profileResIdl.data.vip_banner);
            r();
            DataRes dataRes2 = profileResIdl.data;
            if (dataRes2.finance_tab != null && (duxiaomanEntry = dataRes2.duxiaoman_entry) != null) {
                k(duxiaomanEntry);
            }
            User user = profileResIdl.data.user;
            if (user != null && (userGrowth = user.user_growth) != null) {
                q(userGrowth);
            }
            j(profileResIdl.data.user);
            o();
            i();
            p(profileResIdl.data.recom_swan_list);
            n();
            PersonRedTipManager.getInstance().syncRedTipState(true);
        }
    }

    public final void c(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && TbadkCoreApplication.getCurrentAccount() != null && list != null && list.size() > 0) {
            HashMap e = this.t.e();
            if (e == null) {
                e = new HashMap();
            }
            for (int i = 0; i < list.size(); i++) {
                if (!e.containsKey(((ApkDownloadInfoData) list.get(i)).getApkPackageName())) {
                    if (((ApkDownloadInfoData) list.get(i)).getStatus() == null) {
                        e.put(((ApkDownloadInfoData) list.get(i)).getApkPackageName(), bi5.k);
                    } else if (((ApkDownloadInfoData) list.get(i)).getStatus().status == bi5.g) {
                        e.put(((ApkDownloadInfoData) list.get(i)).getApkPackageName(), bi5.j);
                        if (this.t.d()) {
                            e.put(bi5.i, bi5.k);
                        } else {
                            e.put(bi5.i, bi5.j);
                        }
                    } else if (((ApkDownloadInfoData) list.get(i)).getStatus().status == bi5.h) {
                        e.put(((ApkDownloadInfoData) list.get(i)).getApkPackageName(), bi5.k);
                    } else {
                        e.put(((ApkDownloadInfoData) list.get(i)).getApkPackageName(), bi5.k);
                    }
                }
            }
            this.t.m(e);
        }
    }

    public final void i() {
        List list;
        mk0 mk0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || !UbsABTestHelper.isShowMyPageDownloadCard()) {
            return;
        }
        m68 m68Var = this.o;
        if (m68Var != null) {
            this.a.add(m68Var);
            return;
        }
        m68 m68Var2 = new m68();
        this.o = m68Var2;
        if (m68Var2 != null && (list = m68Var2.a) != null && m68Var2.b != null) {
            list.clear();
            this.o.b.clear();
            this.t = bi5.c();
            HashMap a = dk0.b().a();
            if (a != null) {
                for (Map.Entry entry : a.entrySet()) {
                    if (entry != null && (mk0Var = (mk0) entry.getValue()) != null && mk0Var.c.status == bi5.g) {
                        if (this.t.i(mk0Var.h.getAbsolutePath()) && !this.t.j(mk0Var.d)) {
                            qk0 qk0Var = mk0Var.p;
                            ApkDownloadInfoData apkDownloadInfoData = new ApkDownloadInfoData(qk0Var.g, mk0Var.h, qk0Var.h, mk0Var.c, mk0Var.d, mk0Var.m, mk0Var);
                            if (!this.o.a.contains(apkDownloadInfoData)) {
                                this.o.a.add(apkDownloadInfoData);
                            }
                        } else {
                            this.t.l(mk0Var.d);
                        }
                    }
                }
                if (this.o.a.size() == 0) {
                    if (this.a.contains(this.o)) {
                        this.a.remove(this.o);
                        return;
                    }
                    return;
                }
                Collections.sort(this.o.a);
                if (this.o.a.size() <= 5) {
                    m68 m68Var3 = this.o;
                    m68Var3.b.addAll(m68Var3.a);
                } else {
                    m68 m68Var4 = this.o;
                    m68Var4.b.addAll(m68Var4.a.subList(0, 5));
                }
                if (this.o.b.size() == 0) {
                    return;
                }
                for (ApkDownloadInfoData apkDownloadInfoData2 : this.o.b) {
                    if (apkDownloadInfoData2.getAdDownloadBean() != null) {
                        AdAppStateManager.instance().register(apkDownloadInfoData2.getAdDownloadBean());
                    }
                }
                c(this.o.b);
                if (!this.t.d() && this.t.f()) {
                    this.t.o();
                }
                this.t.q();
                this.a.add(this.o);
            }
        }
    }

    public final void j(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, user) == null) {
            d68 d68Var = this.q;
            if (d68Var != null) {
                this.a.add(d68Var);
                return;
            }
            CreationData creationData = user.creation_data;
            CreationData creationData2 = user.workcreation_data;
            d68 d68Var2 = new d68();
            this.q = d68Var2;
            d68Var2.h(creationData);
            this.q.j(creationData2);
            this.a.add(this.q);
        }
    }

    public final void q(UserGrowth userGrowth) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, userGrowth) == null) {
            c68 c68Var = this.g;
            if (c68Var != null) {
                this.a.add(c68Var);
                return;
            }
            this.g = new c68();
            y45 y45Var = new y45();
            y45Var.g(userGrowth);
            this.g.f(y45Var);
            this.a.add(this.g);
        }
    }

    public final void w(VipBanner vipBanner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, vipBanner) == null) {
            PersonVipCardData personVipCardData = this.s;
            if (personVipCardData != null && personVipCardData.getTitle() != null) {
                this.a.add(this.s);
                return;
            }
            PersonVipCardData personVipCardData2 = new PersonVipCardData();
            this.s = personVipCardData2;
            personVipCardData2.parserProtobuf(vipBanner);
            if (this.s.getTitle() != null) {
                this.a.add(this.s);
            }
        }
    }

    public final e68 l(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048590, this, i, i2, i3)) == null) {
            e68 e68Var = new e68();
            e68Var.b = i;
            e68Var.e = TbadkCoreApplication.getInst().getString(i2);
            e68Var.a = i3;
            UserData userData = this.b;
            if (userData != null) {
                e68Var.h = userData;
            }
            return e68Var;
        }
        return (e68) invokeIII.objValue;
    }

    public final e68 m(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            e68 e68Var = new e68();
            e68Var.b = i;
            e68Var.e = str;
            e68Var.a = i2;
            UserData userData = this.b;
            if (userData != null) {
                e68Var.h = userData;
            }
            return e68Var;
        }
        return (e68) invokeCommon.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            e68 l = l(R.drawable.icon_mask_wo_list_serve24_svg, R.string.obfuscated_res_0x7f0f0e95, 31);
            this.k = l;
            boolean z = true;
            l.c = true;
            this.a.add(l);
            e68 l2 = l(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.obfuscated_res_0x7f0f02da, 39);
            l2.c = true;
            this.a.add(l2);
            e68 m = m(R.drawable.obfuscated_res_0x7f080874, "订单中心", 47);
            m.g = "tiebaclient://swan/GidbxGjMhcXQsHbhL7KHyLm2qWim65ct/pages/home/index/?_baiduboxapp=%7B%22ext%22%3A%7B%7D%7D&callback=_bdbox_js_275&upgrade=0";
            this.a.add(m);
            e68 m2 = m(R.drawable.obfuscated_res_0x7f080861, "开店", 48);
            m2.g = "https://activity.baidu.com/mbox/4a81af9f62/home";
            this.a.add(m2);
            e68 m3 = m(R.drawable.obfuscated_res_0x7f080961, "隐私设置", 61);
            g68 g68Var = new g68();
            m3.i = g68Var;
            if (ux4.k().l("setting_private_red_dot", 1) != 1) {
                z = false;
            }
            g68Var.a = z;
            this.a.add(m3);
            e68 m4 = m(R.drawable.obfuscated_res_0x7f080855, "广告推广", 49);
            m4.g = "https://yingxiao.baidu.com/new/home/topic/detail?name=index&no=644";
            this.a.add(m4);
            if (this.m == null) {
                this.m = new PersonMoreData();
            }
            e68 l3 = l(R.drawable.obfuscated_res_0x7f080873, R.string.obfuscated_res_0x7f0f0e53, 33);
            l3.j = OrmObject.bundleWithObject(this.m);
            l3.i = new g68();
            PrintStream printStream = System.out;
            printStream.println("Anthony: " + l3.j.toString());
            this.a.add(l3);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            h68 h68Var = new h68();
            ArrayList arrayList = new ArrayList();
            e68 l = l(R.drawable.obfuscated_res_0x7f08085f, R.string.obfuscated_res_0x7f0f0ad9, 12);
            l.c = true;
            arrayList.add(l);
            HashMap hashMap = new HashMap();
            hashMap.put("uid", this.b.getUserId());
            hashMap.put("entryType", "1");
            arrayList.add(l(R.drawable.obfuscated_res_0x7f0807da, R.string.obfuscated_res_0x7f0f0390, 53));
            e68 l2 = l(R.drawable.obfuscated_res_0x7f080858, R.string.obfuscated_res_0x7f0f0474, 56);
            l2.g = TbConfig.CREATE_BA;
            arrayList.add(l2);
            if (MessageManager.getInstance().findTask(2921431) != null) {
                e68 l3 = l(R.drawable.obfuscated_res_0x7f08085e, R.string.obfuscated_res_0x7f0f0226, 25);
                l3.c = true;
                l3.f = true;
                arrayList.add(l3);
            }
            arrayList.add(l(R.drawable.obfuscated_res_0x7f080864, R.string.obfuscated_res_0x7f0f07bc, 58));
            arrayList.add(l(R.drawable.obfuscated_res_0x7f080856, R.string.obfuscated_res_0x7f0f032c, 59));
            if (TbSingleton.getInstance().isBusinessAccount()) {
                e68 l4 = l(R.drawable.obfuscated_res_0x7f080857, R.string.obfuscated_res_0x7f0f0cf9, 15);
                l4.c = true;
                arrayList.add(l4);
            }
            e68 l5 = l(R.drawable.obfuscated_res_0x7f08085d, R.string.obfuscated_res_0x7f0f006b, 50);
            l5.g = "https://wappass.baidu.com/v6/safetyInspection?adapter=3";
            arrayList.add(l5);
            e68 l6 = l(R.drawable.obfuscated_res_0x7f08085a, R.string.obfuscated_res_0x7f0f0b6f, 10);
            this.i = l6;
            l6.i = new g68();
            this.i.c = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.b.getTDouNum());
            }
            g68 g68Var = this.i.i;
            g68Var.c = formatNumForTdouDisPlay;
            g68Var.e = CurrencySwitchUtil.getMoneyIcon();
            arrayList.add(this.i);
            e68 l7 = l(R.drawable.obfuscated_res_0x7f080860, R.string.obfuscated_res_0x7f0f0387, 18);
            l7.c = true;
            arrayList.add(l7);
            e68 l8 = l(R.drawable.obfuscated_res_0x7f080863, R.string.obfuscated_res_0x7f0f0ab9, 51);
            l8.g = TbConfig.TIEBA_ADDRESS + "mo/q/icon/panelIcon?opacity=0&opacitybtnhex=ffffff&user_id=" + this.b.getUserId();
            arrayList.add(l8);
            arrayList.add(l(R.drawable.obfuscated_res_0x7f080862, R.string.obfuscated_res_0x7f0f1250, 52));
            e68 l9 = l(R.drawable.obfuscated_res_0x7f08085b, R.string.obfuscated_res_0x7f0f0ced, 54);
            l9.g = pc5.g("https://boxnovel.baidu.com/boxnovel/tbvipright?data={\"fromaction\": \"tieba\"}");
            arrayList.add(l9);
            e68 l10 = l(R.drawable.obfuscated_res_0x7f08086d, R.string.obfuscated_res_0x7f0f0428, 55);
            l10.g = TbConfig.COMMUNITY_CONVENTION;
            arrayList.add(l10);
            arrayList.add(l(R.drawable.obfuscated_res_0x7f08085c, R.string.obfuscated_res_0x7f0f0537, 57));
            arrayList.add(l(R.drawable.obfuscated_res_0x7f080a51, R.string.obfuscated_res_0x7f0f05d7, 60));
            h68Var.f(arrayList);
            this.a.add(h68Var);
            this.u = h68Var;
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            l68 l68Var = this.n;
            if (l68Var != null && l68Var.a.size() > 0) {
                this.a.add(this.n);
                return;
            }
            this.n = new l68();
            if (ListUtils.isEmpty(this.c)) {
                return;
            }
            for (int i = 0; i < this.c.size(); i++) {
                v58 v58Var = new v58();
                v58Var.b((BannerImage) this.c.get(i));
                if (!ej.isEmpty(v58Var.a())) {
                    this.n.a.add(v58Var);
                }
            }
            if (this.n.a.size() > 0) {
                this.a.add(this.n);
            }
        }
    }

    public w58 s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.r;
        }
        return (w58) invokeV.objValue;
    }

    public ArrayList u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public UserData x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.b;
        }
        return (UserData) invokeV.objValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            d68 d68Var = this.q;
            if (d68Var != null && this.a.contains(d68Var)) {
                for (int i = 0; i < this.a.size(); i++) {
                    if (this.a.get(i) == this.q) {
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            h68 h68Var = this.u;
            if (h68Var != null && this.a.contains(h68Var)) {
                for (int i = 0; i < this.a.size(); i++) {
                    if (this.a.get(i) == this.u) {
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }
}
