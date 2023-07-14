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
/* loaded from: classes5.dex */
public class ab8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<yn> a;
    public bb8 b;
    public hb8 c;
    public k45 d;
    public PostForumData e;
    public eb8 f;
    public wa8 g;
    public wa8 h;
    public wa8 i;
    public cb8 j;
    public za8 k;
    public cb8 l;
    public List<cq6> m;
    public List<yn> n;
    public w35 o;
    public int p;
    public RecomTopicList q;

    public ab8() {
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

    public wa8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (wa8) invokeV.objValue;
    }

    public wa8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (wa8) invokeV.objValue;
    }

    public k45 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (k45) invokeV.objValue;
    }

    public eb8 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (eb8) invokeV.objValue;
    }

    public bb8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (bb8) invokeV.objValue;
    }

    public List<yn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public wa8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (wa8) invokeV.objValue;
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
            bb8 bb8Var = new bb8();
            this.b = bb8Var;
            bb8Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            cb8 cb8Var = new cb8();
            this.l = cb8Var;
            cb8Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                cq6 cq6Var = null;
                if (threadData.isShareThread) {
                    cq6Var = new kq6();
                    cq6Var.a = threadData;
                } else if (lq6.N(threadData)) {
                    cq6Var = new lq6(threadData);
                    cq6Var.s = true;
                } else if (kq6.X(threadData)) {
                    cq6Var = new kq6();
                    cq6Var.a = threadData;
                }
                if (cq6Var != null && cq6Var.isValid()) {
                    cq6Var.E("c10814");
                    this.m.add(cq6Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            hb8 hb8Var = new hb8();
            this.c = hb8Var;
            hb8Var.parserProtobuf(dataRes.relate_forum);
            k45 k45Var = new k45();
            this.d = k45Var;
            k45Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a03);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            k45 k45Var2 = this.d;
            k45Var2.e = R.color.CAM_X0108;
            ArrayList<j45> e = k45Var2.e();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    j45 j45Var = new j45();
                    j45Var.v(relateForum.forum_id.intValue());
                    j45Var.x(relateForum.forum_name);
                    j45Var.t(relateForum.avatar);
                    j45Var.p(relateForum.desc);
                    j45Var.r(relateForum.thread_num.intValue());
                    j45Var.o(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    j45Var.n(z3);
                    e.add(j45Var);
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
            eb8 eb8Var = new eb8();
            this.f = eb8Var;
            eb8Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            wa8 wa8Var = new wa8();
            this.g = wa8Var;
            wa8Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            wa8 wa8Var2 = new wa8();
            this.h = wa8Var2;
            wa8Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            wa8 wa8Var3 = new wa8();
            this.i = wa8Var3;
            wa8Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            cb8 cb8Var2 = new cb8();
            this.j = cb8Var2;
            cb8Var2.a(dataRes.hot_thread);
            za8 za8Var = new za8();
            this.k = za8Var;
            za8Var.i(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                w35 w35Var = new w35();
                this.o = w35Var;
                w35Var.j(dataRes.hot_thread.page);
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
                        ab9 ab9Var = new ab9(specialTopic.title);
                        if (!z) {
                            ab9Var.b = false;
                            z = true;
                        }
                        this.n.add(ab9Var);
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
                        za9 za9Var = new za9(threadInfo2, z2);
                        za9Var.c(i);
                        this.n.add(za9Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<yn> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            eb8 eb8Var = this.f;
            if (eb8Var != null) {
                this.a.add(eb8Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (cq6 cq6Var : this.m) {
                    this.a.add(cq6Var);
                }
            }
            hb8 hb8Var = this.c;
            if (hb8Var != null && hb8Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            za8 za8Var = this.k;
            if (za8Var != null && !ListUtils.isEmpty(za8Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((cq6) ListUtils.getItem(this.k.a, i));
                    hb8 hb8Var2 = this.c;
                    if (hb8Var2 != null && hb8Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
