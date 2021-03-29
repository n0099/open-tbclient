package com.baidu.tieba.hottopic.frs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistModel;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import d.b.i0.b1.c.j;
import d.b.i0.b1.d.d;
import d.b.i0.p0.q0;
import d.b.i0.p0.s0;
import java.util.ArrayList;
import java.util.List;
import tbclient.Media;
import tbclient.TopicList.TopicList;
/* loaded from: classes3.dex */
public class FrsHottopicFragment extends BaseFragment implements q0, d.a, s0 {

    /* renamed from: e  reason: collision with root package name */
    public HotRanklistModel f17562e;

    /* renamed from: f  reason: collision with root package name */
    public j f17563f;

    /* renamed from: g  reason: collision with root package name */
    public d f17564g;

    /* renamed from: h  reason: collision with root package name */
    public long f17565h;
    public String i;
    public String j;
    public d.b.h0.d0.c k;
    public CustomMessageListener l = new a(2921397);
    public HotRanklistModel.b m = new b();
    public CustomMessageListener n = new c(2001624);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || FrsHottopicFragment.this.k == null || !FrsHottopicFragment.this.k.isViewAttached()) {
                return;
            }
            FrsHottopicFragment.this.k.a(num.intValue());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements HotRanklistModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.b
        public void loadNetDataCallback(boolean z, j jVar, int i, String str) {
            FrsHottopicFragment.this.n();
            FrsHottopicFragment.this.P0();
            FrsHottopicFragment.this.f17564g.h(false);
            if (z) {
                FrsHottopicFragment.this.f17563f = jVar;
                d dVar = FrsHottopicFragment.this.f17564g;
                FrsHottopicFragment frsHottopicFragment = FrsHottopicFragment.this;
                dVar.e(frsHottopicFragment.N0(frsHottopicFragment.f17563f));
                if (FrsHottopicFragment.this.O0()) {
                    return;
                }
                FrsHottopicFragment.this.f17564g.i();
            } else if (FrsHottopicFragment.this.O0()) {
            } else {
                FrsHottopicFragment.this.S0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 401) {
                FrsHottopicFragment.this.refresh();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    @Override // d.b.i0.p0.q0
    public void B0() {
        this.f17564g.d();
    }

    @Override // d.b.i0.p0.q0
    public void E() {
        refresh();
    }

    public final List<n> N0(j jVar) {
        if (jVar == null || ListUtils.isEmpty(jVar.a())) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TopicList topicList : jVar.a()) {
            if (topicList != null) {
                a2 a2Var = new a2();
                a2Var.l4(topicList.topic_tid + "");
                a2Var.C3(topicList.video_info);
                a2Var.t3(this.f17565h);
                a2Var.u3(this.i);
                a2Var.c4(this.j);
                a2Var.n4(topicList.topic_h5_url);
                MetaData metaData = new MetaData();
                metaData.setUserName(topicList.topic_name);
                a2Var.p3(metaData);
                a2Var.P3(topicList.update_time.longValue());
                a2Var.m4(topicList.topic_desc);
                a2Var.o4(topicList.topic_user_name);
                a2Var.J3();
                ArrayList<MediaData> arrayList2 = new ArrayList<>();
                List<Media> list = topicList.media;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list.get(i));
                        arrayList2.add(mediaData);
                    }
                }
                a2Var.U3(arrayList2);
                arrayList.add(a2Var);
            }
        }
        return arrayList;
    }

    public final boolean O0() {
        return this.f17564g.b();
    }

    public final void P0() {
        this.f17564g.g(true);
        d.b.h0.d0.c cVar = this.k;
        if (cVar != null && cVar.isViewAttached()) {
            this.k.dettachView(this.f17564g.a());
        }
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    public final void Q0() {
        if (isPrimary()) {
            d.b.h0.d0.c cVar = this.k;
            if (cVar == null || !cVar.isViewAttached()) {
                return;
            }
            MessageManager.getInstance().registerListener(this.l);
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    public final void R0() {
        this.f17564g.g(false);
        showLoadingView(this.f17564g.a(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    public final void S0() {
        this.f17564g.g(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
        if (this.k == null) {
            d.b.h0.d0.c cVar = new d.b.h0.d0.c(getPageContext().getContext(), getNetRefreshListener());
            this.k = cVar;
            cVar.e(null);
            this.k.d(null);
            this.k.c(null);
            this.k.f();
            this.k.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.k.onChangeSkinType();
        this.k.attachView(this.f17564g.a(), true);
        MessageManager.getInstance().registerListener(this.l);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = "4";
        tbPageTag.tabId = 401;
        return tbPageTag;
    }

    @Override // d.b.i0.p0.s0
    public void m() {
        refresh();
    }

    public final void n() {
        this.f17564g.g(true);
        hideLoadingView(this.f17564g.a());
    }

    @Override // d.b.i0.p0.s0
    public void o() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d dVar = this.f17564g;
        if (dVar != null) {
            dVar.c();
        }
        d.b.h0.d0.c cVar = this.k;
        if (cVar == null || !cVar.isViewAttached()) {
            return;
        }
        this.k.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HotRanklistModel hotRanklistModel = new HotRanklistModel(getPageContext());
        this.f17562e = hotRanklistModel;
        hotRanklistModel.x(this.m);
        registerListener(this.n);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f17565h = d.b.b.e.m.b.f(arguments.getString("fid"), 0L);
            arguments.getString("from");
            this.i = arguments.getString("first_class_name");
            this.j = arguments.getString("second_class_name");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_hottopic_fragment, (ViewGroup) null);
        d dVar = new d(this, inflate, getPageContext());
        this.f17564g = dVar;
        dVar.f(getTbPageTag());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.l);
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (O0()) {
            return;
        }
        refresh();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new StatisticItem("c13008").param("fid", this.f17565h).param("obj_type", 2).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (d.b.b.e.p.j.z()) {
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        Q0();
    }

    public void refresh() {
        if (!d.b.b.e.p.j.z()) {
            S0();
            return;
        }
        P0();
        this.f17564g.d();
        if (!O0()) {
            R0();
        } else {
            this.f17564g.h(true);
        }
        this.f17562e.cancelLoadData();
        this.f17562e.u("frs", "frstab", "0", this.f17565h);
    }
}
