package com.baidu.tieba.frs.vc;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
import c.a.d.n.e.v;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.u;
import c.a.s0.y.d;
import c.a.t0.e1.d3.e;
import c.a.t0.e1.f1;
import c.a.t0.e1.g1;
import c.a.t0.e1.y0;
import c.a.t0.e1.z2.q;
import c.a.t0.x3.i;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.view.AdapterLinearLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tbclient.ForumRuleStatus;
/* loaded from: classes12.dex */
public class FrsTopView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrsFoldingView f43772e;

    /* renamed from: f  reason: collision with root package name */
    public ForumData f43773f;

    /* renamed from: g  reason: collision with root package name */
    public UserData f43774g;

    /* renamed from: h  reason: collision with root package name */
    public String f43775h;

    /* renamed from: i  reason: collision with root package name */
    public String f43776i;

    /* renamed from: j  reason: collision with root package name */
    public BdUniqueId f43777j;
    public int k;
    public String l;
    public List<View> m;
    public List<e> n;
    public List<n> o;
    public v p;
    public y0 q;
    public ArrayList<Boolean> r;
    public c.a.t0.e1.w2.b s;

    /* loaded from: classes12.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes12.dex */
    public final class b implements v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTopView f43778e;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43779e;

            public a(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f43779e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.f43779e);
                    netWork.getNetContext().getRequest().mIsNeedAddCommenParam = false;
                    netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                    netWork.getNetData();
                }
            }
        }

        public b(FrsTopView frsTopView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTopView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43778e = frsTopView;
        }

        @Override // c.a.d.n.e.v
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || bdUniqueId == null) {
                return;
            }
            if (nVar != null && (nVar instanceof e2)) {
                e2 e2Var = (e2) nVar;
                if (e2Var.E() == null || e2Var.E().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.f43778e.getContext())) {
                    if (e2Var.w() != 1 || ViewHelper.checkUpIsLogin(this.f43778e.getContext())) {
                        if (e2Var.G() != null) {
                            if (ViewHelper.checkUpIsLogin(this.f43778e.getContext())) {
                                String a2 = e2Var.G().a();
                                if (StringUtils.isNull(a2) || !c.a.d.f.p.n.C()) {
                                    return;
                                }
                                c.a.s0.m.a.l(this.f43778e.getContext(), a2);
                            }
                        } else if (e2Var.M() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                ViewHelper.skipToLoginActivity(this.f43778e.getTbPageContext().getPageActivity());
                                return;
                            }
                            u M = e2Var.M();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.f43778e.getTbPageContext().getPageActivity(), M.a(), M.b(), 2)));
                        } else {
                            String z2 = e2Var.z();
                            if (z2 == null || z2.equals("")) {
                                z = false;
                            } else {
                                new Thread(new a(this, z2)).start();
                                z = true;
                            }
                            String w1 = e2Var.w1();
                            if (w1 == null) {
                                w1 = "";
                            }
                            if (e2Var.t0() == 2 && !w1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                UrlManager.getInstance().dealOneLink(this.f43778e.getTbPageContext(), new String[]{w1, "", null});
                                return;
                            }
                            if (w1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && !TextUtils.isEmpty(w1) && w1.length() > 3) {
                                e2Var.T3(w1.substring(3));
                            }
                            if (bdUniqueId.getId() == e2.c4.getId()) {
                                q.c(e2Var.n1());
                            } else if (bdUniqueId.getId() == e2.M3.getId()) {
                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                statisticItem.param("obj_type", "2");
                                statisticItem.param("tid", e2Var.w1());
                                TiebaStatic.log(statisticItem);
                            }
                            FrsTopView frsTopView = this.f43778e;
                            frsTopView.gotoPBActivity(frsTopView.getFragmentActivity(), e2Var, i2, z);
                            if (this.f43778e.q != null) {
                                this.f43778e.q.a(e2Var);
                            }
                        }
                    }
                }
            } else if (nVar == null || !(nVar instanceof c.a.t0.x3.q)) {
            } else {
                this.f43778e.h(((c.a.t0.x3.q) nVar).a());
            }
        }

        public /* synthetic */ b(FrsTopView frsTopView, a aVar) {
            this(frsTopView);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsTopView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseFragmentActivity getFragmentActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (getContext() instanceof BaseFragmentActivity) {
                return (BaseFragmentActivity) getContext();
            }
            return null;
        }
        return (BaseFragmentActivity) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getTbPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (getContext() instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) getContext()).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(g1.frs_top_view_layout, (ViewGroup) this, true);
            this.f43772e = (FrsFoldingView) findViewById(f1.frs_folding_layout);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            AdapterLinearLayout adapterLinearLayout = new AdapterLinearLayout(getContext());
            adapterLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            adapterLinearLayout.setOrientation(1);
            e eVar = new e(getContext());
            eVar.s(this.f43776i, this.f43775h, this.f43774g);
            eVar.t(this.f43773f);
            eVar.q(this.f43777j);
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
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || ListUtils.isEmpty(this.m)) {
            return;
        }
        setVisibility(0);
        FrsFoldingView frsFoldingView = this.f43772e;
        if (frsFoldingView != null) {
            frsFoldingView.setViews(this.m, this.n);
        }
    }

    public c.a.t0.e1.w2.b getStatisticMetaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.s : (c.a.t0.e1.w2.b) invokeV.objValue;
    }

    public List<View> getmTopViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<View> list = this.m;
            if (list == null || list.size() == 0) {
                return null;
            }
            return this.m;
        }
        return (List) invokeV.objValue;
    }

    public void gotoPBActivity(BaseFragmentActivity baseFragmentActivity, e2 e2Var, int i2, boolean z) {
        PbActivityConfig createFromThreadCfg;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{baseFragmentActivity, e2Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || baseFragmentActivity == null || e2Var == null) {
            return;
        }
        String str = null;
        String valueOf = String.valueOf(e2Var.U());
        OriginalForumInfo originalForumInfo = e2Var.J1;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            str = valueOf;
        }
        if (e2Var.w0() > 0 && c.a.t0.x3.p0.e.c()) {
            createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(e2Var.w1(), String.valueOf(e2Var.w0()), false, true, FrsFragment.STAR_FRS);
        } else {
            createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(e2Var, this.f43775h, FrsFragment.STAR_FRS, 18003, true, false, z);
        }
        if (i2 == 4) {
            createFromThreadCfg.setVideo_source("floor5");
        } else {
            createFromThreadCfg.setVideo_source("frs");
        }
        createFromThreadCfg.setFromSmartFrs(e2Var.B2());
        createFromThreadCfg.setSmartFrsPosition(i2);
        createFromThreadCfg.setForumId(valueOf);
        createFromThreadCfg.setFromForumId(str);
        createFromThreadCfg.setStartFrom(3);
        createFromThreadCfg.setFrom("from_frs");
        if (e2Var.h2() && createFromThreadCfg.getIntent() != null) {
            createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
        }
        baseFragmentActivity.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public final void h(ForumRuleStatus forumRuleStatus) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, forumRuleStatus) == null) || forumRuleStatus == null || this.f43774g == null || this.f43773f == null) {
            return;
        }
        int i2 = 1;
        if ((c.a.d.a.b.f().h("ForumRulesEditActivity") || d.h().k()) && this.f43774g.getIs_manager() == 1) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921518, ""));
            return;
        }
        if (this.f43774g.getIs_manager() == 1 && forumRuleStatus.has_forum_rule.intValue() == 0 && forumRuleStatus.audit_status.intValue() == 0) {
            Context context = getContext();
            String str = this.f43776i;
            String str2 = this.f43775h;
            ForumData forumData = this.f43773f;
            String image_url = forumData != null ? forumData.getImage_url() : "";
            ForumData forumData2 = this.f43773f;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRuleEditActivityConfig(context, str, str2, ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS, image_url, forumData2 != null ? forumData2.getUser_level() : 0, 25052)));
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(getContext(), this.f43776i, "")));
        }
        StatisticItem statisticItem = new StatisticItem("c14027");
        statisticItem.param("fid", this.f43776i);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.f43774g.getIs_manager() != 1) {
            if (this.f43774g.getIs_manager() == 2) {
                i2 = 2;
            } else {
                i2 = this.f43773f.isLike() == 1 ? 3 : 4;
            }
        }
        statisticItem.param("obj_type", i2);
        TiebaStatic.log(statisticItem);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            for (e eVar : this.n) {
                eVar.notifyDataSetChanged();
            }
            FrsFoldingView frsFoldingView = this.f43772e;
            if (frsFoldingView != null) {
                frsFoldingView.onChangeSkinType();
            }
        }
    }

    public void refrshRuleStatus(int i2) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || i2 == -1 || this.n.size() <= i2 || (eVar = this.n.get(0)) == null) {
            return;
        }
        new ArrayList();
        List<n> n = eVar.n();
        if (n == null || n.size() <= i2 || !(n.get(i2) instanceof c.a.t0.x3.q)) {
            return;
        }
        c.a.t0.x3.q qVar = (c.a.t0.x3.q) n.get(i2);
        if (qVar != null) {
            ForumRuleStatus.Builder builder = new ForumRuleStatus.Builder();
            builder.has_forum_rule = qVar.a().has_forum_rule;
            builder.title = qVar.a().title;
            builder.audit_status = 1;
            qVar.d(builder.build(true));
        }
        eVar.r(n);
        eVar.notifyDataSetChanged();
    }

    public void setDatas(List<n> list, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, list, iVar) == null) {
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
                    f();
                    e eVar = this.n.get(i3);
                    if (eVar != null) {
                        if (this.p == null) {
                            this.p = new b(this, null);
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
            g();
        }
    }

    public void setForum(String str, String str2, ForumData forumData, UserData userData, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048586, this, str, str2, forumData, userData, str3) == null) {
            this.f43776i = str;
            this.f43775h = str2;
            this.f43773f = forumData;
            this.f43774g = userData;
        }
    }

    public void setFragmentUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bdUniqueId) == null) {
            this.f43777j = bdUniqueId;
        }
    }

    public void setStatListener(y0 y0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, y0Var) == null) {
            this.q = y0Var;
        }
    }

    public void setUrlAndColor(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, str, i2) == null) {
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
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsTopView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f43775h = "";
        this.f43776i = "";
        this.k = 0;
        this.l = null;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.s = new c.a.t0.e1.w2.b();
        e();
    }
}
