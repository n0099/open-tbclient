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
import com.baidu.tbadk.core.atomData.FrsVideoTabPlayActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
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
import com.baidu.tieba.c25;
import com.baidu.tieba.cx9;
import com.baidu.tieba.er7;
import com.baidu.tieba.es7;
import com.baidu.tieba.fo;
import com.baidu.tieba.g9;
import com.baidu.tieba.ks6;
import com.baidu.tieba.mo7;
import com.baidu.tieba.mz9;
import com.baidu.tieba.qk5;
import com.baidu.tieba.qx4;
import com.baidu.tieba.sw5;
import com.baidu.tieba.tw9;
import com.baidu.tieba.vi;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.view.AdapterLinearLayout;
import com.baidu.tieba.vn;
import com.baidu.tieba.ye7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tbclient.ForumRuleStatus;
/* loaded from: classes5.dex */
public class FrsTopView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFoldingView a;
    public ForumData b;
    public UserData c;
    public String d;
    public String e;
    public BdUniqueId f;
    public int g;
    public String h;
    public List<View> i;
    public List<es7> j;
    public List<vn> k;
    public fo l;
    public ye7 m;
    public ArrayList<Boolean> n;
    public mo7 o;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public final class b implements fo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTopView a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            public a(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.a);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTopView;
        }

        public /* synthetic */ b(FrsTopView frsTopView, a aVar) {
            this(frsTopView);
        }

        @Override // com.baidu.tieba.fo
        public void b(View view2, vn vnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, vnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || bdUniqueId == null) {
                return;
            }
            if (vnVar != null && (vnVar instanceof ThreadData)) {
                ThreadData threadData = (ThreadData) vnVar;
                if (threadData.getAnchorInfoData() != null && threadData.getAnchorInfoData().getGroup_id() != 0 && !ViewHelper.checkUpIsLogin(this.a.getContext())) {
                    return;
                }
                if (threadData.getActInfoType() == 1 && !ViewHelper.checkUpIsLogin(this.a.getContext())) {
                    return;
                }
                if (threadData.getAppCodeData() != null) {
                    if (!ViewHelper.checkUpIsLogin(this.a.getContext())) {
                        return;
                    }
                    String a2 = threadData.getAppCodeData().a();
                    if (!StringUtils.isNull(a2) && vi.F()) {
                        qx4.q(this.a.getContext(), a2);
                    }
                } else if (threadData.getCartoonThreadData() != null) {
                    if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        ViewHelper.skipToLoginActivity(this.a.getTbPageContext().getPageActivity());
                        return;
                    }
                    c25 cartoonThreadData = threadData.getCartoonThreadData();
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.a.getTbPageContext().getPageActivity(), cartoonThreadData.a(), cartoonThreadData.b(), 2)));
                } else {
                    String ad_url = threadData.getAd_url();
                    if (ad_url != null && !ad_url.equals("")) {
                        ks6.a(new a(this, ad_url), "requestFrsTop", 3);
                        z = true;
                    } else {
                        z = false;
                    }
                    String tid = threadData.getTid();
                    if (tid == null) {
                        tid = "";
                    }
                    if (threadData.getIs_top() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        UrlManager.getInstance().dealOneLink(this.a.getTbPageContext(), new String[]{tid, "", null});
                        return;
                    }
                    if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && !TextUtils.isEmpty(tid) && tid.length() > 3) {
                        threadData.setId(tid.substring(3));
                    }
                    if (bdUniqueId.getId() == ThreadData.TYPE_STAR_INTERVIEW.getId()) {
                        er7.c(threadData.getTaskInfoData());
                    } else if (bdUniqueId.getId() == ThreadData.TYPE_SHARE_THREAD.getId()) {
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        statisticItem.param("obj_type", "2");
                        statisticItem.param("tid", threadData.getTid());
                        TiebaStatic.log(statisticItem);
                    }
                    FrsTopView frsTopView = this.a;
                    frsTopView.e(frsTopView.getFragmentActivity(), threadData, i, z);
                    if (this.a.m != null) {
                        this.a.m.a(threadData);
                    }
                }
            } else if (vnVar == null || !(vnVar instanceof cx9)) {
            } else {
                this.a.k(((cx9) vnVar).a());
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = "";
        this.e = "";
        this.g = 0;
        this.h = null;
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.o = new mo7();
        f();
    }

    public void l(Context context, ThreadData threadData, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048585, this, context, threadData, i) != null) || threadData == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.buildWithThreadData(threadData);
        arrayList.add(videoItemData);
        String str = null;
        if (threadData.getBaijiahaoData() != null) {
            str = threadData.getBaijiahaoData().oriUgcNid;
        }
        OriginalThreadInfo originalThreadInfo = threadData.originalThreadData;
        boolean z2 = true;
        if (originalThreadInfo != null && originalThreadInfo.r != null) {
            if (threadData.getThreadData().originalThreadData.r.is_vertical.intValue() != 1) {
                z2 = false;
            }
            z = z2;
        } else {
            z = true;
        }
        sw5.e(context, arrayList, str, z, i, null, FrsVideoTabPlayActivityConfig.FROM_FRS_VIDEO_TOP, "frs_page", "", FrsVideoTabPlayActivityConfig.FROM_FRS_VIDEO_TOP, FrsVideoTabPlayActivityConfig.FROM_FRS_VIDEO_TOP, false, true, true, threadData.getFid());
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            for (es7 es7Var : this.j) {
                es7Var.notifyDataSetChanged();
            }
            FrsFoldingView frsFoldingView = this.a;
            if (frsFoldingView != null) {
                frsFoldingView.k();
            }
        }
    }

    public void setFragmentUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bdUniqueId) == null) {
            this.f = bdUniqueId;
        }
    }

    public void setStatListener(ye7 ye7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, ye7Var) == null) {
            this.m = ye7Var;
        }
    }

    public void setUrlAndColor(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, str, i) == null) {
            this.g = i;
            for (es7 es7Var : this.j) {
                if (str != null) {
                    es7Var.u(str);
                    this.h = str;
                }
                es7Var.w(i);
                es7Var.notifyDataSetChanged();
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

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0395, (ViewGroup) this, true);
            this.a = (FrsFoldingView) findViewById(R.id.obfuscated_res_0x7f090c62);
        }
    }

    public mo7 getStatisticMetaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.o;
        }
        return (mo7) invokeV.objValue;
    }

    public List<View> getmTopViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<View> list = this.i;
            if (list != null && list.size() != 0) {
                return this.i;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || ListUtils.isEmpty(this.i)) {
            return;
        }
        setVisibility(0);
        FrsFoldingView frsFoldingView = this.a;
        if (frsFoldingView != null) {
            frsFoldingView.setViews(this.i, this.j);
        }
    }

    public void e(BaseFragmentActivity baseFragmentActivity, ThreadData threadData, int i, boolean z) {
        PbActivityConfig createFromThreadCfg;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{baseFragmentActivity, threadData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && baseFragmentActivity != null && threadData != null) {
            String str = null;
            String valueOf = String.valueOf(threadData.getFid());
            OriginalForumInfo originalForumInfo = threadData.mOriginalForumInfo;
            if (originalForumInfo != null) {
                valueOf = originalForumInfo.id;
                str = valueOf;
            }
            if (threadData.getLastReadPid() > 0 && mz9.c()) {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(threadData.getTid(), String.valueOf(threadData.getLastReadPid()), false, true, "frs_page");
            } else if (threadData.getThreadType() == 40) {
                l(getTbPageContext().getContext(), threadData, i);
                return;
            } else {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(threadData, this.d, "frs_page", 18003, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source("floor5");
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(threadData.isSmartFrsThread());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(valueOf);
            createFromThreadCfg.setFromForumId(str);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (threadData.isInterviewLiveStyle() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            baseFragmentActivity.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AdapterLinearLayout adapterLinearLayout = new AdapterLinearLayout(getContext());
            adapterLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            adapterLinearLayout.setOrientation(1);
            es7 es7Var = new es7(getContext());
            es7Var.s(this.e, this.d, this.c);
            es7Var.t(this.b);
            es7Var.q(this.f);
            String str = this.h;
            if (str != null) {
                es7Var.u(str);
            }
            int i = this.g;
            if (i != 0) {
                es7Var.w(i);
            }
            adapterLinearLayout.setAdapter(es7Var);
            this.i.add(adapterLinearLayout);
            this.j.add(es7Var);
        }
    }

    public void i(int i) {
        es7 es7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || i == -1 || this.j.size() <= i || (es7Var = this.j.get(0)) == null) {
            return;
        }
        new ArrayList();
        List<vn> n = es7Var.n();
        if (n != null && n.size() > i && (n.get(i) instanceof cx9)) {
            cx9 cx9Var = (cx9) n.get(i);
            if (cx9Var != null) {
                ForumRuleStatus.Builder builder = new ForumRuleStatus.Builder();
                builder.has_forum_rule = cx9Var.a().has_forum_rule;
                builder.title = cx9Var.a().title;
                builder.audit_status = 1;
                cx9Var.b(builder.build(true));
            }
            es7Var.r(n);
            es7Var.notifyDataSetChanged();
        }
    }

    public final void k(ForumRuleStatus forumRuleStatus) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, forumRuleStatus) == null) && forumRuleStatus != null && this.c != null && this.b != null) {
            String str = "";
            int i2 = 1;
            if ((g9.f().h("ForumRulesEditActivity") || qk5.h().k()) && this.c.getIs_manager() == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921518, ""));
                return;
            }
            if (this.c.getIs_manager() == 1 && forumRuleStatus.has_forum_rule.intValue() == 0 && forumRuleStatus.audit_status.intValue() == 0) {
                Context context = getContext();
                String str2 = this.e;
                String str3 = this.d;
                ForumData forumData = this.b;
                if (forumData != null) {
                    str = forumData.getImage_url();
                }
                String str4 = str;
                ForumData forumData2 = this.b;
                if (forumData2 != null) {
                    i = forumData2.getUser_level();
                } else {
                    i = 0;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRuleEditActivityConfig(context, str2, str3, ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS, str4, i, 25052)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(getContext(), this.e, "")));
            }
            StatisticItem statisticItem = new StatisticItem("c14027");
            statisticItem.param("fid", this.e);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (this.c.getIs_manager() != 1) {
                if (this.c.getIs_manager() == 2) {
                    i2 = 2;
                } else if (this.b.isLike() == 1) {
                    i2 = 3;
                } else {
                    i2 = 4;
                }
            }
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void setDatas(List<vn> list, tw9 tw9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, list, tw9Var) == null) {
            this.k.clear();
            this.j.clear();
            this.i.clear();
            if (ListUtils.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            if (!ListUtils.isEmpty(list)) {
                if (list.size() > 6) {
                    list = list.subList(0, 6);
                }
                this.k.addAll(list);
                if (this.k.size() <= 2) {
                    i = 1;
                } else {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    g();
                    es7 es7Var = this.j.get(i2);
                    if (es7Var != null) {
                        if (this.l == null) {
                            this.l = new b(this, null);
                        }
                        es7Var.v(this.l);
                        List<vn> list2 = this.k;
                        es7Var.r(new ArrayList(list2.subList(i2 * 2, Math.min((i2 * 4) + 2, list2.size()))));
                    }
                }
            }
            if (this.n == null && this.i != null) {
                this.n = new ArrayList<>(Collections.nCopies(this.i.size(), Boolean.FALSE));
            }
            j();
        }
    }

    public void setForum(String str, String str2, ForumData forumData, UserData userData, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048587, this, str, str2, forumData, userData, str3) == null) {
            this.e = str;
            this.d = str2;
            this.b = forumData;
            this.c = userData;
        }
    }
}
