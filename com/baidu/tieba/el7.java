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
public class el7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Cdo> a;
    public fl7 b;
    public ll7 c;
    public o05 d;
    public PostForumData e;
    public il7 f;
    public al7 g;
    public al7 h;
    public al7 i;
    public gl7 j;
    public dl7 k;
    public gl7 l;
    public List<eg6> m;
    public List<Cdo> n;
    public a05 o;
    public int p;
    public RecomTopicList q;

    public el7() {
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

    public al7 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (al7) invokeV.objValue;
    }

    public al7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (al7) invokeV.objValue;
    }

    public o05 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (o05) invokeV.objValue;
    }

    public il7 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (il7) invokeV.objValue;
    }

    public fl7 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (fl7) invokeV.objValue;
    }

    public List<Cdo> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public al7 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (al7) invokeV.objValue;
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
            fl7 fl7Var = new fl7();
            this.b = fl7Var;
            fl7Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            gl7 gl7Var = new gl7();
            this.l = gl7Var;
            gl7Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                eg6 eg6Var = null;
                if (threadData.isShareThread) {
                    eg6Var = new mg6();
                    eg6Var.a = threadData;
                } else if (ng6.R(threadData)) {
                    eg6Var = new ng6(threadData);
                    eg6Var.s = true;
                } else if (mg6.W(threadData)) {
                    eg6Var = new mg6();
                    eg6Var.a = threadData;
                }
                if (eg6Var != null && eg6Var.isValid()) {
                    eg6Var.J("c10814");
                    this.m.add(eg6Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            ll7 ll7Var = new ll7();
            this.c = ll7Var;
            ll7Var.parserProtobuf(dataRes.relate_forum);
            o05 o05Var = new o05();
            this.d = o05Var;
            o05Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0927);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            o05 o05Var2 = this.d;
            o05Var2.e = R.color.CAM_X0108;
            ArrayList<n05> g = o05Var2.g();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    n05 n05Var = new n05();
                    n05Var.x(relateForum.forum_id.intValue());
                    n05Var.y(relateForum.forum_name);
                    n05Var.v(relateForum.avatar);
                    n05Var.t(relateForum.desc);
                    n05Var.u(relateForum.thread_num.intValue());
                    n05Var.s(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    n05Var.r(z3);
                    g.add(n05Var);
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
            il7 il7Var = new il7();
            this.f = il7Var;
            il7Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            al7 al7Var = new al7();
            this.g = al7Var;
            al7Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            al7 al7Var2 = new al7();
            this.h = al7Var2;
            al7Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            al7 al7Var3 = new al7();
            this.i = al7Var3;
            al7Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            gl7 gl7Var2 = new gl7();
            this.j = gl7Var2;
            gl7Var2.a(dataRes.hot_thread);
            dl7 dl7Var = new dl7();
            this.k = dl7Var;
            dl7Var.n(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                a05 a05Var = new a05();
                this.o = a05Var;
                a05Var.j(dataRes.hot_thread.page);
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
                        j98 j98Var = new j98(specialTopic.title);
                        if (!z) {
                            j98Var.b = false;
                            z = true;
                        }
                        this.n.add(j98Var);
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
                        i98 i98Var = new i98(threadInfo2, z2);
                        i98Var.c(i);
                        this.n.add(i98Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<Cdo> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            il7 il7Var = this.f;
            if (il7Var != null) {
                this.a.add(il7Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (eg6 eg6Var : this.m) {
                    this.a.add(eg6Var);
                }
            }
            ll7 ll7Var = this.c;
            if (ll7Var != null && ll7Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            dl7 dl7Var = this.k;
            if (dl7Var != null && !ListUtils.isEmpty(dl7Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((eg6) ListUtils.getItem(this.k.a, i));
                    ll7 ll7Var2 = this.c;
                    if (ll7Var2 != null && ll7Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
