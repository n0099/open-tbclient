package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.EnterForumInfoMessage;
import com.baidu.tbadk.core.message.RequestEnterForumDataMessage;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity;
import com.baidu.tieba.enterForum.message.ForumGuideHttpResponseMessage;
import com.baidu.tieba.enterForum.message.ForumGuideSocketResponseMessage;
import com.baidu.tieba.enterForum.message.SetLikeForumHttpResponseMessage;
import com.baidu.tieba.enterForum.message.SetLikeForumSocketResponseMessage;
import com.baidu.tieba.enterForum.model.EnterForumAdModel;
import com.baidu.tieba.enterForum.model.EnterForumAdResponsedMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListHttpResponsedMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListSocketResponsedMessage;
import com.baidu.tieba.jn5;
import com.baidu.tieba.k9;
import com.baidu.tieba.kb;
import com.baidu.tieba.kn5;
import com.baidu.tieba.ln5;
import com.baidu.tieba.mf;
import com.baidu.tieba.mn5;
import com.baidu.tieba.my6;
import com.baidu.tieba.nf;
import com.baidu.tieba.of;
import com.baidu.tieba.oy6;
import com.baidu.tieba.r95;
import com.baidu.tieba.rn5;
import com.baidu.tieba.sx5;
import com.baidu.tieba.tr6;
import com.baidu.tieba.uy6;
import com.baidu.tieba.v3a;
import com.baidu.tieba.v4a;
import com.baidu.tieba.view.bubbleView.BubbleLayout;
import com.baidu.tieba.ww5;
import com.baidu.tieba.wx5;
import com.baidu.tieba.xi;
import com.baidu.tieba.yg;
import com.baidu.tieba.yy6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class EnterForumDelegateStatic extends jn5 {
    public static /* synthetic */ Interceptable $ic;
    public static nf c;
    public static EnterForumModel d;
    public static EnterForumAdModel e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomResponsedMessage a;

            public a(j jVar, CustomResponsedMessage customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, customResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                EnterForumDelegateStatic.l((Activity) this.a.getData());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !TbadkCoreApplication.isLogin()) {
                return;
            }
            r95 p = r95.p();
            if (p.l("key_enter_forum_ufan_tip_show" + TbadkCoreApplication.getCurrentAccount(), false)) {
                return;
            }
            r95 p2 = r95.p();
            if (p2.q("key_enter_forum_ufan_attention_check_count" + TbadkCoreApplication.getCurrentAccount(), 0) <= 5 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Activity)) {
                yg.a().post(new a(this, customResponsedMessage));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class q implements mf {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        @Override // com.baidu.tieba.mf
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 4;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.mf
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 16;
            }
            return invokeV.intValue;
        }

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    EnterForumDelegateStatic.c.d();
                }
            }
        }

        public q(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
        }

        @Override // com.baidu.tieba.mf
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                BubbleLayout bubbleLayout = (BubbleLayout) View.inflate(this.a, R.layout.obfuscated_res_0x7f0d02b3, null);
                TextView textView = (TextView) bubbleLayout.findViewById(R.id.obfuscated_res_0x7f090a05);
                textView.setOnClickListener(new a(this));
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
                bubbleLayout.d(SkinManager.getColor(R.color.cp_link_tip_a_alpha95));
                return bubbleLayout;
            }
            return (View) invokeL.objValue;
        }

        @Override // com.baidu.tieba.mf
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (xi.i(this.a) > 0.0f) {
                    return (int) ((this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703eb) * 2) / xi.i(this.a));
                }
                return this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703eb);
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.mf
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070233) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
                if (UtilHelper.getVirtualBarHeight(this.a) > 0 || MenuKeyUtils.hasSmartBar()) {
                    dimensionPixelSize -= xi.g(this.a, R.dimen.obfuscated_res_0x7f0701d5);
                }
                if (xi.i(this.a) > 0.0f) {
                    return (int) ((dimensionPixelSize * 3) / xi.i(this.a));
                }
                return dimensionPixelSize;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class a implements mn5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public a(EnterForumDelegateStatic enterForumDelegateStatic, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumDelegateStatic, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // com.baidu.tieba.mn5.b
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return LayoutInflater.from(this.a).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements EnterForumModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.f
        public void a(EnterForumModel.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                oy6 e = eVar.d.e();
                ArrayList arrayList = new ArrayList();
                Iterator<my6> it = e.b().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().k());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new EnterForumInfoMessage(2001329, arrayList));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends k9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.k9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            }
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends kb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.kb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof ForumGuideSocketResponseMessage;
                if ((!z && !(responsedMessage instanceof ForumGuideHttpResponseMessage)) || EnterForumDelegateStatic.d.getUniqueId() != responsedMessage.getOrginalMessage().getTag() || responsedMessage.hasError()) {
                    return;
                }
                if (z) {
                    EnterForumDelegateStatic.d.l0((ForumGuideSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof ForumGuideHttpResponseMessage) {
                    EnterForumDelegateStatic.d.k0((ForumGuideHttpResponseMessage) responsedMessage);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && TbadkCoreApplication.isLogin() && (customResponsedMessage instanceof RequestEnterForumDataMessage)) {
                if (((RequestEnterForumDataMessage) customResponsedMessage).isCache()) {
                    EnterForumDelegateStatic.d.e0(true);
                } else {
                    EnterForumDelegateStatic.d.f0(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<tr6> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                return new CustomResponsedMessage<>(2016562, new yy6());
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr.length != 0 && strArr[0] != null) {
                    String lowerCase = strArr[0].toLowerCase();
                    if (lowerCase.contains("unidispatch/hotuserrank")) {
                        HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(tbPageContext.getPageActivity());
                        hotUserRankActivityConfig.setUri(Uri.parse(lowerCase));
                        tbPageContext.sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Void> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                String data = customMessage.getData();
                VisitedForumData visitedForumData = new VisitedForumData();
                visitedForumData.setForumId(data);
                uy6.n().i(visitedForumData);
                TiebaStatic.log(new StatisticItem("c13005").param("fid", data));
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            kn5 b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null) {
                return;
            }
            EnterForumDelegateStatic enterForumDelegateStatic = new EnterForumDelegateStatic();
            if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                EnterForumDelegateStatic.e.a0();
            }
            ((ln5) customResponsedMessage.getData()).a(enterForumDelegateStatic);
            if (((ln5) customResponsedMessage.getData()).getContext() == null || (b = enterForumDelegateStatic.b()) == null || b.a.isAdded()) {
                return;
            }
            b.a.setArguments(new Bundle());
        }
    }

    /* loaded from: classes5.dex */
    public static class k implements CustomMessageTask.CustomRunnable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                uy6.n().r();
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class l implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                return new CustomResponsedMessage<>(2921483, uy6.n().m());
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class m extends sx5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.sx5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                NetWork netWork = new NetWork();
                netWork.setUrl(TbConfig.SERVER_ADDRESS + "/ala/sys/liveBarConcerned");
                netWork.addPostData("uid", TbadkCoreApplication.getCurrentAccount());
                String postNetData = netWork.postNetData();
                if (netWork.isNetSuccess() && netWork.getServerErrorCode() == 0) {
                    try {
                        boolean z = false;
                        if (new JSONObject(postNetData).optInt("live_bar_concerned", 0) == 1) {
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    } catch (JSONException unused) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class n implements ww5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        public n(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ww5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, bool) != null) || !bool.booleanValue()) {
                return;
            }
            EnterForumDelegateStatic.w(this.a);
        }
    }

    /* loaded from: classes5.dex */
    public static class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && EnterForumDelegateStatic.c != null) {
                EnterForumDelegateStatic.c.d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class p implements of.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Handler a;
        public final /* synthetic */ Runnable b;

        @Override // com.baidu.tieba.of.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public p(Handler handler, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = handler;
            this.b = runnable;
        }

        @Override // com.baidu.tieba.of.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r95 p = r95.p();
                p.A("key_enter_forum_ufan_tip_show" + TbadkCoreApplication.getCurrentAccount(), true);
                nf unused = EnterForumDelegateStatic.c = null;
                this.a.removeCallbacks(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2056451033, "Lcom/baidu/tieba/enterForum/home/EnterForumDelegateStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2056451033, "Lcom/baidu/tieba/enterForum/home/EnterForumDelegateStatic;");
                return;
            }
        }
        i iVar = new i(2007002);
        iVar.setPriority(3);
        MessageManager.getInstance().registerListener(iVar);
        if (xi.E()) {
            MessageManager.getInstance().registerListener(new j(2921341));
        }
        q();
        m();
        p();
        s();
        TbadkCoreApplication.getInst().RegisterIntent(HotUserRankActivityConfig.class, HotUserRankActivity.class);
        r();
        n();
        u();
        t();
        v();
        o();
    }

    public EnterForumDelegateStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016562, new f());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            UrlManager.getInstance().addListener(new g());
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921519, new h());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            uy6.n();
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            v3a.e(CmdConfigHttp.CMD_ENTER_FORUM_AD_REQUEST, TbConfig.URL_ENTER_FORUM_AD, EnterForumAdResponsedMessage.class, false, false, true, false);
        }
    }

    public static void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            v3a.h(309651, TabFeedListSocketResponsedMessage.class, false, false);
            v3a.c(309651, CmdConfigHttp.CMD_TAB_FEED_LIST, TbConfig.URL_TAB_FEED_LIST, TabFeedListHttpResponsedMessage.class, false, false, true, false);
        }
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921483, new l());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            uy6.n();
        }
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921479, new k());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    @Override // com.baidu.tieba.jn5
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return MainTabActivityConfig.ENTER_FORUM_DELEGATE_AVAILABLE;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.jn5
    public TbFragmentTabIndicator c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) mn5.e().d(1002, new a(this, context));
            this.b = maintabBottomIndicator;
            return maintabBottomIndicator;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    public static void l(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, activity) == null) {
            r95 p2 = r95.p();
            int q2 = p2.q("key_enter_forum_ufan_attention_check_count" + TbadkCoreApplication.getCurrentAccount(), 0);
            r95 p3 = r95.p();
            p3.q("key_enter_forum_ufan_attention_check_count" + TbadkCoreApplication.getCurrentAccount(), q2 + 1);
            wx5.b(new m(), new n(activity));
        }
    }

    public static void w(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, activity) == null) {
            nf nfVar = c;
            if (nfVar != null) {
                nfVar.d();
            }
            Handler handler = new Handler();
            o oVar = new o();
            of ofVar = new of();
            ofVar.d(true);
            ofVar.h(new p(handler, oVar));
            ofVar.k(activity.getWindow().getDecorView());
            ofVar.c(20);
            ofVar.j(false);
            ofVar.a(new q(activity));
            nf b2 = ofVar.b();
            c = b2;
            b2.m(activity);
            handler.postDelayed(oVar, 5000L);
        }
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            v4a.d();
            if (d == null) {
                EnterForumModel enterForumModel = new EnterForumModel(null);
                d = enterForumModel;
                enterForumModel.s0(new b());
            }
            if (e == null) {
                EnterForumAdModel enterForumAdModel = new EnterForumAdModel();
                e = enterForumAdModel;
                enterForumAdModel.setLoadDataCallBack(new c());
            }
            MessageManager.getInstance().registerListener(new d(CmdConfigHttp.CMD_ENTER_FORUM_DATA, 309683));
            MessageManager.getInstance().registerListener(new e(2001323));
        }
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            v3a.h(303011, forumRecommendSocketResponseMessage.class, false, false);
            v3a.c(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
            v3a.h(309683, ForumGuideSocketResponseMessage.class, false, false);
            v3a.c(309683, CmdConfigHttp.CMD_ENTER_FORUM_DATA, "c/f/forum/forumGuide", ForumGuideHttpResponseMessage.class, false, false, true, false);
            v3a.h(309685, SetLikeForumSocketResponseMessage.class, false, false);
            v3a.c(309685, CmdConfigHttp.CMD_SET_LIKE_FORUM, "c/c/forum/setLikeForumSort", SetLikeForumHttpResponseMessage.class, false, false, false, false);
        }
    }

    public static void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            v3a.h(309601, RecentlyVisitedForumSocketResponseMessage.class, false, false);
            v3a.c(309601, CmdConfigHttp.CMD_GET_HISTORY_FORUM, "c/f/forum/gethistoryforum", RecentlyVisitedForumHttpResponseMessage.class, false, false, false, false);
            v3a.e(CmdConfigHttp.CMD_DELETE_HISTORY_FORUM, "c/c/forum/delHistoryForum", null, false, false, false, false);
        }
    }

    @Override // com.baidu.tieba.jn5
    public kn5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            kn5 kn5Var = new kn5();
            kn5Var.a = new EnterForumTabFragment();
            kn5Var.e = 1;
            kn5Var.b = R.string.enter_forum;
            kn5Var.i = kn5.l;
            kn5Var.f = R.raw.lottie_tab_forum;
            kn5Var.h = rn5.f().d("enterForum");
            return kn5Var;
        }
        return (kn5) invokeV.objValue;
    }
}
