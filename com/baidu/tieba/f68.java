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
public class f68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<xn> a;
    public g68 b;
    public m68 c;
    public c45 d;
    public PostForumData e;
    public j68 f;
    public b68 g;
    public b68 h;
    public b68 i;
    public h68 j;
    public e68 k;
    public h68 l;
    public List<yo6> m;
    public List<xn> n;
    public o35 o;
    public int p;
    public RecomTopicList q;

    public f68() {
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

    public b68 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (b68) invokeV.objValue;
    }

    public b68 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (b68) invokeV.objValue;
    }

    public c45 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (c45) invokeV.objValue;
    }

    public j68 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (j68) invokeV.objValue;
    }

    public g68 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (g68) invokeV.objValue;
    }

    public List<xn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public b68 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (b68) invokeV.objValue;
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
            g68 g68Var = new g68();
            this.b = g68Var;
            g68Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            h68 h68Var = new h68();
            this.l = h68Var;
            h68Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                yo6 yo6Var = null;
                if (threadData.isShareThread) {
                    yo6Var = new gp6();
                    yo6Var.a = threadData;
                } else if (hp6.P(threadData)) {
                    yo6Var = new hp6(threadData);
                    yo6Var.s = true;
                } else if (gp6.X(threadData)) {
                    yo6Var = new gp6();
                    yo6Var.a = threadData;
                }
                if (yo6Var != null && yo6Var.isValid()) {
                    yo6Var.F("c10814");
                    this.m.add(yo6Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            m68 m68Var = new m68();
            this.c = m68Var;
            m68Var.parserProtobuf(dataRes.relate_forum);
            c45 c45Var = new c45();
            this.d = c45Var;
            c45Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09f8);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            c45 c45Var2 = this.d;
            c45Var2.e = R.color.CAM_X0108;
            ArrayList<b45> e = c45Var2.e();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    b45 b45Var = new b45();
                    b45Var.w(relateForum.forum_id.intValue());
                    b45Var.x(relateForum.forum_name);
                    b45Var.u(relateForum.avatar);
                    b45Var.q(relateForum.desc);
                    b45Var.s(relateForum.thread_num.intValue());
                    b45Var.o(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    b45Var.n(z3);
                    e.add(b45Var);
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
            j68 j68Var = new j68();
            this.f = j68Var;
            j68Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            b68 b68Var = new b68();
            this.g = b68Var;
            b68Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            b68 b68Var2 = new b68();
            this.h = b68Var2;
            b68Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            b68 b68Var3 = new b68();
            this.i = b68Var3;
            b68Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            h68 h68Var2 = new h68();
            this.j = h68Var2;
            h68Var2.a(dataRes.hot_thread);
            e68 e68Var = new e68();
            this.k = e68Var;
            e68Var.k(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                o35 o35Var = new o35();
                this.o = o35Var;
                o35Var.j(dataRes.hot_thread.page);
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
                        w49 w49Var = new w49(specialTopic.title);
                        if (!z) {
                            w49Var.b = false;
                            z = true;
                        }
                        this.n.add(w49Var);
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
                        v49 v49Var = new v49(threadInfo2, z2);
                        v49Var.c(i);
                        this.n.add(v49Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<xn> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            j68 j68Var = this.f;
            if (j68Var != null) {
                this.a.add(j68Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (yo6 yo6Var : this.m) {
                    this.a.add(yo6Var);
                }
            }
            m68 m68Var = this.c;
            if (m68Var != null && m68Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            e68 e68Var = this.k;
            if (e68Var != null && !ListUtils.isEmpty(e68Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((yo6) ListUtils.getItem(this.k.a, i));
                    m68 m68Var2 = this.c;
                    if (m68Var2 != null && m68Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
