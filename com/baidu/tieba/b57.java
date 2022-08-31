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
public class b57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<pn> a;
    public c57 b;
    public i57 c;
    public wq4 d;
    public PostForumData e;
    public f57 f;
    public x47 g;
    public x47 h;
    public x47 i;
    public d57 j;
    public a57 k;
    public d57 l;
    public List<l06> m;
    public List<pn> n;
    public hq4 o;
    public int p;
    public RecomTopicList q;

    public b57() {
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

    public x47 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (x47) invokeV.objValue;
    }

    public x47 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : (x47) invokeV.objValue;
    }

    public wq4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (wq4) invokeV.objValue;
    }

    public f57 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : (f57) invokeV.objValue;
    }

    public c57 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (c57) invokeV.objValue;
    }

    public List<pn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public x47 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : (x47) invokeV.objValue;
    }

    public void h(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) || dataRes == null) {
            return;
        }
        dataRes.is_new_url.intValue();
        if (dataRes.topic_info != null) {
            c57 c57Var = new c57();
            this.b = c57Var;
            c57Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            d57 d57Var = new d57();
            this.l = d57Var;
            d57Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                l06 l06Var = null;
                if (threadData.isShareThread) {
                    l06Var = new t06();
                    l06Var.a = threadData;
                } else if (u06.R(threadData)) {
                    l06Var = new u06(threadData);
                    l06Var.s = true;
                } else if (t06.W(threadData)) {
                    l06Var = new t06();
                    l06Var.a = threadData;
                }
                if (l06Var != null && l06Var.isValid()) {
                    l06Var.L("c10814");
                    this.m.add(l06Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            i57 i57Var = new i57();
            this.c = i57Var;
            i57Var.parserProtobuf(dataRes.relate_forum);
            wq4 wq4Var = new wq4();
            this.d = wq4Var;
            wq4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f087f);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            wq4 wq4Var2 = this.d;
            wq4Var2.e = R.color.CAM_X0108;
            ArrayList<vq4> h = wq4Var2.h();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    vq4 vq4Var = new vq4();
                    vq4Var.D(relateForum.forum_id.intValue());
                    vq4Var.E(relateForum.forum_name);
                    vq4Var.C(relateForum.avatar);
                    vq4Var.A(relateForum.desc);
                    vq4Var.B(relateForum.thread_num.intValue());
                    vq4Var.z(relateForum.member_num.intValue());
                    vq4Var.w(relateForum.is_liked.intValue() != 0);
                    h.add(vq4Var);
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
            f57 f57Var = new f57();
            this.f = f57Var;
            f57Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            x47 x47Var = new x47();
            this.g = x47Var;
            x47Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            x47 x47Var2 = new x47();
            this.h = x47Var2;
            x47Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            x47 x47Var3 = new x47();
            this.i = x47Var3;
            x47Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            d57 d57Var2 = new d57();
            this.j = d57Var2;
            d57Var2.a(dataRes.hot_thread);
            a57 a57Var = new a57();
            this.k = a57Var;
            a57Var.r(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                hq4 hq4Var = new hq4();
                this.o = hq4Var;
                hq4Var.j(dataRes.hot_thread.page);
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
                        ip7 ip7Var = new ip7(specialTopic.title);
                        if (!z) {
                            ip7Var.b = false;
                            z = true;
                        }
                        this.n.add(ip7Var);
                    }
                    int size = specialTopic.thread_list.size();
                    int i = 0;
                    while (i < size) {
                        ThreadInfo threadInfo2 = specialTopic.thread_list.get(i);
                        i++;
                        hp7 hp7Var = new hp7(threadInfo2, i == size);
                        hp7Var.c(i);
                        this.n.add(hp7Var);
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
            f57 f57Var = this.f;
            if (f57Var != null) {
                this.a.add(f57Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (l06 l06Var : this.m) {
                    this.a.add(l06Var);
                }
            }
            i57 i57Var = this.c;
            if (i57Var != null && i57Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            a57 a57Var = this.k;
            if (a57Var != null && !ListUtils.isEmpty(a57Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((l06) ListUtils.getItem(this.k.a, i));
                    i57 i57Var2 = this.c;
                    if (i57Var2 != null && i57Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
