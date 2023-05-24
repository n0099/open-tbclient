package com.baidu.tieba;

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
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import com.baidu.tieba.personCenter.data.PersonRedTipData;
import com.baidu.tieba.personCenter.data.PersonVipCardData;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import tbclient.BannerImage;
import tbclient.CreationData;
import tbclient.CustomGrid;
import tbclient.NamoaixudEntry;
import tbclient.Personal.PersonalResIdl;
import tbclient.Profile.DataRes;
import tbclient.Profile.Namoaixud;
import tbclient.Profile.ProfileResIdl;
import tbclient.Profile.UserGodInfo;
import tbclient.Profile.VipBanner;
import tbclient.SmartApp;
import tbclient.TbBookrack;
import tbclient.UcCard;
import tbclient.User;
import tbclient.UserGrowth;
import tbclient.UserMap;
/* loaded from: classes5.dex */
public class h79 implements s59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<rn> a;
    public UserData b;
    public List<BannerImage> c;
    public PersonUserGodInfo d;
    public g79 e;
    public i79 f;
    public j79 g;
    public l79 h;
    public l79 i;
    public l79 j;
    public l79 k;
    public m79 l;
    public PersonMoreData m;
    public s79 n;
    public t79 o;
    public p79 p;
    public k79 q;
    public d79 r;
    public PersonVipCardData s;
    public HashMap<String, PersonRedTipData> t;
    public o79 u;
    public ws5 v;

    public h79() {
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
        this.t = new HashMap<>();
        this.u = null;
        this.v = null;
        this.a = new ArrayList<>();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            g79 g79Var = this.e;
            if (g79Var != null) {
                this.a.add(g79Var);
            } else if (this.b == null) {
            } else {
                this.e = new g79();
                this.b.getFansNum();
                this.e.a = this.b.getConcern_num();
                this.e.b = this.b.getLike_bars();
                this.e.c = this.b.getThreadNum();
                g79 g79Var2 = this.e;
                g79Var2.e = this.b;
                this.a.add(g79Var2);
            }
        }
    }

    public UserData A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (UserData) invokeV.objValue;
    }

    public m79 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.l;
        }
        return (m79) invokeV.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            g79 g79Var = this.e;
            if (g79Var != null && this.a.contains(g79Var)) {
                return this.a.indexOf(this.e);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public d79 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.r;
        }
        return (d79) invokeV.objValue;
    }

    public ArrayList<rn> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            o79 o79Var = this.u;
            if (o79Var != null && this.a.contains(o79Var)) {
                return this.a.indexOf(this.u);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void C(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbBookrack) == null) && tbBookrack != null) {
            e69 e69Var = new e69();
            e69Var.a(tbBookrack);
            new h69(true, e69Var);
        }
    }

    public final void D(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ucCard) == null) {
            new x59().a(ucCard);
        }
    }

    public void G(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, userPendantData) == null) {
            this.b.setPendantData(userPendantData);
        }
    }

    public void d(boolean z) {
        l79 l79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (l79Var = this.j) != null) {
            if (l79Var.i == null) {
                l79Var.i = new n79();
            }
            this.j.i.b(z);
        }
    }

    public void e(boolean z) {
        g79 g79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (g79Var = this.e) != null) {
            g79Var.d = z;
        }
    }

    public void f(boolean z) {
        l79 l79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (l79Var = this.k) != null) {
            if (l79Var.i == null) {
                l79Var.i = new n79();
            }
            this.k.i.b(z);
        }
    }

    public void g(boolean z) {
        l79 l79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (l79Var = this.h) != null) {
            if (l79Var.i == null) {
                l79Var.i = new n79();
            }
            this.h.i.b(z);
        }
    }

    public final void l(NamoaixudEntry namoaixudEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, namoaixudEntry) == null) {
            i79 i79Var = this.f;
            if (i79Var != null) {
                this.a.add(i79Var);
                return;
            }
            i79 i79Var2 = new i79();
            this.f = i79Var2;
            i79Var2.d(namoaixudEntry);
            this.a.add(this.f);
        }
    }

    public final void E(List<UserMap> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.m = new PersonMoreData();
        for (UserMap userMap : list) {
            if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                String replaceAll = userMap.url.replaceAll("amp;", "");
                PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                personMoreItemData.mId = userMap.id.intValue();
                personMoreItemData.mName = userMap.name;
                personMoreItemData.mUrl = replaceAll;
                this.m.mUrlMaps.add(personMoreItemData);
            }
        }
    }

    public List<l79> q(List<CustomGrid> list) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                CustomGrid customGrid = list.get(i);
                if (customGrid != null) {
                    c79 c79Var = new c79();
                    c79Var.a(customGrid);
                    l79 b = c79Var.b();
                    boolean z2 = true;
                    if (i == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    b.o = z;
                    if (i != list.size() - 1) {
                        z2 = false;
                    }
                    b.p = z2;
                    if (b.a == 33 && b.m == 0) {
                        if (this.m == null) {
                            this.m = new PersonMoreData();
                        }
                        b.j = OrmObject.bundleWithObject(this.m);
                    }
                    if (b.i == null) {
                        b.i = new n79();
                    }
                    b.i.b(i(c79Var));
                    arrayList.add(b);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void F(User user, UserGodInfo userGodInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, user, userGodInfo) == null) {
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

    @Override // com.baidu.tieba.s59
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, personalResIdl) == null) && personalResIdl != null && personalResIdl.data != null) {
            if (this.b == null) {
                this.b = new UserData();
            }
            this.b.parserProtobuf(personalResIdl.data.user);
            m79 m79Var = new m79();
            this.l = m79Var;
            m79Var.a = this.b;
            this.a.add(m79Var);
            h();
            o();
            PersonRedTipManager.getInstance().syncRedTipState(true);
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                TbadkCoreApplication.getCurrentAccountObj().setSex(this.b.getSex());
            }
        }
    }

    public final void r(List<SmartApp> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048600, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.p == null) {
            p79 p79Var = new p79();
            this.p = p79Var;
            this.a.add(p79Var);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new r79(smartApp));
                }
            }
        }
        this.p.d(arrayList);
    }

    @Override // com.baidu.tieba.s59
    public void b(ProfileResIdl profileResIdl) {
        UserGrowth userGrowth;
        NamoaixudEntry namoaixudEntry;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, profileResIdl) == null) && profileResIdl != null && profileResIdl.data != null) {
            this.l = new m79();
            DataRes dataRes = profileResIdl.data;
            this.c = dataRes.banner;
            Namoaixud namoaixud = dataRes.namoaixud;
            F(dataRes.user, dataRes.user_god_info);
            C(profileResIdl.data.tbbookrack);
            D(profileResIdl.data.uc_card);
            E(profileResIdl.data.url_map);
            if (profileResIdl.data.bubble_info != null) {
                d79 d79Var = new d79();
                this.r = d79Var;
                d79Var.d(profileResIdl.data.bubble_info);
            }
            this.a.clear();
            this.a.add(this.l);
            h();
            z(profileResIdl.data.vip_banner);
            t();
            DataRes dataRes2 = profileResIdl.data;
            if (dataRes2.finance_tab != null && (namoaixudEntry = dataRes2.namoaixud_entry) != null) {
                l(namoaixudEntry);
            }
            User user = profileResIdl.data.user;
            if (user != null && (userGrowth = user.user_growth) != null) {
                s(userGrowth);
            }
            k(profileResIdl.data.user);
            if (!ListUtils.isEmpty(profileResIdl.data.custom_grid)) {
                List<l79> q = q(profileResIdl.data.custom_grid);
                if (!ListUtils.isEmpty(q)) {
                    o79 o79Var = new o79();
                    o79Var.d(q);
                    this.a.add(o79Var);
                    this.u = o79Var;
                } else {
                    p();
                }
            } else {
                p();
            }
            j();
            r(profileResIdl.data.recom_naws_list);
            if (!ListUtils.isEmpty(profileResIdl.data.more_grid)) {
                List<l79> q2 = q(profileResIdl.data.more_grid);
                if (!ListUtils.isEmpty(q2)) {
                    for (l79 l79Var : q2) {
                        if (l79Var != null) {
                            this.a.add(l79Var);
                        }
                    }
                } else {
                    o();
                }
            } else {
                o();
            }
            PersonRedTipManager.getInstance().syncRedTipState(true);
        }
    }

    public final void c(List<ApkDownloadInfoData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, list) == null) && TbadkCoreApplication.getCurrentAccount() != null && list != null && list.size() > 0) {
            HashMap<String, String> e = this.v.e();
            if (e == null) {
                e = new HashMap<>();
            }
            for (int i = 0; i < list.size(); i++) {
                if (!e.containsKey(list.get(i).getApkPackageName())) {
                    if (list.get(i).getStatus() == null) {
                        e.put(list.get(i).getApkPackageName(), ws5.k);
                    } else if (list.get(i).getStatus().status == ws5.g) {
                        e.put(list.get(i).getApkPackageName(), ws5.j);
                        if (this.v.d()) {
                            e.put(ws5.i, ws5.k);
                        } else {
                            e.put(ws5.i, ws5.j);
                        }
                    } else if (list.get(i).getStatus().status == ws5.h) {
                        e.put(list.get(i).getApkPackageName(), ws5.k);
                    } else {
                        e.put(list.get(i).getApkPackageName(), ws5.k);
                    }
                }
            }
            this.v.m(e);
        }
    }

    public final boolean i(c79 c79Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, c79Var)) == null) {
            if (c79Var == null) {
                return false;
            }
            PersonRedTipData personRedTipData = new PersonRedTipData();
            if (c79Var.f != 0) {
                z = true;
            } else {
                z = false;
            }
            personRedTipData.setShow(z);
            personRedTipData.setRedPointVersion(c79Var.f);
            if (this.t == null) {
                this.t = new HashMap<>();
            }
            String s = o65.m().s(o65.q("key_my_tab_item_red_tip_data"), "");
            if (!StringUtils.isNull(s)) {
                new HashMap();
                for (Map.Entry<String, Object> entry : DataExt.toMap(s).entrySet()) {
                    if (entry.getValue() instanceof Map) {
                        PersonRedTipData personRedTipData2 = new PersonRedTipData();
                        if (((Map) entry.getValue()).get("hadShow") instanceof Boolean) {
                            personRedTipData2.setShow(((Boolean) ((Map) entry.getValue()).get("hadShow")).booleanValue());
                        }
                        if (((Map) entry.getValue()).get("redPointVersion") instanceof Long) {
                            personRedTipData2.setRedPointVersion(((Long) ((Map) entry.getValue()).get("redPointVersion")).longValue());
                        }
                        this.t.put(entry.getKey(), personRedTipData2);
                    }
                }
                if (this.t.get(String.valueOf(c79Var.e)) == null) {
                    this.t.put(String.valueOf(c79Var.e), personRedTipData);
                    o65.m().B(o65.q("key_my_tab_item_red_tip_data"), DataExt.toJson(this.t));
                    if (c79Var.f == 0) {
                        return false;
                    }
                    return true;
                }
                if (this.t.get(String.valueOf(c79Var.e)) != null) {
                    if (c79Var.f > ((PersonRedTipData) Objects.requireNonNull(this.t.get(String.valueOf(c79Var.e)))).getRedPointVersion()) {
                        this.t.put(String.valueOf(c79Var.e), personRedTipData);
                        o65.m().B(o65.q("key_my_tab_item_red_tip_data"), DataExt.toJson(this.t));
                        return true;
                    } else if (c79Var.f == ((PersonRedTipData) Objects.requireNonNull(this.t.get(String.valueOf(c79Var.e)))).getRedPointVersion()) {
                        return ((PersonRedTipData) Objects.requireNonNull(this.t.get(String.valueOf(c79Var.e)))).isShow();
                    }
                }
                return false;
            }
            this.t.put(String.valueOf(c79Var.e), personRedTipData);
            o65.m().B(o65.q("key_my_tab_item_red_tip_data"), DataExt.toJson(this.t));
            if (c79Var.f == 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void j() {
        List<ApkDownloadInfoData> list;
        qk0 value;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || !UbsABTestHelper.isShowMyPageDownloadCard()) {
            return;
        }
        t79 t79Var = this.o;
        if (t79Var != null) {
            this.a.add(t79Var);
            return;
        }
        t79 t79Var2 = new t79();
        this.o = t79Var2;
        if (t79Var2 != null && (list = t79Var2.a) != null && t79Var2.b != null) {
            list.clear();
            this.o.b.clear();
            this.v = ws5.c();
            HashMap<String, qk0> a = hk0.b().a();
            if (a != null) {
                for (Map.Entry<String, qk0> entry : a.entrySet()) {
                    if (entry != null && (value = entry.getValue()) != null && value.c.status == ws5.g) {
                        if (this.v.i(value.h.getAbsolutePath()) && !this.v.j(value.d)) {
                            uk0 uk0Var = value.p;
                            ApkDownloadInfoData apkDownloadInfoData = new ApkDownloadInfoData(uk0Var.g, value.h, uk0Var.h, value.c, value.d, value.m, value);
                            if (!this.o.a.contains(apkDownloadInfoData)) {
                                this.o.a.add(apkDownloadInfoData);
                            }
                        } else {
                            this.v.l(value.d);
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
                    t79 t79Var3 = this.o;
                    t79Var3.b.addAll(t79Var3.a);
                } else {
                    t79 t79Var4 = this.o;
                    t79Var4.b.addAll(t79Var4.a.subList(0, 5));
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
                if (!this.v.d() && this.v.f()) {
                    this.v.o();
                }
                this.v.q();
                this.a.add(this.o);
            }
        }
    }

    public final void k(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, user) == null) {
            k79 k79Var = this.q;
            if (k79Var != null) {
                this.a.add(k79Var);
                return;
            }
            CreationData creationData = user.creation_data;
            CreationData creationData2 = user.workcreation_data;
            k79 k79Var2 = new k79();
            this.q = k79Var2;
            k79Var2.e(creationData);
            this.q.f(creationData2);
            this.a.add(this.q);
        }
    }

    public final void s(UserGrowth userGrowth) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, userGrowth) == null) {
            j79 j79Var = this.g;
            if (j79Var != null) {
                this.a.add(j79Var);
                return;
            }
            this.g = new j79();
            ee5 ee5Var = new ee5();
            ee5Var.g(userGrowth);
            this.g.d(ee5Var);
            this.a.add(this.g);
        }
    }

    public final void z(VipBanner vipBanner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, vipBanner) == null) {
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

    public final l79 m(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048595, this, i, i2, i3)) == null) {
            l79 l79Var = new l79();
            l79Var.b = i;
            l79Var.e = TbadkCoreApplication.getInst().getString(i2);
            l79Var.a = i3;
            UserData userData = this.b;
            if (userData != null) {
                l79Var.h = userData;
            }
            return l79Var;
        }
        return (l79) invokeIII.objValue;
    }

    public final l79 n(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            l79 l79Var = new l79();
            l79Var.b = i;
            l79Var.e = str;
            l79Var.a = i2;
            UserData userData = this.b;
            if (userData != null) {
                l79Var.h = userData;
            }
            return l79Var;
        }
        return (l79) invokeCommon.objValue;
    }

    public final void o() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            l79 m = m(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
            this.k = m;
            m.c = true;
            m.o = true;
            this.a.add(m);
            l79 m2 = m(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.obfuscated_res_0x7f0f030b, 39);
            m2.c = true;
            this.a.add(m2);
            l79 n = n(R.drawable.obfuscated_res_0x7f080a14, "订单中心", 47);
            n.g = "tiebaclient://swan/GidbxGjMhcXQsHbhL7KHyLm2qWim65ct/pages/home/index/?_baiduboxapp=%7B%22ext%22%3A%7B%7D%7D&callback=_bdbox_js_275&upgrade=0";
            this.a.add(n);
            l79 n2 = n(R.drawable.obfuscated_res_0x7f080a02, "开店", 48);
            n79 n79Var = new n79();
            n2.i = n79Var;
            n79Var.i = "免佣金";
            n2.g = "https://activity.baidu.com/mbox/4a81af9f62/home";
            this.a.add(n2);
            l79 n3 = n(R.drawable.obfuscated_res_0x7f080b10, "隐私设置", 61);
            n79 n79Var2 = new n79();
            n3.i = n79Var2;
            if (o65.m().n("setting_private_red_dot", 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            n79Var2.a = z;
            this.a.add(n3);
            l79 n4 = n(R.drawable.obfuscated_res_0x7f0809f5, "广告推广", 49);
            n4.g = "https://yingxiao.baidu.com/new/home/topic/detail?name=index&no=644";
            this.a.add(n4);
            if (this.m == null) {
                this.m = new PersonMoreData();
            }
            l79 m3 = m(R.drawable.obfuscated_res_0x7f080a13, R.string.obfuscated_res_0x7f0f0fdb, 33);
            m3.j = OrmObject.bundleWithObject(this.m);
            m3.i = new n79();
            m3.p = true;
            this.a.add(m3);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            o79 o79Var = new o79();
            ArrayList arrayList = new ArrayList();
            l79 m = m(R.drawable.obfuscated_res_0x7f080a00, R.string.member_center, 12);
            m.c = true;
            arrayList.add(m);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f0809f9, R.string.dressup_center_title, 62));
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080971, R.string.certification_center, 53));
            l79 m2 = m(R.drawable.obfuscated_res_0x7f0809f8, R.string.create_ba, 56);
            m2.g = TbConfig.CREATE_BA;
            arrayList.add(m2);
            if (MessageManager.getInstance().findTask(2921431) != null) {
                l79 m3 = m(R.drawable.obfuscated_res_0x7f0809ff, R.string.ala_live, 25);
                m3.c = true;
                m3.f = true;
                arrayList.add(m3);
            }
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a05, R.string.game_hall, 58));
            arrayList.add(m(R.drawable.obfuscated_res_0x7f0809f6, R.string.book_desk, 59));
            if (TbSingleton.getInstance().isBusinessAccount()) {
                l79 m4 = m(R.drawable.obfuscated_res_0x7f0809f7, R.string.official_account, 15);
                m4.c = true;
                arrayList.add(m4);
            }
            l79 m5 = m(R.drawable.obfuscated_res_0x7f0809fe, R.string.account_check, 50);
            m5.g = "https://wappass.baidu.com/v6/safetyInspection?adapter=3";
            arrayList.add(m5);
            l79 m6 = m(R.drawable.obfuscated_res_0x7f0809fb, R.string.obfuscated_res_0x7f0f0caa, 10);
            this.i = m6;
            m6.i = new n79();
            this.i.c = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.b.getTDouNum());
            }
            n79 n79Var = this.i.i;
            n79Var.c = formatNumForTdouDisPlay;
            n79Var.e = CurrencySwitchUtil.getMoneyIcon();
            arrayList.add(this.i);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080991, R.string.welfare_entrance, 63));
            l79 m7 = m(R.drawable.obfuscated_res_0x7f080a04, R.string.mark_center, 51);
            m7.g = TbConfig.TIEBA_ADDRESS + "mo/q/icon/panelIcon?opacity=0&opacitybtnhex=ffffff&user_id=" + this.b.getUserId();
            arrayList.add(m7);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a03, R.string.subscribe_manager, 52));
            l79 m8 = m(R.drawable.obfuscated_res_0x7f0809fc, R.string.novel_member_monthly, 54);
            m8.g = en5.g("https://boxnovel.baidu.com/boxnovel/tbvipright?data={\"fromaction\": \"tieba\"}");
            arrayList.add(m8);
            l79 m9 = m(R.drawable.obfuscated_res_0x7f080a0e, R.string.community_convention, 55);
            m9.g = TbConfig.COMMUNITY_CONVENTION;
            arrayList.add(m9);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f0809fd, R.string.earn_money, 57));
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080c04, R.string.exchange_mall, 60));
            o79Var.d(arrayList);
            this.a.add(o79Var);
            this.u = o79Var;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            s79 s79Var = this.n;
            if (s79Var != null && s79Var.a.size() > 0) {
                this.a.add(this.n);
                return;
            }
            this.n = new s79();
            if (ListUtils.isEmpty(this.c)) {
                return;
            }
            for (int i = 0; i < this.c.size(); i++) {
                b79 b79Var = new b79();
                b79Var.b(this.c.get(i));
                if (!qi.isEmpty(b79Var.a())) {
                    this.n.a.add(b79Var);
                }
            }
            if (this.n.a.size() > 0) {
                this.a.add(this.n);
            }
        }
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            k79 k79Var = this.q;
            if (k79Var != null && this.a.contains(k79Var)) {
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
}
