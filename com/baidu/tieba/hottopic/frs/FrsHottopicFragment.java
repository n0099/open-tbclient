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
import d.a.j0.r.q.a2;
import d.a.k0.c1.c.j;
import d.a.k0.c1.d.d;
import d.a.k0.q0.q0;
import d.a.k0.q0.s0;
import java.util.ArrayList;
import java.util.List;
import tbclient.Media;
import tbclient.TopicList.TopicList;
/* loaded from: classes4.dex */
public class FrsHottopicFragment extends BaseFragment implements q0, d.a, s0 {

    /* renamed from: e  reason: collision with root package name */
    public HotRanklistModel f16855e;

    /* renamed from: f  reason: collision with root package name */
    public j f16856f;

    /* renamed from: g  reason: collision with root package name */
    public d f16857g;

    /* renamed from: h  reason: collision with root package name */
    public long f16858h;

    /* renamed from: i  reason: collision with root package name */
    public String f16859i;
    public String j;
    public d.a.j0.d0.c k;
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
            FrsHottopicFragment.this.O0();
            FrsHottopicFragment.this.f16857g.h(false);
            if (z) {
                FrsHottopicFragment.this.f16856f = jVar;
                d dVar = FrsHottopicFragment.this.f16857g;
                FrsHottopicFragment frsHottopicFragment = FrsHottopicFragment.this;
                dVar.e(frsHottopicFragment.M0(frsHottopicFragment.f16856f));
                if (FrsHottopicFragment.this.N0()) {
                    return;
                }
                FrsHottopicFragment.this.f16857g.i();
            } else if (FrsHottopicFragment.this.N0()) {
            } else {
                FrsHottopicFragment.this.R0();
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

    @Override // d.a.k0.q0.q0
    public void B0() {
        this.f16857g.d();
    }

    public final List<n> M0(j jVar) {
        if (jVar == null || ListUtils.isEmpty(jVar.a())) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TopicList topicList : jVar.a()) {
            if (topicList != null) {
                a2 a2Var = new a2();
                a2Var.o4(topicList.topic_tid + "");
                a2Var.F3(topicList.video_info);
                a2Var.w3(this.f16858h);
                a2Var.x3(this.f16859i);
                a2Var.f4(this.j);
                a2Var.q4(topicList.topic_h5_url);
                MetaData metaData = new MetaData();
                metaData.setUserName(topicList.topic_name);
                a2Var.s3(metaData);
                a2Var.S3(topicList.update_time.longValue());
                a2Var.p4(topicList.topic_desc);
                a2Var.r4(topicList.topic_user_name);
                a2Var.M3();
                ArrayList<MediaData> arrayList2 = new ArrayList<>();
                List<Media> list = topicList.media;
                if (list != null) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list.get(i2));
                        arrayList2.add(mediaData);
                    }
                }
                a2Var.X3(arrayList2);
                arrayList.add(a2Var);
            }
        }
        return arrayList;
    }

    public final boolean N0() {
        return this.f16857g.b();
    }

    public final void O0() {
        this.f16857g.g(true);
        d.a.j0.d0.c cVar = this.k;
        if (cVar != null && cVar.isViewAttached()) {
            this.k.dettachView(this.f16857g.a());
        }
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    public final void P0() {
        if (isPrimary()) {
            d.a.j0.d0.c cVar = this.k;
            if (cVar == null || !cVar.isViewAttached()) {
                return;
            }
            MessageManager.getInstance().registerListener(this.l);
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    public final void Q0() {
        this.f16857g.g(false);
        showLoadingView(this.f16857g.a(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    public final void R0() {
        this.f16857g.g(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
        if (this.k == null) {
            d.a.j0.d0.c cVar = new d.a.j0.d0.c(getPageContext().getContext(), getNetRefreshListener());
            this.k = cVar;
            cVar.e(null);
            this.k.d(null);
            this.k.c(null);
            this.k.f();
            this.k.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.k.onChangeSkinType();
        this.k.attachView(this.f16857g.a(), true);
        MessageManager.getInstance().registerListener(this.l);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = "4";
        tbPageTag.tabId = 401;
        return tbPageTag;
    }

    @Override // d.a.k0.q0.s0
    public void k() {
    }

    @Override // d.a.k0.q0.s0
    public void m() {
        refresh();
    }

    public final void n() {
        this.f16857g.g(true);
        hideLoadingView(this.f16857g.a());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d dVar = this.f16857g;
        if (dVar != null) {
            dVar.c();
        }
        d.a.j0.d0.c cVar = this.k;
        if (cVar == null || !cVar.isViewAttached()) {
            return;
        }
        this.k.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HotRanklistModel hotRanklistModel = new HotRanklistModel(getPageContext());
        this.f16855e = hotRanklistModel;
        hotRanklistModel.x(this.m);
        registerListener(this.n);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f16858h = d.a.c.e.m.b.f(arguments.getString("fid"), 0L);
            arguments.getString("from");
            this.f16859i = arguments.getString("first_class_name");
            this.j = arguments.getString("second_class_name");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_hottopic_fragment, (ViewGroup) null);
        d dVar = new d(this, inflate, getPageContext());
        this.f16857g = dVar;
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
        if (N0()) {
            return;
        }
        refresh();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new StatisticItem("c13008").param("fid", this.f16858h).param("obj_type", 2).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
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
        P0();
    }

    public void refresh() {
        if (!d.a.c.e.p.j.z()) {
            R0();
            return;
        }
        O0();
        this.f16857g.d();
        if (!N0()) {
            Q0();
        } else {
            this.f16857g.h(true);
        }
        this.f16855e.cancelLoadData();
        this.f16855e.u("frs", "frstab", "0", this.f16858h);
    }

    @Override // d.a.k0.q0.q0
    public void t() {
        refresh();
    }
}
