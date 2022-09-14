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
public class i67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Cdo> a;
    public j67 b;
    public p67 c;
    public bt4 d;
    public PostForumData e;
    public m67 f;
    public e67 g;
    public e67 h;
    public e67 i;
    public k67 j;
    public h67 k;
    public k67 l;
    public List<c26> m;
    public List<Cdo> n;
    public ms4 o;
    public int p;
    public RecomTopicList q;

    public i67() {
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

    public e67 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (e67) invokeV.objValue;
    }

    public e67 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : (e67) invokeV.objValue;
    }

    public bt4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (bt4) invokeV.objValue;
    }

    public m67 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : (m67) invokeV.objValue;
    }

    public j67 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (j67) invokeV.objValue;
    }

    public List<Cdo> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public e67 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : (e67) invokeV.objValue;
    }

    public void h(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) || dataRes == null) {
            return;
        }
        dataRes.is_new_url.intValue();
        if (dataRes.topic_info != null) {
            j67 j67Var = new j67();
            this.b = j67Var;
            j67Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            k67 k67Var = new k67();
            this.l = k67Var;
            k67Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                c26 c26Var = null;
                if (threadData.isShareThread) {
                    c26Var = new k26();
                    c26Var.a = threadData;
                } else if (l26.R(threadData)) {
                    c26Var = new l26(threadData);
                    c26Var.s = true;
                } else if (k26.W(threadData)) {
                    c26Var = new k26();
                    c26Var.a = threadData;
                }
                if (c26Var != null && c26Var.isValid()) {
                    c26Var.L("c10814");
                    this.m.add(c26Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            p67 p67Var = new p67();
            this.c = p67Var;
            p67Var.parserProtobuf(dataRes.relate_forum);
            bt4 bt4Var = new bt4();
            this.d = bt4Var;
            bt4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0892);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            bt4 bt4Var2 = this.d;
            bt4Var2.e = R.color.CAM_X0108;
            ArrayList<at4> h = bt4Var2.h();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    at4 at4Var = new at4();
                    at4Var.D(relateForum.forum_id.intValue());
                    at4Var.E(relateForum.forum_name);
                    at4Var.C(relateForum.avatar);
                    at4Var.A(relateForum.desc);
                    at4Var.B(relateForum.thread_num.intValue());
                    at4Var.z(relateForum.member_num.intValue());
                    at4Var.w(relateForum.is_liked.intValue() != 0);
                    h.add(at4Var);
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
            m67 m67Var = new m67();
            this.f = m67Var;
            m67Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            e67 e67Var = new e67();
            this.g = e67Var;
            e67Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            e67 e67Var2 = new e67();
            this.h = e67Var2;
            e67Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            e67 e67Var3 = new e67();
            this.i = e67Var3;
            e67Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            k67 k67Var2 = new k67();
            this.j = k67Var2;
            k67Var2.a(dataRes.hot_thread);
            h67 h67Var = new h67();
            this.k = h67Var;
            h67Var.r(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                ms4 ms4Var = new ms4();
                this.o = ms4Var;
                ms4Var.j(dataRes.hot_thread.page);
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
                        sq7 sq7Var = new sq7(specialTopic.title);
                        if (!z) {
                            sq7Var.b = false;
                            z = true;
                        }
                        this.n.add(sq7Var);
                    }
                    int size = specialTopic.thread_list.size();
                    int i = 0;
                    while (i < size) {
                        ThreadInfo threadInfo2 = specialTopic.thread_list.get(i);
                        i++;
                        rq7 rq7Var = new rq7(threadInfo2, i == size);
                        rq7Var.c(i);
                        this.n.add(rq7Var);
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
            m67 m67Var = this.f;
            if (m67Var != null) {
                this.a.add(m67Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (c26 c26Var : this.m) {
                    this.a.add(c26Var);
                }
            }
            p67 p67Var = this.c;
            if (p67Var != null && p67Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            h67 h67Var = this.k;
            if (h67Var != null && !ListUtils.isEmpty(h67Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((c26) ListUtils.getItem(this.k.a, i));
                    p67 p67Var2 = this.c;
                    if (p67Var2 != null && p67Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
