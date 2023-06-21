package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.hottopic.data.PostForumData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.Hottopic.PkModule;
import tbclient.Hottopic.RelateForum;
import tbclient.Hottopic.SpecialTopic;
import tbclient.RecomTopicList;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<wn> a;
    public b68 b;
    public h68 c;
    public z35 d;
    public PostForumData e;
    public e68 f;
    public w58 g;
    public w58 h;
    public w58 i;
    public c68 j;
    public z58 k;
    public c68 l;
    public List<to6> m;
    public List<wn> n;
    public l35 o;
    public int p;
    public RecomTopicList q;

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
        this.a = null;
        this.b = null;
        this.c = null;
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
        this.a = new ArrayList<>();
    }

    public w58 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (w58) invokeV.objValue;
    }

    public w58 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (w58) invokeV.objValue;
    }

    public z35 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (z35) invokeV.objValue;
    }

    public e68 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (e68) invokeV.objValue;
    }

    public b68 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (b68) invokeV.objValue;
    }

    public List<wn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public w58 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (w58) invokeV.objValue;
    }

    public void h(DataRes dataRes) {
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, dataRes) != null) || dataRes == null) {
            return;
        }
        dataRes.is_new_url.intValue();
        if (dataRes.topic_info != null) {
            b68 b68Var = new b68();
            this.b = b68Var;
            b68Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            c68 c68Var = new c68();
            this.l = c68Var;
            c68Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                to6 to6Var = null;
                if (threadData.isShareThread) {
                    to6Var = new bp6();
                    to6Var.a = threadData;
                } else if (cp6.P(threadData)) {
                    to6Var = new cp6(threadData);
                    to6Var.s = true;
                } else if (bp6.X(threadData)) {
                    to6Var = new bp6();
                    to6Var.a = threadData;
                }
                if (to6Var != null && to6Var.isValid()) {
                    to6Var.F("c10814");
                    this.m.add(to6Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            h68 h68Var = new h68();
            this.c = h68Var;
            h68Var.parserProtobuf(dataRes.relate_forum);
            z35 z35Var = new z35();
            this.d = z35Var;
            z35Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09f5);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            z35 z35Var2 = this.d;
            z35Var2.e = R.color.CAM_X0108;
            ArrayList<y35> e = z35Var2.e();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    y35 y35Var = new y35();
                    y35Var.w(relateForum.forum_id.intValue());
                    y35Var.x(relateForum.forum_name);
                    y35Var.u(relateForum.avatar);
                    y35Var.q(relateForum.desc);
                    y35Var.s(relateForum.thread_num.intValue());
                    y35Var.o(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    y35Var.n(z3);
                    e.add(y35Var);
                }
            }
        }
        List<RelateForum> list2 = dataRes.post_forum;
        if (list2 != null && list2.size() != 0) {
            PostForumData postForumData = new PostForumData();
            this.e = postForumData;
            postForumData.parserProtobuf(dataRes.post_forum);
        }
        PkModule pkModule = dataRes.pk_module;
        if (pkModule != null && !StringUtils.isNull(pkModule.ques_desc)) {
            e68 e68Var = new e68();
            this.f = e68Var;
            e68Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            w58 w58Var = new w58();
            this.g = w58Var;
            w58Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            w58 w58Var2 = new w58();
            this.h = w58Var2;
            w58Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            w58 w58Var3 = new w58();
            this.i = w58Var3;
            w58Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            c68 c68Var2 = new c68();
            this.j = c68Var2;
            c68Var2.a(dataRes.hot_thread);
            z58 z58Var = new z58();
            this.k = z58Var;
            z58Var.k(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                l35 l35Var = new l35();
                this.o = l35Var;
                l35Var.j(dataRes.hot_thread.page);
                this.o.b();
            }
            dataRes.is_global_block.intValue();
        }
        this.q = dataRes.next_topic;
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.n = new ArrayList();
            if (this.f != null) {
                z = true;
            } else {
                z = false;
            }
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (!ListUtils.isEmpty(specialTopic.thread_list)) {
                    if (!TextUtils.isEmpty(specialTopic.title)) {
                        l09 l09Var = new l09(specialTopic.title);
                        if (!z) {
                            l09Var.b = false;
                            z = true;
                        }
                        this.n.add(l09Var);
                    }
                    int size = specialTopic.thread_list.size();
                    int i = 0;
                    while (i < size) {
                        ThreadInfo threadInfo2 = specialTopic.thread_list.get(i);
                        i++;
                        if (i == size) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        k09 k09Var = new k09(threadInfo2, z2);
                        k09Var.c(i);
                        this.n.add(k09Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<wn> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            e68 e68Var = this.f;
            if (e68Var != null) {
                this.a.add(e68Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (to6 to6Var : this.m) {
                    this.a.add(to6Var);
                }
            }
            h68 h68Var = this.c;
            if (h68Var != null && h68Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            z58 z58Var = this.k;
            if (z58Var != null && !ListUtils.isEmpty(z58Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((to6) ListUtils.getItem(this.k.a, i));
                    h68 h68Var2 = this.c;
                    if (h68Var2 != null && h68Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
