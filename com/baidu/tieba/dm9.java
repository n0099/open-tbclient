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
public abstract class dm9 {
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
    public ArrayList<xn> i;
    public fm9 j;
    public ci9 k;
    public su7 l;
    public List<AlaLiveInfoCoreData> m;
    public jm9 n;
    public lm9 o;
    public List<xn> p;
    public ArrayList<xn> q;
    public ArrayList<qm9> r;
    public ArrayList<xn> s;
    public gi9 t;
    public qm9 u;
    public qm9 v;
    public qm9 w;
    public qm9 x;
    public qm9 y;
    public PersonUserGodInfo z;

    public abstract void b();

    public dm9(boolean z) {
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
            fm9 fm9Var = new fm9();
            this.j = fm9Var;
            fm9Var.a = new ArrayList();
            for (ForumDynamic forumDynamic : list) {
                if (forumDynamic != null) {
                    im9 im9Var = new im9();
                    im9Var.a = forumDynamic.forum_id.longValue();
                    im9Var.b = forumDynamic.forum_name;
                    im9Var.c = forumDynamic.avatar;
                    im9Var.e = this.c;
                    im9Var.d = forumDynamic.user_thread_count.intValue();
                    this.j.a.add(im9Var);
                }
            }
        }
    }

    public th9 a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            th9 th9Var = new th9();
            th9Var.a = i;
            th9Var.c = i2;
            return th9Var;
        }
        return (th9) invokeII.objValue;
    }

    public final qm9 c(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3)) == null) {
            qm9 qm9Var = new qm9();
            TbadkCoreApplication.getInst().getString(i2);
            tj9 tj9Var = new tj9();
            qm9Var.a = tj9Var;
            tj9Var.a = i3;
            return qm9Var;
        }
        return (qm9) invokeIII.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.r.clear();
            qm9 c = c(R.drawable.icon_starer_caise_heibai, R.string.obfuscated_res_0x7f0f0c30, 20);
            this.v = c;
            c.b = new Bundle();
            this.v.b.putBoolean("person_center_item_red_tip", true);
            this.v.a.b = new Bundle();
            this.v.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(this.v);
            qm9 c2 = c(R.drawable.icon_lover_caise_heibai, R.string.obfuscated_res_0x7f0f04cf, 24);
            this.w = c2;
            c2.b = new Bundle();
            this.w.b.putBoolean("person_center_item_red_tip", true);
            this.w.a.b = new Bundle();
            this.w.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(this.w);
            qm9 c3 = c(R.drawable.icon_liwu_caise_heibai, R.string.obfuscated_res_0x7f0f08d4, 32);
            this.u = c3;
            c3.b = new Bundle();
            this.u.b.putBoolean("person_center_item_red_tip", true);
            this.u.a.b = new Bundle();
            this.u.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(this.u);
            qm9 c4 = c(R.drawable.icon_lishi_caise_heibai, R.string.obfuscated_res_0x7f0f09b8, 21);
            c4.a.b = new Bundle();
            c4.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(c4);
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
                qm9 c5 = c(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
                c5.b = new Bundle();
                c5.a.b = new Bundle();
                c5.a.b.putSerializable(UserData.TYPE_USER, this.g);
                this.r.add(c5);
            }
            qm9 c6 = c(R.drawable.icon_vip_heibai, R.string.obfuscated_res_0x7f0f0c53, 16);
            this.x = c6;
            c6.b = new Bundle();
            this.x.b.putBoolean("person_center_item_red_tip", true);
            this.x.a.b = new Bundle();
            this.x.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(this.x);
            qm9 c7 = c(R.drawable.icon_bookshoop_caise_heibai, R.string.obfuscated_res_0x7f0f036f, 31);
            c7.a.b = new Bundle();
            c7.a.b.putSerializable(UserData.TYPE_USER, this.g);
            gi9 gi9Var = this.t;
            if (gi9Var != null) {
                c7.a.b.putString("book_jump_link", gi9Var.a);
            }
            this.r.add(c7);
            qm9 c8 = c(R.drawable.icon_kabao_caise_heibai, R.string.obfuscated_res_0x7f0f03de, 33);
            c8.a.b = new Bundle();
            c8.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(c8);
            qm9 c9 = c(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
            c9.a.b = new Bundle();
            c9.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(c9);
            qm9 c10 = c(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
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

    public ArrayList<xn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.q;
        }
        return (ArrayList) invokeV.objValue;
    }

    public su7 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.l;
        }
        return (su7) invokeV.objValue;
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

    public List<xn> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ci9 ci9Var = this.k;
            if (ci9Var == null) {
                return null;
            }
            return ci9Var.a();
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
            em9 em9Var = new em9();
            em9Var.a = this.a;
            em9Var.b = this.c;
            em9Var.c = z;
            em9Var.d = StringHelper.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            em9Var.e = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            em9Var.f = forumDynamic.forum_id.longValue();
            em9Var.g = forumDynamic.avatar;
            em9Var.h = forumDynamic.forum_name;
            boolean z2 = true;
            if (forumDynamic.is_like.intValue() != 1) {
                z2 = false;
            }
            em9Var.i = z2;
            em9Var.j = forumDynamic.member_count.intValue();
            em9Var.k = forumDynamic.thread_count.intValue();
            this.p.add(em9Var);
            this.p.add(a(xi.g(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.obfuscated_res_0x7f070198), R.color.CAM_X0204));
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
        gm9 gm9Var = new gm9();
        gm9Var.a = this.a;
        gm9Var.b = z;
        gm9Var.e = this.c;
        gm9Var.c = StringHelper.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        gm9Var.d = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        gm9Var.d = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        gm9Var.f = new ArrayList();
        for (User user : list) {
            if (user != null) {
                UserData userData = new UserData();
                userData.parserProtobuf(user);
                gm9Var.f.add(userData);
            }
        }
        this.p.add(gm9Var);
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
            jm9 jm9Var = new jm9();
            this.n = jm9Var;
            jm9Var.c(user);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.b = z;
        }
    }

    public void v(sh9 sh9Var) {
        String str;
        String str2;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, sh9Var) != null) || sh9Var == null) {
            return;
        }
        this.B = sh9Var.GetUser();
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
        UserGodInfo userGodInfo = sh9Var.getUserGodInfo();
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.g.setIsBigV(true);
            this.z.parserProtobuf(sh9Var.getUserGodInfo());
        }
        if (this.h == null) {
            this.h = new AntiData();
        }
        this.h.parserProtobuf(sh9Var.GetAntiStat());
        User user = this.B;
        if (user != null) {
            PrivSets privSets = user.priv_sets;
            if (privSets != null) {
                this.d = privSets.like.intValue();
                this.e = this.B.priv_sets.post.intValue();
            }
            this.c = this.B.sex.intValue();
        }
        if (sh9Var.getTaInfo() != null) {
            if (sh9Var.getTaInfo().is_friend.intValue() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.b = z2;
        }
        this.g.setIsFriend(sh9Var.getTaInfo().is_friend.intValue());
        if (sh9Var.getBookrackData() != null) {
            di9 di9Var = new di9();
            di9Var.a(sh9Var.getBookrackData());
            this.t = new gi9(true, di9Var);
        }
        if (!ListUtils.isEmpty(sh9Var.getConcernedForumList()) && !this.a && !n()) {
            p(sh9Var.getConcernedForumList());
        }
        if (this.n == null) {
            u(this.B);
        }
        Random random = new Random();
        if (this.a && !ListUtils.isEmpty(sh9Var.GetPostList())) {
            for (PostInfoList postInfoList : sh9Var.GetPostList()) {
                if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                    t(this.B, postInfoList, random);
                }
            }
        }
        String yearBytime = StringHelper.getYearBytime(System.currentTimeMillis());
        if (!ListUtils.isEmpty(sh9Var.getDynamicInfoList())) {
            Date date = new Date();
            String str3 = "";
            String str4 = "";
            boolean z3 = true;
            for (DynamicInfo dynamicInfo : sh9Var.getDynamicInfoList()) {
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
            lm9 lm9Var = new lm9();
            this.o = lm9Var;
            lm9Var.b = this.c;
            lm9Var.a = this.a;
        }
        if (this.a) {
            d();
            sh9Var.getMaskType();
        }
        sh9Var.getUserAgreeInfo();
        sh9Var.getLiveInfo();
        this.l = sh9Var.getGoodsWindowInfo();
        this.m = sh9Var.getLiveReplayInfo();
        this.A = sh9Var.getNicknameInfo();
        this.E = sh9Var.getHotRankEntry();
        List<ThreadInfo> newestThreadList = sh9Var.getNewestThreadList();
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
            ArrayList<xn> arrayList = this.i;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.i = null;
            this.j = null;
            this.k = null;
            this.n = null;
            this.o = null;
            List<xn> list = this.p;
            if (list != null) {
                list.clear();
            }
            ArrayList<xn> arrayList2 = this.s;
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
