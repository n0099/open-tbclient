package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class b05 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public static b05 a;
    public static ConcurrentHashMap<String, Integer> b;
    public static ArrayList<String> c;
    public static ConcurrentHashMap<String, me<byte[]>> d;
    public static ConcurrentHashMap<String, me<String>> e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947591170, "Lcom/baidu/tieba/b05;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947591170, "Lcom/baidu/tieba/b05;");
                return;
            }
        }
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        b = concurrentHashMap;
        concurrentHashMap.put("tb.pb_mark", 50);
        b.put("tb.pb_history", 300);
        b.put("tb.pb_normal", 1);
        b.put("tb.pb_editor", 50);
        b.put("tb.live_hotlist", 20);
        b.put("tb.live_hotlist", 20);
        b.put("tb.my_pages", 5);
        b.put("tb.my_forums", 3);
        b.put("tb.my_bookmarks", 3);
        b.put("tb.my_posts", 3);
        b.put("tb.eva_posts", 50);
        b.put("tb.im_frsgroup", 50);
        b.put("tb.im_hotgroup", 30);
        b.put("tb.im_groupinfo", 50);
        b.put("tb.im_groupactivity", 50);
        b.put("tb.im_entergroup", 10);
        b.put("tb.im_enterforum_groupinfo", 10);
        b.put("tb.im_group_setting", 3);
        b.put("tb.im_personal_chat_setting", 3);
        b.put("tb.im_official_chat_setting", 3);
        b.put("tb.im_official_history", 50);
        b.put("tb.im_recommend_detail", 10);
        b.put("tb.square", 1);
        b.put("tb.first_dir", 1);
        b.put("tb.forum_rank", 20);
        b.put("tb.pic_gif", 50);
        b.put("tb.official_bar_menu", 1000);
        b.put("tb.friend_feed", 20);
        b.put("net_err_record", 30);
        b.put("tb_face_package", 30);
        b.put("tb.recommend_friend", 10);
        b.put("tb.searchperson_history", 5);
        b.put("tb.game_center_home", 20);
        b.put("tb.game_center_list", 20);
        b.put("tb.person_wallet_new", 10);
        b.put("tb.frs_hottopic", 100);
        ArrayList<String> arrayList = new ArrayList<>();
        c = arrayList;
        arrayList.add("tb.dialog_strategies_data");
        c.add("tb.ala.gift_list");
        c.add("tb.square");
        c.add("tb.first_dir");
        c.add("tb.forum_rank");
        c.add("tb.im_group_setting");
        c.add("tb.im_personal_chat_setting");
        c.add("tb.im_official_chat_setting");
        c.add("net_err_record");
        c.add("tb_user_profile");
        c.add("tb_forum_recommend");
        c.add("tb.ad_killer_tags");
        c.add("tb.manga.settings");
        c.add("tb.share_add_experienced");
        c.add("tb.write_privacy_state_space");
        c.add("tb.concern_page_all");
        c.add("tb.im_group_chat_http");
        e = new ConcurrentHashMap<>();
        d = new ConcurrentHashMap<>();
        qb.b().a("cmd2001012", new a());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b05() {
        super(2000998);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public static synchronized void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            synchronized (b05.class) {
                if (str == null) {
                    return;
                }
                if (str2 != null) {
                    str = str + str2;
                }
                me<byte[]> meVar = d.get(str);
                if (meVar != null) {
                    BdCacheService.n().k(meVar, true);
                    d.remove(str);
                }
            }
        }
    }

    public static synchronized me<byte[]> b(String str) {
        InterceptResult invokeL;
        me<byte[]> c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            synchronized (b05.class) {
                c2 = c(str, null);
            }
            return c2;
        }
        return (me) invokeL.objValue;
    }

    public static synchronized me<String> e(String str) {
        InterceptResult invokeL;
        me<String> f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            synchronized (b05.class) {
                f = f(str, null);
            }
            return f;
        }
        return (me) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
            synchronized (b05.class) {
                d.clear();
                e.clear();
            }
        }
    }

    public static synchronized me<byte[]> c(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            synchronized (b05.class) {
                if (str == null) {
                    return null;
                }
                if (str2 != null) {
                    str3 = str + str2;
                } else {
                    str3 = str;
                }
                me<byte[]> meVar = d.get(str3);
                if (meVar != null && (meVar instanceof me)) {
                    return meVar;
                }
                BdCacheService n = BdCacheService.n();
                Integer num = b.get(str);
                num = (num == null || num.intValue() == 0) ? 20 : 20;
                BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
                if (c.contains(str)) {
                    cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
                }
                try {
                    meVar = n.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
                d.put(str3, meVar);
                return meVar;
            }
        }
        return (me) invokeLL.objValue;
    }

    public static synchronized me<String> f(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            synchronized (b05.class) {
                if (str == null) {
                    return null;
                }
                if (str2 != null) {
                    str3 = str + str2;
                } else {
                    str3 = str;
                }
                me<String> meVar = e.get(str3);
                BdCacheService n = BdCacheService.n();
                Integer num = b.get(str);
                num = (num == null || num.intValue() == 0) ? 20 : 20;
                BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
                if (c.contains(str)) {
                    cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
                }
                try {
                    meVar = n.d(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
                return meVar;
            }
        }
        return (me) invokeLL.objValue;
    }

    @Deprecated
    public static synchronized b05 d() {
        InterceptResult invokeV;
        b05 b05Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            synchronized (b05.class) {
                if (a == null) {
                    a = new b05();
                }
                b05Var = a;
            }
            return b05Var;
        }
        return (b05) invokeV.objValue;
    }

    public static synchronized me<String> g(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, str, str2, str3)) == null) {
            synchronized (b05.class) {
                if (str != null && str3 != null) {
                    if (str2 != null) {
                        str4 = str + str2;
                    } else {
                        str4 = str;
                    }
                    me<String> meVar = e.get(str4);
                    BdCacheService j = BdCacheService.j(str3);
                    Integer num = b.get(str);
                    num = (num == null || num.intValue() == 0) ? 20 : 20;
                    BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
                    if (c.contains(str)) {
                        cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
                    }
                    try {
                        meVar = j.d(str4, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
                    } catch (Exception e2) {
                        BdLog.detailException(e2);
                    }
                    return meVar;
                }
                return null;
            }
        }
        return (me) invokeLLL.objValue;
    }
}
