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
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.t;
import d.a.j0.x.d;
import d.a.k0.d3.i;
import d.a.k0.d3.p;
import d.a.k0.q0.r2.e;
import d.a.k0.q0.y0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tbclient.ForumRuleStatus;
/* loaded from: classes4.dex */
public class FrsTopView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public FrsFoldingView f15861e;

    /* renamed from: f  reason: collision with root package name */
    public ForumData f15862f;

    /* renamed from: g  reason: collision with root package name */
    public UserData f15863g;

    /* renamed from: h  reason: collision with root package name */
    public String f15864h;

    /* renamed from: i  reason: collision with root package name */
    public String f15865i;
    public BdUniqueId j;
    public int k;
    public String l;
    public List<View> m;
    public List<e> n;
    public List<n> o;
    public w p;
    public y0 q;
    public ArrayList<Boolean> r;
    public d.a.k0.q0.j2.b s;

    /* loaded from: classes4.dex */
    public final class b implements w {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f15867e;

            public a(b bVar, String str) {
                this.f15867e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetWork netWork = new NetWork(this.f15867e);
                netWork.getNetContext().getRequest().mIsNeedAddCommenParam = false;
                netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                netWork.getNetData();
            }
        }

        public b() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
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
                                if (StringUtils.isNull(a2) || !l.D()) {
                                    return;
                                }
                                d.a.j0.l.a.k(FrsTopView.this.getContext(), a2);
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
                            String x1 = a2Var.x1();
                            if (x1 == null) {
                                x1 = "";
                            }
                            if (a2Var.x0() == 2 && !x1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                UrlManager.getInstance().dealOneLink(FrsTopView.this.getTbPageContext(), new String[]{x1, "", null});
                                return;
                            }
                            if (x1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && !TextUtils.isEmpty(x1) && x1.length() > 3) {
                                a2Var.G3(x1.substring(3));
                            }
                            if (bdUniqueId.getId() == a2.B3.getId()) {
                                d.a.k0.q0.n2.l.c(a2Var.o1());
                            } else if (bdUniqueId.getId() == a2.k3.getId()) {
                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                statisticItem.param("obj_type", "2");
                                statisticItem.param("tid", a2Var.x1());
                                TiebaStatic.log(statisticItem);
                            }
                            FrsTopView frsTopView = FrsTopView.this;
                            frsTopView.e(frsTopView.getFragmentActivity(), a2Var, i2, z);
                            if (FrsTopView.this.q != null) {
                                FrsTopView.this.q.a(a2Var);
                            }
                        }
                    }
                }
            } else if (nVar == null || !(nVar instanceof p)) {
            } else {
                FrsTopView.this.k(((p) nVar).c());
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

    public void e(BaseFragmentActivity baseFragmentActivity, a2 a2Var, int i2, boolean z) {
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
        if (a2Var.A0() > 0 && d.a.k0.d3.n0.e.c()) {
            createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(a2Var.x1(), String.valueOf(a2Var.A0()), false, true, "frs_page");
        } else {
            createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(a2Var, this.f15864h, "frs_page", 18003, true, false, z);
        }
        if (i2 == 4) {
            createFromThreadCfg.setVideo_source("floor5");
        } else {
            createFromThreadCfg.setVideo_source("frs");
        }
        createFromThreadCfg.setFromSmartFrs(a2Var.v2());
        createFromThreadCfg.setSmartFrsPosition(i2);
        createFromThreadCfg.setForumId(valueOf);
        createFromThreadCfg.setFromForumId(str);
        createFromThreadCfg.setStartFrom(3);
        createFromThreadCfg.setFrom("from_frs");
        if (a2Var.f2() && createFromThreadCfg.getIntent() != null) {
            createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
        }
        baseFragmentActivity.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public final void f() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_top_view_layout, (ViewGroup) this, true);
        this.f15861e = (FrsFoldingView) findViewById(R.id.frs_folding_layout);
    }

    public final void g() {
        AdapterLinearLayout adapterLinearLayout = new AdapterLinearLayout(getContext());
        adapterLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        adapterLinearLayout.setOrientation(1);
        e eVar = new e(getContext());
        eVar.s(this.f15865i, this.f15864h, this.f15863g);
        eVar.t(this.f15862f);
        eVar.q(this.j);
        String str = this.l;
        if (str != null) {
            eVar.u(str);
        }
        int i2 = this.k;
        if (i2 != 0) {
            eVar.w(i2);
        }
        adapterLinearLayout.setAdapter(eVar);
        this.m.add(adapterLinearLayout);
        this.n.add(eVar);
    }

    public d.a.k0.q0.j2.b getStatisticMetaData() {
        return this.s;
    }

    public List<View> getmTopViews() {
        List<View> list = this.m;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.m;
    }

    public void h(int i2) {
        for (e eVar : this.n) {
            eVar.notifyDataSetChanged();
        }
        FrsFoldingView frsFoldingView = this.f15861e;
        if (frsFoldingView != null) {
            frsFoldingView.k();
        }
    }

    public void i(int i2) {
        e eVar;
        if (i2 == -1 || this.n.size() <= i2 || (eVar = this.n.get(0)) == null) {
            return;
        }
        new ArrayList();
        List<n> n = eVar.n();
        if (n == null || n.size() <= i2 || !(n.get(i2) instanceof p)) {
            return;
        }
        p pVar = (p) n.get(i2);
        if (pVar != null) {
            ForumRuleStatus.Builder builder = new ForumRuleStatus.Builder();
            builder.has_forum_rule = pVar.c().has_forum_rule;
            builder.forum_rule_id = pVar.c().forum_rule_id;
            builder.title = pVar.c().title;
            builder.audit_status = 1;
            pVar.e(builder.build(true));
        }
        eVar.r(n);
        eVar.notifyDataSetChanged();
    }

    public final void j() {
        if (ListUtils.isEmpty(this.m)) {
            return;
        }
        setVisibility(0);
        FrsFoldingView frsFoldingView = this.f15861e;
        if (frsFoldingView != null) {
            frsFoldingView.setViews(this.m, this.n);
        }
    }

    public final void k(ForumRuleStatus forumRuleStatus) {
        if (forumRuleStatus == null || this.f15863g == null || this.f15862f == null) {
            return;
        }
        int i2 = 1;
        if ((d.a.c.a.b.f().h("ForumRulesEditActivity") || d.h().k()) && this.f15863g.getIs_manager() == 1) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921518, ""));
            return;
        }
        if (this.f15863g.getIs_manager() == 1 && forumRuleStatus.has_forum_rule.intValue() == 0 && forumRuleStatus.audit_status.intValue() == 0) {
            Context context = getContext();
            String str = this.f15865i;
            String str2 = this.f15864h;
            ForumData forumData = this.f15862f;
            String image_url = forumData != null ? forumData.getImage_url() : "";
            ForumData forumData2 = this.f15862f;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRuleEditActivityConfig(context, str, str2, ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS, image_url, forumData2 != null ? forumData2.getUser_level() : 0, 25052)));
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(getContext(), this.f15865i, "")));
        }
        StatisticItem statisticItem = new StatisticItem("c14027");
        statisticItem.param("fid", this.f15865i);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.f15863g.getIs_manager() != 1) {
            if (this.f15863g.getIs_manager() == 2) {
                i2 = 2;
            } else {
                i2 = this.f15862f.isLike() == 1 ? 3 : 4;
            }
        }
        statisticItem.param("obj_type", i2);
        TiebaStatic.log(statisticItem);
    }

    public void setDatas(List<n> list, i iVar) {
        this.o.clear();
        this.n.clear();
        this.m.clear();
        if (ListUtils.isEmpty(list)) {
            setVisibility(8);
            return;
        }
        if (!ListUtils.isEmpty(list)) {
            if (list.size() > 6) {
                list = list.subList(0, 6);
            }
            this.o.addAll(list);
            int i2 = this.o.size() <= 2 ? 1 : 2;
            for (int i3 = 0; i3 < i2; i3++) {
                g();
                e eVar = this.n.get(i3);
                if (eVar != null) {
                    if (this.p == null) {
                        this.p = new b();
                    }
                    eVar.v(this.p);
                    List<n> list2 = this.o;
                    eVar.r(list2.subList(i3 * 2, Math.min((i3 * 4) + 2, list2.size())));
                }
            }
        }
        if (this.r == null && this.m != null) {
            this.r = new ArrayList<>(Collections.nCopies(this.m.size(), Boolean.FALSE));
        }
        j();
    }

    public void setForum(String str, String str2, ForumData forumData, UserData userData, String str3) {
        this.f15865i = str;
        this.f15864h = str2;
        this.f15862f = forumData;
        this.f15863g = userData;
    }

    public void setFragmentUniqueId(BdUniqueId bdUniqueId) {
        this.j = bdUniqueId;
    }

    public void setStatListener(y0 y0Var) {
        this.q = y0Var;
    }

    public void setUrlAndColor(String str, int i2) {
        this.k = i2;
        for (e eVar : this.n) {
            if (str != null) {
                eVar.u(str);
                this.l = str;
            }
            eVar.w(i2);
            eVar.notifyDataSetChanged();
        }
    }

    public FrsTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15864h = "";
        this.f15865i = "";
        this.k = 0;
        this.l = null;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.s = new d.a.k0.q0.j2.b();
        f();
    }
}
