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
public class e77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList a;
    public f77 b;
    public l77 c;
    public qt4 d;
    public PostForumData e;
    public i77 f;
    public a77 g;
    public a77 h;
    public a77 i;
    public g77 j;
    public d77 k;
    public g77 l;
    public List m;
    public List n;
    public bt4 o;
    public int p;
    public RecomTopicList q;

    public e77() {
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
        this.a = new ArrayList();
    }

    public a77 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (a77) invokeV.objValue;
    }

    public a77 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (a77) invokeV.objValue;
    }

    public qt4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (qt4) invokeV.objValue;
    }

    public i77 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (i77) invokeV.objValue;
    }

    public f77 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (f77) invokeV.objValue;
    }

    public List f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public a77 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (a77) invokeV.objValue;
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
            f77 f77Var = new f77();
            this.b = f77Var;
            f77Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            g77 g77Var = new g77();
            this.l = g77Var;
            g77Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                w26 w26Var = null;
                if (threadData.isShareThread) {
                    w26Var = new e36();
                    w26Var.a = threadData;
                } else if (f36.R(threadData)) {
                    w26Var = new f36(threadData);
                    w26Var.s = true;
                } else if (e36.W(threadData)) {
                    w26Var = new e36();
                    w26Var.a = threadData;
                }
                if (w26Var != null && w26Var.isValid()) {
                    w26Var.L("c10814");
                    this.m.add(w26Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            l77 l77Var = new l77();
            this.c = l77Var;
            l77Var.parserProtobuf(dataRes.relate_forum);
            qt4 qt4Var = new qt4();
            this.d = qt4Var;
            qt4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f089e);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            qt4 qt4Var2 = this.d;
            qt4Var2.e = R.color.CAM_X0108;
            ArrayList<pt4> h = qt4Var2.h();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    pt4 pt4Var = new pt4();
                    pt4Var.D(relateForum.forum_id.intValue());
                    pt4Var.E(relateForum.forum_name);
                    pt4Var.C(relateForum.avatar);
                    pt4Var.A(relateForum.desc);
                    pt4Var.B(relateForum.thread_num.intValue());
                    pt4Var.z(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    pt4Var.w(z3);
                    h.add(pt4Var);
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
            i77 i77Var = new i77();
            this.f = i77Var;
            i77Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            a77 a77Var = new a77();
            this.g = a77Var;
            a77Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            a77 a77Var2 = new a77();
            this.h = a77Var2;
            a77Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            a77 a77Var3 = new a77();
            this.i = a77Var3;
            a77Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            g77 g77Var2 = new g77();
            this.j = g77Var2;
            g77Var2.a(dataRes.hot_thread);
            d77 d77Var = new d77();
            this.k = d77Var;
            d77Var.r(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                bt4 bt4Var = new bt4();
                this.o = bt4Var;
                bt4Var.j(dataRes.hot_thread.page);
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
                        rr7 rr7Var = new rr7(specialTopic.title);
                        if (!z) {
                            rr7Var.b = false;
                            z = true;
                        }
                        this.n.add(rr7Var);
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
                        qr7 qr7Var = new qr7(threadInfo2, z2);
                        qr7Var.c(i);
                        this.n.add(qr7Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            i77 i77Var = this.f;
            if (i77Var != null) {
                this.a.add(i77Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (w26 w26Var : this.m) {
                    this.a.add(w26Var);
                }
            }
            l77 l77Var = this.c;
            if (l77Var != null && l77Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            d77 d77Var = this.k;
            if (d77Var != null && !ListUtils.isEmpty(d77Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((w26) ListUtils.getItem(this.k.a, i));
                    l77 l77Var2 = this.c;
                    if (l77Var2 != null && l77Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
