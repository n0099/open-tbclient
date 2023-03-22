package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.me;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.App;
import tbclient.BannerList;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumInfo;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class ha9 {
    public static /* synthetic */ Interceptable $ic;
    public static final Wire c;
    public static ha9 d;
    public transient /* synthetic */ FieldHolder $fh;
    public qa9 a;
    public me<byte[]> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947817129, "Lcom/baidu/tieba/ha9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947817129, "Lcom/baidu/tieba/ha9;");
                return;
            }
        }
        c = new Wire(new Class[0]);
    }

    public static ha9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (ha9.class) {
                    if (d == null) {
                        d = new ha9();
                    }
                }
            }
            return d;
        }
        return (ha9) invokeV.objValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            long o = m35.m().o("key_frs_cache_time", 604800000L);
            if (o < 0) {
                return 604800000L;
            }
            return o;
        }
        return invokeV.longValue;
    }

    public qa9 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return (qa9) invokeV.objValue;
    }

    public ha9() {
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
        this.a = null;
        this.b = null;
        this.b = BdCacheService.n().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public void a(String str, byte[] bArr, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048576, this, str, bArr, z) == null) && str != null && str.length() > 0) {
            if (z) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                me<byte[]> meVar = this.b;
                meVar.e(currentAccount + str, bArr, h());
                return;
            }
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            me<byte[]> meVar2 = this.b;
            meVar2.i(currentAccount2 + str, bArr, h());
        }
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && this.b != null && str != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            me<byte[]> meVar = this.b;
            byte[] bArr = meVar.get(currentAccount + str);
            if (bArr != null && bArr.length > 0) {
                try {
                    FrsPageResIdl frsPageResIdl = (FrsPageResIdl) c.parseFrom(bArr, FrsPageResIdl.class);
                    if (frsPageResIdl != null && frsPageResIdl.data != null && frsPageResIdl.data.forum != null && frsPageResIdl.data.forum.banner_list != null && frsPageResIdl.data.forum.banner_list.app != null && frsPageResIdl.data.forum.banner_list.app.size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (App app : frsPageResIdl.data.forum.banner_list.app) {
                            boolean isNull = StringUtils.isNull(str2);
                            if (app != null && (isNull || str2.equals(k09.a(app)))) {
                                arrayList.add(app);
                            }
                        }
                        BannerList.Builder builder = new BannerList.Builder(frsPageResIdl.data.forum.banner_list);
                        if (builder.app != null) {
                            builder.app.removeAll(arrayList);
                        }
                        FrsPageResIdl.Builder builder2 = new FrsPageResIdl.Builder(frsPageResIdl);
                        DataRes.Builder builder3 = new DataRes.Builder(frsPageResIdl.data);
                        ForumInfo.Builder builder4 = new ForumInfo.Builder(frsPageResIdl.data.forum);
                        builder4.banner_list = builder.build(true);
                        builder3.forum = builder4.build(true);
                        builder2.data = builder3.build(true);
                        a(str, builder2.build(true).toByteArray(), true);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void m(String str, byte[] bArr) {
        List<ThreadInfo> list;
        int count;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, str, bArr) == null) && this.b != null && str != null && bArr != null && bArr.length > 0) {
            try {
                FrsPageResIdl frsPageResIdl = (FrsPageResIdl) c.parseFrom(bArr, FrsPageResIdl.class);
                if (frsPageResIdl == null || frsPageResIdl.data == null || (count = ListUtils.getCount((list = frsPageResIdl.data.thread_list))) <= 0) {
                    return;
                }
                if (count >= 15) {
                    a(str, bArr, true);
                    return;
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                me<byte[]> meVar = this.b;
                byte[] bArr2 = meVar.get(currentAccount + str);
                if (bArr2 == null) {
                    a(str, bArr, true);
                    return;
                }
                FrsPageResIdl frsPageResIdl2 = (FrsPageResIdl) c.parseFrom(bArr2, FrsPageResIdl.class);
                if (frsPageResIdl2 != null && frsPageResIdl2.data != null && frsPageResIdl2.data.thread_list != null) {
                    List<ThreadInfo> list2 = frsPageResIdl2.data.thread_list;
                    int count2 = ListUtils.getCount(list2);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int i = 0;
                    for (int i2 = 15; i < count2 && count < i2; i2 = 15) {
                        ThreadInfo threadInfo = (ThreadInfo) ListUtils.getItem(list2, i);
                        if (threadInfo != null && threadInfo.tid != null && threadInfo.is_top.intValue() == 0 && !k(threadInfo.tid.longValue(), list)) {
                            arrayList.add(threadInfo);
                            User f = f(frsPageResIdl2.data.user_list, threadInfo.author_id.longValue());
                            if (f != null) {
                                arrayList2.add(f);
                            }
                            count++;
                        }
                        i++;
                    }
                    FrsPageResIdl.Builder builder = new FrsPageResIdl.Builder(frsPageResIdl);
                    DataRes.Builder builder2 = new DataRes.Builder(frsPageResIdl.data);
                    builder2.thread_list.addAll(arrayList);
                    builder2.user_list.addAll(arrayList2);
                    builder.data = builder2.build(true);
                    a(str, builder.build(true).toByteArray(), true);
                    return;
                }
                a(str, bArr, true);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.b != null && str != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            me<byte[]> meVar = this.b;
            byte[] bArr = meVar.get(currentAccount + str);
            if (bArr != null && bArr.length > 0) {
                try {
                    FrsPageResIdl frsPageResIdl = (FrsPageResIdl) c.parseFrom(bArr, FrsPageResIdl.class);
                    if (frsPageResIdl != null && frsPageResIdl.data != null && frsPageResIdl.data.ala_stage_list != null) {
                        DataRes.Builder builder = new DataRes.Builder(frsPageResIdl.data);
                        if (builder.ala_stage_list != null) {
                            builder.ala_stage_list.clear();
                        }
                        FrsPageResIdl.Builder builder2 = new FrsPageResIdl.Builder(frsPageResIdl);
                        builder2.data = builder.build(true);
                        a(str, builder2.build(true).toByteArray(), true);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) && this.b != null && str != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            me<byte[]> meVar = this.b;
            byte[] bArr = meVar.get(currentAccount + str);
            if (bArr != null && bArr.length > 0) {
                try {
                    FrsPageResIdl frsPageResIdl = (FrsPageResIdl) c.parseFrom(bArr, FrsPageResIdl.class);
                    if (frsPageResIdl != null && frsPageResIdl.data != null && frsPageResIdl.data.thread_list != null) {
                        ArrayList arrayList = new ArrayList();
                        for (ThreadInfo threadInfo : frsPageResIdl.data.thread_list) {
                            if (threadInfo != null && threadInfo.tid != null && str2 != null && str2.equals(threadInfo.tid.toString())) {
                                arrayList.add(threadInfo);
                            }
                        }
                        DataRes.Builder builder = new DataRes.Builder(frsPageResIdl.data);
                        if (builder.thread_list != null) {
                            builder.thread_list.removeAll(arrayList);
                        }
                        FrsPageResIdl.Builder builder2 = new FrsPageResIdl.Builder(frsPageResIdl);
                        builder2.data = builder.build(true);
                        a(str, builder2.build(true).toByteArray(), true);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (this.b != null && str != null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                me<byte[]> meVar = this.b;
                byte[] bArr = meVar.get(currentAccount + str);
                if (bArr != null && bArr.length > 0) {
                    qa9 qa9Var = new qa9();
                    this.a = qa9Var;
                    qa9Var.isFromCache = true;
                    qa9Var.parserProtobuf(bArr, false);
                    ForumData forumData = this.a.forum;
                    if (forumData != null && forumData.getFrsBannerData() != null) {
                        this.a.forum.getFrsBannerData().i = false;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final User f(List<User> list, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, list, j)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            for (User user : list) {
                if (user != null && user.id.longValue() == j) {
                    return user;
                }
            }
            return null;
        }
        return (User) invokeLJ.objValue;
    }

    public final boolean k(long j, List<ThreadInfo> list) {
        InterceptResult invokeJL;
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048585, this, j, list)) == null) {
            int count = ListUtils.getCount(list);
            for (int i = 0; i < count; i++) {
                ThreadInfo threadInfo = (ThreadInfo) ListUtils.getItem(list, i);
                if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == j) {
                    return true;
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }

    public String g(String str, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048582, this, str, i, i2, i3)) == null) {
            String str2 = str + i + i2;
            if (i3 != 0) {
                return str + i + i2 + FrsRequestData.CATEGORY_ID_KEY + i3;
            }
            return str2;
        }
        return (String) invokeLIII.objValue;
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        me.b<byte[]> h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (str != null && str.length() > 0 && (h = this.b.h(str)) != null) {
                return UtilHelper.isSameDay(h.c, System.currentTimeMillis());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void n(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) && str != null && str.length() > 0) {
            if (z) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                me<byte[]> meVar = this.b;
                meVar.remove(currentAccount + str);
                return;
            }
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            me<byte[]> meVar2 = this.b;
            meVar2.d(currentAccount2 + str);
        }
    }
}
