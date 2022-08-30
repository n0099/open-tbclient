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
/* loaded from: classes3.dex */
public class d57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<pn> a;
    public e57 b;
    public k57 c;
    public xq4 d;
    public PostForumData e;
    public h57 f;
    public z47 g;
    public z47 h;
    public z47 i;
    public f57 j;
    public c57 k;
    public f57 l;
    public List<n06> m;
    public List<pn> n;
    public iq4 o;
    public int p;
    public RecomTopicList q;

    public d57() {
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

    public z47 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (z47) invokeV.objValue;
    }

    public z47 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : (z47) invokeV.objValue;
    }

    public xq4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (xq4) invokeV.objValue;
    }

    public h57 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : (h57) invokeV.objValue;
    }

    public e57 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (e57) invokeV.objValue;
    }

    public List<pn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public z47 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : (z47) invokeV.objValue;
    }

    public void h(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) || dataRes == null) {
            return;
        }
        dataRes.is_new_url.intValue();
        if (dataRes.topic_info != null) {
            e57 e57Var = new e57();
            this.b = e57Var;
            e57Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            f57 f57Var = new f57();
            this.l = f57Var;
            f57Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                n06 n06Var = null;
                if (threadData.isShareThread) {
                    n06Var = new v06();
                    n06Var.a = threadData;
                } else if (w06.R(threadData)) {
                    n06Var = new w06(threadData);
                    n06Var.s = true;
                } else if (v06.W(threadData)) {
                    n06Var = new v06();
                    n06Var.a = threadData;
                }
                if (n06Var != null && n06Var.isValid()) {
                    n06Var.L("c10814");
                    this.m.add(n06Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            k57 k57Var = new k57();
            this.c = k57Var;
            k57Var.parserProtobuf(dataRes.relate_forum);
            xq4 xq4Var = new xq4();
            this.d = xq4Var;
            xq4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f087f);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            xq4 xq4Var2 = this.d;
            xq4Var2.e = R.color.CAM_X0108;
            ArrayList<wq4> h = xq4Var2.h();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    wq4 wq4Var = new wq4();
                    wq4Var.D(relateForum.forum_id.intValue());
                    wq4Var.E(relateForum.forum_name);
                    wq4Var.C(relateForum.avatar);
                    wq4Var.A(relateForum.desc);
                    wq4Var.B(relateForum.thread_num.intValue());
                    wq4Var.z(relateForum.member_num.intValue());
                    wq4Var.w(relateForum.is_liked.intValue() != 0);
                    h.add(wq4Var);
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
            h57 h57Var = new h57();
            this.f = h57Var;
            h57Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            z47 z47Var = new z47();
            this.g = z47Var;
            z47Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            z47 z47Var2 = new z47();
            this.h = z47Var2;
            z47Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            z47 z47Var3 = new z47();
            this.i = z47Var3;
            z47Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            f57 f57Var2 = new f57();
            this.j = f57Var2;
            f57Var2.a(dataRes.hot_thread);
            c57 c57Var = new c57();
            this.k = c57Var;
            c57Var.r(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                iq4 iq4Var = new iq4();
                this.o = iq4Var;
                iq4Var.j(dataRes.hot_thread.page);
                this.o.b();
            }
            dataRes.is_global_block.intValue();
        }
        this.q = dataRes.next_topic;
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.n = new ArrayList();
            boolean z = this.f != null;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (!ListUtils.isEmpty(specialTopic.thread_list)) {
                    if (!TextUtils.isEmpty(specialTopic.title)) {
                        kp7 kp7Var = new kp7(specialTopic.title);
                        if (!z) {
                            kp7Var.b = false;
                            z = true;
                        }
                        this.n.add(kp7Var);
                    }
                    int size = specialTopic.thread_list.size();
                    int i = 0;
                    while (i < size) {
                        ThreadInfo threadInfo2 = specialTopic.thread_list.get(i);
                        i++;
                        jp7 jp7Var = new jp7(threadInfo2, i == size);
                        jp7Var.c(i);
                        this.n.add(jp7Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<pn> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            h57 h57Var = this.f;
            if (h57Var != null) {
                this.a.add(h57Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (n06 n06Var : this.m) {
                    this.a.add(n06Var);
                }
            }
            k57 k57Var = this.c;
            if (k57Var != null && k57Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            c57 c57Var = this.k;
            if (c57Var != null && !ListUtils.isEmpty(c57Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((n06) ListUtils.getItem(this.k.a, i));
                    k57 k57Var2 = this.c;
                    if (k57Var2 != null && k57Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
