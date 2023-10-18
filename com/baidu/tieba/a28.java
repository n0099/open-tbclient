package com.baidu.tieba;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.homepage.concern.data.RecommendBarCardModel;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.HeaderCard;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.Personalized.UserFollowLive;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class a28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c28 a;
    public final int b;
    public int c;
    public j28 d;
    public int e;
    public int f;
    public int g;
    public ArrayList<ThreadInfo> h;
    public ArrayList<App> i;
    public Long j;
    public List<yh> k;
    public a08 l;

    public final int h(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048592, this, i, i2)) == null) ? (i2 < 0 || i <= i2) ? i : i - 1 : invokeII.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Comparator<yk6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(a28 a28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(yk6 yk6Var, yk6 yk6Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, yk6Var, yk6Var2)) == null) {
                if (yk6Var != null && yk6Var2 != null) {
                    if (yk6Var.getPosition() > yk6Var2.getPosition()) {
                        return 1;
                    }
                    if (yk6Var.getPosition() < yk6Var2.getPosition()) {
                        return -1;
                    }
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends ow5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jk6 n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a28 a28Var, int i, String str, jk6 jk6Var) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a28Var, Integer.valueOf(i), str, jk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = jk6Var;
        }

        @Override // com.baidu.tieba.ow5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), g(), null)));
                jk6 jk6Var = this.n;
                if (jk6Var instanceof rk6) {
                    statisticItem = ((rk6) jk6Var).N();
                } else if (jk6Var instanceof sk6) {
                    statisticItem = ((sk6) jk6Var).K(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public a28(a08 a08Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a08Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = new j28();
        this.e = 0;
        this.j = 0L;
        this.a = new c28();
        if (UbsABTestHelper.disableHomeMaxThreadCount()) {
            this.b = LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        } else {
            this.b = SharedPrefHelper.getInstance().getInt("home_page_max_thread_count", 300);
        }
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.k = new ArrayList();
        this.l = a08Var;
    }

    public final void A(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        List<ThreadInfo> list;
        List<ThreadInfo> list2;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) && builder != null && builder2 != null && (list = builder.thread_list) != null && (list2 = builder2.thread_list) != null) {
            this.f = ListUtils.getCount(list);
            BannerList bannerList = builder.banner_list;
            if (bannerList != null) {
                this.g = ListUtils.getCount(bannerList.app);
            } else {
                this.g = 0;
            }
            int count = ListUtils.getCount(list) + ListUtils.getCount(this.h);
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null && !TextUtils.isEmpty(threadInfo.lego_card)) {
                    hashSet2.add(threadInfo.lego_card);
                } else if (threadInfo != null && threadInfo.tid != null) {
                    hashSet.add(y18.a(builder, threadInfo));
                }
            }
            HashSet hashSet3 = new HashSet();
            HashSet hashSet4 = new HashSet();
            Iterator<ThreadInfo> it = this.h.iterator();
            while (it.hasNext()) {
                ThreadInfo next = it.next();
                if (next != null && !TextUtils.isEmpty(next.lego_card)) {
                    hashSet4.add(next.lego_card);
                } else if (next != null && next.tid != null) {
                    hashSet3.add(y18.a(builder, next));
                }
            }
            if (i == 1) {
                if (!ListUtils.isEmpty(list2)) {
                    this.d.b((ThreadInfo) ListUtils.getItem(list2, 0));
                }
                for (ThreadInfo threadInfo2 : list2) {
                    if (threadInfo2 != null && !TextUtils.isEmpty(threadInfo2.lego_card)) {
                        if (!hashSet2.contains(threadInfo2.lego_card) && !hashSet4.contains(threadInfo2.lego_card)) {
                            list.add(threadInfo2);
                        }
                    } else if (threadInfo2 != null && threadInfo2.tid != null) {
                        x18 a2 = y18.a(builder2, threadInfo2);
                        if (!hashSet.contains(a2) && !hashSet3.contains(a2)) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!a2.a() || !z3) {
                            list.add(threadInfo2);
                            JSONObject b2 = h1a.b(threadInfo2);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                        }
                    }
                }
            } else {
                this.d.c(z, list);
                if (y()) {
                    BannerList bannerList2 = builder.banner_list;
                    if (bannerList2 != null && !ListUtils.isEmpty(bannerList2.app)) {
                        this.i.addAll(0, builder.banner_list.app);
                        BannerList.Builder builder3 = new BannerList.Builder(builder.banner_list);
                        builder3.app = new LinkedList();
                        builder.banner_list = builder3.build(false);
                    }
                    this.h.addAll(0, list);
                    list.clear();
                    hashSet.clear();
                    hashSet2.clear();
                    if (ListUtils.getCount(this.h) > this.b) {
                        for (int size = this.h.size() - 1; size >= this.b; size--) {
                            this.h.remove(size);
                        }
                    }
                    hashSet3.clear();
                    hashSet4.clear();
                    Iterator<ThreadInfo> it2 = this.h.iterator();
                    while (it2.hasNext()) {
                        ThreadInfo next2 = it2.next();
                        if (next2 != null && !TextUtils.isEmpty(next2.lego_card)) {
                            hashSet4.add(next2.lego_card);
                        } else if (next2 != null && next2.tid != null) {
                            hashSet3.add(y18.a(builder, next2));
                        }
                    }
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ThreadInfo threadInfo3 = (ThreadInfo) ListUtils.getItem(list2, count2);
                    if (threadInfo3 != null && !TextUtils.isEmpty(threadInfo3.lego_card)) {
                        if (!hashSet2.contains(threadInfo3.lego_card) && !hashSet4.contains(threadInfo3.lego_card)) {
                            list.add(0, threadInfo3);
                        }
                    } else if (threadInfo3 != null && threadInfo3.tid != null) {
                        x18 a3 = y18.a(builder2, threadInfo3);
                        if (!hashSet.contains(a3) && !hashSet3.contains(a3)) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (!a3.a() || !z2 || threadInfo3.is_highlight.intValue() == 1) {
                            list.add(0, threadInfo3);
                            JSONObject b3 = h1a.b(threadInfo3);
                            if (b3 != null) {
                                arrayList.add(0, b3);
                            }
                        }
                    }
                }
            }
            if (y()) {
                if (!ListUtils.isEmpty(this.i) && builder2.banner_list != null) {
                    int count3 = ListUtils.getCount(list2) + ListUtils.getCount(builder2.banner_list.app);
                    for (int i2 = 0; i2 < this.i.size(); i2++) {
                        App app = this.i.get(i2);
                        if (app != null) {
                            App.Builder builder4 = new App.Builder(app);
                            xy9.c(builder4, count3);
                            App build = builder4.build(false);
                            this.i.remove(i2);
                            this.i.add(i2, build);
                        }
                    }
                }
                if (ListUtils.getCount(list) >= this.e) {
                    list.addAll(this.h);
                    this.h.clear();
                    BannerList.Builder builder5 = new BannerList.Builder(builder.banner_list);
                    if (builder5.app == null) {
                        builder5.app = new LinkedList();
                    }
                    builder5.app.addAll(this.i);
                    builder.banner_list = builder5.build(false);
                    this.i.clear();
                }
            }
            int count4 = (ListUtils.getCount(list) + ListUtils.getCount(this.h)) - count;
            this.a.b = count4;
            this.c = count4;
            h1a.f().h("HOME", arrayList);
        }
    }

    public final void B(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2) == null) && list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    public final void C(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) && builder != null && builder2 != null) {
            Integer num = builder2.fresh_ctrl_num;
            if (num != null && num.intValue() > 0) {
                i2 = builder2.fresh_ctrl_num.intValue();
            } else {
                i2 = 0;
            }
            this.e = i2;
            int i3 = this.b;
            if (i2 > i3) {
                i2 = i3;
            }
            this.e = i2;
            A(z, builder, builder2, i);
            z(z, builder, builder2, i);
            B(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    public final List<ThreadInfo> D(DataRes.Builder builder, int i, int i2) {
        InterceptResult invokeLII;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, builder, i, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (builder != null && (list = builder.thread_list) != null) {
                if (i == 1) {
                    for (int count = ((ListUtils.getCount(list) - i2) + 30) - 1; count >= 30; count--) {
                        if (list.size() > count) {
                            arrayList.add(list.remove(count));
                        }
                    }
                } else {
                    for (int count2 = ListUtils.getCount(list) - 1; count2 >= i2; count2--) {
                        list.remove(count2);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLII.objValue;
    }

    public void s(List<yh> list, s18 s18Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048603, this, list, s18Var, z) == null) {
            if (z) {
                DefaultLog.getInstance().i("RecentForumLog", "插入最进逛的吧，有直播数据，不插入");
            } else if (list != null && this.a.a != null) {
                E(list);
                E(this.a.a);
                int l = l(list);
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("RecentForumLog", "插入最进逛的吧，Banner位置为：" + l);
                list.add(l + 1, s18Var);
                this.a.a.add(0, s18Var);
                s18Var.position = -1;
            }
        }
    }

    public final void E(List<yh> list) {
        int e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, list) == null) && (e = e(list)) != -1) {
            list.remove(e);
        }
    }

    public final boolean G(DataRes.Builder builder) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, builder)) == null) {
            if (builder == null || (num = builder.show_adsense) == null || num.intValue() != 1) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void H(List<yk6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, list) != null) || list == null) {
            return;
        }
        Collections.sort(list, new a(this));
    }

    public final int e(List<yh> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, list)) == null) {
            if (list != null && !ListUtils.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) instanceof s18) {
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final int l(List<yh> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, list)) == null) {
            if (list != null && !ListUtils.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) instanceof u18) {
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final void F(List<yh> list) {
        BaseCardInfo baseCardInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            Iterator<yh> it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                yh next = it.next();
                if ((next instanceof BaseCardInfo) && (i = (baseCardInfo = (BaseCardInfo) next).position) > 0) {
                    baseCardInfo.position = i - i2;
                }
                if ((next instanceof RecommendBarCardModel) && !((RecommendBarCardModel) next).i()) {
                    it.remove();
                    i2++;
                }
            }
        }
    }

    public final void a(List<yh> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            int i = 0;
            int i2 = 0;
            for (yh yhVar : list) {
                if (yhVar instanceof RecommendBarCardModel) {
                    RecommendBarCardModel recommendBarCardModel = (RecommendBarCardModel) yhVar;
                    if (recommendBarCardModel.i()) {
                        recommendBarCardModel.position = i2 + 1;
                        i++;
                    }
                }
                if (yhVar instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) yhVar;
                    i2 = baseCardInfo.position + i;
                    baseCardInfo.position = i2;
                }
            }
        }
    }

    public void I(long j, boolean z) {
        c28 c28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) && (c28Var = this.a) != null && !ListUtils.isEmpty(c28Var.a)) {
            for (yh yhVar : this.a.a) {
                if (yhVar instanceof jk6) {
                    jk6 jk6Var = (jk6) yhVar;
                    if (jk6Var.n && j == jk6Var.getThreadData().getFid() && z != jk6Var.getThreadData().getForumData().f()) {
                        jk6Var.getThreadData().getForumData().o(z);
                    }
                }
            }
        }
    }

    public boolean v(List<yh> list, pw7 pw7Var) {
        InterceptResult invokeLL;
        int j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, list, pw7Var)) == null) {
            if (list != null && this.a.a != null && pw7Var != null && StringUtils.isNotNull(pw7Var.getTid())) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        break;
                    }
                    yh yhVar = list.get(i2);
                    if (yhVar instanceof rk6) {
                        rk6 rk6Var = (rk6) yhVar;
                        if (rk6Var.getThreadData() != null && StringUtils.isNotNull(rk6Var.getThreadData().getTid()) && rk6Var.getThreadData().getTid().equals(pw7Var.getTid())) {
                            pw7Var.Y(rk6Var.getThreadData().getClickBackCard());
                            i = i2;
                            break;
                        }
                    }
                    i2++;
                }
                if (x(list, pw7Var) || !pw7.Z(pw7Var) || (j = j(i, list, pw7Var.getTid())) < 0) {
                    return false;
                }
                list.add(j, pw7Var);
                this.a.a.add(j, pw7Var);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final q18 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            c28 c28Var = this.a;
            if (c28Var != null && !ListUtils.isEmpty(c28Var.a)) {
                for (yh yhVar : this.a.a) {
                    if (yhVar instanceof q18) {
                        return (q18) yhVar;
                    }
                }
            }
            return null;
        }
        return (q18) invokeV.objValue;
    }

    public final t18 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c28 c28Var = this.a;
            if (c28Var != null && !ListUtils.isEmpty(c28Var.a)) {
                for (yh yhVar : this.a.a) {
                    if (yhVar instanceof t18) {
                        return (t18) yhVar;
                    }
                }
            }
            return null;
        }
        return (t18) invokeV.objValue;
    }

    @Nullable
    public final List<RecommendBarCardModel> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            c28 c28Var = this.a;
            if (c28Var != null && !ListUtils.isEmpty(c28Var.a)) {
                ArrayList arrayList = new ArrayList();
                for (yh yhVar : this.a.a) {
                    if (yhVar instanceof RecommendBarCardModel) {
                        RecommendBarCardModel recommendBarCardModel = (RecommendBarCardModel) yhVar;
                        if (recommendBarCardModel.i()) {
                            arrayList.add(recommendBarCardModel);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public c28 f(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        InterceptResult invokeCommon;
        DataRes.Builder builder3;
        DataRes.Builder builder4;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)})) == null) {
            if (i != 0 && i != 1) {
                return null;
            }
            if (builder == null) {
                builder3 = new DataRes.Builder();
            } else {
                builder3 = builder;
            }
            if (builder2 == null) {
                builder4 = new DataRes.Builder();
            } else {
                builder4 = builder2;
            }
            e28.c(builder3);
            e28.c(builder4);
            C(z, builder3, builder4, i);
            List<ThreadInfo> D = D(builder3, i, this.b);
            e28.p(builder3);
            List<AdvertAppInfo> g = tz9.m().g();
            int i3 = 0;
            if (i != 0 && z && g != null) {
                i2 = g.size();
            } else {
                i2 = 0;
            }
            List<yk6> d = e28.d(builder3);
            H(d);
            int i4 = i2;
            List<yh> o = o(builder3.thread_list, d, builder4.user_follow_live, i, 0, builder4, i4, z);
            List<yh> o2 = o(D, new ArrayList(), builder4.user_follow_live, i, 1, null, i4, z);
            this.d.a(o);
            b28.c(builder3, o);
            c28 c28Var = this.a;
            c28Var.a = o;
            if (o2 != null) {
                i3 = o2.size();
            }
            c28Var.c = i3;
            return this.a;
        }
        return (c28) invokeCommon.objValue;
    }

    public List<ThreadInfo> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.h;
        }
        return (List) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            ArrayList<ThreadInfo> arrayList = this.h;
            if (arrayList != null && !ListUtils.isEmpty(arrayList)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.e > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int j(int i, @NonNull List<yh> list, @NonNull String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048594, this, i, list, str)) == null) {
            return p28.a(i, list, str);
        }
        return invokeILL.intValue;
    }

    public final int k(@NonNull String str, @NonNull List<yh> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, str, list)) == null) {
            for (int i = 0; i < list.size(); i++) {
                yh yhVar = list.get(i);
                if (yhVar instanceof jk6) {
                    jk6 jk6Var = (jk6) yhVar;
                    if (jk6Var.getThreadData() != null && !TextUtils.isEmpty(jk6Var.getThreadData().getTid()) && str.equals(jk6Var.getThreadData().getTid())) {
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public void n(List<yh> list, UserFollowLive userFollowLive) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, list, userFollowLive) == null) && b() == null && list != null && this.a.a != null && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
            DefaultLog.getInstance().i("RecentForumLog", "直播入口插入，删除最近逛的吧模快");
            E(list);
            E(this.a.a);
            q18 q18Var = new q18();
            q18Var.d(userFollowLive);
            list.add(0, q18Var);
            this.a.a.add(0, q18Var);
            q18Var.position = -1;
        }
    }

    public final void m(yk6 yk6Var, List<yh> list, int i, int i2, int i3) {
        e16 e16Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{yk6Var, list, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            AbsDataRecorder g = a16.i().g(AbsDataRecorder.Scene.RECOMMEND);
            String str = null;
            if (g instanceof e16) {
                e16Var = (e16) g;
            } else {
                e16Var = null;
            }
            if (yk6Var instanceof l18) {
                str = ((l18) yk6Var).a.a;
            }
            if (e16Var != null && !ListUtils.isEmpty(e16Var.d()) && e16Var.d().contains(str)) {
                a16.i().n(list, i + 1, 1);
            } else if (i2 == i3 + 1 && a16.i().p(AbsDataRecorder.Scene.RECOMMEND)) {
                a16.i().n(list, i + 1, 1);
                if (!StringUtils.isNull(str) && e16Var != null && e16Var.d() != null) {
                    e16Var.d().add(str);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x05f8  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0647  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<yh> o(List<ThreadInfo> list, List<yk6> list2, UserFollowLive userFollowLive, int i, int i2, DataRes.Builder builder, int i3, boolean z) {
        InterceptResult invokeCommon;
        char c;
        int i4;
        Iterator<yh> it;
        boolean z2;
        int e;
        q18 b2;
        List<RecommendBarCardModel> c2;
        int j;
        Iterator<yh> it2;
        long j2;
        long j3;
        t18 t18Var;
        boolean z3;
        jk6 e2;
        rk6 i5;
        ThreadRecommendInfoData threadRecommendInfoData;
        rk6 i6;
        wk6 h;
        pw7 g;
        rk6 i7;
        rk6 i8;
        rk6 i9;
        int e3;
        RecommendBarCardModel recommendBarCardModel;
        int i10;
        nw7 nw7Var;
        int d;
        HeaderCard headerCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{list, list2, userFollowLive, Integer.valueOf(i), Integer.valueOf(i2), builder, Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (list == null) {
                return null;
            }
            long j4 = 0;
            int i11 = 1;
            if (builder != null && !ListUtils.isEmpty(builder.thread_list) && builder.active_center != null) {
                ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
                if (threadInfo.id.longValue() > 0 && io4.f().l()) {
                    this.j = threadInfo.id;
                }
            }
            List<yh> arrayList = new ArrayList<>(ListUtils.getCount(list));
            Iterator<ThreadInfo> it3 = list.iterator();
            while (true) {
                c = 0;
                if (!it3.hasNext()) {
                    break;
                }
                ThreadData threadData = new ThreadData();
                AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                threadData.isFromHomPage = true;
                threadData.parserProtobuf(it3.next());
                arrayList.add(threadData);
            }
            nta ntaVar = new nta();
            if (builder != null && (headerCard = builder.header_card) != null) {
                ntaVar.g(headerCard);
            }
            if (i2 == 0 && tta.p(ntaVar, false)) {
                tta ttaVar = new tta();
                ttaVar.m(1);
                ttaVar.h(ntaVar);
                if (ListUtils.add(arrayList, ttaVar.getPosition(), ttaVar)) {
                    int position = ttaVar.getPosition();
                    ttaVar.position = position;
                    i4 = position;
                    if (i2 == 0 && nw7.l(builder)) {
                        nw7Var = new nw7();
                        nw7Var.i(builder.hot_card);
                        d = nw7Var.d() - 1;
                        if (d >= 0 && ListUtils.add(arrayList, d, nw7Var)) {
                            nw7Var.position = d;
                        }
                    }
                    if (builder != null && RecommendBarCardModel.t(builder.hot_recomforum, -1)) {
                        recommendBarCardModel = new RecommendBarCardModel();
                        if (builder.hot_recomforum.floor.intValue() <= 0) {
                            i10 = builder.hot_recomforum.floor.intValue() - 1;
                        } else {
                            i10 = 0;
                        }
                        recommendBarCardModel.floorPosition = i10;
                        if (recommendBarCardModel.m(builder.hot_recomforum.tab_list)) {
                            p(recommendBarCardModel, recommendBarCardModel.floorPosition, arrayList);
                        }
                    }
                    if (i2 == 0 && UbsABTestHelper.isPersonalizeFunAdABTest() && G(builder)) {
                        int f = w65.f();
                        e3 = w65.e();
                        if (i == 0) {
                            e3 = w65.a();
                            this.k.clear();
                        }
                        if (i4 >= 0 && e3 > i4) {
                            e3++;
                        }
                        q(e3, f, arrayList);
                    }
                    List<yh> linkedList = new LinkedList<>();
                    it = arrayList.iterator();
                    int i12 = 0;
                    while (it.hasNext()) {
                        yh next = it.next();
                        boolean z4 = next instanceof ThreadData;
                        if (z4 && ((ThreadData) next).isFunAdPlaceHolder()) {
                            if (G(builder)) {
                                linkedList.add(next);
                                i12++;
                            }
                            it2 = it;
                            j2 = j4;
                        } else if (z4) {
                            ThreadData threadData2 = (ThreadData) next;
                            int i13 = i12 + 1;
                            threadData2.floorPosition = i13;
                            threadData2.isFromNet = z;
                            if (!TextUtils.isEmpty(threadData2.getLegoCard())) {
                                cx4 cx4Var = new cx4();
                                cx4Var.e(threadData2.getLegoCard());
                                cx4Var.position = i12;
                                linkedList.add(cx4Var);
                            } else if (r48.G(threadData2)) {
                                if (StringUtils.isNull(threadData2.getTopicModule().topic_name)) {
                                    j4 = 0;
                                } else {
                                    r48 r48Var = new r48();
                                    r48Var.I(threadData2.getTopicModule());
                                    r48Var.Z = i11;
                                    r48Var.position = i12;
                                    r48Var.K(threadData2);
                                    r48Var.setSupportType(BaseCardInfo.SupportType.FULL);
                                    linkedList.add(r48Var);
                                }
                            } else if (!rk6.R(threadData2) && !sk6.L(threadData2) && !tk6.R(threadData2)) {
                                if (mk6.R(threadData2) && threadData2.isBJHArticleThreadType()) {
                                    mk6 mk6Var = new mk6(threadData2);
                                    mk6Var.position = i12;
                                    linkedList.add(mk6Var);
                                } else {
                                    jk6 e4 = e28.e(threadData2);
                                    if (e4 != null) {
                                        e4.g = threadData2.getTid();
                                        e4.position = i12;
                                    }
                                    if (e4 != null && e4.isValid()) {
                                        linkedList.add(e4);
                                    }
                                }
                            } else {
                                rk6 i14 = e28.i(threadData2);
                                if (i14 != null) {
                                    if (!threadData2.showCardEnterFourm() && !"user".equals(threadData2.getHeadType())) {
                                        ThreadData threadData3 = i14.a;
                                        if (threadData3 != null && threadData3.getForumData() != null && !StringUtils.isNull(threadData3.getForumData().b)) {
                                            i14.g = threadData2.getTid();
                                            i14.position = i12;
                                            e28.t(i14);
                                            linkedList.add(i14);
                                            z3 = true;
                                            e2 = e28.e(threadData2);
                                            if (e2 != null) {
                                                e2.g = threadData2.getTid();
                                                e2.position = i12;
                                                if (e2 instanceof rk6) {
                                                    if (threadData2.isBJHNormalThreadType()) {
                                                        e28.w(e2);
                                                    } else if (threadData2.picCount() == i11) {
                                                        e28.y(e2);
                                                        int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                                                        it2 = it;
                                                        e2.j = imageWidthAndHeight[c];
                                                        e2.k = imageWidthAndHeight[i11];
                                                    } else {
                                                        it2 = it;
                                                        if (threadData2.picCount() >= 2) {
                                                            e28.x(e2);
                                                        } else {
                                                            e28.z(e2);
                                                        }
                                                    }
                                                } else {
                                                    it2 = it;
                                                    if (e2 instanceof sk6) {
                                                        e28.A(e2);
                                                    }
                                                }
                                                if (e2 instanceof tk6) {
                                                    e28.B(e2);
                                                }
                                                if (e2 != null && e2.isValid()) {
                                                    e2.a.insertItemToTitleOrAbstractText();
                                                    if (!threadData2.isUgcThreadType() && threadData2.getAuthor() != null && z3) {
                                                        String string = TbadkCoreApplication.getInst().getString(R.string.at_username);
                                                        Object[] objArr = new Object[i11];
                                                        objArr[c] = threadData2.getAuthor().getName_show();
                                                        String format = String.format(string, objArr);
                                                        SpannableString spannableString = new SpannableString(format);
                                                        spannableString.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), e2), 0, format.length() - 1, 33);
                                                        e2.a.insertUsernameIntoTitleOrAbstract(spannableString);
                                                    }
                                                    linkedList.add(e2);
                                                }
                                                if (threadData2.getItem() != null && (i9 = e28.i(threadData2)) != null) {
                                                    i9.g = threadData2.getTid();
                                                    i9.position = i12;
                                                    e28.C(i9);
                                                    if (!rk6.R(threadData2)) {
                                                        i9.E("1");
                                                    } else if (sk6.L(threadData2)) {
                                                        i9.E("2");
                                                    }
                                                    linkedList.add(i9);
                                                }
                                                if ((ListUtils.isEmpty(threadData2.getLinkDataList()) || !ListUtils.isEmpty(threadData2.getGoodsDataList())) && (i5 = e28.i(threadData2)) != null) {
                                                    i5.g = threadData2.getTid();
                                                    i5.position = i12;
                                                    if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) == 1) {
                                                        e28.F(i5);
                                                    } else {
                                                        e28.D(i5);
                                                    }
                                                    linkedList.add(i5);
                                                }
                                                threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                                if (threadRecommendInfoData != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason) && (i8 = e28.i(threadData2)) != null) {
                                                    i8.g = threadData2.getTid();
                                                    i8.position = i12;
                                                    e28.E(i8);
                                                    if (i8.isValid()) {
                                                        linkedList.add(i8);
                                                    }
                                                }
                                                if (threadData2.showCardEnterFourm() && (i7 = e28.i(threadData2)) != null) {
                                                    i7.g = threadData2.getTid();
                                                    i7.position = i12;
                                                    e28.s(i7);
                                                    if (!rk6.R(threadData2)) {
                                                        i7.E("1");
                                                    } else if (sk6.L(threadData2)) {
                                                        i7.E("2");
                                                    }
                                                    if (!threadData2.showCardEnterFourm() && !StringUtils.isNull(threadData2.getForum_name())) {
                                                        linkedList.add(i7);
                                                    } else if (!StringUtils.isNull(threadData2.getForum_name())) {
                                                        linkedList.add(i7);
                                                    }
                                                }
                                                if (threadData2.getTopAgreePost() != null) {
                                                    rk6 i15 = e28.i(threadData2);
                                                    if (i15 != null) {
                                                        i15.g = threadData2.getTid();
                                                        i15.position = i12;
                                                        e28.u(i15);
                                                    }
                                                    if (i15 != null && i15.isValid()) {
                                                        linkedList.add(i15);
                                                    }
                                                }
                                                i6 = e28.i(threadData2);
                                                if (i6 != null) {
                                                    i6.g = threadData2.getTid();
                                                    i6.position = i12;
                                                    e28.r(i6);
                                                }
                                                if (i6 != null && i6.isValid() && ThreadCardUtils.isBottomShowOp(i6.a)) {
                                                    linkedList.add(i6);
                                                }
                                                h = e28.h(threadData2, z);
                                                if (h != null) {
                                                    h.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                                                    h.position = i13;
                                                    h.setTid(threadData2.tid);
                                                    linkedList.add(h);
                                                }
                                                g = e28.g(threadData2);
                                                if (g != null && pw7.X(g) && x(this.a.a, g) && !x(linkedList, g)) {
                                                    g.g = threadData2.getTid();
                                                    linkedList.add(g);
                                                }
                                                j2 = 0;
                                                j3 = JavaTypesHelper.toLong(threadData2.getId(), 0L);
                                                if (j3 != 0 && j3 == this.j.longValue()) {
                                                    if (builder.active_center == null) {
                                                        t18Var = new t18();
                                                        t18Var.G(builder.active_center);
                                                    } else {
                                                        t18Var = null;
                                                    }
                                                    if (t18Var == null) {
                                                        t18Var = d();
                                                    }
                                                    if (t18Var != null) {
                                                        t18Var.R = i13;
                                                        linkedList.add(t18Var);
                                                        i12 = i13;
                                                    }
                                                }
                                                i12++;
                                            }
                                            it2 = it;
                                            if (e2 instanceof tk6) {
                                            }
                                            if (e2 != null) {
                                                e2.a.insertItemToTitleOrAbstractText();
                                                if (!threadData2.isUgcThreadType()) {
                                                    String string2 = TbadkCoreApplication.getInst().getString(R.string.at_username);
                                                    Object[] objArr2 = new Object[i11];
                                                    objArr2[c] = threadData2.getAuthor().getName_show();
                                                    String format2 = String.format(string2, objArr2);
                                                    SpannableString spannableString2 = new SpannableString(format2);
                                                    spannableString2.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), e2), 0, format2.length() - 1, 33);
                                                    e2.a.insertUsernameIntoTitleOrAbstract(spannableString2);
                                                }
                                                linkedList.add(e2);
                                            }
                                            if (threadData2.getItem() != null) {
                                                i9.g = threadData2.getTid();
                                                i9.position = i12;
                                                e28.C(i9);
                                                if (!rk6.R(threadData2)) {
                                                }
                                                linkedList.add(i9);
                                            }
                                            if (ListUtils.isEmpty(threadData2.getLinkDataList())) {
                                            }
                                            i5.g = threadData2.getTid();
                                            i5.position = i12;
                                            if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) == 1) {
                                            }
                                            linkedList.add(i5);
                                            threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                            if (threadRecommendInfoData != null) {
                                                i8.g = threadData2.getTid();
                                                i8.position = i12;
                                                e28.E(i8);
                                                if (i8.isValid()) {
                                                }
                                            }
                                            if (threadData2.showCardEnterFourm()) {
                                                i7.g = threadData2.getTid();
                                                i7.position = i12;
                                                e28.s(i7);
                                                if (!rk6.R(threadData2)) {
                                                }
                                                if (!threadData2.showCardEnterFourm()) {
                                                }
                                                if (!StringUtils.isNull(threadData2.getForum_name())) {
                                                }
                                            }
                                            if (threadData2.getTopAgreePost() != null) {
                                            }
                                            i6 = e28.i(threadData2);
                                            if (i6 != null) {
                                            }
                                            if (i6 != null) {
                                                linkedList.add(i6);
                                            }
                                            h = e28.h(threadData2, z);
                                            if (h != null) {
                                            }
                                            g = e28.g(threadData2);
                                            if (g != null) {
                                                g.g = threadData2.getTid();
                                                linkedList.add(g);
                                            }
                                            j2 = 0;
                                            j3 = JavaTypesHelper.toLong(threadData2.getId(), 0L);
                                            if (j3 != 0) {
                                                if (builder.active_center == null) {
                                                }
                                                if (t18Var == null) {
                                                }
                                                if (t18Var != null) {
                                                }
                                            }
                                            i12++;
                                        } else if (i14.isValid()) {
                                            i14.g = threadData2.getTid();
                                            i14.position = i12;
                                            e28.v(i14);
                                            linkedList.add(i14);
                                        }
                                    } else if (i14.isValid()) {
                                        i14.g = threadData2.getTid();
                                        i14.position = i12;
                                        e28.v(i14);
                                        linkedList.add(i14);
                                    }
                                }
                                z3 = false;
                                e2 = e28.e(threadData2);
                                if (e2 != null) {
                                }
                                it2 = it;
                                if (e2 instanceof tk6) {
                                }
                                if (e2 != null) {
                                }
                                if (threadData2.getItem() != null) {
                                }
                                if (ListUtils.isEmpty(threadData2.getLinkDataList())) {
                                }
                                i5.g = threadData2.getTid();
                                i5.position = i12;
                                if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) == 1) {
                                }
                                linkedList.add(i5);
                                threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                if (threadRecommendInfoData != null) {
                                }
                                if (threadData2.showCardEnterFourm()) {
                                }
                                if (threadData2.getTopAgreePost() != null) {
                                }
                                i6 = e28.i(threadData2);
                                if (i6 != null) {
                                }
                                if (i6 != null) {
                                }
                                h = e28.h(threadData2, z);
                                if (h != null) {
                                }
                                g = e28.g(threadData2);
                                if (g != null) {
                                }
                                j2 = 0;
                                j3 = JavaTypesHelper.toLong(threadData2.getId(), 0L);
                                if (j3 != 0) {
                                }
                                i12++;
                            }
                            it2 = it;
                            j2 = 0;
                            j3 = JavaTypesHelper.toLong(threadData2.getId(), 0L);
                            if (j3 != 0) {
                            }
                            i12++;
                        } else {
                            it2 = it;
                            j2 = j4;
                            if (next instanceof BaseCardInfo) {
                                linkedList.add(next);
                            } else {
                                linkedList.add(next);
                            }
                            i12++;
                        }
                        j4 = j2;
                        it = it2;
                        i11 = 1;
                        c = 0;
                    }
                    if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                        int i16 = 0;
                        int i17 = 0;
                        for (int i18 = 0; i18 < ListUtils.getCount(list2); i18++) {
                            yk6 yk6Var = (yk6) ListUtils.getItem(list2, i18);
                            if (yk6Var != null && i16 < linkedList.size()) {
                                int i19 = i16;
                                while (i19 < linkedList.size() && (!(linkedList.get(i19) instanceof jk6) || h(((jk6) linkedList.get(i19)).position, i4) + i17 != yk6Var.getPosition() - 1)) {
                                    i19++;
                                }
                                if (linkedList.size() > i19 && i19 > 0) {
                                    linkedList.add(i19, yk6Var);
                                    int i20 = i17 + 1;
                                    m(yk6Var, linkedList, i19, i20, i3);
                                    i16 = i19;
                                    i17 = i20;
                                } else {
                                    i16 = i19;
                                }
                            }
                        }
                        int i21 = 0;
                        int i22 = 0;
                        for (yh yhVar : linkedList) {
                            if (yhVar instanceof bx4) {
                                ((bx4) yhVar).setPosition(i21 + 1);
                                i22++;
                            } else if (yhVar instanceof BaseCardInfo) {
                                BaseCardInfo baseCardInfo = (BaseCardInfo) yhVar;
                                i21 = baseCardInfo.position + i22;
                                baseCardInfo.position = i21;
                            }
                        }
                    }
                    if (i2 == 0 && i == 1) {
                        c2 = c();
                        if (!ListUtils.isEmpty(c2)) {
                            for (RecommendBarCardModel recommendBarCardModel2 : c2) {
                                String f2 = recommendBarCardModel2.f();
                                if (!TextUtils.isEmpty(f2) && (j = j(k(f2, linkedList), linkedList, f2)) >= 0 && j <= linkedList.size()) {
                                    linkedList.add(j, recommendBarCardModel2);
                                    a(linkedList);
                                }
                            }
                        }
                    }
                    if (i2 != 0) {
                        if (i == 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
                            DefaultLog.getInstance().i("RecentForumLog", "首页接口插入直播入口");
                            q18 q18Var = new q18();
                            q18Var.d(userFollowLive);
                            linkedList.add(0, q18Var);
                            q18Var.position = -1;
                        } else if (i == 1 && (b2 = b()) != null) {
                            linkedList.add(0, b2);
                            b2.position = -1;
                        } else {
                            z2 = false;
                            if (z2) {
                                DefaultLog.getInstance().i("RecentForumLog", "首页接口返回，设置有直播数据标志位");
                                this.l.a1(true);
                            }
                        }
                        z2 = true;
                        if (z2) {
                        }
                    } else {
                        z2 = false;
                    }
                    if (i2 == 0 && !z2) {
                        if (i != 0 && this.l.l0() > 0) {
                            DefaultLog.getInstance().i("RecentForumLog", "推荐接口返回, 且没有插入直播数据");
                            if (this.l.g0() != null) {
                                DefaultLog.getInstance().i("RecentForumLog", "推荐接口返回, 插入最近逛的吧模快");
                                linkedList.add(0, this.l.g0());
                            }
                        } else {
                            e = e(this.a.a);
                            if (e != -1) {
                                linkedList.add(0, (s18) this.a.a.get(e));
                            }
                        }
                    }
                    if (i2 == 0 && i == 0) {
                        a08 a08Var = this.l;
                        a08Var.e1(a08Var.l0() + 1);
                        TbLog defaultLog = DefaultLog.getInstance();
                        defaultLog.i("RecentForumLog", "推荐接口返回, 等待值：" + this.l.l0());
                    }
                    AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                    return linkedList;
                }
            }
            i4 = -1;
            if (i2 == 0) {
                nw7Var = new nw7();
                nw7Var.i(builder.hot_card);
                d = nw7Var.d() - 1;
                if (d >= 0) {
                    nw7Var.position = d;
                }
            }
            if (builder != null) {
                recommendBarCardModel = new RecommendBarCardModel();
                if (builder.hot_recomforum.floor.intValue() <= 0) {
                }
                recommendBarCardModel.floorPosition = i10;
                if (recommendBarCardModel.m(builder.hot_recomforum.tab_list)) {
                }
            }
            if (i2 == 0) {
                int f3 = w65.f();
                e3 = w65.e();
                if (i == 0) {
                }
                if (i4 >= 0) {
                    e3++;
                }
                q(e3, f3, arrayList);
            }
            List<yh> linkedList2 = new LinkedList<>();
            it = arrayList.iterator();
            int i122 = 0;
            while (it.hasNext()) {
            }
            if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
            }
            if (i2 == 0) {
                c2 = c();
                if (!ListUtils.isEmpty(c2)) {
                }
            }
            if (i2 != 0) {
            }
            if (i2 == 0) {
                if (i != 0) {
                }
                e = e(this.a.a);
                if (e != -1) {
                }
            }
            if (i2 == 0) {
                a08 a08Var2 = this.l;
                a08Var2.e1(a08Var2.l0() + 1);
                TbLog defaultLog2 = DefaultLog.getInstance();
                defaultLog2.i("RecentForumLog", "推荐接口返回, 等待值：" + this.l.l0());
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList2);
            return linkedList2;
        }
        return (List) invokeCommon.objValue;
    }

    public void p(jv4 jv4Var, int i, List<yh> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048600, this, jv4Var, i, list) != null) || jv4Var == null || list == null || i <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    jv4Var.floorPosition = i;
                    ListUtils.add(list, i3, jv4Var);
                    return;
                }
                i2++;
            }
        }
    }

    public final void q(int i, int i2, List<yh> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048601, this, i, i2, list) == null) && !ListUtils.isEmpty(list) && i >= 0 && i2 >= 1) {
            ListIterator<yh> listIterator = list.listIterator();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (listIterator.hasNext()) {
                if (i4 == i || (i4 > i && (i4 - i) % i2 == 0)) {
                    if (i5 < this.k.size()) {
                        listIterator.add(this.k.get(i5));
                    } else {
                        ThreadData threadData = new ThreadData();
                        nea neaVar = new nea();
                        neaVar.n(true);
                        threadData.funAdData = neaVar;
                        listIterator.add(threadData);
                        this.k.add(threadData);
                    }
                    i5++;
                    if (i3 == 0) {
                        i3 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i3 > 0 && a16.i().p(AbsDataRecorder.Scene.RECOMMEND)) {
                a16.i().n(list, i3, 1);
            }
        }
    }

    public void u(List<yh> list, y4a y4aVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048605, this, list, y4aVar, i) != null) || ListUtils.isEmpty(list) || y4aVar == null || i < 0) {
            return;
        }
        F(list);
        if (i == 0) {
            t(list, RecommendBarCardModel.e(y4aVar), y4aVar.a);
            return;
        }
        while (i < list.size() && !(list.get(i) instanceof jk6) && !(list.get(i) instanceof bx4)) {
            i++;
        }
        if (list.get(i) instanceof jk6) {
            t(list, RecommendBarCardModel.e(y4aVar), ((jk6) list.get(i)).position + 2);
        } else if (list.get(i) instanceof bx4) {
            t(list, RecommendBarCardModel.e(y4aVar), ((bx4) list.get(i)).n() + 2);
        }
    }

    public boolean r(List<yh> list, r18 r18Var, int i, int i2) {
        InterceptResult invokeLLII;
        RecommendBarCardModel d;
        int j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048602, this, list, r18Var, i, i2)) == null) {
            if (ListUtils.isEmpty(list) || r18Var == null || TextUtils.isEmpty(r18Var.b()) || i < 0 || i >= list.size() || i2 < 0 || i2 < i || i2 >= list.size() || (d = RecommendBarCardModel.d(r18Var)) == null || (j = j(k(r18Var.b(), list), list, r18Var.b())) < 0 || j > list.size() || j <= i) {
                return false;
            }
            d.o(r18Var.b());
            d.q(RecommendBarCardModel.RecDataSource.FORUMBACKCONCERN);
            list.add(j, d);
            this.a.a.add(j, d);
            a(list);
            return true;
        }
        return invokeLLII.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
        if (r5.size() <= r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
        r5.add(r0, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
        r5.add(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t(List<yh> list, RecommendBarCardModel recommendBarCardModel, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048604, this, list, recommendBarCardModel, i) == null) && recommendBarCardModel != null && !ListUtils.isEmpty(recommendBarCardModel.h())) {
            int i2 = 0;
            if (list.size() > 0) {
                int i3 = 0;
                while (i3 < list.size() && ((!(list.get(i3) instanceof jk6) || ((jk6) list.get(i3)).position + 1 != i) && (!(list.get(i3) instanceof bx4) || ((bx4) list.get(i3)).n() + 1 != i))) {
                    i3++;
                }
            }
            int i4 = 0;
            for (yh yhVar : list) {
                if (yhVar instanceof RecommendBarCardModel) {
                    RecommendBarCardModel recommendBarCardModel2 = (RecommendBarCardModel) yhVar;
                    if (!recommendBarCardModel2.i()) {
                        recommendBarCardModel2.position = i4 + 1;
                        i2++;
                    }
                }
                if (yhVar instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) yhVar;
                    i4 = baseCardInfo.position + i2;
                    baseCardInfo.position = i4;
                }
            }
        }
    }

    public final boolean x(List<yh> list, pw7 pw7Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, list, pw7Var)) == null) {
            if (this.a != null && !ListUtils.isEmpty(list)) {
                for (yh yhVar : list) {
                    if ((yhVar instanceof pw7) && ((pw7) yhVar).getTid().equals(pw7Var.getTid())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void z(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) {
            e28.m(z, builder, builder2, i, this.c, this.f, this.g);
        }
    }
}
