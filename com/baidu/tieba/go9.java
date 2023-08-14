package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
/* loaded from: classes6.dex */
public class go9 implements rm9 {
    public static /* synthetic */ Interceptable $ic;
    public static final String w;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ym> a;
    public UserData b;
    public List<BannerImage> c;
    public PersonUserGodInfo d;
    public fo9 e;
    public ho9 f;
    public io9 g;
    public ko9 h;
    public ko9 i;
    public ko9 j;
    public ko9 k;
    public lo9 l;
    public PersonMoreData m;
    public ro9 n;
    public so9 o;
    public oo9 p;
    public jo9 q;
    public co9 r;
    public PersonVipCardData s;
    public HashMap<String, PersonRedTipData> t;
    public no9 u;
    public cw5 v;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947800792, "Lcom/baidu/tieba/go9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947800792, "Lcom/baidu/tieba/go9;");
                return;
            }
        }
        w = TbConfig.TIEBA_ADDRESS + "mo/q/hybrid-usergrow-base/novelChannel?channel_id=personal_tieba_story&customfullscreen=1&nonavigationbar=1&user_skin_overlay=0";
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            jo9 jo9Var = this.q;
            if (jo9Var != null && this.a.contains(jo9Var)) {
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

    public go9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
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
            fo9 fo9Var = this.e;
            if (fo9Var != null) {
                this.a.add(fo9Var);
            } else if (this.b == null) {
            } else {
                this.e = new fo9();
                this.b.getFansNum();
                this.e.a = this.b.getConcern_num();
                this.e.b = this.b.getLike_bars();
                this.e.c = this.b.getThreadNum();
                fo9 fo9Var2 = this.e;
                fo9Var2.e = this.b;
                this.a.add(fo9Var2);
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

    public lo9 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.l;
        }
        return (lo9) invokeV.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            fo9 fo9Var = this.e;
            if (fo9Var != null && this.a.contains(fo9Var)) {
                return this.a.indexOf(this.e);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public co9 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.r;
        }
        return (co9) invokeV.objValue;
    }

    public ArrayList<ym> x() {
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
            no9 no9Var = this.u;
            if (no9Var != null && this.a.contains(no9Var)) {
                return this.a.indexOf(this.u);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void C(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbBookrack) == null) && tbBookrack != null) {
            dn9 dn9Var = new dn9();
            dn9Var.a(tbBookrack);
            new gn9(true, dn9Var);
        }
    }

    public final void D(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ucCard) == null) {
            new wm9().a(ucCard);
        }
    }

    public void G(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, userPendantData) == null) {
            this.b.setPendantData(userPendantData);
        }
    }

    public void d(boolean z) {
        ko9 ko9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (ko9Var = this.j) != null) {
            if (ko9Var.h == null) {
                ko9Var.h = new mo9();
            }
            this.j.h.b(z);
        }
    }

    public void e(boolean z) {
        fo9 fo9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (fo9Var = this.e) != null) {
            fo9Var.d = z;
        }
    }

    public void f(boolean z) {
        ko9 ko9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (ko9Var = this.k) != null) {
            if (ko9Var.h == null) {
                ko9Var.h = new mo9();
            }
            this.k.h.b(z);
        }
    }

    public void g(boolean z) {
        ko9 ko9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (ko9Var = this.h) != null) {
            if (ko9Var.h == null) {
                ko9Var.h = new mo9();
            }
            this.h.h.b(z);
        }
    }

    public final void l(NamoaixudEntry namoaixudEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, namoaixudEntry) == null) {
            ho9 ho9Var = this.f;
            if (ho9Var != null) {
                this.a.add(ho9Var);
                return;
            }
            ho9 ho9Var2 = new ho9();
            this.f = ho9Var2;
            ho9Var2.d(namoaixudEntry);
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

    public List<ko9> q(List<CustomGrid> list) {
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
                    bo9 bo9Var = new bo9();
                    bo9Var.a(customGrid);
                    ko9 b = bo9Var.b();
                    boolean z2 = true;
                    if (i == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    b.n = z;
                    if (i != list.size() - 1) {
                        z2 = false;
                    }
                    b.o = z2;
                    if (b.a == 33 && b.l == 0) {
                        if (this.m == null) {
                            this.m = new PersonMoreData();
                        }
                        b.i = OrmObject.bundleWithObject(this.m);
                    }
                    if (b.h == null) {
                        b.h = new mo9();
                    }
                    b.h.b(i(bo9Var));
                    b.g = this.b;
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

    @Override // com.baidu.tieba.rm9
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, personalResIdl) == null) && personalResIdl != null && personalResIdl.data != null) {
            if (this.b == null) {
                this.b = new UserData();
            }
            this.b.parserProtobuf(personalResIdl.data.user);
            lo9 lo9Var = new lo9();
            this.l = lo9Var;
            lo9Var.a = this.b;
            this.a.add(lo9Var);
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
            oo9 oo9Var = new oo9();
            this.p = oo9Var;
            this.a.add(oo9Var);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new qo9(smartApp));
                }
            }
        }
        this.p.d(arrayList);
    }

    @Override // com.baidu.tieba.rm9
    public void b(ProfileResIdl profileResIdl) {
        UserGrowth userGrowth;
        NamoaixudEntry namoaixudEntry;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, profileResIdl) == null) && profileResIdl != null && profileResIdl.data != null) {
            this.l = new lo9();
            DataRes dataRes = profileResIdl.data;
            this.c = dataRes.banner;
            Namoaixud namoaixud = dataRes.namoaixud;
            F(dataRes.user, dataRes.user_god_info);
            C(profileResIdl.data.tbbookrack);
            D(profileResIdl.data.uc_card);
            E(profileResIdl.data.url_map);
            if (profileResIdl.data.bubble_info != null) {
                co9 co9Var = new co9();
                this.r = co9Var;
                co9Var.d(profileResIdl.data.bubble_info);
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
                List<ko9> q = q(profileResIdl.data.custom_grid);
                if (!ListUtils.isEmpty(q)) {
                    no9 no9Var = new no9();
                    no9Var.d(q);
                    this.a.add(no9Var);
                    this.u = no9Var;
                } else {
                    p();
                }
            } else {
                p();
            }
            j();
            r(profileResIdl.data.recom_naws_list);
            if (!ListUtils.isEmpty(profileResIdl.data.more_grid)) {
                List<ko9> q2 = q(profileResIdl.data.more_grid);
                if (!ListUtils.isEmpty(q2)) {
                    for (ko9 ko9Var : q2) {
                        if (ko9Var != null) {
                            this.a.add(ko9Var);
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
                        e.put(list.get(i).getApkPackageName(), cw5.k);
                    } else if (list.get(i).getStatus().status == cw5.g) {
                        e.put(list.get(i).getApkPackageName(), cw5.j);
                        if (this.v.d()) {
                            e.put(cw5.i, cw5.k);
                        } else {
                            e.put(cw5.i, cw5.j);
                        }
                    } else if (list.get(i).getStatus().status == cw5.h) {
                        e.put(list.get(i).getApkPackageName(), cw5.k);
                    } else {
                        e.put(list.get(i).getApkPackageName(), cw5.k);
                    }
                }
            }
            this.v.m(e);
        }
    }

    public final boolean i(bo9 bo9Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bo9Var)) == null) {
            if (bo9Var == null) {
                return false;
            }
            PersonRedTipData personRedTipData = new PersonRedTipData();
            if (bo9Var.f != 0) {
                z = true;
            } else {
                z = false;
            }
            personRedTipData.setShow(z);
            personRedTipData.setRedPointVersion(bo9Var.f);
            if (this.t == null) {
                this.t = new HashMap<>();
            }
            String string = SharedPrefHelper.getInstance().getString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_my_tab_item_red_tip_data"), "");
            if (!StringUtils.isNull(string)) {
                new HashMap();
                for (Map.Entry<String, Object> entry : DataExt.toMap(string).entrySet()) {
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
                if (this.t.get(String.valueOf(bo9Var.e)) == null) {
                    this.t.put(String.valueOf(bo9Var.e), personRedTipData);
                    SharedPrefHelper.getInstance().putString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_my_tab_item_red_tip_data"), DataExt.toJson(this.t));
                    if (bo9Var.f == 0) {
                        return false;
                    }
                    return true;
                }
                if (this.t.get(String.valueOf(bo9Var.e)) != null) {
                    if (bo9Var.f > ((PersonRedTipData) Objects.requireNonNull(this.t.get(String.valueOf(bo9Var.e)))).getRedPointVersion()) {
                        this.t.put(String.valueOf(bo9Var.e), personRedTipData);
                        SharedPrefHelper.getInstance().putString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_my_tab_item_red_tip_data"), DataExt.toJson(this.t));
                        return true;
                    } else if (bo9Var.f == ((PersonRedTipData) Objects.requireNonNull(this.t.get(String.valueOf(bo9Var.e)))).getRedPointVersion()) {
                        return ((PersonRedTipData) Objects.requireNonNull(this.t.get(String.valueOf(bo9Var.e)))).isShow();
                    }
                }
                return false;
            }
            this.t.put(String.valueOf(bo9Var.e), personRedTipData);
            SharedPrefHelper.getInstance().putString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_my_tab_item_red_tip_data"), DataExt.toJson(this.t));
            if (bo9Var.f == 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void j() {
        List<ApkDownloadInfoData> list;
        el0 value;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || !UbsABTestHelper.isShowMyPageDownloadCard()) {
            return;
        }
        so9 so9Var = this.o;
        if (so9Var != null) {
            this.a.add(so9Var);
            return;
        }
        so9 so9Var2 = new so9();
        this.o = so9Var2;
        if (so9Var2 != null && (list = so9Var2.a) != null && so9Var2.b != null) {
            list.clear();
            this.o.b.clear();
            this.v = cw5.c();
            HashMap<String, el0> a = vk0.b().a();
            if (a != null) {
                for (Map.Entry<String, el0> entry : a.entrySet()) {
                    if (entry != null && (value = entry.getValue()) != null && value.c.status == cw5.g) {
                        if (this.v.i(value.h.getAbsolutePath()) && !this.v.j(value.d)) {
                            il0 il0Var = value.p;
                            ApkDownloadInfoData apkDownloadInfoData = new ApkDownloadInfoData(il0Var.g, value.h, il0Var.h, value.c, value.d, value.m, value);
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
                    so9 so9Var3 = this.o;
                    so9Var3.b.addAll(so9Var3.a);
                } else {
                    so9 so9Var4 = this.o;
                    so9Var4.b.addAll(so9Var4.a.subList(0, 5));
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

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            no9 no9Var = new no9();
            ArrayList arrayList = new ArrayList();
            ko9 m = m(R.drawable.obfuscated_res_0x7f080a31, R.string.member_center, 12);
            m.c = true;
            m.g = this.b;
            arrayList.add(m);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a2a, R.string.dressup_center_title, 62));
            arrayList.add(m(R.drawable.obfuscated_res_0x7f08099e, R.string.certification_center, 53));
            ko9 m2 = m(R.drawable.obfuscated_res_0x7f080a29, R.string.create_ba, 56);
            m2.f = TbConfig.CREATE_BA;
            arrayList.add(m2);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a36, R.string.game_hall, 58));
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a27, R.string.book_desk, 59));
            if (TbSingleton.getInstance().isBusinessAccount()) {
                ko9 m3 = m(R.drawable.obfuscated_res_0x7f080a28, R.string.official_account, 15);
                m3.c = true;
                arrayList.add(m3);
            }
            ko9 m4 = m(R.drawable.obfuscated_res_0x7f080a2f, R.string.account_check, 50);
            m4.f = "https://wappass.baidu.com/v6/safetyInspection?adapter=3";
            arrayList.add(m4);
            ko9 m5 = m(R.drawable.obfuscated_res_0x7f080a2c, R.string.obfuscated_res_0x7f0f0d10, 10);
            this.i = m5;
            m5.h = new mo9();
            this.i.c = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.b.getTDouNum());
            }
            mo9 mo9Var = this.i.h;
            mo9Var.c = formatNumForTdouDisPlay;
            mo9Var.e = CurrencySwitchUtil.getMoneyIcon();
            arrayList.add(this.i);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f0809c0, R.string.welfare_entrance, 63));
            ko9 m6 = m(R.drawable.obfuscated_res_0x7f080a35, R.string.mark_center, 51);
            m6.f = TbConfig.TIEBA_ADDRESS + "mo/q/icon/panelIcon?opacity=0&opacitybtnhex=ffffff&user_id=" + this.b.getUserId();
            arrayList.add(m6);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a34, R.string.subscribe_manager, 52));
            ko9 m7 = m(R.drawable.obfuscated_res_0x7f080a2d, R.string.obfuscated_res_0x7f0f0eb3, 54);
            m7.f = w;
            arrayList.add(m7);
            ko9 m8 = m(R.drawable.obfuscated_res_0x7f080a3f, R.string.community_convention, 55);
            m8.f = TbConfig.COMMUNITY_CONVENTION;
            arrayList.add(m8);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a2e, R.string.earn_money, 57));
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080c46, R.string.exchange_mall, 60));
            no9Var.d(arrayList);
            this.a.add(no9Var);
            this.u = no9Var;
        }
    }

    public final void k(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, user) == null) {
            jo9 jo9Var = this.q;
            if (jo9Var != null) {
                this.a.add(jo9Var);
                return;
            }
            CreationData creationData = user.creation_data;
            CreationData creationData2 = user.workcreation_data;
            jo9 jo9Var2 = new jo9();
            this.q = jo9Var2;
            jo9Var2.e(creationData);
            this.q.f(creationData2);
            this.a.add(this.q);
        }
    }

    public final void s(UserGrowth userGrowth) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, userGrowth) == null) {
            io9 io9Var = this.g;
            if (io9Var != null) {
                this.a.add(io9Var);
                return;
            }
            this.g = new io9();
            xg5 xg5Var = new xg5();
            xg5Var.g(userGrowth);
            this.g.d(xg5Var);
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

    public final ko9 m(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048595, this, i, i2, i3)) == null) {
            ko9 ko9Var = new ko9();
            ko9Var.b = i;
            ko9Var.e = TbadkCoreApplication.getInst().getString(i2);
            ko9Var.a = i3;
            UserData userData = this.b;
            if (userData != null) {
                ko9Var.g = userData;
            }
            return ko9Var;
        }
        return (ko9) invokeIII.objValue;
    }

    public final ko9 n(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            ko9 ko9Var = new ko9();
            ko9Var.b = i;
            ko9Var.e = str;
            ko9Var.a = i2;
            UserData userData = this.b;
            if (userData != null) {
                ko9Var.g = userData;
            }
            return ko9Var;
        }
        return (ko9) invokeCommon.objValue;
    }

    public final void o() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ko9 m = m(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
            this.k = m;
            m.c = true;
            m.n = true;
            this.a.add(m);
            ko9 m2 = m(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.obfuscated_res_0x7f0f0314, 39);
            m2.c = true;
            this.a.add(m2);
            ko9 n = n(R.drawable.obfuscated_res_0x7f080a45, "订单中心", 47);
            n.f = "tiebaclient://swan/GidbxGjMhcXQsHbhL7KHyLm2qWim65ct/pages/home/index/?_baiduboxapp=%7B%22ext%22%3A%7B%7D%7D&callback=_bdbox_js_275&upgrade=0";
            this.a.add(n);
            ko9 n2 = n(R.drawable.obfuscated_res_0x7f080a33, "开店", 48);
            mo9 mo9Var = new mo9();
            n2.h = mo9Var;
            mo9Var.i = "免佣金";
            n2.f = "https://activity.baidu.com/mbox/4a81af9f62/home";
            this.a.add(n2);
            ko9 n3 = n(R.drawable.obfuscated_res_0x7f080b51, "隐私设置", 61);
            mo9 mo9Var2 = new mo9();
            n3.h = mo9Var2;
            if (SharedPrefHelper.getInstance().getInt("setting_private_red_dot", 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            mo9Var2.a = z;
            this.a.add(n3);
            ko9 n4 = n(R.drawable.obfuscated_res_0x7f080a26, "广告推广", 49);
            n4.f = "https://yingxiao.baidu.com/new/home/topic/detail?name=index&no=644";
            this.a.add(n4);
            if (this.m == null) {
                this.m = new PersonMoreData();
            }
            ko9 m3 = m(R.drawable.obfuscated_res_0x7f080a44, R.string.obfuscated_res_0x7f0f1050, 33);
            m3.i = OrmObject.bundleWithObject(this.m);
            m3.h = new mo9();
            m3.o = true;
            this.a.add(m3);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            ro9 ro9Var = this.n;
            if (ro9Var != null && ro9Var.a.size() > 0) {
                this.a.add(this.n);
                return;
            }
            this.n = new ro9();
            if (ListUtils.isEmpty(this.c)) {
                return;
            }
            for (int i = 0; i < this.c.size(); i++) {
                ao9 ao9Var = new ao9();
                ao9Var.b(this.c.get(i));
                if (!bi.isEmpty(ao9Var.a())) {
                    this.n.a.add(ao9Var);
                }
            }
            if (this.n.a.size() > 0) {
                this.a.add(this.n);
            }
        }
    }
}
