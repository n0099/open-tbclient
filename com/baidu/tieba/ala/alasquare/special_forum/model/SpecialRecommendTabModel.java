package com.baidu.tieba.ala.alasquare.special_forum.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.special_forum.message.AlaSpecialRecommendResponse;
import d.a.c.j.e.n;
import d.a.m0.r.q.a2;
import d.a.n0.v.d.f.c.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class SpecialRecommendTabModel extends BdBaseModel {

    /* renamed from: f  reason: collision with root package name */
    public b f13833f;

    /* renamed from: e  reason: collision with root package name */
    public int f13832e = 1;

    /* renamed from: i  reason: collision with root package name */
    public HttpMessageListener f13836i = new a(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);

    /* renamed from: g  reason: collision with root package name */
    public List<n> f13834g = new LinkedList();

    /* renamed from: h  reason: collision with root package name */
    public List<a2> f13835h = new ArrayList();

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            c cVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021095 && (httpResponsedMessage instanceof AlaSpecialRecommendResponse)) {
                AlaSpecialRecommendResponse alaSpecialRecommendResponse = (AlaSpecialRecommendResponse) httpResponsedMessage;
                if (alaSpecialRecommendResponse.isSuccess()) {
                    if (SpecialRecommendTabModel.this.f13832e == 0) {
                        SpecialRecommendTabModel.this.f13834g.clear();
                        SpecialRecommendTabModel.this.f13835h.clear();
                    }
                    boolean z = alaSpecialRecommendResponse.hasMore;
                    if (ListUtils.getCount(alaSpecialRecommendResponse.livesList) > 0) {
                        SpecialRecommendTabModel.this.D(alaSpecialRecommendResponse.livesList);
                    }
                    SpecialRecommendTabModel specialRecommendTabModel = SpecialRecommendTabModel.this;
                    specialRecommendTabModel.z(specialRecommendTabModel.f13835h);
                    if (SpecialRecommendTabModel.this.f13832e == 0 && (cVar = alaSpecialRecommendResponse.mSpecialActivityListData) != null) {
                        SpecialRecommendTabModel.this.B(cVar);
                    }
                    SpecialRecommendTabModel.t(SpecialRecommendTabModel.this);
                    if (SpecialRecommendTabModel.this.f13833f != null) {
                        SpecialRecommendTabModel.this.f13833f.b(SpecialRecommendTabModel.this.f13834g, z);
                    }
                } else if (SpecialRecommendTabModel.this.f13833f != null) {
                    SpecialRecommendTabModel.this.f13833f.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str);

        void b(List<n> list, boolean z);
    }

    public SpecialRecommendTabModel(TbPageContext tbPageContext) {
        MessageManager.getInstance().registerListener(this.f13836i);
    }

    public static /* synthetic */ int t(SpecialRecommendTabModel specialRecommendTabModel) {
        int i2 = specialRecommendTabModel.f13832e;
        specialRecommendTabModel.f13832e = i2 + 1;
        return i2;
    }

    public List<a2> A() {
        return this.f13835h;
    }

    public final void B(c cVar) {
        if (cVar == null || ListUtils.isEmpty(cVar.f61720e)) {
            return;
        }
        if (ListUtils.getCount(this.f13834g) > 2) {
            this.f13834g.add(2, cVar);
        } else {
            this.f13834g.add(cVar);
        }
    }

    public final void C(int i2) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);
        httpMessage.addParam(Config.PACKAGE_NAME, i2);
        httpMessage.addParam("tab_name", "推荐");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final void D(List<a2> list) {
        for (a2 a2Var : list) {
            if (a2Var != null && (a2Var.u1() == 49 || a2Var.u1() == 69)) {
                String y1 = a2Var.y1();
                if (!TextUtils.isEmpty(y1)) {
                    boolean z = false;
                    Iterator<a2> it = this.f13835h.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (y1.equals(it.next().y1())) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (!z) {
                        this.f13835h.add(a2Var);
                    }
                }
            }
        }
    }

    public void E() {
        C(this.f13832e);
    }

    public void F() {
        this.f13832e = 0;
        C(0);
    }

    public void G(b bVar) {
        this.f13833f = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.f13836i);
    }

    public void z(List<a2> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f13834g = new LinkedList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            d.a.n0.v.d.g.b.b bVar = new d.a.n0.v.d.g.b.b();
            d.a.n0.v.d.a.c cVar = new d.a.n0.v.d.a.c();
            cVar.f61417h = list.get(i2);
            bVar.f61787e = cVar;
            int i3 = i2 + 1;
            if (i3 < size) {
                d.a.n0.v.d.a.c cVar2 = new d.a.n0.v.d.a.c();
                cVar2.f61417h = list.get(i3);
                bVar.f61788f = cVar2;
            }
            this.f13834g.add(bVar);
        }
    }
}
