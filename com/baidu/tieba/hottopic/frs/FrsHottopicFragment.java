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
import d.a.c.j.e.n;
import d.a.i0.r.q.a2;
import d.a.j0.c1.c.j;
import d.a.j0.c1.d.d;
import d.a.j0.q0.q0;
import d.a.j0.q0.s0;
import java.util.ArrayList;
import java.util.List;
import tbclient.Media;
import tbclient.TopicList.TopicList;
/* loaded from: classes4.dex */
public class FrsHottopicFragment extends BaseFragment implements q0, d.a, s0 {

    /* renamed from: e  reason: collision with root package name */
    public HotRanklistModel f17540e;

    /* renamed from: f  reason: collision with root package name */
    public j f17541f;

    /* renamed from: g  reason: collision with root package name */
    public d f17542g;

    /* renamed from: h  reason: collision with root package name */
    public long f17543h;

    /* renamed from: i  reason: collision with root package name */
    public String f17544i;
    public String j;
    public d.a.i0.d0.c k;
    public CustomMessageListener l = new a(2921397);
    public HotRanklistModel.b m = new b();
    public CustomMessageListener n = new c(2001624);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
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

    /* loaded from: classes4.dex */
    public class b implements HotRanklistModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.b
        public void loadNetDataCallback(boolean z, j jVar, int i2, String str) {
            FrsHottopicFragment.this.n();
            FrsHottopicFragment.this.P0();
            FrsHottopicFragment.this.f17542g.h(false);
            if (z) {
                FrsHottopicFragment.this.f17541f = jVar;
                d dVar = FrsHottopicFragment.this.f17542g;
                FrsHottopicFragment frsHottopicFragment = FrsHottopicFragment.this;
                dVar.e(frsHottopicFragment.N0(frsHottopicFragment.f17541f));
                if (FrsHottopicFragment.this.O0()) {
                    return;
                }
                FrsHottopicFragment.this.f17542g.i();
            } else if (FrsHottopicFragment.this.O0()) {
            } else {
                FrsHottopicFragment.this.S0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
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

    @Override // d.a.j0.q0.q0
    public void C0() {
        this.f17542g.d();
    }

    public final List<n> N0(j jVar) {
        if (jVar == null || ListUtils.isEmpty(jVar.a())) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TopicList topicList : jVar.a()) {
            if (topicList != null) {
                a2 a2Var = new a2();
                a2Var.m4(topicList.topic_tid + "");
                a2Var.D3(topicList.video_info);
                a2Var.u3(this.f17543h);
                a2Var.v3(this.f17544i);
                a2Var.d4(this.j);
                a2Var.o4(topicList.topic_h5_url);
                MetaData metaData = new MetaData();
                metaData.setUserName(topicList.topic_name);
                a2Var.q3(metaData);
                a2Var.Q3(topicList.update_time.longValue());
                a2Var.n4(topicList.topic_desc);
                a2Var.p4(topicList.topic_user_name);
                a2Var.K3();
                ArrayList<MediaData> arrayList2 = new ArrayList<>();
                List<Media> list = topicList.media;
                if (list != null) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list.get(i2));
                        arrayList2.add(mediaData);
                    }
                }
                a2Var.V3(arrayList2);
                arrayList.add(a2Var);
            }
        }
        return arrayList;
    }

    public final boolean O0() {
        return this.f17542g.b();
    }

    public final void P0() {
        this.f17542g.g(true);
        d.a.i0.d0.c cVar = this.k;
        if (cVar != null && cVar.isViewAttached()) {
            this.k.dettachView(this.f17542g.a());
        }
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    public final void Q0() {
        if (isPrimary()) {
            d.a.i0.d0.c cVar = this.k;
            if (cVar == null || !cVar.isViewAttached()) {
                return;
            }
            MessageManager.getInstance().registerListener(this.l);
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    public final void R0() {
        this.f17542g.g(false);
        showLoadingView(this.f17542g.a(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    public final void S0() {
        this.f17542g.g(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
        if (this.k == null) {
            d.a.i0.d0.c cVar = new d.a.i0.d0.c(getPageContext().getContext(), getNetRefreshListener());
            this.k = cVar;
            cVar.e(null);
            this.k.d(null);
            this.k.c(null);
            this.k.f();
            this.k.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.k.onChangeSkinType();
        this.k.attachView(this.f17542g.a(), true);
        MessageManager.getInstance().registerListener(this.l);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = "4";
        tbPageTag.tabId = 401;
        return tbPageTag;
    }

    @Override // d.a.j0.q0.s0
    public void k() {
    }

    @Override // d.a.j0.q0.s0
    public void m() {
        refresh();
    }

    public final void n() {
        this.f17542g.g(true);
        hideLoadingView(this.f17542g.a());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d dVar = this.f17542g;
        if (dVar != null) {
            dVar.c();
        }
        d.a.i0.d0.c cVar = this.k;
        if (cVar == null || !cVar.isViewAttached()) {
            return;
        }
        this.k.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HotRanklistModel hotRanklistModel = new HotRanklistModel(getPageContext());
        this.f17540e = hotRanklistModel;
        hotRanklistModel.x(this.m);
        registerListener(this.n);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f17543h = d.a.c.e.m.b.f(arguments.getString("fid"), 0L);
            arguments.getString("from");
            this.f17544i = arguments.getString("first_class_name");
            this.j = arguments.getString("second_class_name");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_hottopic_fragment, (ViewGroup) null);
        d dVar = new d(this, inflate, getPageContext());
        this.f17542g = dVar;
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
        TiebaStatic.log(new StatisticItem("c13008").param("fid", this.f17543h).param("obj_type", 2).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (d.a.c.e.p.j.z()) {
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        Q0();
    }

    public void refresh() {
        if (!d.a.c.e.p.j.z()) {
            S0();
            return;
        }
        P0();
        this.f17542g.d();
        if (!O0()) {
            R0();
        } else {
            this.f17542g.h(true);
        }
        this.f17540e.cancelLoadData();
        this.f17540e.u("frs", "frstab", "0", this.f17543h);
    }

    @Override // d.a.j0.q0.q0
    public void t() {
        refresh();
    }
}
