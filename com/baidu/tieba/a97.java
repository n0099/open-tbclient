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
public class a97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<xn> a;
    public b97 b;
    public h97 c;
    public iu4 d;
    public PostForumData e;
    public e97 f;
    public w87 g;
    public w87 h;
    public w87 i;
    public c97 j;
    public z87 k;
    public c97 l;
    public List<t46> m;
    public List<xn> n;
    public ut4 o;
    public int p;
    public RecomTopicList q;

    public a97() {
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

    public w87 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (w87) invokeV.objValue;
    }

    public w87 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (w87) invokeV.objValue;
    }

    public iu4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (iu4) invokeV.objValue;
    }

    public e97 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (e97) invokeV.objValue;
    }

    public b97 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (b97) invokeV.objValue;
    }

    public List<xn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public w87 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (w87) invokeV.objValue;
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
            b97 b97Var = new b97();
            this.b = b97Var;
            b97Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            c97 c97Var = new c97();
            this.l = c97Var;
            c97Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                t46 t46Var = null;
                if (threadData.isShareThread) {
                    t46Var = new b56();
                    t46Var.a = threadData;
                } else if (c56.R(threadData)) {
                    t46Var = new c56(threadData);
                    t46Var.s = true;
                } else if (b56.W(threadData)) {
                    t46Var = new b56();
                    t46Var.a = threadData;
                }
                if (t46Var != null && t46Var.isValid()) {
                    t46Var.L("c10814");
                    this.m.add(t46Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            h97 h97Var = new h97();
            this.c = h97Var;
            h97Var.parserProtobuf(dataRes.relate_forum);
            iu4 iu4Var = new iu4();
            this.d = iu4Var;
            iu4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08a9);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            iu4 iu4Var2 = this.d;
            iu4Var2.e = R.color.CAM_X0108;
            ArrayList<hu4> h = iu4Var2.h();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    hu4 hu4Var = new hu4();
                    hu4Var.D(relateForum.forum_id.intValue());
                    hu4Var.E(relateForum.forum_name);
                    hu4Var.C(relateForum.avatar);
                    hu4Var.A(relateForum.desc);
                    hu4Var.B(relateForum.thread_num.intValue());
                    hu4Var.z(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    hu4Var.w(z3);
                    h.add(hu4Var);
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
            e97 e97Var = new e97();
            this.f = e97Var;
            e97Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            w87 w87Var = new w87();
            this.g = w87Var;
            w87Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            w87 w87Var2 = new w87();
            this.h = w87Var2;
            w87Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            w87 w87Var3 = new w87();
            this.i = w87Var3;
            w87Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            c97 c97Var2 = new c97();
            this.j = c97Var2;
            c97Var2.a(dataRes.hot_thread);
            z87 z87Var = new z87();
            this.k = z87Var;
            z87Var.r(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                ut4 ut4Var = new ut4();
                this.o = ut4Var;
                ut4Var.j(dataRes.hot_thread.page);
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
                        mt7 mt7Var = new mt7(specialTopic.title);
                        if (!z) {
                            mt7Var.b = false;
                            z = true;
                        }
                        this.n.add(mt7Var);
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
                        lt7 lt7Var = new lt7(threadInfo2, z2);
                        lt7Var.c(i);
                        this.n.add(lt7Var);
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
            e97 e97Var = this.f;
            if (e97Var != null) {
                this.a.add(e97Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (t46 t46Var : this.m) {
                    this.a.add(t46Var);
                }
            }
            h97 h97Var = this.c;
            if (h97Var != null && h97Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            z87 z87Var = this.k;
            if (z87Var != null && !ListUtils.isEmpty(z87Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((t46) ListUtils.getItem(this.k.a, i));
                    h97 h97Var2 = this.c;
                    if (h97Var2 != null && h97Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
