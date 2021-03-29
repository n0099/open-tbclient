package com.baidu.tieba.frs.vc;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.view.AdapterLinearLayout;
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.b.j.e.w;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.t;
import d.b.h0.x.d;
import d.b.i0.c3.i;
import d.b.i0.c3.p;
import d.b.i0.p0.h1.g;
import d.b.i0.p0.q2.e;
import d.b.i0.p0.y0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tbclient.ForumRuleStatus;
/* loaded from: classes4.dex */
public class FrsTopView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public FrsFoldingView f16657e;

    /* renamed from: f  reason: collision with root package name */
    public g f16658f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16659g;

    /* renamed from: h  reason: collision with root package name */
    public ForumData f16660h;
    public UserData i;
    public String j;
    public String k;
    public BdUniqueId l;
    public int m;
    public String n;
    public List<View> o;
    public List<e> p;
    public List<n> q;
    public w r;
    public y0 s;
    public ArrayList<Boolean> t;
    public d.b.i0.p0.j2.b u;

    /* loaded from: classes4.dex */
    public final class b implements w {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f16662e;

            public a(b bVar, String str) {
                this.f16662e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetWork netWork = new NetWork(this.f16662e);
                netWork.getNetContext().getRequest().mIsNeedAddCommenParam = false;
                netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                netWork.getNetData();
            }
        }

        public b() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            if (bdUniqueId == null) {
                return;
            }
            if (nVar != null && (nVar instanceof a2)) {
                a2 a2Var = (a2) nVar;
                if (a2Var.O() == null || a2Var.O().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(FrsTopView.this.getContext())) {
                    if (a2Var.G() != 1 || ViewHelper.checkUpIsLogin(FrsTopView.this.getContext())) {
                        if (a2Var.Q() != null) {
                            if (ViewHelper.checkUpIsLogin(FrsTopView.this.getContext())) {
                                String a2 = a2Var.Q().a();
                                if (StringUtils.isNull(a2) || !l.C()) {
                                    return;
                                }
                                d.b.h0.l.a.k(FrsTopView.this.getContext(), a2);
                            }
                        } else if (a2Var.W() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                ViewHelper.skipToLoginActivity(FrsTopView.this.getTbPageContext().getPageActivity());
                                return;
                            }
                            t W = a2Var.W();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsTopView.this.getTbPageContext().getPageActivity(), W.a(), W.b(), 2)));
                        } else {
                            String J = a2Var.J();
                            if (J == null || J.equals("")) {
                                z = false;
                            } else {
                                new Thread(new a(this, J)).start();
                                z = true;
                            }
                            String w1 = a2Var.w1();
                            if (w1 == null) {
                                w1 = "";
                            }
                            if (a2Var.x0() == 2 && !w1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                UrlManager.getInstance().dealOneLink(FrsTopView.this.getTbPageContext(), new String[]{w1, "", null});
                                return;
                            }
                            if (w1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && !TextUtils.isEmpty(w1) && w1.length() > 3) {
                                a2Var.D3(w1.substring(3));
                            }
                            if (bdUniqueId.getId() == a2.A3.getId()) {
                                d.b.i0.p0.m2.l.c(a2Var.o1());
                            } else if (bdUniqueId.getId() == a2.j3.getId()) {
                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                statisticItem.param("obj_type", "2");
                                statisticItem.param("tid", a2Var.w1());
                                TiebaStatic.log(statisticItem);
                            }
                            FrsTopView frsTopView = FrsTopView.this;
                            frsTopView.f(frsTopView.getFragmentActivity(), a2Var, i, z);
                            if (FrsTopView.this.s != null) {
                                FrsTopView.this.s.a(a2Var);
                            }
                        }
                    }
                }
            } else if (nVar == null || !(nVar instanceof p)) {
            } else {
                FrsTopView.this.l(((p) nVar).a());
            }
        }
    }

    public FrsTopView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseFragmentActivity getFragmentActivity() {
        if (getContext() instanceof BaseFragmentActivity) {
            return (BaseFragmentActivity) getContext();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getTbPageContext() {
        if (getContext() instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) getContext()).getPageContext();
        }
        return null;
    }

    public final void e(i iVar) {
        if (iVar == null) {
            return;
        }
        if (this.f16658f == null) {
            g gVar = new g(getContext());
            this.f16658f = gVar;
            addView(gVar.e());
        }
        this.f16658f.d(this.f16660h, iVar);
        if (this.f16659g) {
            return;
        }
        this.f16659g = true;
        StatisticItem statisticItem = new StatisticItem("common_exp");
        statisticItem.param("page_type", "a006");
        statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
        int i = 6;
        if (iVar.j() != 1) {
            if (iVar.j() == 2) {
                i = 7;
            } else if (iVar.j() == 3) {
                i = 8;
            }
        }
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
        statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i);
        statisticItem.param("obj_id", iVar.b());
        ForumData forumData = this.f16660h;
        if (forumData != null) {
            statisticItem.param("fid", forumData.getId());
            statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f16660h.getFirst_class());
            statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f16660h.getSecond_class());
        }
        if (iVar.j() == 1) {
            statisticItem.param("tid", iVar.g());
            statisticItem.param("thread_type", iVar.h());
        }
        TiebaStatic.log(statisticItem);
    }

    public void f(BaseFragmentActivity baseFragmentActivity, a2 a2Var, int i, boolean z) {
        PbActivityConfig createFromThreadCfg;
        if (baseFragmentActivity == null || a2Var == null) {
            return;
        }
        String str = null;
        String valueOf = String.valueOf(a2Var.c0());
        OriginalForumInfo originalForumInfo = a2Var.C1;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            str = valueOf;
        }
        if (a2Var.A0() > 0 && d.b.i0.c3.n0.e.c()) {
            createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(a2Var.w1(), String.valueOf(a2Var.A0()), false, true, "frs_page");
        } else {
            createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(a2Var, this.j, "frs_page", 18003, true, false, z);
        }
        if (i == 4) {
            createFromThreadCfg.setVideo_source("floor5");
        } else {
            createFromThreadCfg.setVideo_source("frs");
        }
        createFromThreadCfg.setFromSmartFrs(a2Var.s2());
        createFromThreadCfg.setSmartFrsPosition(i);
        createFromThreadCfg.setForumId(valueOf);
        createFromThreadCfg.setFromForumId(str);
        createFromThreadCfg.setStartFrom(3);
        createFromThreadCfg.setFrom("from_frs");
        if (a2Var.d2() && createFromThreadCfg.getIntent() != null) {
            createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
        }
        baseFragmentActivity.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public final void g() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_top_view_layout, (ViewGroup) this, true);
        this.f16657e = (FrsFoldingView) findViewById(R.id.frs_folding_layout);
    }

    public d.b.i0.p0.j2.b getStatisticMetaData() {
        return this.u;
    }

    public List<View> getmTopViews() {
        List<View> list = this.o;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.o;
    }

    public final void h() {
        AdapterLinearLayout adapterLinearLayout = new AdapterLinearLayout(getContext());
        adapterLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        adapterLinearLayout.setOrientation(1);
        e eVar = new e(getContext());
        eVar.s(this.k, this.j, this.i);
        eVar.t(this.f16660h);
        eVar.q(this.l);
        String str = this.n;
        if (str != null) {
            eVar.u(str);
        }
        int i = this.m;
        if (i != 0) {
            eVar.w(i);
        }
        adapterLinearLayout.setAdapter(eVar);
        this.o.add(adapterLinearLayout);
        this.p.add(eVar);
    }

    public void i(int i) {
        for (e eVar : this.p) {
            eVar.notifyDataSetChanged();
        }
        FrsFoldingView frsFoldingView = this.f16657e;
        if (frsFoldingView != null) {
            frsFoldingView.k();
        }
    }

    public void j(int i) {
        e eVar;
        if (i == -1 || this.p.size() <= i || (eVar = this.p.get(0)) == null) {
            return;
        }
        new ArrayList();
        List<n> n = eVar.n();
        if (n == null || n.size() <= i || !(n.get(i) instanceof p)) {
            return;
        }
        p pVar = (p) n.get(i);
        if (pVar != null) {
            ForumRuleStatus.Builder builder = new ForumRuleStatus.Builder();
            builder.has_forum_rule = pVar.a().has_forum_rule;
            builder.forum_rule_id = pVar.a().forum_rule_id;
            builder.title = pVar.a().title;
            builder.audit_status = 1;
            pVar.e(builder.build(true));
        }
        eVar.r(n);
        eVar.notifyDataSetChanged();
    }

    public final void k() {
        if (ListUtils.isEmpty(this.o)) {
            return;
        }
        setVisibility(0);
        FrsFoldingView frsFoldingView = this.f16657e;
        if (frsFoldingView != null) {
            frsFoldingView.setViews(this.o, this.p);
        }
    }

    public final void l(ForumRuleStatus forumRuleStatus) {
        if (forumRuleStatus == null || this.i == null || this.f16660h == null) {
            return;
        }
        int i = 1;
        if ((d.b.b.a.b.f().h("ForumRulesEditActivity") || d.h().k()) && this.i.getIs_manager() == 1) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921518, ""));
            return;
        }
        if (this.i.getIs_manager() == 1 && forumRuleStatus.has_forum_rule.intValue() == 0 && forumRuleStatus.audit_status.intValue() == 0) {
            Context context = getContext();
            String str = this.k;
            String str2 = this.j;
            ForumData forumData = this.f16660h;
            String image_url = forumData != null ? forumData.getImage_url() : "";
            ForumData forumData2 = this.f16660h;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRuleEditActivityConfig(context, str, str2, ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS, image_url, forumData2 != null ? forumData2.getUser_level() : 0, 25052)));
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(getContext(), this.k, "")));
        }
        StatisticItem statisticItem = new StatisticItem("c14027");
        statisticItem.param("fid", this.k);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.i.getIs_manager() != 1) {
            if (this.i.getIs_manager() == 2) {
                i = 2;
            } else {
                i = this.f16660h.isLike() == 1 ? 3 : 4;
            }
        }
        statisticItem.param("obj_type", i);
        TiebaStatic.log(statisticItem);
    }

    public void setDatas(List<n> list, i iVar) {
        this.q.clear();
        this.p.clear();
        this.o.clear();
        if (ListUtils.isEmpty(list) && iVar == null) {
            setVisibility(8);
            return;
        }
        if (iVar != null) {
            e(iVar);
        }
        if (!ListUtils.isEmpty(list)) {
            if (list.size() > 6) {
                list = list.subList(0, 6);
            }
            this.q.addAll(list);
            int i = this.q.size() <= 2 ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                h();
                e eVar = this.p.get(i2);
                if (eVar != null) {
                    if (this.r == null) {
                        this.r = new b();
                    }
                    eVar.v(this.r);
                    List<n> list2 = this.q;
                    eVar.r(list2.subList(i2 * 2, Math.min((i2 * 4) + 2, list2.size())));
                }
            }
        }
        if (this.t == null && this.o != null) {
            this.t = new ArrayList<>(Collections.nCopies(this.o.size(), Boolean.FALSE));
        }
        k();
    }

    public void setForum(String str, String str2, ForumData forumData, UserData userData, String str3) {
        this.k = str;
        this.j = str2;
        this.f16660h = forumData;
        this.i = userData;
    }

    public void setFragmentUniqueId(BdUniqueId bdUniqueId) {
        this.l = bdUniqueId;
    }

    public void setStatListener(y0 y0Var) {
        this.s = y0Var;
    }

    public void setUrlAndColor(String str, int i) {
        this.m = i;
        for (e eVar : this.p) {
            if (str != null) {
                eVar.u(str);
                this.n = str;
            }
            eVar.w(i);
            eVar.notifyDataSetChanged();
        }
    }

    public FrsTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16659g = false;
        this.j = "";
        this.k = "";
        this.m = 0;
        this.n = null;
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.u = new d.b.i0.p0.j2.b();
        g();
    }
}
