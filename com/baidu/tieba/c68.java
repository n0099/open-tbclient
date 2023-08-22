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
public class c68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final e68 a;
    public final int b;
    public int c;
    public l68 d;
    public int e;
    public int f;
    public int g;
    public ArrayList<ThreadInfo> h;
    public ArrayList<App> i;
    public Long j;
    public List<bn> k;
    public c48 l;

    public final int h(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048592, this, i, i2)) == null) ? (i2 < 0 || i <= i2) ? i : i - 1 : invokeII.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Comparator<fp6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(c68 c68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c68Var};
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
        public int compare(fp6 fp6Var, fp6 fp6Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fp6Var, fp6Var2)) == null) {
                if (fp6Var != null && fp6Var2 != null) {
                    if (fp6Var.getPosition() > fp6Var2.getPosition()) {
                        return 1;
                    }
                    if (fp6Var.getPosition() < fp6Var2.getPosition()) {
                        return -1;
                    }
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends h16 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ro6 m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c68 c68Var, int i, String str, ro6 ro6Var) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c68Var, Integer.valueOf(i), str, ro6Var};
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
            this.m = ro6Var;
        }

        @Override // com.baidu.tieba.h16, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), g(), null)));
                ro6 ro6Var = this.m;
                if (ro6Var instanceof zo6) {
                    statisticItem = ((zo6) ro6Var).N();
                } else if (ro6Var instanceof ap6) {
                    statisticItem = ((ap6) ro6Var).K(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public c68(c48 c48Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c48Var};
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
        this.d = new l68();
        this.e = 0;
        this.j = 0L;
        this.a = new e68();
        if (UbsABTestHelper.disableHomeMaxThreadCount()) {
            this.b = LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        } else {
            this.b = SharedPrefHelper.getInstance().getInt("home_page_max_thread_count", 300);
        }
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.k = new ArrayList();
        this.l = c48Var;
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
                    hashSet.add(a68.a(builder, threadInfo));
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
                    hashSet3.add(a68.a(builder, next));
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
                        z58 a2 = a68.a(builder2, threadInfo2);
                        if (!hashSet.contains(a2) && !hashSet3.contains(a2)) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!a2.a() || !z3) {
                            list.add(threadInfo2);
                            JSONObject b2 = f3a.b(threadInfo2);
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
                            hashSet3.add(a68.a(builder, next2));
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
                        z58 a3 = a68.a(builder2, threadInfo3);
                        if (!hashSet.contains(a3) && !hashSet3.contains(a3)) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (!a3.a() || !z2 || threadInfo3.is_highlight.intValue() == 1) {
                            list.add(0, threadInfo3);
                            JSONObject b3 = f3a.b(threadInfo3);
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
                            v0a.c(builder4, count3);
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
            f3a.f().h("HOME", arrayList);
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

    public void s(List<bn> list, u58 u58Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048603, this, list, u58Var, z) == null) {
            if (z) {
                DefaultLog.getInstance().i("RecentForumLog", "插入最进逛的吧，有直播数据，不插入");
            } else if (list != null && this.a.a != null) {
                E(list);
                E(this.a.a);
                int l = l(list);
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("RecentForumLog", "插入最进逛的吧，Banner位置为：" + l);
                list.add(l + 1, u58Var);
                this.a.a.add(0, u58Var);
                u58Var.position = -1;
            }
        }
    }

    public final void E(List<bn> list) {
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

    public final void H(List<fp6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, list) != null) || list == null) {
            return;
        }
        Collections.sort(list, new a(this));
    }

    public final int e(List<bn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, list)) == null) {
            if (list != null && !ListUtils.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) instanceof u58) {
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final int l(List<bn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, list)) == null) {
            if (list != null && !ListUtils.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) instanceof w58) {
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final void F(List<bn> list) {
        BaseCardInfo baseCardInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            Iterator<bn> it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                bn next = it.next();
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

    public final void a(List<bn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            int i = 0;
            int i2 = 0;
            for (bn bnVar : list) {
                if (bnVar instanceof RecommendBarCardModel) {
                    RecommendBarCardModel recommendBarCardModel = (RecommendBarCardModel) bnVar;
                    if (recommendBarCardModel.i()) {
                        recommendBarCardModel.position = i2 + 1;
                        i++;
                    }
                }
                if (bnVar instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) bnVar;
                    i2 = baseCardInfo.position + i;
                    baseCardInfo.position = i2;
                }
            }
        }
    }

    public void I(long j, boolean z) {
        e68 e68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) && (e68Var = this.a) != null && !ListUtils.isEmpty(e68Var.a)) {
            for (bn bnVar : this.a.a) {
                if (bnVar instanceof ro6) {
                    ro6 ro6Var = (ro6) bnVar;
                    if (ro6Var.n && j == ro6Var.getThreadData().getFid() && z != ro6Var.getThreadData().getForumData().f()) {
                        ro6Var.getThreadData().getForumData().n(z);
                    }
                }
            }
        }
    }

    public boolean v(List<bn> list, r08 r08Var) {
        InterceptResult invokeLL;
        int j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, list, r08Var)) == null) {
            if (list != null && this.a.a != null && r08Var != null && StringUtils.isNotNull(r08Var.getTid())) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        break;
                    }
                    bn bnVar = list.get(i2);
                    if (bnVar instanceof zo6) {
                        zo6 zo6Var = (zo6) bnVar;
                        if (zo6Var.getThreadData() != null && StringUtils.isNotNull(zo6Var.getThreadData().getTid()) && zo6Var.getThreadData().getTid().equals(r08Var.getTid())) {
                            r08Var.Y(zo6Var.getThreadData().getClickBackCard());
                            i = i2;
                            break;
                        }
                    }
                    i2++;
                }
                if (x(list, r08Var) || !r08.Z(r08Var) || (j = j(i, list, r08Var.getTid())) < 0) {
                    return false;
                }
                list.add(j, r08Var);
                this.a.a.add(j, r08Var);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final s58 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            e68 e68Var = this.a;
            if (e68Var != null && !ListUtils.isEmpty(e68Var.a)) {
                for (bn bnVar : this.a.a) {
                    if (bnVar instanceof s58) {
                        return (s58) bnVar;
                    }
                }
            }
            return null;
        }
        return (s58) invokeV.objValue;
    }

    public final v58 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            e68 e68Var = this.a;
            if (e68Var != null && !ListUtils.isEmpty(e68Var.a)) {
                for (bn bnVar : this.a.a) {
                    if (bnVar instanceof v58) {
                        return (v58) bnVar;
                    }
                }
            }
            return null;
        }
        return (v58) invokeV.objValue;
    }

    @Nullable
    public final List<RecommendBarCardModel> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            e68 e68Var = this.a;
            if (e68Var != null && !ListUtils.isEmpty(e68Var.a)) {
                ArrayList arrayList = new ArrayList();
                for (bn bnVar : this.a.a) {
                    if (bnVar instanceof RecommendBarCardModel) {
                        RecommendBarCardModel recommendBarCardModel = (RecommendBarCardModel) bnVar;
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

    public e68 f(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)})) == null) {
            if (i != 0 && i != 1) {
                return null;
            }
            if (builder == null) {
                builder = new DataRes.Builder();
            }
            if (builder2 == null) {
                builder2 = new DataRes.Builder();
            }
            g68.c(builder);
            g68.c(builder2);
            C(z, builder, builder2, i);
            List<ThreadInfo> D = D(builder, i, this.b);
            g68.o(builder);
            List<AdvertAppInfo> g = r1a.m().g();
            int i3 = 0;
            if (i != 0 && z && g != null) {
                i2 = g.size();
            } else {
                i2 = 0;
            }
            List<fp6> d = g68.d(builder);
            H(d);
            List<bn> o = o(builder.thread_list, d, builder2.user_follow_live, i, 0, builder2, i2);
            List<bn> o2 = o(D, new ArrayList(), builder2.user_follow_live, i, 1, null, i2);
            this.d.a(o);
            d68.c(builder, o);
            e68 e68Var = this.a;
            e68Var.a = o;
            if (o2 != null) {
                i3 = o2.size();
            }
            e68Var.c = i3;
            return this.a;
        }
        return (e68) invokeCommon.objValue;
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

    public final int j(int i, @NonNull List<bn> list, @NonNull String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048594, this, i, list, str)) == null) {
            return q68.a(i, list, str);
        }
        return invokeILL.intValue;
    }

    public final int k(@NonNull String str, @NonNull List<bn> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, str, list)) == null) {
            for (int i = 0; i < list.size(); i++) {
                bn bnVar = list.get(i);
                if (bnVar instanceof ro6) {
                    ro6 ro6Var = (ro6) bnVar;
                    if (ro6Var.getThreadData() != null && !TextUtils.isEmpty(ro6Var.getThreadData().getTid()) && str.equals(ro6Var.getThreadData().getTid())) {
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public void n(List<bn> list, UserFollowLive userFollowLive) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, list, userFollowLive) == null) && b() == null && list != null && this.a.a != null && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
            DefaultLog.getInstance().i("RecentForumLog", "直播入口插入，删除最近逛的吧模快");
            E(list);
            E(this.a.a);
            s58 s58Var = new s58();
            s58Var.d(userFollowLive);
            list.add(0, s58Var);
            this.a.a.add(0, s58Var);
            s58Var.position = -1;
        }
    }

    public final void m(fp6 fp6Var, List<bn> list, int i, int i2, int i3) {
        y56 y56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{fp6Var, list, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            AbsDataRecorder g = u56.i().g(AbsDataRecorder.Scene.RECOMMEND);
            String str = null;
            if (g instanceof y56) {
                y56Var = (y56) g;
            } else {
                y56Var = null;
            }
            if (fp6Var instanceof n58) {
                str = ((n58) fp6Var).a.a;
            }
            if (y56Var != null && !ListUtils.isEmpty(y56Var.d()) && y56Var.d().contains(str)) {
                u56.i().n(list, i + 1, 1);
            } else if (i2 == i3 + 1 && u56.i().p(AbsDataRecorder.Scene.RECOMMEND)) {
                u56.i().n(list, i + 1, 1);
                if (!StringUtils.isNull(str) && y56Var != null && y56Var.d() != null) {
                    y56Var.d().add(str);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0531  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x05b8  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x05f7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<bn> o(List<ThreadInfo> list, List<fp6> list2, UserFollowLive userFollowLive, int i, int i2, DataRes.Builder builder, int i3) {
        InterceptResult invokeCommon;
        char c;
        int i4;
        boolean z;
        int e;
        s58 b2;
        List<RecommendBarCardModel> c2;
        int j;
        v58 v58Var;
        boolean z2;
        ro6 e2;
        zo6 h;
        ThreadRecommendInfoData threadRecommendInfoData;
        zo6 h2;
        r08 g;
        zo6 h3;
        zo6 h4;
        zo6 h5;
        int e3;
        RecommendBarCardModel recommendBarCardModel;
        int i5;
        p08 p08Var;
        int d;
        HeaderCard headerCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{list, list2, userFollowLive, Integer.valueOf(i), Integer.valueOf(i2), builder, Integer.valueOf(i3)})) == null) {
            if (list == null) {
                return null;
            }
            if (builder != null && !ListUtils.isEmpty(builder.thread_list) && builder.active_center != null) {
                ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
                if (threadInfo.id.longValue() > 0 && xt4.f().l()) {
                    this.j = threadInfo.id;
                }
            }
            List<bn> arrayList = new ArrayList<>(ListUtils.getCount(list));
            Iterator<ThreadInfo> it = list.iterator();
            while (true) {
                c = 0;
                if (!it.hasNext()) {
                    break;
                }
                ThreadData threadData = new ThreadData();
                AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                threadData.isFromHomPage = true;
                threadData.parserProtobuf(it.next());
                arrayList.add(threadData);
            }
            dva dvaVar = new dva();
            if (builder != null && (headerCard = builder.header_card) != null) {
                dvaVar.f(headerCard);
            }
            if (i2 == 0 && gva.i(dvaVar, false)) {
                gva gvaVar = new gva();
                gvaVar.g(1);
                gvaVar.d(dvaVar);
                if (ListUtils.add(arrayList, gvaVar.getPosition(), gvaVar)) {
                    int position = gvaVar.getPosition();
                    gvaVar.position = position;
                    i4 = position;
                    if (i2 == 0 && p08.l(builder)) {
                        p08Var = new p08();
                        p08Var.i(builder.hot_card);
                        d = p08Var.d() - 1;
                        if (d >= 0 && ListUtils.add(arrayList, d, p08Var)) {
                            p08Var.position = d;
                        }
                    }
                    if (builder != null && RecommendBarCardModel.t(builder.hot_recomforum, -1)) {
                        recommendBarCardModel = new RecommendBarCardModel();
                        if (builder.hot_recomforum.floor.intValue() <= 0) {
                            i5 = builder.hot_recomforum.floor.intValue() - 1;
                        } else {
                            i5 = 0;
                        }
                        recommendBarCardModel.floorPosition = i5;
                        if (recommendBarCardModel.m(builder.hot_recomforum.tab_list)) {
                            p(recommendBarCardModel, recommendBarCardModel.floorPosition, arrayList);
                        }
                    }
                    if (i2 == 0 && UbsABTestHelper.isPersonalizeFunAdABTest() && G(builder)) {
                        int f = ac5.f();
                        e3 = ac5.e();
                        if (i == 0) {
                            e3 = ac5.a();
                            this.k.clear();
                        }
                        if (i4 >= 0 && e3 > i4) {
                            e3++;
                        }
                        q(e3, f, arrayList);
                    }
                    List<bn> linkedList = new LinkedList<>();
                    int i6 = 0;
                    for (bn bnVar : arrayList) {
                        boolean z3 = bnVar instanceof ThreadData;
                        if (z3 && ((ThreadData) bnVar).isFunAdPlaceHolder()) {
                            if (G(builder)) {
                                linkedList.add(bnVar);
                                i6++;
                            }
                            c = 0;
                        } else if (z3) {
                            ThreadData threadData2 = (ThreadData) bnVar;
                            if (!TextUtils.isEmpty(threadData2.getLegoCard())) {
                                p25 p25Var = new p25();
                                p25Var.e(threadData2.getLegoCard());
                                p25Var.position = i6;
                                linkedList.add(p25Var);
                            } else if (h98.G(threadData2)) {
                                if (!StringUtils.isNull(threadData2.getTopicModule().topic_name)) {
                                    h98 h98Var = new h98();
                                    h98Var.I(threadData2.getTopicModule());
                                    h98Var.Z = 1;
                                    h98Var.position = i6;
                                    h98Var.K(threadData2);
                                    h98Var.setSupportType(BaseCardInfo.SupportType.FULL);
                                    linkedList.add(h98Var);
                                }
                            } else if (!zo6.R(threadData2) && !ap6.L(threadData2) && !bp6.R(threadData2)) {
                                if (uo6.R(threadData2) && threadData2.isBJHArticleThreadType()) {
                                    uo6 uo6Var = new uo6(threadData2);
                                    uo6Var.position = i6;
                                    linkedList.add(uo6Var);
                                } else {
                                    ro6 e4 = g68.e(threadData2);
                                    if (e4 != null) {
                                        e4.g = threadData2.getTid();
                                        e4.position = i6;
                                    }
                                    if (e4 != null && e4.isValid()) {
                                        linkedList.add(e4);
                                    }
                                }
                            } else {
                                zo6 h6 = g68.h(threadData2);
                                if (h6 != null) {
                                    if (threadData2.showCardEnterFourm()) {
                                        if (h6.isValid()) {
                                            h6.g = threadData2.getTid();
                                            h6.position = i6;
                                            g68.u(h6);
                                            linkedList.add(h6);
                                        }
                                    } else {
                                        ThreadData threadData3 = h6.a;
                                        if (threadData3 != null && threadData3.getForumData() != null && !StringUtils.isNull(threadData3.getForumData().b)) {
                                            h6.g = threadData2.getTid();
                                            h6.position = i6;
                                            g68.s(h6);
                                            linkedList.add(h6);
                                            z2 = true;
                                            e2 = g68.e(threadData2);
                                            if (e2 != null) {
                                                e2.g = threadData2.getTid();
                                                e2.position = i6;
                                                if (e2 instanceof zo6) {
                                                    if (threadData2.isBJHNormalThreadType()) {
                                                        g68.v(e2);
                                                    } else if (threadData2.picCount() == 1) {
                                                        g68.x(e2);
                                                        int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                                                        e2.j = imageWidthAndHeight[c];
                                                        e2.k = imageWidthAndHeight[1];
                                                    } else if (threadData2.picCount() >= 2) {
                                                        g68.w(e2);
                                                    } else {
                                                        g68.y(e2);
                                                    }
                                                } else if (e2 instanceof ap6) {
                                                    g68.z(e2);
                                                }
                                            }
                                            if (e2 instanceof bp6) {
                                                g68.A(e2);
                                            }
                                            if (e2 != null && e2.isValid()) {
                                                e2.a.insertItemToTitleOrAbstractText();
                                                if (!threadData2.isUgcThreadType() && threadData2.getAuthor() != null && z2) {
                                                    String string = TbadkCoreApplication.getInst().getString(R.string.at_username);
                                                    Object[] objArr = new Object[1];
                                                    objArr[c] = threadData2.getAuthor().getName_show();
                                                    String format = String.format(string, objArr);
                                                    SpannableString spannableString = new SpannableString(format);
                                                    spannableString.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), e2), 0, format.length() - 1, 33);
                                                    e2.a.insertUsernameIntoTitleOrAbstract(spannableString);
                                                }
                                                linkedList.add(e2);
                                            }
                                            if (threadData2.getItem() != null && (h5 = g68.h(threadData2)) != null) {
                                                h5.g = threadData2.getTid();
                                                h5.position = i6;
                                                g68.B(h5);
                                                if (!zo6.R(threadData2)) {
                                                    h5.E("1");
                                                } else if (ap6.L(threadData2)) {
                                                    h5.E("2");
                                                }
                                                linkedList.add(h5);
                                            }
                                            if ((ListUtils.isEmpty(threadData2.getLinkDataList()) || !ListUtils.isEmpty(threadData2.getGoodsDataList())) && (h = g68.h(threadData2)) != null) {
                                                h.g = threadData2.getTid();
                                                h.position = i6;
                                                if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) != 1) {
                                                    g68.E(h);
                                                } else {
                                                    g68.C(h);
                                                }
                                                linkedList.add(h);
                                            }
                                            threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                            if (threadRecommendInfoData != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason) && (h4 = g68.h(threadData2)) != null) {
                                                h4.g = threadData2.getTid();
                                                h4.position = i6;
                                                g68.D(h4);
                                                if (h4.isValid()) {
                                                    linkedList.add(h4);
                                                }
                                            }
                                            if (threadData2.showCardEnterFourm() && (h3 = g68.h(threadData2)) != null) {
                                                h3.g = threadData2.getTid();
                                                h3.position = i6;
                                                g68.r(h3);
                                                if (!zo6.R(threadData2)) {
                                                    h3.E("1");
                                                } else if (ap6.L(threadData2)) {
                                                    h3.E("2");
                                                }
                                                if (!threadData2.showCardEnterFourm() && !StringUtils.isNull(threadData2.getForum_name())) {
                                                    linkedList.add(h3);
                                                } else if (!StringUtils.isNull(threadData2.getForum_name())) {
                                                    linkedList.add(h3);
                                                }
                                            }
                                            if (threadData2.getTopAgreePost() != null) {
                                                zo6 h7 = g68.h(threadData2);
                                                if (h7 != null) {
                                                    h7.g = threadData2.getTid();
                                                    h7.position = i6;
                                                    g68.t(h7);
                                                }
                                                if (h7 != null && h7.isValid()) {
                                                    linkedList.add(h7);
                                                }
                                            }
                                            h2 = g68.h(threadData2);
                                            if (h2 != null) {
                                                h2.g = threadData2.getTid();
                                                h2.position = i6;
                                                g68.q(h2);
                                            }
                                            if (h2 != null && h2.isValid()) {
                                                linkedList.add(h2);
                                            }
                                            g = g68.g(threadData2);
                                            if (g != null && r08.X(g) && x(this.a.a, g) && !x(linkedList, g)) {
                                                g.g = threadData2.getTid();
                                                linkedList.add(g);
                                            }
                                        } else if (h6.isValid()) {
                                            h6.g = threadData2.getTid();
                                            h6.position = i6;
                                            g68.u(h6);
                                            linkedList.add(h6);
                                        }
                                    }
                                }
                                z2 = false;
                                e2 = g68.e(threadData2);
                                if (e2 != null) {
                                }
                                if (e2 instanceof bp6) {
                                }
                                if (e2 != null) {
                                    e2.a.insertItemToTitleOrAbstractText();
                                    if (!threadData2.isUgcThreadType()) {
                                        String string2 = TbadkCoreApplication.getInst().getString(R.string.at_username);
                                        Object[] objArr2 = new Object[1];
                                        objArr2[c] = threadData2.getAuthor().getName_show();
                                        String format2 = String.format(string2, objArr2);
                                        SpannableString spannableString2 = new SpannableString(format2);
                                        spannableString2.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), e2), 0, format2.length() - 1, 33);
                                        e2.a.insertUsernameIntoTitleOrAbstract(spannableString2);
                                    }
                                    linkedList.add(e2);
                                }
                                if (threadData2.getItem() != null) {
                                    h5.g = threadData2.getTid();
                                    h5.position = i6;
                                    g68.B(h5);
                                    if (!zo6.R(threadData2)) {
                                    }
                                    linkedList.add(h5);
                                }
                                if (ListUtils.isEmpty(threadData2.getLinkDataList())) {
                                }
                                h.g = threadData2.getTid();
                                h.position = i6;
                                if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) != 1) {
                                }
                                linkedList.add(h);
                                threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                if (threadRecommendInfoData != null) {
                                    h4.g = threadData2.getTid();
                                    h4.position = i6;
                                    g68.D(h4);
                                    if (h4.isValid()) {
                                    }
                                }
                                if (threadData2.showCardEnterFourm()) {
                                    h3.g = threadData2.getTid();
                                    h3.position = i6;
                                    g68.r(h3);
                                    if (!zo6.R(threadData2)) {
                                    }
                                    if (!threadData2.showCardEnterFourm()) {
                                    }
                                    if (!StringUtils.isNull(threadData2.getForum_name())) {
                                    }
                                }
                                if (threadData2.getTopAgreePost() != null) {
                                }
                                h2 = g68.h(threadData2);
                                if (h2 != null) {
                                }
                                if (h2 != null) {
                                    linkedList.add(h2);
                                }
                                g = g68.g(threadData2);
                                if (g != null) {
                                    g.g = threadData2.getTid();
                                    linkedList.add(g);
                                }
                            }
                            long j2 = JavaTypesHelper.toLong(threadData2.getId(), 0L);
                            if (j2 != 0 && j2 == this.j.longValue()) {
                                if (builder.active_center != null) {
                                    v58Var = new v58();
                                    v58Var.G(builder.active_center);
                                } else {
                                    v58Var = null;
                                }
                                if (v58Var == null) {
                                    v58Var = d();
                                }
                                if (v58Var != null) {
                                    i6++;
                                    v58Var.R = i6;
                                    linkedList.add(v58Var);
                                }
                            }
                            i6++;
                            c = 0;
                        } else {
                            if (bnVar instanceof BaseCardInfo) {
                                linkedList.add(bnVar);
                            } else {
                                linkedList.add(bnVar);
                            }
                            i6++;
                            c = 0;
                        }
                    }
                    if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                        int i7 = 0;
                        int i8 = 0;
                        for (int i9 = 0; i9 < ListUtils.getCount(list2); i9++) {
                            fp6 fp6Var = (fp6) ListUtils.getItem(list2, i9);
                            if (fp6Var != null && i7 < linkedList.size()) {
                                int i10 = i7;
                                while (i10 < linkedList.size() && (!(linkedList.get(i10) instanceof ro6) || h(((ro6) linkedList.get(i10)).position, i4) + i8 != fp6Var.getPosition() - 1)) {
                                    i10++;
                                }
                                if (linkedList.size() > i10 && i10 > 0) {
                                    linkedList.add(i10, fp6Var);
                                    int i11 = i8 + 1;
                                    m(fp6Var, linkedList, i10, i11, i3);
                                    i7 = i10;
                                    i8 = i11;
                                } else {
                                    i7 = i10;
                                }
                            }
                        }
                        int i12 = 0;
                        int i13 = 0;
                        for (bn bnVar2 : linkedList) {
                            if (bnVar2 instanceof o25) {
                                ((o25) bnVar2).setPosition(i12 + 1);
                                i13++;
                            } else if (bnVar2 instanceof BaseCardInfo) {
                                BaseCardInfo baseCardInfo = (BaseCardInfo) bnVar2;
                                i12 = baseCardInfo.position + i13;
                                baseCardInfo.position = i12;
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
                            s58 s58Var = new s58();
                            s58Var.d(userFollowLive);
                            linkedList.add(0, s58Var);
                            s58Var.position = -1;
                        } else if (i == 1 && (b2 = b()) != null) {
                            linkedList.add(0, b2);
                            b2.position = -1;
                        } else {
                            z = false;
                            if (z) {
                                DefaultLog.getInstance().i("RecentForumLog", "首页接口返回，设置有直播数据标志位");
                                this.l.a1(true);
                            }
                        }
                        z = true;
                        if (z) {
                        }
                    } else {
                        z = false;
                    }
                    if (i2 == 0 && !z) {
                        if (i != 0 && this.l.l0() > 0) {
                            DefaultLog.getInstance().i("RecentForumLog", "推荐接口返回, 且没有插入直播数据");
                            if (this.l.g0() != null) {
                                DefaultLog.getInstance().i("RecentForumLog", "推荐接口返回, 插入最近逛的吧模快");
                                linkedList.add(0, this.l.g0());
                            }
                        } else {
                            e = e(this.a.a);
                            if (e != -1) {
                                linkedList.add(0, (u58) this.a.a.get(e));
                            }
                        }
                    }
                    if (i2 == 0 && i == 0) {
                        c48 c48Var = this.l;
                        c48Var.e1(c48Var.l0() + 1);
                        TbLog defaultLog = DefaultLog.getInstance();
                        defaultLog.i("RecentForumLog", "推荐接口返回, 等待值：" + this.l.l0());
                    }
                    AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                    return linkedList;
                }
            }
            i4 = -1;
            if (i2 == 0) {
                p08Var = new p08();
                p08Var.i(builder.hot_card);
                d = p08Var.d() - 1;
                if (d >= 0) {
                    p08Var.position = d;
                }
            }
            if (builder != null) {
                recommendBarCardModel = new RecommendBarCardModel();
                if (builder.hot_recomforum.floor.intValue() <= 0) {
                }
                recommendBarCardModel.floorPosition = i5;
                if (recommendBarCardModel.m(builder.hot_recomforum.tab_list)) {
                }
            }
            if (i2 == 0) {
                int f3 = ac5.f();
                e3 = ac5.e();
                if (i == 0) {
                }
                if (i4 >= 0) {
                    e3++;
                }
                q(e3, f3, arrayList);
            }
            List<bn> linkedList2 = new LinkedList<>();
            int i62 = 0;
            while (r4.hasNext()) {
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
                c48 c48Var2 = this.l;
                c48Var2.e1(c48Var2.l0() + 1);
                TbLog defaultLog2 = DefaultLog.getInstance();
                defaultLog2.i("RecentForumLog", "推荐接口返回, 等待值：" + this.l.l0());
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList2);
            return linkedList2;
        }
        return (List) invokeCommon.objValue;
    }

    public void p(w05 w05Var, int i, List<bn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048600, this, w05Var, i, list) != null) || w05Var == null || list == null || i <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    w05Var.floorPosition = i;
                    ListUtils.add(list, i3, w05Var);
                    return;
                }
                i2++;
            }
        }
    }

    public final void q(int i, int i2, List<bn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048601, this, i, i2, list) == null) && !ListUtils.isEmpty(list) && i >= 0 && i2 >= 1) {
            ListIterator<bn> listIterator = list.listIterator();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (listIterator.hasNext()) {
                if (i4 == i || (i4 > i && (i4 - i) % i2 == 0)) {
                    if (i5 < this.k.size()) {
                        listIterator.add(this.k.get(i5));
                    } else {
                        ThreadData threadData = new ThreadData();
                        xfa xfaVar = new xfa();
                        xfaVar.n(true);
                        threadData.funAdData = xfaVar;
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
            if (i3 > 0 && u56.i().p(AbsDataRecorder.Scene.RECOMMEND)) {
                u56.i().n(list, i3, 1);
            }
        }
    }

    public void u(List<bn> list, k6a k6aVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048605, this, list, k6aVar, i) != null) || ListUtils.isEmpty(list) || k6aVar == null || i < 0) {
            return;
        }
        F(list);
        if (i == 0) {
            t(list, RecommendBarCardModel.e(k6aVar), k6aVar.a);
            return;
        }
        while (i < list.size() && !(list.get(i) instanceof ro6) && !(list.get(i) instanceof o25)) {
            i++;
        }
        if (list.get(i) instanceof ro6) {
            t(list, RecommendBarCardModel.e(k6aVar), ((ro6) list.get(i)).position + 2);
        } else if (list.get(i) instanceof o25) {
            t(list, RecommendBarCardModel.e(k6aVar), ((o25) list.get(i)).p() + 2);
        }
    }

    public boolean r(List<bn> list, t58 t58Var, int i, int i2) {
        InterceptResult invokeLLII;
        RecommendBarCardModel d;
        int j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048602, this, list, t58Var, i, i2)) == null) {
            if (ListUtils.isEmpty(list) || t58Var == null || TextUtils.isEmpty(t58Var.b()) || i < 0 || i >= list.size() || i2 < 0 || i2 < i || i2 >= list.size() || (d = RecommendBarCardModel.d(t58Var)) == null || (j = j(k(t58Var.b(), list), list, t58Var.b())) < 0 || j > list.size() || j <= i) {
                return false;
            }
            d.n(t58Var.b());
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
    public final void t(List<bn> list, RecommendBarCardModel recommendBarCardModel, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048604, this, list, recommendBarCardModel, i) == null) && recommendBarCardModel != null && !ListUtils.isEmpty(recommendBarCardModel.h())) {
            int i2 = 0;
            if (list.size() > 0) {
                int i3 = 0;
                while (i3 < list.size() && ((!(list.get(i3) instanceof ro6) || ((ro6) list.get(i3)).position + 1 != i) && (!(list.get(i3) instanceof o25) || ((o25) list.get(i3)).p() + 1 != i))) {
                    i3++;
                }
            }
            int i4 = 0;
            for (bn bnVar : list) {
                if (bnVar instanceof RecommendBarCardModel) {
                    RecommendBarCardModel recommendBarCardModel2 = (RecommendBarCardModel) bnVar;
                    if (!recommendBarCardModel2.i()) {
                        recommendBarCardModel2.position = i4 + 1;
                        i2++;
                    }
                }
                if (bnVar instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) bnVar;
                    i4 = baseCardInfo.position + i2;
                    baseCardInfo.position = i4;
                }
            }
        }
    }

    public final boolean x(List<bn> list, r08 r08Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, list, r08Var)) == null) {
            if (this.a != null && !ListUtils.isEmpty(list)) {
                for (bn bnVar : list) {
                    if ((bnVar instanceof r08) && ((r08) bnVar).getTid().equals(r08Var.getTid())) {
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
            g68.l(z, builder, builder2, i, this.c, this.f, this.g);
        }
    }
}
