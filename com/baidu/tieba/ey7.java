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
public class ey7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<in> a;
    public fy7 b;
    public ly7 c;
    public qz4 d;
    public PostForumData e;
    public iy7 f;
    public ay7 g;
    public ay7 h;
    public ay7 i;
    public gy7 j;
    public dy7 k;
    public gy7 l;
    public List<qi6> m;
    public List<in> n;
    public cz4 o;
    public int p;
    public RecomTopicList q;

    public ey7() {
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

    public ay7 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (ay7) invokeV.objValue;
    }

    public ay7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (ay7) invokeV.objValue;
    }

    public qz4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (qz4) invokeV.objValue;
    }

    public iy7 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (iy7) invokeV.objValue;
    }

    public fy7 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (fy7) invokeV.objValue;
    }

    public List<in> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public ay7 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (ay7) invokeV.objValue;
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
            fy7 fy7Var = new fy7();
            this.b = fy7Var;
            fy7Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            gy7 gy7Var = new gy7();
            this.l = gy7Var;
            gy7Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                qi6 qi6Var = null;
                if (threadData.isShareThread) {
                    qi6Var = new yi6();
                    qi6Var.a = threadData;
                } else if (zi6.N(threadData)) {
                    qi6Var = new zi6(threadData);
                    qi6Var.s = true;
                } else if (yi6.W(threadData)) {
                    qi6Var = new yi6();
                    qi6Var.a = threadData;
                }
                if (qi6Var != null && qi6Var.isValid()) {
                    qi6Var.E("c10814");
                    this.m.add(qi6Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            ly7 ly7Var = new ly7();
            this.c = ly7Var;
            ly7Var.parserProtobuf(dataRes.relate_forum);
            qz4 qz4Var = new qz4();
            this.d = qz4Var;
            qz4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0943);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            qz4 qz4Var2 = this.d;
            qz4Var2.e = R.color.CAM_X0108;
            ArrayList<pz4> e = qz4Var2.e();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    pz4 pz4Var = new pz4();
                    pz4Var.v(relateForum.forum_id.intValue());
                    pz4Var.x(relateForum.forum_name);
                    pz4Var.t(relateForum.avatar);
                    pz4Var.p(relateForum.desc);
                    pz4Var.r(relateForum.thread_num.intValue());
                    pz4Var.o(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    pz4Var.n(z3);
                    e.add(pz4Var);
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
            iy7 iy7Var = new iy7();
            this.f = iy7Var;
            iy7Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            ay7 ay7Var = new ay7();
            this.g = ay7Var;
            ay7Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            ay7 ay7Var2 = new ay7();
            this.h = ay7Var2;
            ay7Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            ay7 ay7Var3 = new ay7();
            this.i = ay7Var3;
            ay7Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            gy7 gy7Var2 = new gy7();
            this.j = gy7Var2;
            gy7Var2.a(dataRes.hot_thread);
            dy7 dy7Var = new dy7();
            this.k = dy7Var;
            dy7Var.j(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                cz4 cz4Var = new cz4();
                this.o = cz4Var;
                cz4Var.j(dataRes.hot_thread.page);
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
                        ur8 ur8Var = new ur8(specialTopic.title);
                        if (!z) {
                            ur8Var.b = false;
                            z = true;
                        }
                        this.n.add(ur8Var);
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
                        tr8 tr8Var = new tr8(threadInfo2, z2);
                        tr8Var.c(i);
                        this.n.add(tr8Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<in> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            iy7 iy7Var = this.f;
            if (iy7Var != null) {
                this.a.add(iy7Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (qi6 qi6Var : this.m) {
                    this.a.add(qi6Var);
                }
            }
            ly7 ly7Var = this.c;
            if (ly7Var != null && ly7Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            dy7 dy7Var = this.k;
            if (dy7Var != null && !ListUtils.isEmpty(dy7Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((qi6) ListUtils.getItem(this.k.a, i));
                    ly7 ly7Var2 = this.c;
                    if (ly7Var2 != null && ly7Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
