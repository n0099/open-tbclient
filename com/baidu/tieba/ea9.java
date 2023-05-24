package com.baidu.tieba;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import tbclient.DynamicInfo;
import tbclient.ForumDynamic;
import tbclient.HotUserRankEntry;
import tbclient.PostInfoList;
import tbclient.PrivSets;
import tbclient.Profile.NicknameInfo;
import tbclient.Profile.UserGodInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.UserDynamic;
/* loaded from: classes5.dex */
public abstract class ea9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NicknameInfo A;
    public User B;
    public MetaData C;
    public List<ThreadData> D;
    public HotUserRankEntry E;
    public boolean a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public int f;
    public UserData g;
    public AntiData h;
    public ArrayList<rn> i;
    public ga9 j;
    public d69 k;
    public ro7 l;
    public List<AlaLiveInfoCoreData> m;
    public ka9 n;
    public ma9 o;
    public List<rn> p;
    public ArrayList<rn> q;
    public ArrayList<ra9> r;
    public ArrayList<rn> s;
    public h69 t;
    public ra9 u;
    public ra9 v;
    public ra9 w;
    public ra9 x;
    public ra9 y;
    public PersonUserGodInfo z;

    public abstract void b();

    public ea9(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = true;
        this.c = 1;
        this.d = 1;
        this.e = 1;
        this.f = -1;
        this.a = z;
        this.q = new ArrayList<>();
        this.r = new ArrayList<>();
        this.D = new ArrayList();
    }

    public final void p(List<ForumDynamic> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            ga9 ga9Var = new ga9();
            this.j = ga9Var;
            ga9Var.a = new ArrayList();
            for (ForumDynamic forumDynamic : list) {
                if (forumDynamic != null) {
                    ja9 ja9Var = new ja9();
                    ja9Var.a = forumDynamic.forum_id.longValue();
                    ja9Var.b = forumDynamic.forum_name;
                    ja9Var.c = forumDynamic.avatar;
                    ja9Var.e = this.c;
                    ja9Var.d = forumDynamic.user_thread_count.intValue();
                    this.j.a.add(ja9Var);
                }
            }
        }
    }

    public u59 a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            u59 u59Var = new u59();
            u59Var.a = i;
            u59Var.c = i2;
            return u59Var;
        }
        return (u59) invokeII.objValue;
    }

    public final ra9 c(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3)) == null) {
            ra9 ra9Var = new ra9();
            TbadkCoreApplication.getInst().getString(i2);
            u79 u79Var = new u79();
            ra9Var.a = u79Var;
            u79Var.a = i3;
            return ra9Var;
        }
        return (ra9) invokeIII.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.r.clear();
            ra9 c = c(R.drawable.icon_starer_caise_heibai, R.string.obfuscated_res_0x7f0f0bee, 20);
            this.v = c;
            c.b = new Bundle();
            this.v.b.putBoolean("person_center_item_red_tip", true);
            this.v.a.b = new Bundle();
            this.v.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(this.v);
            ra9 c2 = c(R.drawable.icon_lover_caise_heibai, R.string.obfuscated_res_0x7f0f04c2, 24);
            this.w = c2;
            c2.b = new Bundle();
            this.w.b.putBoolean("person_center_item_red_tip", true);
            this.w.a.b = new Bundle();
            this.w.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(this.w);
            ra9 c3 = c(R.drawable.icon_liwu_caise_heibai, R.string.obfuscated_res_0x7f0f0897, 32);
            this.u = c3;
            c3.b = new Bundle();
            this.u.b.putBoolean("person_center_item_red_tip", true);
            this.u.a.b = new Bundle();
            this.u.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(this.u);
            ra9 c4 = c(R.drawable.icon_lishi_caise_heibai, R.string.obfuscated_res_0x7f0f097b, 21);
            c4.a.b = new Bundle();
            c4.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(c4);
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
                ra9 c5 = c(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
                c5.b = new Bundle();
                c5.a.b = new Bundle();
                c5.a.b.putSerializable(UserData.TYPE_USER, this.g);
                this.r.add(c5);
            }
            ra9 c6 = c(R.drawable.icon_vip_heibai, R.string.obfuscated_res_0x7f0f0c11, 16);
            this.x = c6;
            c6.b = new Bundle();
            this.x.b.putBoolean("person_center_item_red_tip", true);
            this.x.a.b = new Bundle();
            this.x.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(this.x);
            ra9 c7 = c(R.drawable.icon_bookshoop_caise_heibai, R.string.obfuscated_res_0x7f0f0366, 31);
            c7.a.b = new Bundle();
            c7.a.b.putSerializable(UserData.TYPE_USER, this.g);
            h69 h69Var = this.t;
            if (h69Var != null) {
                c7.a.b.putString("book_jump_link", h69Var.a);
            }
            this.r.add(c7);
            ra9 c8 = c(R.drawable.icon_kabao_caise_heibai, R.string.obfuscated_res_0x7f0f03d5, 33);
            c8.a.b = new Bundle();
            c8.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(c8);
            ra9 c9 = c(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
            c9.a.b = new Bundle();
            c9.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(c9);
            ra9 c10 = c(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
            c10.a.b = new Bundle();
            c10.a.b.putString("key_service_centre", "");
            this.r.add(c10);
        }
    }

    public AntiData e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h;
        }
        return (AntiData) invokeV.objValue;
    }

    public ArrayList<rn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.q;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ro7 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.l;
        }
        return (ro7) invokeV.objValue;
    }

    public List<ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.D;
        }
        return (List) invokeV.objValue;
    }

    public User i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.B;
        }
        return (User) invokeV.objValue;
    }

    public UserData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.g;
        }
        return (UserData) invokeV.objValue;
    }

    public List<rn> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            d69 d69Var = this.k;
            if (d69Var == null) {
                return null;
            }
            return d69Var.a();
        }
        return (List) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.a) {
                return false;
            }
            int i = this.d;
            if (i == 3) {
                return true;
            }
            if (i != 2 || this.b) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.a) {
                return false;
            }
            int i = this.e;
            if (i == 3) {
                return true;
            }
            if (i != 2 || this.b) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void q(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048592, this, dynamicInfo, z) == null) {
            if ((n() && !this.a) || (forumDynamic = dynamicInfo.forum_dynamic) == null) {
                return;
            }
            if (this.p == null) {
                this.p = new ArrayList();
            }
            fa9 fa9Var = new fa9();
            fa9Var.a = this.a;
            fa9Var.b = this.c;
            fa9Var.c = z;
            fa9Var.d = StringHelper.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            fa9Var.e = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            fa9Var.f = forumDynamic.forum_id.longValue();
            fa9Var.g = forumDynamic.avatar;
            fa9Var.h = forumDynamic.forum_name;
            boolean z2 = true;
            if (forumDynamic.is_like.intValue() != 1) {
                z2 = false;
            }
            fa9Var.i = z2;
            fa9Var.j = forumDynamic.member_count.intValue();
            fa9Var.k = forumDynamic.thread_count.intValue();
            this.p.add(fa9Var);
            this.p.add(a(ri.g(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.obfuscated_res_0x7f070198), R.color.CAM_X0204));
        }
    }

    public final void r(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048593, this, dynamicInfo, z) != null) || (userDynamic = dynamicInfo.user_dynamic) == null) {
            return;
        }
        List<User> list = userDynamic.concerned_user_list;
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.p == null) {
            this.p = new ArrayList();
        }
        ha9 ha9Var = new ha9();
        ha9Var.a = this.a;
        ha9Var.b = z;
        ha9Var.e = this.c;
        ha9Var.c = StringHelper.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        ha9Var.d = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        ha9Var.d = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        ha9Var.f = new ArrayList();
        for (User user : list) {
            if (user != null) {
                UserData userData = new UserData();
                userData.parserProtobuf(user);
                ha9Var.f.add(userData);
            }
        }
        this.p.add(ha9Var);
    }

    public final void s(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{user, dynamicInfo, random, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if ((o() && !this.a) || (threadInfo = dynamicInfo.thread_dynamic) == null) {
                return;
            }
            if (this.p == null) {
                this.p = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.f);
            this.f = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.F = this.a;
            cardPersonDynamicThreadData.D = z;
            cardPersonDynamicThreadData.C = z2;
            cardPersonDynamicThreadData.E = z3;
            cardPersonDynamicThreadData.q = 3;
            cardPersonDynamicThreadData.f(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.p.add(cardPersonDynamicThreadData);
        }
    }

    public final void t(User user, PostInfoList postInfoList, Random random) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, user, postInfoList, random) == null) {
            if (o() && !this.a) {
                return;
            }
            if (this.s == null) {
                this.s = new ArrayList<>();
            }
            this.f = UtilHelper.getRandom(random, 3, this.f);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.F = this.a;
            cardPersonDynamicThreadData.D = false;
            cardPersonDynamicThreadData.C = false;
            cardPersonDynamicThreadData.e(user, null, postInfoList, this.f);
            this.s.add(cardPersonDynamicThreadData);
        }
    }

    public final void u(User user) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, user) == null) && user != null && !ListUtils.isEmpty(user.gift_list)) {
            ka9 ka9Var = new ka9();
            this.n = ka9Var;
            ka9Var.c(user);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.b = z;
        }
    }

    public void v(t59 t59Var) {
        String str;
        String str2;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, t59Var) != null) || t59Var == null) {
            return;
        }
        this.B = t59Var.GetUser();
        if (this.g == null) {
            this.g = new UserData();
        }
        this.g.parserProtobuf(this.B);
        if (this.C == null) {
            this.C = new MetaData();
        }
        this.C.parserProtobuf(this.B);
        if (this.z == null) {
            this.z = new PersonUserGodInfo();
        }
        UserGodInfo userGodInfo = t59Var.getUserGodInfo();
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.g.setIsBigV(true);
            this.z.parserProtobuf(t59Var.getUserGodInfo());
        }
        if (this.h == null) {
            this.h = new AntiData();
        }
        this.h.parserProtobuf(t59Var.GetAntiStat());
        User user = this.B;
        if (user != null) {
            PrivSets privSets = user.priv_sets;
            if (privSets != null) {
                this.d = privSets.like.intValue();
                this.e = this.B.priv_sets.post.intValue();
            }
            this.c = this.B.sex.intValue();
        }
        if (t59Var.getTaInfo() != null) {
            if (t59Var.getTaInfo().is_friend.intValue() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.b = z2;
        }
        this.g.setIsFriend(t59Var.getTaInfo().is_friend.intValue());
        if (t59Var.getBookrackData() != null) {
            e69 e69Var = new e69();
            e69Var.a(t59Var.getBookrackData());
            this.t = new h69(true, e69Var);
        }
        if (!ListUtils.isEmpty(t59Var.getConcernedForumList()) && !this.a && !n()) {
            p(t59Var.getConcernedForumList());
        }
        if (this.n == null) {
            u(this.B);
        }
        Random random = new Random();
        if (this.a && !ListUtils.isEmpty(t59Var.GetPostList())) {
            for (PostInfoList postInfoList : t59Var.GetPostList()) {
                if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                    t(this.B, postInfoList, random);
                }
            }
        }
        String yearBytime = StringHelper.getYearBytime(System.currentTimeMillis());
        if (!ListUtils.isEmpty(t59Var.getDynamicInfoList())) {
            Date date = new Date();
            String str3 = "";
            String str4 = "";
            boolean z3 = true;
            for (DynamicInfo dynamicInfo : t59Var.getDynamicInfoList()) {
                if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                    long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                    date.setTime(longValue);
                    String yearBytime2 = StringHelper.getYearBytime(longValue);
                    String chineseMonthBytime = StringHelper.getChineseMonthBytime(longValue);
                    String dateBytime = StringHelper.getDateBytime(longValue);
                    boolean z4 = !StringHelper.equals(yearBytime2, yearBytime);
                    if (StringHelper.equals(dateBytime, str3) && StringHelper.equals(chineseMonthBytime, str4) && StringHelper.equals(yearBytime2, yearBytime)) {
                        yearBytime2 = yearBytime;
                        str2 = str3;
                        str = str4;
                        z = false;
                    } else {
                        str = chineseMonthBytime;
                        str2 = dateBytime;
                        z = true;
                    }
                    int intValue = dynamicInfo.type.intValue();
                    if (intValue != 1) {
                        if (intValue != 2) {
                            if (intValue == 3) {
                                q(dynamicInfo, z);
                            }
                        } else {
                            r(dynamicInfo, z);
                        }
                    } else {
                        s(this.B, dynamicInfo, random, z4, z, z3);
                    }
                    yearBytime = yearBytime2;
                    str3 = str2;
                    str4 = str;
                    z3 = false;
                }
            }
        }
        if (this.o == null && ListUtils.isEmpty(this.p) && ListUtils.isEmpty(this.s)) {
            ma9 ma9Var = new ma9();
            this.o = ma9Var;
            ma9Var.b = this.c;
            ma9Var.a = this.a;
        }
        if (this.a) {
            d();
            t59Var.getMaskType();
        }
        t59Var.getUserAgreeInfo();
        t59Var.getLiveInfo();
        this.l = t59Var.getGoodsWindowInfo();
        this.m = t59Var.getLiveReplayInfo();
        this.A = t59Var.getNicknameInfo();
        this.E = t59Var.getHotRankEntry();
        List<ThreadInfo> newestThreadList = t59Var.getNewestThreadList();
        if (!ListUtils.isEmpty(newestThreadList)) {
            for (int i = 0; i < newestThreadList.size(); i++) {
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(newestThreadList.get(i));
                threadData.setAuthor(this.C);
                threadData.praserTimeConsumingInfo();
                this.D.add(threadData);
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.b = true;
            this.c = 1;
            this.d = 1;
            this.e = 1;
            this.f = -1;
            this.g = null;
            ArrayList<rn> arrayList = this.i;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.i = null;
            this.j = null;
            this.k = null;
            this.n = null;
            this.o = null;
            List<rn> list = this.p;
            if (list != null) {
                list.clear();
            }
            ArrayList<rn> arrayList2 = this.s;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            this.p = null;
            this.s = null;
            this.q.clear();
            this.A = null;
            this.l = null;
            List<AlaLiveInfoCoreData> list2 = this.m;
            if (list2 != null) {
                list2.clear();
            }
            List<ThreadData> list3 = this.D;
            if (list3 != null) {
                list3.clear();
            }
        }
    }
}
