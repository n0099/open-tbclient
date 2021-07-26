package com.baidu.tieba.frs.vc;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tieba.R;
import com.baidu.tieba.view.AdapterLinearLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.d.k.e.n;
import d.a.d.k.e.w;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.u;
import d.a.p0.y.d;
import d.a.q0.h3.i;
import d.a.q0.h3.p;
import d.a.q0.u0.r2.e;
import d.a.q0.u0.x0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tbclient.ForumRuleStatus;
/* loaded from: classes4.dex */
public class FrsTopView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrsFoldingView f16141e;

    /* renamed from: f  reason: collision with root package name */
    public ForumData f16142f;

    /* renamed from: g  reason: collision with root package name */
    public UserData f16143g;

    /* renamed from: h  reason: collision with root package name */
    public String f16144h;

    /* renamed from: i  reason: collision with root package name */
    public String f16145i;
    public BdUniqueId j;
    public int k;
    public String l;
    public List<View> m;
    public List<e> n;
    public List<n> o;
    public w p;
    public x0 q;
    public ArrayList<Boolean> r;
    public d.a.q0.u0.j2.b s;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public final class b implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTopView f16146e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f16147e;

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
                this.f16147e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.f16147e);
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
            this.f16146e = frsTopView;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) || bdUniqueId == null) {
                return;
            }
            if (nVar != null && (nVar instanceof b2)) {
                b2 b2Var = (b2) nVar;
                if (b2Var.C() == null || b2Var.C().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.f16146e.getContext())) {
                    if (b2Var.q() != 1 || ViewHelper.checkUpIsLogin(this.f16146e.getContext())) {
                        if (b2Var.E() != null) {
                            if (ViewHelper.checkUpIsLogin(this.f16146e.getContext())) {
                                String a2 = b2Var.E().a();
                                if (StringUtils.isNull(a2) || !l.D()) {
                                    return;
                                }
                                d.a.p0.m.a.k(this.f16146e.getContext(), a2);
                            }
                        } else if (b2Var.K() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                ViewHelper.skipToLoginActivity(this.f16146e.getTbPageContext().getPageActivity());
                                return;
                            }
                            u K = b2Var.K();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.f16146e.getTbPageContext().getPageActivity(), K.a(), K.b(), 2)));
                        } else {
                            String x = b2Var.x();
                            if (x == null || x.equals("")) {
                                z = false;
                            } else {
                                new Thread(new a(this, x)).start();
                                z = true;
                            }
                            String o1 = b2Var.o1();
                            if (o1 == null) {
                                o1 = "";
                            }
                            if (b2Var.n0() == 2 && !o1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                UrlManager.getInstance().dealOneLink(this.f16146e.getTbPageContext(), new String[]{o1, "", null});
                                return;
                            }
                            if (o1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && !TextUtils.isEmpty(o1) && o1.length() > 3) {
                                b2Var.y3(o1.substring(3));
                            }
                            if (bdUniqueId.getId() == b2.N3.getId()) {
                                d.a.q0.u0.n2.l.c(b2Var.f1());
                            } else if (bdUniqueId.getId() == b2.w3.getId()) {
                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                statisticItem.param("obj_type", "2");
                                statisticItem.param("tid", b2Var.o1());
                                TiebaStatic.log(statisticItem);
                            }
                            FrsTopView frsTopView = this.f16146e;
                            frsTopView.e(frsTopView.getFragmentActivity(), b2Var, i2, z);
                            if (this.f16146e.q != null) {
                                this.f16146e.q.a(b2Var);
                            }
                        }
                    }
                }
            } else if (nVar == null || !(nVar instanceof p)) {
            } else {
                this.f16146e.k(((p) nVar).b());
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

    public void e(BaseFragmentActivity baseFragmentActivity, b2 b2Var, int i2, boolean z) {
        PbActivityConfig createFromThreadCfg;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{baseFragmentActivity, b2Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || baseFragmentActivity == null || b2Var == null) {
            return;
        }
        String str = null;
        String valueOf = String.valueOf(b2Var.R());
        OriginalForumInfo originalForumInfo = b2Var.F1;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            str = valueOf;
        }
        if (b2Var.q0() > 0 && d.a.q0.h3.n0.e.c()) {
            createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(b2Var.o1(), String.valueOf(b2Var.q0()), false, true, "frs_page");
        } else {
            createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(b2Var, this.f16144h, "frs_page", 18003, true, false, z);
        }
        if (i2 == 4) {
            createFromThreadCfg.setVideo_source("floor5");
        } else {
            createFromThreadCfg.setVideo_source("frs");
        }
        createFromThreadCfg.setFromSmartFrs(b2Var.l2());
        createFromThreadCfg.setSmartFrsPosition(i2);
        createFromThreadCfg.setForumId(valueOf);
        createFromThreadCfg.setFromForumId(str);
        createFromThreadCfg.setStartFrom(3);
        createFromThreadCfg.setFrom("from_frs");
        if (b2Var.V1() && createFromThreadCfg.getIntent() != null) {
            createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
        }
        baseFragmentActivity.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.frs_top_view_layout, (ViewGroup) this, true);
            this.f16141e = (FrsFoldingView) findViewById(R.id.frs_folding_layout);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AdapterLinearLayout adapterLinearLayout = new AdapterLinearLayout(getContext());
            adapterLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            adapterLinearLayout.setOrientation(1);
            e eVar = new e(getContext());
            eVar.s(this.f16145i, this.f16144h, this.f16143g);
            eVar.t(this.f16142f);
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
    }

    public d.a.q0.u0.j2.b getStatisticMetaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.s : (d.a.q0.u0.j2.b) invokeV.objValue;
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

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            for (e eVar : this.n) {
                eVar.notifyDataSetChanged();
            }
            FrsFoldingView frsFoldingView = this.f16141e;
            if (frsFoldingView != null) {
                frsFoldingView.k();
            }
        }
    }

    public void i(int i2) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || i2 == -1 || this.n.size() <= i2 || (eVar = this.n.get(0)) == null) {
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
            builder.has_forum_rule = pVar.b().has_forum_rule;
            builder.forum_rule_id = pVar.b().forum_rule_id;
            builder.title = pVar.b().title;
            builder.audit_status = 1;
            pVar.c(builder.build(true));
        }
        eVar.r(n);
        eVar.notifyDataSetChanged();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.m)) {
            return;
        }
        setVisibility(0);
        FrsFoldingView frsFoldingView = this.f16141e;
        if (frsFoldingView != null) {
            frsFoldingView.setViews(this.m, this.n);
        }
    }

    public final void k(ForumRuleStatus forumRuleStatus) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, forumRuleStatus) == null) || forumRuleStatus == null || this.f16143g == null || this.f16142f == null) {
            return;
        }
        int i2 = 1;
        if ((d.a.d.a.b.f().h("ForumRulesEditActivity") || d.h().k()) && this.f16143g.getIs_manager() == 1) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921518, ""));
            return;
        }
        if (this.f16143g.getIs_manager() == 1 && forumRuleStatus.has_forum_rule.intValue() == 0 && forumRuleStatus.audit_status.intValue() == 0) {
            Context context = getContext();
            String str = this.f16145i;
            String str2 = this.f16144h;
            ForumData forumData = this.f16142f;
            String image_url = forumData != null ? forumData.getImage_url() : "";
            ForumData forumData2 = this.f16142f;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRuleEditActivityConfig(context, str, str2, ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS, image_url, forumData2 != null ? forumData2.getUser_level() : 0, 25052)));
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(getContext(), this.f16145i, "")));
        }
        StatisticItem statisticItem = new StatisticItem("c14027");
        statisticItem.param("fid", this.f16145i);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.f16143g.getIs_manager() != 1) {
            if (this.f16143g.getIs_manager() == 2) {
                i2 = 2;
            } else {
                i2 = this.f16142f.isLike() == 1 ? 3 : 4;
            }
        }
        statisticItem.param("obj_type", i2);
        TiebaStatic.log(statisticItem);
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
                    g();
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
            j();
        }
    }

    public void setForum(String str, String str2, ForumData forumData, UserData userData, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048586, this, str, str2, forumData, userData, str3) == null) {
            this.f16145i = str;
            this.f16144h = str2;
            this.f16142f = forumData;
            this.f16143g = userData;
        }
    }

    public void setFragmentUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bdUniqueId) == null) {
            this.j = bdUniqueId;
        }
    }

    public void setStatListener(x0 x0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, x0Var) == null) {
            this.q = x0Var;
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
        this.f16144h = "";
        this.f16145i = "";
        this.k = 0;
        this.l = null;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.s = new d.a.q0.u0.j2.b();
        f();
    }
}
