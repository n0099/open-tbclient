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
public class gj9 implements rh9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<xn> a;
    public UserData b;
    public List<BannerImage> c;
    public PersonUserGodInfo d;
    public fj9 e;
    public hj9 f;
    public ij9 g;
    public kj9 h;
    public kj9 i;
    public kj9 j;
    public kj9 k;
    public lj9 l;
    public PersonMoreData m;
    public rj9 n;
    public sj9 o;
    public oj9 p;
    public jj9 q;
    public cj9 r;
    public PersonVipCardData s;
    public HashMap<String, PersonRedTipData> t;
    public nj9 u;
    public kx5 v;

    public gj9() {
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
            fj9 fj9Var = this.e;
            if (fj9Var != null) {
                this.a.add(fj9Var);
            } else if (this.b == null) {
            } else {
                this.e = new fj9();
                this.b.getFansNum();
                this.e.a = this.b.getConcern_num();
                this.e.b = this.b.getLike_bars();
                this.e.c = this.b.getThreadNum();
                fj9 fj9Var2 = this.e;
                fj9Var2.e = this.b;
                this.a.add(fj9Var2);
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

    public lj9 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.l;
        }
        return (lj9) invokeV.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            fj9 fj9Var = this.e;
            if (fj9Var != null && this.a.contains(fj9Var)) {
                return this.a.indexOf(this.e);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public cj9 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.r;
        }
        return (cj9) invokeV.objValue;
    }

    public ArrayList<xn> x() {
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
            nj9 nj9Var = this.u;
            if (nj9Var != null && this.a.contains(nj9Var)) {
                return this.a.indexOf(this.u);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void C(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbBookrack) == null) && tbBookrack != null) {
            di9 di9Var = new di9();
            di9Var.a(tbBookrack);
            new gi9(true, di9Var);
        }
    }

    public final void D(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ucCard) == null) {
            new wh9().a(ucCard);
        }
    }

    public void G(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, userPendantData) == null) {
            this.b.setPendantData(userPendantData);
        }
    }

    public void d(boolean z) {
        kj9 kj9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (kj9Var = this.j) != null) {
            if (kj9Var.h == null) {
                kj9Var.h = new mj9();
            }
            this.j.h.b(z);
        }
    }

    public void e(boolean z) {
        fj9 fj9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (fj9Var = this.e) != null) {
            fj9Var.d = z;
        }
    }

    public void f(boolean z) {
        kj9 kj9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (kj9Var = this.k) != null) {
            if (kj9Var.h == null) {
                kj9Var.h = new mj9();
            }
            this.k.h.b(z);
        }
    }

    public void g(boolean z) {
        kj9 kj9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (kj9Var = this.h) != null) {
            if (kj9Var.h == null) {
                kj9Var.h = new mj9();
            }
            this.h.h.b(z);
        }
    }

    public final void l(NamoaixudEntry namoaixudEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, namoaixudEntry) == null) {
            hj9 hj9Var = this.f;
            if (hj9Var != null) {
                this.a.add(hj9Var);
                return;
            }
            hj9 hj9Var2 = new hj9();
            this.f = hj9Var2;
            hj9Var2.d(namoaixudEntry);
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

    public List<kj9> q(List<CustomGrid> list) {
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
                    bj9 bj9Var = new bj9();
                    bj9Var.a(customGrid);
                    kj9 b = bj9Var.b();
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
                        b.h = new mj9();
                    }
                    b.h.b(i(bj9Var));
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

    @Override // com.baidu.tieba.rh9
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, personalResIdl) == null) && personalResIdl != null && personalResIdl.data != null) {
            if (this.b == null) {
                this.b = new UserData();
            }
            this.b.parserProtobuf(personalResIdl.data.user);
            lj9 lj9Var = new lj9();
            this.l = lj9Var;
            lj9Var.a = this.b;
            this.a.add(lj9Var);
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
            oj9 oj9Var = new oj9();
            this.p = oj9Var;
            this.a.add(oj9Var);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new qj9(smartApp));
                }
            }
        }
        this.p.d(arrayList);
    }

    @Override // com.baidu.tieba.rh9
    public void b(ProfileResIdl profileResIdl) {
        UserGrowth userGrowth;
        NamoaixudEntry namoaixudEntry;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, profileResIdl) == null) && profileResIdl != null && profileResIdl.data != null) {
            this.l = new lj9();
            DataRes dataRes = profileResIdl.data;
            this.c = dataRes.banner;
            Namoaixud namoaixud = dataRes.namoaixud;
            F(dataRes.user, dataRes.user_god_info);
            C(profileResIdl.data.tbbookrack);
            D(profileResIdl.data.uc_card);
            E(profileResIdl.data.url_map);
            if (profileResIdl.data.bubble_info != null) {
                cj9 cj9Var = new cj9();
                this.r = cj9Var;
                cj9Var.d(profileResIdl.data.bubble_info);
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
                List<kj9> q = q(profileResIdl.data.custom_grid);
                if (!ListUtils.isEmpty(q)) {
                    nj9 nj9Var = new nj9();
                    nj9Var.d(q);
                    this.a.add(nj9Var);
                    this.u = nj9Var;
                } else {
                    p();
                }
            } else {
                p();
            }
            j();
            r(profileResIdl.data.recom_naws_list);
            if (!ListUtils.isEmpty(profileResIdl.data.more_grid)) {
                List<kj9> q2 = q(profileResIdl.data.more_grid);
                if (!ListUtils.isEmpty(q2)) {
                    for (kj9 kj9Var : q2) {
                        if (kj9Var != null) {
                            this.a.add(kj9Var);
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
                        e.put(list.get(i).getApkPackageName(), kx5.k);
                    } else if (list.get(i).getStatus().status == kx5.g) {
                        e.put(list.get(i).getApkPackageName(), kx5.j);
                        if (this.v.d()) {
                            e.put(kx5.i, kx5.k);
                        } else {
                            e.put(kx5.i, kx5.j);
                        }
                    } else if (list.get(i).getStatus().status == kx5.h) {
                        e.put(list.get(i).getApkPackageName(), kx5.k);
                    } else {
                        e.put(list.get(i).getApkPackageName(), kx5.k);
                    }
                }
            }
            this.v.m(e);
        }
    }

    public final boolean i(bj9 bj9Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bj9Var)) == null) {
            if (bj9Var == null) {
                return false;
            }
            PersonRedTipData personRedTipData = new PersonRedTipData();
            if (bj9Var.f != 0) {
                z = true;
            } else {
                z = false;
            }
            personRedTipData.setShow(z);
            personRedTipData.setRedPointVersion(bj9Var.f);
            if (this.t == null) {
                this.t = new HashMap<>();
            }
            String w = r95.p().w(r95.t("key_my_tab_item_red_tip_data"), "");
            if (!StringUtils.isNull(w)) {
                new HashMap();
                for (Map.Entry<String, Object> entry : DataExt.toMap(w).entrySet()) {
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
                if (this.t.get(String.valueOf(bj9Var.e)) == null) {
                    this.t.put(String.valueOf(bj9Var.e), personRedTipData);
                    r95.p().J(r95.t("key_my_tab_item_red_tip_data"), DataExt.toJson(this.t));
                    if (bj9Var.f == 0) {
                        return false;
                    }
                    return true;
                }
                if (this.t.get(String.valueOf(bj9Var.e)) != null) {
                    if (bj9Var.f > ((PersonRedTipData) Objects.requireNonNull(this.t.get(String.valueOf(bj9Var.e)))).getRedPointVersion()) {
                        this.t.put(String.valueOf(bj9Var.e), personRedTipData);
                        r95.p().J(r95.t("key_my_tab_item_red_tip_data"), DataExt.toJson(this.t));
                        return true;
                    } else if (bj9Var.f == ((PersonRedTipData) Objects.requireNonNull(this.t.get(String.valueOf(bj9Var.e)))).getRedPointVersion()) {
                        return ((PersonRedTipData) Objects.requireNonNull(this.t.get(String.valueOf(bj9Var.e)))).isShow();
                    }
                }
                return false;
            }
            this.t.put(String.valueOf(bj9Var.e), personRedTipData);
            r95.p().J(r95.t("key_my_tab_item_red_tip_data"), DataExt.toJson(this.t));
            if (bj9Var.f == 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void j() {
        List<ApkDownloadInfoData> list;
        dm0 value;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || !UbsABTestHelper.isShowMyPageDownloadCard()) {
            return;
        }
        sj9 sj9Var = this.o;
        if (sj9Var != null) {
            this.a.add(sj9Var);
            return;
        }
        sj9 sj9Var2 = new sj9();
        this.o = sj9Var2;
        if (sj9Var2 != null && (list = sj9Var2.a) != null && sj9Var2.b != null) {
            list.clear();
            this.o.b.clear();
            this.v = kx5.c();
            HashMap<String, dm0> a = ul0.b().a();
            if (a != null) {
                for (Map.Entry<String, dm0> entry : a.entrySet()) {
                    if (entry != null && (value = entry.getValue()) != null && value.c.status == kx5.g) {
                        if (this.v.i(value.h.getAbsolutePath()) && !this.v.j(value.d)) {
                            hm0 hm0Var = value.p;
                            ApkDownloadInfoData apkDownloadInfoData = new ApkDownloadInfoData(hm0Var.g, value.h, hm0Var.h, value.c, value.d, value.m, value);
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
                    sj9 sj9Var3 = this.o;
                    sj9Var3.b.addAll(sj9Var3.a);
                } else {
                    sj9 sj9Var4 = this.o;
                    sj9Var4.b.addAll(sj9Var4.a.subList(0, 5));
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
            nj9 nj9Var = new nj9();
            ArrayList arrayList = new ArrayList();
            kj9 m = m(R.drawable.obfuscated_res_0x7f080a2c, R.string.member_center, 12);
            m.c = true;
            arrayList.add(m);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a25, R.string.dressup_center_title, 62));
            arrayList.add(m(R.drawable.obfuscated_res_0x7f08099b, R.string.certification_center, 53));
            kj9 m2 = m(R.drawable.obfuscated_res_0x7f080a24, R.string.create_ba, 56);
            m2.f = TbConfig.CREATE_BA;
            arrayList.add(m2);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a31, R.string.game_hall, 58));
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a22, R.string.book_desk, 59));
            if (TbSingleton.getInstance().isBusinessAccount()) {
                kj9 m3 = m(R.drawable.obfuscated_res_0x7f080a23, R.string.official_account, 15);
                m3.c = true;
                arrayList.add(m3);
            }
            kj9 m4 = m(R.drawable.obfuscated_res_0x7f080a2a, R.string.account_check, 50);
            m4.f = "https://wappass.baidu.com/v6/safetyInspection?adapter=3";
            arrayList.add(m4);
            kj9 m5 = m(R.drawable.obfuscated_res_0x7f080a27, R.string.obfuscated_res_0x7f0f0d03, 10);
            this.i = m5;
            m5.h = new mj9();
            this.i.c = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.b.getTDouNum());
            }
            mj9 mj9Var = this.i.h;
            mj9Var.c = formatNumForTdouDisPlay;
            mj9Var.e = CurrencySwitchUtil.getMoneyIcon();
            arrayList.add(this.i);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f0809bb, R.string.welfare_entrance, 63));
            kj9 m6 = m(R.drawable.obfuscated_res_0x7f080a30, R.string.mark_center, 51);
            m6.f = TbConfig.TIEBA_ADDRESS + "mo/q/icon/panelIcon?opacity=0&opacitybtnhex=ffffff&user_id=" + this.b.getUserId();
            arrayList.add(m6);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a2f, R.string.subscribe_manager, 52));
            kj9 m7 = m(R.drawable.obfuscated_res_0x7f080a28, R.string.novel_member_monthly, 54);
            m7.f = sr5.g("https://boxnovel.baidu.com/boxnovel/tbvipright?data={\"fromaction\": \"tieba\"}");
            arrayList.add(m7);
            kj9 m8 = m(R.drawable.obfuscated_res_0x7f080a3a, R.string.community_convention, 55);
            m8.f = TbConfig.COMMUNITY_CONVENTION;
            arrayList.add(m8);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a29, R.string.earn_money, 57));
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080c37, R.string.exchange_mall, 60));
            nj9Var.d(arrayList);
            this.a.add(nj9Var);
            this.u = nj9Var;
        }
    }

    public final void k(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, user) == null) {
            jj9 jj9Var = this.q;
            if (jj9Var != null) {
                this.a.add(jj9Var);
                return;
            }
            CreationData creationData = user.creation_data;
            CreationData creationData2 = user.workcreation_data;
            jj9 jj9Var2 = new jj9();
            this.q = jj9Var2;
            jj9Var2.e(creationData);
            this.q.f(creationData2);
            this.a.add(this.q);
        }
    }

    public final void s(UserGrowth userGrowth) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, userGrowth) == null) {
            ij9 ij9Var = this.g;
            if (ij9Var != null) {
                this.a.add(ij9Var);
                return;
            }
            this.g = new ij9();
            oh5 oh5Var = new oh5();
            oh5Var.g(userGrowth);
            this.g.d(oh5Var);
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

    public final kj9 m(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048595, this, i, i2, i3)) == null) {
            kj9 kj9Var = new kj9();
            kj9Var.b = i;
            kj9Var.e = TbadkCoreApplication.getInst().getString(i2);
            kj9Var.a = i3;
            UserData userData = this.b;
            if (userData != null) {
                kj9Var.g = userData;
            }
            return kj9Var;
        }
        return (kj9) invokeIII.objValue;
    }

    public final kj9 n(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            kj9 kj9Var = new kj9();
            kj9Var.b = i;
            kj9Var.e = str;
            kj9Var.a = i2;
            UserData userData = this.b;
            if (userData != null) {
                kj9Var.g = userData;
            }
            return kj9Var;
        }
        return (kj9) invokeCommon.objValue;
    }

    public final void o() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            kj9 m = m(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
            this.k = m;
            m.c = true;
            m.n = true;
            this.a.add(m);
            kj9 m2 = m(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.obfuscated_res_0x7f0f0314, 39);
            m2.c = true;
            this.a.add(m2);
            kj9 n = n(R.drawable.obfuscated_res_0x7f080a40, "订单中心", 47);
            n.f = "tiebaclient://swan/GidbxGjMhcXQsHbhL7KHyLm2qWim65ct/pages/home/index/?_baiduboxapp=%7B%22ext%22%3A%7B%7D%7D&callback=_bdbox_js_275&upgrade=0";
            this.a.add(n);
            kj9 n2 = n(R.drawable.obfuscated_res_0x7f080a2e, "开店", 48);
            mj9 mj9Var = new mj9();
            n2.h = mj9Var;
            mj9Var.i = "免佣金";
            n2.f = "https://activity.baidu.com/mbox/4a81af9f62/home";
            this.a.add(n2);
            kj9 n3 = n(R.drawable.obfuscated_res_0x7f080b43, "隐私设置", 61);
            mj9 mj9Var2 = new mj9();
            n3.h = mj9Var2;
            if (r95.p().q("setting_private_red_dot", 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            mj9Var2.a = z;
            this.a.add(n3);
            kj9 n4 = n(R.drawable.obfuscated_res_0x7f080a21, "广告推广", 49);
            n4.f = "https://yingxiao.baidu.com/new/home/topic/detail?name=index&no=644";
            this.a.add(n4);
            if (this.m == null) {
                this.m = new PersonMoreData();
            }
            kj9 m3 = m(R.drawable.obfuscated_res_0x7f080a3f, R.string.obfuscated_res_0x7f0f103b, 33);
            m3.i = OrmObject.bundleWithObject(this.m);
            m3.h = new mj9();
            m3.o = true;
            this.a.add(m3);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            rj9 rj9Var = this.n;
            if (rj9Var != null && rj9Var.a.size() > 0) {
                this.a.add(this.n);
                return;
            }
            this.n = new rj9();
            if (ListUtils.isEmpty(this.c)) {
                return;
            }
            for (int i = 0; i < this.c.size(); i++) {
                aj9 aj9Var = new aj9();
                aj9Var.b(this.c.get(i));
                if (!wi.isEmpty(aj9Var.a())) {
                    this.n.a.add(aj9Var);
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
            jj9 jj9Var = this.q;
            if (jj9Var != null && this.a.contains(jj9Var)) {
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
