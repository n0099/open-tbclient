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
/* loaded from: classes6.dex */
public class i58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<vn> a;
    public j58 b;
    public p58 c;
    public w35 d;
    public PostForumData e;
    public m58 f;
    public e58 g;
    public e58 h;
    public e58 i;
    public k58 j;
    public h58 k;
    public k58 l;
    public List<mo6> m;
    public List<vn> n;
    public i35 o;
    public int p;
    public RecomTopicList q;

    public i58() {
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

    public e58 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (e58) invokeV.objValue;
    }

    public e58 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (e58) invokeV.objValue;
    }

    public w35 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (w35) invokeV.objValue;
    }

    public m58 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (m58) invokeV.objValue;
    }

    public j58 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (j58) invokeV.objValue;
    }

    public List<vn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public e58 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (e58) invokeV.objValue;
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
            j58 j58Var = new j58();
            this.b = j58Var;
            j58Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            k58 k58Var = new k58();
            this.l = k58Var;
            k58Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                mo6 mo6Var = null;
                if (threadData.isShareThread) {
                    mo6Var = new uo6();
                    mo6Var.a = threadData;
                } else if (vo6.P(threadData)) {
                    mo6Var = new vo6(threadData);
                    mo6Var.s = true;
                } else if (uo6.X(threadData)) {
                    mo6Var = new uo6();
                    mo6Var.a = threadData;
                }
                if (mo6Var != null && mo6Var.isValid()) {
                    mo6Var.F("c10814");
                    this.m.add(mo6Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            p58 p58Var = new p58();
            this.c = p58Var;
            p58Var.parserProtobuf(dataRes.relate_forum);
            w35 w35Var = new w35();
            this.d = w35Var;
            w35Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09f1);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            w35 w35Var2 = this.d;
            w35Var2.e = R.color.CAM_X0108;
            ArrayList<v35> e = w35Var2.e();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    v35 v35Var = new v35();
                    v35Var.w(relateForum.forum_id.intValue());
                    v35Var.x(relateForum.forum_name);
                    v35Var.u(relateForum.avatar);
                    v35Var.q(relateForum.desc);
                    v35Var.s(relateForum.thread_num.intValue());
                    v35Var.o(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    v35Var.n(z3);
                    e.add(v35Var);
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
            m58 m58Var = new m58();
            this.f = m58Var;
            m58Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            e58 e58Var = new e58();
            this.g = e58Var;
            e58Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            e58 e58Var2 = new e58();
            this.h = e58Var2;
            e58Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            e58 e58Var3 = new e58();
            this.i = e58Var3;
            e58Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            k58 k58Var2 = new k58();
            this.j = k58Var2;
            k58Var2.a(dataRes.hot_thread);
            h58 h58Var = new h58();
            this.k = h58Var;
            h58Var.k(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                i35 i35Var = new i35();
                this.o = i35Var;
                i35Var.j(dataRes.hot_thread.page);
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
                        nz8 nz8Var = new nz8(specialTopic.title);
                        if (!z) {
                            nz8Var.b = false;
                            z = true;
                        }
                        this.n.add(nz8Var);
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
                        mz8 mz8Var = new mz8(threadInfo2, z2);
                        mz8Var.c(i);
                        this.n.add(mz8Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<vn> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            m58 m58Var = this.f;
            if (m58Var != null) {
                this.a.add(m58Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (mo6 mo6Var : this.m) {
                    this.a.add(mo6Var);
                }
            }
            p58 p58Var = this.c;
            if (p58Var != null && p58Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            h58 h58Var = this.k;
            if (h58Var != null && !ListUtils.isEmpty(h58Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((mo6) ListUtils.getItem(this.k.a, i));
                    p58 p58Var2 = this.c;
                    if (p58Var2 != null && p58Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
